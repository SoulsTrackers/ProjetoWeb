package br.com.julian.projetolocadora.dto;

import java.util.List;

import br.com.julian.projetolocadora.modelo.Midia;

public class TipoMidiaDTO extends BaseDTO {

	private Integer id;
	private String descricao;
	private List<Midia> midias;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Midia> getMidias() {
		return midias;
	}
	public void setMidias(List<Midia> midias) {
		this.midias = midias;
	}
}
