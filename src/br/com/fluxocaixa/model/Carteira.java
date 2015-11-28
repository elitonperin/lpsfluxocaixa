package br.com.fluxocaixa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CT")
public class Carteira extends Conta {

	private static final long serialVersionUID = -814992088463215212L;
	
	@Column(name="tipo_conta")
	String tipoConta;
	
	@Column(name="banco")
	String banco;
	
	@Column(name="numero_da_conta")
	String numeroDaConta;
	
	@Column(name="nomeDaAgencia")
	String nomeDaAgencia;
	
	@Column(name="gerente")
	String gerente;
	
	@Column(name="telefone")
	String telefone;
	
	@Column(name="saldo")
	float saldo;
	
	@Column(name="data_de_vencimento")
	Date dataDeVencimento;

	public String getTipoConta()
	{
		return tipoConta;
	}

	public void setTipoConta(String tipoConta)
	{
		this.tipoConta = tipoConta;
	}

	public String getBanco()
	{
		return banco;
	}

	public void setBanco(String banco)
	{
		this.banco = banco;
	}

	public String getNumeroDaConta()
	{
		return numeroDaConta;
	}

	public void setNumeroDaConta(String numeroDaConta)
	{
		this.numeroDaConta = numeroDaConta;
	}

	public String getNomeDaAgencia()
	{
		return nomeDaAgencia;
	}

	public void setNomeDaAgencia(String nomeDaAgencia)
	{
		this.nomeDaAgencia = nomeDaAgencia;
	}

	public String getGerente()
	{
		return gerente;
	}

	public void setGerente(String gerente)
	{
		this.gerente = gerente;
	}

	public String getTelefone()
	{
		return telefone;
	}

	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}

	public float getSaldo()
	{
		return saldo;
	}

	public void setSaldo(float saldo)
	{
		this.saldo = saldo;
	}

	public Date getDataDeVencimento()
	{
		return dataDeVencimento;
	}

	public void setDataDeVencimento(Date dataDeVencimento)
	{
		this.dataDeVencimento = dataDeVencimento;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getClass().getSimpleName() + " Banco: " + banco + " Saldo: " + saldo + 
				"\nData de Vencimento: " + dataDeVencimento + "Telefone: " + telefone + 
				"\nGerente: " + gerente + " Nome da Agência: " + nomeDaAgencia + 
				"\nNúmero da Conta: " + numeroDaConta + " Tipo de Conta: " + tipoConta;
	}
}
