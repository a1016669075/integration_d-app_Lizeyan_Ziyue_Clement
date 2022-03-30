package com.demo.service;
import java.util.List;

import com.demo.common.Assist;
import com.demo.entity.Userinfo;

public interface UserinfoService{
	/**
	 * 获得Userinfo数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getUserinfoRowCount(Assist assist);
	/**
	 * 获得Userinfo数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<Userinfo> selectUserinfo(Assist assist);
	/**
	 * 获得一个Userinfo对象,以参数Userinfo对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    Userinfo selectUserinfoByObj(Userinfo obj);
	/**
	 * 通过Userinfo的id获得Userinfo对象
	 * @param id
	 * @return
	 */
    Userinfo selectUserinfoById(Integer id);
	/**
	 * 插入Userinfo到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertUserinfo(Userinfo value);
	/**
	 * 插入Userinfo中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyUserinfo(Userinfo value);
	/**
	 * 批量插入Userinfo到数据库
	 * @param value
	 * @return
	 */
    int insertUserinfoByBatch(List<Userinfo> value);
	/**
	 * 通过Userinfo的id删除Userinfo
	 * @param id
	 * @return
	 */
    int deleteUserinfoById(Integer id);
	/**
	 * 通过辅助工具Assist的条件删除Userinfo
	 * @param assist
	 * @return
	 */
    int deleteUserinfo(Assist assist);
	/**
	 * 通过Userinfo的id更新Userinfo中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateUserinfoById(Userinfo enti);
 	/**
	 * 通过辅助工具Assist的条件更新Userinfo中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateUserinfo(Userinfo value,  Assist assist);
	/**
	 * 通过Userinfo的id更新Userinfo中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyUserinfoById(Userinfo enti);
 	/**
	 * 通过辅助工具Assist的条件更新Userinfo中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyUserinfo(Userinfo value, Assist assist);
}