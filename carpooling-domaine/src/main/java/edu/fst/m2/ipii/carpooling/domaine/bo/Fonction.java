package edu.fst.m2.ipii.carpooling.domaine.bo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Dimitri on 20/03/2015.
 */
@Entity
public class Fonction {
    private String id;
    private String libelle;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Libelle")
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fonction fonction = (Fonction) o;

        if (id != null ? !id.equals(fonction.id) : fonction.id != null) return false;
        if (libelle != null ? !libelle.equals(fonction.libelle) : fonction.libelle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        return result;
    }
}
