
package com.electiva2.tiendaonline.service;

import com.electiva2.tiendaonline.model.Comentarios;
import com.electiva2.tiendaonline.repository.ComentariosRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComentariosService {

    private final ComentariosRepository comentariosRepository;

    public ComentariosService(ComentariosRepository comentariosRepository) {
        this.comentariosRepository = comentariosRepository;
    }

    public List<Comentarios> listarDesdeFecha(LocalDateTime fecha) {
        return comentariosRepository.findByFechaAfter(fecha);
    }
}
