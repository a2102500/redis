package com.ljm.service;

import com.ljm.model.User;

/**
 * Created by liujm on 2017/6/23.
 */
public interface userservice {

    public User select(long id);

    public boolean verification(String username,String password);

    public int insert(String username,String password);

    public User selectToUsername(String username);
}
