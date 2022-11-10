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
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
				.antMatchers("/blog").hasAnyRole("USER","MENTOR")
				.antMatchers("/modulelist/**").hasAnyRole("USER","MENTOR")
				.antMatchers("/chapterlist/**").hasAnyRole("USER","MENTOR")
				.antMatchers("/mentorprofile/**").hasAnyRole("USER","MENTOR")
				.antMatchers("/courses").hasAnyRole("USER","MENTOR")
				.antMatchers("/blogs").hasAnyRole("USER","MENTOR")
				.antMatchers("/course").hasAnyRole("USER","MENTOR")
				.antMatchers("/checkout").hasAnyRole("USER","MENTOR")
				.antMatchers("/addToCart/**").permitAll()
				.antMatchers("https://www.youtube.com/**").permitAll()
				.antMatchers("/", "/home").permitAll()
				.antMatchers("/**/*.js", "/**/*.css","/resources/**", "/static/**", "/css/**", "/js/**", "/images/**","/vendor/**","/fonts/**").permitAll()
				.and().formLogin(form -> form
						.loginPage("/login")
						.defaultSuccessUrl("/auth", true)
						.permitAll());
		http.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
		http.csrf().disable();
		
	}

	@Bean
	public UserDetailsService users() {
		UserDetails user = User.builder()
			.username("user")
			.password("123")
			.roles("USER")
			.build();
		UserDetails admin = User.builder()
			.username("admin")
			.password("123")
			.roles("USER", "ADMIN")
			.build();
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
		auth.inMemoryAuthentication();
		
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
