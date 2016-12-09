package br.com.julian.projetolocadora.dao;

import org.hibernate.Criteria;

import br.com.julian.projetolocadora.modelo.Midia;
import br.com.julian.projetolocadora.util.PesquisaBean;

public class MidiaDAO extends GenericoDAO<Midia, Integer>{

	@Override
	protected void setAtributoPesq(Criteria crit, PesquisaBean pesquisaBean) throws Exception {
		Midia o = (Midia) pesquisaBean.getEntidade();
		
		if(o == null){
			return;
		}
	}

}
