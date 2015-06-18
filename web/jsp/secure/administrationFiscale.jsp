<%@ include file="/jsp/include.jsp" %>

<%@ include file="/header.jsp" %>

<!-- debut corps -->
<table width="100%">
	<tr><td>
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
	  <div class="title1" align="center" >Réservé à l’Administration fiscale</div>
	  <p>Quelle tâche voulez-vous réaliser ? </p>
	  <div>
	    <ol>
		<li><a href="rechercheDemandeNifAValider.htm">Validation des Demandes d’Immatriculation au NIF</a>.</li>
		<li><a href="rechercheReImmatriculationAValider.htm">Validation des Demandes de Re-immatriculation du NIF</a>.</li>
		<li><a href="rechercheMiseAJourAValider.htm">Validation des mises à jour sur les renseignements des Contribuables</a></li>
		<li><a href="attributionMotDePasse.htm">Attribution de mot de passe d'un contribuable</a></li>
		<li><a href="recherchePourImpression.htm">Réimpression des formulaires</a></li>
	  </ol>
	  </div>
    <table width="100%">
      <tr>
        <td id="boxlink"  align="center"><a href="<%=request.getContextPath()%>/annuaireNif.htm">Annuaire</a></td>
        <td id="boxlink"  align="center"><a href="<%=request.getContextPath()%>/logout.jsp">Quitter</a></td>
      </tr>
    </table>
  </td></tr>
</table>
<!-- fin corps -->

<%@ include file="/footer.jsp" %>