package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.ArrayList;

import interfaces.fabrica;
import interfaces.IcontroladorCurso;
import exepciones.CursoExcepcion;
import exepciones.InstitutoExcepcion;

/**
 * Servlet implementation class altaCurso
 */
@WebServlet("/altaCurso")
public class altaCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public altaCurso() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fabrica fab = fabrica.getInstancia();
		IcontroladorCurso icon = fab.getIcontroladorCurso();
				
		//datos del curso
		//SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("desc");
		String duracion = request.getParameter("duracion");
		int cantHoras = Integer.parseInt(request.getParameter("cantHoras"));
		int creditos = Integer.parseInt(request.getParameter("creditos"));
		Date fechaR = new Date();
		String url = request.getParameter("url");
		String instituto = request.getParameter("instituto");
		//getParameterValues se usa para sacar un array de strings
		String[] previas = request.getParameterValues("previas");
		String[] categorias = request.getParameterValues("categorias");
		
		ArrayList<String> listPrevias = new ArrayList<>();
		for(String s: previas) {
			listPrevias.add(s);
		}
		ArrayList<String> listCategorias = new ArrayList<>();
		for(String su: categorias) {
			listCategorias.add(su);
		}
		
		try {
			icon.AltaCurso(nombre, descripcion, duracion, cantHoras, creditos, fechaR, url, instituto, listPrevias, listCategorias);
			request.setAttribute("mensaje", "El curso " + nombre + " se ha ingresado correctamente en el sistema.");
		} catch (CursoExcepcion e) {
			request.setAttribute("mensaje", "El curso de nombre " + nombre + " ya existe en el sistema.");
			e.printStackTrace();
		} catch (InstitutoExcepcion e) {
			request.setAttribute("mensaje", "El instituto de nombre " + instituto + " no existe en el sistema.");
			e.printStackTrace();
		}
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
	}
}
