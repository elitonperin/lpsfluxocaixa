package br.com.fluxocaixa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.sun.istack.internal.NotNull;

@Entity
@DiscriminatorValue("CFE")
public class ClienteFisicoEmail extends ClienteFisico {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5011419112377367430L;

	public ClienteFisicoEmail() {
		// TODO Auto-generated constructor stub
	}

	@Column
	@NotNull
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getClass().getSimpleName() + " CPF: " + getCpf() + " Nome: " + getNome() + 
				"\nTelefone: " + getTelefone() + " Email: " + email + " Descri��o: " + getDescricao() + 
				"\nCidade: " + getCidade() + " Bairro: " + getBairro() + 
				"\nRua: " + getRua() + " N�mero: " + getNumero() + " CEP: " + getCep();
	}
}
