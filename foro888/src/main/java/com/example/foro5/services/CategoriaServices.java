package com.example.foro5.services;

import com.example.foro5.domain.Categoria;
import com.example.foro5.domain.Publicacion;
import com.example.foro5.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

/**
 * CategoriaServices va a representar los servicios requeridos de Categoria (crear, obtener).
 */
@Service
@Transactional
public class CategoriaServices {

    @Autowired
    CategoriaRepository catRep;

    /**
     * Se encarga de recibir un objeto Categoria con los datos, para crear y guardar un nuevo registro en el repositorio de Categoria.
     *
     * @param categoria Objeto categoria con algunos datos que se requieren
     */
    public void crearNuevaCategoria(Categoria categoria) {
        ArrayList<Publicacion> publicaciones = new ArrayList<>();
        categoria.setPublicaciones(publicaciones);
        catRep.save(categoria);
    }

    /**
     * Se encarga de recibir un valor indice para una Categoria solicitada/requerida para buscar en el repositorio de Categoria y retornarlo/obtenerlo.
     *
     * @param index Valor numerico que representa el indice para buscar Categoria solicitada/requerida
     * @return Retorna el objeto Categoria solicitado si se encuentra en el repositorio de Categoria
     */
    public Categoria obtenerCategoria(Long index) {
        return catRep.findById(index).get();
    }

}
