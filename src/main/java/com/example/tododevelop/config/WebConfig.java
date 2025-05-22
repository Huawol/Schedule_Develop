package com.example.tododevelop.config;

import com.example.tododevelop.filter.LoginFilter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean loginFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LoginFilter()); // filter 등록
        filterRegistrationBean.setOrder(1); // filter 순서 1설정
        filterRegistrationBean.addUrlPatterns("/*"); // 전체 URL에 filter 적용

        return filterRegistrationBean;
    }

}
