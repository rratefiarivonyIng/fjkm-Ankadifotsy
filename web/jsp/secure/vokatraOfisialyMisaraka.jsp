<%@ include file="/jsp/include.jsp" %>

<%@ page import="mg.fjkm.ankadifotsy.bo.Fifidianana" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>
<%@ page import="mg.fjkm.ankadifotsy.util.Utils" %>

<%@page import="mg.fjkm.ankadifotsy.bo.FanisamBato"%>

<%@ include file="/header.jsp" %>

<%!
Long fifidiananaId;
List<Map<String, Object>> mapLaharanaAnaranaVavy2Vato, mapLaharanaAnaranaLahy2Vato;
FanisamBato fanisamBatoVehivavy, fanisamBatoLehilahy;
int nbRows;
%>
<%
mapLaharanaAnaranaVavy2Vato = (List<Map<String, Object>>)request.getAttribute(ConstantUtils.sfDATA_VALINY_FIFIDIANANA_VEHIVAVY);
mapLaharanaAnaranaLahy2Vato = (List<Map<String, Object>>)request.getAttribute(ConstantUtils.sfDATA_VALINY_FIFIDIANANA_LEHILAHY);
nbRows = mapLaharanaAnaranaVavy2Vato.size() > mapLaharanaAnaranaLahy2Vato.size() ? mapLaharanaAnaranaVavy2Vato.size() : mapLaharanaAnaranaLahy2Vato.size();
fifidiananaId = ((Fifidianana)request.getAttribute(ConstantUtils.sfREQUEST_FIFIDIANANA)).getId();
fanisamBatoVehivavy = (FanisamBato)request.getAttribute(ConstantUtils.sfDATA_FANISAMBATO_VEHIVAVY);
fanisamBatoLehilahy = (FanisamBato)request.getAttribute(ConstantUtils.sfDATA_FANISAMBATO_LEHILAHY);
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
      
      <tr>
        <td>
          <div id="vokatraMisarakaId" style="vertical-align: top; " >

		    <table width="90%" border="1" align="center">      
		      <tr>
		        <td colspan="2">
					Ny lisitr'ireo voafidy :
		        </td>
		      </tr>
		      
		      <tr bgcolor="#3333CC" style="color:#FFFFFF">
		        <td width="50%">
		          <table border="0" width="100%">
		            <tr bgcolor="#3333CC" style="color:#FFFFFF">
		              <td colspan="2">Isan'ny vato </td>
		              <td>rehetra :</td>
		              <td> <%=fanisamBatoVehivavy.getIsamBatoVoaisa()%></td>
		              <td>&nbsp;</td>
		              <td>manankery :</td>
		              <td> <%=fanisamBatoVehivavy.getIsamBatoManankery()%> </td>
		              <td>&nbsp;</td>
		              <td>maty :</td>
		              <td> <%=fanisamBatoVehivavy.getIsamBatoMaty()%> </td>
		              <td>&nbsp;</td>
		              <td>fotsy :</td>
		              <td><%=fanisamBatoVehivavy.getIsamBatoFotsy()%></td>
		            </tr>
		          </table>
		        </td>      
		        <td width="50%">
		          <table border="0" width="100%">
		            <tr bgcolor="#3333CC" style="color:#FFFFFF">
		              <td colspan="2">Isan'ny vato </td>
		              <td>rehetra :</td>
		              <td> <%=fanisamBatoLehilahy.getIsamBatoVoaisa()%></td>
		              <td>&nbsp;</td>
		              <td>manankery :</td>
		              <td> <%=fanisamBatoLehilahy.getIsamBatoManankery()%> </td>
		              <td>&nbsp;</td>
		              <td>maty :</td>
		              <td> <%=fanisamBatoLehilahy.getIsamBatoMaty()%> </td>
		              <td>&nbsp;</td>
		              <td>fotsy :</td>
		              <td><%=fanisamBatoLehilahy.getIsamBatoFotsy()%></td>
		            </tr>
		          </table>
		        </td>      
		      </tr>
		      
		      <tr>
		        <td width="50%">
		          <table width="100%" border="0">
		          <thead bgcolor="#0000CC" style="color:#FFFFFF"><td width="5%">&nbsp;</td><td width="8%">Laharan'ny mpirotsaka</td><td width="30%">Anarana</td><td width="31%">Fanampiny</td></thead>
		          <tbody>
		          <!-- Affichage des résultats provisoire par Ajax pour les Diakona vehivavy -->
		          
		          <%
		          for (int i=0; i < nbRows; i++){
		        	if (i < mapLaharanaAnaranaVavy2Vato.size()){
		        	  Map<String, Object> m = mapLaharanaAnaranaVavy2Vato.get(i);
		          %>
		          <tr <%= i % 2 == 0 ? "bgcolor='#66CCFF'":"bgcolor='#C0C0C0'" %>>
		            <td><img src="<%=request.getContextPath()%>/<%=Utils.getPhotoName(request, (String)m.get("anarana"), (Long)m.get("mpivavakaId"), (Boolean)m.get("lahy"))%>" width="50" height="50"/></td>
		            <td align="center"><%=m.get("laharana") %></td>
		            <td><%=m.get("anarana") %></td>
		            <td><%=m.get("fanampiny") %></td>
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
		          </tr>
		          <%
		        	}
		          }
		          %>
		          </tbody>
		          </table>
		        </td>
		
		        <td width="50%">
		          <table width="100%" border="0">
		          <thead bgcolor="#0000CC" style="color:#FFFFFF"><td width="5%">&nbsp;</td><td width="8%">Laharan'ny mpirotsaka</td><td width="30%">Anarana</td><td width="31%">Fanampiny</td></thead>
		          <tbody>
		          <%
		          for (int i=0; i < nbRows; i++){
		        	if (i < mapLaharanaAnaranaLahy2Vato.size()){
		        	  Map<String, Object> m = mapLaharanaAnaranaLahy2Vato.get(i);
		          %>
		          <tr <%= i % 2 == 0 ? "bgcolor='#66CCFF'":"bgcolor='#C0C0C0'" %>>
		            <td><img src="<%=request.getContextPath()%>/<%=Utils.getPhotoName(request, (String)m.get("anarana"), (Long)m.get("mpivavakaId"), (Boolean)m.get("lahy"))%>" width="50" height="50"/></td>
		            <td align="center"><%=m.get("laharana") %></td>
		            <td><%=m.get("anarana") %></td>
		            <td><%=m.get("fanampiny") %></td>
		          </tr>
		          <%
		        	}
		        	else{
		          %>
		          <tr <%= i % 2 == 0 ? "bgcolor='#66CCFF'":"bgcolor='#C0C0C0'" %>>
		            <td><img src="<%=request.getContextPath()%>/<%=Utils.getPhotoName(request, "", -1L, true)%>" width="50" height="50"/></td>
		            <td align="center">&nbsp;</td>
		            <td>&nbsp;</td>
		            <td>&nbsp;</td>
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

<%@ include file="/footer.jsp" %>
