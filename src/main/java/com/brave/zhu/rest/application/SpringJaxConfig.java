package com.brave.zhu.rest.application;

import java.util.Set;

import javax.ws.rs.core.Application;

public class SpringJaxConfig extends Application
{
    /** The jax bean collection. */
    private JaxBeanCollection jaxBeanCollection;
    
    /**
     * Instantiates a new spring jax config.
     *
     * @param jaxBeanCollection the jax bean collection
     */
    public SpringJaxConfig(final JaxBeanCollection jaxBeanCollection)
    {
        this.jaxBeanCollection = jaxBeanCollection;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public Set<Class<?>> getClasses()
    {
        return jaxBeanCollection.getBeanTypes();
    }
    
}
