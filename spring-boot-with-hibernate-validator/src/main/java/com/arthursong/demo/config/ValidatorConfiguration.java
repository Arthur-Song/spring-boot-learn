package com.arthursong.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import java.util.*;

/**
 * Created by Administrator on 2018/7/18.
 */
@Configuration
public class ValidatorConfiguration {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:i18n/message");
        Properties properties = new Properties();
        properties.put("fileEncodings", "utf-8");
        messageSource.setFileEncodings(properties);
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(120);
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean(){
        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
        factory.setValidationMessageSource(messageSource());
        Map<String,String> map = new HashMap<>();
        map.put("hibernate.validator.fail_fast","true");
        factory.setValidationPropertyMap(map);
        return factory;
    }
}
