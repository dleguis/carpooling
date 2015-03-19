package edu.fst.m2.ipii.carpooling.domaine.bo;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Dimitri on 20/03/2015.
 */
@Entity
public class Commentaire {
    private int id;
    private String contenu;
    private Date date;
    private Membre membre;
    private Trajet trajet;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Contenu")
    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Basic
    @Column(name = "Date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commentaire that = (Commentaire) o;

        if (id != that.id) return false;
        if (contenu != null ? !contenu.equals(that.contenu) : that.contenu != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (contenu != null ? contenu.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "MembreID", referencedColumnName = "ID", nullable = false)
    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    @ManyToOne
    @JoinColumn(name = "TrajetID", referencedColumnName = "ID", nullable = false)
    public Trajet getTrajet() {
        return trajet;
    }

    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }
}
