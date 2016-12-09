$(document).ready(function(){
	listarCategorias();
})

function listarCategorias(){
	var operacao = "/ControleAPI/categoria/listarCategorias" 
		
	$.ajax({
		url: operacao
	}).done(function (data){
		var lista = data;
		var linhaTabela = '';
		
		for(i = 0; i < lista.length; i++){
			linhaTabela = linhaTabela + '<tr>';
			
			linhaTabela = linhaTabela + '<td class="id">';
			linhaTabela = linhaTabela + lista[i].id;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + '<td class="descricao">';
			linhaTabela = linhaTabela + lista[i].descricao;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + "</tr>";
		}
		
		$('#lista').append(linhaTabela);
	})
}