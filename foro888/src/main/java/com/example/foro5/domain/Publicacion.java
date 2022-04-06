package com.example.foro5.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name="Publicacion")
@EqualsAndHashCode
@NoArgsConstructor
/**
 * Define los atributos de la entidad Publicacion, así como su relación con las otras entidades y configuración de BD
 */
public class Publicacion {
    @Column(name="pub_id", nullable=false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pub_id;

    @Column(name="pub_asunto", nullable=false)
    private String pub_asunto;

    @Column(name="pub_contenido", nullable=false)
    private String pub_contenido;

    @Column(name="pub_fechaCreacion", nullable=false)
    private LocalDate pub_fechaCreacion;

    @ManyToOne(targetEntity=Residente.class, fetch=FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="FK_residente")
    private Residente residente;

    @OneToMany(targetEntity=Comentario.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_comentarios")
    private List<Comentario> comentarios;

    @ManyToOne(targetEntity=Categoria.class, fetch=FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="FK_categoria")
    private Categoria categoria;
}
