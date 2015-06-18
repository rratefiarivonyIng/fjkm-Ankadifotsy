<%@ include file="/jsp/include.jsp" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>

<%!
List<Map<String, Object>> mapLaharanaAnarana2Vato;
%>
<%
mapLaharanaAnarana2Vato = (List<Map<String, Object>>)request.getAttribute(ConstantUtils.sfDATA_TEMP_RESULT);
%>

<%
if (mapLaharanaAnarana2Vato != null){
%>
<table border="0" width="100%">
  <%
  for (int i = 0; i < (Integer)request.getAttribute(ConstantUtils.sfTEMP_RESULT_NBLINES); i++){
	if (i < mapLaharanaAnarana2Vato.size()){
  	  Map<String, Object> m = mapLaharanaAnarana2Vato.get(i);
	  Integer laharana = (Integer)m.get("laharana");
	  String anarana = (String)m.get("anarana");
	  Long vato = (Long)m.get("vato");
	  
	  if (i % 2 == 0){
  %>
  <tr bgcolor="#66CCFF">
    <td width="10%"><%=laharana%></td><td><%=anarana %></td><td width="15%" align="right">[<%=vato%>]</td>
  </tr>
  <%
	  }
	  else{
   %>
  <tr bgcolor="#C0C0C0">
    <td width="10%"><%=laharana%></td><td><%=anarana %></td><td width="15%" align="right">[<%=vato%>]</td>
  </tr>
   <%
	  }
  	}
  	else{
  	  if (i % 2 == 0){
  %>
  <tr bgcolor="#66CCFF">
    <td width="10%">&nbsp;</td><td>&nbsp;</td><td width="15%">&nbsp;</td>
  </tr>
  <%
  	  }
  	  else{
  %>
  <tr bgcolor="#C0C0C0">
    <td width="10%">&nbsp;</td><td>&nbsp;</td><td width="15%">&nbsp;</td>
  </tr>
  <%
  	  }
  	}
  }
  %>
</table>
<%
}
%>