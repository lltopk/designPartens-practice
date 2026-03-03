package org.lyflexi.chainPattern.chainOfSpringCallBack;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * 请求上下文
 */
public class ProtocolsContext {
    private HttpRequest httpRequest;
    private HttpResponse httpResponse;
    private LoginUser  loginUser;

    public LoginUser getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(LoginUser loginUser) {
        this.loginUser = loginUser;
    }


    public HttpRequest getHttpRequest() {
        return httpRequest;
    }

    public void setHttpRequest(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
    }

    public HttpResponse getHttpResponse() {
        return httpResponse;
    }

    public void setHttpResponse(HttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }
}
