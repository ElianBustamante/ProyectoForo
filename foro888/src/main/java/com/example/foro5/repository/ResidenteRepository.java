package com.example.foro5.repository;

import com.example.foro5.domain.Residente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
/**
 * Provee a los métodos de la clase "ResidenteServices" acceso a los datos de la BD a través de métodos heredados de la clase abstracta "CrudRepository"
 */
public interface ResidenteRepository extends CrudRepository<Residente, Long> {

}
