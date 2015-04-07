package edu.fst.m2.ipii.carpooling.transverse.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dimitri on 02/04/15.
 */
public class AbonnementDto {

    private int ID;

    private String libelle;

    private Date dateDebutValide;

    private Date dateFinValide;

    private Set<FormuleDto> formules = new HashSet<>();

    public int getID() {
        return this.ID;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public Date getDateDebutValide() {
        return this.dateDebutValide;
    }

    public Date getDateFinValide() {
        return this.dateFinValide;
    }

    public Set<FormuleDto> getFormules() {
        return this.formules;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setDateDebutValide(Date dateDebutValide) {
        this.dateDebutValide = dateDebutValide;
    }

    public void setDateFinValide(Date dateFinValide) {
        this.dateFinValide = dateFinValide;
    }

    public void setFormules(Set<FormuleDto> formules) {
        this.formules = formules;
    }
}
