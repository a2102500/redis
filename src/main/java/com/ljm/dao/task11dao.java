package com.ljm.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by liujm on 2017/6/15.
 */
@Component
@Repository
public interface task11dao {

public List get11(String head);
}
