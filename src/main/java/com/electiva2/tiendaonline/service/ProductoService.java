
package com.electiva2.tiendaonline.service;

import com.electiva2.tiendaonline.model.Producto;
import com.electiva2.tiendaonline.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> listarPorStockInferiorOIgual(int maxStock) {
        return productoRepository.findByStockLessThanEqual(maxStock);
    }
}
