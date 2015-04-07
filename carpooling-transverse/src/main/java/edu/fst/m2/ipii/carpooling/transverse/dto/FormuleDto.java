package edu.fst.m2.ipii.carpooling.transverse.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dimitri on 05/04/15.
 */
public class FormuleDto {

    private int ID;

    private String titre;

    private int tarif;

    private Set<FonctionDto> fonctions = new HashSet<>();


    public int getID() {
        return this.ID;
    }

    public String getTitre() {
        return this.titre;
    }

    public int getTarif() {
        return this.tarif;
    }

    public Set<FonctionDto> getFonctions() {
        return this.fonctions;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public void setFonctions(Set<FonctionDto> fonctions) {
        this.fonctions = fonctions;
    }
}
