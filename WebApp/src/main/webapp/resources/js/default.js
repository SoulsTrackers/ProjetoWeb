

function abrirTelaCadastroCategoria(){
	var url = "/WebApp/categoria/cadastro.html";
	
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaListarCategoria(){
	var url = "/WebApp/categoria/pesquisa.html";
	
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaCadastroEndereco(){
	var url = "/WebApp/endereco/cadastro.html";
	
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaListarEnderecos(){
	var url = "/WebApp/endereco/pesquisa.html";
	
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaCadastroFilme(){
	var url = "/WebApp/filme/cadastro.html";
	
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaListarFilmes(){
	var url = "/WebApp/filme/pesquisa.html";
	
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaCadastroUsuario(){
	var url = "/WebApp/usuario/cadastro.html";
	
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaListarUsuario(){
	var url = "/WebApp/usuario/pesquisa.html";
	
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaCadastroTipoMidia(){
	var url = "/WebApp/tipomidia/cadastro.html";
	
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}


function abrirTelaListarTipoMidia(){
	var url = "/WebApp/tipomidia/pesquisa.html";
	
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaCadastroMidia(){
	var url = "/WebApp/midia/cadastro.html";
	
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}


function abrirTelaListarMidia(){
	var url = "/WebApp/midia/pesquisa.html";
	
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}


