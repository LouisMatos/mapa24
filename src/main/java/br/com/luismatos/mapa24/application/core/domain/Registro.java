package br.com.luismatos.mapa24.application.core.domain;

import java.util.Date;

import br.com.luismatos.mapa24.infrastructure.adapters.repository.entity.RegistroEntity;
import br.com.luismatos.mapa24.interfaces.dto.RegistroDTO;
import br.com.luismatos.mapa24.shared.utils.ConversaoDatas;

public class Registro {

	private Long id;

	private Double sis;

	private Double dia;

	private String observacao;

	private Date dataRegistro;

	public Registro() {

	}

	public Registro(Long id, Double sis, Double dia, String observacao, Date dataRegistro) {
		this.id = id;
		this.sis = sis;
		this.dia = dia;
		this.observacao = observacao;
		this.dataRegistro = dataRegistro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSis() {
		return sis;
	}

	public void setSis(Double sis) {
		this.sis = sis;
	}

	public Double getDia() {
		return dia;
	}

	public void setDia(Double dia) {
		this.dia = dia;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	@Override
	public String toString() {
		return "Registro [id=" + id + ", sis=" + sis + ", dia=" + dia + ", observacao=" + observacao + ", dataRegistro="
				+ dataRegistro + "]";
	}

	public Registro toRegistro(RegistroDTO registroDTO) {
		this.id = registroDTO.getId();
		this.sis = registroDTO.getSis();
		this.dia = registroDTO.getDia();
		this.observacao = registroDTO.getObservacao();
		this.dataRegistro = ConversaoDatas.convertendoData(registroDTO.getDataRegistro()); 
		return this;
	}

	public Registro toRegistro(RegistroEntity registroEntity) {
		this.id = registroEntity.getId();
		this.sis = registroEntity.getSis();
		this.dia = registroEntity.getDia();
		this.observacao = registroEntity.getObservacao();
		this.dataRegistro = registroEntity.getDataRegistro();
		return this;
	}

}
