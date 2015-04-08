package edu.fst.m2.ipii.carpooling.transverse.dto;

/**
 * Created by Dimitri on 09/04/2015.
 */
public class CoordonneesVilleDto {

    private String request;

    private String rue;

    private String codePostal;

    private String ville;

    private String pays;

    private double latitude;

    private double longitude;


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

    public String toString() {
        return "edu.fst.m2.ipii.carpooling.transverse.dto.CoordonneesVilleDto(request=" + this.request + ", rue=" + this.rue + ", codePostal=" + this.codePostal + ", ville=" + this.ville + ", pays=" + this.pays + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ")";
    }
}
