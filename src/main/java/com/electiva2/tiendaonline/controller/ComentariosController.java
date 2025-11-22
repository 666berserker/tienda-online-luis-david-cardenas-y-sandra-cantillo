
package com.electiva2.tiendaonline.controller;

import com.electiva2.tiendaonline.model.Comentarios;
import com.electiva2.tiendaonline.service.ComentariosService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/comentarios")
@CrossOrigin
public class ComentariosController {

    private final ComentariosService comentariosService;

    public ComentariosController(ComentariosService comentariosService) {
        this.comentariosService = comentariosService;
    }

    // ii. Listar Comentarios → no requiere seguridad, lista todos los comentarios de una fecha en adelante
    @GetMapping("/desde")
    public ResponseEntity<List<Comentarios>> listarDesde(
            @RequestParam("fecha")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha) {
        return ResponseEntity.ok(comentariosService.listarDesdeFecha(fecha));
    }
}
