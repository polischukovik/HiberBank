package hiberbank.config;

import org.springframework.boot.SpringApplication;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringWebMvcSimpleInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

@Override
protected Class<?>[] getRootConfigClasses() {
  return new Class[] {SpringRootConfig.class};
}

@Override
protected Class<?>[] getServletConfigClasses() {
  return new Class[] {SpringWebConfig.class};
}

@Override
protected String[] getServletMappings() {
  return new String[]{"/"};
}



}


