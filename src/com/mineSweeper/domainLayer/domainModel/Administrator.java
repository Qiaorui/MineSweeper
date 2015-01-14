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
    public String getTlfn() {
		return tlfn;
	}

	public void setTlfn(String tlfn) {
		this.tlfn = tlfn;
	}

	public Administrator() {

    }
}
