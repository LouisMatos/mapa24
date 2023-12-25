package br.com.luismatos.mapa24.application.core.usecase;

import java.util.List;

import br.com.luismatos.mapa24.application.ports.in.HomeInputPort;
import br.com.luismatos.mapa24.application.ports.out.HomeOutputPort;
import br.com.luismatos.mapa24.interfaces.dto.RegistroChartDTO;
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

	@Override
	public RegistroChartDTO buscarDadosChart() {
		
		List<RegistroDTO> registroDTOs = homeOutputPort.buscarTodosRegistros().stream()
				.map(registro -> new RegistroDTO().toRegistroDTO(registro)).toList();
		
		RegistroChartDTO registroChartDTO = new RegistroChartDTO();
		
		registroChartDTO.setListaSIS(montaListaString(registroDTOs.stream().map(registro -> registro.getSis()).toList()));
		registroChartDTO.setListaDIA(montaListaString(registroDTOs.stream().map(registro -> registro.getDia()).toList()));
		registroChartDTO.setHorario(montaListaString2(registroDTOs.stream().map(registro -> registro.getDataRegistro()).toList()));
		
		log.info("Registros charts SIS! {}", registroChartDTO.getListaSIS());
		log.info("Registros charts DIA! {}", registroChartDTO.getListaDIA());
		log.info("Registros charts Horario! {}", registroChartDTO.getHorario());
		
		return registroChartDTO;
	}

	private String montaListaString(List<Integer> list) {
		String temp = "[";
		for (int i = 0; i < list.size(); i++) {
			temp = temp + list.get(i) +",";
		}
		temp = temp + "]";
		temp = temp.replaceAll(",]", "]");
		return temp;
	}
	
	private String montaListaString2(List<String> list) {
		String temp = "[";
		for (int i = 0; i < list.size(); i++) {
			temp = temp + list.get(i)+",";
		}
		temp = temp + "]";
		temp = temp.replaceAll(",]", "]");
//		temp = temp.replaceAll("25/12/2023 ", "");
		return temp;
	}
	

	


}
