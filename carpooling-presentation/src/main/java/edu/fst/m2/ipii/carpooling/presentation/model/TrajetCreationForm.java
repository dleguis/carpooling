package edu.fst.m2.ipii.carpooling.presentation.model;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Dimitri on 10/04/2015.
 */
public class TrajetCreationForm {

    @NotBlank
    private String adresseDepart;

    @NotBlank
    private String adresseArrivee;

    private int voitureId;

    private int nbUtilisateursInitiaux = 1;

    private double prix;

    @NotBlank
    private String titre;

    private String dateDepart;

    public String getAdresseDepart() {
        return adresseDepart;
    }

    public void setAdresseDepart(String adresseDepart) {
        this.adresseDepart = adresseDepart;
    }

    public String getAdresseArrivee() {
        return adresseArrivee;
    }

    public void setAdresseArrivee(String adresseArrivee) {
        this.adresseArrivee = adresseArrivee;
    }

    public int getVoitureId() {
        return voitureId;
    }

    public void setVoitureId(int voitureId) {
        this.voitureId = voitureId;
    }

    public int getNbUtilisateursInitiaux() {
        return nbUtilisateursInitiaux;
    }

    public void setNbUtilisateursInitiaux(int nbUtilisateursInitiaux) {
        this.nbUtilisateursInitiaux = nbUtilisateursInitiaux;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(String dateDepart) {
        this.dateDepart = dateDepart;
    }
}
