package br.com.ifpe.supermercado.negocio.decorator;

import br.com.ifpe.supermercado.entidades.classesconcretas.Produto;

public class DecoradorPrecoBlackFriday extends PrecoDecorador{
    private final double desconto;

    public DecoradorPrecoBlackFriday(Produto produto) {
        super(produto);
        this.desconto = 20;
    }

    @Override
    public double getPreco() {
        return produto.getPreco() * (1 - desconto / 100);
    }

}