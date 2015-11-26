package br.com.fluxocaixa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="registros_importacao")
public class RegistroImportacao {
	 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column
	private Date data;
	
	@Column
	private String sistema;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public Integer getId() {
		return id;
	}

}