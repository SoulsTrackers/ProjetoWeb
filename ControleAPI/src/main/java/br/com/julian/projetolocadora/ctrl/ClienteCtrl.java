package br.com.julian.projetolocadora.ctrl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.julian.projetolocadora.dao.ClienteDAO;
import br.com.julian.projetolocadora.dao.UsuarioDAO;
import br.com.julian.projetolocadora.dto.ClienteDTO;
import br.com.julian.projetolocadora.dto.UsuarioDTO;
import br.com.julian.projetolocadora.modelo.Cliente;
import br.com.julian.projetolocadora.modelo.Endereco;
import br.com.julian.projetolocadora.modelo.Usuario;

@Path("/cliente")
public class ClienteCtrl {
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/criarCliente")
	public ClienteDTO criarCliente(ClienteDTO clienteDTO){
		
		Cliente cliente = new Cliente();
		ClienteDAO clienteDAO = new ClienteDAO();
		
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		try{
			
			usuario = this.converterClienteDTOEmUsuario(clienteDTO);
			usuarioDAO.criar(usuario);
			
			cliente = this.converterClienteDTOEmCliente(clienteDTO);
			cliente.setUsuario(usuario);
			clienteDAO.criar(cliente);
			
		}catch (Exception e) {
			String mensagem = "Problema ao criar registro na base. Mensagem Detelhada: ";
			clienteDTO.setMensagem(mensagem + e.getMessage());
		}

		return clienteDTO;
	}

	
	public Cliente converterClienteDTOEmCliente(ClienteDTO clienteDTO){
		
		Cliente cliente  = new Cliente();
		
		return cliente;
	}
	
	public Usuario converterClienteDTOEmUsuario(ClienteDTO clienteDTO){
		Usuario usuario = new Usuario();
		
		usuario.setId(clienteDTO.getUsuarioDTO().getId());
		usuario.setTelefone(clienteDTO.getUsuarioDTO().getTelefone());
		usuario.setCelular(clienteDTO.getUsuarioDTO().getCelular());
		usuario.setEmail(clienteDTO.getUsuarioDTO().getEmail());
		Endereco endereco = new EnderecoCtrl().converterDTOEmEndereco(clienteDTO.getUsuarioDTO().getEnderecoDTO());
		usuario.setEndereco(endereco);
		
		return usuario;
		
	}
	
	
}
