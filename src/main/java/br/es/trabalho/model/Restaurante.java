package br.es.trabalho.model;

import javax.persistence.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Restaurante{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRestaurante;
	
	@Column(name="nome", length = 200, nullable = false)
	private String nome;
	
	@Column(name="cnpj", length = 200, nullable = false, unique = true)	
	private String cnpj;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurante")
	private List<Cardapio> cardapios;
	
	public int getId(){
		return this.idRestaurante;
	}
	
	public void setId(int id) {
		this.idRestaurante = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public List<Cardapio> getCardapios() {
		return this.cardapios; 
	}

	public void setCardapios(Cardapio cardapios) {
		this.cardapios.add(cardapios);
	}
	
}

