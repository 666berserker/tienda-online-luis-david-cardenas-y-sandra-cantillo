
package com.electiva2.tiendaonline.repository;

import com.electiva2.tiendaonline.model.CarritoProducto;
import com.electiva2.tiendaonline.model.CarritoProductoId;
import com.electiva2.tiendaonline.model.CarritoDeCompras;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarritoProductoRepository extends JpaRepository<CarritoProducto, CarritoProductoId> {

    List<CarritoProducto> findByCarrito(CarritoDeCompras carrito);
}
