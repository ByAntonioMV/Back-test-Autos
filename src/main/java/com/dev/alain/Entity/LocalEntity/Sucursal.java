package com.dev.alain.Entity.LocalEntity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Sucursales")
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SucursalId")
    private int sucursalId;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Calle")
    private String calle;

    @Column(name = "Colonia")
    private String colonia;

    @Column(name = "Cp", length = 10)
    private String cp;
}
