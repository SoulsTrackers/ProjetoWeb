package br.com.julian.projetolocadora.dto;

import br.com.julian.projetolocadora.modelo.Usuario;

public class ClienteDTO extends BaseDTO {
	
	private Integer id;
	private UsuarioDTO usuarioDTO;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}
	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	
	
}
