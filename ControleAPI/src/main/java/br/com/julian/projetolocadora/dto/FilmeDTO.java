package br.com.julian.projetolocadora.dto;

import java.util.Calendar;

public class FilmeDTO extends BaseDTO{
	private Integer id;
	private String descricao;
	private Calendar ano;
	private String resumo;
	private Integer classificacao;
	private Calendar duracao;
	private CategoriaDTO categoriaDTO;
	
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
	public Calendar getAno() {
		return ano;
	}
	public void setAno(Calendar ano) {
		this.ano = ano;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public Integer getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(Integer classificacao) {
		this.classificacao = classificacao;
	}
	public Calendar getDuracao() {
		return duracao;
	}
	public void setDuracao(Calendar duracao) {
		this.duracao = duracao;
	}
	public CategoriaDTO getCategoriaDTO() {
		return categoriaDTO;
	}
	public void setCategoriaDTO(CategoriaDTO categoriaDTO) {
		this.categoriaDTO = categoriaDTO;
	}
}
