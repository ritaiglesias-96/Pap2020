package main.webapp.WebContent.servlets.altas;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.webapp.WebContent.resources.dataType.DTResponse;

import interfaces.fabrica;
import interfaces.IcontroladorUsuario;
import exepciones.UsuarioExcepcion;


@WebServlet("/crearUsuario")
public class crearUsuario extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        fabrica fab = fabrica.getInstancia();
        IcontroladorUsuario icon = fab.getIcontroladorUsuario();
        SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
        //todo lo que se obtiene del frontend va en comillas
        //datos del usuario
        String nick = request.getParameter("nickName");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String passwd = request.getParameter("password");
        String imagen = request.getParameter("imagen");
        //cambia la string a un date
        long fN = Date.parse(request.getParameter( "fechaN"));
        Date fechaNac = new Date(fN);
        Date todayDate = Calendar.getInstance().getTime();

        DTResponse respuesta = new DTResponse();
        String tipoUser = request.getParameter("tipoUser");
        String instituto = request.getParameter("institutos");
        if(nick.equals("") || nombre.equals("") || apellido.equals("") || correo.equals("") || passwd.equals("")) {
            respuesta.setCodigo(1);
            respuesta.setMensaje("No puede haber campos vacios");
            request.setAttribute("mensaje", "No puede haber campos vacios");
        } if(!correo.contains("@")) {
            respuesta.setCodigo(1);
            respuesta.setMensaje("Debe ingresar una direccion de correo valida");
            request.setAttribute("mensaje", "Debe ingresar una direccion de correo valida");
        }else if(fechaNac.compareTo(todayDate) > 0){
            respuesta.setCodigo(1);
            respuesta.setMensaje("Debe ingresar una fecha de nacimiento valida");
            request.setAttribute("mensaje", "Debe ingresar una fecha de nacimiento valida");
        }else if(request.getParameter("tipoUser").equals("docente") && instituto.equals("")){
            respuesta.setCodigo(1);
            respuesta.setMensaje("Debe ingresar un instituto para dara de alta a un Docente");
            request.setAttribute("mensaje", "Debe ingresar un instituto para dara de alta a un Docente");
        } else if(tipoUser.equals("")){
            respuesta.setCodigo(1);
            respuesta.setMensaje("Debe ingresar un tipo de Usuario");
            request.setAttribute("mensaje", "Debe ingresar un tipo de Usuario");
        } else {
            try {
                icon.AltaUsuario(nick, nombre, apellido, correo, fechaNac, instituto, passwd, imagen);
                respuesta.setCodigo(0);
                respuesta.setMensaje("El usuario " + nick + " se ha ingresado correctamente en el sistema.");
                request.setAttribute("mensaje", "El usuario " + nick + " se ha ingresado correctamente en el sistema.");
            } catch (UsuarioExcepcion e) {
                respuesta.setCodigo(1);
                respuesta.setMensaje(e.getMessage());
                respuesta.setElemento("nickName");
                request.setAttribute("mensaje", "El usuario de nickname " + nick + " ya existe en el sistema.");
                e.printStackTrace();
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        String usuarioStr = mapper.writeValueAsString(respuesta);
        response.setContentType("application/json");
        response.getWriter().append(usuarioStr);


    }
}
