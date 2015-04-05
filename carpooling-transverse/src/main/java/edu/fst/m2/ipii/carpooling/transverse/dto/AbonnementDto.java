package edu.fst.m2.ipii.carpooling.transverse.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

/**
 * Created by Dimitri on 02/04/15.
 */
public class AbonnementDto {

    @Getter
    @Setter
    private int ID;

    @Getter
    @Setter
    private String libelle;

    @Getter
    @Setter
    private Date dateDebutValide;

    @Getter
    @Setter
    private Date dateFinValide;

    @Getter
    @Setter
    private Set<FormuleDto> formules;
}
