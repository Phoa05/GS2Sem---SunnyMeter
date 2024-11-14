package br.com.fiap.sunnymeter.sunny_meter.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class RegistroConsumo {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "instalacao_id", nullable = false)
    private Instalacao instalacao;

    private double consumoKwh;
    private long medicaoTimestamp;
}

