package br.com.ifpe.supermercado.apresentacao;

import java.util.NoSuchElementException;
import java.util.Scanner;
import br.com.ifpe.supermercado.entidades.classesconcretas.Produto;
import br.com.ifpe.supermercado.entidades.classesconcretas.Produto.ProdutoBuilder;

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
            menuPrincipal();
            int escolha = scan.nextInt();
	    scan.nextLine();

	    switch(escolha){
		    case 1:
			criar();
			break;
		
		    case 2:
			atualizar();
			break;
			    
		    case 3:
			ler();
			break;
			    
		    case 4:
			deletar();
			break;

		    case 5:
				if (fachadaProduto.listar() == null) {
					throw new NoSuchElementException("Não há produtos cadastrados.");
				}
				fachadaProduto.listar().forEach(System.out::println);
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
    private void atualizar(){
	System.out.println("Digite o código de barras do produto a ser atualizado: ");
	String codigoDeBarras = scan.nextLine();

	System.out.println("Digite a quantidade atual: ");
	int quantidade = scan.nextInt();
	scan.nextLine();
	    
	fachadaProduto.atualizarProduto(codigoDeBarras, quantidade);
	System.out.println("O produto foi atualizado.");
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
	System.out.println("Produto removido.");
    }
	
// MENU PRINCIPAL XXXXXXXXX
    private static void menuPrincipal() {
		System.out.println("--------- Menu ---------" +
				"\n 1. Criar Produto" +
				"\n 2. Atualizar Produto" +
				"\n 3. Exibir Informações do Produto" +
                "\n 4. Deletar Produto" +
				"\n 5. Mostrar todos os produtos" +
				"\n Digite o número da opção desejada: \n");
	}

}