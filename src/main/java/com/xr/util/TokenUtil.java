package com.xr.util;

import javax.servlet.http.HttpServletRequest;


public class TokenUtil {
	/**
	 * 判断客户端提交上来的令牌和服务器端生成的令牌是否一致
	 * @param req
	 * @return
	 * true 用户重复提交了表单 
	 * false 用户没有重复提交表单 
	 */
    public static boolean isRepeatSubmit(HttpServletRequest req){
    	String client_token = req.getParameter("token");
        //1、如果用户提交的表单数据中没有token，则用户是重复提交了表单
        if(client_token==null){
            return true;
        }
        //取出存储在Session中的token
        String server_token = (String) req.getSession().getAttribute("token");
        //2、如果当前用户的Session中不存在Token(令牌)，则用户是重复提交了表单
        if(server_token==null){
            return true;
        }
        //3、存储在Session中的Token(令牌)与表单提交的Token(令牌)不同，则用户是重复提交了表单
        if(!client_token.equals(server_token)){
            return true;
        }
        return false;
    }
}
