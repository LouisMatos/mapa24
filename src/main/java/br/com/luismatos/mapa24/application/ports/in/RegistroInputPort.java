package br.com.luismatos.mapa24.application.ports.in;

import br.com.luismatos.mapa24.interfaces.dto.RegistroDTO;

public interface RegistroInputPort {

	public RegistroDTO salvaNovoRegistro(RegistroDTO registroDTO);

}
