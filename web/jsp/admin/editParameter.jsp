<%@ include file="/jsp/include.jsp" %>

<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>

<%@ include file="/header.jsp" %>

<script language="javascript">    
	function invalidateField(field){
		document.getElementById(field+'Label').value ='';
		document.getElementById(field).value ='';
	}
	
	function updateValidateButton(){
		var certifieCheckBox = document.getElementById('certifieCheckBox');
		document.getElementById('boutonValider').disabled = ! (certifieCheckBox.checked);		
	}
     	
</script>

<!-- debut corps -->

<!-- Le Div qui sert à afficher les bulles d'aide -->
<div id="curseur" class="infobulle"></div>
    
<table align="center" border="0">
  <tr>
	<td>
		<%@ include file="/onglet.jsp" %>
    </td>
  </tr>
    
  <tr>
    <td>
	  <div class="title1">Mikirakira ny "paramètres" : </div><br>
	</td>
  </tr>
  
  <tr>
    <td>
	<form id="formParameter" name="formParameter" method="post" action="editParameter.htm">
	<table width="90%" align="center" border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td>Isan'ny valin'ny fitadiavana isaky ny pejy *: </td>
	    <td>
         <spring:bind path="formParameter.nbElementPerPage">
	        <input class="inputleft" id="nbElementPerPageLabel" name="${status.expression}" type="text" size="22" value="${status.value}" />	
	        <font color="red" size="1.2">${status.errorMessage}</font>
         </spring:bind>
         </td>
	  </tr>
	  <tr>
	    <td>Isan'ny mpirotsaka fidiana isaky ny pejy *: </td>
	    <td>
         <spring:bind path="formParameter.nbMirotsakaFidianaPerPage">
	        <input class="inputleft" id="nbMirotsakaFidianaPerPage" name="${status.expression}" type="text" size="22" value="${status.value}" />	
	        <font color="red" size="1.2">${status.errorMessage}</font>
         </spring:bind>
         </td>
	  </tr>
	  <tr>
	    <td>Isan'ny vokatra vonjy maika *: </td>
	    <td>
         <spring:bind path="formParameter.nbTempResultVote">
	        <input class="inputleft" id="nbTempResultVoteLabel" name="${status.expression}" type="text" size="22" value="${status.value}" />	
	        <font color="red" size="1.2">${status.errorMessage}</font>
         </spring:bind>
         </td>
	  </tr>
	  
	  <tr>
	    <td align="right"><input name="Valider" class="button" id="boutonValider" value="Miverina" type="button" onclick="javascript: document.location='index.htm?<%=request.getSession().getAttribute(ConstantUtils.sfSelectedTab)%>';" /></td>
	    <td align="right"><input name="Valider" class="button" id="boutonValider" value="Alefa" type="submit" style="align:right"/></td>
	  </tr>
	</table>
    </form>
	  
    </td>
  </tr>
  
</table>

<!-- Message d'erreur éventuel -->
<%
  if (request.getAttribute(ConstantUtils.sfMessageEnregistrementKO) != null){
%>
<script language="javascript">
function showErrorMessage (){
	var options = {
		"title": "Valin'ny fangatahana",
		"button": "OK",
		"className":"error",
		"modal":"true"
	};
	    
	msg.open("Nisy tsy nety ny fampidirana na fanovàna mpivavaka tianao hatao", options);
	return false;
};

showErrorMessage();
</script>
<%
  }
%>

<!-- fin corps -->

<!-- pied de page -->
<%@ include file="/footer.jsp" %>
