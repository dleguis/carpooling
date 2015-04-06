package edu.fst.m2.ipii.carpooling.presentation.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by Dimitri on 05/04/15.
 */
@Data
public class TrajetRechercheModel {

    private String villeDepart;

    private String villeArrivee;

    private Date dateDepart;
}
