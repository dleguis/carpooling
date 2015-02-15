package edu.fst.m2.ipii.carpooling.transverse.builder;

/**
 * Created by Dimitri on 14/01/2015.
 */
public class BookCriteria {

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
     * Instantiates a new book criteria.
     *
     * @param bookCriteriaBuilder the book criteria builder
     */
    public BookCriteria(BookCriteriaBuilder bookCriteriaBuilder) {
		this.title = bookCriteriaBuilder.title;
		this.authorId = bookCriteriaBuilder.authorId;
		this.editor = bookCriteriaBuilder.editor;
		this.bookId = bookCriteriaBuilder.bookId;
		this.maxPrice = bookCriteriaBuilder.maxPrice;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
		return title;
    }

    /**
     * Gets the author id.
     *
     * @return the author id
     */
    public Integer getAuthorId() {
		return authorId;
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
     * Gets the book id.
     *
     * @return the book id
     */
    public String getBookId() {
		return bookId;
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
     * The Class BookCriteriaBuilder.
     */
    public static class BookCriteriaBuilder {

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
		 * Instantiates a new book criteria builder.
		 */
		public BookCriteriaBuilder() {

		}

		/**
		 * With title.
		 *
		 * @param titre the titre
		 * @return the book criteria builder
		 */
		public BookCriteriaBuilder withTitle(String titre) {
			this.title = titre;
			return this;
		}

		/**
		 * With author id.
		 *
		 * @param authorId the author id
		 * @return the book criteria builder
		 */
		public BookCriteriaBuilder withAuthorId(Integer authorId) {
			this.authorId = authorId;
			return this;
		}

		/**
		 * With editor.
		 *
		 * @param editor the editor
		 * @return the book criteria builder
		 */
		public BookCriteriaBuilder withEditor(String editor) {
			this.editor = editor;
			return this;
		}

		/**
		 * With book id.
		 *
		 * @param bookId the book id
		 * @return the book criteria builder
		 */
		public BookCriteriaBuilder withBookId(String bookId) {
			this.bookId = bookId;
			return this;
		}

		/**
		 * With max price.
		 *
		 * @param maxPrice the max price
		 * @return the book criteria builder
		 */
		public BookCriteriaBuilder withMaxPrice(Float maxPrice) {
			this.maxPrice = maxPrice;
			return this;
		}

		/**
		 * Builds the.
		*
		* @return the book criteria
		*/
		public BookCriteria build() {
			return new BookCriteria(this);
		}
    }
}
