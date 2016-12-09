$(document).ready(function(){
	buscarTiposUsuarios();
})

function buscarTiposUsuarios(){
	var operacao = "/ControleAPI/usuario/buscarTiposUsuarios" 
		
	$.ajax({
		url: operacao
	}).done(function (data){
		//<input type="radio" value="0" name="tipo-usuario">Cliente</label>
		//<label><input type="radio" value="1" name="tipo-usuario">Funcionário</label>
		linhaTabela = "" ;
		var lista = data;
		for(i = 0; i < lista.length; i++){
			linhaTabela += '<label><input type="radio" value="' + lista[i].codigoUsuario + '"name="tipo-usuario" onchange="tipoUsuario();">' 
							+ lista[i].descricaoUsuario + '</label>';
		}
		$('#boxUsuario').append(linhaTabela);
	})
}