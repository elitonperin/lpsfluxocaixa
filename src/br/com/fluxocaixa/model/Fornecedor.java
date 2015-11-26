package br.com.fluxocaixa.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public abstract class Fornecedor extends CentroCusto {


	private static final long serialVersionUID = 2361147735845503492L;

	@Column
	private String rua;
	
	@Column
	private String numero;
	
	@Column
	private String bairro;
	
	@Column
	private String cidade;
	
	@Column
	private String cep;
	
	@Column
	private String telefone;
	
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}	
}
