package com.example.foro5.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="Residente")
@EqualsAndHashCode
@NoArgsConstructor
/**
 * Define los atributos de la entidad Residente, así como su relación con las otras entidades y configuración de BD
 */
public class Residente {
    @Column(name="res_id", nullable=false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long res_id;
    @Column(name="res_rut", nullable=false)
    private String res_rut;
    @Column(name="res_dv", nullable=false)
    private String res_DV;
    @Column(name="res_nombre", nullable=false)
    private String res_nombre;
    @Column(name="res_apellidoPaterno", nullable=false)
    private String res_apellidoPaterno;
    @Column(name="res_apellidoMaterno", nullable=false)
    private String res_apellidoMaterno;
    @Column(name="res_telefono", nullable=false)
    private String res_telefono;
    @Column(name="res_email", nullable=false)
    private String res_email;
    @Column(name="res_alias", nullable=false)
    private String res_alias;
    @Column(name="res_clave", nullable=false)
    private String res_clave;
    @Column(name="res_urlFoto", nullable=false)
    private String res_urlFoto;

    @OneToMany(targetEntity= Publicacion.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_publicaciones")
    private List<Publicacion> publicaciones;

    @OneToMany(targetEntity=Comentario.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_comentario")
    private List<Comentario> comentarios;
}
