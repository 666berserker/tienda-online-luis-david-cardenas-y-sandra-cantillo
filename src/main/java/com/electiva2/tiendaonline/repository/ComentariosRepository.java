
package com.electiva2.tiendaonline.repository;

import com.electiva2.tiendaonline.model.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ComentariosRepository extends JpaRepository<Comentarios, Integer> {

    List<Comentarios> findByFechaAfter(LocalDateTime fecha);
}
