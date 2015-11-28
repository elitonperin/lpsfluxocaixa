package br.com.fluxocaixa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.sun.istack.internal.NotNull;

@Entity
@DiscriminatorValue("FJ")
public class FornecedorJuridico extends Fornecedor {

	private static final long serialVersionUID = 1466498768557879918L;

	@Column
	@NotNull
	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getClass().getSimpleName() + " CNPJ: " + getCnpj() + " Nome: " + getNome() + 
				"\nTelefone: " + getTelefone() + " Descrição: " + getDescricao() + 
				"\nCidade: " + getCidade() + " Bairro: " + getBairro() + 
				"\nRua: " + getRua() + " Número: " + getNumero() + " CEP: ";
	}
}
