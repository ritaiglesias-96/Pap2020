package main.webapp.WebContent.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import interfaces.fabrica;
import main.webapp.WebContent.resources.dataType.DTResponse;
import interfaces.IcontroladorUsuario;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/seguirUsuario")
public class seguirUsuario extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DTResponse respuesta = new DTResponse();
		fabrica fab = fabrica.getInstancia();
		IcontroladorUsuario iconU = fab.getIcontroladorUsuario();
		
		HttpSession session = request.getSession();
		String nickUsuario = (String) session.getAttribute("nombreUser");
		String aSeguirNickname = request.getParameter("nicknameSeguir");
				
		iconU.comenzarSeguir(nickUsuario, aSeguirNickname);
		respuesta.setCodigo(0);
		respuesta.setMensaje("El usuario " + nickUsuario + " ha comenzado a seguir a " + aSeguirNickname + ".");
		request.setAttribute("mensaje", "El usuario " + nickUsuario + " ha comenzado a seguir a " + aSeguirNickname + ".");
		
		ObjectMapper mapper = new ObjectMapper();
		String programaStr = mapper.writeValueAsString(respuesta);
		response.setContentType("application/json");
		response.getWriter().append(programaStr);
	}

}
