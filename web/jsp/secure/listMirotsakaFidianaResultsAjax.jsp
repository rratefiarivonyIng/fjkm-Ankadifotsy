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
	      <td colspan="8">
	        <table width="100%" border="1">
	          <tr>
                  <td align="left" width="6%" bgcolor="#48A9D2">&nbsp;</td>
			      <td width="8%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Laharana adidy</b></div></td>
			      <td width="17%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Anarana</b></div></td>
			      <td width="17%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Fanampiny</b></div></td>
			      <td width="19%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Adiresy</b></div></td>
			      <td width="12%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Daty nirotsahana</b></div></td>
			      <td width="12%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Ekena ?</b></div></td>
			      <td width="14%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Laharana fifidianana</b></div></td>
			  </tr>
	        </table>
	      </td>
	    </tr>
        <%
        Date now = new Date();
		for (int i = 0; i < listMirotsakaFidiana.size(); i++){
		    Map<String, Object> mirotsakaFidiana = listMirotsakaFidiana.get(i);
		    out.println("<tr>");
		    if (i % 2 == 0){
		   	%>
          <td width="5%" bgcolor="#66CCFF"><img src="<%=request.getContextPath()%>/<%=Utils.getPhotoName(request, (String)mirotsakaFidiana.get("anarana"), (Long)mirotsakaFidiana.get("mpivavakaId"), (Boolean)mirotsakaFidiana.get("lahy"))%>" width="50" height="50"/></td>
	      <td width="8%" bgcolor="#66CCFF"><div align="center" class="Style8"><a href="editMirotsakaFidiana.htm?id=<%=mirotsakaFidiana.get("mpivavakaId")%>&<%=ConstantUtils.sfMirotsakaFidianaId%>=<%=mirotsakaFidiana.get("mirotsakaFidianaId")%>&<%=ConstantUtils.sfEditedFromSearch%>=listMirotsakaFidiana.htm?reload"><%=mirotsakaFidiana.get("laharana") != null ? mirotsakaFidiana.get("laharana") : "" %></a></div></td>
	      <td width="17%" bgcolor="#66CCFF"><div align="left" class="Style8"><a href="editMirotsakaFidiana.htm?id=<%=mirotsakaFidiana.get("mpivavakaId")%>&<%=ConstantUtils.sfMirotsakaFidianaId%>=<%=mirotsakaFidiana.get("mirotsakaFidianaId")%>&<%=ConstantUtils.sfEditedFromSearch%>=listMirotsakaFidiana.htm?reload"><%=mirotsakaFidiana.get("anarana")%></a></div></td>
	      <td width="17%" bgcolor="#66CCFF"><div align="left" class="Style8"><%=mirotsakaFidiana.get("fanampiny")%></div></td>
	      <td width="19%" bgcolor="#66CCFF"><div align="left" class="Style8"><%=mirotsakaFidiana.get("adiresy")%></div></td>
	      <td width="12%" bgcolor="#66CCFF"><div align="center" class="Style8"><%=Utils.sfDateFormatJJMMYYYY.format(mirotsakaFidiana.get("datyNirotsahana"))%></div></td>
		      <% if (mirotsakaFidiana.get("ekena") != null){ %>
	      <td width="13%" bgcolor="#66CCFF">
	      <div align="center" class="Style8">
	            <% if (((Boolean)mirotsakaFidiana.get("ekena")).booleanValue()) {%>
	            Eny
	            <%
	            }else{
	            %>
	            Tsia
	            <%
	            }
	            %>
	      </div>
	      </td>
		      <%
		      }
		      else{
		      %>
	      <td width="13%" bgcolor="#66CCFF"><div align="left" class="Style8">Mbola tsy notapahina</div></td>
		      <%
		      }
		      %>
	      <td width="13%" bgcolor="#66CCFF"><div align="center" class="Style8"><%=mirotsakaFidiana.get("laharanaMpirotsaka") != null ? mirotsakaFidiana.get("laharanaMpirotsaka") : ""%></div></td>
            <%		      
		   	}
		   	else{
		   	%>
          <td width="5%" bgcolor="#C0C0C0"><img src="<%=request.getContextPath()%>/<%=Utils.getPhotoName(request, (String)mirotsakaFidiana.get("anarana"), (Long)mirotsakaFidiana.get("mpivavakaId"), (Boolean)mirotsakaFidiana.get("lahy"))%>" width="50" height="50"/></td>
	      <td width="8%" bgcolor="#C0C0C0"><div align="center" class="Style8"><a href="editMirotsakaFidiana.htm?id=<%=mirotsakaFidiana.get("mpivavakaId")%>&<%=ConstantUtils.sfMirotsakaFidianaId%>=<%=mirotsakaFidiana.get("mirotsakaFidianaId")%>&<%=ConstantUtils.sfEditedFromSearch%>=listMirotsakaFidiana.htm?reload"><%=mirotsakaFidiana.get("laharana") != null ? mirotsakaFidiana.get("laharana") : "" %></a></div></td>
	      <td width="17%" bgcolor="#C0C0C0"><div align="left" class="Style8"><a href="editMirotsakaFidiana.htm?id=<%=mirotsakaFidiana.get("mpivavakaId")%>&<%=ConstantUtils.sfMirotsakaFidianaId%>=<%=mirotsakaFidiana.get("mirotsakaFidianaId")%>&<%=ConstantUtils.sfEditedFromSearch%>=listMirotsakaFidiana.htm?reload"><%=mirotsakaFidiana.get("anarana")%></a></div></td>
	      <td width="17%" bgcolor="#C0C0C0"><div align="left" class="Style8"><%=mirotsakaFidiana.get("fanampiny")%></div></td>
	      <td width="19%" bgcolor="#C0C0C0"><div align="left" class="Style8"><%=mirotsakaFidiana.get("adiresy")%></div></td>
	      <td width="12%" bgcolor="#C0C0C0"><div align="center" class="Style8"><%=Utils.sfDateFormatJJMMYYYY.format(mirotsakaFidiana.get("datyNirotsahana"))%></div></td>
		      <% if (mirotsakaFidiana.get("ekena") != null){ %>
	      <td width="13%" bgcolor="#C0C0C0">
	        <div align="center" class="Style8">
	            <% if (((Boolean)mirotsakaFidiana.get("ekena")).booleanValue()) {%>
	            Eny
	            <%
	            }else{
	            %>
	            Tsia
	            <%
	            }
	            %>
	        </div>
	      </td>
		      <%
		      }
		      else{
		      %>
	      <td width="13%" bgcolor="#C0C0C0"><div align="left" class="Style8">Mbola tsy notapahina</div></td>
		      <%
		      }
		      %>
	      <td width="13%" bgcolor="#C0C0C0"><div align="center" class="Style8"><%=mirotsakaFidiana.get("laharanaMpirotsaka") != null ? mirotsakaFidiana.get("laharanaMpirotsaka") : ""%></div></td>		      
		      <%
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