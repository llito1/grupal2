package mvc.grupal2.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc.grupal2.modelo.Usuario;

import java.io.IOException;
import java.util.List;

@WebServlet("/listar-usuarios")
public class ListarUsuariosServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtenemos el gestor de usuarios del contexto de la aplicación
        GestorUsuarios gestorUsuarios = (GestorUsuarios) getServletContext().getAttribute("gestorUsuarios");

        // Si el gestor de usuarios no existe en el contexto, lo creamos y lo agregamos al contexto
        if (gestorUsuarios == null) {
            gestorUsuarios = new GestorUsuarios();
            getServletContext().setAttribute("gestorUsuarios", gestorUsuarios);
        }

        // Obtenemos la lista de usuarios del gestor de usuarios
        List<Usuario> usuarios = gestorUsuarios.getUsuarios();

        // Agregamos la lista de usuarios al atributo "usuarios" del objeto "request"
        request.setAttribute("usuarios", usuarios);

        // Redireccionamos a la página de lista de usuarios
        request.getRequestDispatcher("listar_usuarios.jsp").forward(request, response);
    }
}
