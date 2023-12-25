package br.com.luismatos.mapa24.infrastructure.adapters.repository.entity;

import java.io.Serializable;
import java.util.Date;

import br.com.luismatos.mapa24.application.core.domain.Registro;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "registros")
public class RegistroEntity implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -5109060706531894659L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_registro")
	private Long id;

	private Double sis;

	private Double dia;

	private String observacao;

	private Date dataRegistro;

	public RegistroEntity toRegistroEntity(Registro registro) {
		this.id = registro.getId();
		this.sis = registro.getSis();
		this.dia = registro.getDia();
		this.observacao = registro.getObservacao();
		this.dataRegistro = registro.getDataRegistro();
		return this;
	}

}
