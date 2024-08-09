package br.com.ifpe.supermercado.negocio.controlador;

import java.util.List;

import br.com.ifpe.supermercado.entidades.classesabstratas.EntidadeBase;
import br.com.ifpe.supermercado.entidades.classesconcretas.Produto;
import br.com.ifpe.supermercado.negocio.factory.DAOFactory;
import br.com.ifpe.supermercado.persistencia.GenericDAO;

public interface GenericControlador<Tipo extends EntidadeBase> {
//O controlador irá fazer a "ponte" entre a Tela (do cliente) e o Dao Genérico que faz o controle da lista
    GenericDAO<Tipo extends EntidadeBase> tipoDAO = DAOFactory.criarDAO();

//Método para fazer a busca e verificar se o produto já existe dentro do sistema usando o Predicate e filter (filtrar)
    @SuppressWarnings("hiding") 
    public <Tipo extends EntidadeBase> void procurar(Tipo objeto) {
		return produtoDAO.ler(filter);
	}

//método que cria um produto a partir dos seus atributos
    public void criarProduto(Tipo objeto){
        Tipo objeto = procurar();

	    if (objeto != null){ //se for diferente de nulo significa que ele já existe
		    throw new NoSuchElementException("Já está cadastrado.");
	    }
	    else { 
            objeto = objeto;
	    }
	    tipoDAO.inserir(objeto); //após criar, chama o DAO para que adicione ele na lista única de produtos
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
