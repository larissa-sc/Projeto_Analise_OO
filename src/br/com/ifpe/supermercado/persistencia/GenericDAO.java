package br.com.ifpe.supermercado.persistencia;

import br.com.ifpe.supermercado.entidades.classesabstratas.EntidadeBase;
import br.com.ifpe.supermercado.interfaces.IGenericDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class GenericDAO<Tipo extends EntidadeBase> implements IGenericDAO<Tipo>{

	List<Tipo> lista = new ArrayList<>();

	public GenericDAO() {
	}
	
	@Override
	public void inserir(Tipo objeto) {
		lista.add(objeto);
	}

	@Override
	public Tipo ler(Predicate<Tipo> filter) {
            return this.lista.stream().filter(filter).findFirst().orElse(null);
	}

	@Override
	public void atualizar(int index, Tipo objeto) {
		lista.set(index, objeto);
	}

	@Override
	public void deletar(Tipo objeto) {
		lista.remove(objeto);
	}

	@Override
	public List<Tipo> listar() {
		return lista;
	}
}