package br.com.ifpe.supermercado.apresentacao;

import br.com.ifpe.supermercado.entidades.classesconcretas.Produto;
import br.com.ifpe.supermercado.negocio.controlador.ControladorProduto;
import java.util.List;

public class Fachada {
    private final ControladorProduto controladorProduto = ControladorProduto.getInstance();

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
        Produto produto = controladorProduto.procurarProduto(codigoDeBarras);
        controladorProduto.deletar(produto);
    }

    public List<Produto> listar(){
        return controladorProduto.listar();
    }
}