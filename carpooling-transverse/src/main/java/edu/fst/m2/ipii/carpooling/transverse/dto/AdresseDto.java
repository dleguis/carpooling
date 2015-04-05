package edu.fst.m2.ipii.carpooling.transverse.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by Dimitri on 02/04/15.
 */

@Data
public class AdresseDto {

    private int ID;

    private String rue;

    private String ville;

    private String codePostal;

    private Double latitude;

    private Double longitude;

    private String pays;


}
