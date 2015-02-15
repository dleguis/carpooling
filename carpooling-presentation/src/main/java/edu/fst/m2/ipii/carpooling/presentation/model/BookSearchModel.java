package edu.fst.m2.ipii.carpooling.presentation.model;

/**
 * Created by Dimitri on 14/01/2015.
 */
public class BookSearchModel {

    /**
     * The title.
     */
    private String title;

    /** The author id. */
    private Integer authorId;

    /** The editor. */
    private String editor;

    /** The book id. */
    private String bookId;

    /** The max price. */
    private Float maxPrice;

    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
	return title;
    }

    /**
     * Sets the title.
     *
     * @param title the new title
     */
    public void setTitle(String title) {
	this.title = title;
    }

    /**
     * Gets the author id.
     *
     * @return the author id
     */
    public Integer getAuthorId() {
	if (authorId != null && authorId.equals(0)) {
	    return null;
	}
	return authorId;
    }

    /**
     * Sets the author id.
     *
     * @param authorId the new author id
     */
    public void setAuthorId(Integer authorId) {
	this.authorId = authorId;
    }

    /**
     * Gets the editor.
     *
     * @return the editor
     */
    public String getEditor() {
	return editor;
    }

    /**
     * Sets the editor.
     *
     * @param editor the new editor
     */
    public void setEditor(String editor) {
	this.editor = editor;
    }

    /**
     * Gets the book id.
     *
     * @return the book id
     */
    public String getBookId() {
	return bookId;
    }

    /**
     * Sets the book id.
     *
     * @param bookId the new book id
     */
    public void setBookId(String bookId) {
	this.bookId = bookId;
    }

    /**
     * Gets the max price.
     *
     * @return the max price
     */
    public Float getMaxPrice() {
	return maxPrice;
    }

    /**
     * Sets the max price.
     *
     * @param maxPrice the new max price
     */
    public void setMaxPrice(Float maxPrice) {
	this.maxPrice = maxPrice;
    }
}
