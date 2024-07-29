package br.com.ifpe.supermercado.apresentacao;

import java.util.Scanner;

public class TelaProduto {

    Scanner scan = new Scanner(System.in);

    public void TelaProduto(Scanner scan){
        while (true) {
            menuPrincipal();
            int escolha = scan.nextInt();
        }
    }

    private static void menuPrincipal() {
		System.out.println("--------- Menu ---------" +
				"\n 1. Criar Produto" +
				"\n 2. Atualizar Produto" +
				"\n 3. Exibir Informações do Produto" +
                "\n 4. Deletar Produto" +
				"\n Digite o número da opção desejada: \n");
	}

}
