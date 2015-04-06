package edu.fst.m2.ipii.carpooling.transverse.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dimitri on 05/04/15.
 */
@Getter
@Setter
public class FormuleDto {

    private int ID;

    private String titre;

    private int tarif;

    private Set<FonctionDto> fonctions = new HashSet<>();


}
