package com.ljm.controller;


import com.ljm.model.Task10;
import com.ljm.service.taskservice;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liujm on 2017/6/15.
 */
@Controller
@RequestMapping("/task10")
public class task10controller {

    Logger log= Logger.getLogger(task10controller.class);
    @Resource
    private taskservice tservice;


//    //注册页面：输入学生名字和密码，点击注册，成功跳转到登陆页面
//    @RequestMapping(value="/zuce", method = RequestMethod.GET)
//    public String Regist(){
//        log.info("------>正在登录");
//        return "regist";
//    }
//    @RequestMapping(value ="/registfrom",method = RequestMethod.POST)
//    public String Regist(@ModelAttribute("t10")task10 t10){
//        log.info("----->"+t10);
//        long createTime = System.currentTimeMillis();
//        t10.setCreate(createTime);
//        taskservice.addStudent(t10);
//        return "login";
//    }
//
//    //登陆页面：账户密码输入错误会刷新登陆页面重新输入，成功会进入列表
//    @RequestMapping(value = "/login",method =RequestMethod.GET)
//    public String Login(){
//        log.info("输入登陆用户名和密码");
//        return "login";
//    }
//    @RequestMapping(value = "/loginto",method=RequestMethod.POST)
//    public String Login(@ModelAttribute("stu")task10 t10){
//        log.info("输入成功"+t10.toString());
//        if(taskservice.Login(t10.getName(),t10.getPassword())!=null){
//            return "list";
//        }else{
//            return "login";
//        }
//    }



    //显示所有学生列表
//    @RequestMapping(value="/list",method =RequestMethod.GET)
//    public String showtask10(Model model){
//        log.info("查询所有");
//        List<task10> task10List=taskservice.getAllStudent();
//        log.info("获取到数据"+task10List);
//        model.addAttribute("List",task10List);
//        log.info("成功");
//        return "list";
//    }


    @RequestMapping(value="/list",method =RequestMethod.GET)
    public String showtask10(Model model){
        log.info("查询所有");
       List<Task10> userList=tservice.selectAllUser();
        System.out.println("获取数据-------------------------------->"+userList);

        model.addAttribute("userList",userList);
        return "list";

   }

//    @RequestMapping(value="/list",method =RequestMethod.GET)
//    public String showtask10(Model model){
//        log.info("查询所有");
//        task10 stuID=taskservice.getStudentById(1);
//        System.out.println("获取数据-------------------------------->"+stuID);
//
//        model.addAttribute("List",stuID);
//        return "list";
//
//    }



//@RequestMapping(value="/list",method =RequestMethod.GET)
//public String showStudent(Model model){
//    log.info("查询所有用户信息");
//    List<task10> userList = taskservice.getAllStudent();
//    model.addAttribute("userList",userList);
//    return "list";
//}


    @RequestMapping(value="/add",method=RequestMethod.GET)
    public String addStudent(){
        log.info("添加学生信息");
        //返回add.jsp页面
        return"add";
    }
    @RequestMapping(value="/addStu",method = RequestMethod.POST)
    public String addStudentPost(@ModelAttribute("stu")Task10 stu){
        System.out.println("------>"+stu.getName());
        log.info("显示学生信息"+stu);
        long createTime=System.currentTimeMillis();
        stu.setCreate(createTime);
        tservice.addStudent(stu);
        return "update";
    }

    //删除学生
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String deleteStudentByID(@PathVariable("id")int id){
        log.info("删除用户");
        try{
            tservice.deleteStudentById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "list";//同上
        //未彻底完成
    }
}
