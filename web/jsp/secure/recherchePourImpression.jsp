<%@ include file="/jsp/include.jsp" %>

<%@ include file="/header.jsp" %>

<!-- debut corps -->
<form name="rechercheNifCommand" id="rechercheNifCommand" method="post" action="recherchePourImpression.htm">
<table width="100%">
	<tr>
	  <td>
		<ul id="tabnav">
			<li><a href="index.htm">Mpivavaka</a></li>
			<li><a class="onglet" href="index.htm?sampana">Sampana</a></li>
			<li><a class="onglet" href="index.htm?diakona">Diakona</a></li>
			<li class="active"><a class="onglet" href="index.htm?administration">Administration</a></li>
			<% if (org.acegisecurity.context.SecurityContextHolder.getContext().getAuthentication() != null) {%>
			<li id="disconnect"><a href="<%=request.getContextPath()%>/logout.jsp">Déconnecter</a></li>
			<%}%>
		</ul>
	<p></p>
	  <div class="title1" align="center" >Validation des Mises à Jour des Contribuables</div>	  
	    <table width="100%"  border="0">
          <tr>
          <spring:bind path="rechercheNifCommand.nif">
            <td width="15%">NIF &nbsp;&nbsp;&nbsp;&nbsp; :</td>
            <td width="45%"><input class="inputleft" name="${status.expression}" type="text" id="${status.expression}" size="25" value="${status.value}" />&nbsp;&nbsp;&nbsp;&nbsp;N NNN NNN NNN</td>
          </spring:bind>
            <td width="40%"><input class="inputleft" name="rechercher" type="submit" id="rechercher" value="Rechercher"></td>
          </tr>
          <tr>
            <td colspan="3">
            <c:if test="${not empty rechercheNifCommand.message}" >
              <div align="center"><font color="red" size="1.3">${rechercheNifCommand.message}</font></div>
            </c:if>
            </td>
          </tr>          
        </table>	  
	  </td>
	</tr>
</table>
</form>
<!-- fin corps -->

<%@ include file="/footer.jsp" %>