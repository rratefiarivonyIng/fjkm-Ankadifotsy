<%@ include file="/jsp/include.jsp" %>

<%@ include file="/header.jsp" %>

<!-- debut corps -->
<form name="rechercheNifCommand" id="rechercheNifCommand" method="post" action="rechercheDemandeNifAValider.htm">
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
	  <div class="title1" align="center" >Validation des demandes d'immatriculation au NIF</div>	  
	    <table width="100%"  border="0">
          <tr>
          <spring:bind path="rechercheNifCommand.reference">
            <td width="18%">R&eacute;f&eacute;rence de la demande</td>
            <td width="61%">
              <input name="${status.expression}" type="text" id="${status.expression}" size="60" value="${status.value}"/>
            </td>
            <td width="21%">&nbsp;</td>
          </spring:bind>
          </tr>
          <tr>
          <spring:bind path="rechercheNifCommand.raisonSociale">
            <td>Raison sociale </td>
            <td><input name="${status.expression}" type="text" id="${status.expression}" size="60" value="${status.value}"/></td>
          </spring:bind>
            <td><input name="rechercher" type="submit" id="rechercher" value="Rechercher"></td>
          </tr>
          <tr>
          <spring:bind path="rechercheNifCommand.nomCommercial">
            <td>Nom commercial </td>
            <td><input name="${status.expression}" type="text" id="${status.expression}" size="60" value="${status.value}" /></td>
            <td>&nbsp;</td>
          </spring:bind>
          </tr>
          <tr>
          <spring:bind path="rechercheNifCommand.adresse">
            <td>Adresse </td>
            <td><input name="${status.expression}" type="text" id="${status.expression}" size="60" value="${status.value}" /></td>
            <td>&nbsp;</td>
          </spring:bind>
          </tr>
          <tr>
          <spring:bind path="rechercheNifCommand.cin">
            <td>CIN </td>
            <td><input name="${status.expression}" type="text" id="${status.expression}" size="60" value="${status.value}" /></td>
            <td>&nbsp;</td>
          </spring:bind>
          </tr>
          <tr>
          <spring:bind path="rechercheNifCommand.rc">
            <td>Registre de commerce </td>
            <td><input name="${status.expression}" type="text" id="${status.expression}" size="60" value="${status.value}" /></td>
            <td>&nbsp;</td>
          </spring:bind>
          </tr>
          <tr>
            <td colspan="3"><table width="100%" class="tabliste">
              <tr>
                <td class="tabcaption"><p align="center">R&eacute;f Demande </p></td>
                <td class="tabcaption">Raison sociale </td>
                <td class="tabcaption">Nom commerciale </td>
                <td class="tabcaption">Centre</td>
                <td class="tabcaption">Situation</td>
                <td>&nbsp;</td>
              </tr>
		      <c:forEach var="contribuable" items="${rechercheNifCommand.resultats}" varStatus="stats">
				<c:if test="${stats.count % 2 == 0}">
					<tr>
		                <td class="tabcontenu">${contribuable.taxPayerNo}</td>
		                <td class="tabcontenu">${contribuable.raisonSociale}</td>
		                <td class="tabcontenu">${contribuable.firstEtablissement.nomCommercial}</td>
		                <td class="tabcontenu">${contribuable.firstEtablissement.centreFiscal.intitule}</td>
		                <td class="tabcontenu">${contribuable.etat.intitule}</td>
				        <td class="tabcontenu"><a href="validationDemandeNif.htm?id=${contribuable.taxPayerNo}">S&eacute;lectionner</a></td>
			        </tr>
				</c:if>
				<c:if test="${stats.count % 2 != 0}">
		      		<tr>
				        <td class="tabcontenu" bgcolor="#FFFFCC">${contribuable.taxPayerNo}</td>
				        <td class="tabcontenu" bgcolor="#FFFFCC">${contribuable.raisonSociale}</td>
				        <td class="tabcontenu" bgcolor="#FFFFCC">${contribuable.firstEtablissement.nomCommercial}</td>
				        <td class="tabcontenu" bgcolor="#FFFFCC">${contribuable.firstEtablissement.centreFiscal.intitule}</td>
				        <td class="tabcontenu" bgcolor="#FFFFCC">${contribuable.etat.intitule}</td>
				        <td class="tabcontenu" bgcolor="#FFFFCC"><a href="validationDemandeNif.htm?id=${contribuable.taxPayerNo}">S&eacute;lectionner</a></td>
		      		</tr>
				</c:if>
		      </c:forEach>
            </table>
            </td>
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
	<tr>
	  <td><table width="100%"  border="0" align="center">
        <tr>
          <td><p align="center"><a href="listeContribuables.htm?etat=1">Demandes en cours de V&eacute;rification </a></p></td>
          <td><p align="center"><a href="listeContribuables.htm?etat=3">Demandes Rejet&eacute;es </a></p></td>
          <td><p align="center"><a href="listeContribuables.htm?etat=4">Demandes Acceptables </a></p></td>
        </tr>
      </table>	  <p>&nbsp;</p></td>
	  </tr>
</table>
</form>
<!-- fin corps -->

<%@ include file="/footer.jsp" %>