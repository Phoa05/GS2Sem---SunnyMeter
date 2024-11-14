package br.com.fiap.sunnymeter.sunny_meter.service;

import br.com.fiap.sunnymeter.sunny_meter.entity.RegistroProducao;
import br.com.fiap.sunnymeter.sunny_meter.exceptions.EntityNotFoundException;
import br.com.fiap.sunnymeter.sunny_meter.repository.RegistroProducaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RegistroProducaoService {

    @Autowired
    private RegistroProducaoRepository registroProducaoRepository;

    public RegistroProducao addRegistroProducao(RegistroProducao registroProducao) {
        return registroProducaoRepository.save(registroProducao);
    }

    public List<RegistroProducao> listRegistrosProducao() {
        return registroProducaoRepository.findAll();
    }

    public List<RegistroProducao> getRegistrosProducaoPorInstalacao(UUID instalacaoId, long inicio, long fim) {
        return registroProducaoRepository.findAllByInstalacaoIdAndMedicaoTimestampBetween(instalacaoId, inicio, fim);
    }

    public RegistroProducao updateRegistroProducao(UUID registroProducaoId, RegistroProducao registroProducaoAtualizado) {
        return registroProducaoRepository.findById(registroProducaoId)
                .map(registroProducao -> {
                    registroProducao.setProducaoKwh(registroProducaoAtualizado.getProducaoKwh());
                    registroProducao.setMedicaoTimestamp(registroProducaoAtualizado.getMedicaoTimestamp());
                    return registroProducaoRepository.save(registroProducao);
                })
                .orElseThrow(() -> new EntityNotFoundException("Registro de Produção não encontrado"));
    }

    public boolean deleteRegistroProducao(UUID registroProducaoId) {
        registroProducaoRepository.findById(registroProducaoId)
                .ifPresent(registroProducao -> registroProducaoRepository.delete(registroProducao));
        return false;
    }
}
