package mvc.grupal2.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    // Creamos un HashMap para almacenar los usuarios y claves válidos
    private static final Map<String, String> usuariosValidos = new HashMap<>();

    static {
        // Agregamos los usuarios válidos y sus claves al HashMap
        usuariosValidos.put("Cliente", "1234");
        usuariosValidos.put("Administrativo", "1234");
        usuariosValidos.put("Profesional", "1234");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");

        // Validamos si el usuario y la clave coinciden con los usuarios válidos almacenados
        if (usuariosValidos.containsKey(usuario) && usuariosValidos.get(usuario).equals(clave)) {
            // Obtenemos la sesión actual o creamos una nueva si no existe
            HttpSession session = request.getSession(true);
            // Almacenamos el tipo de usuario en la sesión
            session.setAttribute("tipoUsuario", usuario);

            // Redireccionamos al menú si el inicio de sesión es válido
            response.sendRedirect("menu.jsp");
        } else {
            // Si la validación de inicio de sesión falla, redirigir nuevamente al formulario de inicio de sesión
            response.sendRedirect("login.jsp");
        }
    }
}
