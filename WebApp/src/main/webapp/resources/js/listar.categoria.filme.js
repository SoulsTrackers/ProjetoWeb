$(document).ready(function(){
	listarCategoriasFilme();
})

function listarCategoriasFilme(){
	var operacao = "/ControleAPI/categoria/listarCategorias" 
		
	$.ajax({
		url: operacao
	}).done(function (data){
		linhaTabela = '<select id="categoria-filme" class="form-control">';
		var lista = data;
		for(i = 0; i < lista.length; i++){
			linhaTabela += '<option value="' + lista[i].id + '">' + lista[i].descricao +  '</option>';
		}
		linhaTabela += '</select>';
		$('#boxCategoria').append(linhaTabela);
	})
}
