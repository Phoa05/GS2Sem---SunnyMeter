package br.com.fiap.sunnymeter.sunny_meter.controller;

import br.com.fiap.sunnymeter.sunny_meter.entity.RegistroConsumo;
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
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroConsumo> updateRegistroConsumo(@PathVariable UUID id, @RequestBody RegistroConsumo registroAtualizado) {
        try {
            return ResponseEntity.ok(registroConsumoService.updateRegistroConsumo(id, registroAtualizado));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistroConsumo(@PathVariable UUID id) {
        registroConsumoService.deleteRegistroConsumo(id);
        return ResponseEntity.noContent().build();
    }
}
