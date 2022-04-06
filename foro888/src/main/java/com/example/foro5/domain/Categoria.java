package com.example.foro5.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="Categoria")
/**
 * Define los atributos de la entidad Categoria, así como su relación con las otras entidades y configuración de BD
 */
public class Categoria {
    @Column(name="cat_id", nullable=false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cat_id;

    @Column(name="cat_nombre", nullable=false)
    private String cat_nombre;

    @OneToMany(targetEntity= Publicacion.class, fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "FK_publicacion")
    private List<Publicacion> publicaciones;

}
