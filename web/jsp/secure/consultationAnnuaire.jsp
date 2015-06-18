<%@ include file="/jsp/include.jsp" %>

<%@ include file="/header.jsp" %>

<!-- debut corps -->
<table width="100%">
	<tr><td>
		<ul id="tabnav">
			<li class="active"><a href="index.htm">Mpivavaka</a></li>
			<li><a class="onglet" href="index.htm?sampana">Sampana</a></li>
			<li><a class="onglet" href="index.htm?diakona">Diakona</a></li>
			<li><a class="onglet" href="index.htm?administration">Administration</a></li>
			<% if (org.acegisecurity.context.SecurityContextHolder.getContext().getAuthentication() != null) {%>
			<li id="disconnect"><a href="<%=request.getContextPath()%>/logout.jsp">Mivoaka</a></li>
			<%}%>
		</ul>
	<p></p>
	  <div class="title1" align="center" >Consultation de l’Annuaire des NIF </div>
	  <p>&nbsp; </p>
	  <div>Cette fonction vous donne la possibilité de :
	  <ol>
		<li>Rechercher un contribuable par le NIF, la RAISON SOCIALE ou le NOM COMMERCIAL, </li>
		<li>Télécharger la Base des NIF, si vous en avez l’autorisation. </li>
	  </ol>
	  </div>
  <table width="100%"><td id="boxlink"  align="center"><a href="annuaireNif.htm">Annuaire</a></td>
  </tr></table>
  </td></tr>
</table>
<!-- fin corps -->


<%@ include file="/footer.jsp" %>