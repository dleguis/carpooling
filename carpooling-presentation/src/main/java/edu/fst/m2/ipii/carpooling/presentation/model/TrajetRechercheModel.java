package edu.fst.m2.ipii.carpooling.presentation.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by Dimitri on 05/04/15.
 */
public class TrajetRechercheModel {

    @NotBlank
    private String villeDepart;

    @NotBlank
    private String villeArrivee;

    @DateTimeFormat(pattern = "dd/MM/YYYY")
    private String dateDepart;

    public TrajetRechercheModel() {
    }

    public String getVilleDepart() {
        return this.villeDepart;
    }

    public String getVilleArrivee() {
        return this.villeArrivee;
    }

    public String getDateDepart() {
        return this.dateDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public void setDateDepart(String dateDepart) {
        this.dateDepart = dateDepart;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof TrajetRechercheModel)) return false;
        final TrajetRechercheModel other = (TrajetRechercheModel) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$villeDepart = this.villeDepart;
        final Object other$villeDepart = other.villeDepart;
        if (this$villeDepart == null ? other$villeDepart != null : !this$villeDepart.equals(other$villeDepart))
            return false;
        final Object this$villeArrivee = this.villeArrivee;
        final Object other$villeArrivee = other.villeArrivee;
        if (this$villeArrivee == null ? other$villeArrivee != null : !this$villeArrivee.equals(other$villeArrivee))
            return false;
        final Object this$dateDepart = this.dateDepart;
        final Object other$dateDepart = other.dateDepart;
        if (this$dateDepart == null ? other$dateDepart != null : !this$dateDepart.equals(other$dateDepart))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $villeDepart = this.villeDepart;
        result = result * PRIME + ($villeDepart == null ? 0 : $villeDepart.hashCode());
        final Object $villeArrivee = this.villeArrivee;
        result = result * PRIME + ($villeArrivee == null ? 0 : $villeArrivee.hashCode());
        final Object $dateDepart = this.dateDepart;
        result = result * PRIME + ($dateDepart == null ? 0 : $dateDepart.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof TrajetRechercheModel;
    }

    public String toString() {
        return "edu.fst.m2.ipii.carpooling.presentation.model.TrajetRechercheModel(villeDepart=" + this.villeDepart + ", villeArrivee=" + this.villeArrivee + ", dateDepart=" + this.dateDepart + ")";
    }
}
