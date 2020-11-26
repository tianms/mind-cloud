package com.mind.manage.controller;

import com.mind.common.constatns.ColumnConstant;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Auther: tianms
 * @Date: 2020/11/26 14:13
 * @Description: Controller公共组件
 */
public abstract class AbstractController {

    /**
     * 请求信息
     */
    protected HttpServletRequest request;

    /**
     * 相应信息
     */
    protected HttpServletResponse response;

	/**
	 * session信息
	 */
	protected HttpSession session;

    // 设置请求信息
    @ModelAttribute
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    // 设置响应信息
    @ModelAttribute
    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

	// 设置session信息
	@ModelAttribute
    public void setSession (HttpSession session) {
    	this.session = session;
	}

	// 获取session中的id
	protected String getSession_Id () {
    	return session.getId();
	}

    // 获取请求头中的token
    protected String getToken() {
        return request.getHeader(ColumnConstant.TOKEN);
    }

    // 获取请求头中的authKey
    protected String getAuthKey() {
        return request.getHeader(ColumnConstant.AUTH_KEY);
    }

    // 获取请求头中的sessionId
    protected String getSessionId() {
        return request.getHeader(ColumnConstant.SESSION_ID);
    }

}
