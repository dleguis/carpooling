package edu.fst.m2.ipii.carpooling.transverse.dto;

import lombok.*;

import java.util.Set;

/**
 * Created by Dimitri on 05/04/15.
 */
public class FormuleDto {

    @Getter
    @Setter
    private int ID;

    @Getter
    @Setter
    private String titre;

    @Getter
    @Setter
    private int tarif;

    @Getter
    @Setter
    private Set<FonctionDto> fonctions;


}
