package com.wq.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.wq.springboot.configuration.NativeLocaleResolver;

/**
 * @author wq-z170
 * @since 2019/12/14 16:51
 * @Desc StringBoot2.X用WebMvcConfigurer类型的是类是拓展SptingMVC，该类标注为@Configuration
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {

    /**
     * 视图映射
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/ok").setViewName("thymeleaf/ok");
        /**
         * 访问当前项目路径和index.html页面时，跳转到登录页面
         */
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
    }

    /**
     *
     * @return LocaleResolver
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new NativeLocaleResolver();
    }


}
