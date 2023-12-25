package br.com.luismatos.mapa24.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.luismatos.mapa24.application.core.usecase.HomeUseCase;
import br.com.luismatos.mapa24.infrastructure.adapters.HomeAdapter;
import br.com.luismatos.mapa24.shared.logger.log.Logger;

@Configuration
public class HomeConfig {

	@Bean
	public HomeUseCase homeUseCase(HomeAdapter homeAdapter, Logger log) {
		return new HomeUseCase(homeAdapter, log);
	}
}
