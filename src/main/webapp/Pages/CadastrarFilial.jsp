<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="Styles/Login.css">
	<link rel="stylesheet" type="text/css" href="Styles/Cadastros.css">
	<meta charset="utf-8">
	<title>Cadastro de Filial</title>
</head>
<script type="text/javascript">
 function pushTo(){
    window.location.pathname = "/astec/cadastrar-cliente";
 }
</script>
<body>
    <form method="post">
        <div class="application-container">
		<div class="form-container">
			<div class="form-header">CADASTRO FILIAL</div>
			<div class="form-content">
				<div class="form-block">
				<label>Nome:</label>
				<input type="text" name="nome">
                                <label>CNPJ</label>
				<input type="text" name="cnpj">
				<label>CEP:</label>
				<input type="text" name="cep">
				<label>Logradouro:</label>
				<input type="text" name="logradouro">
				<label>Número:</label>
				<input type="text" name="numero">
                                <label>Complemento:</label>
				<input type="text" name="complemento">					
				<label>Bairro:</label>
				<input type="text" name="bairro">
                                <label>Cidade:</label>
				<input type="text" name="cidade">
				<label>Estado:</label>
				<input type="text" name="estado">
			</div>
                            <div class="form-block">
                                <h3>INFORMAÇÕES DE LOGIN</h3>
                                <label>Login:</label>
				<input type="text" name="login">
                                <label>Senha:</label>
				<input type="text" name="senha">
			</div>
			</div>
			<div class="form-button">
				<button>Salvar</button>
			</div>
		</div>
	</div>
    </form>
</body>
</html>
