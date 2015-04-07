package edu.fst.m2.ipii.carpooling.transverse.dto;

/**
 * Created by Dimitri on 02/04/15.
 */

public class RoleDto {

    private String ID;

    public RoleDto() {
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof RoleDto)) return false;
        final RoleDto other = (RoleDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$ID = this.ID;
        final Object other$ID = other.ID;
        if (this$ID == null ? other$ID != null : !this$ID.equals(other$ID)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $ID = this.ID;
        result = result * PRIME + ($ID == null ? 0 : $ID.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof RoleDto;
    }

    public String toString() {
        return "edu.fst.m2.ipii.carpooling.transverse.dto.RoleDto(ID=" + this.ID + ")";
    }
}
