package edu.fst.m2.ipii.carpooling.transverse.dto;

import java.util.Set;

/**
 * Created by Dimitri on 02/04/15.
 */
public class MembreDto {

    private int ID;

    private String nomMembre;

    private String prenomMembre;

    private Float note;

    private String login;

    private String password;


    private Set<VoitureDto> voitures;


    private Set<AbonnementDto> abonnements;


    private Set<ReservationDto> reservations;


    private Set<AdresseDto> adresses;


    private Set<PreferenceMembreDto> preferenceMembres;


    private Set<ProfilDto> profils;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNomMembre() {
        return nomMembre;
    }

    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }

    public String getPrenomMembre() {
        return prenomMembre;
    }

    public void setPrenomMembre(String prenomMembre) {
        this.prenomMembre = prenomMembre;
    }

    public Float getNote() {
        return note;
    }

    public void setNote(Float note) {
        this.note = note;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<VoitureDto> getVoitures() {
        return voitures;
    }

    public void setVoitures(Set<VoitureDto> voitures) {
        this.voitures = voitures;
    }

    public Set<AbonnementDto> getAbonnements() {
        return abonnements;
    }

    public void setAbonnements(Set<AbonnementDto> abonnements) {
        this.abonnements = abonnements;
    }

    public Set<ReservationDto> getReservations() {
        return reservations;
    }

    public void setReservations(Set<ReservationDto> reservations) {
        this.reservations = reservations;
    }

    public Set<AdresseDto> getAdresses() {
        return adresses;
    }

    public void setAdresses(Set<AdresseDto> adresses) {
        this.adresses = adresses;
    }

    public Set<PreferenceMembreDto> getPreferenceMembres() {
        return preferenceMembres;
    }

    public void setPreferenceMembres(Set<PreferenceMembreDto> preferenceMembres) {
        this.preferenceMembres = preferenceMembres;
    }

    public Set<ProfilDto> getProfils() {
        return profils;
    }

    public void setProfils(Set<ProfilDto> profils) {
        this.profils = profils;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MembreDto membreDto = (MembreDto) o;

        if (ID != membreDto.ID) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ID;
    }
}
