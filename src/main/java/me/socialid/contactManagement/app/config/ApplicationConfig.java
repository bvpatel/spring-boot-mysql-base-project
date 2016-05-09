package me.socialid.contactManagement.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import me.socialid.contactManagement.app.interceptor.RequestStatisticsInterceptor;
import me.socialid.contactManagement.audit.CurrentTimeDateTimeService;
import me.socialid.contactManagement.audit.DateTimeService;

@Configuration
@EnableConfigurationProperties
@EnableTransactionManagement
@ComponentScan(basePackages = "me.socialid.contactManagement")
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "me.socialid.contactManagement",repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
@EntityScan("me.socialid.contactManagement")
@EnableWebMvc
@EnableJpaAuditing
public class ApplicationConfig extends WebMvcConfigurerAdapter {

	@Bean
	DateTimeService currentTimeDateTimeService() {
		return new CurrentTimeDateTimeService();
	}

	@Autowired
	RequestStatisticsInterceptor requestStatisticsInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestStatisticsInterceptor);
		super.addInterceptors(registry);
	}

}