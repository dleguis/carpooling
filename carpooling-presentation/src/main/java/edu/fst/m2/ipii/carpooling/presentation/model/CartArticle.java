package edu.fst.m2.ipii.carpooling.presentation.model;

/**
 * Created by Dimitri on 13/01/2015.
 */
public class CartArticle {

    /**
     * The book.
     */
    private BookDto book;

    /** The quantity. */
    private int quantity;

    /**
     * Instantiates a new cart article.
     */
    public CartArticle() {

    }

    /**
     * Instantiates a new cart article.
     *
     * @param book the book
     */
    public CartArticle(BookDto book) {
	this.book = book;
    }

    /**
     * Instantiates a new cart article.
     *
     * @param book     the book
     * @param quantity the quantity
     */
    public CartArticle(BookDto book, String quantity) {

        this.book = book;
        // On limite la quantité ajoutable entre 1 et 99
        Integer q;
        try {
            q = Integer.parseInt(quantity);
        } catch (NumberFormatException exception) {
            q = 1;
        }

        this.quantity = q > 0 && q < 100 ? q : 1;
    }

    /**
     * Gets the book.
     *
     * @return the book
     */
    public BookDto getBook() {
	    return book;
    }

    /**
     * Sets the book.
     *
     * @param book the new book
     */
    public void setBook(BookDto book) {
	    this.book = book;
    }

    /**
     * Gets the quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {
	    return quantity;
    }

    /**
     * Sets the quantity.
     *
     * @param quantity the new quantity
     */
    public void setQuantity(int quantity) {
	    this.quantity = quantity;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CartArticle)) {
            return false;
        }

        CartArticle that = (CartArticle) o;

        if (!book.equals(that.book)) {
            return false;
        }

        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	    return book.hashCode();
    }
}
