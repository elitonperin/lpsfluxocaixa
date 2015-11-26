package br.com.fluxocaixa.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="estados_caixa")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="tipo",
        discriminatorType=DiscriminatorType.STRING
)
public abstract class Status {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private Date data;
		
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="movimento_id")
	private FluxoCaixa movimento;
	
	public Status() {
	}
	
	public Integer getId() {
		return id;
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public FluxoCaixa getMovimento() {
		return movimento;
	}

	public void setMovimentacao(FluxoCaixa movimento) {
		this.movimento = movimento;
	}
}