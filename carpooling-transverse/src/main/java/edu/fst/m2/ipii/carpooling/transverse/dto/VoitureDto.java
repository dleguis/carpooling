package edu.fst.m2.ipii.carpooling.transverse.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by Dimitri on 02/04/15.
 */
@Data
public class VoitureDto {

    private int ID;

    private String marque;

    private String modele;

    private int nbPlaces;

    private Float puissance;

    private String carburant;

    private String categorie;
}
