package br.com.luismatos.mapa24.shared.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {


	 @SuppressWarnings("deprecation")
	@Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 http
			.authorizeRequests()
			.requestMatchers("/home/**")
				.permitAll()
				.requestMatchers("/registro/**")
				.permitAll()
			.anyRequest().
				authenticated()
			.and()
			.formLogin(form -> form
	            .loginPage("/login")
	            .defaultSuccessUrl("/usuario/pedido", true)
	            .permitAll()
	        )
			.logout(logout -> {
				logout.logoutUrl("/logout")
					.logoutSuccessUrl("/home");
			})
			.csrf().disable();
	        return http.build();
	    }

	
	

}