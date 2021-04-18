package com.rainbowbetter.week05.item05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass({School.class})
public class SchoolAutoConfiguration {

    // 注入属性类
    @Autowired
    private School school;

    @Bean
    // 当容器没有这个 Bean 的时候才创建这个 Bean
    @ConditionalOnMissingBean(School.class)
    public School SchoolService() {
        School helloworldService = new School();
        helloworldService.ding();
        return helloworldService;
    }
}

