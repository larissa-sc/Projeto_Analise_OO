package br.com.ifpe.supermercado.apresentacao;

import java.util.List;

import br.com.ifpe.supermercado.entidades.classesconcretas.Produto;
import br.com.ifpe.supermercado.negocio.ControladorProduto;

public class Fachada {
    private ControladorProduto controladorProduto = ControladorProduto.getInstance();

    public void criarProduto(Produto produto){
        controladorProduto.criarProduto(produto);
    }

    public Produto lerProduto(String codigoDeBarras){
        return controladorProduto.lerProduto(codigoDeBarras);
    }

    public void atualizarProduto(String codigoDeBarras, int quantidade){
        controladorProduto.atualizarQProduto(codigoDeBarras, quantidade);
    }

    public void deletarProduto(String codigoDeBarras){
        controladorProduto.deletarProduto(codigoDeBarras);
    }

    public List<Produto> listar(){
        return controladorProduto.listar();
    }
}
