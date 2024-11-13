package br.com.fiap.sunnymeter.sunny_meter.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
public class Contrato {
    @Id
    @GeneratedValue
    private UUID id;

    private UUID clienteId;
    private UUID instalacaoId;
    private LocalDate dataInicio;
    private int duracaoContrato;
    private boolean ativo = true;
}
