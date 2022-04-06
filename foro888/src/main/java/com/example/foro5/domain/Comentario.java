package com.example.foro5.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name="Comentario")
@EqualsAndHashCode
@NoArgsConstructor
/**
 * Define los atributos de la entidad Comentario, así como su relación con las otras entidades y configuración de BD
 */
public class Comentario {
    @Column(name="com_id", nullable=false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long com_id;

    @Column(name="com_contenido", nullable=false)
    private String com_contenido;

    @Column(name="fechaCreacion", nullable=false)
    private LocalDate com_fechaCreacion;

    @ManyToOne(targetEntity= Residente.class, fetch=FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="FK_residente")
    private Residente residente;

    @ManyToOne(targetEntity= Publicacion.class, fetch=FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="FK_publicacion")
    private Publicacion publicacion;
}
