package br.com.julian.projetolocadora.ctrl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.julian.projetolocadora.dao.TipoMidiaDAO;
import br.com.julian.projetolocadora.dto.FilmeDTO;
import br.com.julian.projetolocadora.dto.TipoMidiaDTO;
import br.com.julian.projetolocadora.modelo.Filme;
import br.com.julian.projetolocadora.modelo.TipoMidia;

@Path("/tipomidia")
public class TipoMidiaCtrl {

	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/criarMidia")
	public TipoMidiaDTO cadastraTipoMidia(TipoMidiaDTO tipoMidiaDTO){
		
		TipoMidiaDAO tipoMidiaDAO = new TipoMidiaDAO();
		TipoMidia    tipoMidia    = new TipoMidia();
		
		try{
			
			tipoMidia = this.converterTipoMidiaDTOEmTipoMidia(tipoMidiaDTO);
			tipoMidiaDAO.criar(tipoMidia);
			tipoMidiaDTO.setMidias(tipoMidia.getMidias());
			
			
		}catch (Exception e) {
			String mensagem = "Problema ao criar registro na base. Mensagem Detelhada: ";
			tipoMidiaDTO.setMensagem(mensagem + e.getMessage());
		}
		return tipoMidiaDTO;
	}
	
	public TipoMidia converterTipoMidiaDTOEmTipoMidia(TipoMidiaDTO tipoMidiaDTO){
		TipoMidia tipoMidia = new TipoMidia();
		
		tipoMidia.setDescricao(tipoMidiaDTO.getDescricao());
		tipoMidia.setMidias(tipoMidiaDTO.getMidias());
		
		return tipoMidia;
	}


}
