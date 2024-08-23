package br.com.ifpe.supermercado.negocio.controlador;

import br.com.ifpe.supermercado.entidades.classesabstratas.EntidadeBase;
import br.com.ifpe.supermercado.interfaces.IGenericControlador;
import br.com.ifpe.supermercado.negocio.factory.DAOFactory;
import br.com.ifpe.supermercado.persistencia.GenericDAO;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class GenericControlador<Tipo extends EntidadeBase> implements IGenericControlador<Tipo>{
	//O controlador irá fazer a "ponte" entre a Tela (do cliente) e o Dao Genérico que faz o controle da lista
    protected final GenericDAO<Tipo> dao;
	
	public GenericControlador(){
		this.dao = DAOFactory.criarDAO();
	}

	//método que cria um objeto a partir dos seus atributos
    @Override
    public void criar(Tipo objeto){

	    if (objeto == null){ //se for diferente de nulo significa que ele já existe
		    throw new NoSuchElementException("O objeto já está cadastrado no sistema.");
	    }
		else{
        dao.inserir(objeto); //após criar, chama o DAO para que adicione ele na lista única de produtos
		System.out.println("Objeto criado e adicionado.");}
    }

	//método para mostrar as informações de um produto
    @Override
    public Tipo ler(Tipo objeto){

	    if(objeto == null){ //verifica se ele não existe
		    throw new NoSuchElementException("Não foi possível localizar o objeto.");
	    }

	    return objeto; //se existir, repassa as informações dele
    }

	//método para atualizar um produto
    @Override
    public void atualizar(Tipo objeto){
	   
	    if (objeto == null){ //verifica se é nulo (não existe)
		    throw new NoSuchElementException("Não foi possível localizar o objeto.");
	    }
	    else{
			dao.atualizar(listar().indexOf(objeto),objeto);
	    }
    }

	//método para deletar um produto
    @Override
    public void deletar(Tipo objeto){
		
	    if (objeto == null){ //verifica se é nulo (não existe)
		    throw new NoSuchElementException("Objeto não encontrado.");
	    }
	    else{ //se existir ele exclui da lista
		    dao.deletar(objeto);
			System.out.println("Objeto removido.");
	    }
    }

	//método que lista todos os produtos existentes para o usuário
    @Override
    public List<Tipo> listar(){
	    return dao.listar(); //chama o método do DAO para mostrar os produtos
    }
}