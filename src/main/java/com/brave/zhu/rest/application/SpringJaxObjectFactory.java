package com.brave.zhu.rest.application;

import org.restlet.ext.jaxrs.InstantiateException;
import org.restlet.ext.jaxrs.ObjectFactory;

public class SpringJaxObjectFactory implements ObjectFactory
{
    /** The jax bean collection. */
    private JaxBeanCollection jaxBeanCollection;
    
    /**
     * Instantiates a new spring jax object factory.
     *
     * @param jaxBeanCollection the jax bean collection
     */
    public SpringJaxObjectFactory(final JaxBeanCollection jaxBeanCollection)
    {
        this.jaxBeanCollection = jaxBeanCollection;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public <T> T getInstance(Class<T> clazz) throws InstantiateException
    {
        return jaxBeanCollection.getBean(clazz);
    }
}
