package pssg.poc.justin.pocjivtd.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.core.Ordered;


/**
 * The Class PocjivtdConfiguration.
 * @author HLiang
 */
@Configuration
@ConditionalOnClass(DataSource.class)
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
@PropertySource("classpath:application.properties")
public class PocjivtdConfiguration {
	
	/** The env. */
	@Autowired
    private Environment env;
	
	/*
	@Bean(name = "dataSource")
    //@ConditionalOnProperty(name = "usemysql", havingValue = "custom")
    @ConditionalOnMissingBean
    public DataSource dataSource2() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(env.getProperty("mysql.url"));
        dataSource.setUsername(env.getProperty("mysql.user") != null ? env.getProperty("mysql.user") : "");
        dataSource.setPassword(env.getProperty("mysql.pass") != null ? env.getProperty("mysql.pass") : "");

        return dataSource;
    }*/

	/**
	 * Data source.
	 *
	 * @return the jndi object factory bean
	 */
	@Bean(name = "dataSource")
    public JndiObjectFactoryBean dataSource() {
        JndiObjectFactoryBean dataSource = new JndiObjectFactoryBean();
        dataSource.setJndiName("java:jboss/datasources/" + env.getProperty("MYSQL_DATABASE"));
        dataSource.setProxyInterface(DataSource.class);
        dataSource.setLookupOnStartup(true);

        return dataSource;
    }
	
    /**
     * Entity manager factory.
     *
     * @return the local container entity manager factory bean
     */
    @Bean
    @ConditionalOnBean(name = "dataSource")
    @ConditionalOnMissingBean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource((DataSource) dataSource().getObject());
        em.setPackagesToScan("pssg.poc.justin.pocjivtd");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    /**
     * Transaction manager.
     *
     * @param entityManagerFactory the entity manager factory
     * @return the jpa transaction manager
     */
    @Bean
    @ConditionalOnMissingBean(type = "JpaTransactionManager")
    JpaTransactionManager transactionManager(final EntityManagerFactory entityManagerFactory) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
