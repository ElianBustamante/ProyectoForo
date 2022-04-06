package com.example.foro5.services;

import com.example.foro5.domain.Publicacion;
import com.example.foro5.repository.CategoriaRepository;
import com.example.foro5.repository.PublicacionRepository;
import com.example.foro5.repository.ResidenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;


/**
 * PublicacionServices va a representar los servicios requeridos de Publicacion (crear, obtener, eliminar y actualizar).
 */
@Service
@Transactional
public class PublicacionServices {
    @Autowired
    PublicacionRepository pr;

    @Autowired
    ResidenteRepository rr;

    @Autowired
    CategoriaRepository cr;

    /**
     * Se encarga de recibir un objeto Publicacion con los datos, para crear y guardar un nuevo registro en el repositorio de Categoria.
     *
     * @param publicacion Objeto Publicacion con algunos datos que se requieren
     */
    public boolean crearNuevaPublicacion(Publicacion publicacion, Long id_user) {
        if (rr.findById(id_user).isPresent()) {
            publicacion.setResidente(rr.findById(id_user).get());
            publicacion.setPub_fechaCreacion(LocalDate.now());
            publicacion.setComentarios(new ArrayList<>());


            rr.findById(id_user).get().getPublicaciones().add(publicacion);
            pr.save(publicacion);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Se encarga de recibir un valor indice para una Publicacion solicitada/requerida para buscar en el repositorio de Publicacion y retornarlo/obtenerlo.
     *
     * @param index Valor numerico que representa el indice para buscar Publicacion solicitada/requerida
     * @return Retorna el objeto Publicacion solicitado si se encuentra en el repositorio de Publicacion
     */
    public Publicacion obtenerPublicacion(Long index) {
        return pr.findById(index).get();
    }

    /**
     * Se encarga de recibir un valor indice para una Publicacion solicitado/requerido para buscar en el repositorio de Publicacion y eliminarla.
     *
     * @param index Valor numerico que representa el indice para buscar una Publicacion solicitada/requerida
     */
    public boolean eliminarPublicacion(Long index) {
        if (pr.findById(index).isPresent()) {
            Long id_user = pr.findById(index).get().getResidente().getRes_id();
            Publicacion p = pr.findById(index).get();

            if (rr.findById(id_user).isPresent()) {
                rr.findById(id_user).get().getPublicaciones().remove(p);
            }
            pr.deleteById(index);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Se encarga de contar el total de Publicaciones en la base de datos/repositorio y retornar dicho valor.
     *
     * @return Retorna el valor numerico del total de registros en el repositorio de Publicacion
     */
    public Long obtenerNumeroPublicacionesBD() {
        return pr.count();
    }

    public Iterable<Publicacion> publicacionesUsuario(Long index) {
        /*ArrayList<Publicacion> publicacionLista = new ArrayList<>();

        for (int i = 1; i < pr.count() + 1; i++) {

            if (pr.findById((long) i).isPresent()) {
                Long idResidente = pr.findById((long) i).get().getResidente().getRes_id();
                Publicacion p = pr.findById((long) i).get();

                if (idResidente.equals(index)) {
                    publicacionLista.add(Math.toIntExact(index), p);
                }
            }
        }
        return publicacionLista;*/

        if (rr.findById(index).isPresent()) {
            return rr.findById(index).get().getPublicaciones();
        } else {
            return new ArrayList<>();
        }
    }
}
