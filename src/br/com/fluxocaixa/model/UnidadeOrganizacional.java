package br.com.fluxocaixa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("UO")
public class UnidadeOrganizacional extends CentroCusto {

	private static final long serialVersionUID = 6539028029562650515L;

	@Column(name="tipo_unidade_setor")
	private String tipoUnidade;
	
	@Column(name="numero_externo_setor")
	private String numeroExterno;

	@ManyToOne
	@JoinColumn(name="hierarquia_setor_id", nullable=true)
	private UnidadeOrganizacional unidadePai;

	@ManyToOne
	@JoinColumn(name="funcionario_id", nullable=true)
	private Funcionario funcionario;
	
	public String getTipoUnidade() {
		return tipoUnidade;
	}

	public void setTipoUnidade(String tipoUnidade) {
		this.tipoUnidade = tipoUnidade;
	}

	public String getNumeroExterno() {
		return numeroExterno;
	}

	public void setNumeroExterno(String numeroExterno) {
		this.numeroExterno = numeroExterno;
	}

	public UnidadeOrganizacional getUnidadePai() {
		return unidadePai;
	}

	public void setUnidadePai(UnidadeOrganizacional unidadePai) {
		this.unidadePai = unidadePai;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	

	@Override
	public String toString() {
		return getClass().getSimpleName() + " Nome: " + getNome() + " Tipo de Unidade: " + getTipoUnidade() +
				"\nNúmero Externo: " + getNumeroExterno();
	}
	
	
}
