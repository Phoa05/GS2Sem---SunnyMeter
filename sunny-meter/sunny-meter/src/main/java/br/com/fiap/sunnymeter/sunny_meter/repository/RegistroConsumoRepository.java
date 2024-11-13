package br.com.fiap.sunnymeter.sunny_meter.repository;

import br.com.fiap.sunnymeter.sunny_meter.entity.RegistroConsumo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RegistroConsumoRepository extends JpaRepository<RegistroConsumo, UUID> {
}
