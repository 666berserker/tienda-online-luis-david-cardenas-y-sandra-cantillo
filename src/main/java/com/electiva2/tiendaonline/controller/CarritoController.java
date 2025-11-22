
package com.electiva2.tiendaonline.controller;

import com.electiva2.tiendaonline.dto.CarritoItemResponse;
import com.electiva2.tiendaonline.dto.CrearCarritoRequest;
import com.electiva2.tiendaonline.model.CarritoDeCompras;
import com.electiva2.tiendaonline.model.Usuario;
import com.electiva2.tiendaonline.service.CarritoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/carritos")
@CrossOrigin
public class CarritoController {

    private final CarritoService carritoService;

    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    // d. Crear Carrito → requiere seguridad
    @PostMapping
    public ResponseEntity<CarritoDeCompras> crearCarrito(@Valid @RequestBody CrearCarritoRequest request,
                                                         Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();
        CarritoDeCompras carrito = carritoService.crearCarrito(usuario, request);
        return ResponseEntity.ok(carrito);
    }

    // e. Listar productos del carrito → requiere seguridad
    @GetMapping("/{idCarrito}/productos")
    public ResponseEntity<List<CarritoItemResponse>> listarProductos(@PathVariable Integer idCarrito,
                                                                     Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();
        List<CarritoItemResponse> items = carritoService.listarProductosDelCarrito(usuario, idCarrito);
        return ResponseEntity.ok(items);
    }
}
