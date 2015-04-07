package edu.fst.m2.ipii.carpooling.transverse.dto;

/**
 * Created by Dimitri on 02/04/15.
 */

public class AdresseDto {

    private int ID;

    private String rue;

    private String ville;

    private String codePostal;

    private Double latitude;

    private Double longitude;

    private String pays;

    public AdresseDto() {
    }


    public int getID() {
        return this.ID;
    }

    public String getRue() {
        return this.rue;
    }

    public String getVille() {
        return this.ville;
    }

    public String getCodePostal() {
        return this.codePostal;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public String getPays() {
        return this.pays;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof AdresseDto)) return false;
        final AdresseDto other = (AdresseDto) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.ID != other.ID) return false;
        final Object this$rue = this.rue;
        final Object other$rue = other.rue;
        if (this$rue == null ? other$rue != null : !this$rue.equals(other$rue)) return false;
        final Object this$ville = this.ville;
        final Object other$ville = other.ville;
        if (this$ville == null ? other$ville != null : !this$ville.equals(other$ville)) return false;
        final Object this$codePostal = this.codePostal;
        final Object other$codePostal = other.codePostal;
        if (this$codePostal == null ? other$codePostal != null : !this$codePostal.equals(other$codePostal))
            return false;
        final Object this$latitude = this.latitude;
        final Object other$latitude = other.latitude;
        if (this$latitude == null ? other$latitude != null : !this$latitude.equals(other$latitude)) return false;
        final Object this$longitude = this.longitude;
        final Object other$longitude = other.longitude;
        if (this$longitude == null ? other$longitude != null : !this$longitude.equals(other$longitude)) return false;
        final Object this$pays = this.pays;
        final Object other$pays = other.pays;
        if (this$pays == null ? other$pays != null : !this$pays.equals(other$pays)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.ID;
        final Object $rue = this.rue;
        result = result * PRIME + ($rue == null ? 0 : $rue.hashCode());
        final Object $ville = this.ville;
        result = result * PRIME + ($ville == null ? 0 : $ville.hashCode());
        final Object $codePostal = this.codePostal;
        result = result * PRIME + ($codePostal == null ? 0 : $codePostal.hashCode());
        final Object $latitude = this.latitude;
        result = result * PRIME + ($latitude == null ? 0 : $latitude.hashCode());
        final Object $longitude = this.longitude;
        result = result * PRIME + ($longitude == null ? 0 : $longitude.hashCode());
        final Object $pays = this.pays;
        result = result * PRIME + ($pays == null ? 0 : $pays.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof AdresseDto;
    }

    public String toString() {
        return "edu.fst.m2.ipii.carpooling.transverse.dto.AdresseDto(ID=" + this.ID + ", rue=" + this.rue + ", ville=" + this.ville + ", codePostal=" + this.codePostal + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", pays=" + this.pays + ")";
    }
}
