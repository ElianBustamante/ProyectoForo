package com.example.foro5.controllers;

import com.example.foro5.domain.Publicacion;
import com.example.foro5.domain.Residente;
import com.example.foro5.repository.CategoriaRepository;
import com.example.foro5.repository.ComentarioRepository;
import com.example.foro5.repository.PublicacionRepository;
import com.example.foro5.services.ComentarioServices;
import com.example.foro5.services.PublicacionServices;
import com.example.foro5.services.ResidenteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Conecta a la clase Servicio de "ResidenteServices"
 */
@Controller
public class ResidenteController {
    @Autowired
    private ResidenteServices residenteServices;

    @Autowired
    private PublicacionServices publicacionServices;

    @Autowired
    private ComentarioServices comentarioServices;

    public Residente r = null;
    public Publicacion p;

    /**
     * Conecta el método "crearNuevoResidente" de "ResidenteServices" con el formulario de la vista "Registrar_residente_Admin" para extraer datos externos
     *
     * @param residente Objeto Residente con los datos que se requieren
     * @return Redirecciona a la vista html "Foros.html"
     */
    @PostMapping(value = "/registrarResidente")
    public String registrarResidente(Residente residente) {
        residente.setRes_urlFoto("nulo");
        residenteServices.crearNuevoResidente(residente);
        return "redirect:/ver_foros";
    }

    @PostMapping("/validar_login")
    public String login(Residente residente) {
        r = residenteServices.validarLogin(residente.getRes_rut(), residente.getRes_clave());

        if (r == null) {
            return "redirect:/inicio_sesion";
        } else {
            return "redirect:/mi_perfil";
        }
    }

    @Autowired
    PublicacionRepository pr;

    @Autowired
    CategoriaRepository cr;

    @Autowired
    ComentarioRepository comRep;

    @GetMapping(value = "/mi_perfil")
    public String residenteMiPerfil(Model model) {
        if (r == null) {
            return "redirect:/inicio_sesion";
        } else {
            model.addAttribute("residente", r);
            model.addAttribute("publicaciones", pr.findAll());

            return "Mi_perfil";
        }
    }

    @GetMapping(value = "/configuracion_cuenta")
    public String residenteConfigCuenta(Model model) {
        if (r == null) {
            return "redirect:/inicio_sesion";
        } else {
            model.addAttribute("residente", r);

            return "Config_cuenta";
        }
    }

    @GetMapping(value = "/mis_publicaciones")
    public String residenteMisPublicaciones(Model model) {
        if (r == null) {
            return "redirect:/inicio_sesion";
        } else {
            model.addAttribute("residente", r);
            model.addAttribute("publicaciones", publicacionServices.publicacionesUsuario(r.getRes_id()));

            return "Mis_publicaciones";
        }
    }

    /**
     * Se encarga de retornar vista de ingreso de datos, registrar publicacion.
     *
     * @return Retorna vista html "Crear_publicacion.html"
     */
    @GetMapping("/crear_publicacion")
    public String residenteCrearPublicacion(Model model) {
        if (r == null) {
            return "redirect:/inicio_sesion";
        } else {
            model.addAttribute("categorias", cr.findAll());
            model.addAttribute("residente", r);
            return "Crear_publicacion";
        }
    }

    /**
     * Se encarga de retornar vista para efectos de navegabilidad, acceder a Ver foros.
     *
     * @return Retorna vista html "Foros.html"
     */
    @GetMapping("/ver_foros")
    public String residenteVerForos(Model model) {
        if (r == null) {
            return "redirect:/inicio_sesion";
        } else {
            model.addAttribute("publicaciones", pr.findAll());
            model.addAttribute("residente", r);
            return "Foros";
        }
    }

    /**
     * Se encarga de retornar vista de actualizacion de datos, actualizar alias.
     * @return Retorna vista html "Actualizar_alias.html"
     */
    @GetMapping("/actualizar_alias")
    public String configuracionAlias(Model model) {
        if (r == null) {
            return "redirect:/inicio_sesion";
        } else {
            model.addAttribute("residente", r);
            return "Actualizar_alias";
        }
    }

    /**
     * Se encarga de retornar vista de actualizacion de datos, actualizar contacto.
     *
     * @return Retorna vista html "Actualizar_contacto.html"
     */
    @GetMapping("/actualizar_contacto")
    public String actualizarContacto(Model model) {
        if (r == null) {
            return "redirect:/inicio_sesion";
        } else {
            model.addAttribute("residente", r);
            return "Actualizar_contacto";
        }
    }

    @PostMapping("/guardar_alias")
    public String guardarAlias(Residente residente) {
        if (r == null) {
            return "redirect:/inicio_sesion";
        } else {
            r.setRes_alias(residente.getRes_alias());
            residenteServices.crearNuevoResidente(r);
            return "redirect:/configuracion_cuenta";
        }
    }

    @PostMapping("/guardar_contacto")
    public String guardarContacto(Residente residente){
        if (r == null) {
            return "redirect:/inicio_sesion";
        } else {
            r.setRes_telefono(residente.getRes_telefono());
            residenteServices.crearNuevoResidente(r);
            return "redirect:/configuracion_cuenta";
        }
    }

    @GetMapping("/crear_comentario/{id}")
    public String crearComentario(Model model, @PathVariable Long id) {
        if (r == null) {
            return "redirect:/inicio_sesion";
        } else {
            model.addAttribute("publicacion", pr.findById(id));
            model.addAttribute("residente", r);
            model.addAttribute("comentarios", comentarioServices.cargarComentariosPorIDpublicacion(id));
            return "Nuevo_comentario";
        }
    }

    /**
     * Conecta el método "obtenerPublicacion" de "PublicacionServices".
     *
     * @param id Variable numerica que representa el indice de la Publicacion
     * @return Retorna la Publicacion buscada o solicitada mediante el método "obtenerPublicacion" más el id o indice pasado por parámetro
     */
    @GetMapping(value = "publicacion/ver_publicacion/{id}")
    public String obtenerPublicacion(@PathVariable Long id, Model model) {
        if (r == null) {
            return "redirect:/inicio_sesion";
        } else {
            Publicacion p = publicacionServices.obtenerPublicacion(id);

            model.addAttribute("publicacion", p);
            model.addAttribute("comentarios", comentarioServices.cargarComentariosPorIDpublicacion(id));
            model.addAttribute("residente", r);

            return "Ver_publicacion";
        }
    }

    @GetMapping("/cerrar_sesion")
    public String cerrarSesion() {
        r = null;
        return "redirect:/inicio_sesion";
    }
}
