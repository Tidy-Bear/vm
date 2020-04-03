package com.ishang.vm.config;

import com.ishang.vm.interceptor.LoginInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.*;

@SpringBootConfiguration
public class MyWebConfigurer implements WebMvcConfigurer {

//    @Bean
//    public LoginInterceptor getLoginIntercepter() {
//        return new LoginInterceptor();
//    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry){
//        registry.addInterceptor(getLoginIntercepter())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/index.html")
//                .excludePathPatterns("/api/login")
//                .excludePathPatterns("/api/logout");
//    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //所有请求都允许跨域，使用这种配置方法就不能在 interceptor 中再配置 header 了
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins("http://localhost:8080")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowedHeaders("*")
                .maxAge(3600);
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        本机测试使用
//        registry.addResourceHandler("/api/file/**").addResourceLocations("file:" + "E:/Java/SpringBoot/HW/tempimg/");
        registry.addResourceHandler("/api/file/**").addResourceLocations("file:" + "C:/vm/img/");
    }


}

