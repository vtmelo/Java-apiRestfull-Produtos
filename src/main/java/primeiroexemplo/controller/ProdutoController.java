package primeiroexemplo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import primeiroexemplo.model.Produto;
import primeiroexemplo.services.ProdutoServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoServices produtoServices;

    @GetMapping
    public List<Produto> obterTodos(){
        return produtoServices.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Produto> obterPorId(@PathVariable Integer id){
        return produtoServices.obterPorID(id);
    }

    @PostMapping
    public Produto adicionar(@RequestBody Produto produto){
       return produtoServices.adicionar(produto);
    }


    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id){
        produtoServices.deletar(id);
        return "Produto com id: " + id + " foi deletado com sucesso";
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Integer id,@RequestBody Produto produto){
        return produtoServices.atualizar(id,produto);
    }
}
