package mvc.grupal2.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc.grupal2.modelo.Usuario;

import java.io.IOException;

@WebServlet("/crear-usuario")
public class CrearUsuarioServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lógica para mostrar la interfaz de Crear Usuario
        request.getRequestDispatcher("crear_usuario.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lógica para procesar la información del formulario y almacenar el usuario en el gestor de usuarios
        String tipoUsuario = request.getParameter("tipo");
        String clave = request.getParameter("clave");
        String run = request.getParameter("run");

        // Creamos un nuevo usuario con los datos recibidos
        Usuario usuario = new Usuario(tipoUsuario, clave, run);

        // Obtenemos el gestor de usuarios del contexto de la aplicación
        GestorUsuarios gestorUsuarios = (GestorUsuarios) getServletContext().getAttribute("gestorUsuarios");

        // Si el gestor de usuarios no existe en el contexto, lo creamos y lo agregamos al contexto
        if (gestorUsuarios == null) {
            gestorUsuarios = new GestorUsuarios();
            getServletContext().setAttribute("gestorUsuarios", gestorUsuarios);
        }

        // Agregamos el usuario al gestor de usuarios
        gestorUsuarios.agregarUsuario(usuario);

        // Redirigimos a la página de listado de usuarios con una redirección directa (sin sendRedirect)
        response.sendRedirect("listar-usuarios");
    }
}
