package hiberbank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan({ "hiberbank.controler" })
public class SpringWebConfig extends WebMvcConfigurerAdapter {
	

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
	
//    @Bean(name="htmlViewResolver")
//    public UrlBasedViewResolver setupViewResolver() {
//        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
//        resolver.setPrefix("/WEB-INF/views/html/");
//        resolver.setSuffix(".html");
//        resolver.setViewClass(JstlView.class);
//        resolver.setOrder(0);
//        return resolver;
//    }
	
    @Bean(name="jspViewResolver")
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/jsp/");
        bean.setSuffix(".jsp");
        return bean;
    }
    
//    @Bean(name="htmlViewResolver")
//    public InternalResourceViewResolver htmlViewResolver() {
//        InternalResourceViewResolver bean = new InternalResourceViewResolver();
//        bean.setPrefix("/WEB-INF/views/html/");
//        bean.setSuffix(".html");
//        return bean;
//    }
	
	
 
}