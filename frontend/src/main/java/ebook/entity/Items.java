package ebook.entity;

public class Items extends ItemsKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column items.num
     *
     * @mbg.generated
     */
    private Integer num;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column items.see
     *
     * @mbg.generated
     */
    private Integer see;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column items.num
     *
     * @return the value of items.num
     *
     * @mbg.generated
     */
    public Integer getNum() {
        return num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column items.num
     *
     * @param num the value for items.num
     *
     * @mbg.generated
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column items.see
     *
     * @return the value of items.see
     *
     * @mbg.generated
     */
    public Integer getSee() {
        return see;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column items.see
     *
     * @param see the value for items.see
     *
     * @mbg.generated
     */
    public void setSee(Integer see) {
        this.see = see;
    }
}