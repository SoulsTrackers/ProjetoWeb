function cadastrarEndereco(){
	var rua    = $("#rua-endereco").val();
	var numero = $("#numero-endereco").val();
	var bairro = $("#bairro-endereco").val();
	var cidade = $("#cidade-endereco").val();
	var estado = $("#estado-endereco").val();
	var cep    = $("#cep-endereco").val();
	var complemento = $("#complemento-endereco").val();
	
	var enderecoDTO = new Object();
	var operacao = "/ControleAPI/endereco/criarEndereco" 
		
	enderecoDTO.rua 		= rua;
	enderecoDTO.numero 		= numero;
	enderecoDTO.bairro		= bairro;
	enderecoDTO.cidade 		= cidade;
	enderecoDTO.estado	    = estado;
	enderecoDTO.cep         = cep;
	enderecoDTO.complemento = complemento;

	$.ajax({
		method: "POST",
		url: operacao,
		data: JSON.stringify(enderecoDTO),
		contentType: "application/json"
	}).done(function (data){
		var mensagem = '';
		var titulo = '';
		if(data.mensagem != undefined && data.mensagem != null && data.mensagem != ''){
			titulo = 'Atenção';
			mensagem = data.mensagem;
		}else{
			titulo = "Sucesso";
			mensagem = "Endereço cadastrado com sucesso.";
		}
		
		mostrarModal(titulo, mensagem);
	});
}

function mostrarModal(titulo, mensagem){
	$('#modal-title').html(titulo);
	$('#modal-mensagem').html(mensagem);
	
	$('#modal-mensagens').modal('show');
}		