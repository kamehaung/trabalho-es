package br.es.trabalho.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cardapio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCardapio;
	
	private String tipo;
	
	@ManyToOne
	private Restaurante restaurante;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "card")
	private List<Prato> pratos;
	
	public int getId() {
		return idCardapio;
	}
	
	public void setId(int idCardapio) {
		this.idCardapio = idCardapio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Restaurante getRest() {
		return restaurante;
	}

	public void setRest(Restaurante idRest) {
		this.restaurante = idRest;
	}
	
	public List<Prato> getPratos() {
		return this.pratos; 
	}

	public void setPratos(Prato pratos) {
		this.pratos.add(pratos);
	}
	
	@Override
	public String toString() {
		return "" + this.idCardapio;
	}
	
}
