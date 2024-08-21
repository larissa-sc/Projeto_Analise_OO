package br.com.ifpe.supermercado.persistencia;

import br.com.ifpe.supermercado.entidades.classesabstratas.EntidadeBase;
import br.com.ifpe.supermercado.interfaces.IGenericDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// o dao genárico pode ser utilizado para qualquer classe que extender a Entidade Base
// uso do CRUD
public class GenericDAO<Tipo extends EntidadeBase> implements IGenericDAO<Tipo>{

	// cria a lista de objetos a ser manipulada pelo próprio DAO
	List<Tipo> lista = new ArrayList<>();

	public GenericDAO() {
	}
	
	@Override
	public void inserir(Tipo objeto) {
		lista.add(objeto);
	}

	//uso do stream para transformar a lista em  um fluxo de informações e usando o filter e predicate
	//para realizar a verificação das informações a partir de um filtro informado no controlador, caso n exista
	//retorna nulo
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