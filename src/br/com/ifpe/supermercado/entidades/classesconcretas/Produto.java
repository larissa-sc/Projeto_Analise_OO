package br.com.ifpe.supermercado.entidades.classesconcretas;

import br.com.ifpe.supermercado.entidades.classesabstratas.EntidadeBase;

//classe abstrata pois age como a entidade base do projeto geral
public class Produto extends EntidadeBase {
	
	private String codigoDeBarras;
	private String nome;
	private String marca;
	private int quantidade;
	private double preco;

	public Produto(String codigoDeBarras, String nome, String marca, int quantidade, double preco) {
		this.codigoDeBarras = codigoDeBarras;
		this.nome = nome;
		this.marca = marca;
		this.quantidade = quantidade;
		this.preco = preco;
	}

    @Override
	public String toString(){
		return "Produto [ codigoDeBarras = " + codigoDeBarras + 
						", nome = " + nome +
						", marca = " + marca +
						", quantidade = " + quantidade +
						", preco = " + preco +"]";
	}
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
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

	public static final class ProdutoBuilder {
		private String codigoDeBarras;
		private String nome;
		private String marca;
		private int quantidade;
		private double preco;

		public ProdutoBuilder codigoDeBarras(String codigoDeBarras){
			this.codigoDeBarras = codigoDeBarras;
			return this;
		}
		
		public ProdutoBuilder nome(String nome){
			this.nome = nome;
			return this;
		}

		public ProdutoBuilder marca(String marca){
			this.marca = marca;
			return this;
		}

		public ProdutoBuilder quantidade(int quantidade){
			this.quantidade = quantidade;
			return this;
		}

		public ProdutoBuilder preco(double preco){
			this.preco = preco;
			return this;
		}

		public Produto build(){
			return new Produto(codigoDeBarras, nome, marca, quantidade, preco);
		}
	}
}