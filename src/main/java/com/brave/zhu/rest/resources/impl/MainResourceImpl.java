package com.brave.zhu.rest.resources.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.brave.zhu.rest.resources.MainResource;

public class MainResourceImpl implements MainResource
{
    private static final Logger log = LoggerFactory.getLogger(MainResourceImpl.class);
    
    /** {@inheritDoc} */
    
    @Override
    public Map<String, ?> doPost(String taskId)
    {
        log.debug("Main resource received a post msg: [taskId={}]", taskId);
        return createResult(taskId);
    }
    
    /** {@inheritDoc} */
    
    @Override
    public Map<String, ?> doGet(String taskId)
    {
        log.debug("Main resource received a get msg: [taskId={}]", taskId);
        return createResult(taskId);
    }
    
    protected Map<String, ?> createResult(String taskId)
    {
        StringBuilder stringBuilder = new StringBuilder();
        StackTraceElement[] stes = new Throwable().getStackTrace();
        for (StackTraceElement ste : stes)
        {
            stringBuilder.append("at ")
                    .append(ste.getClassName())
                    .append('.')
                    .append(ste.getMethodName())
                    .append(" (line:")
                    .append(ste.getLineNumber())
                    .append(")")
                    .append('\n');
        }
        log.debug("[StackTrace]\n" + stringBuilder.toString());
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("taskId", taskId);
        result.put("result", "success");
        return result;
    }
}
