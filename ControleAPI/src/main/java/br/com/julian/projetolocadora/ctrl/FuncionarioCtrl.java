package br.com.julian.projetolocadora.ctrl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.julian.projetolocadora.dao.ClienteDAO;
import br.com.julian.projetolocadora.dao.FuncionarioDAO;
import br.com.julian.projetolocadora.dao.UsuarioDAO;
import br.com.julian.projetolocadora.dto.ClienteDTO;
import br.com.julian.projetolocadora.dto.FuncionarioDTO;
import br.com.julian.projetolocadora.dto.UsuarioDTO;
import br.com.julian.projetolocadora.modelo.Cliente;
import br.com.julian.projetolocadora.modelo.Endereco;
import br.com.julian.projetolocadora.modelo.Funcionario;
import br.com.julian.projetolocadora.modelo.Usuario;

@Path("/funcionario")
public class FuncionarioCtrl {

	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/criarFuncionario")
	public FuncionarioDTO criarFuncionario(FuncionarioDTO funcionarioDTO){
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = new Funcionario();
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		
		try {

			usuario = this.converterFuncionarioDTOEmUsuario(funcionarioDTO);
			usuarioDAO.criar(usuario);
			
			funcionario = this.converterFuncionarioDTOEmFuncionario(funcionarioDTO);
			funcionario.setUsuario(usuario);
			funcionarioDAO.criar(funcionario);
		
			
		} catch (Exception e) {
			String mensagemErro = "Problemas ao criar registro: mensagem detalhada: ";
			funcionarioDTO.setMensagem(mensagemErro + e.getMessage());
		}
		
		return funcionarioDTO;
	}
	
	public Funcionario converterFuncionarioDTOEmFuncionario(FuncionarioDTO funcionarioDTO){
		Funcionario funcionario = new Funcionario();
		
		funcionario.setLogin(funcionarioDTO.getLogin());
		funcionario.setSenha(funcionarioDTO.getSenha());
		funcionario.setSalario(funcionarioDTO.getSalario());
		
		return funcionario;
	}
	
	public Usuario converterFuncionarioDTOEmUsuario(FuncionarioDTO funcionarioDTO){
		Usuario usuario = new Usuario();
		
		usuario.setId(funcionarioDTO.getUsuarioDTO().getId());
		usuario.setNome(funcionarioDTO.getUsuarioDTO().getNome());
		usuario.setTelefone(funcionarioDTO.getUsuarioDTO().getTelefone());
		usuario.setCelular(funcionarioDTO.getUsuarioDTO().getCelular());
		usuario.setEmail(funcionarioDTO.getUsuarioDTO().getEmail());
		Endereco endereco = new EnderecoCtrl().converterDTOEmEndereco(funcionarioDTO.getUsuarioDTO().getEnderecoDTO());
		usuario.setEndereco(endereco);		
		
		return usuario;
	}
	
	
}
