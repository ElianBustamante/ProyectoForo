package com.example.foro5.controllers;

import com.example.foro5.domain.Categoria;
import com.example.foro5.services.CategoriaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Conecta la clase Servicio "CategoriaServices" con la vista "Agregar_categoria_Admin"
 */
@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaServices cs;

    /**
     * Conecta el método "crearNuevaCategoria" de "CategoriaServices" con el formulario de la vista "Agregar_categoria_Admin" para extraer datos externos
     * @param categoria Conecta el objeto formado por el formulario de la vista "Agregar_categoria_Admin" con el método "crearNuevaCategoria" de la clase "CategoriaServices"
     * @return Redirecciona a vista html "Foros.html"
     */
    @PostMapping("/agregarCategoria")
    public String crearCategoria(Categoria categoria){
        cs.crearNuevaCategoria(categoria);
        return "redirect:/ver_foros";
    }
}
