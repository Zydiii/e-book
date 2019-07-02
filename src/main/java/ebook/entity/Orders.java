package ebook.entity;

import java.util.Date;

public class Orders {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.id
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.money
     *
     * @mbg.generated
     */
    private Float money;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.receiverAddress
     *
     * @mbg.generated
     */
    private String receiveraddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.receiverName
     *
     * @mbg.generated
     */
    private String receivername;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.receiverPhone
     *
     * @mbg.generated
     */
    private String receiverphone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.state
     *
     * @mbg.generated
     */
    private Integer state;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.odertime
     *
     * @mbg.generated
     */
    private Date odertime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.donetime
     *
     * @mbg.generated
     */
    private Date donetime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.see
     *
     * @mbg.generated
     */
    private Integer see;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.id
     *
     * @return the value of orders.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.id
     *
     * @param id the value for orders.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.money
     *
     * @return the value of orders.money
     *
     * @mbg.generated
     */
    public Float getMoney() {
        return money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.money
     *
     * @param money the value for orders.money
     *
     * @mbg.generated
     */
    public void setMoney(Float money) {
        this.money = money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.receiverAddress
     *
     * @return the value of orders.receiverAddress
     *
     * @mbg.generated
     */
    public String getReceiveraddress() {
        return receiveraddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.receiverAddress
     *
     * @param receiveraddress the value for orders.receiverAddress
     *
     * @mbg.generated
     */
    public void setReceiveraddress(String receiveraddress) {
        this.receiveraddress = receiveraddress == null ? null : receiveraddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.receiverName
     *
     * @return the value of orders.receiverName
     *
     * @mbg.generated
     */
    public String getReceivername() {
        return receivername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.receiverName
     *
     * @param receivername the value for orders.receiverName
     *
     * @mbg.generated
     */
    public void setReceivername(String receivername) {
        this.receivername = receivername == null ? null : receivername.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.receiverPhone
     *
     * @return the value of orders.receiverPhone
     *
     * @mbg.generated
     */
    public String getReceiverphone() {
        return receiverphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.receiverPhone
     *
     * @param receiverphone the value for orders.receiverPhone
     *
     * @mbg.generated
     */
    public void setReceiverphone(String receiverphone) {
        this.receiverphone = receiverphone == null ? null : receiverphone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.state
     *
     * @return the value of orders.state
     *
     * @mbg.generated
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.state
     *
     * @param state the value for orders.state
     *
     * @mbg.generated
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.odertime
     *
     * @return the value of orders.odertime
     *
     * @mbg.generated
     */
    public Date getOdertime() {
        return odertime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.odertime
     *
     * @param odertime the value for orders.odertime
     *
     * @mbg.generated
     */
    public void setOdertime(Date odertime) {
        this.odertime = odertime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.donetime
     *
     * @return the value of orders.donetime
     *
     * @mbg.generated
     */
    public Date getDonetime() {
        return donetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.donetime
     *
     * @param donetime the value for orders.donetime
     *
     * @mbg.generated
     */
    public void setDonetime(Date donetime) {
        this.donetime = donetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.user_id
     *
     * @return the value of orders.user_id
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.user_id
     *
     * @param userId the value for orders.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.see
     *
     * @return the value of orders.see
     *
     * @mbg.generated
     */
    public Integer getSee() {
        return see;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.see
     *
     * @param see the value for orders.see
     *
     * @mbg.generated
     */
    public void setSee(Integer see) {
        this.see = see;
    }
}