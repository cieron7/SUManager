package net.dqsy.manager.web.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;


public class BeanFactoryUtil implements ApplicationContextAware {
    private static ApplicationContext context;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    public static <T> T getBean(String beanName, Class<T> requiredType) {
        return context.getBean(beanName, requiredType);
    }

    public static <T> T getBean(Class<T> clazz) {
        Map<?, T> beanMap = context.getBeansOfType(clazz);
        if (beanMap == null || beanMap.size() == 0) {
            return null;
        }
        return beanMap.values().iterator().next();
    }
}
