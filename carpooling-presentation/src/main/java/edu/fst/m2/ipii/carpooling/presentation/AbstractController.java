package edu.fst.m2.ipii.carpooling.presentation;


import edu.fst.m2.ipii.carpooling.presentation.model.Cart;
import edu.fst.m2.ipii.carpooling.presentation.model.CartArticle;
import edu.fst.m2.ipii.carpooling.transverse.constants.Constants;
import edu.fst.m2.ipii.carpooling.transverse.dto.Utilisateur;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

/**
 * Created by Dimitri on 16/11/14.
 */
public abstract class AbstractController {

    /**
     * The Constant LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractController.class);

    // @Autowired
    // protected Cart cart;

    /**
     * Gets the user profil.
     *
     * @return the user profil
     */
    @ModelAttribute
    public Utilisateur getUserProfil() {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        return (Utilisateur) a.getPrincipal();
    }

    /**
     * Gets the cart.
     *
     * @param session
     *            the session
     * @return the cart
     */
    @ModelAttribute(value = "cart")
    public Cart getCart(HttpSession session) {

	Cart cart = null;

	try {
	    cart = (Cart) session.getAttribute(Constants.CART.name());
	} catch (ClassCastException exception) {
	    LOGGER.warn("Echec du cast du Cart");
	    cart = new Cart();
	}

	if (cart == null) {
	    cart = new Cart();
	}

	return cart;
    }

    /**
     * Gets the cart quantity.
     *
     * @param session
     *            the session
     * @return the cart quantity
     */
    public String getCartQuantity(HttpSession session) {
	return String.valueOf(CollectionUtils.size(getCart(session).getArticles()));
    }

    /**
     * Adds the cart article.
     *
     * @param session
     *            the session
     * @param article
     *            the article
     */
    public void addCartArticle(HttpSession session, CartArticle article) {
        Cart cart = getCart(session);
        cart.addArticle(article);

        session.setAttribute(Constants.CART.name(), cart);
    }

    /**
     * Update cart article.
     *
     * @param session
     *            the session
     * @param article
     *            the article
     * @param quantity
     *            the quantity
     */
    public void updateCartArticle(HttpSession session, CartArticle article, Integer quantity) {
        Cart cart = getCart(session);
        cart.updateArticle(article, quantity);

        session.setAttribute(Constants.CART.name(), cart);
    }

    /**
     * Delete cart article.
     *
     * @param session
     *            the session
     * @param article
     *            the article
     */
    public void deleteCartArticle(HttpSession session, CartArticle article) {
        Cart cart = getCart(session);
        cart.deleteArticle(article);

        session.setAttribute(Constants.CART.name(), cart);
    }

    /**
     * Clear cart.
     *
     * @param session
     *            the session
     */
    public void clearCart(HttpSession session) {
	    session.setAttribute(Constants.CART.name(), new Cart());
    }

}
