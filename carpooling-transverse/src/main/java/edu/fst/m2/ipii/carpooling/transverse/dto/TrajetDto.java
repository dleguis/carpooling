package edu.fst.m2.ipii.carpooling.transverse.dto;

import edu.fst.m2.ipii.carpooling.transverse.constants.EtatReservation;

import java.util.*;

/**
 * Created by Dimitri on 05/04/15.
 */
public class TrajetDto {

    private int ID;

    private PointEmbarquementDto arrivee;

    private PointEmbarquementDto depart;

    private VoitureDto voiture;

    private String titre;

    private boolean actif;

    private Date dateDepart;

    private int nbPlacesDisponibles;

    private double tarif;

    private String conducteur;

    private List<String> passagers;

    private List<ReservationDto> reservations = new ArrayList<>();

    private Set<CommentaireDto> commentaires = new HashSet<>();

    public PointEmbarquementDto getPointDepart() {
        for (ReservationDto reservationDto : getReservations()) {
            if (EtatReservation.INITIALE.equals(reservationDto.getEtat()) || reservationDto.isInitiale()) {
                return reservationDto.getPointEmbarquement();
            }
        }

        return null;
    }

    public List<PointEmbarquementDto> getEtapes() {
        List<PointEmbarquementDto> pts = new ArrayList<>();
        for (ReservationDto reservationDto : getReservations()) {
            if (EtatReservation.VALIDEE.equals(reservationDto.getEtat())) {
                pts.add(reservationDto.getPointEmbarquement());
            }
        }

        return pts;
    }

    public int getID() {
        return this.ID;
    }

    public PointEmbarquementDto getArrivee() {
        return this.arrivee;
    }

    public PointEmbarquementDto getDepart() {
        return this.depart;
    }

    public VoitureDto getVoiture() {
        return this.voiture;
    }

    public String getTitre() {
        return this.titre;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public Date getDateDepart() {
        return this.dateDepart;
    }

    public int getNbPlacesDisponibles() {
        return this.nbPlacesDisponibles;
    }

    public double getTarif() {
        return this.tarif;
    }

    public String getConducteur() {
        return this.conducteur;
    }

    public List<String> getPassagers() {
        return this.passagers;
    }

    public List<ReservationDto> getReservations() {
        return this.reservations;
    }

    public Set<CommentaireDto> getCommentaires() {
        return this.commentaires;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setArrivee(PointEmbarquementDto arrivee) {
        this.arrivee = arrivee;
    }

    public void setDepart(PointEmbarquementDto depart) {
        this.depart = depart;
    }

    public void setVoiture(VoitureDto voiture) {
        this.voiture = voiture;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public void setNbPlacesDisponibles(int nbPlacesDisponibles) {
        this.nbPlacesDisponibles = nbPlacesDisponibles;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    public void setConducteur(String conducteur) {
        this.conducteur = conducteur;
    }

    public void setPassagers(List<String> passagers) {
        this.passagers = passagers;
    }

    public void setReservations(List<ReservationDto> reservations) {
        this.reservations = reservations;
    }

    public void setCommentaires(Set<CommentaireDto> commentaires) {
        this.commentaires = commentaires;
    }
}
