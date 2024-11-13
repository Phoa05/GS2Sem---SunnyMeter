package br.com.fiap.sunnymeter.sunny_meter.repository;

import br.com.fiap.sunnymeter.sunny_meter.entity.RegistroConsumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface RegistroConsumoRepository extends JpaRepository<RegistroConsumo, UUID> {
    @Query("SELECT r FROM RegistroConsumo r WHERE r.instalacao.id = :instalacaoId AND r.medicaoTimestamp BETWEEN :inicio AND :fim")
    List<RegistroConsumo> findAllByInstalacaoIdAndMedicaoTimestampBetween(
            @Param("instalacaoId") UUID instalacaoId,
            @Param("inicio") long inicio,
            @Param("fim") long fim
    );
}
