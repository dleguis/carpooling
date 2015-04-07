package edu.fst.m2.ipii.carpooling.transverse.criteria;

import java.util.Date;

/**
 * Created by Dimitri on 05/04/15.
 */
public class TrajetCriteria {

    private String villeDepart;

    private String villeArrivee;

    private Date dateDepart;

    @java.beans.ConstructorProperties({"villeDepart", "villeArrivee", "dateDepart"})
    TrajetCriteria(String villeDepart, String villeArrivee, Date dateDepart) {
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.dateDepart = dateDepart;
    }

    public static TrajetCriteriaBuilder builder() {
        return new TrajetCriteriaBuilder();
    }


    public String getVilleDepart() {
        return this.villeDepart;
    }

    public String getVilleArrivee() {
        return this.villeArrivee;
    }

    public Date getDateDepart() {
        return this.dateDepart;
    }

    public static class TrajetCriteriaBuilder {
        private String villeDepart;
        private String villeArrivee;
        private Date dateDepart;

        TrajetCriteriaBuilder() {
        }

        public TrajetCriteria.TrajetCriteriaBuilder villeDepart(String villeDepart) {
            this.villeDepart = villeDepart;
            return this;
        }

        public TrajetCriteria.TrajetCriteriaBuilder villeArrivee(String villeArrivee) {
            this.villeArrivee = villeArrivee;
            return this;
        }

        public TrajetCriteria.TrajetCriteriaBuilder dateDepart(Date dateDepart) {
            this.dateDepart = dateDepart;
            return this;
        }

        public TrajetCriteria build() {
            return new TrajetCriteria(villeDepart, villeArrivee, dateDepart);
        }

        public String toString() {
            return "edu.fst.m2.ipii.carpooling.transverse.criteria.TrajetCriteria.TrajetCriteriaBuilder(villeDepart=" + this.villeDepart + ", villeArrivee=" + this.villeArrivee + ", dateDepart=" + this.dateDepart + ")";
        }
    }
}
