package ebook.dao;

import ebook.entity.Orderitem;
import ebook.entity.OrderitemExample;
import ebook.entity.OrderitemKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderitemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderitem
     *
     * @mbg.generated
     */
    long countByExample(OrderitemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderitem
     *
     * @mbg.generated
     */
    int deleteByExample(OrderitemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderitem
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(OrderitemKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderitem
     *
     * @mbg.generated
     */
    int insert(Orderitem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderitem
     *
     * @mbg.generated
     */
    int insertSelective(Orderitem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderitem
     *
     * @mbg.generated
     */
    List<Orderitem> selectByExample(OrderitemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderitem
     *
     * @mbg.generated
     */
    Orderitem selectByPrimaryKey(OrderitemKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderitem
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Orderitem record, @Param("example") OrderitemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderitem
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Orderitem record, @Param("example") OrderitemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderitem
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Orderitem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderitem
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Orderitem record);
}