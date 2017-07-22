package com.ljm.service;

import com.ljm.dao.task11dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by liujm on 2017/6/29.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class professionserviceimpl implements professionservice{
    @Autowired
    private task11dao  task11dao;

    public List getProfessionWithDirection(String  direction){
        return task11dao.get11(direction);
    }

}
