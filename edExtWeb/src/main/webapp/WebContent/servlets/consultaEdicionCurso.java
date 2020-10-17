package main.webapp.WebContent.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import datatypes.*;
import exepciones.EdicionExcepcion;
import exepciones.UsuarioExcepcion;
import interfaces.fabrica;
import interfaces.*;

/**
 * Servlet implementation class consultaEdicion
 */
@WebServlet("/consultaEdicionCurso")
public class consultaEdicionCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public consultaEdicionCurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fabrica fab = fabrica.getInstancia();
		IcontroladorCurso icon = fab.getIcontroladorCurso();
		IcontroladorUsuario iconu = fab.getIcontroladorUsuario();
		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
		
		//HttpSession session = request.getSession();
		String edicion = request.getParameter("edicion");
		Date today = Calendar.getInstance().getTime();
		DTEdicionCurso dte = null;
		
		try {
			dte = icon.verInfoEdicion(edicion);
			//previas y categorias no se precisan
			String fechaI = format.format(dte.getFechaI());
			String fechaF = format.format(dte.getFechaF());
			String fechaPub = format.format(dte.getFechaPub());
			ArrayList<String> docentes = dte.getDocentes();
			request.setAttribute("nombre", dte.getNombre());
			request.setAttribute("cupo", dte.getCupo());
			request.setAttribute("fechaI", fechaI);
			request.setAttribute("fechaF", fechaF);
			request.setAttribute("fechaPub", fechaPub);
			Boolean esVigente = false;
			if (dte.getFechaF().after(today)) 
				esVigente = true; 
			request.setAttribute("vigencia", esVigente);
			//session.setAttribute("docentes", docentes);
			//obtiene una lista con el nombre, apellido y nickname de los docentes
			ArrayList<String> listDoc = new ArrayList<>();
			for(String s: docentes) {
				try {
					DTDocente dtd = (DTDocente) iconu.verInfoUsuario(s);
					String nombreCompleto = dtd.getNombre() + " " + dtd.getApellido() + ", " + dtd.getNick();
					listDoc.add(nombreCompleto);
				} catch (UsuarioExcepcion e) {
					//no existe usuario
					e.printStackTrace();
				}
			}
			request.setAttribute("docentes", listDoc);
		} catch (EdicionExcepcion e) {
			//no existe edicion
			e.printStackTrace();
		}
				
		request.getRequestDispatcher("/infoEdicion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}