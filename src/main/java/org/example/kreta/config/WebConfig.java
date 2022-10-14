package org.example.kreta.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
   /* @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
     //   registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/**");
     //   registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/**");
     //   registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry re) {

      //  re.addViewController("/").setViewName("index.html");
     //   re.addViewController("/welcome").setViewName("welcome.html");
     //   re.addViewController("/tmp").setViewName("check.html");
    }*/
}
