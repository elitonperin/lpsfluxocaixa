package br.com.fluxocaixa.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("NAO_REALIZADO")
public class NaoRealizado extends Status{
	
}

