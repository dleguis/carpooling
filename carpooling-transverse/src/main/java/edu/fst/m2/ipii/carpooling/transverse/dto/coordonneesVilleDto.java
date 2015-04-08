package edu.fst.m2.ipii.carpooling.transverse.dto;

/**
 * Created by Dimitri on 07/04/2015.
 */
public class CoordonneesVilleDto {

    private String request;

    private String rue;

    private String codePostal;

    private String ville;

    private String pays;

    private double latitude;

    private double longitude;

    private double distance;

    public CoordonneesVilleDto() {
    }

    public String getRequest() {
        return this.request;
    }

    public String getRue() {
        return this.rue;
    }

    public String getCodePostal() {
        return this.codePostal;
    }

    public String getVille() {
        return this.ville;
    }

    public String getPays() {
        return this.pays;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof CoordonneesVilleDto)) return false;
        final CoordonneesVilleDto other = (CoordonneesVilleDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$request = this.request;
        final Object other$request = other.request;
        if (this$request == null ? other$request != null : !this$request.equals(other$request)) return false;
        final Object this$rue = this.rue;
        final Object other$rue = other.rue;
        if (this$rue == null ? other$rue != null : !this$rue.equals(other$rue)) return false;
        final Object this$codePostal = this.codePostal;
        final Object other$codePostal = other.codePostal;
        if (this$codePostal == null ? other$codePostal != null : !this$codePostal.equals(other$codePostal))
            return false;
        final Object this$ville = this.ville;
        final Object other$ville = other.ville;
        if (this$ville == null ? other$ville != null : !this$ville.equals(other$ville)) return false;
        final Object this$pays = this.pays;
        final Object other$pays = other.pays;
        if (this$pays == null ? other$pays != null : !this$pays.equals(other$pays)) return false;
        if (Double.compare(this.latitude, other.latitude) != 0) return false;
        if (Double.compare(this.longitude, other.longitude) != 0) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $request = this.request;
        result = result * PRIME + ($request == null ? 0 : $request.hashCode());
        final Object $rue = this.rue;
        result = result * PRIME + ($rue == null ? 0 : $rue.hashCode());
        final Object $codePostal = this.codePostal;
        result = result * PRIME + ($codePostal == null ? 0 : $codePostal.hashCode());
        final Object $ville = this.ville;
        result = result * PRIME + ($ville == null ? 0 : $ville.hashCode());
        final Object $pays = this.pays;
        result = result * PRIME + ($pays == null ? 0 : $pays.hashCode());
        final long $latitude = Double.doubleToLongBits(this.latitude);
        result = result * PRIME + (int) ($latitude >>> 32 ^ $latitude);
        final long $longitude = Double.doubleToLongBits(this.longitude);
        result = result * PRIME + (int) ($longitude >>> 32 ^ $longitude);
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof CoordonneesVilleDto;
    }

    public String toString() {
        return "edu.fst.m2.ipii.carpooling.transverse.dto.CoordonneesVilleDto(request=" + this.request + ", rue=" + this.rue + ", codePostal=" + this.codePostal + ", ville=" + this.ville + ", pays=" + this.pays + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ")";
    }
}
