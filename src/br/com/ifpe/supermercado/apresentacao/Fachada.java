package br.com.ifpe.supermercado.apresentacao;

import br.com.ifpe.supermercado.entidades.classesconcretas.Produto;
import br.com.ifpe.supermercado.negocio.controlador.ControladorTeste;

import java.util.List;

public class Fachada {
    private final ControladorTeste controladorProduto = ControladorTeste.getInstance();

    public void criarProduto(Produto produto){
        controladorProduto.criarProduto(produto);
    }

    public Produto lerProduto(String codigoDeBarras){
        return controladorProduto.lerProduto(codigoDeBarras);
    }

    public void atualizarQProduto(String codigoDeBarras, int quantidade){
        controladorProduto.atualizarQProduto(codigoDeBarras, quantidade);
    }

    public void aplicarDescontoBlack(String codigoDeBarras, int vezes){
        controladorProduto.aplicarDescontoBlack(codigoDeBarras, vezes);
    }

    public void aplicarDescontoComum(String codigoDeBarras, int vezes){
        controladorProduto.aplicarDescontoComum(codigoDeBarras, vezes);
    }

    public void deletarProduto(String codigoDeBarras){
        controladorProduto.deletarProduto(codigoDeBarras);
    }

    public List<Produto> listar(){
        return controladorProduto.listar();
    }
}