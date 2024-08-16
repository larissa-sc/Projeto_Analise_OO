package br.com.ifpe.supermercado.apresentacao;

import br.com.ifpe.supermercado.entidades.classesconcretas.Produto;
import br.com.ifpe.supermercado.entidades.classesconcretas.Produto.ProdutoBuilder;
import br.com.ifpe.supermercado.interfaces.IPrecoAdapter;
import br.com.ifpe.supermercado.negocio.adapter.PrecoAdapterDolar;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TelaProduto {
//criando apenas uma instância do controlador (Singleton)
    private static final TelaProduto instance = new TelaProduto();
    private Scanner scan = new Scanner(System.in);
    private Fachada fachadaProduto = new Fachada();
	private IPrecoAdapter precoAdapterDolar = new PrecoAdapterDolar();

    private TelaProduto(){}

    public static TelaProduto getInstance(){
	    return instance;
    }

    public void iniciar(){
        while (true) {
            menuPrincipal();
            int escolha = scan.nextInt();
	    scan.nextLine();

	    switch(escolha){
		    case 1:
			criar();
			break;
		
		    case 2:
			atualizarQProduto();
			break;
			    
		    case 3:
			ler();
			break;
			    
		    case 4:
			deletar();
			break;

			case 5:
			aplicarDescontoComum();
			break;

			case 6:
			aplicarDescontoBlack();
			break;
			
		    case 7:
				if (fachadaProduto.listar() == null) {
					throw new NoSuchElementException("Não há produtos cadastrados.");
				}
				fachadaProduto.listar().forEach(produto -> {
					System.out.println(produto);
					System.out.println("Preço em dólar: $" + precoAdapterDolar.getPrecoEmDolar(produto.getPreco()));
				});
				break;

		    default:
			throw new NoSuchElementException("Opção inválida.");
	    }
        }
    }

// CRIANDO PRODUTO XXXXXXXXXXXX
    private void criar(){
	System.out.println("Digite o código de barras: ");
	String codigoDeBarras = scan.nextLine();

	System.out.println("Digite o nome: ");
	String nome = scan.nextLine();

	System.out.println("Digite a marca: ");
	String marca = scan.nextLine();

	System.out.println("Digite a quantidade: ");
	int quantidade = scan.nextInt();
	scan.nextLine();

	System.out.println("Digite o preço do produto: ");
	double preco = scan.nextInt();
	scan.nextLine();

	Produto produto = new ProdutoBuilder()
					.codigoDeBarras(codigoDeBarras)
					.nome(nome)
					.marca(marca)
					.quantidade(quantidade)
					.preco(preco)
					.build();
	fachadaProduto.criarProduto(produto);
	System.out.println("Produto criado e adicionado.");
    }

// ATUALIZANDO PRODUTO XXXXXXXXX
    private void atualizarQProduto(){
	System.out.println("Digite o código de barras do produto a ser atualizado: ");
	String codigoDeBarras = scan.nextLine();

	System.out.println("Digite a quantidade atual: ");
	int quantidade = scan.nextInt();
	scan.nextLine();
	    
	fachadaProduto.atualizarQProduto(codigoDeBarras, quantidade);
    }

// LENDO PRODUTO XXXXXXXXXX
    private void ler(){
	System.out.println("Digite o código de barras do produto: ");
	String codigoDeBarras = scan.nextLine();

	System.out.println(fachadaProduto.lerProduto(codigoDeBarras));
    }

// DELETAR PRODUTO XXXXXXXXXX
    private void deletar(){
	System.out.println("Digite o código de barras do produto a ser deletado: ");
	String codigoDeBarras = scan.nextLine();

	fachadaProduto.deletarProduto(codigoDeBarras);
    }

	// ATUALIZANDO PRODUTO XXXXXXXXX
    private void aplicarDescontoBlack(){
		System.out.println("Digite o código de barras do produto a ser aplicado o desconto: ");
		String codigoDeBarras = scan.nextLine();
	
		System.out.println("Digite quantas vezes gostaria de aplicar o desconto de 20%: ");
		int vezes = scan.nextInt();
		scan.nextLine();
			
		fachadaProduto.aplicarDescontoBlack(codigoDeBarras, vezes);
	}

	// ATUALIZANDO PRODUTO XXXXXXXXX
    private void aplicarDescontoComum(){
		System.out.println("Digite o código de barras do produto a ser aplicado o desconto: ");
		String codigoDeBarras = scan.nextLine();
	
		System.out.println("Digite quantas vezes gostaria de aplicar o desconto de 10%: ");
		int vezes = scan.nextInt();
		scan.nextLine();
			
		fachadaProduto.aplicarDescontoComum(codigoDeBarras, vezes);
	}
	
// MENU PRINCIPAL XXXXXXXXX
    private static void menuPrincipal() {
		System.out.println("""
                            --------- Menu ---------
                            1. Criar produto
                            2. Atualizar quantidade do produto
                            3. Exibir Informações do produto
                            4. Deletar produto
							5. Aplicar desconto comum
							6. Aplicar promoção Black Friday
                            7. Mostrar todos os produtos
                            Digite o número da opção desejada: 
                                   """);
	}

}
