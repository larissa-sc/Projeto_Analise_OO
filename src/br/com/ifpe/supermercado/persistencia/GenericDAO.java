package br.com.ifpe.supermercado.persistencia;

import java.util.List;

import br.com.ifpe.supermercado.interfaces.IGenericDAO;

public class GenericDAO<Tipo> implements IGenericDAO<Tipo>{

	
	
	public GenericDAO() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void criar(Tipo objeto) {
		
	}

	@Override
	public void ler(Tipo objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(int index, Tipo objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Tipo objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tipo> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
