package br.com.julian.projetolocadora.dao;

import java.io.Serializable;

import org.hibernate.Criteria;

import br.com.julian.projetolocadora.modelo.Cliente;
import br.com.julian.projetolocadora.util.PesquisaBean;

public class ClienteDAO extends GenericoDAO<Cliente, Integer>{

	@Override
	protected void setAtributoPesq(Criteria crit, PesquisaBean pesquisaBean) throws Exception {
		Cliente o = (Cliente) pesquisaBean.getEntidade();
		
		if(o == null){
			return;
		}
	}

}
