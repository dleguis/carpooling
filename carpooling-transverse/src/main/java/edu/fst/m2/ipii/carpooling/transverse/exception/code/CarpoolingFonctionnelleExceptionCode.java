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

    /** The ER r_ boo k_001. */
    ERR_BOOK_001("Le livre n'existe pas"),

    /** The ER r_ autho r_001. */
    ERR_AUTHOR_001("L'auteur n'existe pas"),

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
