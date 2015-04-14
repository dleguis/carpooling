package edu.fst.m2.ipii.carpooling.transverse.exception.code;

/**
 * Created by Dimitri on 16/11/14.
 */
public enum CarpoolingFonctionnelleExceptionCode {

    /**
     * The ER r_ use r_001.
     */
    ERR_USER_001("L'utilisateur existe déjà"),

    /** The ER r_ use r_002. */
    ERR_USER_002("L'utilisateur n'existe pas"),

    /** The ER r_ use r_003. */
    ERR_USER_003("Modification de cet utilisateur interdite"),

    /**
     * The ER r_ use r_004.
     */
    ERR_USER_004("Mot de passe incorrect"),

    ERR_USER_005("Le nom d'utilisateur ou l'adresse email existe déjà"),

    /** The ER r_ boo k_001. */
    ERR_TRAJET_001("Le trajet existe déjà"),

    /** The ER r_ autho r_001. */
    ERR_TRAJET_002("Le trajet n'existe pas"),

    ERR_TRAJET_003("Le trajet est plein"),

    ERR_RESA_001("La réservation n'existe pas"),

    ERR_VOITURE_001("La voiture n'existe pas"),

    ERR_VOITURE_002("Action interdite sur cette voiture"),

    /** The ER r_ orde r_001. */
    ERR_ORDER_001("La commande n'existe pas"),

    /** The ER r_ orde r_002. */
    ERR_ORDER_002("Modification de commande interdite");

    /** The message. */
    private String message;

    /**
     * Instantiates a new bookstore fonctionnelle exception code.
     *
     * @param message the message
     */
    private CarpoolingFonctionnelleExceptionCode(String message) {
	this.message = message;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
	return message;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
	return message;
    }
}
