package br.com.julian.projetolocadora.dao;

import org.hibernate.Criteria;

import br.com.julian.projetolocadora.modelo.Usuario;
import br.com.julian.projetolocadora.util.PesquisaBean;

public class UsuarioDAO extends GenericoDAO<Usuario, Integer> {

	@Override
	protected void setAtributoPesq(Criteria crit, PesquisaBean pesquisaBean) throws Exception {
		Usuario o = (Usuario) pesquisaBean.getEntidade();
		
		if(o == null){
			return;
		}
	}

	
	
}
