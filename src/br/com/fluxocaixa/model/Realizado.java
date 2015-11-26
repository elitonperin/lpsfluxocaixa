package br.com.fluxocaixa.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("REALIZADO")
public class Realizado extends Status {
	
}

