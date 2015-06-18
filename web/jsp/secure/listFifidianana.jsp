<%@ include file="/jsp/include.jsp" %>

<%@ page import="java.util.List" %>

<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>

<%@ page import="mg.fjkm.ankadifotsy.bo.Fitandremana" %>
<%@ page import="mg.fjkm.ankadifotsy.bo.Mpivavaka" %>

<%@ page import="mg.fjkm.ankadifotsy.form.FormChristian" %>

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

<table align="center" >
	<tr>
	<td>
		<%@ include file="/onglet.jsp" %>
	<p></p>
	  <div class="title1" align="center">Lisitr'ireo mpino kristiana :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </div><br>
	  <div class="boxform">
	<table valign="TOP" align="center" bgcolor="#ffffff" border="0" cellpadding="3" cellspacing="0" width="100%">
    <tr>
      <td width="17%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Laharana</b></div></td>
      <td width="25%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Anarana</b></div></td>
      <td width="18%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Fanampiny</b></div></td>
      <td width="40%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Adiresy</b></div></td>
    </tr>
	<%
	List<Mpivavaka> mpivavakas = (List<Mpivavaka>)request.getAttribute(ConstantUtils.sfDATA_MPIVAVAKAS);
	for (int i = 0; i < mpivavakas.size(); i++){
	    Mpivavaka mpivavaka = mpivavakas.get(i);
	    out.println("<tr>");
	    if (i % 2 == 0){
	   	%>
      <td width="17%" bgcolor="#66CCFF"><div align="center" class="Style8"><a href="editChristian.htm?laharana=<%=mpivavaka.getLaharana()%>"><%=mpivavaka.getLaharana()%></a></div></td>
      <td width="25%" bgcolor="#66CCFF"><div align="center" class="Style8"><a href="editChristian.htm?id=<%=mpivavaka.getId()%>"><%=mpivavaka.getAnarana()%></a></div></td>
      <td width="18%" bgcolor="#66CCFF"><div align="center" class="Style8"><%=mpivavaka.getFanampiny()%></div></td>
      <td width="40%" bgcolor="#66CCFF"><div align="center" class="Style8"><%=mpivavaka.getAdresse()%></div></td>
	   	<%
	   	}
	   	else{
	   	%>
      <td width="17%" bgcolor="#C0C0C0"><div align="center" class="Style8"><a href="editChristian.htm?laharana=<%=mpivavaka.getLaharana()%>"><%=mpivavaka.getLaharana()%></a></div></td>
      <td width="25%" bgcolor="#C0C0C0"><div align="center" class="Style8"><a href="editChristian.htm?id=<%=mpivavaka.getId()%>"><%=mpivavaka.getAnarana()%></a></div></td>
      <td width="18%" bgcolor="#C0C0C0"><div align="center" class="Style8"><%=mpivavaka.getFanampiny()%></div></td>
      <td width="40%" bgcolor="#C0C0C0"><div align="center" class="Style8"><%=mpivavaka.getAdresse()%></div></td>
	   	<%}
	   	out.println("</tr>");
	}
	%>
	</table>

	  </div>
	  
      </td>
	</tr>
</table>

<!-- fin corps -->

<%@ include file="/footer.jsp" %>
