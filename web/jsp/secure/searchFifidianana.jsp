<%@ include file="/jsp/include.jsp" %>

<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>

<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>
<%@ page import="mg.fjkm.ankadifotsy.util.Utils" %>

<%@ page import="mg.fjkm.ankadifotsy.bo.Fitandremana" %>
<%@ page import="mg.fjkm.ankadifotsy.bo.Fifidianana" %>

<%@ page import="mg.fjkm.ankadifotsy.form.FormSearchFifidianana" %>

<%@ include file="/header.jsp" %>

<script language="javascript">	
	function submitFormFromLink(pageNo){
		document.getElementById('pageNo').value = pageNo;
		document.getElementById('boutonValider').value = 'Tadiavo';
		document.getElementById('formSearchChristian').submit();
	}

</script>

<!-- debut corps -->
<%!
	FormSearchFifidianana formSearchFifidianana;
%>
<%
	formSearchFifidianana = (FormSearchFifidianana)request.getAttribute(FormSearchFifidianana.sfFORM_ID);
%>

<table align="center" border="0" >
  <tr>
    <td>
		<%@ include file="/onglet.jsp" %>
    </td>
  </tr>
  
  <tr>
    <td>Fitadiavana fifidianana : </td>
  </tr>
  
  <tr>
    <td>
	<form id="formSearchFifidianana" name="formSearchFifidianana" method="post" action="searchFifidianana.htm">
	<table width="100%" align="center" border="1" cellpadding="0" cellspacing="0">
	  <tr>
	    <td colspan="2">
	      <table width="100%"  border="0">
	        <tr>
	          <td colspan="2">
	            <table width="90%" border="0">
	              <tr>
	                <td width="50%" align="left">Fitandremana *</td>
	                <td align="left">
			        <spring:bind path="formSearchFifidianana.fitandremana" >
          	        <!-- la saisie à autocompléter -->
		              <input class="inputleft" id="fitandremanaLabel" name="fitandremanaLabel" type="text" size="22" value="${formSearchFifidianana.fitandremana.label}" />	
		            <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
		              <input type="hidden" id="fitandremanaID" name="${status.expression}" value="${formSearchFifidianana.fitandremana.id}" />	
		              <span id="indicatorFitandremanaID" style="display:none;"><img src="<%=request.getContextPath()%>/images/indicator.gif" /></span>
		              <font color="red" size="1.2">${status.errorMessage}</font>
              
                    <ajax:autocomplete
				      source="fitandremanaLabel"
				      target="fitandremanaID"
				      baseUrl="fitandremanaAutoCompletion.htm"
				      className="autocomplete"
				      indicator="indicatorFitandremanaID"
				      minimumCharacters="1"
			        />                  
                    </spring:bind>
	                </td>
	              </tr>
	          
	              <tr>
		            <td title="Karazana fifidianana">Karazany </td>
		            <td align="center">
			        <spring:bind path="formSearchFifidianana.karazamPifidianana" >
          	        <!-- la saisie à autocompléter -->
		              <input class="inputleft" id="karazamPifidiananaLabel" name="karazamPifidiananaLabel" type="text" size="22" value="${formSearchFifidianana.karazamPifidianana.label}" />	
		            <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
		              <input type="hidden" id="karazamPifidiananaID" name="${status.expression}" value="${formSearchFifidianana.karazamPifidianana.id}" />	
		              <span id="indicatorKarazamPifidiananaID" style="display:none;"><img src="<%=request.getContextPath()%>/images/indicator.gif" /></span>
		              <font color="red" size="1.2">${status.errorMessage}</font>
              
                    <ajax:autocomplete
				      source="karazamPifidiananaLabel"
				      target="karazamPifidiananaID"
				      baseUrl="karazamPifidiananaAutoCompletion.htm"
				      className="autocomplete"
				      indicator="indicatorKarazamPifidiananaID"
				      minimumCharacters="1"
			        />                  
                    </spring:bind>
		            </td>
	              </tr>
	            </table>
	          </td>
	          <td colspan="2">
	            <table width="100%" border="0">
	              <tr>
	                <td width="30%">TaomPanompoana</td>
	                <td colspan="2">
	                <spring:bind path="formSearchFifidianana.taomPanompoana" >
          	        <!-- la saisie à autocompléter -->
		              <input class="inputleft" id="taomPanompoanaLabel" name="taomPanompoanaLabel" type="text" size="22" value="${formSearchFifidianana.taomPanompoana}" />	
		            <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
		              <input type="hidden" id="taomPanompoanaID" name="${status.expression}" value="${formSearchFifidianana.taomPanompoana.id}" />	
		              <span id="indicatorTaomPanompoanaID" style="display:none;"><img src="<%=request.getContextPath()%>/images/indicator.gif" /></span>
		              <font color="red" size="1.2">${status.errorMessage}</font>
              
                    <ajax:autocomplete
				      source="taomPanompoanaLabel"
				      target="taomPanompoanaID"
				      baseUrl="taomPanompoanaAutoCompletion.htm"
				      className="autocomplete"
				      indicator="indicatorTaomPanompoanaID"
				      minimumCharacters="1"
			        />                  
		            </spring:bind>
				    </td>
	              </tr>
	              <tr>
	                <td>Efa Mikatona</td>
	                <td colspan="2">
	                <spring:bind path="formSearchFifidianana.datyManakatona" >
                      <input name="${status.expression}" type="text" id="datyMikatona" value="<%=formSearchFifidianana.getDatyManakatona() != null ? Utils.sfDateFormatJJMMYYYY.format(formSearchFifidianana.getDatyManakatona()) : ""%>" size="10" class="inputleft" />
                      <img src="<%=request.getContextPath()%>/images/icon_calendar.gif" id="imgDateMikatona" width="16" height="16" />
		            </spring:bind>
                    </td>
	              </tr>
	            </table>
		      </td>

	          <td colspan="2">&nbsp;</td>
	        </tr>
                       
            <tr>
	          <td colspan="2" align="left">&nbsp;</td>
	          <td>&nbsp;</td>
	          <td align="right"><input name="Valider" class="button" id="boutonValider" value="Tadiavo" type="submit" /></td>
		      <td>&nbsp;</td>          
              <td>&nbsp;</td>
	        </tr>
          </table>
        </td>
	  </tr>
    </table>

    <spring:bind path="formSearchFifidianana.pageNo">
       <input name="${status.expression}" id="pageNo" value="${status.value}" type="hidden" />
    </spring:bind>

    <spring:bind path="formSearchFifidianana.from">
       <input name="${status.expression}" id="from" value="${status.value}" type="hidden" />
    </spring:bind>
	
    </form>
	  
   </td>
  </tr>

   <%
  List<Fifidianana> fifidiananas = (List<Fifidianana>)request.getAttribute(ConstantUtils.sfDATA_FIFIDIANANAS);
  if (fifidiananas != null && fifidiananas.size() > 0){ %>
  <tr>
    <td>
      <%@ include file="pagination.jsp" %>
    </td>
  </tr>
  <tr>
    <td>
		<table align="center" bgcolor="#ffffff" border="0" cellpadding="3" cellspacing="0" width="100%">
	    <tr>
	      <td colspan="5">
	        <table width="100%" border="1">
	          <tr>
			      <td width="17%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Fitandremana</b></div></td>
			      <td width="30%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Fifidianana</b></div></td>
			      <td width="23%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Karazany</b></div></td>
			      <td width="20%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Taom-panompoana</b></div></td>
			      <td width="10%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Mikatona</b></div></td>
			  </tr>
	        </table>
	      </td>
	    </tr>
        
        <%
        Date now = new Date();
		for (int i = 0; i < fifidiananas.size(); i++){
		    Fifidianana fifidianana = fifidiananas.get(i);
		    out.println("<tr>");
		    if (i % 2 == 0){%>
	          <td width="17%" bgcolor="#66CCFF"><div align="center" class="Style8"><a href="<%=request.getContextPath()%>/admin/editFifidianana.htm?<%=ConstantUtils.sfFifidiananaId%>=<%=fifidianana.getId()%>" title="Manova ny fifidianana"><%=fifidianana.getFitandremana().getLabel()%></a></div></td>
	          <td width="30%" bgcolor="#66CCFF"><div align="left" class="Style8"><a href="selectFifidianana.htm?id=<%=fifidianana.getId()%>" title="Misafidy fifidianana hokirakiraina"><%=fifidianana.getLabel()%></a></div></td>
	          <td width="23%" bgcolor="#66CCFF"><div align="left" class="Style8"><a href="selectFifidianana.htm?id=<%=fifidianana.getId()%>" title="Misafidy fifidianana hokirakiraina"><%=fifidianana.getKarazamPifidianana().getLabel()%></a></div></td>
	          <td width="20%" bgcolor="#66CCFF"><div align="center" class="Style8"><%=fifidianana.getTaomPanompoana().toString()%></div></td>
	          <td width="10%" bgcolor="#66CCFF"><div align="left" class="Style8">
	        <%
              if (fifidianana.isMikatona(now)){%>
                Eny
            <%
              }else{%>
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
	          <td width="17%" bgcolor="#C0C0C0"><div align="center" class="Style8"><a href="<%=request.getContextPath()%>/admin/editFifidianana.htm?<%=ConstantUtils.sfFifidiananaId%>=<%=fifidianana.getId()%>" title="Manova ny fifidianana"><%=fifidianana.getFitandremana().getLabel()%></a></div></td>
	          <td width="30%" bgcolor="#C0C0C0"><div align="left" class="Style8"><a href="selectFifidianana.htm?id=<%=fifidianana.getId()%>"><%=fifidianana.getLabel()%></a></div></td>
	          <td width="23%" bgcolor="#C0C0C0"><div align="left" class="Style8"><a href="selectFifidianana.htm?id=<%=fifidianana.getId()%>"><%=fifidianana.getKarazamPifidianana().getLabel()%></a></div></td>
	          <td width="20%" bgcolor="#C0C0C0"><div align="center" class="Style8"><%=fifidianana.getTaomPanompoana().toString()%></div></td>
	          <td width="10%" bgcolor="#C0C0C0"><div align="left" class="Style8">
	        <%
              if (fifidianana.isMikatona(now)){%>
                Eny
            <%
              }else{%>
                Tsia
            <%
              }
	        %>
	      </div>
	      </td>
		<%
		   }
		   out.println("</tr>");
		}
	}
	else{
	    if (fifidiananas != null){
	%>
	 <tr>
       <td colspan="5" align="center" bgcolor="#FF0000">Tsy misy mifanaraka amin'ny sivana.</td>
	 </tr>
	<%
		}
	}
	%>
		</table>
    </td>
  </tr>
	
</table>

<script language="javascript">
	Calendar.setup({
		inputField     :    "datyMikatona",     // id of the input field
		ifFormat       :    "%d/%m/%Y",      // format of the input field
		button         :    "imgDateMikatona",  // trigger for the calendar (button ID)
		align          :    "Tl",           // alignment (defaults to "Bl")
		singleClick    :    true
	});

</script>

<!-- fin corps -->

<%@ include file="/footer.jsp" %>
