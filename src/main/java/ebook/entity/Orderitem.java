package ebook.entity;

public class Orderitem {
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
     * This field corresponds to the database column orderitem.good_id
     *
     * @mbg.generated
     */
    private String goodId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orderitem.buynum
     *
     * @mbg.generated
     */
    private Integer buynum;

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
     * This method returns the value of the database column orderitem.good_id
     *
     * @return the value of orderitem.good_id
     *
     * @mbg.generated
     */
    public String getGoodId() {
        return goodId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orderitem.good_id
     *
     * @param goodId the value for orderitem.good_id
     *
     * @mbg.generated
     */
    public void setGoodId(String goodId) {
        this.goodId = goodId == null ? null : goodId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orderitem.buynum
     *
     * @return the value of orderitem.buynum
     *
     * @mbg.generated
     */
    public Integer getBuynum() {
        return buynum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orderitem.buynum
     *
     * @param buynum the value for orderitem.buynum
     *
     * @mbg.generated
     */
    public void setBuynum(Integer buynum) {
        this.buynum = buynum;
    }
}