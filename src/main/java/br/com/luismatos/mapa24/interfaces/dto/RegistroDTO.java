package br.com.luismatos.mapa24.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.luismatos.mapa24.application.core.domain.Registro;
import br.com.luismatos.mapa24.shared.utils.ConversaoDatas;
import lombok.Data;

@Data
public class RegistroDTO {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("SIS")
	private Integer sis;

	@JsonProperty("DIA")
	private Integer dia;

	@JsonProperty("observacao")
	private String observacao;

	@JsonProperty("dataRegistro")
	private String dataRegistro;

	public RegistroDTO toRegistroDTO(Registro registro) {
		this.id = registro.getId();
		this.sis = registro.getSis();
		this.dia = registro.getDia();
		this.observacao = registro.getObservacao();
		this.dataRegistro = ConversaoDatas.convertendoDataString(registro.getDataRegistro());
		return this;
	}

}
