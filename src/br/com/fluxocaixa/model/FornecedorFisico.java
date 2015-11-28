package br.com.fluxocaixa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.sun.istack.internal.NotNull;

@Entity
@DiscriminatorValue("FF")
public class FornecedorFisico extends Fornecedor {

	private static final long serialVersionUID = 5001419118577367430L;

	@Column
	@NotNull
	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getClass().getSimpleName() + " CPF: " + getCpf() + " Nome: " + getNome() + 
				"\nTelefone: " + getTelefone() + " Descri��o: " + getDescricao() + 
				"\nCidade: " + getCidade() + " Bairro: " + getBairro() + 
				"\nRua: " + getRua() + " N�mero: " + getNumero() + " CEP: ";
	}
}
