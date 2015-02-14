/*
 * 文 件 名:  JaxBeanCollection.java
 * 版    权:  zhuzhiyong Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZZY
 * 修改时间:  2015年2月13日
 * 修改内容:  <修改内容>
 */
package com.brave.zhu.rest.application;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class JaxBeanCollection implements BeanFactoryAware
{
    /** The bean names. */
    private Set<Class<?>> beanNames;
    
    /** The bean factory. */
    private BeanFactory beanFactory;
    
    /**
     * Sets the bean names.
     *
     * @param beans the new bean names
     */
    public void setBeanNames(List<Object> beans)
    {
        beanNames = new HashSet<Class<?>>();
        for (Object bean : beans)
        {
            beanNames.add(bean.getClass());
        }
    }
    
    /**
     * Gets the bean.
     *
     * @param <T> the generic type
     * @param clazz the clazz
     * @return the bean
     */
    public <T> T getBean(Class<T> clazz)
    {
        return beanFactory.getBean(clazz);
    }
    
    /**
     * Gets the bean types.
     *
     * @return the bean types
     */
    public Set<Class<?>> getBeanTypes()
    {
        return beanNames;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException
    {
        this.beanFactory = beanFactory;
    }
    
}
