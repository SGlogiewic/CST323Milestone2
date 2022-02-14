package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import com.gcu.business.UserAccountService;
import com.gcu.business.UserAccountServiceInterface;

@Configuration
public class SpringConfig {

	@Bean(name="accountsService", initMethod="init", destroyMethod="destroy")
	@RequestScope
	public UserAccountServiceInterface accountsService() {
		return new UserAccountService();
	}
}
