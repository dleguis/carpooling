package edu.fst.m2.ipii.carpooling.domaine.bo;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Dimitri on 20/03/2015.
 */
@Entity
public class Abonnement {
    private int id;
    private int formuleId;
    private int membreId;
    private String libelle;
    private Date dateDebutValide;
    private Date dateFinValide;
    private Formule formule;
    private Membre membre;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "FormuleID")
    public int getFormuleId() {
        return formuleId;
    }

    public void setFormuleId(int formuleId) {
        this.formuleId = formuleId;
    }

    @Basic
    @Column(name = "MembreID")
    public int getMembreId() {
        return membreId;
    }

    public void setMembreId(int membreId) {
        this.membreId = membreId;
    }

    @Basic
    @Column(name = "Libelle")
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Basic
    @Column(name = "DateDebutValide")
    public Date getDateDebutValide() {
        return dateDebutValide;
    }

    public void setDateDebutValide(Date dateDebutValide) {
        this.dateDebutValide = dateDebutValide;
    }

    @Basic
    @Column(name = "DateFinValide")
    public Date getDateFinValide() {
        return dateFinValide;
    }

    public void setDateFinValide(Date dateFinValide) {
        this.dateFinValide = dateFinValide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Abonnement that = (Abonnement) o;

        if (formuleId != that.formuleId) return false;
        if (id != that.id) return false;
        if (membreId != that.membreId) return false;
        if (dateDebutValide != null ? !dateDebutValide.equals(that.dateDebutValide) : that.dateDebutValide != null)
            return false;
        if (dateFinValide != null ? !dateFinValide.equals(that.dateFinValide) : that.dateFinValide != null)
            return false;
        if (libelle != null ? !libelle.equals(that.libelle) : that.libelle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + formuleId;
        result = 31 * result + membreId;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        result = 31 * result + (dateDebutValide != null ? dateDebutValide.hashCode() : 0);
        result = 31 * result + (dateFinValide != null ? dateFinValide.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "FormuleID", referencedColumnName = "ID", nullable = false)
    public Formule getFormule() {
        return formule;
    }

    public void setFormule(Formule formule) {
        this.formule = formule;
    }

    @ManyToOne
    @JoinColumn(name = "MembreID", referencedColumnName = "ID", nullable = false)
    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }
}
