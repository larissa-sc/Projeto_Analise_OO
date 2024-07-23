package br.com.ifpe.supermercado.entidades.classeabstrata;

public abstract class EntidadeBase {
    private int id;
    private static int contador;

    public EntidadeBase() {
        ++contador;
        id=contador;
    }
    public int getId() {
        return id;
    }
}
