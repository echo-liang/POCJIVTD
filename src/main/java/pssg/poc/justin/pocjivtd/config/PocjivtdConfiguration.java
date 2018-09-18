package pssg.poc.justin.pocjivtd.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


import org.springframework.core.Ordered;

@Configuration
@ConditionalOnClass(DataSource.class)
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
@ComponentScan
@PropertySource("classpath:application.properties")
public class PocjivtdConfiguration {
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

	@Bean(name = "dataSource")
    public JndiObjectFactoryBean dataSource() {
        JndiObjectFactoryBean dataSource = new JndiObjectFactoryBean();
        //dataSource.setJndiName("java:comp/env/jdbc/global_globaldb");
        dataSource.setJndiName("java:jboss/datasources/echodb1");
        dataSource.setProxyInterface(DataSource.class);
        dataSource.setLookupOnStartup(true);

        return dataSource;
    }
	
    @Bean
    @ConditionalOnBean(name = "dataSource")
    @ConditionalOnMissingBean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource((DataSource) dataSource().getObject());
        em.setPackagesToScan("pssg.poc.justin.pocjivtd");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        //if (additionalProperties() != null) {
        //    em.setJpaProperties(additionalProperties());
        //}
        return em;
    }

    @Bean
    @ConditionalOnMissingBean(type = "JpaTransactionManager")
    JpaTransactionManager transactionManager(final EntityManagerFactory entityManagerFactory) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
