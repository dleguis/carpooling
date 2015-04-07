package edu.fst.m2.ipii.carpooling.transverse.dto;

/**
 * Created by Dimitri on 02/04/15.
 */

public class PreferenceMembreDto {

    private int ID;

    private String cle;

    private String valeur;

    private String libelle;

    public PreferenceMembreDto() {
    }

    public int getID() {
        return this.ID;
    }

    public String getCle() {
        return this.cle;
    }

    public String getValeur() {
        return this.valeur;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCle(String cle) {
        this.cle = cle;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof PreferenceMembreDto)) return false;
        final PreferenceMembreDto other = (PreferenceMembreDto) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.ID != other.ID) return false;
        final Object this$cle = this.cle;
        final Object other$cle = other.cle;
        if (this$cle == null ? other$cle != null : !this$cle.equals(other$cle)) return false;
        final Object this$valeur = this.valeur;
        final Object other$valeur = other.valeur;
        if (this$valeur == null ? other$valeur != null : !this$valeur.equals(other$valeur)) return false;
        final Object this$libelle = this.libelle;
        final Object other$libelle = other.libelle;
        if (this$libelle == null ? other$libelle != null : !this$libelle.equals(other$libelle)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.ID;
        final Object $cle = this.cle;
        result = result * PRIME + ($cle == null ? 0 : $cle.hashCode());
        final Object $valeur = this.valeur;
        result = result * PRIME + ($valeur == null ? 0 : $valeur.hashCode());
        final Object $libelle = this.libelle;
        result = result * PRIME + ($libelle == null ? 0 : $libelle.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof PreferenceMembreDto;
    }

    public String toString() {
        return "edu.fst.m2.ipii.carpooling.transverse.dto.PreferenceMembreDto(ID=" + this.ID + ", cle=" + this.cle + ", valeur=" + this.valeur + ", libelle=" + this.libelle + ")";
    }
}
