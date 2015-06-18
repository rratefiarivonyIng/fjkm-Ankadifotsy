
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>
<%@ page import="mg.fjkm.ankadifotsy.util.Utils" %>

<%@page import="mg.fjkm.ankadifotsy.bo.FanisamBato"%>
<%@ page import="mg.fjkm.ankadifotsy.bo.Fifidianana" %>

<%!
List<Map<String, Object>> mapLaharanaAnarana2Vato;
Long fifidiananaId;
FanisamBato fanisamBato;
int nbRows;
%>
<%
mapLaharanaAnarana2Vato = (List<Map<String, Object>>)request.getAttribute(ConstantUtils.sfDATA_VALINY_FIFIDIANANA);
nbRows = mapLaharanaAnarana2Vato.size();
fifidiananaId = ((Fifidianana)request.getAttribute(ConstantUtils.sfREQUEST_FIFIDIANANA)).getId();
fanisamBato = (FanisamBato)request.getAttribute(ConstantUtils.sfDATA_FANISAMBATO);
%>      
  
  <tr>
    <td colspan="2">
    <table width="90%" border="1" align="center">
      <tr bgcolor="#3333CC" style="color:#FFFFFF">
        <td>
          <table border="0" width="100%">
            <tr bgcolor="#3333CC" style="color:#FFFFFF">
              <td colspan="2">Isan'ny vato </td>
              <td>rehetra :</td>
              <td> <%=fanisamBato.getIsamBatoVoaisa()%></td>
              <td>&nbsp;</td>
              <td>manankery :</td>
              <td> <%=fanisamBato.getIsamBatoManankery()%> </td>
              <td>&nbsp;</td>
              <td>maty :</td>
              <td> <%=fanisamBato.getIsamBatoMaty()%> </td>
              <td>&nbsp;</td>
              <td>fotsy :</td>
              <td><%=fanisamBato.getIsamBatoFotsy()%></td>
            </tr>
          </table>
        </td>      
      </tr>
      
      <tr>
        <td width="100%">
          <table width="100%" border="0">
          <thead bgcolor="#0000CC" style="color:#FFFFFF"><td width="5%">&nbsp;</td><td width="8%">Laharan'ny mpirotsaka</td><td width="25%">Anarana</td><td width="27%">Fanampiny</td><td width="9%">Vato</td></thead>
          <tbody>
          <!-- Affichage des résultats provisoire par Ajax pour les Diakona vehivavy -->          
          <%
          for (int i=0; i < nbRows; i++){
        	if (i < mapLaharanaAnarana2Vato.size()){
        	  Map<String, Object> m = mapLaharanaAnarana2Vato.get(i);
          %>
          <tr <%= i % 2 == 0 ? "bgcolor='#66CCFF'":"bgcolor='#C0C0C0'" %>>
            <td><img src="<%=request.getContextPath()%>/<%=Utils.getPhotoName(request, (String)m.get("anarana"), (Long)m.get("mpivavakaId"), (Boolean)m.get("lahy"))%>" width="50" height="50"/></td>
            <td align="center"><%=m.get("laharana") %></td>
            <td><%=m.get("anarana") %></td>
            <td><%=m.get("fanampiny") %></td>
            <td align="right"><%=m.get("vato") %></td>
          </tr>
          <%
        	}
        	else{
          %>
          <tr <%= i % 2 == 0 ? "bgcolor='#66CCFF'":"bgcolor='#C0C0C0'" %>>
            <td><img src="<%=request.getContextPath()%>/<%=Utils.getPhotoName(request, "", -1L, false)%>" width="50" height="50"/></td>
            <td align="center">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td align="right">&nbsp;</td>
          </tr>
          <%
        	}
          }
          %>
          </tbody>
          </table>
        </td>
      </tr>
    </table>
	  
    </td>
  </tr>