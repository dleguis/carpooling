package edu.fst.m2.ipii.carpooling.domaine.bo;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Dimitri on 20/03/2015.
 */
@Entity
public class Formule {
    private int id;
    private String titre;
    private Collection<Fonction> fonctions;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Titre")
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Formule formule = (Formule) o;

        if (id != formule.id) return false;
        if (titre != null ? !titre.equals(formule.titre) : formule.titre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (titre != null ? titre.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "formuleByFormuleId")
    public Collection<Fonction> getFonctions() {
        return fonctions;
    }

    public void setFonctions(Collection<Fonction> fonctions) {
        this.fonctions = fonctions;
    }
}
