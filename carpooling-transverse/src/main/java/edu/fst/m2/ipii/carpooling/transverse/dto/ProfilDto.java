package edu.fst.m2.ipii.carpooling.transverse.dto;

import java.util.Set;

/**
 * Created by Dimitri on 02/04/15.
 */
public class ProfilDto {

    private int ID;

    private String libelle;

    private Set<RoleDto> roles;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Set<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDto> roles) {
        this.roles = roles;
    }
}
