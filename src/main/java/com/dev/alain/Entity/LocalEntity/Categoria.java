package com.dev.alain.Entity.LocalEntity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoriaId")
    private int categoriaId;

    @Column(name = "Nombre", nullable = false)
    private String nombre;
}
