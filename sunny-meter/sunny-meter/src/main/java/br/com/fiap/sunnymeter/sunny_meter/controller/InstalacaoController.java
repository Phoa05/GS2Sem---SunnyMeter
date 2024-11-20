package br.com.fiap.sunnymeter.sunny_meter.controller;

import br.com.fiap.sunnymeter.sunny_meter.model.Instalacao;
import br.com.fiap.sunnymeter.sunny_meter.service.InstalacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/instalacoes")
public class InstalacaoController {

    @Autowired
    private InstalacaoService instalacaoService;

    @PostMapping
    public Instalacao criarInstalacao(@RequestBody Instalacao instalacao) {
        return instalacaoService.criarInstalacao(instalacao);
    }

    @GetMapping
    public List<Instalacao> listarInstalacoes() {
        return instalacaoService.listarInstalacoes();
    }

    @GetMapping("/{instalacaoUuid}")
    public Optional<Instalacao> buscarInstalacao(@PathVariable UUID instalacaoUuid) {
        return instalacaoService.buscarInstalacao(instalacaoUuid);
    }

    @DeleteMapping("/{instalacaoUuid}")
    public boolean deletarInstalacao(@PathVariable UUID instalacaoUuid) {
        return instalacaoService.deletarInstalacao(instalacaoUuid);
    }
}
