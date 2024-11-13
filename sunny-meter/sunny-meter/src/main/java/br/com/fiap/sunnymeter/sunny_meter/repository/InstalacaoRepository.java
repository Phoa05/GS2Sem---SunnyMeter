package br.com.fiap.sunnymeter.sunny_meter.repository;

import br.com.fiap.sunnymeter.sunny_meter.entity.Instalacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InstalacaoRepository extends JpaRepository<Instalacao, UUID> {
}