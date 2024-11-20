package br.com.fiap.sunnymeter.sunny_meter.controller;

import br.com.fiap.sunnymeter.sunny_meter.model.Cliente;
import br.com.fiap.sunnymeter.sunny_meter.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clienteService.criarCliente(cliente);
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/{clienteUuid}")
    public Optional<Cliente> buscarCliente(@PathVariable UUID clienteUuid) {
        return clienteService.buscarCliente(clienteUuid);
    }

    @DeleteMapping("/{clienteUuid}")
    public boolean deletarCliente(@PathVariable UUID clienteUuid) {
        return clienteService.deletarCliente(clienteUuid);
    }
}
