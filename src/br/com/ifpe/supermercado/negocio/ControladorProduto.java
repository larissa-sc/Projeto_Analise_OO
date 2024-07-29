package br.com.ifpe.supermercado.negocio;

import br.com.ifpe.supermercado.entidades.classeabstrata.Produto;
import br.com.ifpe.supermercado.persistencia.GenericDAO;
import java.util.function.Predicate;

public class ControladorProduto {
    GenericDAO<Produto> produtoDAO = new GenericDAO();

    private Produto procurarProduto(String codigoDeBarras) {
		Predicate<Produto> filter = produto -> produto.getCodigoDeBarras().equals(codigoDeBarras);
		return produtoDAO.ler(filter);
	}

    public void criarProduto(String codigoDeBarras){

    }
}
