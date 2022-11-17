package pl.systemyinformatyczne.zakladfryzjerski;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServlet;

@Configuration
public class WebConfig {
    @Bean
    public ServletRegistrationBean<HttpServlet> DatabaseAccess() {
        ServletRegistrationBean<HttpServlet> servRegBean = new ServletRegistrationBean<>();
        servRegBean.setServlet(new DatabaseAccess());
        servRegBean.addUrlMappings("/DatabaseAccess");
        servRegBean.setLoadOnStartup(1);
        return servRegBean;
    }
    @Bean
    public ServletRegistrationBean<HttpServlet> ViewClient() {
        ServletRegistrationBean<HttpServlet> servRegBean = new ServletRegistrationBean<>();
        servRegBean.setServlet(new ViewClient());
        servRegBean.addUrlMappings("/ViewClient");
        servRegBean.setLoadOnStartup(1);
        return servRegBean;
    }}