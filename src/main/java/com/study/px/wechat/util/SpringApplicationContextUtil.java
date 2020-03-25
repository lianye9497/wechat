package com.study.px.wechat.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-05-23 19:47
 **/
@Component
public class SpringApplicationContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public SpringApplicationContextUtil() {
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static <T> T getBean(String key, Class<T> cls) {
        return applicationContext.getBean(key, cls);
    }

    public static <T> T getBean(Class<T> cls) {
        return applicationContext.getBean(cls);
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}

