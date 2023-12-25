package br.com.luismatos.mapa24.infrastructure.adapters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.luismatos.mapa24.application.core.domain.Registro;
import br.com.luismatos.mapa24.application.ports.out.HomeOutputPort;
import br.com.luismatos.mapa24.infrastructure.adapters.repository.RegistroRepository;
import br.com.luismatos.mapa24.infrastructure.adapters.repository.entity.RegistroEntity;
import br.com.luismatos.mapa24.shared.logger.log.Logger;

@Component
public class HomeAdapter implements HomeOutputPort {

	@Autowired
	private Logger log;

	@Autowired
	private RegistroRepository registroRepository;

	@Override
	public List<Registro> buscarTodosRegistros() {
		log.info("Buscando todos os registro de pressão cadastrados na base de dados!");
		List<RegistroEntity> entities = registroRepository.findAll();
		return entities.stream().map(entity -> new Registro().toRegistro(entity)).toList();
	}

}
