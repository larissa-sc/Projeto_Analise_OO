package br.com.ifpe.supermercado.negocio.decorator;

import br.com.ifpe.supermercado.entidades.classesconcretas.Produto;

public class DecoradorPrecoDesconto extends PrecoDecorador{
    private final double desconto;

    public DecoradorPrecoDesconto(Produto produto) {
        super(produto);
        this.desconto = 10;
    }

    @Override
    public double getPreco() {
        return produto.getPreco() * (1 - desconto / 100);
    }

}