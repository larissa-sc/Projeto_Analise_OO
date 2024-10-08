package br.com.ifpe.supermercado.apresentacao;

import br.com.ifpe.supermercado.entidades.classesconcretas.Produto;
import br.com.ifpe.supermercado.entidades.classesconcretas.Produto.ProdutoBuilder;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TelaProduto {
//criando apenas uma instância do controlador (Singleton)
    private static final TelaProduto instance = new TelaProduto();
    private Scanner scan = new Scanner(System.in);
    private Fachada fachadaProduto = new Fachada();

    private TelaProduto(){}

    public static TelaProduto getInstance(){
	    return instance;
    }

    public void iniciar(){
        while (true) {
            try {
				menuPrincipal();
				String escolha = scan.nextLine();
	
			switch(escolha){
				case "1":
				criar();
				break;
			
				case "2":
				atualizarQProduto();
				break;
					
				case "3":
				ler();
				break;
					
				case "4":
				deletar();
				break;
	
				case "5":
				aplicarDescontoComum();
				break;
	
				case "6":
				aplicarDescontoBlack();
				break;
				
				case "7":
					if (fachadaProduto.listar().isEmpty() == true) {
						throw new NoSuchElementException("Não há produtos cadastrados.");
					}
					else{
						fachadaProduto.listar().forEach(produto -> {
						System.out.println(produto);
					});}
					break;
	
				default:
					throw new NoSuchElementException("Opção Inválida");
			}
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
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
		System.out.println("--------- Menu ---------"+
                        	"\n 1. Criar produto"+
                            "\n 2. Atualizar quantidade do produto"+
                            "\n 3. Exibir Informações do produto"+
                            "\n 4. Deletar produto"+
							"\n 5. Aplicar desconto comum"+
							"\n 6. Aplicar promoção Black Friday"+
                            "\n 7. Mostrar todos os produtos"+
                            "\n Digite o número da opção desejada: ");
	}

}
