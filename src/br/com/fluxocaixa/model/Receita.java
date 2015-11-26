package br.com.fluxocaixa.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RECEITA")
public class Receita extends FluxoCaixa {

	@Override
	public String toString() {
		return "Receita [toString()=" + super.toString() + "]";
	}

}
