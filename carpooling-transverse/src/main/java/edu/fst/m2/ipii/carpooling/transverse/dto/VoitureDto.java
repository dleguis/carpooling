package edu.fst.m2.ipii.carpooling.transverse.dto;

/**
 * Created by Dimitri on 02/04/15.
 */
public class VoitureDto {

    private int ID;

    private String marque;

    private String modele;

    private int nbPlaces;

    private Float puissance;

    private String carburant;

    private String categorie;

    public VoitureDto() {
    }

    public int getID() {
        return this.ID;
    }

    public String getMarque() {
        return this.marque;
    }

    public String getModele() {
        return this.modele;
    }

    public int getNbPlaces() {
        return this.nbPlaces;
    }

    public Float getPuissance() {
        return this.puissance;
    }

    public String getCarburant() {
        return this.carburant;
    }

    public String getCategorie() {
        return this.categorie;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public void setPuissance(Float puissance) {
        this.puissance = puissance;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof VoitureDto)) return false;
        final VoitureDto other = (VoitureDto) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.ID != other.ID) return false;
        final Object this$marque = this.marque;
        final Object other$marque = other.marque;
        if (this$marque == null ? other$marque != null : !this$marque.equals(other$marque)) return false;
        final Object this$modele = this.modele;
        final Object other$modele = other.modele;
        if (this$modele == null ? other$modele != null : !this$modele.equals(other$modele)) return false;
        if (this.nbPlaces != other.nbPlaces) return false;
        final Object this$puissance = this.puissance;
        final Object other$puissance = other.puissance;
        if (this$puissance == null ? other$puissance != null : !this$puissance.equals(other$puissance)) return false;
        final Object this$carburant = this.carburant;
        final Object other$carburant = other.carburant;
        if (this$carburant == null ? other$carburant != null : !this$carburant.equals(other$carburant)) return false;
        final Object this$categorie = this.categorie;
        final Object other$categorie = other.categorie;
        if (this$categorie == null ? other$categorie != null : !this$categorie.equals(other$categorie)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.ID;
        final Object $marque = this.marque;
        result = result * PRIME + ($marque == null ? 0 : $marque.hashCode());
        final Object $modele = this.modele;
        result = result * PRIME + ($modele == null ? 0 : $modele.hashCode());
        result = result * PRIME + this.nbPlaces;
        final Object $puissance = this.puissance;
        result = result * PRIME + ($puissance == null ? 0 : $puissance.hashCode());
        final Object $carburant = this.carburant;
        result = result * PRIME + ($carburant == null ? 0 : $carburant.hashCode());
        final Object $categorie = this.categorie;
        result = result * PRIME + ($categorie == null ? 0 : $categorie.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof VoitureDto;
    }

    public String toString() {
        return "edu.fst.m2.ipii.carpooling.transverse.dto.VoitureDto(ID=" + this.ID + ", marque=" + this.marque + ", modele=" + this.modele + ", nbPlaces=" + this.nbPlaces + ", puissance=" + this.puissance + ", carburant=" + this.carburant + ", categorie=" + this.categorie + ")";
    }
}
