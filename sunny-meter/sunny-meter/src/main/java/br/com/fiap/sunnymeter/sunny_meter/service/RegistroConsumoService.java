package br.com.fiap.sunnymeter.sunny_meter.service;

import br.com.fiap.sunnymeter.sunny_meter.entity.RegistroConsumo;
import br.com.fiap.sunnymeter.sunny_meter.repository.RegistroConsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public double calcularConsumoTotal(UUID instalacaoId, long inicio, long fim) {
        return registroConsumoRepository.findAllByInstalacaoIdAndMedicaoTimestampBetween(instalacaoId, inicio, fim)
                .stream()
                .mapToDouble(RegistroConsumo::getConsumoKwh)
                .sum();
    }
}
