package br.com.ifpe.supermercado.negocio.controlador;

import br.com.ifpe.supermercado.entidades.classesconcretas.Produto;
import br.com.ifpe.supermercado.interfaces.IPrecoAdapter;
import br.com.ifpe.supermercado.negocio.decorator.DecoradorPrecoBlackFriday;
import br.com.ifpe.supermercado.negocio.decorator.DecoradorPrecoDesconto;
import br.com.ifpe.supermercado.negocio.adapter.PrecoAdapterDolar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ControladorProduto extends GenericControlador<Produto>{
	private IPrecoAdapter precoAdapterDolar = new PrecoAdapterDolar();
	
//criando apenas uma instância do controlador (Singleton)
    private static final ControladorProduto instance = new ControladorProduto();
    private ControladorProduto(){}
    public static ControladorProduto getInstance(){
	    return instance;
    }

//Método para fazer a busca e verificar se o produto já existe dentro do sistema usando o Predicate e filter (filtrar)
    private Produto procurarProduto(String codigoDeBarras) {
		Predicate<Produto> filter = produto -> produto.getCodigoDeBarras().equals(codigoDeBarras);
		return dao.ler(filter);
	}

    public void criarProduto(Produto p){
	    Produto produto = procurarProduto(p.getCodigoDeBarras());  //método que guarda no produto se ele existe ou não (nesse caso null)
		if (produto ==  null) {
			super.criar(p);
		}
		super.criar(produto);
    }

    public Produto lerProduto(String codigoDeBarras){
	    Produto produto = procurarProduto(codigoDeBarras); //método que guarda no produto se ele existe ou não (nesse caso null)

	    return super.ler(produto);
		System.out.println("Preço em dólar: $" + precoAdapterDolar.getPrecoEmDolar(produto.getPreco()));
    }

    //método para atualizar a quantidade de um produto
    public void atualizarQProduto(String codigoDeBarras, int quantidade){
	    Produto produto = procurarProduto(codigoDeBarras); //método que guarda no produto se ele existe ou não (nesse caso null)

        produto.setQuantidade(quantidade);

	    super.atualizar(produto);
        System.out.println("O produto foi atualizado.");
    }

    public void aplicarDescontoBlack(String codigoDeBarras, int vezes){
        Produto produto = procurarProduto(codigoDeBarras); //método que guarda no produto se ele existe ou não (nesse caso null)

        if (produto == null) {
            throw new NoSuchElementException("Objeto não encontrado.");
        }

        for (int i = 0; i < vezes; i++) {
            DecoradorPrecoBlackFriday decorador = new DecoradorPrecoBlackFriday(produto);
            produto.setPreco(decorador.getPreco());
        }
		System.out.println("O desconto foi aplicado.");
    }

    public void aplicarDescontoComum(String codigoDeBarras, int vezes){
        Produto produto = procurarProduto(codigoDeBarras); //método que guarda no produto se ele existe ou não (nesse caso null)

        if (produto == null) {
            throw new NoSuchElementException("Objeto não encontrado.");
        }

        for (int i = 0; i < vezes; i++) {
            DecoradorPrecoDesconto decorador = new DecoradorPrecoDesconto(produto);
            produto.setPreco(decorador.getPreco());
        }
		System.out.println("O desconto foi aplicado.");
    }

    //método para deletar um produto
    public void deletarProduto(String codigoDeBarras){
	    Produto produto = procurarProduto(codigoDeBarras); //método que guarda no produto se ele existe ou não (nesse caso null)
	    
	    super.deletar(produto);
		System.out.println("Produto removido."); 
    }

    //método que lista todos os produtos existentes para o usuário
    @Override
    public List<Produto> listar(){
        return super.listar();
    }
}