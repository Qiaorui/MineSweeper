package com.mineSweeper.domainLayer.domainModel;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Id;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("Administrator")
public class Administrator extends UsuariRegistrat {

    private String tlfn;
    @Column(unique = true, nullable= false)
    /**
     * getTlfn
     * Obtiene el telefono del administrador
     */
    public String getTlfn() {
		return tlfn;
	}

    /**
     * setTlfn
     * Hace un set del telefono
     * @param tlfn El telefono del administrador
     */
	public void setTlfn(String tlfn) {
		this.tlfn = tlfn;
	}

    /**
     * Administrator
     * Crea una instancia de la clase administrador
     */
	public Administrator() {

    }
}
