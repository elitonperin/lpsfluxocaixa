package br.com.fluxocaixa.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CT")
public class Carteira extends Conta {

	private static final long serialVersionUID = -814992088463215212L;

}
