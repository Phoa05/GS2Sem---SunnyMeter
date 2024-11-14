package br.com.fiap.sunnymeter.sunny_meter.service;

import br.com.fiap.sunnymeter.sunny_meter.entity.Cliente;
import br.com.fiap.sunnymeter.sunny_meter.exceptions.EntityNotFoundException;
import br.com.fiap.sunnymeter.sunny_meter.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente addCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getCliente(UUID clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
    }

    public Cliente updateCliente(UUID clienteId, Cliente clienteAtualizado) {
        return clienteRepository.findById(clienteId)
                .map(cliente -> {
                    cliente.setNome(clienteAtualizado.getNome());
                    cliente.setDocumento(clienteAtualizado.getDocumento());
                    cliente.setTipo(clienteAtualizado.getTipo());
                    cliente.setCep(clienteAtualizado.getCep());
                    cliente.setEndereco(clienteAtualizado.getEndereco());
                    return clienteRepository.save(cliente);
                })
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado para atualização"));
    }

    public boolean deleteCliente(UUID clienteId) {
        clienteRepository.findById(clienteId).ifPresent(cliente -> {
            cliente.setAtivo(false);
            clienteRepository.save(cliente);
        });
        return false;
    }
}
