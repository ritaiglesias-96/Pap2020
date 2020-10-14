<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@include  file="defaultHeader.jsp" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@page import="java.util.ArrayList"%>
    <div class="main">
        <br><br>

        <div class="container">
        
            <div class="row">
	            <div class="input-field col s6" >
	                <select name="institutos" id="institutos" onchange="obtenerCursosPorInstituto(institutos.value)">
	                    <option value="" disabled >Seleccione uno</option>
	                </select>
	                <label>Instituto</label>
	            </div>
	            
	            <div class="input-field col s6" >
	                <select name="categorias" id="categorias" onchange="obtenerCursosPorCategoria(categorias.value)">
	                    <option value="" disabled >Seleccione uno</option>
	                </select>
	                <label>Categorias</label>
	            </div>
	            
                <!-- CARD CONSULTA CURSO-->
				<div class="col s12 m5">
                    <div class="card teal darken-4">
                        <div class="card-content white-text">
                            <span class="card-title">Cursos</span>
                        </div>
                        <ul class="collection" name="curso" id="curso">
                                <c:forEach var="cur" items="${curso}">
                                    <li class="collection-item"><div>${cur}<a href="consultaCurso?curso=${cur}" class="secondary-content"><i class="material-icons">send</i></a></div></li>
                                </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
<script type="text/javascript">

	$(document).ready(function () {
	    $('#institutos').formSelect();
	    $('#categorias').formSelect();
	 });
	
</script>
    <script src="resources/scripts/listas.js"> </script>
    <%@include  file="footer.jsp" %>
   