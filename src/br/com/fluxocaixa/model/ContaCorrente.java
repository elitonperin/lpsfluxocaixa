package br.com.fluxocaixa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class ContaCorrente extends Conta {

	private static final long serialVersionUID = 382484734679029194L;
	
	@Column(name="numero_conta")
	String numero;
	
	@Column(name="banco_conta")
	String banco;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}
}
