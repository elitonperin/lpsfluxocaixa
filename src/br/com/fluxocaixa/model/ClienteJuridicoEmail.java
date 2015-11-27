/**
 * 
 */
package br.com.fluxocaixa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.sun.istack.internal.NotNull;

/**
 * @author eliton_perin
 *
 */

@Entity
@DiscriminatorValue("CJE")
public class ClienteJuridicoEmail extends ClienteJuridico {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5001419114327367430L;

	@Column
	@NotNull
	private String email;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 */
	public ClienteJuridicoEmail() {
		// TODO Auto-generated constructor stub
	}

}
