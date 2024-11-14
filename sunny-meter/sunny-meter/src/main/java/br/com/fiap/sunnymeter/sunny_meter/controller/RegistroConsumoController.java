package br.com.fiap.sunnymeter.sunny_meter.controller;

import br.com.fiap.sunnymeter.sunny_meter.entity.RegistroConsumo;
import br.com.fiap.sunnymeter.sunny_meter.exceptions.EntityNotFoundException;
import br.com.fiap.sunnymeter.sunny_meter.service.RegistroConsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/registrosConsumo")
public class RegistroConsumoController {

    @Autowired
    private RegistroConsumoService registroConsumoService;

    @PostMapping
    public RegistroConsumo addRegistroConsumo(@RequestBody RegistroConsumo registro) {
        return registroConsumoService.addRegistroConsumo(registro);
    }

    @GetMapping
    public List<RegistroConsumo> listRegistrosConsumo() {
        return registroConsumoService.listRegistrosConsumo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroConsumo> getRegistroConsumo(@PathVariable UUID id) {
        return registroConsumoService.getRegistroConsumo(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new EntityNotFoundException("Registro de Consumo não encontrado com o ID: " + id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroConsumo> updateRegistroConsumo(@PathVariable UUID id, @RequestBody RegistroConsumo registroAtualizado) {
        try {
            return ResponseEntity.ok(registroConsumoService.updateRegistroConsumo(id, registroAtualizado));
        } catch (RuntimeException e) {
            throw new EntityNotFoundException("Registro de Consumo não encontrado para atualização com o ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistroConsumo(@PathVariable UUID id) {
        if (!registroConsumoService.deleteRegistroConsumo(id)) {
            throw new EntityNotFoundException("Registro de Consumo não encontrado para deleção com o ID: " + id);
        }
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
