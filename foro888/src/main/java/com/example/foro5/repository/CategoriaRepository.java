package com.example.foro5.repository;

import com.example.foro5.domain.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
/**
 * Provee a los métodos de la clase "CategoriaServices" acceso a los datos de la BD a través de métodos heredados de la clase abstracta "CrudRepository"
 */
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

}