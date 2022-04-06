package com.example.foro5.services;

import com.example.foro5.domain.Comentario;
import com.example.foro5.domain.Publicacion;
import com.example.foro5.repository.ComentarioRepository;
import com.example.foro5.repository.PublicacionRepository;
import com.example.foro5.repository.ResidenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * ComentarioServices va a representar los servicios requeridos de Comentario (crear, obtener, eliminar y obtener).
 */
@Service
@Transactional
public class ComentarioServices {
    @Autowired
    ComentarioRepository comRep;

    @Autowired
    PublicacionRepository pubRep;

    @Autowired
    ResidenteRepository resRep;


    /**
     * Se encarga de recibir un objeto Comentario con los datos, para crear y guardar un nuevo registro en el repositorio de Comentario.
     *
     * @param comentario Objeto Comentario con algunos datos que se requieren
     */
    public boolean crearNuevoComentario(Comentario comentario, Long id_pub, Long id_res) {
        if (resRep.findById(id_res).isPresent()) {
            comentario.setPublicacion(pubRep.findById(id_pub).get());
            comentario.setResidente(resRep.findById(id_res).get());
            comentario.setCom_fechaCreacion(LocalDate.now());

            pubRep.findById(id_pub).get().getComentarios().add(comentario);

            comRep.save(comentario);
            return true;
        } else {
            return false;
        }
    }

    public Iterable<Comentario> cargarComentariosPorIDpublicacion(Long id_pub) {

        if (pubRep.findById(id_pub).isPresent()) {
            return pubRep.findById(id_pub).get().getComentarios();
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * Se encarga de recibir un valor indice para un Comentario solicitado/requerido para buscar en el repositorio de Comentario y eliminarlo.
     *
     * @param index Valor numerico que representa el indice para buscar Comentario solicitado/requerido
     */
    public void eliminarComentario(Long index) {
        comRep.deleteById(index);
    }
}
