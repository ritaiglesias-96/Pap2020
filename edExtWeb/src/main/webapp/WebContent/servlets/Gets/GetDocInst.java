package main.webapp.WebContent.servlets.Gets;

import com.fasterxml.jackson.databind.ObjectMapper;
import interfaces.IcontroladorCurso;
import interfaces.fabrica;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/GetDocInst")
public class GetDocInst extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        fabrica fabrica = interfaces.fabrica.getInstancia();
        IcontroladorCurso icon = fabrica.getIcontroladorCurso();
        HttpSession session = request.getSession();

        try {
            String inst = request.getParameter("instituto");
            java.util.ArrayList<String> docentes = icon.listarDocentesInstituto(inst);
            System.out.println("instituto = " + inst);
            System.out.println("docentes = " + docentes);
            session.setAttribute("docentes", docentes);


            String docentesStr = mapper.writeValueAsString(docentes);
            System.out.println("	Los docentes que guardo son: " + docentesStr);

            response.setContentType("application/json");
            response.getWriter().append(docentesStr);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
