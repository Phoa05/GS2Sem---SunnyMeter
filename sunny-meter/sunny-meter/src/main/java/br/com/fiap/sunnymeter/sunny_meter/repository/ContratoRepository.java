package br.com.fiap.sunnymeter.sunny_meter.repository;

import br.com.fiap.sunnymeter.sunny_meter.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ContratoRepository extends JpaRepository<Contrato, UUID> {
}
