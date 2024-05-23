## Proyecto: Sistema de Login

### Integrantes del Equipo
- Ana Campoverde
- George Quishpe
- Daniel Mera
- Kenny Pinchao
- Santiago Gualotuña

### Descripción del Programa
Este proyecto es un sistema de login básico implementado en Java utilizando servlets. Permite a los usuarios iniciar sesión utilizando un nombre de usuario y contraseña predefinidos, con un mecanismo para manejar múltiples intentos fallidos de inicio de sesión.

### Fallos, Defectos y Errores Identificados

1. **Fallo: Validación Incompleta de Campos Vacíos**
    - **Descripción:** El código verifica si `username` o `password` son `null`, pero no verifica si están vacíos.

2. **Fallo: Falta de Validación de Intentos Excedidos**
    - **Descripción:** El código no verifica si el usuario ha superado el límite de intentos antes de permitir nuevos intentos de inicio de sesión.

3. **Fallo: Manejo Incorrecto de Cuentas Bloqueadas**
    - **Descripción:** El código verifica si la cuenta está bloqueada después de intentar verificar las credenciales.

4. **Fallo: Manejo Inadecuado de Usuarios No Existentes**
    - **Descripción:** El código no maneja adecuadamente el caso en que el usuario no exista en la base de datos.

5. **Defecto: Reinicio de Intentos Fallidos No Implementado**
    - **Descripción:** El código no reinicia los intentos fallidos después de un inicio de sesión exitoso.

6. **Error: Manejo de Errores en JavaScript**
    - **Descripción:** El código JavaScript no maneja el caso en que `error` sea `null`.

### Cómo Descargar y Ejecutar

1. Clonar el repositorio desde GitHub:
   ```bash
   git clone https://github.com/georgeQuishpe/Login_GR4.git


2. Descargar e instalar Apache Tomcat versión 10 desde [aquí](https://tomcat.apache.org/download-10.cgi).

3. Configurar Tomcat en su entorno de desarrollo (por ejemplo, en IntelliJ IDEA):

- Ir a Run/Debug Configurations.
- Añadir una nueva configuración de Tomcat y seleccionar la versión descargada.
- Escoger el archivo del proyecto clonado.
- Ejecutar el proyecto. 

4. Se abrirá en el navegador en la siguiente URL:

    ``` arduino
    http://localhost:8080/Login_GR4