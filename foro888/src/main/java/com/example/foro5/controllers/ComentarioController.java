package com.example.foro5.controllers;

import com.example.foro5.domain.Comentario;
import com.example.foro5.services.ComentarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Conecta la clase Servicio "ComentarioServices" con la vista "Nuevo_comentario"
 */
@Controller
@RequestMapping("/comentario")
public class ComentarioController {
    @Autowired
    private ComentarioServices comentarioServices;

    /**
     * Conecta el método "crearNuevoComentario" de la clase "comentarioServices" con el formulario de la vista "Nuevo_comentario"
     * @param comentario Conecta el objeto formado por el formulario de la vista "Nuevo_comentario" con el método "crearNuevoComentario" de la clase "ComentarioServices"
     * @return Redirecciona a la pantalla "Foros"
     */
    @PostMapping(value = "/crearComentario/{id_pub}/{id_res}")
    public String crearComentario(Comentario comentario, @PathVariable Long id_pub, @PathVariable Long id_res) {
        if (comentarioServices.crearNuevoComentario(comentario, id_pub, id_res)) {
            return "redirect:/publicacion/ver_publicacion/"+ id_pub;
        } else {
            return "redirect:/inicio_sesion";
        }
    }

    /**
     * Utiliza el método "eliminarComentario" de la clase "comentarioServices" para eliminar un comentario especifico
     * @param id especifica cual es el comentario que se busca obtener
     * @return Devuelve el objeto Comentario correspondiente
     */
    @GetMapping(value = "/eliminar_comentario/{id}")
    public boolean eliminarComentario(@PathVariable Long id) {
        comentarioServices.eliminarComentario(id);
        return true;
    }
}
















