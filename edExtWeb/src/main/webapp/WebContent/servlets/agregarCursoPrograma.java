package main.webapp.WebContent.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Date;

import clases.ProgramaFormacion;
import com.fasterxml.jackson.databind.ObjectMapper;
import interfaces.fabrica;
import interfaces.IcontroladorCurso;
import main.webapp.WebContent.resources.dataType.DTResponse;

/**
 * Servlet implementation class inscripcionPrograma
 */
@WebServlet("/agregarCursoPrograma")
public class agregarCursoPrograma extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public agregarCursoPrograma() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fabrica fab = fabrica.getInstancia();
		IcontroladorCurso icon = fab.getIcontroladorCurso();
				
		String nomCurso = request.getParameter("curso");
		String nomPrograma = request.getParameter("programa");

		DTResponse respuesta = new DTResponse();

		try {
			icon.agregarCursoPrograma(nomCurso, nomPrograma);
			respuesta.setCodigo(0);
			respuesta.setMensaje("El curso " + nomCurso + " fue agregado al programa " + nomPrograma + " correctamente");
			request.setAttribute("mensaje", "El curso " + nomCurso + " fue agregado al programa " + nomPrograma + " correctamente");
		} catch (Exception e) {
			respuesta.setCodigo(1);
			respuesta.setMensaje("El curso " + nomCurso + " ya se encuentra en el programa " + nomPrograma);
			//algo no existe lol
			e.printStackTrace();
		}

		ObjectMapper mapper = new ObjectMapper();
		String inscriStr = mapper.writeValueAsString(respuesta);
		System.out.println("La respuesta generada es: " + inscriStr);

		response.setContentType("application/json");
		response.getWriter().append(inscriStr);
	}

}
