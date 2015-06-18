<%@ include file="/jsp/include.jsp" %>

<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>

<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>
<%@ page import="mg.fjkm.ankadifotsy.util.Utils" %>

<%@ page import="mg.fjkm.ankadifotsy.bo.Fitandremana" %>
<%@ page import="mg.fjkm.ankadifotsy.bo.Fifidianana" %>
<%@ page import="mg.fjkm.ankadifotsy.form.FormFifidianana" %>

<%@ include file="/header.jsp" %>

<script language="javascript">	
	function submitForm(){
		document.getElementById('formFifidianana').submit();
	}
</script>

<!-- debut corps -->
<%!
FormFifidianana formFifidianana;
%>
<% formFifidianana = (FormFifidianana)request.getAttribute(FormFifidianana.sfFORM_ID); %>
<table align="center" border="0" >
  <tr>
    <td>
		<%@ include file="/onglet.jsp" %>
    </td>
  </tr>
  
  <tr>
    <td>Famerenana ny fifidianana  : <%=formFifidianana.getFifidianana().getLabel() %> </td>
  </tr>
  
  <tr>
    <td>
	<form id="formFifidianana" method="post" action="initFifidianana.htm">
	<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	  	<td><font color="red"><b>TANDREMO : </b></font></td>
	  	<td colspan="2"><font color="red"><b>Mamerina 0 ny isam-bato azon'ny kandida rehetra <br/> Tsy afaka averina intsony raha vao alefa ity !!!</b></font></td>
	    <td width="30%">
		    <input type="button" name="Alefa" value="Alefa" onclick="submitForm();"/>
        </td>
	  </tr>
    </table>
	
    </form>
	  
   </td>
  </tr>	
</table>

<!-- fin corps -->

<%@ include file="/footer.jsp" %>
