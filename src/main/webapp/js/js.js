$(".nav-link").click(function(){
	if ($(this).attr('id') == 'ed_perfil') {
	    $("#div1").toggleClass("d-flex justify-content-center");
	    $("#div2").hide();
	    $("#div4").hide();
	    $("#div2").removeClass("d-flex justify-content-center");
	    $("#div4").removeClass("d-flex justify-content-center");
	  }
	else if($(this).attr('id') == 'ed_dados'){
	    $("#div2").toggleClass("d-flex justify-content-center");
	    $("#div1").hide();
	    $("#div4").hide();
	    $("#div1").removeClass("d-flex justify-content-center");
	    $("#div4").removeClass("d-flex justify-content-center");
	  }
	else if($(this).attr('id') == 'calcular'){
		$("#div2").hide();
	    $("#div1").hide();
	    $("#div4").toggleClass("d-flex justify-content-center");
	    $("#div1").removeClass("d-flex justify-content-center");
	    $("#div2").removeClass("d-flex justify-content-center");
	}else{
		$("#div2").hide();
	    $("#div1").hide();
	    $("#div4").hide();
	    $("#div4").removeClass("d-flex justify-content-center");
	    $("#div1").removeClass("d-flex justify-content-center");
	    $("#div2").removeClass("d-flex justify-content-center");
	}
});

$("#EditarDadosPessoais").submit(function() {
	var senha1 = $("#exampleInputPassword1");
	var senha2 = $("#exampleInputPassword2");
	var s1 = senha1.val().indexOf(" ");
    if(senha1.val() != senha2.val()){
    	alert("senha incorreta");
    	return false;
    }else if(senha1.val().length < 5){
    	alert("a senha precisa conter +5 caracters");
    	return false;
    }else if(s1>=0){
    	alert("a senha nao deve conter espaços");
    	return false;
    }
     
});


$("#subcadastro").click(function() {
	var senha1 = $("#password1");
	var senha2 = $("#password-confirm");
	var nome = $("#nameCadastro").val();
	var email = $("#emailCadastro").val();
	alert(nome);
	if(senha1.val()!=senha2.val()){
		alert("senhas nao confirmada");
		return false;
	}else if(senha1.val().length <= 5){
		alert("a senha deve ter no minimo 5 caracters");
		return false;
	}else if (senha1.val().indexOf(" ")>=0){
		alert("nao deve haver espaços na senha");
		return false;
	}else{
		var categoria ;
		 $.ajax({
			url:'/calculadora/CriarConta',
			data: { inpnome: nome, inpemail: email, inpsenha : senha1.val() },
			type: 'post',
			success: function(data){
				
				if(data.length > 1){
					alert(data);
				}else{
					window.location.href = "pages/usuario.jsp";
				}
           },error:function(){
        	   alert("erro");
           }
		   
		})
	}
});