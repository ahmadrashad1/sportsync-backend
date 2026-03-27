package com.SportSync2.Config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class CorsPreflightFilterConfig {

    @Bean
    public FilterRegistrationBean<CorsPreflightFilter> corsPreflightFilterRegistration() {
        FilterRegistrationBean<CorsPreflightFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new CorsPreflightFilter());
        bean.addUrlPatterns("/*");
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
