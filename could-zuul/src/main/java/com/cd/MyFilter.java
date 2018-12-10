package com.cd;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(MyFilter.class);

    @Override//路由之前
    public String filterType() {
        return "pre";
    }

    @Override//路由过滤顺序
    public int filterOrder() {
        return 0;
    }

    @Override//这里可以写逻辑判断，是否要过滤，本文true,永远过滤
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑，可用很复杂，包括查sql,nosql去判断该请求到底有没有权限访问
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run()  {
        RequestContext ctx = RequestContext.getCurrentContext();//通过requestContext域获取对象
        HttpServletRequest request = ctx.getRequest();//用对象获取request
        //通过loggerFactory中的方法来获取请求路径的方法，地址
        log.info(String.format("%s >>> %s",request.getMethod(),request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken==null){//判断accessToken是否等于空
            log.warn("token is empty");//如果等于空，提示这是空的
            ctx.setSendZuulResponse(false);//设置响应发送为false
            ctx.setResponseStatusCode(401);//设置响应的状态码
            try{
                //如果出现错误也提示token is empty
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){
                return null;
            }
        }
        //不等于空就放行
        log.info("ok");
        return null;
    }
}
