package com.tms.bpp;

import com.tms.annotation.MessageProcessing;
import com.tms.model.Message;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

@Component
public class MessageProcessingAnnotationBeanPostBrocessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        MessageProcessing annotation = bean.getClass().getAnnotation(MessageProcessing.class);

        if(annotation != null) {
            Field[] fields = bean.getClass().getDeclaredFields();
            for(Field field : fields) {
                if(field.getName().equalsIgnoreCase("message")) {
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, bean, new Message("Hello from BPP!!!"));
                }
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
