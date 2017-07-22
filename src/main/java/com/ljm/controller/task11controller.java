package com.ljm.controller;

import com.ljm.dao.task11dao;
import com.ljm.dao.task10dao;

import com.ljm.model.Task10;
import com.ljm.model.task11;
import com.ljm.service.userservice;
import com.ljm.util.TypeUtil;
import com.ljm.util.des;
import com.ljm.util.md5util;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by liujm on 2017/6/15.
 */
@Controller
@RequestMapping
public class task11controller {

    Logger log = Logger.getLogger(task11controller.class);

    @Resource
    private task11dao elevendao;

    @Resource
    private task10dao tendao;

    @Resource
    private userservice userservice;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String message(ModelMap modelMap,HttpServletRequest request) {
        List<Task10> list = tendao.selectAllStudent();
        log.info("-------"+list);
        modelMap.put("studentList", list);
        return "home";
    }

    @RequestMapping(value = "/u/courselist", method = RequestMethod.GET)
    public String getCourse(ModelMap modelMap,HttpServletRequest request) {

        List<task11> list1 = elevendao.get11("后端开发");
        log.info("----->"+list1);
        List<task11> list2 = elevendao.get11("前端开发");
        List<task11> list3 = elevendao.get11("运维");
        List<task11> list4 = elevendao.get11("android");
        List<task11> list5 = elevendao.get11("ios");

        List list=new ArrayList();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        list.add(list5);

        log.info("------->"+list);
        modelMap.put("lists",list);
        return "courselist";

    }

    //登陆页面
    @RequestMapping(value="login",method=RequestMethod.GET)
    public String login(){
        return "login";
    }
    //登陆失败页面
    @RequestMapping(value="no",method=RequestMethod.GET)
        public String no(){
            return "no";
        }

    //登陆处理
    @RequestMapping(value="login",method= RequestMethod.POST)
    public void loginaction(@RequestParam("username")String username, @RequestParam("password")String password,
                            HttpServletResponse httpServletResponse){
        String md5= md5util.stringToMD5(username+password);
        if(userservice.verification(username,md5)){
            //待加密内容
            log.info("------>");
//           long id=((User)userservice.selectToUsername(username)).getId();
            long id=userservice.selectToUsername(username).getId();
            long creatDate=new Date().getTime();
            String str=id+"="+creatDate;
            //加密操作
            byte[] result= des.encrype(str.getBytes(),"12345678");
            //把加密的字节转换为16进制
            String resules= TypeUtil.bytesToHexString(result);
//            String resules=result.toString();
            Cookie cookie=new Cookie("token",resules);
            cookie.setMaxAge(60*60*24*7);//保留7天
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.addCookie(cookie);
            try{
                //重定向
                httpServletResponse.sendRedirect("home");
            }catch(IOException e){
                e.printStackTrace();
            }
        }else{
            try{
                httpServletResponse.sendRedirect("no");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    //注册页面
    @RequestMapping(value="regist",method=RequestMethod.GET)
    public String regist(){
        return "regist";
    }

    @RequestMapping(value="registto",method=RequestMethod.POST)
    public String register(@RequestParam("username")String username,@RequestParam("password")String password){
        String md5=md5util.stringToMD5(username+password);
        userservice.insert(username,md5);
        log.info("---------->"+username+md5);
        return "ok";

    }

}






