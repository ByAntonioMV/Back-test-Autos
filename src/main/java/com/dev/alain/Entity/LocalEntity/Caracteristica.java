package com.dev.alain.Entity.LocalEntity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Caracteristicas")
public class Caracteristica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CaracteristicaId")
    private Integer caracteristicaId;

    @Column(name = "CaballosFuerza")
    private String caballosFuerza;

    @Column(name = "TipoMotor")
    private String tipoMotor;

    @Column(name = "TipoMarchar")
    private String tipoMarchar;

    @Column(name = "Cilindrada")
    private String cilindrada;

    @Column(name = "TipoFrenos")
    private String tipoFrenos;

    @ManyToOne
    @JoinColumn(name = "AutoId", referencedColumnName = "AutoId")
    private Auto auto;
}
