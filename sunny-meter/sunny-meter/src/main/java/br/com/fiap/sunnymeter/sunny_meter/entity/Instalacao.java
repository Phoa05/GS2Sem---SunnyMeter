package br.com.fiap.sunnymeter.sunny_meter.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Instalacao {
    @Id
    @GeneratedValue
    private UUID id;

    private String endereco;
    private String cep;
    private boolean ativo = true;
}
