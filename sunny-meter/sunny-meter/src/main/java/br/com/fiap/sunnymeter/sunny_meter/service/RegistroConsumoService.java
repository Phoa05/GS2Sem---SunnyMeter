package br.com.fiap.sunnymeter.sunny_meter.service;

import br.com.fiap.sunnymeter.sunny_meter.entity.RegistroConsumo;
import br.com.fiap.sunnymeter.sunny_meter.repository.RegistroConsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RegistroConsumoService {

    @Autowired
    private RegistroConsumoRepository registroConsumoRepository;

    public RegistroConsumo addRegistroConsumo(RegistroConsumo registro) {
        return registroConsumoRepository.save(registro);
    }

    public List<RegistroConsumo> listRegistrosConsumo() {
        return registroConsumoRepository.findAll();
    }

    public Optional<RegistroConsumo> getRegistroConsumo(UUID id) {
        return registroConsumoRepository.findById(id);
    }

    public RegistroConsumo updateRegistroConsumo(UUID id, RegistroConsumo registroAtualizado) {
        return registroConsumoRepository.findById(id).map(registro -> {
            registro.setInstalacaoId(registroAtualizado.getInstalacaoId());
            registro.setConsumoKwh(registroAtualizado.getConsumoKwh());
            registro.setMedicaoTimestamp(registroAtualizado.getMedicaoTimestamp());
            return registroConsumoRepository.save(registro);
        }).orElseThrow(() -> new RuntimeException("Registro de consumo não encontrado"));
    }

    public void deleteRegistroConsumo(UUID id) {
        registroConsumoRepository.deleteById(id);
    }
}
