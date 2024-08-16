package br.com.ifpe.supermercado.interfaces;

import java.util.List;
import java.util.function.Predicate;

//uso do DAO GENERICO para implementar o CRUD (create=criar, read=ler, update=atualizar, delete=remover)
//interface com os principais métodos usados             
public interface IGenericDAO<Tipo>{
	
	public void inserir(Tipo objeto);
	
	public Tipo ler(Predicate<Tipo> filter);
	
	public void atualizar(int index, Tipo objeto);
	
	public void deletar(Tipo objeto);
	
	List<Tipo> listar();
}