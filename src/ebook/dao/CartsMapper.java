package ebook.dao;

import ebook.entity.Carts;
import ebook.entity.CartsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CartsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carts
     *
     * @mbg.generated
     */
    long countByExample(CartsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carts
     *
     * @mbg.generated
     */
    int deleteByExample(CartsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carts
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carts
     *
     * @mbg.generated
     */
    int insert(Carts record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carts
     *
     * @mbg.generated
     */
    int insertSelective(Carts record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carts
     *
     * @mbg.generated
     */
    List<Carts> selectByExample(CartsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carts
     *
     * @mbg.generated
     */
    Carts selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carts
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Carts record, @Param("example") CartsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carts
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Carts record, @Param("example") CartsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carts
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Carts record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carts
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Carts record);
}