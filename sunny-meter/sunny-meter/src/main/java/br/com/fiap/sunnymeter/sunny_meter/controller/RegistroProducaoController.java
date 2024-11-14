package br.com.fiap.sunnymeter.sunny_meter.controller;

import br.com.fiap.sunnymeter.sunny_meter.entity.RegistroProducao;
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
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroProducao> updateRegistroProducao(@PathVariable UUID id, @RequestBody RegistroProducao registroAtualizado) {
        try {
            return ResponseEntity.ok(registroProducaoService.updateRegistroProducao(id, registroAtualizado));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistroProducao(@PathVariable UUID id) {
        registroProducaoService.deleteRegistroProducao(id);
        return ResponseEntity.noContent().build();
    }
}
