package main.webapp.WebContent.servlets.altas;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import main.webapp.WebContent.resources.dataType.DTResponse;
import publicadores.*;

@WebServlet("/altaEdicion")
public class altaEdicion extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DTResponse respuesta = new DTResponse();
        ControladorCursoPublishService cup = new ControladorCursoPublishServiceLocator();

        //datos del curso
        //SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
        String nombre = request.getParameter("nombre");
        Date today = Calendar.getInstance().getTime();
        Calendar calT = Calendar.getInstance();
        calT.setTime(today);
        long fI = Date.parse(request.getParameter("fechaI"));
        Date fechaI = new Date(fI);
        Calendar calI = Calendar.getInstance();
        calI.setTime(fechaI);
        long fF = Date.parse(request.getParameter("fechaF"));
        Date fechaF = new Date(fF);
        Calendar calF = Calendar.getInstance();
        calF.setTime(fechaF);

        String instituto = request.getParameter("instituto");
        String cursos = request.getParameter("cursos");

        String[] docentes = request.getParameter("docentes").split(",");
        Integer cupo = Integer.parseInt(request.getParameter("cupo"));
        String imagen = request.getParameter("imagen");

        System.out.println(nombre);
        System.out.println(instituto);
        System.out.println(imagen);

        try {
            ControladorCursoPublish port = cup.getcontroladorCursoPublishPort();
            if (nombre.equals("") || cupo == 0) {
                respuesta.setCodigo(1);
                respuesta.setMensaje("No puede haber campos vacios");
                request.setAttribute("mensaje", "No puede haber campos vacios");
            } else if (today.compareTo(fechaF) > 0) {
                respuesta.setCodigo(1);
                respuesta.setMensaje("Ingresar una fecha de fin valida");
                request.setAttribute("mensaje", "Ingresar una fecha de fin valida");
            } else if (fechaF.before(fechaI)) {
                respuesta.setCodigo(1);
                respuesta.setMensaje("La fecha de inicio debe ser previa a la de finalizacion");
                request.setAttribute("mensaje", "La fecha de inicio debe ser previa a la de finalizacion");
            } else if (instituto.equals("")) {
                respuesta.setCodigo(1);
                respuesta.setMensaje("Debe seleccionar un instituto para dar de alta a la edicion");
                request.setAttribute("mensaje", "Debe seleccionar un instituto para dar de alta a la edicion");
            } else if (cursos.equals("")) {
                respuesta.setCodigo(1);
                respuesta.setMensaje("Debe seleccionar un curso para dar de alta a la edicion");
                request.setAttribute("mensaje", "Debe seleccionar un curso para dar de alta a la edicion");
            } else if (docentes.equals("")) {
                respuesta.setCodigo(1);
                respuesta.setMensaje("Debe ingresar al menos un docente para dar de alta a la edicion");
                request.setAttribute("mensaje", "Debe ingresar al menos un docente para dar de alta a la edicion");
            } else {
                try {
                    port.nuevosDatosEdicion(nombre, calI, calF, cupo, calT, cursos, docentes, imagen);
                    respuesta.setCodigo(0);
                    respuesta.setMensaje("La edicion " + nombre + " se ha ingresado correctamente en el sistema.");
                    request.setAttribute("mensaje", "La edicion " + nombre + " se ha ingresado correctamente en el sistema.");
                } catch (EdicionExcepcion edicionExcepcion) {
                    request.setAttribute("mensaje", "La edicion " + nombre + " ya existe en el sistema.");
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("La edicion " + nombre + " ya existe en el sistema.");
                    respuesta.setElemento("nombre");
                    edicionExcepcion.printStackTrace();
                } catch (CursoExcepcion cursoExcepcion) {
                    request.setAttribute("mensaje", "El curso " + nombre + " no existe en el sistema.");
                    respuesta.setCodigo(1);
                    respuesta.setElemento("curso");
                    respuesta.setMensaje("El curso " + nombre + " no existe en el sistema.");
                    cursoExcepcion.printStackTrace();
                }
            }
            ObjectMapper mapper = new ObjectMapper();
            String cursoStr = mapper.writeValueAsString(respuesta);
            response.setContentType("application/json");
            response.getWriter().append(cursoStr);

        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

}
