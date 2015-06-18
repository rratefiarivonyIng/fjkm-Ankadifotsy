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

	function uploadPhoto(){
		document.forms["photoUploadForm"].submit();
	}
</script>

<!-- debut corps -->
<%!
	FormChristian formChristian;
%>
<%
	formChristian = (FormChristian)request.getAttribute(FormChristian.sfFORM_ID);
%>

<!-- Le Div qui sert à afficher les bulles d'aide -->
<div id="curseur" class="infobulle"></div>
    
<table align="center" border="0">
  <tr>
	<td>
		<%@ include file="/onglet.jsp" %>
    </td>
  </tr>

  <%@ include file="showFifidianana.jsp" %>  
    
  <tr>
    <td>
	  <div class="title1">Ampidiro ny mombamomba ny Kristiana : </div><br>
	</td>
  </tr>
  
  <tr>
    <td>
	<form id="formChristian" name="formChristian" method="post" action="editChristian.htm">
	<table width="90%" valign="TOP" align="center" border="1" cellpadding="0" cellspacing="0">
	  <tr>
	    <td colspan="2">
	      <table width="100%"  border="0">
	        <tr>
	          <td colspan="2" valign="top">
	            <table width="90%" border="0">
	              <tr>
	                <td width="50%" align="left">Fitandremana *</td>
	                <td align="left">
                    <spring:bind path="formChristian.fitandremana">
          	        <!-- la saisie à autocompléter -->
		              <input class="inputleft" id="fitandremanaLabel" name="fitandremanaLabel" type="text" size="22" value="${formChristian.fitandremana.label}" />	
		            <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
		              <input type="hidden" id="fitandremanaID" name="${status.expression}" value="${formChristian.fitandremana.id}" />	
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
			        <spring:bind path="formChristian.laharana">
		            <td title="Laharana ho an'ny mpandray">Laharana </td>
		            <td align="center">
		      	      <input name="${status.expression}" value="${status.value}" type="text" size="18" />
		      	      <font color="red" size="1.2">${status.errorMessage}</font>
		            </td>
		            </spring:bind>
	              </tr>
	              
	              <tr>
	                <td colspan="2">&nbsp;</td>
	              </tr>
	            </table>
	          </td>
	          <td colspan="2" valign="top">
	            <table width="100%" border="0">
	              <tr>
	                <td>Niaviana </td>
	                <td colspan="2" align="left">
			        <spring:bind path="formChristian.fitandremanaNiaviana" >
          	        <!-- la saisie à autocompléter -->
		              <input class="inputleft" id="fitandremanaNiavianaLabel" name="fitandremanaNiavianaLabel" type="text" size="22" value="${formChristian.fitandremanaNiaviana.label}" />	
		            <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
		              <input type="hidden" id="fitandremanaNiavianaID" name="${status.expression}" value="${formChristian.fitandremanaNiaviana.id}" />	
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
	                <td width="40%">Batisa</td>
	                <td>
	                  <div id="batisaId">
	                <% if (formChristian.isVitaBatisa()) {%>
	                  <div onMouseOver="showToolTip('Laharana <%=formChristian.getBatisa().getLaharana()%> <br/>Tamin\'ny <%=Utils.sfDateFormatJJMMYYYY.format(formChristian.getBatisa().getDaty())%> <br/> tao <%=formChristian.getBatisa().getFitandremana().getLabel()%>');" onMouseOut="hideToolTip();">Eny</div>
	                <%} 
	                   else{%>
	                  Tsia
	                <%}%> 
	                  </div>
			        </td>
			        <td>
			          <a href="#" id="ovayBatisa" onclick="javascript:editBatisa();">Ovay</a>
				    </td>
	              </tr>
	              <tr>
	                <td>Mpandray</td>
	                <td id="mpandrayId">
	                <% if (formChristian.isMpandray()) {%>
	                  <div onMouseOver="showToolTip('Laharana <%=formChristian.getMpandray().getLaharana()%> <br/>Tamin\'ny <%=Utils.sfDateFormatJJMMYYYY.format(formChristian.getMpandray().getDaty())%> <br/> tao <%=formChristian.getMpandray().getFitandremana().getLabel()%>');" onMouseOut="hideToolTip();">Eny</div>
	                <%} 
	                else{%>
	                  Tsia
	                <%}%> 
	                </td>
			        <td>
			          <a href="#" id="ovayMpandray" onclick="javascript:editMpandray();">Ovay</a>
				    </td>
	              </tr>
	            </table>
		      </td>
              
              <td>&nbsp;</td>
	          <td align="right">
                <img src="<%=request.getContextPath()%>/<%=formChristian.getPhotoName(request)%>" width="80" height="90"/>
	          </td>
	        </tr>
       
            <tr>
		      <spring:bind path="formChristian.anarana">
              <td width="12%">Anarana *</td>
              <td align="left" width="23%">
          	    <input name="${status.expression}" value="${status.value}" type="text" size="22"  />
          	    <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
              </spring:bind>
		      <spring:bind path="formChristian.fanampiny">
              <td width="10%">Fanampiny </td>
              <td width="23%">
          	    <input name="${status.expression}" value="${status.value}" type="text" size="22"  />
          	    <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
              </spring:bind>
		      <td colspan="2">
		      <spring:bind path="formChristian.lahy">
                <table valign="TOP" align="right">
                  <tr>
                  <% 
                  if (formChristian.getMpivavaka().getId() != null){
                  %>
                  <td><a href="uploadPhoto.htm">Manova ny sary</a></td>
                  <%
                  }
                  %>
	              <c:choose>
	              <c:when test="${status.value}">
	                <td><input class="inputleft" name="${status.expression}" type="radio" value="true" checked />Lahy</td>
	                <td><input class="inputleft" name="${status.expression}" type="radio" value="false" />Vavy</td>
	              </c:when>
	              <c:otherwise>
	                <td><input class="inputleft" name="${status.expression}" type="radio" value="true" />Lahy</td>
	                <td><input class="inputleft" name="${status.expression}" type="radio" value="false" checked />Vavy</td>
	              </c:otherwise>
	              </c:choose>
                  </tr>
                </table>
              </spring:bind>
		      </td>          
            </tr>

            <tr height="12">
              <td>Teraka ny </td>
	  		  <spring:bind path="formChristian.datyTeraka">
              <td>
                <input name="${status.expression}" type="text" id="datyTeraka" value="${status.value}" size="10" class="inputleft" />
                <img src="<%=request.getContextPath()%>/images/icon_calendar.gif" id="imgDateTeraka" width="16" height="16" />
              </td>
              </spring:bind>
              <td align="left"> tao </td>
              <spring:bind path="formChristian.toeranaTeraka">
              <td align="right">
                <input type="text" size="22" name="${status.expression}" value="${status.value}" />
        	    <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
              </spring:bind>
              
              <td colspan="2">&nbsp;</td>
            </tr>

            <tr>
              <spring:bind path="formChristian.laharanaCIN">
              <td>Karapanondro </td>
              <td align="left">
                <input type="text" size="22" name="${status.expression}" value="${status.value}"  />
                <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
              </spring:bind>
              <spring:bind path="formChristian.datyCIN">
              <td>tamin'ny </td>
              <td>
                <input name="${status.expression}" type="text" id="dateCIN" value="${status.value}" size="10" class="inputleft" />
                <img src="<%=request.getContextPath()%>/images/icon_calendar.gif" id="imgDateCIN" width="16" height="16" />
                <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
              </spring:bind>
		      <td>tao</td>          
              <td>          
	          <spring:bind path="formChristian.taoCIN">
	          	  <!-- la saisie à autocompléter -->
			      <input class="inputleft" id="firaisanaCinLabel" name="firaisanaCinLabel" type="text" size="22" value="${formChristian.taoCIN.label}" />	
			      <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
			      <input type="hidden" id="firaisanaCinID" name="${status.expression}" value="${formChristian.taoCIN.id}" />	
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
              <spring:bind path="formChristian.datyNanoloinaCIN">
              <td>Nosoloina </td>
              <td align="left">
                <input name="${status.expression}" type="text" id="datyNanoloinaCIN" value="${status.value}" size="10" class="inputleft" />
                <img src="<%=request.getContextPath()%>/images/icon_calendar.gif" id="imgDateNanoloinaCIN" width="16" height="16" />
                <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
              </spring:bind>
              <td>tao </td>
              <td>
              <spring:bind path="formChristian.taoNanoloinaCIN">
          	  <!-- la saisie à autocompléter -->
		        <input class="inputleft" id="firaisanaNanoloinaCinLabel" name="firaisanaNanoloinaCinLabel" type="text" size="22" value="${formChristian.taoNanoloinaCIN.label}" />	
		      <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
		        <input type="hidden" id="firaisanaNanoloinaCinID" name="${status.expression}" value="${formChristian.taoNanoloinaCIN.id}" />	
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
              <td>Ray </td>
              <td align="left">
          	  <!-- la saisie à autocompléter -->
              <spring:bind path="formChristian.mpivavakaRayAnarana">
		        <input class="inputleft" id="mpivavakaRayAnarana" name="${status.expression}" type="text" size="22" value="${status.value}" />	
		        <font color="red" size="1.2">${status.errorMessage}</font>
		      </spring:bind>
		      <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
              <spring:bind path="formChristian.ray_">
		        <input type="hidden" id="rayID" name="${status.expression}" value="${formChristian.ray_.id}" />	
		        <span id="indicatorRayID" style="display:none;"><img src="<%=request.getContextPath()%>/images/indicator.gif" /></span>
		        <font color="red" size="1.2">${status.errorMessage}</font>
              </spring:bind>
              
                <ajax:autocomplete
				  source="mpivavakaRayAnarana"
				  target="rayID"
				  baseUrl="mpivavakaAutoCompletion.htm"
		  		  parameters="excluMpivavakaID=${formChristian.mpivavaka.id},lehilahy=1"
				  className="autocomplete"
				  indicator="indicatorRayID"
				  minimumCharacters="1"
			    />                  
              </td>
              <td>Reny </td>
              <td>
          	  <!-- la saisie à autocompléter -->
              <spring:bind path="formChristian.mpivavakaRenyAnarana">
		        <input class="inputleft" id="mpivavakaRenyAnarana" name="${status.expression}" type="text" size="22" value="${status.value}" />	
		        <font color="red" size="1.2">${status.errorMessage}</font>
		      </spring:bind>
		      <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
              <spring:bind path="formChristian.reny_">
		        <input type="hidden" id="renyID" name="${status.expression}" value="${formChristian.reny_.id}" />	
		        <span id="indicatorRenyID" style="display:none;"><img src="<%=request.getContextPath()%>/images/indicator.gif" /></span>
		        <font color="red" size="1.2">${status.errorMessage}</font>
              </spring:bind>
              
                <ajax:autocomplete
				  source="mpivavakaRenyAnarana"
				  target="renyID"
				  baseUrl="mpivavakaAutoCompletion.htm"
		  		  parameters="excluMpivavakaID=${formChristian.mpivavaka.id},lehilahy=0"
				  className="autocomplete"
				  indicator="indicatorRenyID"
				  minimumCharacters="1"
			    />                  
              </td>
              <td>&nbsp;</td>
		      <td>&nbsp;</td>          
            </tr>

            <tr>
              <td>Vady </td>
              <td align="left">
          	  <!-- la saisie à autocompléter -->
              <spring:bind path="formChristian.mpivavakaAnaranaVady">
		        <input class="inputleft" id="mpivavakaVadyAnarana" name="${status.expression}" type="text" size="22" value="${status.value}" />	
		        <font color="red" size="1.2">${status.errorMessage}</font>
		      </spring:bind>
		      <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
              <spring:bind path="formChristian.vady">
		        <input type="hidden" id="vadyID" name="${status.expression}" value="${formChristian.vady.id}" />	
		        <span id="indicatorVadyID" style="display:none;"><img src="<%=request.getContextPath()%>/images/indicator.gif" /></span>
		        <font color="red" size="1.2">${status.errorMessage}</font>
              </spring:bind>
              
                <ajax:autocomplete
				  source="mpivavakaVadyAnarana"
				  target="vadyID"
				  baseUrl="mpivavakaAutoCompletion.htm"
		  		  parameters="excluMpivavakaID=${formChristian.mpivavaka.id},excluLehilahy=${formChristian.lahy}"
				  className="autocomplete"
				  indicator="indicatorVadyID"
				  minimumCharacters="1"
			    />                  
              </td>
              <td>Tamin'ny</td>
              <spring:bind path="formChristian.datyFanambadiana">
		      <td>
                <input name="${status.expression}" type="text" id="datyFanambadiana" value="${status.value}" size="10" class="inputleft" />
                <img src="<%=request.getContextPath()%>/images/icon_calendar.gif" id="imgDateFanambadiana" width="16" height="16" />
                <font color="red" size="1.2">${status.errorMessage}</font>
              </td>          
              </spring:bind>
              <td>tao</td>
              <td>
              <spring:bind path="formChristian.fitandremanaFanambadiana">
          	  <!-- la saisie à autocompléter -->
		        <input class="inputleft" id="fitandremanaFanambadianaLabel" name="fitandremanaFanambadianaLabel" type="text" size="22" value="${formChristian.fitandremanaFanambadiana.label}" />	
		      <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
		        <input type="hidden" id="fitandremanaFanambadianaID" name="${status.expression}" value="${formChristian.fitandremanaFanambadiana.id}" />	
		        <span id="indicatorFitandremanaFanambadianaID" style="display:none;"><img src="<%=request.getContextPath()%>/images/indicator.gif" /></span>
		        <font color="red" size="1.2">${status.errorMessage}</font>
              
                <ajax:autocomplete
				  source="fitandremanaFanambadianaLabel"
				  target="fitandremanaFanambadianaID"
				  baseUrl="fitandremanaAutoCompletion.htm"
				  className="autocomplete"
				  indicator="indicatorFitandremanaFanambadianaID"
				  minimumCharacters="1"
			    />                  
              </spring:bind>
              </td>
            </tr>

            <tr>
              <spring:bind path="formChristian.adresse">
              <td>Adiresy </td>
              <td colspan="3" align="left">
			    <textarea name="${status.expression}" rows="3" cols="40">${status.value}</textarea>
                <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
              </spring:bind>
		      <td colspan="2">
		        <table width="100%">
		          <tr>
          		    <spring:bind path="formChristian.antonAsa">
		            <td>Asa </td>
		            <td>
	          	    <!-- la saisie à autocompléter -->
			          <input class="inputleft" id="antonAsaLabel" name="antonAsaLabel" type="text" size="22" value="${formChristian.antonAsa.intitule}" />	
			        <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
			          <input type="hidden" id="antonAsaID" name="${status.expression}" value="${formChristian.antonAsa.id}" />	
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
          		    <spring:bind path="formChristian.talenta">
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
              <spring:bind path="formChristian.firaisana">
              <td>Firaisana</td>
              <td>
          	  <!-- la saisie à autocompléter -->
		        <input class="inputleft" id="firaisanaLabel" name="firaisanaLabel" type="text" size="22" value="${formChristian.firaisana.label}" onchange="javascript:invalidateField('faritraID');"/>	
		      <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
		        <input type="hidden" id="firaisanaID" name="${status.expression}" value="${formChristian.firaisana.id}" />	
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
              <spring:bind path="formChristian.faritra">
              <td>Faritra</td>
              <td>
          	  <!-- la saisie à autocompléter -->
                <input id="faritraLabel" name="faritraLabel" type="text" size="22" value="${formChristian.faritra.label}"/>
		      <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
		        <input type="hidden" id="faritraID" name="${status.expression}" value="${formChristian.faritra.id}" />
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
  		      <spring:bind path="formChristian.tel">
	  	      <td align="left">
	            <input type="text" size="22" name="${status.expression}" value="${status.value}"  />
	            <font color="red" size="1.2">${status.errorMessage}</font>
	          </td>
	          </spring:bind>
	          <spring:bind path="formChristian.mailaka">
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
              <td colspan="7">&nbsp;</td>
            </tr>
        
            <tr>
	          <td>&nbsp;</td>
	          <% if (formChristian.isFromSearch()) {%>
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

	Calendar.setup({
		inputField     :    "dateCIN",     // id of the input field
		ifFormat       :    "%d/%m/%Y",      // format of the input field
		button         :    "imgDateCIN",  // trigger for the calendar (button ID)
		align          :    "Tl",           // alignment (defaults to "Bl")
		singleClick    :    true
	});

	Calendar.setup({
		inputField     :    "datyNanoloinaCIN",     // id of the input field
		ifFormat       :    "%d/%m/%Y",      // format of the input field
		button         :    "imgDateNanoloinaCIN",  // trigger for the calendar (button ID)
		align          :    "Tl",           // alignment (defaults to "Bl")
		singleClick    :    true
	});

	Calendar.setup({
		inputField     :    "datyFanambadiana",     // id of the input field
		ifFormat       :    "%d/%m/%Y",      // format of the input field
		button         :    "imgDateFanambadiana",  // trigger for the calendar (button ID)
		align          :    "Tl",           // alignment (defaults to "Bl")
		singleClick    :    true
	});
</script>

<!-- Message d'erreur éventuel -->
<%
  if (request.getAttribute(ConstantUtils.sfMessageEnregistrementKO) != null){
%>
<script language="javascript">
function showErrorMessage (){
	var options = {
		"title": "Valin'ny fangatahana",
		"button": "OK",
		"className":"error",
		"modal":"true"
	};
	    
	msg.open("Nisy tsy nety ny fampidirana na fanovàna mpivavaka tianao hatao", options);
	return false;
};

showErrorMessage();
</script>
<%
  }
%>

<%@ include file="editTrangaScript.jsp" %>

<!-- fin corps -->

<!-- pied de page -->
<%@ include file="/footer.jsp" %>
