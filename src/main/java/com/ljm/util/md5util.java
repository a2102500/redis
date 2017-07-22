package com.ljm.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by liujm on 2017/6/24.
 */
public class md5util {
    public static String stringToMD5(String string){
        //设定一个算法名md,先假设为空
        MessageDigest md=null;
        try{
            //添加一个名为MD5的算法
            md=MessageDigest.getInstance("MD5");
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        //计算md5函数
        md.update(string.getBytes());
        //digest()最后确定返回md5 hash值，返回值为8位zifuc，
        // 因为md5 hash值是16位的hex值，实际上就是8位的字符
        //BigInteger函数则将8位的字符串转换成16位的hex值，用字符串来表示：得到字符串形式的hash值
        return new BigInteger(1,md.digest()).toString(16);

    }
}
