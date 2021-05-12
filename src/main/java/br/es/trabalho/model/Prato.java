package br.es.trabalho.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

@Entity
public class Prato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPrato;
	
	@Column(length = 200, nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private float preco;
	
	@ManyToOne
	private Cardapio card;
	
//	public Prato(String nome, float preco) {
//		this.nome = nome;
//		this.preco = preco;
//	}
	
	public int getId() {
		return idPrato;
	}

	public void setId(int idPrato) {
		this.idPrato = idPrato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Cardapio getCardapio() {
		return card;
	}

	public void setCardapio(Cardapio idCardapio) {
		this.card = idCardapio;
	}
	
}
