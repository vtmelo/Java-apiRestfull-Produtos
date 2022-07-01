package primeiroexemplo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import primeiroexemplo.model.Cliente;
import primeiroexemplo.repository.ClienteRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServices {

    @Autowired
    ClienteRepository clienteRepository;


    public List<Cliente> obterTodos(){
        return clienteRepository.obterTodos();
    }

    public Optional<Cliente> obterPorCpf(String cpf){
        return clienteRepository.obterPorCpf(cpf);
    }

    public Cliente adicionarCliente(Cliente cliente){
       return clienteRepository.adicionarCliente(cliente);
    }

    public void removerCliente(String cpf){
        clienteRepository.removerCliente(cpf);
    }

    public Cliente atualizar(String cpf, Cliente cliente){

       cliente.setCpf(cpf);
       return clienteRepository.atualizar(cliente);
    }

}
