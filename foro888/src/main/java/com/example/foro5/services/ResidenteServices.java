package com.example.foro5.services;

import com.example.foro5.domain.Residente;
import com.example.foro5.repository.ResidenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
/**
 * ResidenteServices va a representar los servicios requeridos de Residente (crear, obtener y obtener).
 */
@Service
@Transactional
public class ResidenteServices {
    @Autowired
    ResidenteRepository resRep;

    /**
     * Se encarga de recibir un objeto Residente con los datos, para crear y guardar un nuevo registro en el repositorio de Comentario.
     *
     * @param nuevoResidente Objeto Comentario con algunos datos que se requieren
     */
    public void crearNuevoResidente(Residente nuevoResidente) {
        resRep.save(nuevoResidente);
    }

    /**
     * Se encarga de recibir un valor indice para un Residente solicitada/requerido para buscar en el repositorio de Residente y retornarlo/obtenerlo.
     *
     * @param index Valor numerico que representa el indice para buscar Residente solicitado/requerido
     * @return Retorna el objeto Residente solicitado si se encuentra en el repositorio de Residente
     */
    public Residente obtenerResidente(Long index) {
        return resRep.findById(index).get();
    }

    public Residente validarLogin(String rut, String clave) {
        String rutResp = "";
        String claveResp = "";
        Residente residente = null;

        for (int i = 1; i < resRep.count() + 1; i++) {
            if (resRep.findById((long) i).isPresent()) {
                rutResp = resRep.findById((long) i).get().getRes_rut();
                claveResp = resRep.findById((long) i).get().getRes_clave();

                if (rut.equals(rutResp) && clave.equals(claveResp)) {
                    residente = resRep.findById((long) i).get();
                    break;
                }
            }
        }

        return residente;
    }

    /**
     * Se encarga de recibir un valor indice para una Publicacion solicitado/requerido para buscar en el repositorio de Publicacion y actualizarla.
     *@param index Valor numerico que representa el indice para buscar un Residente solicitada/requerida
     * @param telefono Cadena que representa el telefono de contacto de un residente en específico
     * @param alias Cadena que representa el pseudónimo de un Residente en específico
     */
    public void editarResidente(String telefono, String alias, Long index) {
        Residente residente = resRep.findById(index).get();

        residente.setRes_telefono(telefono);
        residente.setRes_alias(alias);

        resRep.save(residente);
    }

    public void editarAlias (String alias, Long index) {
        resRep.findById(index).get().setRes_alias(alias);
    }
}
