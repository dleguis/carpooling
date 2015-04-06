package edu.fst.m2.ipii.carpooling.presentation.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Dimitri on 05/04/15.
 */
@Data
public class TrajetRechercheModel {

    @NotBlank
    private String villeDepart;

    @NotBlank
    private String villeArrivee;

    @DateTimeFormat(pattern = "dd/MM/YYYY")
    private String dateDepart;
}
