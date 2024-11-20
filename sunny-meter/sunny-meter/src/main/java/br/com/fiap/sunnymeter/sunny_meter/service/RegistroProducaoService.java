package br.com.fiap.sunnymeter.sunny_meter.service;

import br.com.fiap.sunnymeter.sunny_meter.model.RegistroProducao;
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

    public RegistroProducao saveOrUpdateRegistroProducao(RegistroProducao registroProducao) {
        return registroProducaoRepository.save(registroProducao);
    }

    public List<RegistroProducao> getAllRegistrosProducao() {
        return registroProducaoRepository.findAll();
    }

    public Optional<RegistroProducao> getRegistroProducaoById(UUID id) {
        return registroProducaoRepository.findById(id);
    }

    public void deleteRegistroProducao(UUID id) {
        registroProducaoRepository.deleteById(id);
    }

    public List<RegistroProducao> findByDataProducao(String dataProducao) {
        return registroProducaoRepository.findByDataProducao(dataProducao);
    }
}
