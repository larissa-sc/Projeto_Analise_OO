package br.com.ifpe.supermercado.negocio.decorador;

import br.com.ifpe.supermercado.interfaces.IDecoradorPreco;
import br.com.ifpe.supermercado.entidades.classesconcretas.Produto;

public abstract class PrecoDecorador implements IDecoradorPreco {
    protected Produto produto;

    public PrecoDecorador(Produto produto) {
        this.produto = produto;
    }

    public double getPreco() {
        return produto.getPreco();
    }
}
