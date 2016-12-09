package br.com.julian.projetolocadora.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import br.com.julian.projetolocadora.dao.CategoriaDAO;
import br.com.julian.projetolocadora.modelo.Categoria;
import br.com.julian.projetolocadora.dto.BaseDTO;
import br.com.julian.projetolocadora.dto.CategoriaDTO;

@Path("/categoria")
public class CategoriaCtrl {

	@GET
	@Produces("application/json")
	@Path("/{id}")
	public BaseDTO consultarCategoria(@PathParam("id") Integer id) {
		CategoriaDTO categoriaDTO = new CategoriaDTO();
		
		try {
			Categoria categoria = new CategoriaDAO().pesqPorId(id);	
			
			categoriaDTO = this.converterCategoriaEmDTO(categoria);
			
		} catch (Exception e) {
			categoriaDTO.setMensagem("Não foi possível encontrar registros com essa informação");
		}
		
		return categoriaDTO;
	}
	
	public CategoriaDTO converterCategoriaEmDTO(Categoria categoria){
		CategoriaDTO categoriaDTO = new CategoriaDTO();
		
		categoriaDTO.setId(categoria.getId());
		categoriaDTO.setDescricao(categoria.getDescricao());
		
		return categoriaDTO;
	}
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/criarCategoria")
	public CategoriaDTO criarCategoria(CategoriaDTO categoriaDTO){
		
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria categoria = new Categoria();
		
		try {
			this.validarCamposObrigatorios(categoriaDTO);
			categoria = this.converterDTOEmCategoria(categoriaDTO);
			categoriaDAO.criar(categoria);
		} catch (Exception e) {
			String mensagemErro = "Problemas ao criar registro: mensagem detalhada: ";
			categoriaDTO.setMensagem(mensagemErro + e.getMessage());
		}
		
		return categoriaDTO;
	}
	
	public void validarCamposObrigatorios(CategoriaDTO categoriaDTO) throws Exception{
		if(categoriaDTO.getDescricao() == null || categoriaDTO.getDescricao().isEmpty()){
			throw new Exception("Campo Descrição é obrigatório.");
		}
	}
	
	public Categoria converterDTOEmCategoria(CategoriaDTO categoriaDTO){
		Categoria categoria = new Categoria();
		
		categoria.setId(categoriaDTO.getId());
		categoria.setDescricao(categoriaDTO.getDescricao());
		
		return categoria;
	}
	
	@GET
	@Produces("application/json")
	@Path("/listarCategorias")
	public List<CategoriaDTO> listarCategorias(){
		List<CategoriaDTO> categoriasDTO = new ArrayList<CategoriaDTO>();
		List<Categoria> categorias = new ArrayList<Categoria>();
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		
		try{
			categorias = categoriaDAO.pesq(null);
			
			for(Categoria categoria : categorias){
				CategoriaDTO categoriaDTO = this.converterCategoriaEmDTO(categoria);
				categoriasDTO.add(categoriaDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return categoriasDTO;
	}
	//@POST - Criar registro
	//@DELETE - Remover
	//@PUT - Atualizar

}
