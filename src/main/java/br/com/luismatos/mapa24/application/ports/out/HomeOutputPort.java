package br.com.luismatos.mapa24.application.ports.out;

import java.util.List;

import br.com.luismatos.mapa24.application.core.domain.Registro;

public interface HomeOutputPort {

	public List<Registro> buscarTodosRegistros();
}
