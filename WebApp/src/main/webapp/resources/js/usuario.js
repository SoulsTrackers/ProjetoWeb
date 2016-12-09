function cadastrarUsuario(){
	
	var tipoUsuario = $('input[name=tipo-usuario]:checked').val();
		
		if(tipoUsuario == 1){
			var operacao = "/ControleAPI/funcionario/criarFuncionario"
			
			var funcionarioDTO = new Object();
			funcionarioDTO.usuarioDTO = new Object();
			
			funcionarioDTO.usuarioDTO.nome 	      = $("#nome-usuario").val();
			funcionarioDTO.usuarioDTO.telefone	      = $("#telefone-usuario").val();
			funcionarioDTO.usuarioDTO.celular 	      = $("#celular-usuario").val();
			funcionarioDTO.usuarioDTO.email 	      = $("#email-usuario").val();
			funcionarioDTO.usuarioDTO.enderecoDTO 	  = new Object();
			funcionarioDTO.usuarioDTO.enderecoDTO.id = $("#endereco-usuario").val();
			
			funcionarioDTO.login 	  = $("#login-funcionario").val();
			funcionarioDTO.senha 	  = $("#senha-funcionario").val();
			funcionarioDTO.salario 	  = $("#salario-funcionario").val();
			
			var dados = JSON.stringify(funcionarioDTO);
		}
		else {
			
			var operacao = "/ControleAPI/cliente/criarCliente"
			
			var clienteDTO = new Object();
			clienteDTO.usuarioDTO = new Object();
			
			clienteDTO.usuarioDTO.nome		     = $("#nome-usuario").val();
			clienteDTO.usuarioDTO.telefone       = $("#telefone-usuario").val();
			clienteDTO.usuarioDTO.celular        = $("#celular-usuario").val();
			clienteDTO.usuarioDTO.email          = $("#email-usuario").val();
			clienteDTO.usuarioDTO.enderecoDTO    = new Object();
			clienteDTO.usuarioDTO.enderecoDTO.id = $("#endereco-usuario").val();
			
			var dados = JSON.stringify(clienteDTO);
		}
		
	
		$.ajax({
			method: "POST",
			url: operacao,
			data: dados,
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