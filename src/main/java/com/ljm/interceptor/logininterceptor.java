package com.ljm.interceptor;
import com.ljm.service.userservice;
import com.ljm.util.TypeUtil;
import com.ljm.util.des;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**k
 * Created by Administrator on 2017/5/2.
 */
//登陆认证的拦截器
public class logininterceptor implements HandlerInterceptor {

    Logger log = Logger.getLogger(logininterceptor.class);
    @Autowired
    private userservice userService;

    //preHandle此方法是进行处理器拦截用的,顾名思义,该方法将在controller处理之前调用
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        Cookie[] cookie = httpServletRequest.getCookies();
        if (cookie != null) {
            for (int i = 0; i < cookie.length; i++) {
                if (cookie[i].getName().equals("token")) {
                    String token = cookie[i].getValue();
                    byte[] tk = TypeUtil.hexStringToByte(token);
//                    byte[] tk = token.getBytes();

                    byte[] tk1 = des.decrypt(tk,"12345678");
                    System.out.println("sfsdfsdfsdfsdf----------:"+tk1.toString());
                    String tk2 = new String(tk1);
                    log.info("======"+tk1);

                    String id = "";
                    String time = "";
                    for (int j = 0; j < tk2.length(); j++) {
                        char c = tk2.charAt(j);
                        if (c == '=') {
                            for (int k = j + 1; k < tk2.length(); k++)
                                time = time + tk2.charAt(k);
                            break;
                        }
                        id = id + c;
                    }
                    if (userService.select(Long.parseLong(id)) != null) {

                        return true;
                    }
                }
            }
        }
        httpServletRequest.getSession();
        String contextpath = httpServletRequest.getScheme() + "://" + httpServletRequest.getServerName() + ":" + httpServletRequest.getServerPort() + httpServletRequest.getContextPath();
        String uri = contextpath + "/login";
        httpServletResponse.sendRedirect(uri);
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
