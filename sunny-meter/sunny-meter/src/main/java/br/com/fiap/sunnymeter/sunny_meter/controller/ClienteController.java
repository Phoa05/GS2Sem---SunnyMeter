package br.com.fiap.sunnymeter.sunny_meter.controller;

import br.com.fiap.sunnymeter.sunny_meter.entity.Cliente;
import br.com.fiap.sunnymeter.sunny_meter.exceptions.EntityNotFoundException;
import br.com.fiap.sunnymeter.sunny_meter.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente addCliente(@RequestBody Cliente cliente) {
        return clienteService.addCliente(cliente);
    }

    @GetMapping
    public List<Cliente> listClientes() {
        return clienteService.listClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable UUID id) {
        return clienteService.getCliente(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable UUID id, @RequestBody Cliente clienteAtualizado) {
        try {
            return ResponseEntity.ok(clienteService.updateCliente(id, clienteAtualizado));
        } catch (RuntimeException e) {
            throw new EntityNotFoundException("Cliente não encontrado para atualização com o ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable UUID id) {
        if (!clienteService.deleteCliente(id)) {
            throw new EntityNotFoundException("Cliente não encontrado para deleção com o ID: " + id);
        }
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
