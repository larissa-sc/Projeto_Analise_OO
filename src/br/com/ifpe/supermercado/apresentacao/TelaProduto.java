package br.com.ifpe.supermercado.apresentacao;

import java.util.Scanner;

public class TelaProduto {

    Scanner scan = new Scanner(System.in);
    ControladorProduto controladorProduto = ControladorProduto.getInstance();

    public void TelaProduto(Scanner scan){
        while (true) {
            menuPrincipal();
            int escolha = scan.nextInt();

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
			controladorProduto.listar().forEach(System.out::println);
			break;

		    default:
			    System.out.println("Opção inválida.")
	    }
        }
    }

    private void criar(){
	System.out.println("Digite o código de barras: ");
	String codigoDeBarras = scan.nextLine();

	System.out.println("Digite o nome: ");
	String nome = scan.nextLine();

	System.out.println("Digite a marca: ");
	String marca = scan.nextLine();

	System.out.println("Digite a quantidade: ");
	int quantidade = scan.nextInt();

	controladorProduto.criarProduto(codigoDeBarras, nome, marca, quantidade);
	System.out.println("Produto criado e adicionado.");
    }

    private void atualizar(){
	System.out.println("Digite o código de barras do produto a ser atualizado: ");
	String codigoDeBarras = scan.nextLine();

	System.out.println("Digite a quantidade atual: ");
	int quantidade = scan.nextInt();

	controladorProduto.atualizarProduto(codigoDeBarras, quantidade);
	System.out.println("O produto foi atualizado.");
    }

    private void ler(){
	System.out.println("Digite o código de barras do produto: ");
	String codigoDeBarras = scan.nextLine();

	System.out.println(controladorProduto.lerProduto(codigoDeBarras));
    }

    private void deletar(){
	System.out.println("Digite o código de barras do produto a ser deletado: ");
	String codigoDeBarras = scan.nextLine();

	controladorProduto.deletarProduto(codigoDeBarras);
	System.out.println("Produto removido.");
    }
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
