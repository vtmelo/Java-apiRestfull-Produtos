package primeiroexemplo.repository;

import org.springframework.stereotype.Repository;
import primeiroexemplo.model.Produto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepository {

    private List<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId =0;


    /**
    *Metodo para retornar uma lista de produtos
    * @return Lista de produtos
    * */
    public List<Produto> obterTodos(){
        return produtos;
    }

/**
* Metodo que retorna o produto encontrado pelo id
* @param id do produto
 * @return Retorna um produto caso seja encontrado
 */
    public Optional<Produto> obterPorID(Integer id){
        return produtos.stream().
                filter(produto -> produto.getId() == id)
                 .findFirst();
    }

    /**
     * Metodo para adicionar produto na lista
     * @param produto a ser adicionado
     * @return produto adicionado
     */
    public Produto adicionar(Produto produto){
        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);

        return produto;
    }

    /**
     * Metodo que deleta um produto dado um id
     * @param id do produto a ser deletado
     */
    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId()==id);
    }


    /**
     * Metodo que atualiza um produto
     * @param produto atualizado
     * @return produto apos atualizar
     */
    public Produto atualizar(Produto produto){

       Optional<Produto> produtoEncontrado = obterPorID(produto.getId());

       if(!produtoEncontrado.isPresent()){
           throw new InputMismatchException("Produto nao encontrado");
       }
       deletar(produto.getId());

       produtos.add(produto);

       return produto;
    }
}
