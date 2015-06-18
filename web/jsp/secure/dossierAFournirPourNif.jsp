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
	  <div class="title1" align="center" ><strong>Dossiers &agrave; fournir pour l'obtention du NIF </strong> </div>
	  <div class="normal">
	    <p>&#149;&nbsp; <em>Copie de la CIN (personne physique ou g&eacute;rant de la soci&eacute;t&eacute;), ou Carte de r&eacute;sident pour les &eacute;trangers </em></p>
	    <p>&#149;&nbsp; <em>R&eacute;c&eacute;piss&eacute; et bordereau de versement de l'imp&ocirc;t synth&eacute;tique ou de l'acompte provisionnel, </em></p>
	    <p>&#149;&nbsp; <em>Copie de la carte statistique, </em></p>
	    <p>&#149;&nbsp; <em>Statuts, PV de modification des statuts, Acte constitutif, </em></p>
	    <p>&#149;&nbsp; <em>Certificat de r&eacute;sidence (du propri&eacute;taire ou du g&eacute;rant) </em></p>
	    <p>&#149;&nbsp; <em>Certificat d'existence (entreprise ou soci&eacute;t&eacute;) </em></p>
	    <p>&#149;&nbsp; <em>Fiche d'identification des entreprises </em></p>
	    <p>&#149;&nbsp; <em>… (carte grise, licence, autorisation minist&eacute;rielle,) … </em></p>
	  </div>
	  </td>
	</tr>
</table>
<!-- fin corps -->

<%@ include file="/footer.jsp" %>