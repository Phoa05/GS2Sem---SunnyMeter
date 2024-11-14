package br.com.fiap.sunnymeter.sunny_meter.service;

import br.com.fiap.sunnymeter.sunny_meter.entity.RegistroConsumo;
import br.com.fiap.sunnymeter.sunny_meter.exceptions.EntityNotFoundException;
import br.com.fiap.sunnymeter.sunny_meter.repository.RegistroConsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RegistroConsumoService {

    @Autowired
    private RegistroConsumoRepository registroConsumoRepository;

    public RegistroConsumo addRegistroConsumo(RegistroConsumo registroConsumo) {
        return registroConsumoRepository.save(registroConsumo);
    }

    public List<RegistroConsumo> listRegistrosConsumo() {
        return registroConsumoRepository.findAll();
    }

    public List<RegistroConsumo> getRegistrosConsumoPorInstalacao(UUID instalacaoId, long inicio, long fim) {
        return registroConsumoRepository.findAllByInstalacaoIdAndMedicaoTimestampBetween(instalacaoId, inicio, fim);
    }

    public RegistroConsumo updateRegistroConsumo(UUID registroConsumoId, RegistroConsumo registroConsumoAtualizado) {
        return registroConsumoRepository.findById(registroConsumoId)
                .map(registroConsumo -> {
                    registroConsumo.setConsumoKwh(registroConsumoAtualizado.getConsumoKwh());
                    registroConsumo.setMedicaoTimestamp(registroConsumoAtualizado.getMedicaoTimestamp());
                    return registroConsumoRepository.save(registroConsumo);
                })
                .orElseThrow(() -> new EntityNotFoundException("Registro de Consumo não encontrado"));
    }

    public void deleteRegistroConsumo(UUID registroConsumoId) {
        registroConsumoRepository.findById(registroConsumoId)
                .ifPresent(registroConsumo -> registroConsumoRepository.delete(registroConsumo));
    }
}
