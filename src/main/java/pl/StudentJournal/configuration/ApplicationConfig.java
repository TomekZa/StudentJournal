package pl.StudentJournal.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
@Import(DataBaseConfig.class)
@ComponentScan(basePackages = "pl.StudentJournal.configuration")
public class ApplicationConfig {

    @Bean
    public PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertySourcesPlaceholderConfigurer.setLocations(new ClassPathResource("database.properties"));

        return propertySourcesPlaceholderConfigurer;
    }
}
