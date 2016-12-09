$(document).ready(function(){
	listarFilmes();
})

function listarFilmes(){
	var operacao = "/ControleAPI/filme/listar"
	$.ajax({
		url: operacao
	}).done(function (data){
		var lista = data.retorno;
		var linhaTabela = '';
		
		for(i = 0; i < lista.length; i++){
			linhaTabela = linhaTabela + '<tr>';
			
			linhaTabela = linhaTabela + '<td class="id">';
			linhaTabela = linhaTabela + lista[i].id;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + '<td class="descricao">';
			linhaTabela = linhaTabela + lista[i].descricao;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + '<td class="ano">';
			linhaTabela = linhaTabela + lista[i].ano;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + '<td class="resumo">';
			linhaTabela = linhaTabela + lista[i].resumo;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + '<td class="classificacao">';
			linhaTabela = linhaTabela + lista[i].classificacao;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + '<td class="durcao">';
			linhaTabela = linhaTabela + lista[i].duracao;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + '<td class="categoria">';
			linhaTabela = linhaTabela + lista[i].categoria;
			linhaTabela = linhaTabela + '</td>';
			
			linhaTabela = linhaTabela + '<td class="complemento">';
			linhaTabela = linhaTabela + lista[i].complemento;
			linhaTabela = linhaTabela + '</td>';
			linhaTabela = linhaTabela + "</tr>";
		}
		
		$('#lista').append(linhaTabela);
	})
}