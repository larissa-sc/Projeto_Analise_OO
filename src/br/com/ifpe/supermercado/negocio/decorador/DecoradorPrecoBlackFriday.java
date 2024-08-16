
import br.com.ifpe.supermercado.negocio.decorator.PrecoDecorador;

public class DecoradorPrecoBlackFriday extends PrecoDecorador{
    private final double desconto;

    public DecoradorPrecoBlackFriday(Produto produto, double desconto) {
        super(produto);
        this.desconto = 20;
    }

    @Override
    public double getPreco() {
        return produto.getPreco() * (1 - desconto / 100);
    }

}