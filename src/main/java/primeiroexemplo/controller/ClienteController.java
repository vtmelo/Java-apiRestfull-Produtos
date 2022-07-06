package primeiroexemplo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import primeiroexemplo.model.Cliente;
import primeiroexemplo.services.ClienteServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteServices clienteServices;


    @GetMapping
    public List<Cliente> getAll(){
        return clienteServices.obterTodos();
    }

    @GetMapping("/{cpf}")
    public Optional<Cliente> getById(@PathVariable String cpf){
        return clienteServices.obterPorCpf(cpf);
    }

    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente){
        return clienteServices.adicionarCliente(cliente);
    }
    @PutMapping
    public Cliente updateCliente(@PathVariable String cpf,@RequestBody Cliente cliente){
        return clienteServices.atualizar(cpf, cliente);
    }
    @DeleteMapping
    public void deleteCliente(@PathVariable String cpf){
        clienteServices.removerCliente(cpf);
    }

}
