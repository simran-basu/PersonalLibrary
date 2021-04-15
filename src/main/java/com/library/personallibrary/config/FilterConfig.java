package com.library.personallibrary.config;

import com.library.personallibrary.filter.NewFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<NewFilter> registrationBean(){
        FilterRegistrationBean<NewFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new NewFilter());
        registrationBean.addUrlPatterns("/users/*");
        return registrationBean;
    }
}
