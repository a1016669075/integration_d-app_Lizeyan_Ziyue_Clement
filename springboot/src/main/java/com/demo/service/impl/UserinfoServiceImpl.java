package com.demo.service.impl;
import java.util.List;

import com.demo.common.Assist;
import com.demo.dao.UserinfoDao;
import com.demo.entity.Userinfo;
import com.demo.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserinfoServiceImpl implements UserinfoService{
    @Autowired
    private UserinfoDao userinfoDao;
    @Override
    public long getUserinfoRowCount(Assist assist){
        return userinfoDao.getUserinfoRowCount(assist);
    }
    @Override
    public List<Userinfo> selectUserinfo(Assist assist){
        return userinfoDao.selectUserinfo(assist);
    }
    @Override
    public Userinfo selectUserinfoByObj(Userinfo obj){
        return userinfoDao.selectUserinfoByObj(obj);
    }
    @Override
    public Userinfo selectUserinfoById(Integer id){
        return userinfoDao.selectUserinfoById(id);
    }
    @Override
    public int insertUserinfo(Userinfo value){
        return userinfoDao.insertUserinfo(value);
    }
    @Override
    public int insertNonEmptyUserinfo(Userinfo value){
        return userinfoDao.insertNonEmptyUserinfo(value);
    }
    @Override
    public int insertUserinfoByBatch(List<Userinfo> value){
        return userinfoDao.insertUserinfoByBatch(value);
    }
    @Override
    public int deleteUserinfoById(Integer id){
        return userinfoDao.deleteUserinfoById(id);
    }
    @Override
    public int deleteUserinfo(Assist assist){
        return userinfoDao.deleteUserinfo(assist);
    }
    @Override
    public int updateUserinfoById(Userinfo enti){
        return userinfoDao.updateUserinfoById(enti);
    }
    @Override
    public int updateUserinfo(Userinfo value, Assist assist){
        return userinfoDao.updateUserinfo(value,assist);
    }
    @Override
    public int updateNonEmptyUserinfoById(Userinfo enti){
        return userinfoDao.updateNonEmptyUserinfoById(enti);
    }
    @Override
    public int updateNonEmptyUserinfo(Userinfo value, Assist assist){
        return userinfoDao.updateNonEmptyUserinfo(value,assist);
    }

    public UserinfoDao getUserinfoDao() {
        return this.userinfoDao;
    }

    public void setUserinfoDao(UserinfoDao userinfoDao) {
        this.userinfoDao = userinfoDao;
    }

}