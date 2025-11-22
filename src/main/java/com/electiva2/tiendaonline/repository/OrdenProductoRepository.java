
package com.electiva2.tiendaonline.repository;

import com.electiva2.tiendaonline.model.OrdenProducto;
import com.electiva2.tiendaonline.model.OrdenProductoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenProductoRepository extends JpaRepository<OrdenProducto, OrdenProductoId> {
}
