
import br.com.ifpe.supermercado.negocio.decorator.PrecoDecorador;

public class DecoradorPrecoDesconto extends PrecoDecorador{
    private final double desconto;

    public DecoradorPrecoDesconto(Produto produto, double desconto) {
        super(produto);
        this.desconto = 10;
    }

    @Override
    public double getPreco() {
        return produto.getPreco() * (1 - desconto / 100);
    }

}