package edu.fst.m2.ipii.carpooling.presentation.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dimitri on 13/01/15.
 */
public class Cart {

    /**
     * The articles.
     */
    private Set<CartArticle> articles;

    /**
     * Gets the articles.
     *
     * @return the articles
     */
    public Set<CartArticle> getArticles() {
	if (null == articles) {
	    articles = new HashSet<CartArticle>();
	}
	return articles;
    }

    /**
     * Gets the article.
     *
     * @param cartArticle the cart article
     * @return the article
     */
    public CartArticle getArticle(CartArticle cartArticle) {
	for (CartArticle ca : getArticles()) {
	    if (ca.equals(cartArticle)) {
		return ca;
	    }
	}

	return null;
    }

    /**
     * Adds the article.
     *
     * @param cartArticle the cart article
     * @return the cart article
     */
    public CartArticle addArticle(CartArticle cartArticle) {

	CartArticle newArticle = getArticle(cartArticle);

	if (newArticle == null) {
	    newArticle = cartArticle;
	    getArticles().add(newArticle);
	} else {
	    newArticle.setQuantity(newArticle.getQuantity() + cartArticle.getQuantity());
	}

	return newArticle;
    }

    /**
     * Update article.
     *
     * @param cartArticle the cart article
     * @param quantity the quantity
     * @return the cart article
     */
    public CartArticle updateArticle(CartArticle cartArticle, Integer quantity) {

	CartArticle newArticle = getArticle(cartArticle);
	if (newArticle != null) {
	    newArticle.setQuantity(quantity);
	}

	return newArticle;
    }

    /**
     * Delete article.
     *
     * @param cartArticle the cart article
     * @return the cart article
     */
    public CartArticle deleteArticle(CartArticle cartArticle) {

	getArticles().remove(cartArticle);

	return cartArticle;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Cart{" + "articles=" + articles + '}';
    }
}
