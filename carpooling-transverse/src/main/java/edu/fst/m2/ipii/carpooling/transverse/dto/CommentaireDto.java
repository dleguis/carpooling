package edu.fst.m2.ipii.carpooling.transverse.dto;

import java.util.Date;

/**
 * Created by Dimitri on 05/04/15.
 */
public class CommentaireDto {

    private int ID;

    private MembreDto membre;

    private String contenu;

    private Date dateCommentaire;

    public int getID() {
        return this.ID;
    }

    public MembreDto getMembre() {
        return this.membre;
    }

    public String getContenu() {
        return this.contenu;
    }

    public Date getDateCommentaire() {
        return this.dateCommentaire;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setMembre(MembreDto membre) {
        this.membre = membre;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setDateCommentaire(Date dateCommentaire) {
        this.dateCommentaire = dateCommentaire;
    }
}
