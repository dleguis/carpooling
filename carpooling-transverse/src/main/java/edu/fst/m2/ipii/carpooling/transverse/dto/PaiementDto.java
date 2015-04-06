package edu.fst.m2.ipii.carpooling.transverse.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Dimitri on 05/04/15.
 */
@Getter
@Setter
public class PaiementDto {

    private int ID;

    private MoyenPaiementDto moyenPaiement;

    private double somme;
}
