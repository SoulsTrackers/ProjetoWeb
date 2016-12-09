package br.com.julian.projetolocadora.dto;

import br.com.julian.projetolocadora.modelo.Filme;
import br.com.julian.projetolocadora.modelo.TipoMidia;

public class MidiaDTO extends BaseDTO {
	private Integer id;
	private FilmeDTO filmeDTO;
	private Boolean inutilizada;
	private TipoMidiaDTO tipoMidiaDTO;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public FilmeDTO getFilmeDTO() {
		return filmeDTO;
	}
	public void setFilmeDTO(FilmeDTO filmeDTO) {
		this.filmeDTO = filmeDTO;
	}
	public Boolean getInutilizada() {
		return inutilizada;
	}
	public void setInutilizada(Boolean inutilizada) {
		this.inutilizada = inutilizada;
	}
	public TipoMidiaDTO getTipoMidiaDTO() {
		return tipoMidiaDTO;
	}
	public void setTipoMidiaDTO(TipoMidiaDTO tipoMidiaDTO) {
		this.tipoMidiaDTO = tipoMidiaDTO;
	}

	
	
}
