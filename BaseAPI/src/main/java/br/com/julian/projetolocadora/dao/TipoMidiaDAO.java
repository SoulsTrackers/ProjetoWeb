package br.com.julian.projetolocadora.dao;

import org.hibernate.Criteria;

import br.com.julian.projetolocadora.modelo.TipoMidia;
import br.com.julian.projetolocadora.util.PesquisaBean;

public class TipoMidiaDAO extends GenericoDAO<TipoMidia, Integer> {

	@Override
	protected void setAtributoPesq(Criteria crit, PesquisaBean pesquisaBean) throws Exception {
		TipoMidia o = (TipoMidia) pesquisaBean.getEntidade();
		
		if(o == null){
			return;
		}
	}

}
