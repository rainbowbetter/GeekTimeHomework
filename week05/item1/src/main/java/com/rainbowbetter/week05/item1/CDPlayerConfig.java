package com.rainbowbetter.week05.item1;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayerConfig {
    @Bean
    public CompactDisc compactDisc() {
        return new CompactDisc();
    }

    //引用创建bean的方法
    @Bean
    public CDPlayer cdPlayer() {
        return new CDPlayer(compactDisc());
    }

    //或者 cdPlayer()方法请求一个CompactDisc作为参数
    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }
}

