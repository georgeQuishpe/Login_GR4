package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final Map<String, String> users = new HashMap<>();
    private static final Map<String, Integer> loginAttempts = new HashMap<>();

    static {
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username == null || password == null) { // Fallo: No se valida si los campos de usuario y contraseña están vacíos
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.sendRedirect(req.getContextPath() + "/index.jsp?error=empty_data");
            return;
        }

        if (!loginAttempts.containsKey(username)) { // Fallo: No se valida si el usuario ha superado el límite de intentos
            loginAttempts.put(username, 0);
        }

        if (loginAttempts.get(username) >= 3) { // Fallo: No se verifica si la cuenta está bloqueada antes de verificar las credenciales
            resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
            resp.sendRedirect(req.getContextPath() + "/index.jsp?error=account_blocked");
            return;
        }

        if (!users.containsKey(username) || !users.get(username).equals(password)) { // Fallo: No se maneja si el usuario no existe en la base de datos
            loginAttempts.put(username, loginAttempts.get(username) + 1); // Defecto: No se reinician los intentos fallidos después de un inicio de sesión exitoso
            System.out.println("Intentos de inicio de sesion: " + loginAttempts.get(username));
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.sendRedirect(req.getContextPath() + "/index.jsp?error=incorrect_credentials");
            return;
        }

        loginAttempts.put(username, 0); // Defecto: No se maneja si el usuario se bloquea automáticamente después de un cierto número de intentos fallidos
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.sendRedirect(req.getContextPath() + "/index.jsp?error=login_successful");
    }
}
