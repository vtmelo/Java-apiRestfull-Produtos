package primeiroexemplo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import primeiroexemplo.model.Produto;
import primeiroexemplo.repository.ProdutoRepository;

 import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServices {

    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     *Metodo para retornar uma lista de produtos
     * @return Lista de produtos
     * */
    public List<Produto> obterTodos(){
        //colocar regra aqui caso exista
        return produtoRepository.obterTodos();
    }

    /**
     * Metodo que retorna o produto encontrado pelo id
     * @param id do produto
     * @return Retorna um produto caso seja encontrado
     */
    public Optional<Produto> obterPorID(Integer id){
        return produtoRepository.obterPorID(id);
    }

    /**
     * Metodo para adicionar produto na lista
     * @param produto a ser adicionado
     * @return produto adicionado
     */
    public Produto adicionar(Produto produto){
        return  produtoRepository.adicionar(produto);
    }

    /**
     * Metodo que deleta um produto dado um id
     * @param id do produto a ser deletado
     */
    public void deletar(Integer id){
        produtoRepository.deletar(id);
    }

    /**
     * Metodo que atualiza um produto
     * @param id do produto
     * @param produto atualizado
     * @return produto apos atualizar
     */
    public Produto atualizar(Integer id,Produto produto){
        //separado pois o id vem pela query param e n no body
        produto.setId(id);

        return produtoRepository.atualizar(produto);
    }



}
