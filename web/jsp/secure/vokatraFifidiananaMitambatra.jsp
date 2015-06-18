<%@ include file="/jsp/include.jsp" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>
<%@ page import="mg.fjkm.ankadifotsy.util.Utils" %>

<%@ page import="mg.fjkm.ankadifotsy.bo.Fifidianana" %>

<%@ include file="/header.jsp" %>

<%!
Long fifidiananaId;
%>
<%
fifidiananaId = ((Fifidianana)request.getAttribute(ConstantUtils.sfREQUEST_FIFIDIANANA)).getId();
%>
<!-- debut corps -->
<table align="center" border="0">
  <tr>
	<td>
		<%@ include file="/onglet.jsp" %>
    </td>
  </tr>
  
  <%@ include file="showFifidianana.jsp" %>  
  
  <tr>
    <td colspan="2">
	  <div class="title1">Voka-pifidianana : </div><br>
	</td>
  </tr>
    
  <tr>
    <td colspan="2">
    <table width="90%" border="0" align="center">
      <tr bgcolor="#3333CC" style="color:#FFFFFF">
        <td colspan="2">&nbsp;</td>      
      </tr>
      
      <tr>
        <td colspan="2">
          <!-- Affichage des résultats provisoire par Ajax -->
          <div id="vokatraMitambatraId" style="vertical-align: top; " >
          </div>
        </td>
      </tr>
      
      <tr>
        <td colspan="2">
          <a href="selectFifidianana.htm?id=<%=fifidiananaId %>">Miverina amin'ny fifidianana</a>
        </td>
      </tr>
    </table>
	  
    </td>
  </tr>
  
</table>

<!-- fin corps -->

<script language="javascript">
	var reqAjaxVokatra = new AjReq();
	var optVokatras = {
		method : 'POST',
		abortAfter : 15000,
		update : document.getElementById('vokatraMitambatraId'),
		onSuccess : function(){window.setTimeout(getVokatraVonjyMaika, 20000);}
	};
 	
  	function getVokatraVonjyMaika(){
  		reqAjaxVokatra.send('vokatraFifidianana.htm', optVokatras);
	}

  	getVokatraVonjyMaika();
</script>

<%@ include file="/footer.jsp" %>
