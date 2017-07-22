package com.ljm.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;
import java.util.Date;

/**
 * Created by liujm on 2017/6/24.
 */
public class des {
    //加密
    public static byte[] encrype(byte[] datasource,String password){
        try{
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            //创建一个秘钥工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekry = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            //用秘钥初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE,securekry,random);
            //现在，获取数据并加密
            //正在执行加密操作
            return cipher.doFinal(datasource);
        }catch(Throwable e){
            e.printStackTrace();
        }
        return null;
    }

    //解密
    public static byte[] decrypt(byte[] src,String password)throws Exception{
        //DES算法要求有一个可信任的随机数源
        SecureRandom random=new SecureRandom();
        //创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(password.getBytes());
        //创建一个密钥工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        //将DESKeySpec对象装换成SecretKey对象
        SecretKey secretKey = keyFactory.generateSecret(desKey);
        //Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");
        //用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, secretKey, random);
        // 真正开始解密操作
        return cipher.doFinal(src);
    }
    public static void main(String[] args){
        //待加密内容
        String str = "12"+"="+ new Date().getTime();
        //密码。长度要是8的倍数
        String password = "12346578";
        byte[] result = des.encrype(str.getBytes(),password);
        System.out.println("加密后："+new String(result));

        //直接将如上内容解密
        try{
            byte[] decryResult = des.decrypt(result,password);
            System.out.println("解密后："+new String(decryResult));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
