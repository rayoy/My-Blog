package com.my.blog.website.dao;

import com.my.blog.website.model.JordonMap;
import com.my.blog.website.model.JordonMapCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JordonMapMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jordon_map
     *
     * @mbggenerated
     */
    int countByExample(JordonMapCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jordon_map
     *
     * @mbggenerated
     */
    int deleteByExample(JordonMapCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jordon_map
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jordon_map
     *
     * @mbggenerated
     */
    int insert(JordonMap record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jordon_map
     *
     * @mbggenerated
     */
    int insertSelective(JordonMap record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jordon_map
     *
     * @mbggenerated
     */
    List<JordonMap> selectByExample(JordonMapCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jordon_map
     *
     * @mbggenerated
     */
    JordonMap selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jordon_map
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") JordonMap record, @Param("example") JordonMapCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jordon_map
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") JordonMap record, @Param("example") JordonMapCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jordon_map
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(JordonMap record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jordon_map
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(JordonMap record);
}