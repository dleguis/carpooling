package edu.fst.m2.ipii.carpooling.transverse.dto;

/**
 * Created by Dimitri on 05/04/15.
 */

public class FonctionDto {

    private String ID;

    private String libelle;

    public FonctionDto() {
    }

    public String getID() {
        return this.ID;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof FonctionDto)) return false;
        final FonctionDto other = (FonctionDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$ID = this.ID;
        final Object other$ID = other.ID;
        if (this$ID == null ? other$ID != null : !this$ID.equals(other$ID)) return false;
        final Object this$libelle = this.libelle;
        final Object other$libelle = other.libelle;
        if (this$libelle == null ? other$libelle != null : !this$libelle.equals(other$libelle)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $ID = this.ID;
        result = result * PRIME + ($ID == null ? 0 : $ID.hashCode());
        final Object $libelle = this.libelle;
        result = result * PRIME + ($libelle == null ? 0 : $libelle.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof FonctionDto;
    }

    public String toString() {
        return "edu.fst.m2.ipii.carpooling.transverse.dto.FonctionDto(ID=" + this.ID + ", libelle=" + this.libelle + ")";
    }
}
