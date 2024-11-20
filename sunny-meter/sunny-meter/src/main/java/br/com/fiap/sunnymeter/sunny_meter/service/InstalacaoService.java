package br.com.fiap.sunnymeter.sunny_meter.service;

import br.com.fiap.sunnymeter.sunny_meter.model.Instalacao;
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

    public Instalacao criarInstalacao(Instalacao instalacao) {
        instalacao.setAtivo(true);
        return instalacaoRepository.save(instalacao);
    }

    public List<Instalacao> listarInstalacoes() {
        return instalacaoRepository.findAll();
    }

    public Optional<Instalacao> buscarInstalacao(UUID instalacaoUuid) {
        return instalacaoRepository.findById(instalacaoUuid);
    }

    public boolean deletarInstalacao(UUID instalacaoUuid) {
        Optional<Instalacao> instalacao = instalacaoRepository.findById(instalacaoUuid);
        if (instalacao.isPresent()) {
            instalacao.get().setAtivo(false);
            instalacaoRepository.save(instalacao.get());
            return true;
        }
        return false;
    }
}
