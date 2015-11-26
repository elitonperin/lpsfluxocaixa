package br.com.fluxocaixa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("CR")
public class CartaoCredito extends Conta {

	private static final long serialVersionUID = -475504752251734204L;
	
	@Column(name="numero_cartao")
	private String numero;
	
	@Column(name="limite_cartao")
	private String limite;
	
	@Temporal(TemporalType.DATE)
	@Column(name="vencimento_cartao")
	private Date vencimento;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getLimite() {
		return limite;
	}

	public void setLimite(String limite) {
		this.limite = limite;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}
}