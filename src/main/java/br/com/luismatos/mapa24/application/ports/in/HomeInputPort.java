package br.com.luismatos.mapa24.application.ports.in;

import java.util.List;

import br.com.luismatos.mapa24.interfaces.dto.RegistroDTO;

public interface HomeInputPort {
	
	public List<RegistroDTO> buscarTodosRegistros();

}
