
package com.electiva2.tiendaonline.controller;

import com.electiva2.tiendaonline.model.Producto;
import com.electiva2.tiendaonline.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // i. Listar Productos → no requiere seguridad, lista todos los productos por debajo de x unidades
    @GetMapping("/bajo-stock")
    public ResponseEntity<List<Producto>> listarPorStock(@RequestParam("maxStock") int maxStock) {
        return ResponseEntity.ok(productoService.listarPorStockInferiorOIgual(maxStock));
    }
}
