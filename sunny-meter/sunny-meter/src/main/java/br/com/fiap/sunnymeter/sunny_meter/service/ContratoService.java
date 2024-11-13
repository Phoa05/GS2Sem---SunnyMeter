package br.com.fiap.sunnymeter.sunny_meter.service;

import br.com.fiap.sunnymeter.sunny_meter.entity.Contrato;
import br.com.fiap.sunnymeter.sunny_meter.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public void deleteContrato(UUID contratoId) {
        contratoRepository.findById(contratoId).ifPresent(contrato -> {
            contrato.setAtivo(false); // Deleção lógica
            contratoRepository.save(contrato);
        });
    }

    public boolean isContratoValido(UUID contratoId) {
        return contratoRepository.findById(contratoId)
                .map(contrato -> {
                    LocalDate dataExpiracao = contrato.getDataInicio().plusMonths(contrato.getDuracaoContrato());
                    return dataExpiracao.isAfter(LocalDate.now());
                })
                .orElse(false);
    }
}
