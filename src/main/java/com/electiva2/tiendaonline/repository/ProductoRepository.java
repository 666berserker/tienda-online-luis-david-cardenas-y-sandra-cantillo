
package com.electiva2.tiendaonline.repository;

import com.electiva2.tiendaonline.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByStockLessThanEqual(Integer stock);
}
