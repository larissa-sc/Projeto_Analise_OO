package br.com.ifpe.supermercado.negocio;

import br.com.ifpe.supermercado.entidades.classeabstrata.Produto;
import br.com.ifpe.supermercado.persistencia.GenericDAO;
import java.util.function.Predicate;

public class ControladorProduto {
    GenericDAO<Produto> produtoDAO = new GenericDAO();
	
//criando apenas uma instância do controlador	
    private static final ControladorProduto instance = new ControladorProduto();
    private ControladorProduto(){}
    private static ControladorProduto.getInstance(){
	    return instance;
    }

    private Produto procurarProduto(String codigoDeBarras) {
		Predicate<Produto> filter = produto -> produto.getCodigoDeBarras().equals(codigoDeBarras);
		return produtoDAO.ler(filter);
	}

    public void criarProduto(String codigoDeBarras, String nome, String marca, int quantidade){
	    Produto produto = procurarProduto(codigoDeBarras);

	    if (produto != null){
		    throw new NoSuchElementException("O produto com código de barras:" + codigoDeBarras + "já está cadastrado.");
	    }
	    else {
		    produto = new Produto();
		    produto.setCodigoDeBarras(codigoDeBarras);
		    produto.setNome(nome);
		    produto.setMarca(marca);
		    produto.setQuantidade(quantidade);
	    }

	    produtoDAO.inserir(produto);
    }
	
    public Produto lerProduto(String codigoDeBarras){
	    Produto produto = procurarProduto(codigoDeBarras);

	    if(produto == null){
		    throw new NoSuchElementException("O código de barras" + codigoDeBarras + "não foi encontrado.");
	    }
	    return produto;
    }

    public void atualizarProduto(String codigoDeBarras, int quantidade){
	    Produto produto = procurarProduto(codigoDeBarras);

	    if (produto == null){
		    throw new NoSuchElementException("O código de barras" + codigoDeBarras + "não foi encontrado.");)
	    }
	    else{
		    Produto copia = produto;
		    copia.setQuantidade(quantidade);
	    }
	    produtoDAO.atualizar(produtoDAO.listar().indexOF(produto), copia);
    }

    public void deletarProduto(String codigoDeBarras){
	    Produto produto = procurarProduto(codigoDeBarras);
	    if (produto == null){
		    throw new NoSuchElementException("O código de barras" + codigoDeBarras + "não foi encontrado.");)
	    }
	    else{
		    produtoDAO.deletar(produto);
	    }
    }

    public List<Produto> listar(){
	    return produtoDAO.listar();
    }
}
