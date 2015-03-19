package edu.fst.m2.ipii.carpooling.domaine.bo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by Dimitri on 20/03/2015.
 */
@Entity
public class Facture {
    private int id;
    private Date date;
    private Paiement paiement;
    private Collection<Reservation> reservations;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        Facture facture = (Facture) o;

        if (id != facture.id) return false;
        if (date != null ? !date.equals(facture.date) : facture.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PaiementID", referencedColumnName = "ID", nullable = false)
    public Paiement getPaiement() {
        return paiement;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }

    @OneToMany(mappedBy = "facture")
    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Collection<Reservation> reservations) {
        this.reservations = reservations;
    }
}
