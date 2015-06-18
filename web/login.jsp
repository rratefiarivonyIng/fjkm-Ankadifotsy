<%@ include file="/jsp/include.jsp" %>

<%@ include file="/header.jsp" %>

<%
	request.setAttribute("ctx",request.getContextPath());
%>

<!-- debut corps -->

<table width="100%">
	<tr><td>
	<p></p>
	  <div class="title1" align="center" >Fidirana</div>
	  <form method="POST" action="<c:url value='j_acegi_security_check'/>">
	    <table border="0" align="center">
          <tr>
            <td width="50%" align="right">Anarana</td>
            <td ><input type="text" name="j_username" /></td>
          </tr>
          <tr>
            <td align="right">Miafina</td>
            <td ><input type="password" name="j_password"/></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td align="left"><input name="Entrer" type="submit" id="Entrer" value="Miditra"/></td>
          </tr>
        </table>
	  </form>
	  
	  </td>
	</tr>
</table>

<!-- fin corps -->
<%@ include file="/footer.jsp" %>


<!-- Message d'erreur d'authentification -->
<%
  if (request.getParameterNames() != null && request.getParameterNames().hasMoreElements() && request.getParameterNames().nextElement().equals("failed")){
%>
<script language="javascript">
function showErrorMessage(){
	var options = {
		"title": "Fidirana",
		"button": "OK",
		"className":"error",
		"modal":"true"
	};
	    
	msg.open("Hamarino ny anarana sy ny teny miafina", options);
	return false;
};

showErrorMessage();
</script>
<%
  }
%>
