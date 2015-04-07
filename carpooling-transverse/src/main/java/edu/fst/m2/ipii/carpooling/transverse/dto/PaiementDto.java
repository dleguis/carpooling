package edu.fst.m2.ipii.carpooling.transverse.dto;

/**
 * Created by Dimitri on 05/04/15.
 */
public class PaiementDto {

    private int ID;

    private MoyenPaiementDto moyenPaiement;

    private double somme;

    public int getID() {
        return this.ID;
    }

    public MoyenPaiementDto getMoyenPaiement() {
        return this.moyenPaiement;
    }

    public double getSomme() {
        return this.somme;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setMoyenPaiement(MoyenPaiementDto moyenPaiement) {
        this.moyenPaiement = moyenPaiement;
    }

    public void setSomme(double somme) {
        this.somme = somme;
    }
}
