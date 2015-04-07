package edu.fst.m2.ipii.carpooling.transverse.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dimitri on 02/04/15.
 */
public class ProfilDto {

    private int ID;

    private String libelle;

    private Set<RoleDto> roles = new HashSet<>();

    public int getID() {
        return this.ID;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public Set<RoleDto> getRoles() {
        return this.roles;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setRoles(Set<RoleDto> roles) {
        this.roles = roles;
    }
}
