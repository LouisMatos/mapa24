package br.com.luismatos.mapa24.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.luismatos.mapa24.application.core.domain.Registro;
import br.com.luismatos.mapa24.shared.utils.ConversaoDatas;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegistroDTO {

	@JsonProperty("id")
	private Long id;

	@NotNull
	@JsonProperty("SIS")
	private Double sis;

	@NotNull
	@JsonProperty("DIA")
	private Double dia;
	
	@NotEmpty
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
