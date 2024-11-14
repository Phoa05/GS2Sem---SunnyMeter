package br.com.fiap.sunnymeter.sunny_meter.controller;

import br.com.fiap.sunnymeter.sunny_meter.entity.Instalacao;
import br.com.fiap.sunnymeter.sunny_meter.service.InstalacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/instalacoes")
public class InstalacaoController {

    @Autowired
    private InstalacaoService instalacaoService;

    @PostMapping
    public Instalacao addInstalacao(@RequestBody Instalacao instalacao) {
        return instalacaoService.addInstalacao(instalacao);
    }

    @GetMapping
    public List<Instalacao> listInstalacoes() {
        return instalacaoService.listInstalacoes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instalacao> getInstalacao(@PathVariable UUID id) {
        return instalacaoService.getInstalacao(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instalacao> updateInstalacao(@PathVariable UUID id, @RequestBody Instalacao instalacaoAtualizada) {
        try {
            return ResponseEntity.ok(instalacaoService.updateInstalacao(id, instalacaoAtualizada));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstalacao(@PathVariable UUID id) {
        instalacaoService.deleteInstalacao(id);
        return ResponseEntity.noContent().build();
    }
}

