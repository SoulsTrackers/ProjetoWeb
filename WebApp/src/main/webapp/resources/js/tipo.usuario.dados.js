$(document).ready(function(){
	tipoUsuario();
})

function tipoUsuario(){
	var tipoUsuario = $('input[name=tipo-usuario]:checked').val();
	
	if(tipoUsuario == 1){
		$("#loginFuncionario").show();
		$("#senhaFuncionario").show();
		$("#salarioFuncionario").show();
	}
	else{
		$("#loginFuncionario").hide();
		$("#senhaFuncionario").hide();
		$("#salarioFuncionario").hide();		
	}
}