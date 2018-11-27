package pl.StudentJournal.configuration;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.transaction.TransactionManager;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "pl.StudentJournal.repository", entityManagerFactoryRef = "entityManagerFactoryBean")
public class DataBaseConfig {

    @Value("${jdbc.driverClass}")
    private String jdbcDriverClass;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.user}")
    private String jdbcUser;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Value("${hibernate.dialect}")
    private String hibernateDialect;
    @Value("${hibernate.hbm2ddl.auto}")
    private String hibernateHbm2ddlAuto;
    @Value("${hibernate.show_sql}")
    private String hibernateShowSql;
    @Value("${hibernate.format_sql}")
    private String hibernateFormatSql;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(jdbcDriverClass);
        driverManagerDataSource.setUrl(jdbcUrl);
        driverManagerDataSource.setUsername(jdbcUser);
        driverManagerDataSource.setPassword(jdbcPassword);

        return driverManagerDataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(dataSource());
        localContainerEntityManagerFactoryBean.setPackagesToScan("pl.StudentJournal.entity");
        localContainerEntityManagerFactoryBean.setJpaProperties(getJpaProperties());
        localContainerEntityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);

        return localContainerEntityManagerFactoryBean;
    }

    @Bean(name = "transactionManager")
    public JpaTransactionManager transaction() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());

        return jpaTransactionManager;
    }


    @Bean
    public Properties getJpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", hibernateDialect);
        properties.setProperty("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
        properties.setProperty("hibernate.show_sql", hibernateShowSql);
        properties.setProperty("hibernate.format_sql", hibernateFormatSql);

        return properties;
    }


}
