package edu.fst.m2.ipii.carpooling.transverse.dto;

import lombok.*;

/**
 * Created by Dimitri on 05/04/15.
 */
public class PointEmbarquementDto {

    @Getter
    @Setter
    private int ID;

    @Getter
    @Setter
    private ReservationDto reservation;

    @Getter
    @Setter
    private Double latitude;

    @Getter
    @Setter
    private Double longitude;


}
