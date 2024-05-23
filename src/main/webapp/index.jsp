<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inicio de sesión</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<script>
    window.onload = function() {
        const urlParams = new URLSearchParams(window.location.search);
        const error = urlParams.get('error');
        const errorMessage = document.getElementById('error');

        // Error: No se maneja si 'error' es nulo
        if (error === 'incorrect_credentials') {
            errorMessage.innerText = 'Credenciales incorrectas';
        }else if (error === 'account_blocked') {
            errorMessage.innerText = 'Cuenta bloqueada por demasiados intentos fallidos';
        }else if (error === 'empty_data') {
            errorMessage.innerText = 'Usuario o contraseña no proporcionados';
        }else if (error === 'login_successful') {
            errorMessage.innerText = 'Inicio de sesion exitoso';
        }
    }
</script>
<div class="container">
    <h1 class="titulo young-serif-regular">Bienvenido</h1>
    <div class="icon">
        <img src="img/buho.png" alt="b&uacute;ho" height="100px" width="100px">
    </div>
    <form action="login" method="post">
        <input type="text" name="username" class="form-control average-sans-regular" placeholder="Usuario">
        <input type="password" name="password" class="form-control average-sans-regular" placeholder="Contrase&ntilde;a">
        <button class="btn w-100 py-2 average-sans-regular" type="submit">Iniciar sesi&oacute;n</button>
        <p id="error" class="error-message"></p>
    </form>
</div>
</body>
</html>
