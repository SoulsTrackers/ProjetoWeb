$(document).ready(function(){
	listarEnderecosUsuarios();
})

function listarEnderecosUsuarios(){
	var operacao = "/ControleAPI/endereco/listarEnderecos" 
		
	$.ajax({
		url: operacao
	}).done(function (data){
		linhaTabela = '<select id="endereco-usuario" class="form-control" >';
		var lista = data;
		for(i = 0; i < lista.length; i++){
			linhaTabela += '<option value="' + lista[i].id + '">' + lista[i].rua +  '</option>';
		}
		linhaTabela += '</select>';
		$('#boxEndereco').append(linhaTabela);
	})
}