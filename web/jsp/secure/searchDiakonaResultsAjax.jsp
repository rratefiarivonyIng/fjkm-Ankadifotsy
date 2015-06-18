<%@ include file="/jsp/include.jsp" %>

<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>

<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>
<%@ page import="mg.fjkm.ankadifotsy.util.Utils" %>

<%@ page import="mg.fjkm.ankadifotsy.bo.Fitandremana" %>
<%@ page import="mg.fjkm.ankadifotsy.bo.Mpivavaka" %>

<%@ page import="mg.fjkm.ankadifotsy.form.FormSearchChristian" %>

<%@ page import="mg.fjkm.ankadifotsy.bo.SaveableEntity" %>

<script language="javascript">	
	function submitFormFromLink(pageNo){
		document.getElementById('pageNo').value = pageNo;
		document.getElementById('boutonValider').value = 'Tadiavo';
		document.getElementById('formSearchChristian').submit();
	}

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
<%!
	FormSearchChristian formSearchChristian;
%>
<%
	formSearchChristian = (FormSearchChristian)request.getAttribute(FormSearchChristian.sfFORM_ID);
%>
<%
  List<Mpivavaka> mpivavakas = (List<Mpivavaka>)request.getAttribute(ConstantUtils.sfDATA_MPIVAVAKAS);
  if (mpivavakas != null && mpivavakas.size() > 0){ %>
<table width="100%">
  <tr>
    <td>
      <%@ include file="pagination.jsp" %>
    </td>
  </tr>
  <tr>
    <td>
		<table valign="TOP" align="center" bgcolor="#ffffff" border="0" cellpadding="3" cellspacing="0" width="100%">
	    <tr>
	      <td colspan="7">
	        <table width=100%" border="1">
	          <tr>
                  <td align="left" width="5%" bgcolor="#48A9D2">&nbsp;</td>
			      <td width="12%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Laharana</b></div></td>
			      <td width="22%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Anarana</b></div></td>
			      <td width="15%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Fanampiny</b></div></td>
			      <td width="22%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Adiresy</b></div></td>
			      <td width="15%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Diakona</b></div></td>
			      <td width="14%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Azo fidiana</b></div></td>
			  </tr>
	        </table>
	      </td>
	    </tr>
        <%
        Date now = new Date();
		for (int i = 0; i < mpivavakas.size(); i++){
		    Mpivavaka mpivavaka = mpivavakas.get(i);
		    out.println("<tr>");
		    if (i % 2 == 0){
		   	%>
          <td width="4%" bgcolor="#66CCFF"><img src="<%=request.getContextPath()%>/<%=Utils.getPhotoName(request, mpivavaka)%>" width="50" height="50"/></td>
	      <td width="12%" bgcolor="#66CCFF"><div align="center" class="Style8"><a href="editDiakona.htm?id=<%=mpivavaka.getId()%>&<%=ConstantUtils.sfEditedFromSearch%>"><%=mpivavaka.getLaharana() != null ? mpivavaka.getLaharana() : "" %></a></div></td>
	      <td width="22%" bgcolor="#66CCFF"><div align="left" class="Style8"><a href="editDiakona.htm?id=<%=mpivavaka.getId()%>&<%=ConstantUtils.sfEditedFromSearch%>"><%=mpivavaka.getAnarana()%></a></div></td>
	      <td width="15%" bgcolor="#66CCFF"><div align="left" class="Style8"><%=mpivavaka.getFanampiny()%></div></td>
	      <td width="22%" bgcolor="#66CCFF"><div align="left" class="Style8"><%=mpivavaka.getAdresse()%></div></td>
		      <%if (mpivavaka.isDiakona(now)){ %>
		        <td width="15%" bgcolor="#66CCFF"><div align="center" class="Style8">
		          Amperin'asa</div>
		        </td>
		        <td width="14%" bgcolor="#66CCFF"><div align="center" class="Style8">
		          <a href="editDiakona.htm?id=<%=mpivavaka.getId()%>&<%=ConstantUtils.sfEditedFromSearch%>">Eny</a></div>
		        </td>
		      <%
		        }
		        else{
		          if (mpivavaka.efaDiakona()){
		      %>
		        <td width="15%" bgcolor="#66CCFF"><div align="center" class="Style8">
		          Eny</div>
		        </td>
		        <td width="14%" bgcolor="#66CCFF"><div align="center" class="Style8">
		          <a href="editDiakona.htm?id=<%=mpivavaka.getId()%>&<%=ConstantUtils.sfEditedFromSearch%>">Eny</a></div>
		        </td>
		      <%
		        }
		        else if (mpivavaka.isElligibleDiakona(now)){%>
		        <td width="15%" bgcolor="#66CCFF"><div align="center" class="Style8">
		          Tsia</div>
		        </td>
		        <td width="14%" bgcolor="#66CCFF"><div align="center" class="Style8">
		          <a href="editDiakona.htm?id=<%=mpivavaka.getId()%>&<%=ConstantUtils.sfEditedFromSearch%>">Eny</a></div>
		        </td>
		      <%
		        }
		        else{%>
		          <td width="15%" bgcolor="#66CCFF"><div align="center" class="Style8">
		            Tsia</div>
		          </td>
		          <td width="14%" bgcolor="#66CCFF"><div align="center" class="Style8">
		            Tsia</div>
		          </td>
		      <%
		         }
		       }
		   	}
		   	else{
		   	%>
          <td width="4%" bgcolor="#C0C0C0"><img src="<%=request.getContextPath()%>/<%=Utils.getPhotoName(request, mpivavaka)%>" width="50" height="50"/></td>
	      <td width="12%" bgcolor="#C0C0C0"><div align="center" class="Style8"><a href="editDiakona.htm?id=<%=mpivavaka.getId()%>&<%=ConstantUtils.sfEditedFromSearch%>"><%=mpivavaka.getLaharana() != null ? mpivavaka.getLaharana() : "" %></a></div></td>
	      <td width="22%" bgcolor="#C0C0C0"><div align="left" class="Style8"><a href="editDiakona.htm?id=<%=mpivavaka.getId()%>&<%=ConstantUtils.sfEditedFromSearch%>"><%=mpivavaka.getAnarana()%></a></div></td>
	      <td width="15%" bgcolor="#C0C0C0"><div align="left" class="Style8"><%=mpivavaka.getFanampiny()%></div></td>
	      <td width="22%" bgcolor="#C0C0C0"><div align="left" class="Style8"><%=mpivavaka.getAdresse()%></div></td>
		     <% if (mpivavaka.isDiakona(now)){ %>
		          <td width="15%" bgcolor="#C0C0C0"><div align="center" class="Style8">
		            Amperin'asa</div>
		          </td>
		          <td width="14%" bgcolor="#C0C0C0"><div align="center" class="Style8">
		            <a href="editDiakona.htm?id=<%=mpivavaka.getId()%>&<%=ConstantUtils.sfEditedFromSearch%>">Eny</a></div>
		          </td>
		        <%
		        }
		        else{
		          if (mpivavaka.efaDiakona()){
		        %>
		          <td width="15%" bgcolor="#C0C0C0"><div align="center" class="Style8">
		            Eny</div>
		          </td>
		          <td width="14%" bgcolor="#C0C0C0"><div align="center" class="Style8">
		            <a href="editDiakona.htm?id=<%=mpivavaka.getId()%>&<%=ConstantUtils.sfEditedFromSearch%>">Eny</a></div>
		          </td>
		        <%
		          }
		          else if (mpivavaka.isElligibleDiakona(now)){%>
		          <td width="15%" bgcolor="#C0C0C0"><div align="center" class="Style8">
		            Tsia</div>
		          </td>
		          <td width="14%" bgcolor="#C0C0C0"><div align="center" class="Style8">
		            <a href="editDiakona.htm?id=<%=mpivavaka.getId()%>&<%=ConstantUtils.sfEditedFromSearch%>">Eny</a></div>
		          </td>
		        <%
		          }
		          else{%>
		          <td width="15%" bgcolor="#C0C0C0"><div align="center" class="Style8">
		            Tsia</div>
		          </td>
		          <td width="14%" bgcolor="#C0C0C0"><div align="center" class="Style8">
		            Tsia</div>
		          </td>
		        <%
		         }
		      }
		   }
		   out.println("</tr>");
		}
	}
	else{
	    if (mpivavakas != null){
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