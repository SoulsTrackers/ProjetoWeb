package br.com.julian.projetolocadora.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.julian.projelolocadora.util.TipoUsuario;
import br.com.julian.projetolocadora.dao.ClienteDAO;
import br.com.julian.projetolocadora.dao.FuncionarioDAO;
import br.com.julian.projetolocadora.dao.UsuarioDAO;
import br.com.julian.projetolocadora.dto.ClienteDTO;
import br.com.julian.projetolocadora.dto.EnderecoDTO;
import br.com.julian.projetolocadora.dto.FuncionarioDTO;
import br.com.julian.projetolocadora.dto.TipoUsuarioDTO;
import br.com.julian.projetolocadora.dto.UsuarioDTO;
import br.com.julian.projetolocadora.modelo.Cliente;
import br.com.julian.projetolocadora.modelo.Endereco;
import br.com.julian.projetolocadora.modelo.Funcionario;
import br.com.julian.projetolocadora.modelo.Usuario;

@Path("/usuario")
public class UsuarioCtrl {

@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/criarUsuario")
	public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO){
		
		Usuario usuario  = new Usuario();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		try{
			//this.validarCamposObrigatorios(usuarioDTO);
			usuario = this.converterUsuarioDTOEmUsuario(usuarioDTO);
			
			usuarioDAO.criar(usuario);
			usuarioDTO.setId(usuario.getId());
			
		} catch (Exception e) {
			String mensagem = "Problema ao criar registro na base. Mensagem Detelhada: ";
			usuarioDTO.setMensagem(mensagem + e.getMessage());
		}
		return usuarioDTO;
	}
	
	public Usuario converterUsuarioDTOEmUsuario(UsuarioDTO usuarioDTO){
		
		Usuario usuario = new Usuario();
		
		usuario.setId(usuarioDTO.getId());
		usuario.setNome(usuarioDTO.getNome());
		usuario.setTelefone(usuarioDTO.getTelefone());
		usuario.setCelular(usuarioDTO.getCelular());
		Endereco endereco = new EnderecoCtrl().converterDTOEmEndereco(usuarioDTO.getEnderecoDTO());
		usuario.setEndereco(endereco);
		
		return usuario;
	}
	
	
	
	@GET
	@Produces("application/json")
	@Path("/buscarTiposUsuarios")
	public List<TipoUsuarioDTO> buscarTiposUsuario() {
		List<TipoUsuarioDTO> tiposUsuarioDTO = new ArrayList<TipoUsuarioDTO>();
		TipoUsuarioDTO tipoUsuarioDTO = null;
		
		for (TipoUsuario tp : TipoUsuario.values()) {
			tipoUsuarioDTO = new TipoUsuarioDTO();
			tipoUsuarioDTO.setCodigoUsuario(tp.getCodigoUsuario());
			tipoUsuarioDTO.setDescricaoUsuario(tp.getDescricaoUsuario());
			tiposUsuarioDTO.add(tipoUsuarioDTO);
		}
		
		return tiposUsuarioDTO;
	}


	
	
}
