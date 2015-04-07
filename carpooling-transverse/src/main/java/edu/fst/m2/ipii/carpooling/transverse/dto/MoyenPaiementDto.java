package edu.fst.m2.ipii.carpooling.transverse.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dimitri on 05/04/15.
 */
public class MoyenPaiementDto {

    private int ID;

    private String libelle;

    private Set<PaiementDto> paiements = new HashSet<>();

    public int getID() {
        return this.ID;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public Set<PaiementDto> getPaiements() {
        return this.paiements;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setPaiements(Set<PaiementDto> paiements) {
        this.paiements = paiements;
    }
}
