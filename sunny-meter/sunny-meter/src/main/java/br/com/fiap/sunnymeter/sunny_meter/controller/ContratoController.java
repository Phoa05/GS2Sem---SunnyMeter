package br.com.fiap.sunnymeter.sunny_meter.controller;

import br.com.fiap.sunnymeter.sunny_meter.model.Contrato;
import br.com.fiap.sunnymeter.sunny_meter.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @PostMapping
    public Contrato criarContrato(@RequestBody Contrato contrato) {
        return contratoService.criarContrato(contrato);
    }

    @GetMapping("/{contratoUuid}")
    public Optional<Contrato> buscarContrato(@PathVariable UUID contratoUuid) {
        return contratoService.buscarContrato(contratoUuid);
    }

    @DeleteMapping("/{contratoUuid}")
    public boolean deletarContrato(@PathVariable UUID contratoUuid) {
        return contratoService.deletarContrato(contratoUuid);
    }
}
