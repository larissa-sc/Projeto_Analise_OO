package br.com.ifpe.supermercado.persistencia;

import java.util.ArrayList;
import java.util.List;

import br.com.ifpe.supermercado.entidades.classeabstrata.EntidadeBase;
import br.com.ifpe.supermercado.interfaces.IGenericDAO;

public class GenericDAO<Tipo extends EntidadeBase> implements IGenericDAO<Tipo>{

	List<Tipo> lista = new ArrayList<>();

	public GenericDAO() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void inserir(Tipo objeto) {

	}

	@Override
	public void ler(Tipo objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(int index, Tipo objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Tipo objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tipo> listar() {
		// TODO Auto-generated method stub
		return lista;
	}
	
	

}
