package edu.fst.m2.ipii.carpooling.transverse.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Dimitri on 05/04/15.
 */
public class PaiementDto {

    @Getter
    @Setter
    private int ID;

    @Getter
    @Setter
    private MoyenPaiementDto moyenPaiement;

    @Getter
    @Setter
    private double somme;
}
