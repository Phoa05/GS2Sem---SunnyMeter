package br.com.fiap.sunnymeter.sunny_meter.controller;

import br.com.fiap.sunnymeter.sunny_meter.entity.RegistroProducao;
import br.com.fiap.sunnymeter.sunny_meter.exceptions.EntityNotFoundException;
import br.com.fiap.sunnymeter.sunny_meter.service.RegistroProducaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/registrosProducao")
public class RegistroProducaoController {

    @Autowired
    private RegistroProducaoService registroProducaoService;

    @PostMapping
    public RegistroProducao addRegistroProducao(@RequestBody RegistroProducao registro) {
        return registroProducaoService.addRegistroProducao(registro);
    }

    @GetMapping
    public List<RegistroProducao> listRegistrosProducao() {
        return registroProducaoService.listRegistrosProducao();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroProducao> getRegistroProducao(@PathVariable UUID id) {
        return registroProducaoService.getRegistroProducao(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new EntityNotFoundException("Registro de Produção não encontrado com o ID: " + id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroProducao> updateRegistroProducao(@PathVariable UUID id, @RequestBody RegistroProducao registroAtualizado) {
        try {
            return ResponseEntity.ok(registroProducaoService.updateRegistroProducao(id, registroAtualizado));
        } catch (RuntimeException e) {
            throw new EntityNotFoundException("Registro de Produção não encontrado para atualização com o ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistroProducao(@PathVariable UUID id) {
        if (!registroProducaoService.deleteRegistroProducao(id)) {
            throw new EntityNotFoundException("Registro de Produção não encontrado para deleção com o ID: " + id);
        }
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
