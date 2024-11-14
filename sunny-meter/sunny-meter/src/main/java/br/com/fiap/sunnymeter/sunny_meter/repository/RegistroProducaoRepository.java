package br.com.fiap.sunnymeter.sunny_meter.repository;

import br.com.fiap.sunnymeter.sunny_meter.entity.RegistroProducao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface RegistroProducaoRepository extends JpaRepository<RegistroProducao, UUID> {
    List<RegistroProducao> findAllByInstalacaoIdAndMedicaoTimestampBetween(
            UUID instalacaoId, long inicio, long fim);
}

