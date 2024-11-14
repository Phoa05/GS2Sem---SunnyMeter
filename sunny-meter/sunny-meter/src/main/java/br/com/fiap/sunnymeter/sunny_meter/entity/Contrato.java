package br.com.fiap.sunnymeter.sunny_meter.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Entity
@Data
public class Contrato {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "instalacao_id", nullable = false)
    private Instalacao instalacao;

    private LocalDate dataInicio;
    private int duracaoContrato;
    private boolean ativo = true;

}

