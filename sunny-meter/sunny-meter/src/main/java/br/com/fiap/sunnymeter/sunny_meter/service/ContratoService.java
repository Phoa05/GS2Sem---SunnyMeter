package br.com.fiap.sunnymeter.sunny_meter.service;

import br.com.fiap.sunnymeter.sunny_meter.model.Contrato;
import br.com.fiap.sunnymeter.sunny_meter.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    public Contrato criarContrato(Contrato contrato) {
        if (contrato.getTimeframe() % 90 != 0 || contrato.getTimeframe() < 90 || contrato.getTimeframe() > 810) {
            throw new IllegalArgumentException("Invalid timeframe!");
        }
        contrato.setAtivo(true);
        return contratoRepository.save(contrato);
    }

    public Optional<Contrato> buscarContrato(UUID contratoUuid) {
        return contratoRepository.findById(contratoUuid);
    }

    public boolean deletarContrato(UUID contratoUuid) {
        Optional<Contrato> contrato = contratoRepository.findById(contratoUuid);
        if (contrato.isPresent() && contrato.get().isAtivo()) {
            contrato.get().setAtivo(false);
            contratoRepository.save(contrato.get());
            return true;
        }
        return false;
    }
}
