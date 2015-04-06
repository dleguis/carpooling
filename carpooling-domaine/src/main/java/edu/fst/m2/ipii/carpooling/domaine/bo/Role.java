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
@Entity
@Table(name="Role")
public class Role implements Serializable {
	public Role() {
	}
	
	@Column(name="ID", nullable=false, length=255)	
	@Id	
	private String ID;
	
	public void setID(String value) {
		this.ID = value;
	}
	
	public String getID() {
		return ID;
	}
	
	public String getORMID() {
		return getID();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
}
