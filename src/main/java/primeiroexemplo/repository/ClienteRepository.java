package primeiroexemplo.repository;

import org.springframework.stereotype.Repository;
import primeiroexemplo.model.Cliente;
import primeiroexemplo.model.exception.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository {
    List<Cliente> clientes = new ArrayList<Cliente>();

    public List<Cliente> obterTodos(){
        return clientes;
    }

    public Optional<Cliente> obterPorCpf(String cpf){
        return clientes.stream().
                filter(cliente -> cliente.getCpf() == cpf)
                .findFirst();
    }

    public Cliente adicionarCliente(Cliente cliente){
        clientes.add(cliente);
        return cliente;
    }
    public void removerCliente(String cpf){
        clientes.removeIf(cliente -> cliente.getCpf() == cpf);
    }

    public Cliente atualizar(Cliente cliente){

        Optional<Cliente> clienteEncontrado =obterPorCpf(cliente.getCpf());
        if(!clienteEncontrado.isPresent()){
            throw new ResourceNotFoundException("Cliente nao encontrado");
        }
        removerCliente(cliente.getCpf());
        adicionarCliente(cliente);
        return cliente;
    }
}
