package br.com.fiap.sunnymeter.sunny_meter.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID contratoUuid;
    private UUID clienteUuid;
    private UUID instalacaoUuid;
    private int timeframe;
    private boolean ativo;
    private long contratoInicioTimestamp;

    public UUID getContratoUuid() {
        return contratoUuid;
    }

    public void setContratoUuid(UUID contratoUuid) {
        this.contratoUuid = contratoUuid;
    }

    public UUID getClienteUuid() {
        return clienteUuid;
    }

    public void setClienteUuid(UUID clienteUuid) {
        this.clienteUuid = clienteUuid;
    }

    public UUID getInstalacaoUuid() {
        return instalacaoUuid;
    }

    public void setInstalacaoUuid(UUID instalacaoUuid) {
        this.instalacaoUuid = instalacaoUuid;
    }

    public int getTimeframe() {
        return timeframe;
    }

    public void setTimeframe(int timeframe) {
        this.timeframe = timeframe;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public long getContratoInicioTimestamp() {
        return contratoInicioTimestamp;
    }

    public void setContratoInicioTimestamp(long contratoInicioTimestamp) {
        this.contratoInicioTimestamp = contratoInicioTimestamp;
    }
}
