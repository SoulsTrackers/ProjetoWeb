package br.com.julian.projetolocadora.dao;

import org.hibernate.Criteria;

import br.com.julian.projetolocadora.modelo.Funcionario;
import br.com.julian.projetolocadora.util.PesquisaBean;

public class FuncionarioDAO extends GenericoDAO<Funcionario, Integer> {

	@Override
	protected void setAtributoPesq(Criteria crit, PesquisaBean pesquisaBean) throws Exception {
		Funcionario o = (Funcionario) pesquisaBean.getEntidade();
		
		if(o == null){
			return;
		}
	}

}
