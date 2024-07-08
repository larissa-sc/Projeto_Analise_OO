public class Produto {

    private static Produto instance;

    private  Produto() {
    }

    public static Produto getInstance() {
        if (instance == null) {
            instance = new Produto();
        }
        return instance;
    }

    private String codDeBarras;
    private String nome;
    private String marca;
    private int quantidade;

    public Produto(String codDeBarras, String marca, String nome, int quantidade) {
        this.codDeBarras = codDeBarras;
        this.marca = marca;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getCodDeBarras() {
        return codDeBarras;
    }

    public void setCodDeBarras(String codDeBarras) {
        this.codDeBarras = codDeBarras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
