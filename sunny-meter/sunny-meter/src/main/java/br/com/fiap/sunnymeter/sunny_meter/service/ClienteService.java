package br.com.fiap.sunnymeter.sunny_meter.service;

import br.com.fiap.sunnymeter.sunny_meter.model.Cliente;
import br.com.fiap.sunnymeter.sunny_meter.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criarCliente(Cliente cliente) {
        cliente.setAtivo(true);
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarCliente(UUID clienteUuid) {
        return clienteRepository.findById(clienteUuid);
    }

    public boolean deletarCliente(UUID clienteUuid) {
        Optional<Cliente> cliente = clienteRepository.findById(clienteUuid);
        if (cliente.isPresent()) {
            cliente.get().setAtivo(false);
            clienteRepository.save(cliente.get());
            return true;
        }
        return false;
    }
}
