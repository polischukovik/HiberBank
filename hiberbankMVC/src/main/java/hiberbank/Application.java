package hiberbank;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "hiberbank" })
public class Application {
	private static ConfigurableApplicationContext context;
	
    public static void main(String[] args) {
        context = SpringApplication.run(Application.class, args);
    }
    
    public static ConfigurableApplicationContext getAppCtx(){
    	return context;
    }
    
    public static void exit(){
    	SpringApplication.exit(Application.getAppCtx(), new ExitCodeGenerator() {

		    @Override
		    public int getExitCode() {
		      return 0;
		    }
		  });
    }
}
