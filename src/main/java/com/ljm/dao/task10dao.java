package com.ljm.dao;

import com.ljm.model.Task10;

import javafx.concurrent.Task;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by liujm on 2017/6/15.
 */
@Component
@Repository
public interface task10dao {
    //登陆方法
    public Task10 Login(@Param("stu_name")String stu_name, @Param("stu_pwd")String stu_pwd);
    //通过ID查找学生信息
//    public Student selectStudentById(@Param("id")int id);
    //查看所有学生信息
    public List<Task10> selectAllStudent();
    //添加学生
    public int addStudent(Task10 stu);
    //通过id删除学生
    public void  deleteStudentById(@Param("id")int id);
    //修改学生信息
    public void updateStudentById(@Param("Student")Task10 stu);
    
    Task10 getStudentById(@Param("id")int id);

//task6+
    public List<Task10> selectAllUser();

    List<Long> getUserIdList();

    public Task10 select(long id);

    public Task10 selectToUsername(String username);

    public int insert(@Param("name")String name,@Param("password") String password);



}
