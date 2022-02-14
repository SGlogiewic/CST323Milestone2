package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.gcu.business.UserSecurityService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserSecurityService userSecurity;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/login/", "/register/").permitAll()
		.and().httpBasic().and().formLogin()
			.loginPage("/login/")
				.usernameParameter("username")
				.passwordParameter("password")
				.permitAll()
		.defaultSuccessUrl("/").and()
			.logout()
				.logoutUrl("/logout")
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.permitAll()
				.logoutSuccessUrl("/");
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		FakeEncoder enc = new FakeEncoder();
		auth.userDetailsService(userSecurity).passwordEncoder(enc);
	}
}
