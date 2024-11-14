package br.com.fiap.sunnymeter.sunny_meter.controller;

import br.com.fiap.sunnymeter.sunny_meter.entity.Contrato;
import br.com.fiap.sunnymeter.sunny_meter.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @PostMapping
    public Contrato addContrato(@RequestBody Contrato contrato) {
        return contratoService.addContrato(contrato);
    }

    @GetMapping
    public List<Contrato> listContratos() {
        return contratoService.listContratos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> getContrato(@PathVariable UUID id) {
        return contratoService.getContrato(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrato> updateContrato(@PathVariable UUID id, @RequestBody Contrato contratoAtualizado) {
        try {
            return ResponseEntity.ok(contratoService.updateContrato(id, contratoAtualizado));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContrato(@PathVariable UUID id) {
        contratoService.deleteContrato(id);
        return ResponseEntity.noContent().build();
    }
}

