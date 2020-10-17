<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="datatypes.DTEdicionCurso" %>
<%@ page import="interfaces.fabrica" %>
<%@ page import="interfaces.IcontroladorUsuario" %>

<%@ page import="controladores.controladorCurso" %>
<%@ page import="datatypes.DTUsuario" %>
<%@ page import="org.apache.taglibs.standard.tei.DeclareTEI" %>
<%@ page import="datatypes.DTEstudiante" %>
<%@ page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Mi Perfil</title>
    <% if (session.getAttribute("tipoUser")=="docente"){ %>
    <%@include file="defaultHeader.jsp"%>
    <%}else{ %>
    <%@include file="headerEstVis.jsp"%>
    <%}%>
</head>

<body>
    <!--GET-ATRIBUTOS USUARIO-->
    <%
      //ver la imagen\
        HttpSession ses = request.getSession();
      String nickname = (String) ses.getAttribute("nickname");
      String nombre = (String) ses.getAttribute("nombre");
      String apellido = (String) ses.getAttribute("apellido");
      String correo = (String) ses.getAttribute("correo");
      Date fechaN = (Date) ses.getAttribute("fechaNac");

      SimpleDateFormat fechaNa = new SimpleDateFormat("yyyy/MM/dd");
      String fechaNac = fechaNa.format(fechaN);

  	  String tipo = (String) ses.getAttribute("tipoUser");
  	  if(tipo.equals("estudiante")) {
          ArrayList<String> programas = (ArrayList<String>) ses.getAttribute("programas");
      }
      fabrica fab = fabrica.getInstancia();
      IcontroladorUsuario icon = fab.getIcontroladorUsuario();
      String selectedEdi = new String();
    %>
    <div class="main">
        <br><br>
        <div class="container">
            <div class="row">
                <!-- CARD USUARIO-->
                <div class="col s12 m3">
                    <div class="card">
                        <div class="card-image">
                        	 <!-- IMAGEN DEL USUARIO-->
                            <img src="resources/images/img4.jpg">
                        </div>
                        <!-- COLLAPSIBLE USUARIO -->
                        <ul class="collapsible">
                            <%if (tipo.equals("estudiante")){%>
                            <li>
                                <div class="collapsible-header  yellow darken-4">
                                    <i class="material-icons">account_circle</i>Mi Perfil
                                </div>
                                <div class="collapsible-body">
                                    <p><a href="modificarDatosUsuario.jsp" type="button" onclick="window.location = 'http://localhost:8080/edExtWeb/modificarDatosUsuario.jsp'">Modificar Datos</a></p>
                                </div>
                            </li>
                            <li>
                                <div class="collapsible-header lime"><i class="material-icons">book</i>Inscribirme</div>
                                <div class="collapsible-body">
                                    <div class="row">
                                        <p><a href="consultaEdicion.jsp">Inscribirme a Edicion de curso</a></p>
                                        <p><a href="consultaPrograma.jsp">Inscribirme a Programa de Formacion</a></p>
                                    </div>
                                </div>
                            </li>
                        </div>
                            <%}else if(tipo.equals("docente")){%>
                            <li>
                                <div class="collapsible-header  yellow darken-4"><i
                                        class="material-icons">account_circle</i>Mi Perfil
                                </div>
                                <div class="collapsible-body">
                                    <p><a href="modificarDatosUsuario.jsp">Modificar Datos</a></p>
                                </div>
                            </li>
                            <li>
                                <div class="collapsible-header lime"><i class="material-icons">book</i>Ediciones</div>
                                <div class="collapsible-body">
                                    <div class="row">
                                        <p><a href="<%//listarAceptadosEdicionesdecurso.jsp%>">Ver Resultados</a></p>
                                    </div>
                                </div>
                            </li>
                            </div>
                            <%}%>
                        </ul>
                    </div>
                <div class="col s12 m9">
                	<!-- TAB DE INFORMACION-->
                    <div id="cardInfo" class="card">
                        <div class="card-content">
                            <p>I am a very simple card. I am good at containing small bits of information. I am
                                convenient because I require little markup to use effectively.</p>
                        </div>
                        <div class="card-tabs">
                            <ul class="tabs tabs-fixed-width">
                                <li class="tab" class="active"><a href="#test1">Datos</a></li>
                                <li class="tab"><a href="#test2">Social</a></li>
                                <li class="tab"><a href="#test3">Cursos</a></li>
                                <%if(tipo.equals("estudiante")){ %>
                                <li class="tab"><a href="#test4">Programas</a></li>
                                <%} %>
                            </ul>
                        </div>
                        <div class="card-content ">
                        <!-- DATOS USUARIO -->
                            <div id="test1">
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Nickname
                                    </div>
                                    <div class="col s7 grey-text text-darken-4 right-align"><%=nickname%></div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Nombre</div>
                                    <div class="col s7 grey-text text-darken-4 right-align"><%=nombre%></div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Apellido
                                    </div>
                                    <div class="col s7 grey-text text-darken-4 right-align"><%=apellido %></div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Email</div>
                                    <div class="col s7 grey-text text-darken-4 right-align"><%=correo %></div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de
                                        Nacimiento</div>
                                    <div class="col s7 grey-text text-darken-4 right-align"><%=fechaNac %></div>
                                </div>
                            </div>
                            <!-- SEGUIDORES Y SEGUIDOS -->
                            <div id="test2">
                                <ul class="collection with-header">
                                    <li class="collection-header">
                                        <h10>Seguidos</h10>
                                    </li>
                                    <li class='collection-item'>
                                        <a class="btn-floating btn-small "><i class="material-icons">delete</i></a>
                                        Alvin
                                    </li>

                                </ul>
                                <ul class="collection with-header">
                                    <li class="collection-header">
                                        <h10>Seguidores</h10>
                                    </li>
                                    <li class='collection-item'>
                                        <a class="btn-floating btn-small "><i class="material-icons">person_add</i></a>
                                        Alvin
                                    </li>
                                    <%
											//for (DTUsuario s : seguidores){ 
											//out.print("<li class='collection-item'>>"+s.getNick()+"</li>");
								 			//}
										%>
                                </ul>
                                <%//}%>
                            </div>
                            <!--GET-EDICIONES-->
                            <div id="test3">
                                <div class="row">
                                    <div class="input-field col s12">
                                        <%if(tipo.equals("estudiante")){ %>
                                        <select id="edicion" name="edicion" onchange="getDatosEdicion(edicion.value)" >
                                            <option value="" disabled selected >Seleccionar una edicion</option>
                                            <c:forEach var="ed" items="${edicionesNombres}">
                                                <option value="${ed}">${ed}</option>
                                            </c:forEach>
                                        </select>
                                        <label>Inscripciones a Ediciones de Cursos</label>
                                        <%}else if(tipo.equals("docente")){%>
                                        <select id="edicion" name="edicion" onchange="getDatosEdicion(edicion.value)" >
                                            <option value="" disabled selected >Seleccionar una edicion</option>
                                            <c:forEach var="ed" items="${ediciones}">
                                                <option value="${ed}">${ed}</option>
                                            </c:forEach>
                                        </select>
                                        <label>Ediciones de Cursos Asociados</label>
                                        <%} %>
                                    </div>
                                </div>
                                <%
                                 %>

                                <div id="infoSelecEdi">
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Nombre</div>
                                    <div class="col s7 grey-text text-darken-4 right-align"></div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de
                                        Inicio</div>
                                    <div class="col s7 grey-text text-darken-4 right-align"></div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de Fin
                                    </div>
                                    <div class="col s7 grey-text text-darken-4 right-align"></div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de
                                        Publicacion</div>
                                    <div class="col s7 grey-text text-darken-4 right-align"></div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Cupo</div>
                                    <div class="col s7 grey-text text-darken-4 right-align"></div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Curso</div>
                                    <div class="col s7 grey-text text-darken-4 right-align"></div>
                                </div>
                            </div>
                            </div>
							<!--GET- PROGRAMAS DE FORMACION-->
                            <%if (tipo.equals("estudiante")){%>
                            <div id="test4">
                                <div class="row">
                                    <div class="input-field col s12">
                                        <!--GET-PROGRAMAS-->
                                        <select id="programas" name="programa" onchange="getDatosPrograma(programa.value)">
                                            <option value="" disabled selected>Seleccionar un programa</option>
                                            <c:forEach var="pro" items="${programasNombres}">
                                                <option value="${pro}">${pro}</option>
                                            </c:forEach>
                                        </select>

                                        <label>Inscripciones a Programas de Formacion</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <!--imagen del programa-->
                                    <img src="resources/images/asd.jpg" sizes="[class]= card-content" style="width: 400px;height: 300px;padding-left: 100px;">
                                </div>
                                <div id="infoSelectedProg">
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Nombre</div>
                                    <div class="col s7 grey-text text-darken-4 right-align"></div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Descripcion
                                    </div>
                                    <div class="col s7 grey-text text-darken-4 right-align"></div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de
                                        Inicio</div>
                                    <div class="col s7 grey-text text-darken-4 right-align"></div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de Fin
                                    </div>
                                    <div class="col s7 grey-text text-darken-4 right-align"></div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de Alta
                                    </div>
                                    <div class="col s7 grey-text text-darken-4 right-align"></div>
                                </div>
                                </div>
                            </div>
                            <%}%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="footer.jsp" %>

<script type="text/javascript">
    document.addEventListener('DOMContentLoaded', function () {
        var elems = document.querySelectorAll('.collapsible');
        var instances = M.Collapsible.init(elems);
    });
</script>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        var elems = document.querySelectorAll('select');
        var instances = M.FormSelect.init(elems);
    });
</script>
<script type="text/javascript">
    $(document).ready(function () {
        $('.tabs').tabs();
    });
</script>
    <script>
        function getDatosPrograma(nombre){
            var baseURL = 'http://localhost:8081/edExtWeb/';

            var url = baseURL +`GetDatosPrograma?nombre=`+ nombre;

            fetch(url)
                .then((res)=>{
                    return res.json();
                }).then((progSelected) => {
                var progHtml = document.getElementById("infoSelectedProg");
                console.log(progSelected)

                JSON.stringify(progSelected);

                var fechaInicio = new Date(progSelected.fechaI).toLocaleDateString();
                var fechaFin = new Date(progSelected.fechaF).toLocaleDateString();
                var fechaAlta = new Date(progSelected.fechaA).toLocaleDateString();


                    progHtml.innerHTML =`<div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Nombre</div>`;
                    progHtml.innerHTML +=`<div class="col s7 grey-text text-darken-4 right-align">` + progSelected.nombre +`</div>`;
                    progHtml.innerHTML +=`</div>`;
                progHtml.innerHTML +=`<div class="row">`;
                progHtml.innerHTML +=`<div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Descripcion</div>`;
                progHtml.innerHTML +=`<div class="col s7 grey-text text-darken-4 right-align">` + progSelected.descripcion + `</div>`;
                progHtml.innerHTML +=`</div>`;
                progHtml.innerHTML +=`</div>`;
                progHtml.innerHTML +=`<div class="row">`;
                    progHtml.innerHTML +=`<div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de Inicio</div>`;
                    progHtml.innerHTML +=`<div class="col s7 grey-text text-darken-4 right-align">`+ fechaInicio +`</div>`;
                    progHtml.innerHTML +=`</div>`;
                progHtml.innerHTML +=`<div class="row">`;
                    progHtml.innerHTML +=`<div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de Fin`;
                    progHtml.innerHTML +=`</div>`;
                    progHtml.innerHTML +=`<div class="col s7 grey-text text-darken-4 right-align">` + fechaFin + `</div>`;
                    progHtml.innerHTML +=`</div>`;
                progHtml.innerHTML +=`<div class="row">`;
                    progHtml.innerHTML +=`<div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de Alta</div>`;
                    progHtml.innerHTML +=`<div class="col s7 grey-text text-darken-4 right-align">` + fechaAlta +`</div>`;
                    progHtml.innerHTML +=`</div>`;
                progHtml.innerHTML +=`<div class="row">`;
                    progHtml.innerHTML +=`<div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Cupo</div>`;
                    progHtml.innerHTML +=`<div class="col s7 grey-text text-darken-4 right-align">` + progSelected.cupo +`</div>`;
                    progHtml.innerHTML +=`</div>`;

            })
        }
    </script>
    <script>
        function getDatosEdicion(nombre){
            var baseURL = 'http://localhost:8081/edExtWeb/';

            var url = baseURL +`GetDatosEdicion?nombre=`+ nombre;

            fetch(url)
                .then((res)=>{
                    return res.json();
                }).then((ediSelected) => {
                var edicionHtml = document.getElementById("infoSelecEdi");
                console.log(ediSelected)


                JSON.stringify(ediSelected);

                var fechaInicio = new Date(ediSelected.fechaI).toLocaleDateString();
                var fechaFin = new Date(ediSelected.fechaF).toLocaleDateString();
                var fechaPublic = new Date(ediSelected.fechaPub).toLocaleDateString();

                edicionHtml.innerHTML = `<div class="row">`;
                edicionHtml.innerHTML +=`<div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Nombre</div>`;
                edicionHtml.innerHTML +=`<div class="col s7 grey-text text-darken-4 right-align">` + ediSelected.nombre +`</div>`;
                edicionHtml.innerHTML +=`</div>`;
                edicionHtml.innerHTML +=`<div class="row">`;
                edicionHtml.innerHTML +=`<div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de Inicio</div>`;
                edicionHtml.innerHTML +=`<div class="col s7 grey-text text-darken-4 right-align">`+ fechaInicio +`</div>`;
                edicionHtml.innerHTML +=`</div>`;
                edicionHtml.innerHTML +=`<div class="row">`;
                edicionHtml.innerHTML +=`<div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de Fin`;
                edicionHtml.innerHTML +=`</div>`;
                edicionHtml.innerHTML +=`<div class="col s7 grey-text text-darken-4 right-align">` + fechaFin + `</div>`;
                edicionHtml.innerHTML +=`</div>`;
                edicionHtml.innerHTML +=`<div class="row">`;
                edicionHtml.innerHTML +=`<div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de Publicacion</div>`;
                edicionHtml.innerHTML +=`<div class="col s7 grey-text text-darken-4 right-align">` + fechaPublic +`</div>`;
                edicionHtml.innerHTML +=`</div>`;
                edicionHtml.innerHTML +=`<div class="row">`;
                edicionHtml.innerHTML +=`<div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Cupo</div>`;
                edicionHtml.innerHTML +=`<div class="col s7 grey-text text-darken-4 right-align">` + ediSelected.cupo +`</div>`;
                edicionHtml.innerHTML +=`</div>`;
                edicionHtml.innerHTML +=`<div class="row">`;
                edicionHtml.innerHTML +=`<div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Curso</div>`;
                edicionHtml.innerHTML +=`<div class="col s7 grey-text text-darken-4 right-align">` +ediSelected.nomCurso + `</div>`;
                edicionHtml.innerHTML +=`</div>`;

            })
        }
    </script>
</body>

</html>