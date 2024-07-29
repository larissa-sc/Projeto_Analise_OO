package br.com.ifpe.supermercado.entidades.classeabstrata;

//classe abstrata pois age como a entidade base do projeto geral
public class Produto extends EntidadeBase{
	
	protected String codigoDeBarras;
	protected String nome;
	protected String marca;
	protected int quantidade;
	
	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}
	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
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
