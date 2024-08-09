package br.com.ifpe.supermercado.main;

import br.com.ifpe.supermercado.apresentacao.TelaProduto;

public class Main {
    public static void main(String[] args) {
        TelaProduto telaProduto = TelaProduto.getInstance();
        telaProduto.iniciar();
    }
}