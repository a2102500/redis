package com.ljm.service;

import com.ljm.dao.Userdao;

import com.ljm.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by liujm on 2017/6/23.
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class Userserviceimpl implements userservice{

    @Resource
    private Userdao myuserdao;

    public User select(long id) {
        return myuserdao.select(id);

    }
    public User selectToUsername(String username){
        return myuserdao.selectToUsername(username);
    }
    public boolean verification(String username,String psaaword){
        if(myuserdao.verification(username,psaaword)==null){
            return false;
        }
        return true;
    }

    public int insert(String username,String password){
        return myuserdao.insert(username,password);
    }
}
