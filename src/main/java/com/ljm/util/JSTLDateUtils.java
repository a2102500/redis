package com.ljm.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Administrator on 2017/4/30.
 * 用于页面jstl时间格式化
 *
 */
public class JSTLDateUtils extends TagSupport {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public int doStartTag() throws JspException {
        String vv = String.valueOf(value);
        long time = Long.valueOf(vv);
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String s = dateFormat.format(c.getTime());
        try {
            pageContext.getOut().write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }

    public static void main(String[] args) {
        long a = 646416839;
        long time = Long.valueOf(a);
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String s = dateFormat.format(c.getTime());
        System.out.println(s);
    }
}
