package br.com.fluxocaixa.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("TRANSFERENCIA")
public class Transferencia extends FluxoCaixa {
	
	@ManyToOne
	@JoinColumn(name="destino_id")
	private CentroCusto destino;

	public CentroCusto getDestino() {
		return destino;
	}

	public void setDestino(CentroCusto destino) {
		this.destino = destino;
	}
}