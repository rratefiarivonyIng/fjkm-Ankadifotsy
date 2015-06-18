<%@ include file="/jsp/include.jsp" %>

<%@ include file="/header.jsp" %>

<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/scripts/printing.js"></script>

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
	  <div class="title1" align="center" >La Demande de Réimmatriculation a été validée !</div>
	  <p></p>
	  <form name="form1" method="put" action="imprimerNif.htm">
	    <table width="70%"  border="0" align="center">
          <tr>
            <td width="34%">R&eacute;f&eacute;rence de la demande</td>
            <td colspan="2">
              <input name="reference" type="text" id="nif" size="60" value="${reference}" disabled="true"/>
            </td>
          </tr>
          <tr>
            <td>Raison social </td>
            <td colspan="2"><input name="raisonsociale" type="text" id="raisonsociale" size="60" value="${raisonSociale}" disabled="true"/></td>
          </tr>
          <tr>
            <td>Nom commercial </td>
            <td colspan="2"><input name="nomcommercial" type="text" id="nomcommercial" size="60" value="${nomCommercial}" disabled="true"/></td>
          </tr>
          <tr>
            <td>Ancien NIF </td>
            <td colspan="2"><input name="ancienNif" type="text" id="ancienNif" size="60" value="${ancienNif}" disabled="true"/></td>
          </tr>
          <tr>
            <td>Mot de passe </td>
            <td colspan="2"><input name="motDePasse" type="text" id="motDePasse" size="60" value="${motDePasse}" disabled="true"/></td>
          </tr>
          <tr>
            <td height="27" colspan="3" class="title1"><div class="boxmarque">Numéro d’Identification Fiscale (NIF) :<br>${nif}</div></td>
          </tr>
          <tr>          
            <td height="27"><input class="inputcenter" name="ImprimerAttestation" type="button" value="Imprimer Attestation d’immatriculation" onclick="javascript:printAttestation('${nif}','${taxPayerNo}');" /></td>
            <td height="27">&nbsp;</td>
            <td height="27"><input class="inputcenter" name="ImprimerFiche" type="button" value="Imprimer Fiche des Renseignements" onclick="javascript:printFicheRenseignement('${nif}','${taxPayerNo}');"></td>
          </tr>
        </table>
        <input name="nif" type="hidden" id="nif" size="60" value="${nif}" />
        <input name="taxPayerNo" type="hidden" id="taxPayerNo" size="60" value="${reference}" />
	  </form>	  
	  </td>
	</tr>
</table>
<!-- fin corps -->

<%@ include file="/footer.jsp" %>