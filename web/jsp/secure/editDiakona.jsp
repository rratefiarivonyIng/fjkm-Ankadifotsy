<%@ include file="/jsp/include.jsp" %>

<%@ page import="java.util.List" %>

<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>
<%@ page import="mg.fjkm.ankadifotsy.util.Utils" %>

<%@ page import="mg.fjkm.ankadifotsy.bo.Diakona" %>
<%@ page import="mg.fjkm.ankadifotsy.bo.Fitandremana" %>
<%@ page import="mg.fjkm.ankadifotsy.bo.TaomPanompoana" %>
<%@ page import="mg.fjkm.ankadifotsy.bo.Mpivavaka" %>

<%@ page import="mg.fjkm.ankadifotsy.form.FormDiakona" %>

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
<%!
	FormDiakona formDiakona;
%>
<%
	formDiakona = (FormDiakona)request.getAttribute(FormDiakona.sfFORM_ID);
%>

<table align="center" border="0">
  <tr>
	<td>
		<%@ include file="/onglet.jsp" %>
    </td>
  </tr>
  
  <%@ include file="showFifidianana.jsp" %>  
  
  <tr>
    <td>
	  <div class="title1">Fampahafantarana Diakona: </div><br>
	</td>
  </tr>
  
  <tr>
    <td>
	<form id="formDiakona" name="formDiakona" method="post" action="editDiakona.htm">
	<table width="93%" align="center" border="1" cellpadding="0" cellspacing="0">
	  <tr>
	    <td colspan="2">
	      <table width="100%"  border="0">
	        <tr>
	          <td colspan="2" valign="top">
	            <table width="90%" border="0">
	              <tr>
	                <td width="50%" align="left">Fitandremana *</td>
	                <td align="left">
			        <spring:bind path="formDiakona.fitandremana" >
          	        <!-- la saisie à autocompléter -->
		              <input class="inputleft" id="fitandremanaLabel" name="fitandremanaLabel" type="text" size="22" value="${formDiakona.fitandremana.label}" />	
		            <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
		              <input type="hidden" id="fitandremanaID" name="${status.expression}" value="${formDiakona.fitandremana.id}" />	
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
			        <spring:bind path="formDiakona.laharana">
		            <td title="Laharana ho an'ny mpandray">Laharana </td>
		            <td align="center">
		      	      <input name="${status.expression}" value="${status.value}" type="text" size="18" />
		      	      <font color="red" size="1.2">${status.errorMessage}</font>
		            </td>
		            </spring:bind>
	              </tr>
	              
	              <tr>
	                <td>Mpandray</td>
                    <td>
                      <%=Utils.sfDateFormatJJMMYYYY.format(formDiakona.getDatyMpandray())%>
                    </td>
	              </tr>
	            </table>
	          </td>
	          
	          <td colspan="2" valign="top">
	            <table width="100%" border="0">
	              <tr>
	                <td>Niaviana </td>
	                <td colspan="2" align="left">
			        <spring:bind path="formDiakona.fitandremanaNiaviana" >
          	        <!-- la saisie à autocompléter -->
		              <input class="inputleft" id="fitandremanaNiavianaLabel" name="fitandremanaNiavianaLabel" type="text" size="22" value="${formDiakona.fitandremanaNiaviana.label}" />	
		            <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
		              <input type="hidden" id="fitandremanaNiavianaID" name="${status.expression}" value="${formDiakona.fitandremanaNiaviana.id}" />	
		              <span id="indicatorFitandremanaNiavianaID" style="display:none;"><img src="<%=request.getContextPath()%>/images/indicator.gif" /></span>
		              <font color="red" size="1.2">${status.errorMessage}</font>
              
                    <ajax:autocomplete
				      source="fitandremanaNiavianaLabel"
				      target="fitandremanaNiavianaID"
				      baseUrl="fitandremanaAutoCompletion.htm"
				      className="autocomplete"
				      indicator="indicatorFitandremanaNiavianaID"
				      minimumCharacters="1"
			        />                  
                    </spring:bind>
	                </td>
	              </tr>
	              
	              <tr>
	                <td width="45%">Taom-panompoana *</td>
	                <spring:bind path="formDiakona.taomPanompoana">
	                <td>
	                  <select name="${status.expression}" id="taomPanompoana" >
				      <%
					    List<TaomPanompoana> taomPanompoanas = (List<TaomPanompoana>) request.getAttribute(ConstantUtils.sfDATA_TAOMPANOMPOANAS);
					    for (TaomPanompoana taomPanompoana : taomPanompoanas){
						  if (taomPanompoana.getId().equals(formDiakona.getTaomPanompoana().getId()))
							out.println("<option value='"+taomPanompoana.getId()+"' selected='true' >"+taomPanompoana.toString()+"</option>");
						  else
							out.println("<option value='"+taomPanompoana.getId()+"'>"+taomPanompoana.toString()+"</option>");
					    }
			          %>
	                  </select>
	                  <font color="red" size="1.2">${status.errorMessage}</font>	                
			        </td>
			        </spring:bind>
			        <td>
			        </td>
	              </tr>

	              <tr>
	                <td>tao </td>
	                <td>
			        <spring:bind path="formDiakona.fitandremanaDiakona" >
          	        <!-- la saisie à autocompléter -->
		              <input class="inputleft" id="fitandremanaDiakonaLabel" name="fitandremanaDiakonaLabel" type="text" size="22" value="${formDiakona.fitandremanaDiakona.label}" />	
		            <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
		              <input type="hidden" id="fitandremanaDiakonaID" name="${status.expression}" value="${formDiakona.fitandremanaDiakona.id}" />	
		              <span id="indicatorFitandremanaDiakonaID" style="display:none;"><img src="<%=request.getContextPath()%>/images/indicator.gif" /></span>
		              <font color="red" size="1.2">${status.errorMessage}</font>
              
                    <ajax:autocomplete
				      source="fitandremanaDiakonaLabel"
				      target="fitandremanaDiakonaID"
				      baseUrl="fitandremanaAutoCompletion.htm"
				      className="autocomplete"
				      indicator="indicatorFitandremanaDiakonaID"
				      minimumCharacters="1"
			        />                  
                    </spring:bind>
	                </td>
	              </tr>
	            </table>
		      </td>
              
              <td>&nbsp;</td>
	          <td align="right"><img src="<%=request.getContextPath()%>/<%=formDiakona.getPhotoName(request)%>" width="80" height="80"/></td>
	        </tr>
       
            <tr>
		      <spring:bind path="formDiakona.anarana">
              <td width="12%">Anarana *</td>
              <td align="left" width="23%">
          	    <input name="${status.expression}" value="${status.value}" type="text" size="22"  />
          	    <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
              </spring:bind>
		      <spring:bind path="formDiakona.fanampiny">
              <td width="10%">Fanampiny </td>
              <td width="23%">
          	    <input name="${status.expression}" value="${status.value}" type="text" size="22"  />
          	    <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
              </spring:bind>
		      <td colspan="2">
		      <spring:bind path="formDiakona.lahy">
                <table valign="TOP" align="right">
                  <tr>
	              <c:choose>
	              <c:when test="${status.value}">
	                <td><input class="inputleft" name="${status.expression}" type="radio" value="true" checked="true" />Lahy</td>
	                <td><input class="inputleft" name="${status.expression}" type="radio" value="false" />Vavy</td>
	              </c:when>
	              <c:otherwise>
	                <td><input class="inputleft" name="${status.expression}" type="radio" value="true" />Lahy</td>
	                <td><input class="inputleft" name="${status.expression}" type="radio" value="false" checked="true" />Vavy</td>
	              </c:otherwise>
	              </c:choose>
                  </tr>
                </table>
              </spring:bind>
		      </td>          
            </tr>

            <tr>
              <td>Teraka ny </td>
	  		  <spring:bind path="formDiakona.datyTeraka">
              <td>
                <input name="${status.expression}" type="text" id="dateTeraka" value="${status.value}" size="10" class="inputleft" />
                <img src="<%=request.getContextPath()%>/images/icon_calendar.gif" id="imgDateTeraka" width="16" height="16" />
              </td>
              </spring:bind>
              <td align="left"> tao </td>
              <spring:bind path="formDiakona.toeranaTeraka">
              <td align="right">
                <input type="text" size="22" name="${status.expression}" value="${status.value}" />
        	    <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
              </spring:bind>
		      <td>&nbsp;</td>          
              <td>&nbsp;</td>
            </tr>

            <tr>
              <spring:bind path="formDiakona.laharanaCIN">
              <td>Karapanondro </td>
              <td align="left">
                <input type="text" size="22" name="${status.expression}" value="${status.value}"  />
                <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
              </spring:bind>
              <spring:bind path="formDiakona.datyCIN">
              <td>tamin'ny </td>
              <td>
                <input name="${status.expression}" type="text" id="dateCIN" value="${status.value}" size="10" class="inputleft" />
                <img src="<%=request.getContextPath()%>/images/icon_calendar.gif" id="imgDateCIN" width="16" height="16" />
                <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
              </spring:bind>
		      <td>tao</td>          
              <td>          
	          <spring:bind path="formDiakona.taoCIN">
	          	  <!-- la saisie à autocompléter -->
			      <input class="inputleft" id="firaisanaCinLabel" name="firaisanaCinLabel" type="text" size="22" value="${formDiakona.taoCIN.label}" />	
			      <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
			      <input type="hidden" id="firaisanaCinID" name="${status.expression}" value="${formDiakona.taoCIN.id}" />	
			      <span id="indicatorFiraisanaCinID" style="display:none;"><img src="<%=request.getContextPath()%>/images/indicator.gif" /></span>
			      <font color="red" size="1.2">${status.errorMessage}</font>
	              
	              <ajax:autocomplete
					source="firaisanaCinLabel"
					target="firaisanaCinID"
					baseUrl="firaisanaAutoCompletion.htm"
					className="autocomplete"
					indicator="indicatorFiraisanaCinID"
					minimumCharacters="2"
				  />                  
	          </spring:bind>
              </td>
            </tr>

            <tr>
              <td>&nbsp;</td>
		      <td>&nbsp;</td>          
              <spring:bind path="formDiakona.datyNanoloinaCIN">
              <td>Nosoloina </td>
              <td align="left">
                <input name="${status.expression}" type="text" id="datyNanoloinaCIN" value="${status.value}" size="10" class="inputleft" />
                <img src="<%=request.getContextPath()%>/images/icon_calendar.gif" id="imgDateNanoloinaCIN" width="16" height="16" />
                <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
              </spring:bind>
              <td>tao </td>
              <td>
              <spring:bind path="formDiakona.taoNanoloinaCIN">
          	  <!-- la saisie à autocompléter -->
		        <input class="inputleft" id="firaisanaNanoloinaCinLabel" name="firaisanaNanoloinaCinLabel" type="text" size="22" value="${formDiakona.taoNanoloinaCIN.label}" />	
		      <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
		        <input type="hidden" id="firaisanaNanoloinaCinID" name="${status.expression}" value="${formDiakona.taoNanoloinaCIN.id}" />	
		        <span id="indicatorFiraisanaNanoloinaCinID" style="display:none;"><img src="<%=request.getContextPath()%>/images/indicator.gif" /></span>
		        <font color="red" size="1.2">${status.errorMessage}</font>
              
                <ajax:autocomplete
				  source="firaisanaNanoloinaCinLabel"
				  target="firaisanaNanoloinaCinID"
				  baseUrl="firaisanaAutoCompletion.htm"
				  className="autocomplete"
				  indicator="indicatorFiraisanaNanoloinaCinID"
				  minimumCharacters="2"
			    />                  
              </spring:bind>
              </td>
            </tr>
            
            <tr>
              <spring:bind path="formDiakona.adresse">
              <td>Adiresy </td>
              <td colspan="3" align="left">
			    <textarea name="${status.expression}" rows="2" cols="40">${status.value}</textarea>
                <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
              </spring:bind>
		      <td colspan="2">
		        <table width="100%">
		          <tr>
          		    <spring:bind path="formDiakona.antonAsa">
		            <td>Asa </td>
		            <td>
	          	    <!-- la saisie à autocompléter -->
			          <input class="inputleft" id="antonAsaLabel" name="antonAsaLabel" type="text" size="22" value="${formDiakona.antonAsa.intitule}" />	
			        <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
			          <input type="hidden" id="antonAsaID" name="${status.expression}" value="${formDiakona.antonAsa.id}" />	
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
		          <tr>
          		    <spring:bind path="formDiakona.talenta">
		            <td>Talenta</td>
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
              <spring:bind path="formDiakona.firaisana">
              <td>Firaisana</td>
              <td>
          	  <!-- la saisie à autocompléter -->
		        <input class="inputleft" id="firaisanaLabel" name="firaisanaLabel" type="text" size="22" value="${formDiakona.firaisana.label}" onchange="javascript:invalidateField('faritraID');"/>	
		      <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
		        <input type="hidden" id="firaisanaID" name="${status.expression}" value="${formDiakona.firaisana.id}" />	
		        <span id="indicatorFiraisanaID" style="display:none;"><img src="<%=request.getContextPath()%>/images/indicator.gif" /></span>
		        <font color="red" size="1.2">${status.errorMessage}</font>
              
                <ajax:autocomplete
				  source="firaisanaLabel"
				  target="firaisanaID"
				  baseUrl="firaisanaAutoCompletion.htm"
				  className="autocomplete"
				  indicator="indicatorFiraisanaID"
				  minimumCharacters="2"
			    />                  
              </td>
              </spring:bind>
              <spring:bind path="formDiakona.faritra">
              <td>Faritra</td>
              <td>
          	  <!-- la saisie à autocompléter -->
                <input id="faritraLabel" name="faritraLabel" type="text" size="22" value="${formDiakona.faritra.label}"/>
		      <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
		        <input type="hidden" id="faritraID" name="${status.expression}" value="${formDiakona.faritra.id}" />
		        <span id="indicatorFaritraID" style="display:none;"><img src="<%=request.getContextPath()%>/images/indicator.gif" /></span>
		        <font color="red" size="1.2">${status.errorMessage}</font>
              
                <ajax:autocomplete
				  source="faritraLabel"
				  target="faritraID"
				  baseUrl="faritraAutoCompletion.htm"
		  		  parameters="firaisanaID={firaisanaID}"
				  className="autocomplete"
				  indicator="indicatorFaritraID"
				  minimumCharacters="2"
			    />                                
              </td>
              </spring:bind>
		      <td>&nbsp;</td>          
              <td>&nbsp;</td>
            </tr>

            <tr>
              <td>Tél : </td>
  		      <spring:bind path="formDiakona.tel">
	  	      <td align="left">
	            <input type="text" size="22" name="${status.expression}" value="${status.value}"  />
	            <font color="red" size="1.2">${status.errorMessage}</font>
	          </td>
	          </spring:bind>
	          <spring:bind path="formDiakona.mailaka">
	          <td align="left">E-mail </td>
	          <td align="right">
	            <input type="text" size="22" name="${status.expression}" value="${status.value}"  />
	            <font color="red" size="1.2">${status.errorMessage}</font>
	          </td>
	          </spring:bind>
              <td>&nbsp;</td>
		      <td>&nbsp;</td>          
            </tr>

            <tr>
              <td>Vady </td>
              <spring:bind path="formDiakona.vady">
              <td align="left">
                <input type="text" size="22" name="${status.expression}" value="${status.value}"  />
                <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
              </spring:bind>
              <td colspan="4"> 
                <table width="100%" border="0">
                  <tr>
                    <td width="15%">Fanambadiana</td>
		            <td width="37%"><%= formDiakona.getDatyFanambadiana() != null ? Utils.sfDateFormatJJMMYYYY.format(formDiakona.getDatyFanambadiana()) : "" %></td>          
                    <td width="5%">tao</td>
                    <td>${formDiakona.fitandremanaFanambadiana.label}</td>
                  </tr>
                </table>
              </td>
            </tr>

            <tr>
              <td colspan="2">Efa nisara-panambadiana ve ?</td>
              <td colspan="2">
		      <spring:bind path="formDiakona.nisaraBady">
                <table align="center" width="100%">
                  <tr>
	              <c:choose>
	              <c:when test="${status.value}">
	                <td width="50%"><input class="inputleft" name="${status.expression}" type="radio" value="true" checked="true" />Eny</td>
	                <td><input class="inputleft" name="${status.expression}" type="radio" value="false" />Tsia</td>
	              </c:when>
	              <c:otherwise>
	                <td width="50%"><input class="inputleft" name="${status.expression}" type="radio" value="true" />Eny</td>
	                <td><input class="inputleft" name="${status.expression}" type="radio" value="false" checked="true" />Tsia</td>
	              </c:otherwise>
	              </c:choose>
                  </tr>
                </table>
              </spring:bind>              
              </td>
              <td colspan="2">&nbsp;</td>
            </tr>

            <tr>
              <td>Isan'ny zanaka </td>
              <td>${formDiakona.isaZanaka}</td>
              <td>ka lahy </td>
              <spring:bind path="formDiakona.isaZanakaLahy">
              <td align="left">
                <input type="text" size="22" name="${status.expression}" value="${status.value}"  />
                <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
              </spring:bind>
              <td>ka vavy </td>
              <spring:bind path="formDiakona.isaZanakaVavy">
              <td align="left">
                <input type="text" size="22" name="${status.expression}" value="${status.value}"  />
                <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
              </spring:bind>
            </tr>

            <tr>
              <td colspan="2">&nbsp;</td>
              <td>Vita batisa </td>
              <spring:bind path="formDiakona.isaZanakaVitaBatisa">
              <td align="left">
                <input type="text" size="22" name="${status.expression}" value="${status.value}"  />
                <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
              </spring:bind>
              <td>Mpandray </td>
              <spring:bind path="formDiakona.isaZanakaMpandray">
              <td align="left">
                <input type="text" size="22" name="${status.expression}" value="${status.value}"  />
                <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
              </spring:bind>                  
            </tr>

			<!-- Historique naha-diakona -->
			<%
			Mpivavaka mpivavaka = formDiakona.getMpivavaka();
			if (mpivavaka.efaDiakona()){%>
			<tr>
			  <td>Efa Diakona</td>
			  <td >
			    <table>
			      <tr bgcolor="#6633FF">
			        <td><b>Taona</b></td>
			        <td><b>Fitandremana</b></td>
			      </tr>
			    <%
			    for (Diakona diakona : mpivavaka.getAllDiakona()){ %>
			      <tr>
			        <td><%=diakona.getTaomPanompoana().toString()%></td>
			        <td><%=diakona.getFitandremana().getLabel()%></td>
			      </tr>
			    <%
			    }
			    %>
			    </table>
			  </td>
			</tr>
			<%
			}
			else{%>
			<tr>
			  <td colspan="6">Mbola tsy diakona</td>
			</tr>
			<%
			}
			%>
            <tr>
              <td colspan="6">&nbsp;</td>
            </tr>
        
            <tr>
	          <td>&nbsp;</td>	          
	          <% if (formDiakona.isFromSearch()) {%>
	          <td align="center"><input name="Miverina" class="button" id="boutonMiverina" value="Miverina" type="button" onclick="javascript: document.location='searchChristianAjax.htm?reload&from=<%=request.getSession().getAttribute(ConstantUtils.sfSelectedTab)%>';"/></td>
	          <%
	          } 
	          else { 
	          %>
	          <td align="center"><input name="Miverina" class="button" id="boutonMiverina" value="Miverina" type="button" onclick="javascript: document.location='index.htm?<%=request.getSession().getAttribute(ConstantUtils.sfSelectedTab)%>';"/></td>
	          <% 
	          } 
	          %>
		      <td>&nbsp;</td>          
              <td>&nbsp;</td>
	          <td align="right"><input name="Valider" class="button" id="boutonValider" value="Alefa" type="submit" /></td>
	        </tr>
          </table>
        </td>
	  </tr>
	</table>
    </form>
	  
    </td>
  </tr>
  
  <tr>
    <td>
    <!-- Information de création et de dernière modification -->
      <%@ include file="infoCreation.jsp" %>	
	</td>
  </tr>
</table>

<script language="javascript">
	Calendar.setup({
		inputField     :    "datyTeraka",     // id of the input field
		ifFormat       :    "%d/%m/%Y",      // format of the input field
		button         :    "imgDateTeraka",  // trigger for the calendar (button ID)
		align          :    "Tl",           // alignment (defaults to "Bl")
		singleClick    :    true
	});
</script>

<script language="javascript">
	Calendar.setup({
		inputField     :    "dateCIN",     // id of the input field
		ifFormat       :    "%d/%m/%Y",      // format of the input field
		button         :    "imgDateCIN",  // trigger for the calendar (button ID)
		align          :    "Tl",           // alignment (defaults to "Bl")
		singleClick    :    true
	});
</script>

<script language="javascript">
	Calendar.setup({
		inputField     :    "datyNanoloinaCIN",     // id of the input field
		ifFormat       :    "%d/%m/%Y",      // format of the input field
		button         :    "imgDateNanoloinaCIN",  // trigger for the calendar (button ID)
		align          :    "Tl",           // alignment (defaults to "Bl")
		singleClick    :    true
	});
</script>

<!-- fin corps -->

<%@ include file="/footer.jsp" %>
