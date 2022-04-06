package com.example.foro5.repository;

import com.example.foro5.domain.Publicacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
/**
 * Provee a los métodos de la clase "PublicacionServices" acceso a los datos de la BD a través de métodos heredados de la clase abstracta "CrudRepository"
 */
public interface PublicacionRepository extends CrudRepository<Publicacion, Long> {
}
