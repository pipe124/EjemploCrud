package controlador;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import modelo.Administrador;
import modelo.AdministradorDAO;

public class AdministradorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String contraseña = request.getParameter("contraseña");

        Administrador admin = new Administrador();
        admin.setNombre(nombre);
        admin.setCorreo(correo);
        admin.setContraseña(contraseña);

        AdministradorDAO dao = new AdministradorDAO();
        dao.crearAdministrador(admin);

        response.sendRedirect("AdministradorServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AdministradorDAO dao = new AdministradorDAO();
        ArrayList<Administrador> lista = new ArrayList<>(dao.obtenerAdministrador());

        request.setAttribute("listaadministrador", lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("administradores.jsp");
        dispatcher.forward(request, response);
    }
}