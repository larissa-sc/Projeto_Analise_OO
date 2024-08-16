package br.com.ifpe.supermercado.negocio.controlador;

import br.com.ifpe.supermercado.entidades.classesconcretas.Produto;
import br.com.ifpe.supermercado.entidades.classesconcretas.Produto.ProdutoBuilder;
import java.util.List;
import java.util.function.Predicate;

public class ControladorTeste extends GenericControlador<Produto>{


    private static final ControladorTeste instance = new ControladorTeste();
    private ControladorTeste(){}
    public static ControladorTeste getInstance(){
	    return instance;
    }

    private Produto procurarProduto(String codigoDeBarras) {
		Predicate<Produto> filter = produto -> produto.getCodigoDeBarras().equals(codigoDeBarras);
		return dao.ler(filter);
	}

    public void criarProduto(Produto p){
	    Produto produto = procurarProduto(p.getCodigoDeBarras());  //método que guarda no produto se ele existe ou não (nesse caso null)
        if(produto == null){
            super.criar(p);
        }
    }

    public Produto lerProduto(String codigoDeBarras){
	    Produto produto = procurarProduto(codigoDeBarras); //método que guarda no produto se ele existe ou não (nesse caso null)

	    return super.ler(produto);
    }

    //método para atualizar a quantidade de um produto
    public void atualizarQProduto(String codigoDeBarras, int quantidade){
	    Produto produto = procurarProduto(codigoDeBarras); //método que guarda no produto se ele existe ou não (nesse caso null)

        produto = new ProdutoBuilder()
        .codigoDeBarras(produto.getCodigoDeBarras())
        .nome(produto.getNome())
        .marca(produto.getMarca())
        .quantidade(quantidade)
        .preco(produto.getPreco())
        .build();

	    super.atualizar(produto);
    }

    //método para deletar um produto
    public void deletarProduto(String codigoDeBarras){
	    Produto produto = procurarProduto(codigoDeBarras); //método que guarda no produto se ele existe ou não (nesse caso null)
	    
	    super.deletar(produto);
    }

    //método que lista todos os produtos existentes para o usuário
    @Override
    public List<Produto> listar(){
        return super.listar();
    }
}