package com.ocumpave.conversormoneda.infraestructure.persistence.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TipoCambio")
@Table(name = "TipoCambio")
public class TipoCambioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String monedaOrigen;
    private String monedaDestino;
    private BigDecimal tasaCambio;
}
