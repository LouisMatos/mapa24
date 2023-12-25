package br.com.luismatos.mapa24.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.luismatos.mapa24.application.core.usecase.RegistroUseCase;
import br.com.luismatos.mapa24.infrastructure.adapters.RegistroAdapter;
import br.com.luismatos.mapa24.shared.logger.log.Logger;

@Configuration
public class RegistroConfig {

	@Bean
	public RegistroUseCase registroUseCase(RegistroAdapter registroAdapter, Logger log) {
		return new RegistroUseCase(registroAdapter, log);
	}
}
