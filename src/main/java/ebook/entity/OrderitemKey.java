package ebook.entity;

public class OrderitemKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orderitem.order_id
     *
     * @mbg.generated
     */
    private String orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orderitem.book_id
     *
     * @mbg.generated
     */
    private Integer bookId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orderitem.order_id
     *
     * @return the value of orderitem.order_id
     *
     * @mbg.generated
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orderitem.order_id
     *
     * @param orderId the value for orderitem.order_id
     *
     * @mbg.generated
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orderitem.book_id
     *
     * @return the value of orderitem.book_id
     *
     * @mbg.generated
     */
    public Integer getBookId() {
        return bookId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orderitem.book_id
     *
     * @param bookId the value for orderitem.book_id
     *
     * @mbg.generated
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}