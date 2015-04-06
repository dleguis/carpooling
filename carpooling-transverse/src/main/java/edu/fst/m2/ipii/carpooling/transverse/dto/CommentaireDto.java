package edu.fst.m2.ipii.carpooling.transverse.dto;

import lombok.*;

import java.util.Date;

/**
 * Created by Dimitri on 05/04/15.
 */
@Getter
@Setter
public class CommentaireDto {

    private int ID;

    private MembreDto membre;

    private String contenu;

    private Date dateCommentaire;

}
