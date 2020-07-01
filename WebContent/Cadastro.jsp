<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="//assets.locaweb.com.br/locastyle/2.0.6/stylesheets/locastyle.css">
    <title>Cadastro</title>
    <link rel="stylesheet" href="CSS\styleCadastro.css" />
  </head>
  <body>
    <section class="form-section">
      <h1>Cadastro</h1>
      <div class="form-wrapper">
        <form action="cad_pac">
          <div class="input-block">
            <label for="login-email">CPF</label>
            <input type="text" name="cpf" required/>
          </div>
          <div class="input-block">
            <label for="login-password">Nome</label>
            <input type="text" name="nome" required/>
          </div>
          <div class="input-block">
            <label for="login-email">Data nascimento</label>
            <input type="text" name="dataNascimento" placeholder="dd/mm/aaaa" data-mask="00/00/0000" maxlength="10" autocomplete="off" required/>
          </div>
          <div class="input-block">
            <label for="login-email">RG</label>
            <input type="text" name="rg" required/>
          </div>
          <div class="input-block">
            <label for="login-email">Telefone</label>
            <input type="tel" name="telefone" required/>
          </div>
          <div class="input-block">
            <label for="login-email">Email</label>
            <input type="email" name="email" required/>
          </div>
          <div class="input-block">
            <label for="login-email">Endereço</label>
            <input type="text" name="end" required/>
          </div>
          <div class="input-block">
            <label for="login-email">Sexo</label>
            <select name="sexo">
					<option value="M">Masculino</option>
					<option value="F">Feminino</option>
			</select>
          </div>
          <div class="input-block">
            <label for="login-email">Senha</label>
            <input type="password" name="senha" required/>
          </div>
          <div class="input-block">
            <label for="login-email">Confirme sua senha</label>
            <input type="password" name="senha2" required/>
          </div>
          <button type="submit" class="btn-login">Login</button>
        </form>
      </div>
    </section>
  <script async="" src="//www.google-analytics.com/analytics.js"></script><script type="text/javascript" src="//code.jquery.com/jquery-2.0.3.min.js"></script>
  <script type="text/javascript" src="//assets.locaweb.com.br/locastyle/2.0.6/javascripts/locastyle.js"></script>
  <script type="text/javascript" src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
  </body>
</html>