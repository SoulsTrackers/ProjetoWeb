function cadastrarMidia(){
	
	var operacao = "/ControleAPI/tipoMidia/criarTipoMidia"
		
		var tipoMidiaDTO = new Object();
		
		tipoMidiaDTO.descricao    = $("#descricao-tipoMidia").val(); 
		tipoMidiaDTO.midias       = $("#midias-tipoMidia").val();
		
		var dados = JSON.stringify(tipoMidiaDTO);
		
		$.ajax({
			method: "POST",
			url: operacao,
			data: JSON.stringify(tipoMidiaDTO),
			contentType: "application/json"
		}).done(function (data){
			var mensagem = '';
			var titulo = '';
			if(data.mensagem != undefined && data.mensagem != null && data.mensagem != ''){
				titulo = 'Atenção';
				mensagem = data.mensagem;
			}else{
				titulo = "Sucesso";
				mensagem = "Usuário cadastrado com sucesso.";
			}
			
			mostrarModal(titulo, mensagem);
		});
	}
		
	function mostrarModal(titulo, mensagem){
		$('#modal-title').html(titulo);
		$('#modal-mensagem').html(mensagem);
		
		$('#modal-mensagens').modal('show');
	}		
	
	
}