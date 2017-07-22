package com.ljm.util;

/**
 * Created by liujm on 2017/6/26.
 */
public class TypeUtil {
    /**
     * 把16进制字符串转换成字节数组
     *
     * @param hex
     * @return
     */
    public static byte[] hexStringToByte(String hex) {  //这是定义一个16进制的字符串
        int len = (hex.length() / 2);   //设置len来接住这个字符串的长度/2
        byte[] result = new byte[len];  //定义一个名为result的byte数组
        char[] achar = hex.toCharArray();   //要一个字节数组来接一个字符串的数据
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return result;
    }

    private static byte toByte(char c) {
        byte b = (byte) "0123456789ABCDEF".indexOf(c);  //在我看来是在找是否有c这个字符的位置,然后用byte b来接这个角标
        return b;
    }
    //没什么区别,就是hexStringToByte放在了前面
    /**
     * 把字节数组转换成16进制字符串
     *
     * @param bArray
     * @return
     */
    public static String bytesToHexString(byte[] bArray) {
        StringBuffer sb = new StringBuffer(bArray.length);//缓冲容器
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "BA23BF08BCFACFD123";

        //区别在此,原代码为System.out.println(bytesToHexString(hexStringToByte(str)));
        //调用的方法不同
        String out = TypeUtil.bytesToHexString(TypeUtil.hexStringToByte(str));
        System.out.println(out);
    }
}
