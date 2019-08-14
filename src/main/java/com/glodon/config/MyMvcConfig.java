package com.glodon.config;

import com.glodon.bean.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * 跨域
     *
     * @param registry
     */
    public void addCorsMappings(CorsRegistry registry) {
/*        registry.addMapping("/upload/**")//对/api/**进行跨域配置
                .allowedHeaders("**")//允许所有的非简单请求头
                .allowedMethods("GET", "OPTIONS", "POST") //允许三种方法
                .allowedOrigins("*");//允许来自所有域的请求*/
        registry.addMapping("/**")//对/api/**进行跨域配置
                .allowedHeaders("*")//允许所有的非简单请求头
                .allowedMethods("GET", "OPTIONS", "POST") //允许三种方法
                .allowedOrigins("*");//允许来自所有域的请求

    }

    /**
     * 设置拦截器
     *
     * @return
     */
    @Bean
    MyInterceptor myInterceptor() {
        return new MyInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry) {
        List exclude = new ArrayList();//不拦截的列表
        exclude.add("/js/**");
        exclude.add("/templates/**");
        exclude.add("/static/**");
        registry.addInterceptor(myInterceptor())
                .addPathPatterns("/**").excludePathPatterns(exclude);
    }

    /**
     * springmvc视图解析
     *
     * @return
     * @Title: viewResolver
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
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