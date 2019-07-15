package com.glodon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Bean
    MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }
    public void addInterceptors(InterceptorRegistry registry){
        List exclude = new ArrayList();//不拦截的列表
        exclude.add("/icon/**");
        exclude.add("/templates/**");
        exclude.add("/static/**");
        registry.addInterceptor(myInterceptor())
                .addPathPatterns("/**").excludePathPatterns(exclude);
    }

    /**
     * springmvc视图解析
     * @Title: viewResolver
     * @return
     */
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("classpath:/tempaltes/");
        viewResolver.setSuffix(".html");
        // viewResolver.setViewClass(JstlView.class); // 这个属性通常并不需要手动配置，高版本的Spring会自动检测
        return viewResolver;
    }

    /**
     * SpringBoot设置首页
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        WebMvcConfigurer.super.addViewControllers(registry);
        registry.addViewController("/").setViewName("uploaddata");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

}