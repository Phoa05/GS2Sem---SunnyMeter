package br.com.fiap.sunnymeter.sunny_meter.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class RegistroConsumo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID consumoUuid;
    private UUID contratoUuid;
    private double consumoKwh;
    private long medicaoTimestamp;

    public UUID getConsumoUuid() {
        return consumoUuid;
    }

    public void setConsumoUuid(UUID consumoUuid) {
        this.consumoUuid = consumoUuid;
    }

    public UUID getContratoUuid() {
        return contratoUuid;
    }

    public void setContratoUuid(UUID contratoUuid) {
        this.contratoUuid = contratoUuid;
    }

    public double getConsumoKwh() {
        return consumoKwh;
    }

    public void setConsumoKwh(double consumoKwh) {
        this.consumoKwh = consumoKwh;
    }

    public long getMedicaoTimestamp() {
        return medicaoTimestamp;
    }

    public void setMedicaoTimestamp(long medicaoTimestamp) {
        this.medicaoTimestamp = medicaoTimestamp;
    }
}
