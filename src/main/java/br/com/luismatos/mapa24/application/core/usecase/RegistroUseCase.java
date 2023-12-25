package br.com.luismatos.mapa24.application.core.usecase;

import br.com.luismatos.mapa24.application.core.domain.Registro;
import br.com.luismatos.mapa24.application.ports.in.RegistroInputPort;
import br.com.luismatos.mapa24.application.ports.out.RegistroOutputPort;
import br.com.luismatos.mapa24.interfaces.dto.RegistroDTO;
import br.com.luismatos.mapa24.shared.logger.log.Logger;

public class RegistroUseCase implements RegistroInputPort {

	private final Logger log;

	private final RegistroOutputPort registroOutputPort;

	public RegistroUseCase(RegistroOutputPort registroOutputPort, Logger log) {
		this.registroOutputPort = registroOutputPort;
		this.log = log;
	}

	@Override
	public RegistroDTO salvaNovoRegistro(RegistroDTO registroDTO) {

		log.info("Convertendo para Dominio Registro");
		Registro registro = new Registro().toRegistro(registroDTO);

		RegistroDTO dto = new RegistroDTO().toRegistroDTO(registroOutputPort.inserir(registro));
		log.info("Registro: {} salvo com sucesso!", dto.toString());
		return dto;

	}

}
