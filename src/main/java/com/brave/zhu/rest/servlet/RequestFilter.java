/*
 * 文 件 名:  RequestFilter.java
 * 版    权:  zhuzhiyong Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZZY
 * 修改时间:  2015年2月13日
 * 修改内容:  <修改内容>
 */
package com.brave.zhu.rest.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZZY
 * @version  [版本号, 2015年2月13日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class RequestFilter implements Filter
{
    private static final Logger log = LoggerFactory.getLogger(RequestFilter.class);
    
    /** {@inheritDoc} */
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
    }
    
    /** {@inheritDoc} */
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException
    {
        MultiReadHttpServletRequest mutliRequest = new MultiReadHttpServletRequest((HttpServletRequest)request);
        log.debug("Server received a msg:[{}]", IOUtils.toString(mutliRequest.getInputStream()));
        chain.doFilter(mutliRequest, response);
    }
    
    /** {@inheritDoc} */
    
    @Override
    public void destroy()
    {
    }
    
}
