package edu.fst.m2.ipii.carpooling.transverse.criteria;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

/**
 * Created by Dimitri on 05/04/15.
 */
@Builder
public class TrajetCriteria {

    @Getter
    private String villeDepart;

    @Getter
    private String villeArrivee;

    @Getter
    private Date dateDepart;


}
