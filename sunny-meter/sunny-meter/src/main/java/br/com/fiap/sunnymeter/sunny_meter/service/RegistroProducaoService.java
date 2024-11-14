package br.com.fiap.sunnymeter.sunny_meter.service;

import br.com.fiap.sunnymeter.sunny_meter.entity.RegistroProducao;
import br.com.fiap.sunnymeter.sunny_meter.repository.RegistroProducaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public Optional<RegistroProducao> getRegistroProducao(UUID id) {
        return registroProducaoRepository.findById(id);
    }

    public RegistroProducao updateRegistroProducao(UUID id, RegistroProducao registroAtualizado) {
        return registroProducaoRepository.findById(id).map(registro -> {
            registro.setInstalacaoId(registroAtualizado.getInstalacaoId());
            registro.setProducaoKwh(registroAtualizado.getProducaoKwh());
            registro.setMedicaoTimestamp(registroAtualizado.getMedicaoTimestamp());
            return registroProducaoRepository.save(registro);
        }).orElseThrow(() -> new RuntimeException("Registro de produção não encontrado"));
    }

    public void deleteRegistroProducao(UUID id) {
        registroProducaoRepository.deleteById(id);
    }
}
