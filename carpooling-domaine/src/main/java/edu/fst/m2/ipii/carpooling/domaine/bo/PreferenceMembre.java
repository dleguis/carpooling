package edu.fst.m2.ipii.carpooling.domaine.bo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Dimitri on 20/03/2015.
 */
@Entity
public class PreferenceMembre {
    private int id;
    private String preference;
    private String valeur;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Preference")
    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    @Basic
    @Column(name = "Valeur")
    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PreferenceMembre that = (PreferenceMembre) o;

        if (id != that.id) return false;
        if (preference != null ? !preference.equals(that.preference) : that.preference != null) return false;
        if (valeur != null ? !valeur.equals(that.valeur) : that.valeur != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (preference != null ? preference.hashCode() : 0);
        result = 31 * result + (valeur != null ? valeur.hashCode() : 0);
        return result;
    }
}
