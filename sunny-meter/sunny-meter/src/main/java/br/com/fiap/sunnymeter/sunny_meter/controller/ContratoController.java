package br.com.fiap.sunnymeter.sunny_meter.controller;

import br.com.fiap.sunnymeter.sunny_meter.entity.Contrato;
import br.com.fiap.sunnymeter.sunny_meter.exceptions.EntityNotFoundException;
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
                .orElseThrow(() -> new EntityNotFoundException("Contrato não encontrado com o ID: " + id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrato> updateContrato(@PathVariable UUID id, @RequestBody Contrato contratoAtualizado) {
        try {
            return ResponseEntity.ok(contratoService.updateContrato(id, contratoAtualizado));
        } catch (RuntimeException e) {
            throw new EntityNotFoundException("Contrato não encontrado para atualização com o ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContrato(@PathVariable UUID id) {
        if (!contratoService.deleteContrato(id)) {
            throw new EntityNotFoundException("Contrato não encontrado para deleção com o ID: " + id);
        }
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
