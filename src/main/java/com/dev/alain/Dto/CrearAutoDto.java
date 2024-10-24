package com.dev.alain.Dto;

import lombok.Data;

@Data
public class CrearAutoDto {
    private int categoria_id;
    private int sucursal_id;
    private String nombre;
    private String modelo;
    private String marca;
    private String color;
}
