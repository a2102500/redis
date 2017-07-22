package com.ljm.service;

import com.ljm.model.Task10;

import java.util.List;

/**
 * Created by liujm on 2017/6/15.
 */
public interface taskservice {

    Task10 Login(String name, String password);

    List<Task10> getAllStudent();

    int addStudent(Task10 t10);

    void deleteStudentById(int id);

    void updateStudentById(Task10 t10);

//    task10 getStudentById(int id);

    List<Task10> selectAllUser();

    Task10 select(long id);

    int insert(String name,String password);

    Task10 selectToUsername(String username);





}
