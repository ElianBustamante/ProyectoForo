package com.example.foro5.controllers;

import com.example.foro5.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * AppController va a representar lo que es la navegabilidad, devolver vistas html.
 */
@Controller
@RequestMapping("")
public class AppController {

    /**
     * Se encarga de retornar vista de ingreso de datos, iniciar sesion.
     *
     * @return Retorna vista html "Inicio_sesion.html"
     */
    @GetMapping("/inicio_sesion")
    public String login() {
        return "Inicio_sesion";
    }

    /**
     * Se encarga de retornar vista de ingreso de datos, registrar residente.
     *
     * @return Retorna vista html "Registrar_residente_Admin.html"
     */
    @GetMapping("/registrar_usuario")
    public String registrarUsuario() {
        return "Registrar_residente_Admin";
    }

    /**
     * Se encarga de retornar vista de ingreso de datos, registrar o crear categoria.
     * @return Retorna vista html "Agregar_categoria_Admin.html"
     */
    @GetMapping("/crear_categoria")
    public String crearCategoria() {
        return "Agregar_categoria_Admin";
    }

    /**
     * Se encarga de retornar vista de actualizacion de datos, actualizar contraseña.
     *
     * @return Retorna vista html "Nueva_contraseña.html"
     */
    @GetMapping("/nueva_contraseña")
    public String editarClave() {
        return "Nueva_contraseña";
    }

    /**
     * Se encarga de retornar vista de actualizacion de datos, actualizar nombre.
     *
     * @return Retorna vista html "Nuevo_nombre.html"
     */
    @GetMapping("/nuevo_nombre")
    public String editarNombre() {
        return "Nuevo_nombre";
    }

    /**
     * Se encarga de retornar vista para efectos de navegabilidad, acceder a contactar administracion.
     *
     * @return Retorna vista html "Contactar_admin.html"
     */
    @GetMapping("/contactar_administrador")
    public String contactarAdministrador() {
        return "Contactar_admin";
    }

    /**
     * Se encarga de retornar vista para efectos de navegabilidad, acceder a Eliminar cuenta (en contactar administracion).
     *
     * @return Retorna vista html "Eliminar_cuenta.html"
     */
    @GetMapping("/eliminar_cuenta")
    public String eliminarCuenta() {
        return "Eliminar_cuenta";
    }


    @Autowired
    PublicacionRepository pr;

    /**
     * Se encarga de retornar vista para efectos de navegabilidad, acceder a Mi perfil de Administrador
     *
     * @return Retorna vista html "Mi_perfil_Admin.html"
     */
    @GetMapping("/mi_perfil_admin")
    public String accederPerfilAdmin() {
        return "Mi_perfil_Admin";
    }

}
