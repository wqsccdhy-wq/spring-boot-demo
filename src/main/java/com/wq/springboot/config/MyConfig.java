package com.wq.springboot.config;

import com.wq.springboot.Interceptor.LoginHandlerInterceptor;
import com.wq.springboot.configuration.NativeLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author wq-z170
 * @since 2019/12/14 16:51
 * @Desc StringBoot2.X用WebMvcConfigurer类型的是类是拓展SptingMVC，该类标注为@Configuration
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Resource
    private LoginHandlerInterceptor loginHandlerInterceptor;

    @Resource
    private NativeLocaleResolver nativeLocaleResolver;

    /**
     * 视图映射
     * 
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

        registry.addViewController("/main.html").setViewName("dashboard");
    }

    /**
     * 拦截器
     * 
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(loginHandlerInterceptor);
        interceptorRegistration.addPathPatterns("/**");
        interceptorRegistration.excludePathPatterns("/", "/index.html", "/login.html", "/user/login");
        // 不拦截静态资源
        interceptorRegistration.excludePathPatterns("/asserts/**", "/webjars/**", "/static/**");

    }

    /**
     * @Desc 国际化
     * @return LocaleResolver
     */
    @Bean
    public LocaleResolver localeResolver() {

        return nativeLocaleResolver;
    }

}
