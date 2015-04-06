package edu.fst.m2.ipii.carpooling.transverse.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dimitri on 02/04/15.
 */
@Getter
@Setter
public class ProfilDto {

    private int ID;

    private String libelle;

    private Set<RoleDto> roles = new HashSet<>();

}
