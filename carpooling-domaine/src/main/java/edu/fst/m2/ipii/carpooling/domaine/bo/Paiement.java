package edu.fst.m2.ipii.carpooling.domaine.bo;

import javax.persistence.*;

/**
 * Created by Dimitri on 20/03/2015.
 */
@Entity
public class Paiement {
    private int id;
    private double somme;
    private MoyenPaiement moyenPaiement;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Somme")
    public double getSomme() {
        return somme;
    }

    public void setSomme(double somme) {
        this.somme = somme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paiement paiement = (Paiement) o;

        if (id != paiement.id) return false;
        if (Double.compare(paiement.somme, somme) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(somme);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "MoyenPaiementID", referencedColumnName = "ID", nullable = false)
    public MoyenPaiement getMoyenPaiement() {
        return moyenPaiement;
    }

    public void setMoyenPaiement(MoyenPaiement moyenPaiement) {
        this.moyenPaiement = moyenPaiement;
    }
}
