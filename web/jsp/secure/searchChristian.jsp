<%@ include file="/jsp/include.jsp" %>

<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>

<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>
<%@ page import="mg.fjkm.ankadifotsy.util.Utils" %>

<%@ page import="mg.fjkm.ankadifotsy.bo.Fitandremana" %>
<%@ page import="mg.fjkm.ankadifotsy.bo.Mpivavaka" %>

<%@ page import="mg.fjkm.ankadifotsy.form.FormSearchChristian" %>

<%@ include file="/header.jsp" %>

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

<table align="center" border="0" >
  <tr>
    <td>
		<%@ include file="/onglet.jsp" %>
    </td>
  </tr>
  
  <%@ include file="showFifidianana.jsp" %>
  
  <tr>
    <td>Fitadiavana Mpivavaka : </td>
  </tr>
  
  <tr>
    <td>
	<form id="formSearchChristian" name="formSearchChristian" method="post" action="searchChristian.htm">
	<table width="100%" valign="TOP" align="center" border="1" cellpadding="0" cellspacing="0">
	  <tr>
	    <td colspan="2">
	      <table width="100%"  border="0">
	        <tr>
	          <td colspan="2">
	            <table width="90%">
	              <tr>
	                <td width="50%" align="left">Fitandremana *</td>
			        <spring:bind path="formSearchChristian.fitandremana" >
	                <td align="left">
          	        <!-- la saisie à autocompléter -->
		              <input class="inputleft" id="fitandremanaLabel" name="fitandremanaLabel" type="text" size="22" value="${formSearchChristian.fitandremana.label}" />	
		            <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
		              <input type="hidden" id="fitandremanaID" name="${status.expression}" value="${formSearchChristian.fitandremana.id}" />	
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
	                  <font color="red" size="1.2">${status.errorMessage}</font>
	                </td>
	                </spring:bind>
	              </tr>
	          
	              <tr>
			        <spring:bind path="formSearchChristian.laharana">
		            <td title="Laharana ho an'ny mpandray">Laharana </td>
		            <td align="center">
		      	      <input name="${status.expression}" value="${status.value}" type="text" size="22" />
		      	      <font color="red" size="1.2">${status.errorMessage}</font>
		            </td>
		            </spring:bind>
	              </tr>
	            </table>
	          </td>
	          <td colspan="2">
	            <table width="100%">
	              <tr>
	                <td width="30%">Batisa</td>
	                <td colspan="2">
	                <spring:bind path="formSearchChristian.batisa" >
		              <table valign="TOP">
		                <tr>
						<%
						  if (formSearchChristian.getBatisa() == 1){ %>				
			              <td><input class="inputleft" name="${status.expression}" type="radio" value="1" checked />Eny</td>
			              <td><input class="inputleft" name="${status.expression}" type="radio" value="0" />Tsia</td>
			              <td><input class="inputleft" name="${status.expression}" type="radio" value="-1" />Rehetra</td>
						<%
						} 
						else if (formSearchChristian.getBatisa() == 0) { %>
			              <td><input class="inputleft" name="${status.expression}" type="radio" value="1" />Eny</td>
			              <td><input class="inputleft" name="${status.expression}" type="radio" value="0" checked />Tsia</td>
			              <td><input class="inputleft" name="${status.expression}" type="radio" value="-1" />Rehetra</td>
						<%
						}
						else { %>
			              <td><input class="inputleft" name="${status.expression}" type="radio" value="1" />Eny</td>
			              <td><input class="inputleft" name="${status.expression}" type="radio" value="0" />Tsia</td>
			              <td><input class="inputleft" name="${status.expression}" type="radio" value="-1" checked />Rehetra</td>
						<%
						}
						%>
		                </tr>
		              </table>
		            </spring:bind>
				    </td>
	              </tr>
	              <tr>
	                <td>Mpandray</td>
	                <td colspan="2">
	                <spring:bind path="formSearchChristian.mpandray" >
		              <table valign="TOP">
		                <tr>
						<%
						  if (formSearchChristian.getMpandray() == 1){ %>				
			              <td><input class="inputleft" name="${status.expression}" type="radio" value="1" checked />Eny</td>
			              <td><input class="inputleft" name="${status.expression}" type="radio" value="0" />Tsia</td>
			              <td><input class="inputleft" name="${status.expression}" type="radio" value="-1" />Rehetra</td>
						<%
						} 
						else if (formSearchChristian.getMpandray() == 0) { %>
			              <td><input class="inputleft" name="${status.expression}" type="radio" value="1" />Eny</td>
			              <td><input class="inputleft" name="${status.expression}" type="radio" value="0" checked />Tsia</td>
			              <td><input class="inputleft" name="${status.expression}" type="radio" value="false" />Rehetra</td>1
						<%
						}
						else { %>
			              <td><input class="inputleft" name="${status.expression}" type="radio" value="1" />Eny</td>
			              <td><input class="inputleft" name="${status.expression}" type="radio" value="0" />Tsia</td>
			              <td><input class="inputleft" name="${status.expression}" type="radio" value="-1" checked />Rehetra</td>
						<%
						}
						%>
		                </tr>
		              </table>
		            </spring:bind>
				    </td>
	              </tr>
	            </table>
		      </td>

	          <td colspan="2">
                <table>
                  <tr>
		            <spring:bind path="formSearchChristian.lahy">
                    <td colspan="2">
                      <table width="100%" >
                        <tr>
						<%
						  if (formSearchChristian.getLahy() == 1){ %>				
			              <td width="33%"><input name="${status.expression}" type="radio" value="1" checked />Lahy</td>
			              <td width="33%"><input name="${status.expression}" type="radio" value="0" />Vavy</td>
			              <td width="33%"><input name="${status.expression}" type="radio" value="-1" />Rehetra</td>
						<%
						} 
						else if (formSearchChristian.getLahy() == 0) { %>
			              <td><input name="${status.expression}" type="radio" value="1" />Lahy</td>
			              <td><input name="${status.expression}" type="radio" value="0" checked />Vavy</td>
			              <td><input name="${status.expression}" type="radio" value="-1" />Rehetra</td>
						<%
						}
						else { %>
			              <td><input name="${status.expression}" type="radio" value="1" />Lahy</td>
			              <td><input name="${status.expression}" type="radio" value="0"  />Vavy</td>
			              <td><input name="${status.expression}" type="radio" value="-1" checked />Rehetra</td>
						<%
						}
						%>
	                    </tr>
	                  </table>
	                </td>
	                </spring:bind>
                  </tr>
                  <tr>
          		    <spring:bind path="formSearchChristian.talenta">
		            <td width="27%">Talenta</td>
		            <td>
		              <input type="text" size="22" name="${status.expression}" value="${status.value}"  />
		              <font color="red" size="1.2">${status.errorMessage}</font>
		            </td>
		            </spring:bind>
                  </tr>
                </table>
		      </td>
	        </tr>
       
            <tr>
		      <spring:bind path="formSearchChristian.anarana">
              <td width="9%">Anarana *</td>
              <td align="left" width="24%">
          	    <input name="${status.expression}" value="${status.value}" type="text" size="22"  />
          	    <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
              </spring:bind>
		      <spring:bind path="formSearchChristian.fanampiny">
              <td width=10%">Fanampiny </td>
              <td width="23%">
          	    <input name="${status.expression}" value="${status.value}" type="text" size="22"  />
          	    <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
              </spring:bind>
          
              <td colspan="2">
                <table width="100%">
                  <tr>
	     	        <spring:bind path="formSearchChristian.antonAsa">
		            <td width="24%">Asa </td>
		            <td>
	          	    <!-- la saisie à autocompléter -->
			          <input class="inputleft" id="antonAsaLabel" name="antonAsaLabel" type="text" size="22" value="${formSearchChristian.antonAsa.intitule}" />	
			        <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
			          <input type="hidden" id="antonAsaID" name="${status.expression}" value="${formSearchChristian.antonAsa.id}" />	
			          <span id="indicatorAntonAsaID" style="display:none;"><img src="<%=request.getContextPath()%>/images/indicator.gif" /></span>
			          <font color="red" size="1.2">${status.errorMessage}</font>
	              
	                  <ajax:autocomplete
					    source="antonAsaLabel"
					    target="antonAsaID"
					    baseUrl="antonAsaAutoCompletion.htm"
					    className="autocomplete"
					    indicator="indicatorAntonAsaID"
					    minimumCharacters="2"
				      />
		            </td>
		            </spring:bind>
	              </tr>
	            </table>
	          </td>		  
            </tr>
                
            <tr>
	          <td colspan="2" align="left">&nbsp;</td>
	          <td>&nbsp;</td>
	          <td align="right"><input name="Valider" id="boutonValider" value="Tadiavo" type="submit" /></td>
		      <td>&nbsp;</td>          
              <td>&nbsp;</td>
	        </tr>
          </table>
        </td>
	  </tr>
    </table>

    <spring:bind path="formSearchChristian.pageNo">
       <input name="${status.expression}" id="pageNo" value="${status.value}" type="hidden" />
    </spring:bind>

    <spring:bind path="formSearchChristian.from">
       <input name="${status.expression}" id="from" value="${status.value}" type="hidden" />
    </spring:bind>
	
    </form>
	  
   </td>
  </tr>

   <%
  List<Mpivavaka> mpivavakas = (List<Mpivavaka>)request.getAttribute(ConstantUtils.sfDATA_MPIVAVAKAS);
  if (mpivavakas != null && mpivavakas.size() > 0){ %>
  <tr>
    <td>
      <%@ include file="pagination.jsp" %>
    </td>
  </tr>
  <tr>
    <td>
		<table valign="TOP" align="center" bgcolor="#ffffff" border="0" cellpadding="3" cellspacing="0" width="100%">
	    <tr>
	      <% if (ConstantUtils.sfFromDiakona.equals(formSearchChristian.getFrom()) || ConstantUtils.sfFromFifidianana.equals(formSearchChristian.getFrom())){%>
	      <td colspan="7">
	      <%}else{%>
	      <td colspan="5">
	      <%}%>
	        <table width=100%" border="1">
	          <tr>
                  <td align="left" width="5%" bgcolor="#48A9D2">&nbsp;</td>
			      <td width="12%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Laharana</b></div></td>
			      <td width="22%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Anarana</b></div></td>
			      <td width="15%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Fanampiny</b></div></td>
			      <td width="22%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Adiresy</b></div></td>
			      <% if (ConstantUtils.sfFromDiakona.equals(formSearchChristian.getFrom()) || ConstantUtils.sfFromFifidianana.equals(formSearchChristian.getFrom())){
			      %>
			      <td width="15%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Diakona</b></div></td>
			      <td width="14%" bgcolor="#48A9D2"><div align="center" class="Style8"><b>Azo fidiana</b></div></td>
			      <%
			      }
			      %>
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
	      <td width="12%" bgcolor="#66CCFF"><div align="center" class="Style8"><a href="editChristian.htm?laharana=<%=mpivavaka.getLaharana()%>"><%=mpivavaka.getLaharana() != null ? mpivavaka.getLaharana() : "" %></a></div></td>
	      <td width="22%" bgcolor="#66CCFF"><div align="left" class="Style8"><a href="editChristian.htm?id=<%=mpivavaka.getId()%>"><%=mpivavaka.getAnarana()%></a></div></td>
	      <td width="15%" bgcolor="#66CCFF"><div align="left" class="Style8"><%=mpivavaka.getFanampiny()%></div></td>
	      <td width="22%" bgcolor="#66CCFF"><div align="left" class="Style8"><%=mpivavaka.getAdresse()%></div></td>
		      <% if (ConstantUtils.sfFromDiakona.equals(formSearchChristian.getFrom()) || ConstantUtils.sfFromFifidianana.equals(formSearchChristian.getFrom())){
		          if (mpivavaka.isDiakona(now)){ %>
		          <td width="15%" bgcolor="#66CCFF"><div align="center" class="Style8">
		            Amperin'asa</div>
		          </td>
		          <td width="14%" bgcolor="#66CCFF"><div align="center" class="Style8">
		            <a href="editDiakona.htm?id=<%=mpivavaka.getId()%>">Eny</a></div>
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
		            <a href="editDiakona.htm?id=<%=mpivavaka.getId()%>">Eny</a></div>
		          </td>
		        <%
		            }
		            else if (mpivavaka.isElligibleDiakona(now)){%>
		          <td width="15%" bgcolor="#66CCFF"><div align="center" class="Style8">
		            Tsia</div>
		          </td>
		          <td width="14%" bgcolor="#66CCFF"><div align="center" class="Style8">
		            <a href="editDiakona.htm?id=<%=mpivavaka.getId()%>">Eny</a></div>
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
		   	}
		   	else{
		   	%>
          <td width="4%" bgcolor="#C0C0C0"><img src="<%=request.getContextPath()%>/<%=Utils.getPhotoName(request, mpivavaka)%>" width="50" height="50"/></td>
	      <td width="12%" bgcolor="#C0C0C0"><div align="center" class="Style8"><a href="editChristian.htm?laharana=<%=mpivavaka.getLaharana()%>"><%=mpivavaka.getLaharana() != null ? mpivavaka.getLaharana() : "" %></a></div></td>
	      <td width="22%" bgcolor="#C0C0C0"><div align="left" class="Style8"><a href="editChristian.htm?id=<%=mpivavaka.getId()%>"><%=mpivavaka.getAnarana()%></a></div></td>
	      <td width="15%" bgcolor="#C0C0C0"><div align="left" class="Style8"><%=mpivavaka.getFanampiny()%></div></td>
	      <td width="22%" bgcolor="#C0C0C0"><div align="left" class="Style8"><%=mpivavaka.getAdresse()%></div></td>
		      <% if (ConstantUtils.sfFromDiakona.equals(formSearchChristian.getFrom()) || ConstantUtils.sfFromFifidianana.equals(formSearchChristian.getFrom())){
		          if (mpivavaka.isDiakona(now)){ %>
		          <td width="15%" bgcolor="#C0C0C0"><div align="center" class="Style8">
		            Amperin'asa</div>
		          </td>
		          <td width="14%" bgcolor="#C0C0C0"><div align="center" class="Style8">
		            <a href="editDiakona.htm?id=<%=mpivavaka.getId()%>">Eny</a></div>
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
		            <a href="editDiakona.htm?id=<%=mpivavaka.getId()%>">Eny</a></div>
		          </td>
		        <%
		            }
		            else if (mpivavaka.isElligibleDiakona(now)){%>
		          <td width="15%" bgcolor="#C0C0C0"><div align="center" class="Style8">
		            Tsia</div>
		          </td>
		          <td width="14%" bgcolor="#C0C0C0"><div align="center" class="Style8">
		            <a href="editDiakona.htm?id=<%=mpivavaka.getId()%>">Eny</a></div>
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
		   }
		   out.println("</tr>");
		}
	}
	else{
	    if (mpivavakas != null){
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

<%
  //auto-Submit pour afficher les résultats précédents
  if (formSearchChristian.isSubmit()){
%>
<script language="javascript">
	submitFormFromLink('<%=formSearchChristian.getPageNo()%>');
</script>
<%
  }
%>

<!-- fin corps -->

<%@ include file="/footer.jsp" %>
