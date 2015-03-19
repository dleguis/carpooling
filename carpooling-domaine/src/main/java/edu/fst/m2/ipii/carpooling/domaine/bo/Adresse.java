package edu.fst.m2.ipii.carpooling.domaine.bo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Dimitri on 20/03/2015.
 */
@Entity
public class Adresse {
    private int id;
    private String rue;
    private String ville;
    private String codePostal;
    private Float latitude;
    private Float longitude;
    private String pays;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Rue")
    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    @Basic
    @Column(name = "Ville")
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Basic
    @Column(name = "CodePostal")
    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    @Basic
    @Column(name = "Latitude")
    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "Longitude")
    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "Pays")
    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adresse adresse = (Adresse) o;

        if (id != adresse.id) return false;
        if (codePostal != null ? !codePostal.equals(adresse.codePostal) : adresse.codePostal != null) return false;
        if (latitude != null ? !latitude.equals(adresse.latitude) : adresse.latitude != null) return false;
        if (longitude != null ? !longitude.equals(adresse.longitude) : adresse.longitude != null) return false;
        if (pays != null ? !pays.equals(adresse.pays) : adresse.pays != null) return false;
        if (rue != null ? !rue.equals(adresse.rue) : adresse.rue != null) return false;
        if (ville != null ? !ville.equals(adresse.ville) : adresse.ville != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (rue != null ? rue.hashCode() : 0);
        result = 31 * result + (ville != null ? ville.hashCode() : 0);
        result = 31 * result + (codePostal != null ? codePostal.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (pays != null ? pays.hashCode() : 0);
        return result;
    }
}
