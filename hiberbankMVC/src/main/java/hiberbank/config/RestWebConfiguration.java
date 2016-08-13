package hiberbank.config;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

public class RestWebConfiguration extends RepositoryRestMvcConfiguration {
	@Override protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		  config.setPageParamName("p")
		        .setLimitParamName("l")
		        .setSortParamName("q");
		}
}
