package br.com.luismatos.mapa24.application.ports.out;

import br.com.luismatos.mapa24.application.core.domain.Registro;

public interface RegistroOutputPort {
	
	public Registro inserir(Registro registro);

}
