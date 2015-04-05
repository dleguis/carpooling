package edu.fst.m2.ipii.carpooling.transverse.dto;

import lombok.*;

import java.util.Date;

/**
 * Created by Dimitri on 05/04/15.
 */
public class FactureDto {

    @Getter
    @Setter
    private int ID;

    @Getter
    @Setter
    private PaiementDto paiement;

    @Getter
    @Setter
    private Date dateFacture;
}
