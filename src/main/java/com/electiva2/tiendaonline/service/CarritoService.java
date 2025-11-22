
package com.electiva2.tiendaonline.service;

import com.electiva2.tiendaonline.dto.CarritoItemRequest;
import com.electiva2.tiendaonline.dto.CarritoItemResponse;
import com.electiva2.tiendaonline.dto.CrearCarritoRequest;
import com.electiva2.tiendaonline.model.*;
import com.electiva2.tiendaonline.repository.CarritoDeComprasRepository;
import com.electiva2.tiendaonline.repository.CarritoProductoRepository;
import com.electiva2.tiendaonline.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarritoService {

    private final CarritoDeComprasRepository carritoRepository;
    private final CarritoProductoRepository carritoProductoRepository;
    private final ProductoRepository productoRepository;

    public CarritoService(CarritoDeComprasRepository carritoRepository,
                          CarritoProductoRepository carritoProductoRepository,
                          ProductoRepository productoRepository) {
        this.carritoRepository = carritoRepository;
        this.carritoProductoRepository = carritoProductoRepository;
        this.productoRepository = productoRepository;
    }

    @Transactional
    public CarritoDeCompras crearCarrito(Usuario usuario, CrearCarritoRequest request) {
        CarritoDeCompras carrito = new CarritoDeCompras();
        carrito.setUsuario(usuario);
        carrito.setSubtotal(0.0);
        carrito.setImpuestos(0.0);
        carritoRepository.save(carrito);

        double subtotal = 0.0;

        for (CarritoItemRequest item : request.getItems()) {
            Producto producto = productoRepository.findById(item.getIdProducto())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + item.getIdProducto()));

            if (producto.getStock() < item.getCantidad()) {
                throw new RuntimeException("No hay stock suficiente para el producto " + producto.getNombre());
            }

            // Descontar del stock
            producto.setStock(producto.getStock() - item.getCantidad());
            productoRepository.save(producto);

            CarritoProducto cp = new CarritoProducto(carrito, producto, item.getCantidad());
            carritoProductoRepository.save(cp);

            subtotal += producto.getPrecio() * item.getCantidad();
        }

        carrito.setSubtotal(subtotal);
        double impuestos = subtotal * 0.19;
        carrito.setImpuestos(impuestos);
        carritoRepository.save(carrito);

        return carrito;
    }

    public List<CarritoItemResponse> listarProductosDelCarrito(Usuario usuario, Integer idCarrito) {
        CarritoDeCompras carrito = carritoRepository.findByIdCarritoAndUsuario(idCarrito, usuario)
                .orElseThrow(() -> new RuntimeException("El carrito no existe o no pertenece al usuario autenticado"));

        List<CarritoProducto> productosCarrito = carritoProductoRepository.findByCarrito(carrito);
        List<CarritoItemResponse> response = new ArrayList<>();

        for (CarritoProducto cp : productosCarrito) {
            Producto p = cp.getProducto();
            double total = p.getPrecio() * cp.getCantidad();
            response.add(new CarritoItemResponse(
                    p.getIdProducto(),
                    p.getNombre(),
                    cp.getCantidad(),
                    p.getPrecio(),
                    total
            ));
        }

        return response;
    }
}
