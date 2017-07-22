package com.ljm.service;

import com.ljm.dao.task10dao;
import com.ljm.model.Task10;
import com.ljm.util.MemcachedUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by liujm on 2017/6/15.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class taskserviceimpl implements taskservice{
    private Logger log= Logger.getLogger(taskserviceimpl.class);

    @Resource
    private task10dao stuDao;
    @Resource
    private MemcachedUtils memcachedUtils;



    public Task10 Login(String name, String password) {
        return  stuDao.Login(name,password);
    }

    @Override
    public List<Task10> getAllStudent() {
        return null;
    }

//    @Override
//    public List<task10> getAllStudent() {
//        return null;
//    }

//    @Override
//    public List<task10> getAllStudent() {
//        List<task10> task10List=null;
//        log.info("准备进入缓存");
//        if(MemcachedUtils.get("task10List")!=null){
//            //加了这个
//            task10List=(List<task10>) MemcachedUtils.get("task10List");
//            System.out.println("所请求数据是从缓存中取出");
//            return task10List;
//        }
//            task10List = stuDao.selectAllStudent();
//            MemcachedUtils.add("task10List", task10List);
//            System.out.println("所请求数据是从数据库中查询取出,已添加至缓存中");
//
//            return task10List;
//}

    public List<Task10> selectAllUser() {
        //获取所有学生ID合集
        List<Long> longList = stuDao.getUserIdList();
        List<Task10> userList = new ArrayList<Task10>();
        Task10 t10;
        for (Long id : longList) {
            if (MemcachedUtils.get("id" + id) != null) {
                t10  = (Task10) MemcachedUtils.get("t10"+id);
                System.out.println("这是从缓存中获取的");
            } else {
                t10 = stuDao.select(id);
                System.out.println("这是从数据库中获取的id---------->ID="+id);
                MemcachedUtils.set("t10"+id, t10,new Date(1000 * 2000));
                userList.add(t10);
            }
            log.info("判断完成");
        }



//        task10 now10;
//        if (MemcachedUtils.get("user_"+1) != null){
//            now10=(task10) MemcachedUtils.get("user_"+1);
//            log.info("这是从缓存中获取的");
//        }else {
//            now10 = stuDao.select(1);
//            log.info("这是从数据库中获取的");
//            MemcachedUtils.set("1", now10, new Date(1000 * 20));
//            userList.add(now10);
//        }
        return userList;
    }
    public Task10 select(long id) {
        Task10 task10 = new Task10();
        if (memcachedUtils.get("id" + id) != null) {
            task10 = (Task10) memcachedUtils.get("user_" + id);
            System.out.println("这是从缓存中获取的");
        } else {
            task10 = stuDao.select(id);
            memcachedUtils.set("id" + id, task10, new Date(1000 * 2000));
            System.out.println("从数据库中获取");
        }
        return task10;
    }

    @Override
    public int insert(String name, String password) {
        return stuDao.insert(name,password);
    }

    @Override
    public Task10 selectToUsername(String name) {
        return stuDao.selectToUsername(name);
    }

//    @Override
//    public task10 getStudentById(int id) {
//        log.info("准备进入缓存");
//        if (MemcachedUtils.get("id"+id) != null) {
//            task10 mytask10= (com.ljm.model.task10) MemcachedUtils.get("id");
//            System.out.println("所请求数据是从缓存中取出");
//            return mytask10;
//        }else {
//            task10 mytask10 = stuDao.getStudentById(id);
//            MemcachedUtils.add("id"+id, mytask10);
//            System.out.println("所请求数据是从数据库中取出,已添加至缓存中");
//            return mytask10;
//        }
//    }



    @Override
    public int addStudent(Task10 task10) {
        return stuDao.addStudent(task10);
    }

    @Override
    public void deleteStudentById(int id) {
        stuDao.deleteStudentById(id);
    }

    @Override
    public void updateStudentById(Task10 task10) {
        stuDao.updateStudentById(task10);
    }
}
