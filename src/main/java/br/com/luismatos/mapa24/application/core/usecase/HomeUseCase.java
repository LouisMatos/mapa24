package br.com.luismatos.mapa24.application.core.usecase;

import java.util.List;

import br.com.luismatos.mapa24.application.ports.in.HomeInputPort;
import br.com.luismatos.mapa24.application.ports.out.HomeOutputPort;
import br.com.luismatos.mapa24.interfaces.dto.RegistroDTO;
import br.com.luismatos.mapa24.shared.logger.log.Logger;

public class HomeUseCase implements HomeInputPort {

	private final Logger log;

	private final HomeOutputPort homeOutputPort;

	public HomeUseCase(HomeOutputPort homeOutputPort, Logger log) {
		this.homeOutputPort = homeOutputPort;
		this.log = log;
	}

	@Override
	public List<RegistroDTO> buscarTodosRegistros() {

		List<RegistroDTO> registroDTOs = homeOutputPort.buscarTodosRegistros().stream()
				.map(registro -> new RegistroDTO().toRegistroDTO(registro)).toList();

		log.info("Registros encontrados! {}", registroDTOs);

		return registroDTOs;
	}

}
