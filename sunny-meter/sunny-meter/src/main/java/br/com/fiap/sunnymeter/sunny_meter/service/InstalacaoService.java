package br.com.fiap.sunnymeter.sunny_meter.service;

import br.com.fiap.sunnymeter.sunny_meter.entity.Instalacao;
import br.com.fiap.sunnymeter.sunny_meter.repository.InstalacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InstalacaoService {

    @Autowired
    private InstalacaoRepository instalacaoRepository;

    public Instalacao addInstalacao(Instalacao instalacao) {
        return instalacaoRepository.save(instalacao);
    }

    public List<Instalacao> listInstalacoes() {
        return instalacaoRepository.findAll();
    }

    public Optional<Instalacao> getInstalacao(UUID instalacaoId) {
        return instalacaoRepository.findById(instalacaoId);
    }

    public Instalacao updateInstalacao(UUID instalacaoId, Instalacao instalacaoAtualizada) {
        return instalacaoRepository.findById(instalacaoId).map(instalacao -> {
            instalacao.setEndereco(instalacaoAtualizada.getEndereco());
            instalacao.setCep(instalacaoAtualizada.getCep());
            return instalacaoRepository.save(instalacao);
        }).orElseThrow(() -> new RuntimeException("Instalação não encontrada"));
    }

    public void deleteInstalacao(UUID instalacaoId) {
        instalacaoRepository.findById(instalacaoId).ifPresent(instalacao -> {
            instalacao.setAtivo(false);
            instalacaoRepository.save(instalacao);
        });
    }
}

