/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package edu.fst.m2.ipii.carpooling.domaine.bo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Profil")
public class Profil implements Serializable {
	public Profil() {
	}
	
	@Column(name="ID", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_PROFIL_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_PROFIL_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Libelle", nullable=true, length=255)	
	private String libelle;
	
	@ManyToMany(targetEntity=Role.class, fetch = FetchType.EAGER)
	@JoinTable(name="Profil_Role", joinColumns={ @JoinColumn(name="ProfilID") }, inverseJoinColumns={ @JoinColumn(name="RoleID") })
	private Set<Role> roles;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setLibelle(String value) {
		this.libelle = value;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	public Set<Role> getRoles() {
        if (null == roles) {
            roles = new HashSet<>();
        }
		return roles;
	}
	
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
