package br.com.fluxocaixa.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DESPESA")
public class Despesa extends FluxoCaixa {

	@Override
	public String toString() {
		return "Despesa [toString()=" + super.toString() + "]";
	}

}
