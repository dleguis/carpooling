package edu.fst.m2.ipii.carpooling.presentation.model;

import edu.fst.m2.ipii.carpooling.transverse.constants.Carburant;
import edu.fst.m2.ipii.carpooling.transverse.constants.CategorieEnum;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by Dimitri on 14/04/2015.
 */
public class VoitureForm {

    @NotBlank
    private String marque;

    @NotBlank
    private String modele;

    @NotNull
    private Integer nbPlaces;

    private Float puissance;

    private Carburant carburant;

    private CategorieEnum categorie;

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Integer getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(Integer nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public Float getPuissance() {
        return puissance;
    }

    public void setPuissance(Float puissance) {
        this.puissance = puissance;
    }

    public Carburant getCarburant() {
        return carburant;
    }

    public void setCarburant(Carburant carburant) {
        this.carburant = carburant;
    }

    public CategorieEnum getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieEnum categorie) {
        this.categorie = categorie;
    }
}
