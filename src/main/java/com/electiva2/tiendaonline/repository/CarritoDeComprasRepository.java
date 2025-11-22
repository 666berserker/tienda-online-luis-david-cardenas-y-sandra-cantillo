
package com.electiva2.tiendaonline.repository;

import com.electiva2.tiendaonline.model.CarritoDeCompras;
import com.electiva2.tiendaonline.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarritoDeComprasRepository extends JpaRepository<CarritoDeCompras, Integer> {

    Optional<CarritoDeCompras> findByIdCarritoAndUsuario(Integer idCarrito, Usuario usuario);
}
