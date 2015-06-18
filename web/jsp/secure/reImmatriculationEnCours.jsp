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
	  <div class="title1" align="center" >Demandes de ré-immatriculation en cours de Vérification</div>
	 <p></p>
	    <table width="100%"  border="0">
          <tr>
            <td width="100%" colspan="3">
            <table width="100%"  border="1" class="tabliste">
              <tr>
                <td class="tabcaption" width="11%">NIF</td>
                <td class="tabcaption" width="11%">Référence</td>
                <td class="tabcaption" width="24%">Centre </td>
                <td class="tabcaption" width="23%">Raison sociale</td>
                <td class="tabcaption" width="20%">Act. Princ.</td>
                <td class="tabcaption" width="10%">Modifier</td>
              </tr>
		      <c:forEach var="contribuable" items="${contribuables}" varStatus="stats">
				<c:if test="${stats.count % 2 == 0}">
					<tr>
						<c:if test="${not empty contribuable.idContribuable}">
		                <td class="tabcontenu" >${contribuable.idContribuable}</td>
						</c:if>
						<c:if test="${empty contribuable.idContribuable}">
		                <td class="tabcontenu" >${contribuable.ancienNif}</td>
						</c:if>
		                <td class="tabcontenu">${contribuable.taxPayerNo}</td>
		                <td class="tabcontenu">${contribuable.firstEtablissement.centreFiscal.intitule}</td>
		                <td class="tabcontenu">${contribuable.raisonSociale}</td>
		                <td class="tabcontenu">${contribuable.activitePrincipale}</td>
		                <td class="tabcontenu"><a href="validationMiseAJour.htm?id=${contribuable.taxPayerNo}&reImmatriculation=1">modifier</a></td>
			        </tr>
				</c:if>
				<c:if test="${stats.count % 2 != 0}">
		      		<tr>
						<c:if test="${not empty contribuable.idContribuable}">
		                <td class="tabcontenu" bgcolor="#FFFFCC">${contribuable.idContribuable}</td>
						</c:if>
						<c:if test="${empty contribuable.idContribuable}">
		                <td class="tabcontenu" bgcolor="#FFFFCC">${contribuable.ancienNif}</td>
						</c:if>
		                <td class="tabcontenu" bgcolor="#FFFFCC">${contribuable.taxPayerNo}</td>
				        <td class="tabcontenu" bgcolor="#FFFFCC">${contribuable.firstEtablissement.centreFiscal.intitule}</td>
				        <td class="tabcontenu" bgcolor="#FFFFCC">${contribuable.raisonSociale}</td>
				        <td class="tabcontenu" bgcolor="#FFFFCC">${contribuable.activitePrincipale}</td>
				        <td class="tabcontenu" bgcolor="#FFFFCC"><a href="validationMiseAJour.htm?id=${contribuable.taxPayerNo}&reImmatriculation=1">modifier</a></td>
		      		</tr>
				</c:if>
		      </c:forEach>
	          <c:if test="${empty contribuables}">
	      		<tr>
			        <td colspan="6" align="center"><font color="red" size="1.2">Aucune demande de mise à jour trouvée.</font></td>
	      		</tr>
	          </c:if>
            </table>
            </td>
          </tr>
        </table>
	  </td>
	</tr>
	<tr>
	  <td><table width="100%"  border="0">
        <tr>
		  <table width="100%"  border="0">
	        <tr>
			  <td width="20%"><p>
			  <c:if test="${not empty contribuables}">
			    <a href="<%=request.getContextPath()%>/institution/resultat.csv?title=EnInstance">T&eacute;l&eacute;charger </a>
			  </c:if>
			  </p></td>          
	          <td width="80%">&nbsp;</td>
	        </tr>
	      </table>	  
        </tr>
      </table>	  
      </td>
	</tr>
</table>
<!-- fin corps -->

<%@ include file="/footer.jsp" %>