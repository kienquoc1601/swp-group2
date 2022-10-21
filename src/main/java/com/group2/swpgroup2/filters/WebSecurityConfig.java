package com.group2.swpgroup2.filters;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
					.antMatchers("/blog").hasRole("admin")
					.antMatchers("/chapterlist").hasRole("user")
					
					.antMatchers("/", "/home").permitAll()
					.antMatchers("/**/*.js", "/**/*.css").permitAll()
					.and().formLogin();

		
	}
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
			.withUser("foo")
			.password("foo")
			.roles("user")
			.and()
			.withUser("too")
			.password("too")
			.roles("admin");
	}
	@Bean
	public PasswordEncoder getPasswordEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}



	// @Autowired
	// DataSource dataSource;

	// @Bean
	// UserDetailsManager users(DataSource dataSource) {
	// 	auth.
	// 	return users;
	// }
    // @Bean
	// public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	// 	http
	// 		.authorizeHttpRequests((requests) -> requests
    //             .antMatchers("/**/*.js", "/**/*.css").permitAll()
	// 			.antMatchers("/", "/home").permitAll()
	// 			.anyRequest().authenticated()
                
	// 		)
	// 		.formLogin((form) -> form
	// 			.loginPage("/login")
	// 			.permitAll()
	// 		)
	// 		.logout((logout) -> logout.permitAll());

	// 	return http.build();
	// }

	// @Bean
	// public UserDetailsService userDetailsService() {
	// 	UserDetails user =
	// 		 User.withDefaultPasswordEncoder()
	// 			.username("user")
	// 			.password("password")
	// 			.roles("USER")
	// 			.build();

	// 	return new InMemoryUserDetailsManager(user);
	// }
}
