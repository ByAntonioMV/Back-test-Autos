package com.dev.alain.Entity.DavidEntity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Autos")
@Data
public class AutoDavid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AutoId")
    private int autoId;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Modelo")
    private String modelo;

    @Column(name = "Marca")
    private String marca;

    @Column(name = "Color", length = 50)
    private String color;

    @ManyToOne
    @JoinColumn(name = "SucursalId", referencedColumnName = "SucursalId")
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "CategoriaId", referencedColumnName = "CategoriaId")
    private Categoria categoria;
}
