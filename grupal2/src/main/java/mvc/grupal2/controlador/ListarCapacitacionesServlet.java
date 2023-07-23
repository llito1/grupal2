package mvc.grupal2.controlador;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc.grupal2.modelo.Capacitacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/listar-capacitaciones")
public class ListarCapacitacionesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lógica para obtener las capacitaciones almacenadas y pasarlas a la interfaz
        // Obtenemos la lista de capacitaciones del contexto de la aplicación
        ServletContext servletContext = getServletContext();
        List<Capacitacion> capacitaciones = (List<Capacitacion>) servletContext.getAttribute("capacitaciones");

        // Si la lista de capacitaciones no existe en el contexto, la creamos y la agregamos al contexto
        if (capacitaciones == null) {
            capacitaciones = new ArrayList<>();
            servletContext.setAttribute("capacitaciones", capacitaciones);
        }

        request.setAttribute("capacitaciones", capacitaciones);

        request.getRequestDispatcher("listar_capacitaciones.jsp").forward(request, response);
    }
}
