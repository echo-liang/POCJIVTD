package pssg.poc.justin.pocjivtd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * The Class PocjivtdApplication.
 * @author HLiang
 */
@ComponentScan(basePackages={"pssg.poc.justin.pocjivtd"})
@EnableJpaRepositories(basePackages="pssg.poc.justin.pocjivtd.dataaccess.repository")
@EnableTransactionManagement
@EntityScan(basePackages="pssg.poc.justin.pocjivtd.dataaccess.entity")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class PocjivtdApplication extends SpringBootServletInitializer {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(PocjivtdApplication.class, args);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.boot.web.servlet.support.SpringBootServletInitializer#configure(org.springframework.boot.builder.SpringApplicationBuilder)
	 */
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PocjivtdApplication.class);
    }
}
