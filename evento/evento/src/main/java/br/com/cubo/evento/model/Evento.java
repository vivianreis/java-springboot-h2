package br.com.cubo.evento.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Evento {

	@Id
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
