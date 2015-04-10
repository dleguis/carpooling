package edu.fst.m2.ipii.carpooling.transverse.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    private String email;

    private List<VoitureDto> voitures = new ArrayList<>();

    private Set<AbonnementDto> abonnements = new HashSet<>();

    private Set<ReservationDto> reservations = new HashSet<>();

    private Set<AdresseDto> adresses = new HashSet<>();

    private Set<PreferenceMembreDto> preferenceMembres = new HashSet<>();

    private Set<ProfilDto> profils = new HashSet<>();

    public VoitureDto getVoitureWithId(int voitureId) {
        for (VoitureDto voiture : getVoitures()) {
            if (voiture.getID() == voitureId) {
                return voiture;
            }
        }

        return null;
    }

    public int getID() {
        return this.ID;
    }

    public String getNomMembre() {
        return this.nomMembre;
    }

    public String getPrenomMembre() {
        return this.prenomMembre;
    }

    public Float getNote() {
        return this.note;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<VoitureDto> getVoitures() {
        return this.voitures;
    }

    public Set<AbonnementDto> getAbonnements() {
        return this.abonnements;
    }

    public Set<ReservationDto> getReservations() {
        return this.reservations;
    }

    public Set<AdresseDto> getAdresses() {
        return this.adresses;
    }

    public Set<PreferenceMembreDto> getPreferenceMembres() {
        return this.preferenceMembres;
    }

    public Set<ProfilDto> getProfils() {
        return this.profils;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }

    public void setPrenomMembre(String prenomMembre) {
        this.prenomMembre = prenomMembre;
    }

    public void setNote(Float note) {
        this.note = note;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setVoitures(List<VoitureDto> voitures) {
        this.voitures = voitures;
    }

    public void setAbonnements(Set<AbonnementDto> abonnements) {
        this.abonnements = abonnements;
    }

    public void setReservations(Set<ReservationDto> reservations) {
        this.reservations = reservations;
    }

    public void setAdresses(Set<AdresseDto> adresses) {
        this.adresses = adresses;
    }

    public void setPreferenceMembres(Set<PreferenceMembreDto> preferenceMembres) {
        this.preferenceMembres = preferenceMembres;
    }

    public void setProfils(Set<ProfilDto> profils) {
        this.profils = profils;
    }
}
