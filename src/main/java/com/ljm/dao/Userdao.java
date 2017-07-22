package com.ljm.dao;

import com.ljm.model.User;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

//import javax.xml.registry.infomodel.User;

/**
 * Created by liujm on 2017/6/23.
 */
@Repository
public interface Userdao {
    public User select(long id);

    public User selectToUsername(String username);

    public int insert(@Param("username") String username,@Param("password") String password);

    public User verification(@Param("username") String username,@Param("password") String password);



}
