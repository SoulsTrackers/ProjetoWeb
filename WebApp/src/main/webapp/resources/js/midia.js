function cadastraMidia(){
	
	var operacao = "/ControleAPI/midia/criarMidia" 
	var midiaDTO = new Object();
	
	midiaDTO.inutilizada = $("#inutilizada-midia").val();
	midiaDTO.filmeDTO = new Object();
	midiaDTO.filmeDTO.id = $("#filme-midia").val();
	midiaDTO.tipoMidiaDTO = new Object();
	midiaDTO.tipoMidiaDTO.id = $("#tipomidia-midia").val();
	
	

	$.ajax({
		method: "POST",
		url: operacao,
		data: JSON.stringify(midiaDTO),
		contentType: "application/json"
	}).done(function (data){
		var mensagem = '';
		var titulo = '';
		if(data.mensagem != undefined && data.mensagem != null && data.mensagem != ''){
			titulo = 'Atenção';
			mensagem = data.mensagem;
		}else{
			titulo = "Sucesso";
			mensagem = "Midia cadastrada com sucesso.";
		}
		
		mostrarModal(titulo, mensagem);
	});
}

function mostrarModal(titulo, mensagem){
	$('#modal-title').html(titulo);
	$('#modal-mensagem').html(mensagem);
	
	$('#modal-mensagens').modal('show');
}