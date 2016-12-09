package br.com.julian.projetolocadora.dao;

import org.hibernate.Criteria;

import br.com.julian.projetolocadora.modelo.Locacao;
import br.com.julian.projetolocadora.util.PesquisaBean;

public class LocacaoDAO extends GenericoDAO<Locacao, Integer> {

	@Override
	protected void setAtributoPesq(Criteria crit, PesquisaBean pesquisaBean) throws Exception {
		Locacao o = (Locacao) pesquisaBean.getEntidade();
		
		if(o == null){
			return;
		}
	}

}
