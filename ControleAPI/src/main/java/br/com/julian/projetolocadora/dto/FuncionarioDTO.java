package br.com.julian.projetolocadora.dto;

import java.math.BigDecimal;

import br.com.julian.projetolocadora.modelo.Usuario;

public class FuncionarioDTO extends BaseDTO {
	
	private Integer id;
	private UsuarioDTO usuarioDTO;
	private String login;
	private String senha;
	private BigDecimal salario;
	
	
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	
}
