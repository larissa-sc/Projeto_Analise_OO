package br.com.ifpe.supermercado.interfaces;

import java.util.List;

//uso do DAO GENERICO para implementar o CRUD (create=criar, read=ler, update=atualizar, delete=remover)
public interface IGenericDAO<Tipo>{
	
	public void inserir(Tipo objeto);
	
	public void ler(Tipo objeto);
	
	public void atualizar(int index, Tipo objeto);
	
	public void deletar(Tipo objeto);
	
	List<Tipo> listar();
}
