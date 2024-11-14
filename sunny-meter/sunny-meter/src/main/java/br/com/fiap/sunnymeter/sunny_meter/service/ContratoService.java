package br.com.fiap.sunnymeter.sunny_meter.service;

import br.com.fiap.sunnymeter.sunny_meter.entity.Contrato;
import br.com.fiap.sunnymeter.sunny_meter.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    public Contrato addContrato(Contrato contrato) {
        return contratoRepository.save(contrato);
    }

    public List<Contrato> listContratos() {
        return contratoRepository.findAll();
    }

    public Optional<Contrato> getContrato(UUID contratoId) {
        return contratoRepository.findById(contratoId);
    }

    public Contrato updateContrato(UUID contratoId, Contrato contratoAtualizado) {
        return contratoRepository.findById(contratoId).map(contrato -> {
            contrato.setClienteId(contratoAtualizado.getClienteId());
            contrato.setInstalacaoId(contratoAtualizado.getInstalacaoId());
            contrato.setDataInicio(contratoAtualizado.getDataInicio());
            contrato.setDuracaoContrato(contratoAtualizado.getDuracaoContrato());
            return contratoRepository.save(contrato);
        }).orElseThrow(() -> new RuntimeException("Contrato não encontrado"));
    }

    public void deleteContrato(UUID contratoId) {
        contratoRepository.findById(contratoId).ifPresent(contrato -> {
            contrato.setAtivo(false);
            contratoRepository.save(contrato);
        });
    }
}
