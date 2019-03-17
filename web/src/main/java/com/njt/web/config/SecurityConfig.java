package com.njt.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//	auth.jdbcAuthentication().dataSource(securityDataSource)
//		.usersByUsernameQuery("select username,password, enabled from users where username=?")
//		.authoritiesByUsernameQuery("select username, authority from authorities where username=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//	http.cors().and().authorizeRequests().antMatchers(HttpMethod.GET, "/api/courses").hasRole("STUDENT")
//		.antMatchers(HttpMethod.GET, "/api/courses/**").hasRole("STUDENT")
//		.antMatchers(HttpMethod.POST, "/api/courses").hasRole("ADMIN")
//		.antMatchers(HttpMethod.POST, "/api/courses/**").hasRole("ADMIN")
//		.antMatchers(HttpMethod.PUT, "/api/courses").hasRole("ADMIN")
//		.antMatchers(HttpMethod.PUT, "/api/courses/**").hasRole("ADMIN")
//		.antMatchers(HttpMethod.DELETE, "/api/courses/**").hasRole("ADMIN")
//		.antMatchers(HttpMethod.GET, "/api/lecturers").hasRole("STUDENT")
//		.antMatchers(HttpMethod.GET, "/api/lecturers/**").hasRole("STUDENT")
//		.antMatchers(HttpMethod.POST, "/api/lecturers").hasRole("ADMIN")
//		.antMatchers(HttpMethod.POST, "/api/lecturers/**").hasRole("ADMIN")
//		.antMatchers(HttpMethod.PUT, "/api/lecturers").hasRole("ADMIN")
//		.antMatchers(HttpMethod.PUT, "/api/lecturers/**").hasRole("ADMIN")
//		.antMatchers(HttpMethod.DELETE, "/api/lecturers/**").hasRole("ADMIN").and().httpBasic().and().csrf()
//		.disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	http.csrf().disable();
    }

//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//	return source;
//    }

}
