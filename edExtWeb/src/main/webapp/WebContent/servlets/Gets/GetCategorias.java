package main.webapp.WebContent.servlets.Gets;

import com.fasterxml.jackson.databind.ObjectMapper;
import interfaces.IcontroladorCurso;
import interfaces.fabrica;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/GetCategorias")
public class GetCategorias extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        fabrica fabrica = interfaces.fabrica.getInstancia();
        IcontroladorCurso icon = fabrica.getIcontroladorCurso();
        HttpSession session = request.getSession();

        ArrayList<String> categorias = icon.listarCategorias();

        try {
        	request.setAttribute("categorias", categorias);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        String categoriaStr = mapper.writeValueAsString(categorias);
        response.setContentType("application/json");
        response.getWriter().append(categoriaStr);
   }
}
