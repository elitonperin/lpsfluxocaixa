package br.com.fluxocaixa.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CX")
public class Caixa extends Conta {

}
