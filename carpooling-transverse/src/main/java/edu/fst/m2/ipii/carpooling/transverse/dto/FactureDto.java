package edu.fst.m2.ipii.carpooling.transverse.dto;

import java.util.Date;

/**
 * Created by Dimitri on 05/04/15.
 */
public class FactureDto {

    private int ID;

    private PaiementDto paiement;

    private Date dateFacture;

    public int getID() {
        return this.ID;
    }

    public PaiementDto getPaiement() {
        return this.paiement;
    }

    public Date getDateFacture() {
        return this.dateFacture;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPaiement(PaiementDto paiement) {
        this.paiement = paiement;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }
}
