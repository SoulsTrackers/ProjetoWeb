package br.com.julian.projetolocadora.dto;

public class TipoUsuarioDTO extends BaseDTO {
	int codigoUsuario;
	String descricaoUsuario;
	
	public int getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public String getDescricaoUsuario() {
		return descricaoUsuario;
	}
	public void setDescricaoUsuario(String descricaoUsuario) {
		this.descricaoUsuario = descricaoUsuario;
	}
	
}
