package com.example.foro5.repository;

import com.example.foro5.domain.Comentario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
/**
 * Provee a los métodos de la clase "ComentarioServices" acceso a los datos de la BD a través de métodos heredados de la clase abstracta "CrudRepository"
 */
public interface ComentarioRepository extends CrudRepository<Comentario, Long> {
}
