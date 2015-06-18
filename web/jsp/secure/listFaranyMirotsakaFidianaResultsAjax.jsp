<%@ include file="/jsp/include.jsp" %>

<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>
<%@ page import="mg.fjkm.ankadifotsy.util.Utils" %>

<%@ page import="mg.fjkm.ankadifotsy.form.FormListMirotsakaFidiana" %>

<script language="javascript">	
	function submitFormFromLink(pageNo){
		document.getElementById('pageNo').value = pageNo;
		document.getElementById('boutonValider').value = 'Tadiavo';
		document.getElementById('formMirotsakaFidiana').submit();
	}
</script>

<style type="text/css">
.impression   { font-family: Arial Unicode MS; font-size: 20px; font-weight: bold;}
</style>

<!-- debut corps -->
<%!
	FormListMirotsakaFidiana formListMirotsakaFidiana;
	List<Map<String, Object>> listMirotsakaFidiana;
%>
<%
	formListMirotsakaFidiana = (FormListMirotsakaFidiana)request.getAttribute(FormListMirotsakaFidiana.sfFORM_ID);
	listMirotsakaFidiana = (List<Map<String, Object>>)request.getAttribute(ConstantUtils.sfDATA_MIROTSAKAFIDIANAS);
  if (listMirotsakaFidiana != null && listMirotsakaFidiana.size() > 0){ 
%>
<table width="100%">
  <tr>
    <td>
      <%@ include file="pagination.jsp" %>
    </td>
  </tr>
  <tr>
    <td>
		<table align="center" bgcolor="#ffffff" border="0" cellpadding="0" cellspacing="0" width="100%">
	    <tr>
	      <td colspan="9">
	        <table width="100%" border="1">
	          <tr>
                  <td align="left" width="13%" bgcolor="#48A9D2">&nbsp;</td>
			      <td width="3%" bgcolor="#48A9D2"><div align="center" class="impression"><b>No </b></div></td>
			      <td width="26%" bgcolor="#48A9D2"><div align="center" class="impression"><b>Anarana Fanampiny</b></div></td>
			      
                  <td align="left" width="2%" bgcolor="#FFFFFF">&nbsp;</td>
			      
                  <td align="left" width="13%" bgcolor="#48A9D2">&nbsp;</td>
			      <td width="3%" bgcolor="#48A9D2"><div align="center" class="impression"><b>No</b></div></td>
			      <td width="26%" bgcolor="#48A9D2"><div align="center" class="impression"><b>Anarana Fanampiny</b></div></td>
			  </tr>
	        </table>
	      </td>
	    </tr>
        <%
        Date now = new Date();
        int nbLines = listMirotsakaFidiana.size() / 2;
		for (int i = 0; i < nbLines ; i++){
		    Map<String, Object> mirotsakaFidiana = listMirotsakaFidiana.get(i);
		    Map<String, Object> mirotsakaFidiana2 = null;
		    try{
		    	mirotsakaFidiana2 = listMirotsakaFidiana.get(i + nbLines);
		    }
		    catch(Exception e){
		    	if (i < listMirotsakaFidiana.size())
		    		mirotsakaFidiana2 = listMirotsakaFidiana.get(i + listMirotsakaFidiana.size() / 2);
		    }
		    
		    out.println("<tr>");
		    if (i % 2 == 0){
		   	%>
          <td width="14%" bgcolor="#66CCFF"><img src="<%=request.getContextPath()%>/<%=Utils.getPhotoName(request, (String)mirotsakaFidiana.get("anarana"), (Long)mirotsakaFidiana.get("mpivavakaId"), (Boolean)mirotsakaFidiana.get("lahy"))%>" width="155" height="163"/></td>
	      <td width="5%" bgcolor="#66CCFF"><div align="center" class="impression"><%=mirotsakaFidiana.get("laharanaMpirotsaka") != null ? mirotsakaFidiana.get("laharanaMpirotsaka") : ""%></div></td>
	      <td width="26%" bgcolor="#66CCFF"><div align="left" class="impression"><%=mirotsakaFidiana.get("anarana")%>&nbsp;<%=mirotsakaFidiana.get("fanampiny")%></div></td>

		  <td align="left" width="2%" bgcolor="#FFFFFF">&nbsp;</td>
				<%
				if (mirotsakaFidiana2 != null){
				%>
          <td width="14%" bgcolor="#66CCFF"><img src="<%=request.getContextPath()%>/<%=Utils.getPhotoName(request, (String)mirotsakaFidiana2.get("anarana"), (Long)mirotsakaFidiana2.get("mpivavakaId"), (Boolean)mirotsakaFidiana2.get("lahy"))%>" width="155" height="163"/></td>
	      <td width="5%" bgcolor="#66CCFF"><div align="center" class="impression"><%=mirotsakaFidiana2.get("laharanaMpirotsaka") != null ? mirotsakaFidiana2.get("laharanaMpirotsaka") : ""%></div></td>
	      <td width="26%" bgcolor="#66CCFF"><div align="left" class="impression"><%=mirotsakaFidiana2.get("anarana")%>&nbsp;<%=mirotsakaFidiana2.get("fanampiny")%></div></td>
	      		<%
				}
				else
				{
	      		%>
          <td width="14%" bgcolor="#66CCFF">&nbsp;</td>
	      <td width="5%" bgcolor="#66CCFF"><div align="center" class="impression"></div></td>
	      <td width="26%" bgcolor="#66CCFF"><div align="left" class="impression"></div></td>
            <%	
				}
		   	}
		   	else{
		   	%>
          <td width="14%" bgcolor="#C0C0C0"><img src="<%=request.getContextPath()%>/<%=Utils.getPhotoName(request, (String)mirotsakaFidiana.get("anarana"), (Long)mirotsakaFidiana.get("mpivavakaId"), (Boolean)mirotsakaFidiana.get("lahy"))%>" width="155" height="163"/></td>
	      <td width="5%" bgcolor="#C0C0C0"><div align="center" class="impression"><%=mirotsakaFidiana.get("laharanaMpirotsaka") != null ? mirotsakaFidiana.get("laharanaMpirotsaka") : ""%></div></td>		      
	      <td width="26%" bgcolor="#C0C0C0"><div align="left" class="impression"><%=mirotsakaFidiana.get("anarana")%>&nbsp;<%=mirotsakaFidiana.get("fanampiny")%></div></td>

		  <td align="left" width="2%" bgcolor="#FFFFFF">&nbsp;</td>
				<%
				if (mirotsakaFidiana2 != null){
				%>
          <td width="14%" bgcolor="#C0C0C0"><img src="<%=request.getContextPath()%>/<%=Utils.getPhotoName(request, (String)mirotsakaFidiana2.get("anarana"), (Long)mirotsakaFidiana2.get("mpivavakaId"), (Boolean)mirotsakaFidiana2.get("lahy"))%>" width="155" height="163"/></td>
	      <td width="6%" bgcolor="#C0C0C0"><div align="center" class="impression"><%=mirotsakaFidiana2.get("laharanaMpirotsaka") != null ? mirotsakaFidiana2.get("laharanaMpirotsaka") : ""%></div></td>		      
	      <td width="26%" bgcolor="#C0C0C0"><div align="left" class="impression"><%=mirotsakaFidiana2.get("anarana")%>&nbsp;<%=mirotsakaFidiana2.get("fanampiny")%></div></td>
	      		<%
				}
				else{
	      		%>
          <td width="14%" bgcolor="#C0C0C0"></td>
	      <td width="6%" bgcolor="#C0C0C0"><div align="center" class="impression"></div></td>		      
	      <td width="26%" bgcolor="#C0C0C0"><div align="left" class="impression"></div></td>
 	        <%
				}
		   }
		   out.println("</tr>");
		}
	}
	else{
	    if (listMirotsakaFidiana != null){
	%>
	 <tr>
       <td colspan="5"><div align="center" style="bgcolor:#FF0000;">Tsy misy mpivavaka mifanaraka amin'ny sivana.</div></td>
	 </tr>
	<%
		}
	}
	%>
		</table>
    </td>
  </tr>
</table>