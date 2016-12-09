package br.com.julian.projetolocadora.dto;

import java.util.List;

public class BaseListDTO<T extends BaseDTO>{
	private String mensagem;
	private List<T> retorno;
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public List<T> getRetorno() {
		return retorno;
	}
	public void setRetorno(List<T> retorno) {
		this.retorno = retorno;
	}
}
