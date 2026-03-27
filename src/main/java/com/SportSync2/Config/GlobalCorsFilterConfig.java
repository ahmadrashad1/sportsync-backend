package com.SportSync2.Config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class GlobalCorsFilterConfig {

    @Bean
    public FilterRegistrationBean<GlobalCorsFilter> globalCorsFilterRegistration() {
        FilterRegistrationBean<GlobalCorsFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new GlobalCorsFilter());
        bean.addUrlPatterns("/*");
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
