package br.com.fiap.sunnymeter.sunny_meter.controller;

import br.com.fiap.sunnymeter.sunny_meter.model.RegistroProducao;
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
    public ResponseEntity<RegistroProducao> addRegistroProducao(@RequestBody RegistroProducao registro) {
        RegistroProducao savedRegistro = registroProducaoService.saveOrUpdateRegistroProducao(registro);
        return ResponseEntity.ok(savedRegistro);
    }

    @GetMapping
    public List<RegistroProducao> listRegistrosProducao() {
        return registroProducaoService.getAllRegistrosProducao();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroProducao> getRegistroProducao(@PathVariable UUID id) {
        return registroProducaoService.getRegistroProducaoById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new EntityNotFoundException("Registro de Produção não encontrado com o ID: " + id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroProducao> updateRegistroProducao(@PathVariable UUID id, @RequestBody RegistroProducao registroAtualizado) {
        registroAtualizado.setId(id);
        RegistroProducao updatedRegistro = registroProducaoService.saveOrUpdateRegistroProducao(registroAtualizado);
        return ResponseEntity.ok(updatedRegistro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistroProducao(@PathVariable UUID id) {
        registroProducaoService.deleteRegistroProducao(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
