package br.com.fiap.sunnymeter.sunny_meter.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class RegistroProducao {
    @Id
    @GeneratedValue
    private UUID id;

    private UUID instalacaoId;
    private double producaoKwh;
    private long medicaoTimestamp;
}
