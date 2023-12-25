package br.com.luismatos.mapa24.infrastructure.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.luismatos.mapa24.application.core.domain.Registro;
import br.com.luismatos.mapa24.application.ports.out.RegistroOutputPort;
import br.com.luismatos.mapa24.infrastructure.adapters.repository.RegistroRepository;
import br.com.luismatos.mapa24.infrastructure.adapters.repository.entity.RegistroEntity;
import br.com.luismatos.mapa24.shared.logger.log.Logger;

@Component
public class RegistroAdapter implements RegistroOutputPort {

	@Autowired
	private Logger log;
	
	@Autowired
	private RegistroRepository registroRepository;

	@Override
	public Registro inserir(Registro registro) {
		log.info("Cadastrando novo Registro de pressão!");
		RegistroEntity registroEntity = new RegistroEntity().toRegistroEntity(registro);
		return registro.toRegistro(registroRepository.save(registroEntity));
	}

}
