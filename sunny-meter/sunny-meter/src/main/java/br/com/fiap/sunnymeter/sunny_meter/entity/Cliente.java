package br.com.fiap.sunnymeter.sunny_meter.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue
    private UUID id;

    private String nome;
    private String documento;
    private String tipo;
    private String cep;
    private String endereco;
    private boolean ativo = true;
}
