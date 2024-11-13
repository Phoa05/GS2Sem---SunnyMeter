package br.com.fiap.sunnymeter.sunny_meter.service;

import br.com.fiap.sunnymeter.sunny_meter.entity.RegistroProducao;
import br.com.fiap.sunnymeter.sunny_meter.repository.RegistroProducaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class RegistroProducaoService {

    @Autowired
    private RegistroProducaoRepository registroProducaoRepository;

    public RegistroProducao addRegistroProducao(RegistroProducao registro) {
        return registroProducaoRepository.save(registro);
    }

    public List<RegistroProducao> listRegistrosProducao() {
        return registroProducaoRepository.findAll();
    }

    public double calcularProducaoTotal(Long instalacaoId, LocalDateTime inicio, LocalDateTime fim) {
        return registroProducaoRepository
                .findAllByInstalacaoIdAndMedicaoTimestampBetween(instalacaoId, inicio, fim)
                .stream()
                .mapToDouble(RegistroProducao::getProducaoKwh)
                .sum();
    }
}
