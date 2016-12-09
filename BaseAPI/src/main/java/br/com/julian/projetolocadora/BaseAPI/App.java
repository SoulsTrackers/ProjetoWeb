package br.com.julian.projetolocadora.BaseAPI;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.julian.projetolocadora.dao.CategoriaDAO;
import br.com.julian.projetolocadora.dao.FilmeDAO;
import br.com.julian.projetolocadora.modelo.Categoria;
import br.com.julian.projetolocadora.modelo.Cliente;
import br.com.julian.projetolocadora.modelo.Filme;
import br.com.julian.projetolocadora.modelo.Usuario;
import br.com.julian.projetolocadora.util.PesquisaBean;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) 
    {
    	
    	App aplicacao = new App();
    	
    	
    	Categoria categoria = new Categoria();
    	CategoriaDAO dao = new CategoriaDAO();
    	PesquisaBean pesquisaBean = new PesquisaBean(categoria);
    	List<Categoria> categorias = new ArrayList<Categoria>();
    	categoria.setDescricao("Romance");
    	
    	try {
    		dao.criar(categoria);
			System.out.println("Categoria Criada Com Sucesso!");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
//    	try{
//    		categorias = dao.pesq(pesquisaBean, null);
//    		
//    		aplicacao.criarFilme(categorias.get(0));
//    		System.out.println("Filme criado com sucesso");
//    		
//    	}catch(Exception e){
//    		System.out.println(e.getMessage());
//    	}
    	
    	
    	
//    	try{
//    		categorias = dao.pesq(pesquisaBean, null);
//    		for(Categoria retorno : categorias)
//    		{
//    			System.out.println(retorno.getDescricao());
//    		}
//    		
//    	}catch(Exception e){
//    		System.out.println(e.getMessage());
//    	}
    	
    	
    	
    	
//   	try
//    	{
//        	dao.criar(categoria);
//        	System.out.println("Categoria criada com sucesso!");
//    	}catch(Exception e){
//    		System.out.println(e.getMessage());
//    	}
//    	
//    	
    	
    }
    
    public void criarFilme(Categoria categoria) throws Exception
    {
    	Filme filme = new Filme();
    
    	FilmeDAO dao = new FilmeDAO();
    	
   
    	filme.setDescricao("A Volta dos que nao foram");
    	filme.setAno(Calendar.getInstance());
    	filme.setResumo("No final todos morrem, mas também sobrevivem");
  
    	
    	Calendar duracao = Calendar.getInstance();
    	duracao.set(Calendar.HOUR_OF_DAY, 3);
    	duracao.set(Calendar.MINUTE, 0);

    	
    	filme.setDuracao(duracao);
    	
    	dao.criar(filme);
    	  	
    }
    
    public void criarCliente(Usuario usuario)throws Exception
    {
    	Cliente cliente = new Cliente();
    	
    }
}
