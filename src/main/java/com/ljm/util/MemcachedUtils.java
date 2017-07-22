package com.ljm.util;

import com.whalin.MemCached.MemCachedClient;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Date;

/**
 * Created by Tom on 2017/5/6.
 */
@Component
@Repository
public class MemcachedUtils {
    private static final Logger log = Logger.getLogger(MemcachedUtils.class);
    private static MemCachedClient cachedClient;
    static {
        if(cachedClient == null)
            //括号中的名称要和配置文件spring-memcached中的配置名称保持一致,否则会出现缓存初始化失败的情况
        cachedClient = new MemCachedClient();
    }
    private MemcachedUtils(){}

    /**
     * 向缓存添加新的键值对，如果已经存在，则之前的值将被替换
     * @param key
     * @param value
     * @return
     */
    public static boolean set(String key,Object value){
        log.info("------->set方法+1");
        return setExp(key,value,null);
    }

    /**
     * 向缓存添加新的键值对，如果键已存在，则之前的值将被替换
     * @param key 键
     * @param value 值
     * @param expire 过期时间 new Date（1000*10）：十秒后过期
     * @return
     */
    public static boolean set(String key,Object value,Date expire){
        log.info("------->set方法+2");
        return setExp(key,value,expire);
    }

    /**
     * 向缓存添加新的键值对，如果键已经存在，则之前的值将被替换
     * @param key 键
     * @param value 值
     * @param expire 过期时间 new Date(1000*10):十秒后过期
     * @return
     */
    private static boolean setExp(String key,Object value,Date expire){
        boolean flag = false;
        try {
            flag = cachedClient.set(key,value,expire);
        }catch (Exception e){
            //记录Memcached日志
            MemcachedLog.writeLog("Mencached set 方法报错，key值："+key+"\r\n"+exceptionWrite(e));
        }
        return flag;
    }

    /**
     * 仅当缓存中不存在键时，add 命令才会向缓存中添加一个键值对
     * @param key 键
     * @param value 值
     * @return
     */
    public static boolean add(String key,Object value){
        return addExp(key,value,null);
    }

    /**
     * 仅当缓存中不存在键时，add命令才会向缓存中添加一个键值对
     * @param key 键
     * @param value 值
     * @param expire 过期时间 new Date（1000*10）：十秒过期
     * @return
     */
    public static boolean add(String key,Object value,Date expire){
        return addExp(key,value,expire);
    }

    /**
     * 仅当缓存中不存在键时，add命令才会向缓存中添加一个键值对
     * @param key 键
     * @param value 值
     * @param expire 过期时间 new Date（1000*10）：十秒过期
     * @return
     */
    private  static boolean addExp(String key,Object value,Date expire){
        boolean flag = false;
        try{
            flag = cachedClient.add(key, value, expire);
        }catch (Exception e){
            //记录Memcached 日志
            MemcachedLog.writeLog("Memcached add方法报错，key值："+key+"\r\n"+exceptionWrite(e));
        }
        return flag;
    }

    /**
     * 仅当键已存在时，replace命令才会替换缓存中的键
     * @param key 键
     * @param value 值
     * @return
     */
    public static boolean replace(String key,Object value){
        return replaceExp(key,value,null);
    }

    /**
     * 仅当键已经存在时，replace命令才会替换缓存中的键
     * @param key 键
     * @param value 值
     * @param expire 过期时间 new Date（1000*10）：十秒后过期
     * @return
     */
    public static boolean replace(String key,Object value, Date expire){
        return replaceExp(key,value,expire);
    }

    /**
     * 仅当键已经存在时，replace命令才会替换缓存中的键
     * @param key 键
     * @param value 值
     * @param expire 过期时间 new Date（1000*10）：十秒后过期
     * @return
     */
    private static boolean replaceExp(String key,Object value,Date expire){
        boolean flag = false;
        try {
            flag = cachedClient.replace(key,value,expire);
        }catch (Exception e){
            MemcachedLog.writeLog("Memcached replace方法报错，key值：" + key + "\r\n" + exceptionWrite(e));
        }
        return flag;
    }

    /**
     * get 命令用于检索与之前添加的键值对相关的值
     * @param key 键
     * @return
     */
    public static Object get(String key){
        Object obj = null;
        try {
            obj=cachedClient.get(key);
        }catch (Exception e){
            MemcachedLog.writeLog("Memcached get方法报错，key值：" + key + "\r\n" + exceptionWrite(e));
        }
        return obj;
    }

    /**
     *  删除 memcached中的任何现有值
     * @param key 键
     * @return
     */
    public static boolean delete(String key){
        return deleteExp(key,null);
    }

    /**
     * 删除memcached中的任何现有值
     * @param key 键
     * @param expire 过期时间 new Date(1000*10): 十秒后过期
     * @return
     */
    public  static boolean delete(String key,Date expire){
        return deleteExp(key,expire);
    }

    /**
     * 删除memcached中任何现有值，
     * @param key 键
     * @param expire 过期时间 new Date（1000*10）：十秒后过期
     * @return
     */
    private static boolean deleteExp(String key,Date expire){
        boolean flag= false;
        try {
            flag=cachedClient.delete(key,expire);
        }catch (Exception e){
            MemcachedLog.writeLog("Memcached delete方法报错，key值：" + key + "\r\n" + exceptionWrite(e));
        }
        return flag;
    }

    /**
     * 清理缓存中的所有键值对
     * @return
     */
    public static boolean flashAll(){
        boolean flag=false;
        try {
            flag=cachedClient.flushAll();
        }catch (Exception e){
            MemcachedLog.writeLog("Memcached flashAll方法报错\r\n" + exceptionWrite(e));
        }
        return flag;
    }

    /**
     * 返回异常栈信息，String类型
     * @param e
     * @return
     */
    private static String exceptionWrite(Exception e){
        StringWriter sw=new StringWriter();
        PrintWriter pw=new PrintWriter(sw);
        e.printStackTrace(pw);
        pw.flush();
        return sw.toString();
    }
    private static class MemcachedLog{
        private final static String MEMCACHED_LOG="D:\\memcache\\memcached.log";
        private final static String LINUX_MEMCACHED_LOG="/var/log/memcached/memcached.log";
        private static FileWriter fileWriter;
        private static BufferedWriter logWrite;
        //获取PID，可以找到对应的jvm进程
        private final static RuntimeMXBean runtime= ManagementFactory.getRuntimeMXBean();
        private final static String PID=runtime.getName();
        /**
         * 初始化写入流
         */
        static {
            try {
                String osName = System.getProperty("os.name");
                if(osName.indexOf("Window")==-1){
                    fileWriter=new FileWriter(MEMCACHED_LOG,true);
                }else {
                    fileWriter=new FileWriter(LINUX_MEMCACHED_LOG,true);
                }
                logWrite=new BufferedWriter(fileWriter);
            }catch (IOException e){
                log.error("memcached 日志初始化失败",e);
                clossLogStream();
            }
        }
        /**
         * 写入日志信息
         * @param content 日志内容
         */
        public static void writeLog(String content){
            try {
                logWrite.write("[" + PID + "] " + "- [" + (new Date().getTime()) + "]\r\n"
                        + content);
                logWrite.newLine();
                logWrite.flush();
            }catch (IOException e){
                log.error("memcached 写入日志信息失败",e);
            }
        }
        /**
         * 关闭流
         */
        private static void clossLogStream(){
            try {
                fileWriter.close();
                logWrite.close();
            }catch (IOException e){
                log.error("memcached 日志对象关闭失败",e);
            }
        }
    }
}
