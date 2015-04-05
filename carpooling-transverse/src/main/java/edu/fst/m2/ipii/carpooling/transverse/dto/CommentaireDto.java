package edu.fst.m2.ipii.carpooling.transverse.dto;

import lombok.*;

import java.util.Date;

/**
 * Created by Dimitri on 05/04/15.
 */

public class CommentaireDto {

    @Getter
    @Setter
    private int ID;

    @Getter
    @Setter
    private MembreDto membre;

    @Getter
    @Setter
    private String contenu;

    @Getter
    @Setter
    private Date dateCommentaire;


}
