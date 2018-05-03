<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="Styles/Login.css">
	<link rel="stylesheet" type="text/css" href="Styles/Cadastros.css">
	<meta charset="utf-8">
	<title>Cadastro de Imóveis</title>
</head>
<body>
    <form method="post">
        <div class="application-container">
		<div class="form-container">
                    <form action = "CadastroClientes" method = "GET">
			<div class="form-header">CADASTRO DE CLIENTES</div>
			<div class="form-content">
                        <div class="form-block-row">
                            <div>
                              <label>Nome:</label>
                              <input type="text" name="name">
                            </div>
                            <div>
                              <label>Data de Nascimento</label>
                              <input type="text" name="birthday">
                            </div>
                            <div>
                              <label>RG</label>
                              <input type="text" name="documentNumber">
                            </div>
                        </div>
                        <div class="form-block-row">
                            <div>
                              <label>CPF</label>
                              <input type="text" name="cpf">
                            </div>
                            <div>
                              <label>SEXO</label>
                              <input type="text" name="gender">
                            </div>
                            <div>
                              <label>TELEFONE</label>
                              <input type="text" name="phone">
                            </div>
                        </div>
                            <div class="form-block-row">
                                <div>
                              <label>CELULAR</label>
                              <input type="text" name="cellphone">
                            </div>
                            <div>
                              <label>E-MAIL</label>
                              <input type="text" name="email">
                            </div>
                            <div>
                              <label>CEP</label>
                              <input type="text" name="cep">
                            </div>
                            </div>
                            <div class="form-block-row">
                                <div>
                              <label>LOGRADOURO</label>
                              <input type="text" name="logradouro">
                            </div>
                            <div>
                              <label>NÚMERO</label>
                              <input type="text" name="addressNumber">
                            </div>
                            <div>
                              <label>COMPLEMENTO</label>
                              <input type="text" name="complement">
                            </div>
                            </div>
                            
                            <div class="form-block-row">
                            <div>
                              <label>BAIRRO</label>
                              <input type="text" name="neighborhood">
                            </div>
                            <div>
                              <label>CIDADE</label>
                              <input type="text" name="city">
                            </div>
                            <div>
                              <label>ESTADO</label>
                              <input type="text" name="state">
                            </div>
                            </div>
  			</div>
  			<div class="form-button">
                            <button type="submit">Salvar</button>
  			</div>
                    </form>
		</div>
	</div>
    </form>
</body>
</html>
