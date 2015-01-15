package com.mineSweeper.domainLayer.domainModel;


import javax.persistence.DiscriminatorColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.GeneratedValue;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TIPUS", discriminatorType= DiscriminatorType.STRING, length=50)
public class UsuariRegistrat {

    private String nom;
    private String cognom;
    private String username;
    private String pwd;

    public UsuariRegistrat() {

    }

	/**
	 * comprovaPwd
     * Retorna si la contrasenya es igual a pwd
	 * @param pwd contrasenya introduida
	 * @return cert si password es correcte
	 */
    public boolean comprovaPwd(String pwd) {
        return this.pwd.equals(pwd);
    }

	/**
	 * getNom
     * Getter del nom de l'usuari enregistrat
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * setNom
     * Setter del nom de l'usuari
	 * @param nom nom del usuari
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * getCognom
     * Getter del cognom de l'usuari enregistrat
	 * @return cognom del usuari
	 */
	public String getCognom() {
		return cognom;
	}

	/**
	 * setCognom
     * Setter del cognom de l'usuari
	 * @param cognom cognom del usuari
	 */
	public void setCognom(String cognom) {
		this.cognom = cognom;
	}

	/**
	 * getUsername
     * Getter del nom d'usuari de l'usuari enregistrat
	 * @return username del usuari
	 */
    @Id
	public String getUsername() {
		return username;
	}

	/**
	 * setUsername
     * Setter del nom d'usuari de l'usuari
	 * @param username username del usuari
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * getPwd
     * Getter de la contrasenya de l'usuari enregistrat
	 * @return password del usuari
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * setPwd
     * Setter de la contrasenya de l'usuari
	 * @param pwd password del usuari
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
