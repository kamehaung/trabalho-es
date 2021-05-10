package br.es.trabalho.model;

import javax.persistence.Entity;

import java.io.Serializable;
//import java.util.List;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Restaurante implements Serializable{
	 	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idRestaurante;
	
	@Column(length = 200, nullable = false)
	private String nome;
	
	@Column(length = 200, nullable = false, unique = true)	
	private String cnpj;
	
	@OneToMany
	private List<Cardapio> cardapios;
	
	public Restaurante() {
		super();
	}
	
	public Restaurante(Integer id, String nome, String cnpj) {
		this.idRestaurante = id;
		this.nome = nome;
		this.cnpj = cnpj;
	}
	
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

}

