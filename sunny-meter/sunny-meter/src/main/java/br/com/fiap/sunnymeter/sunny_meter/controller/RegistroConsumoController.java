package br.com.fiap.sunnymeter.sunny_meter.controller;

import br.com.fiap.sunnymeter.sunny_meter.model.RegistroConsumo;
import br.com.fiap.sunnymeter.sunny_meter.service.RegistroConsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/registroconsumo")
public class RegistroConsumoController {

    @Autowired
    private RegistroConsumoService registroConsumoService;

    @PostMapping
    public RegistroConsumo registrarConsumo(@RequestBody RegistroConsumo consumo) {
        return registroConsumoService.registrarConsumo(consumo);
    }

    @GetMapping("/mensal/{contratoUuid}")
    public List<RegistroConsumo> calcularConsumoMensal(@PathVariable UUID contratoUuid) {
        return registroConsumoService.calcularConsumoMensal(contratoUuid);
    }
}
