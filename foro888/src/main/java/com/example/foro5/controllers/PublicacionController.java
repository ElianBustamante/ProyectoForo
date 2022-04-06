package com.example.foro5.controllers;

import com.example.foro5.domain.Publicacion;
import com.example.foro5.repository.ComentarioRepository;
import com.example.foro5.services.ComentarioServices;
import com.example.foro5.services.PublicacionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Conecta a la clase Servicio "PublicacionServices".
 */
@Controller
@RequestMapping("/publicacion")
public class PublicacionController {
    @Autowired
    private PublicacionServices publicacionServices;

    @Autowired
    private ComentarioServices comentarioServices;

    /**
     * Conecta el método "crearNuevaPublicacion" de "PublicacionServices" con el formulario de la vista "Crear_publicacion" para extraer datos externos.
     *
     * @param publicacion Objeto Publicacion con los datos que se requieren
     * @return Redirecciona a vista html "Foros.html"
     */
    @PostMapping(value = "/crear/{id}")
    public String crearPublicacion(Publicacion publicacion, @PathVariable Long id) {
        if (publicacionServices.crearNuevaPublicacion(publicacion, id)) {
            return "redirect:/ver_foros";
        } else {
            return "redirect:/inicio_sesion";
        }
    }

    /**
     * Conecta el método "eliminarPublicacion" de "PublicacionServices".
     *
     * @param id Variable numerica que representa el indice de la Publicacion a eliminar posteriormente
     * @return Retorna true una vez se termina de ejecutar el método "eliminarPublicacion"
     */
    @GetMapping(value = "/eliminar_publicacion/{id}")
    public String eliminarPublicacion(@PathVariable Long id) {
        if (publicacionServices.eliminarPublicacion(id)) {
            return "redirect:/mis_publicaciones";
        } else {
            return "redirect:/inicio_sesion";
        }
    }
}
