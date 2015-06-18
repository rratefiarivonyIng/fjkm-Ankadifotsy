<%@ include file="/jsp/include.jsp" %>

<%@ include file="/header.jsp" %>

<!-- debut corps -->
<table align="center">
   <tr>
	 <td>
	  <%@ include file="/onglet.jsp" %>
	 </td>
   </tr>
   
   <tr>
     <td>
	  <div class="title1">Voatokana ho an'ny Administrateur</div>
     </td>
   </tr>
   
   <tr>
     <td>&nbsp;</td>
   </tr>
     
   <tr>
     <td>
	  <ol>
		<div>Eto ianao dia afaka :
		<li>Mampiditra fitandremana</li>
		<li>Mampiditra Taom-panompoana</li>
		<li>Mampiditra firaisana</li>
		<li>Mampiditra faritra</li>
		<li>Mampiditra karazana anton'asa</li>
		<li><a href="manovaTenyMiafina.htm">Manova teny miafina</a></li>
		<li title="isan'ny valin'ny fitadiavana..."><a href="editParameter.htm">Mameno ny paramètres</a></li>
<%		
		if (Utils.isLoggedUserAdmin()){
%>
		<li title="Manome alalana IP vaovao ..."><a href="<%=request.getContextPath()%>/admin/ip.htm">Mikirakira IP ...</a></li>
<%
		}
%>
		</div>
	  </ol>
     </td>
   </tr>
</table>
<!-- fin corps -->

<%@ include file="/footer.jsp" %>