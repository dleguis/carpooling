package edu.fst.m2.ipii.carpooling.transverse.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dimitri on 02/04/15.
 */
@Getter
@Setter
public class AbonnementDto {

    private int ID;

    private String libelle;

    private Date dateDebutValide;

    private Date dateFinValide;

    private Set<FormuleDto> formules = new HashSet<>();
}
