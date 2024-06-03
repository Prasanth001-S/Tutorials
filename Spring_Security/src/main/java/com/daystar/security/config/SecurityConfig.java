package com.daystar.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain customSecurityFilterChain(HttpSecurity http) throws Exception{
		
		http.csrf().disable()  // spring will automatically will restrict all the controller method if they try to make any changes in database. if you want to allow you have to disaple csrf attack like this
		.authorizeHttpRequests()
		.requestMatchers("/hello","/greeting").authenticated()
		.requestMatchers("/register").permitAll();
		
		http.formLogin();
		http.httpBasic();
		return http.build();
	}
	
	/*
	 * @Bean public UserDetailsService userDetailsService(DataSource dataSource) {
	 * return new JdbcUserDetailsManager(dataSource);
	 * 
	 * }
	 */
	
	// this one is first approch for creating user in inmemroy 
	/*
	 * @Bean // this method will help to create Inmemory users in spring memory
	 * public InMemoryUserDetailsManager inMemoryFirstApproach() {
	 * 
	 * UserDetails userOne = User.withDefaultPasswordEncoder()
	 * .username("root").password("12345").authorities("admin").build();
	 * 
	 * return new InMemoryUserDetailsManager(userOne); // here we can pass as many
	 * we want like userOne, userTwo, userThree }
	 */
	
	
	//second approach for this approach you need to create bean for password encoder
	
	/*
	 * @Bean public InMemoryUserDetailsManager inMemorySecondApproach() {
	 * 
	 * UserDetails userThree =
	 * User.withUsername("user").password("54321").authorities("user").build();
	 * return new InMemoryUserDetailsManager(userThree); }
	 */
	
	/*
	 * @Bean public PasswordEncoder passwordEncoderConfiguration() { return
	 * NoOpPasswordEncoder.getInstance(); }
	 */
	
	@Bean
	public PasswordEncoder passwordEncoderConfiguration() {
		return new BCryptPasswordEncoder();
	}
	  
	 
}
