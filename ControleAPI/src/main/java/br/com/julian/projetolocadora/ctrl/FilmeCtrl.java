package br.com.julian.projetolocadora.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.julian.projetolocadora.dao.FilmeDAO;
import br.com.julian.projetolocadora.modelo.Categoria;
import br.com.julian.projetolocadora.modelo.Filme;
import br.com.julian.projetolocadora.dto.CategoriaDTO;
import br.com.julian.projetolocadora.dto.FilmeDTO;
import br.com.julian.projetolocadora.dto.ListFilmeDTO;

@Path("/filme")
public class FilmeCtrl {
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/criarFilme")
	public FilmeDTO cadastraFilme(FilmeDTO filmeDTO){
		Filme filme = new Filme();
		FilmeDAO filmeDAO = new FilmeDAO();
		
		
		try {
			this.validarCamposObrigatorios(filmeDTO);
			filme = this.converterFilmeDTOEmFilme(filmeDTO);
			filmeDAO.criar(filme);
			filmeDTO.setId(filme.getId());
		} catch (Exception e) {
			String mensagem = "Problema ao criar registro na base. Mensagem Detelhada: ";
			filmeDTO.setMensagem(mensagem + e.getMessage());
		}
		
		return filmeDTO;
	}
	
	public Filme converterFilmeDTOEmFilme(FilmeDTO filmeDTO){
		Filme filme = new Filme();
		
		filme.setId(filmeDTO.getId());
		filme.setDescricao(filmeDTO.getDescricao());
		filme.setAno(filmeDTO.getAno());
		filme.setResumo(filmeDTO.getResumo());
		filme.setClassificacao((filmeDTO.getClassificacao()));
		filme.setDuracao(filmeDTO.getDuracao());
		Categoria categoria = new CategoriaCtrl().converterDTOEmCategoria(filmeDTO.getCategoriaDTO());
		filme.setCategoria(categoria);
		
		return filme;
	}
	
	public void validarCamposObrigatorios(FilmeDTO filmeDTO) throws Exception{
		if(filmeDTO.getDescricao() == null || filmeDTO.getDescricao().isEmpty()){
			throw new Exception("Campo descricao  obrigatÃ³rio!");
		}
		
		if(filmeDTO.getCategoriaDTO() == null || filmeDTO.getCategoriaDTO().getId() == null){
			throw new Exception("Campo categoria Ã© obrigatÃ³rio!");
		}
	}
	
	@GET
	@Produces("application/json")
	@Path("/listar")
	public ListFilmeDTO listaFilmes(){
		List<Filme> filmes = new ArrayList<Filme>();
		List<FilmeDTO> filmesDTO = new ArrayList<FilmeDTO>();
		FilmeDAO filmeDAO = new FilmeDAO();
		ListFilmeDTO listFilmeDTO = new ListFilmeDTO();
		
		try {
			filmes = filmeDAO.pesq(null);
			
			for(Filme filme : filmes){
				FilmeDTO filmeDTO = new FilmeDTO();
				filmeDTO = this.converterFilmeEmFilmeDTO(filme);
				filmesDTO.add(filmeDTO);
			}
			
			listFilmeDTO.setRetorno(filmesDTO);
		} catch (Exception e) {
			listFilmeDTO.setMensagem("---");
		}
		
		return listFilmeDTO;
	}
	
	public FilmeDTO converterFilmeEmFilmeDTO(Filme filme){
		FilmeDTO filmeDTO = new FilmeDTO();
		
		filmeDTO.setId(filme.getId());
		filmeDTO.setDescricao(filme.getDescricao());
		filmeDTO.setAno(filme.getAno());
		filmeDTO.setResumo(filme.getResumo());
		filmeDTO.setClassificacao((filme.getClassificacao()));
		filmeDTO.setDuracao(filmeDTO.getDuracao());
		CategoriaDTO categoriaDTO = new CategoriaCtrl().converterCategoriaEmDTO(filme.getCategoria());
		filmeDTO.setCategoriaDTO(categoriaDTO);
		
		return filmeDTO;
	}
}
