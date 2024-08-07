package br.com.ifpe.supermercado.negocio;

import br.com.ifpe.supermercado.entidades.classesconcretas.Produto;
import br.com.ifpe.supermercado.entidades.classesconcretas.Produto.ProdutoBuilder;
import br.com.ifpe.supermercado.persistencia.GenericDAO;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ControladorProduto {
//O controlador irá fazer a "ponte" entre o Tela Produto (do cliente) e o Dao Genérico que faz o controle da lista com os produtos
    GenericDAO<Produto> produtoDAO = DAOFactory.criarDAO();
	
//criando apenas uma instância do controlador (Singleton)
    private static final ControladorProduto instance = new ControladorProduto();
    private ControladorProduto(){}
    public static ControladorProduto getInstance(){
	    return instance;
    }

//Método para fazer a busca e verificar se o produto já existe dentro do sistema usando o Predicate e filter (filtrar)
    private Produto procurarProduto(String codigoDeBarras) {
		Predicate<Produto> filter = produto -> produto.getCodigoDeBarras().equals(codigoDeBarras);
		return produtoDAO.ler(filter);
	}

//método que cria um produto a partir dos seus atributos
    public void criarProduto(Produto p){
	    Produto produto = procurarProduto(p.getCodigoDeBarras());  //método que guarda no produto se ele existe ou não (nesse caso null)

	    if (produto != null){ //se for diferente de nulo significa que ele já existe
		    throw new NoSuchElementException("O produto com código de barras: " + p.getCodigoDeBarras() + " já está cadastrado.");
	    }
	    else { //caso não exista: cria substituindo o primeiro produto (nulo) por um produto com todas as informações
		    produto = p; //usar builder na tela produto
			//.codigoDeBarras(codigoDeBarras)
			//.nome(nome)
			//.marca(marca)
			//.quantidade(quantidade)
			//.preco(preco)
			//.build();
	    }
	    produtoDAO.inserir(produto); //após criar, chama o DAO para que adicione ele na lista única de produtos
    }

//método para mostrar as informações de um produto
    public Produto lerProduto(String codigoDeBarras){
	    Produto produto = procurarProduto(codigoDeBarras); //método que guarda no produto se ele existe ou não (nesse caso null)

	    if(produto == null){ //verifica se ele não existe
		    throw new NoSuchElementException("O código de barras " + codigoDeBarras + " não foi encontrado.");
	    }
	    return produto; //se existir, repassa as informações dele
    }

//método para atualizar um produto
    public void atualizarQProduto(String codigoDeBarras, int quantidade){
	    Produto produto = procurarProduto(codigoDeBarras); //método que guarda no produto se ele existe ou não (nesse caso null)

	    if (produto == null){ //verifica se é nulo (não existe)
		    throw new NoSuchElementException("O código de barras " + codigoDeBarras + " não foi encontrado.");
	    }
	    else{
			int index = listar().indexOf(produto);
		    produto = new ProdutoBuilder()
			.codigoDeBarras(produto.getCodigoDeBarras())
			.nome(produto.getNome())
			.marca(produto.getMarca())
			.quantidade(quantidade)
			.preco(produto.getPreco())
			.build();
			produtoDAO.atualizar(index, produto);
	    }
    }

//método para deletar um produto
    public void deletarProduto(String codigoDeBarras){
	    Produto produto = procurarProduto(codigoDeBarras); //método que guarda no produto se ele existe ou não (nesse caso null)
	    
	    if (produto == null){ //verifica se é nulo (não existe)
		    throw new NoSuchElementException("O código de barras " + codigoDeBarras + " não foi encontrado.");
	    }
	    else{ //se existir ele exclui da lista
		    produtoDAO.deletar(produto);
	    }
    }

//método que lista todos os produtos existentes para o usuário
    public List<Produto> listar(){
	    return produtoDAO.listar(); //chama o método do DAO para mostrar os produtos
    }
}
