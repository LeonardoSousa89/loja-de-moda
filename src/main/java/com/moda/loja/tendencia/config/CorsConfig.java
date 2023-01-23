package com.moda.loja.tendencia.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class CorsConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private Environment env;

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
			
			http.headers().frameOptions().disable();
			
		}
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().anyRequest().permitAll();
		
		http.cors()
			.configurationSource(corsConfigurationSource())
			.and()
			.csrf()
			.disable();
	}

	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		
		configuration.setAllowedOrigins(Arrays.asList("http://127.0.0.1:4200"));
		configuration.setAllowCredentials(true);
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE"));
		
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		
		source.registerCorsConfiguration("/**", configuration);
		
		return source;
	}
	
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter(){
		
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(corsConfigurationSource()));
		
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		
		return bean;
		
	}
	
}



