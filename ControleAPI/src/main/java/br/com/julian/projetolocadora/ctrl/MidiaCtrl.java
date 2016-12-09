package br.com.julian.projetolocadora.ctrl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.julian.projetolocadora.dao.MidiaDAO;
import br.com.julian.projetolocadora.dto.FilmeDTO;
import br.com.julian.projetolocadora.dto.MidiaDTO;
import br.com.julian.projetolocadora.modelo.Categoria;
import br.com.julian.projetolocadora.modelo.Filme;
import br.com.julian.projetolocadora.modelo.Midia;
import br.com.julian.projetolocadora.modelo.TipoMidia;

@Path("/midia")
public class MidiaCtrl {
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/criarMidia")
	public MidiaDTO cadastrarMidia(MidiaDTO midiaDTO){
		Midia midia = new Midia();
		MidiaDAO midiaDAO = new MidiaDAO();
		
		
		
		try{
			
			 this.validarCamposObrigatorios(midiaDTO);
			 midia = this.converterMidiaDTOEmMidia(midiaDTO);
			 midiaDAO.criar(midia);
			 midiaDTO.setId(midia.getId());
			
		}catch (Exception e) {
			String mensagem = "Problema ao criar registro na base. Mensagem Detelhada: ";
			midiaDTO.setMensagem(mensagem + e.getMessage());
		}
		
		return midiaDTO;
	}
	
	public Midia converterMidiaDTOEmMidia(MidiaDTO midiaDTO){
		Midia midia = new Midia();
		
		midia.setId(midiaDTO.getId());
		midia.setInutilizada(midiaDTO.getInutilizada());
		Filme filme = new FilmeCtrl().converterFilmeDTOEmFilme(midiaDTO.getFilmeDTO());
		midia.setFilme(filme);
		TipoMidia tipoMidia = new TipoMidiaCtrl().converterTipoMidiaDTOEmTipoMidia(midiaDTO.getTipoMidiaDTO());
		midia.setTipoMidia(tipoMidia);


		return midia;
	}
	
	public void validarCamposObrigatorios(MidiaDTO midiaDTO) throws Exception{
		if(midiaDTO.getFilmeDTO() == null){
			throw new Exception("Escolha um Filme!");
		}
		
		if(midiaDTO.getInutilizada() == null || midiaDTO.getTipoMidiaDTO() == null){
			throw new Exception("Campos Obrigatorios!");
		}
	}
	
}
