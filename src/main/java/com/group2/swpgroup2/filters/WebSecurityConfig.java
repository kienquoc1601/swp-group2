package com.group2.swpgroup2.filters;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()

				//.antMatchers("/").permitAll().antMatchers("/login").permitAll()
				.antMatchers("/blog").hasRole("ADMIN")
				.antMatchers("/modulelist/**").hasRole("USER")
				.antMatchers("/chapterlist/**").hasRole("USER")
				.antMatchers("/mentorprofile/**").hasRole("USER")
				.antMatchers("/courses").hasRole("USER")
				.antMatchers("/blogs").hasRole("USER")
				.antMatchers("/course").hasRole("USER")
				.antMatchers("/checkout").hasRole("USER")
				.antMatchers("/addToCart/**").permitAll()
				.antMatchers("/", "/home").permitAll()
				.antMatchers("/**/*.js", "/**/*.css").permitAll()
				.and().formLogin(form -> form
						.loginPage("/login")
						.defaultSuccessUrl("/auth", true)
						.permitAll());
		http.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
		http.csrf().disable();
	}


	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	// @Autowired
	// DataSource dataSource;

	// @Bean
	// UserDetailsManager users(DataSource dataSource) {
	// auth.
	// return users;
	// }
	// @Bean
	// public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
	// Exception {
	// http
	// .authorizeHttpRequests((requests) -> requests
	// .antMatchers("/**/*.js", "/**/*.css").permitAll()
	// .antMatchers("/", "/home").permitAll()
	// .anyRequest().authenticated()

	// )
	// .formLogin((form) -> form
	// .loginPage("/login")
	// .permitAll()
	// )
	// .logout((logout) -> logout.permitAll());

	// return http.build();
	// }

	// @Bean
	// public UserDetailsService userDetailsService() {
	// UserDetails user =
	// User.withDefaultPasswordEncoder()
	// .username("user")
	// .password("password")
	// .roles("USER")
	// .build();

	// return new InMemoryUserDetailsManager(user);
	// }
}
