<%@ include file="/jsp/include.jsp" %>

<%@ page import="java.util.List" %>

<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>
<%@ page import="mg.fjkm.ankadifotsy.util.Utils" %>

<%@ page import="mg.fjkm.ankadifotsy.bo.Diakona" %>
<%@ page import="mg.fjkm.ankadifotsy.bo.Fitandremana" %>
<%@ page import="mg.fjkm.ankadifotsy.bo.TaomPanompoana" %>
<%@ page import="mg.fjkm.ankadifotsy.bo.Mpivavaka" %>

<%@ page import="mg.fjkm.ankadifotsy.form.FormMirotsakaFidiana" %>

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
	FormMirotsakaFidiana formMirotsakaFidiana;
%>
<%
	formMirotsakaFidiana = (FormMirotsakaFidiana)request.getAttribute(FormMirotsakaFidiana.sfFORM_ID);
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
	  <div class="title1">Firotsahana hofidiana Diakona : </div><br>
	</td>
  </tr>
  
  <tr>
    <td>
	<form id="formMirotsakaFidiana" name="formMirotsakaFidiana" method="post" action="editMirotsakaFidiana.htm">
	<table width="90%" valign="TOP" align="center" border="1" cellpadding="0" cellspacing="0">
	  <tr>
	    <td colspan="2">
	      <table width="100%"  border="0">
	        <tr>
	          <td colspan="2" valign="top">
	            <table width="90%" border="0">
	              <tr>
	                <td width="50%" align="left">Fitandremana *</td>
			        <spring:bind path="formMirotsakaFidiana.fitandremana" >
	                <td align="left">
          	        <!-- la saisie à autocompléter -->
		              <input class="inputleft" id="fitandremanaLabel" name="fitandremanaLabel" type="text" size="22" value="${formMirotsakaFidiana.fitandremana.label}" disabled="true"/>	
		            <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
		              <input type="hidden" id="fitandremanaID" name="${status.expression}" value="${formMirotsakaFidiana.fitandremana.id}" />	
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
			        <spring:bind path="formMirotsakaFidiana.laharana">
		            <td title="Laharana ho an'ny mpandray">Laharana </td>
		            <td align="center">
		      	      <input name="${status.expression}" value="${status.value}" type="text" size="22" disabled="true"/>
		      	      <font color="red" size="1.2">${status.errorMessage}</font>
		            </td>
		            </spring:bind>
	              </tr>
	              
	              <%
	              if (formMirotsakaFidiana.isMpandray()){
	              %>
	              <tr>
	                <%
	                if (formMirotsakaFidiana.isMpandrayFrom5Years(formMirotsakaFidiana.getDatyFifidianana())){
	                %>
	                <td>Mpandray</td>
	                <%
	                }
	                else{
	                %>
	                <td bgcolor="#FF0000">Mpandray tsy ampy 5 taona</td>
	                <%
	                }
	                %>
                    <td>
                      <%=Utils.sfDateFormatJJMMYYYY.format(formMirotsakaFidiana.getDatyMpandray())%>
                    </td>
	              </tr>
	              <%
	              }
	              else{
	              %>
	              <tr>
	                <td colspan="2" bgcolor="#FF0000">Mbola tsy mpandray fanasan'ny Tompo</td>
	              </tr>
	              <%
	              }
	              %>
	            </table>
	          </td>
	          <td colspan="2" valign="top">
	            <table width="100%" border="0">
	              <tr>
	                <td>Niaviana </td>
	                <td colspan="2" align="left">
          	          <input name="${status.expression}" value="${formMirotsakaFidiana.fitandremanaNiaviana.label}" type="text" size="22" disabled="true" />
	                </td>
	              </tr>
	              
	              <tr>
	                <td width="45%">Taom-panompoana * </td>
	                <td>
	                  <input name="${status.expression}" value="<%=formMirotsakaFidiana.getTaomPanompoana().toString()%>" type="text" size="22" disabled="true" />
			        </td>
			        <td>
			        </td>
	              </tr>
	              
	              <%
	              if (formMirotsakaFidiana.isMpandray()){
	              %>
	              <tr>
	                <td>tao</td>
	                <td>
	                  ${formMirotsakaFidiana.fitandremanaMpandray.label}
				    </td>
	              </tr>
	              <%
	              }
	              else{
	              %>
	              <tr>
	                <td colspan="2">&nbsp;</td>
	              </tr>
	              <%
	              }
	              %>
	            </table>
		      </td>
              
	          <td align="right"><img src="<%=request.getContextPath()%>/<%=formMirotsakaFidiana.getPhotoName(request)%>" width="85" height="85"/></td>
	        </tr>
       
            <tr>
		      <spring:bind path="formMirotsakaFidiana.anarana">
              <td width="12%">Anarana *</td>
              <td align="left" width="23%">
          	    <input name="${status.expression}" value="${status.value}" type="text" size="22"  disabled="true"/>
          	    <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
              </spring:bind>
		      <spring:bind path="formMirotsakaFidiana.fanampiny">
              <td width=10%">Fanampiny </td>
              <td width="23%">
          	    <input name="${status.expression}" value="${status.value}" type="text" size="22"  disabled="true"/>
          	    <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
              </spring:bind>
		      <td>
		      <spring:bind path="formMirotsakaFidiana.lahy">
                <table valign="TOP" align="right">
                  <tr>
	              <c:choose>
	              <c:when test="${status.value}">
	                <td><input class="inputleft" name="${status.expression}" type="radio" value="true" checked disabled="true"/>Lahy</td>
	                <td><input class="inputleft" name="${status.expression}" type="radio" value="false" disabled="true"/>Vavy</td>
	              </c:when>
	              <c:otherwise>
	                <td><input class="inputleft" name="${status.expression}" type="radio" value="true" disabled="true"/>Lahy</td>
	                <td><input class="inputleft" name="${status.expression}" type="radio" value="false" checked disabled="true"/>Vavy</td>
	              </c:otherwise>
	              </c:choose>
                  </tr>
                </table>
              </spring:bind>
		      </td>          
            </tr>

            <tr>
              <td>Teraka ny </td>
	  		  <spring:bind path="formMirotsakaFidiana.datyTeraka">
              <td>
                <input name="${status.expression}" type="text" id="dateTeraka" value="${status.value}" size="10" class="inputleft" disabled="true"/>
                <img src="<%=request.getContextPath()%>/images/icon_calendar.gif" id="imgDateTeraka" width="16" height="16" disabled="true"/>
              </td>
              </spring:bind>
              <td align="left"> tao </td>
              <spring:bind path="formMirotsakaFidiana.toeranaTeraka">
              <td align="right">
                <input type="text" size="22" name="${status.expression}" value="${status.value}" disabled="true"/>
        	    <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
              </spring:bind>
		      <%
		      if (!formMirotsakaFidiana.isOlderThan25Years(formMirotsakaFidiana.getDatyFifidianana())){
		      %>
		      <td bgcolor="#FF0000">Mbola tsy ampy 25 taona</td>          
		      <%
		      }
		      else{
		      %>
		      <td>&nbsp;</td>
		      <%
		      }
		      %>
            </tr>
            
            <tr>
              <spring:bind path="formMirotsakaFidiana.adresse">
              <td>Adiresy </td>
              <td colspan="2" align="left">
			    <textarea name="${status.expression}" rows="2" cols="40" disabled="true">${status.value}</textarea>
                <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
              </spring:bind>
		      <td colspan="2">
		        <table width=100%">
		          <tr>
          		    <spring:bind path="formMirotsakaFidiana.antonAsa">
		            <td>Asa </td>
		            <td>
	          	    <!-- la saisie à autocompléter -->
			          <input class="inputleft" id="antonAsaLabel" name="antonAsaLabel" type="text" size="22" value="${formMirotsakaFidiana.antonAsa.intitule}" disabled="true"/>	
			        <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
			          <input type="hidden" id="antonAsaID" name="${status.expression}" value="${formMirotsakaFidiana.antonAsa.id}" />	
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
          		    <spring:bind path="formMirotsakaFidiana.talenta">
		            <td>Talenta</td>
		            <td>
		              <input type="text" size="22" name="${status.expression}" value="${status.value}"  disabled="true"/>
		              <font color="red" size="1.2">${status.errorMessage}</font>
		            </td>
		            </spring:bind>
		          </tr>
		        </table>
		      </td>          
            </tr>        

            <tr>        
              <spring:bind path="formMirotsakaFidiana.firaisana">
              <td>Firaisana</td>
              <td>
          	  <!-- la saisie à autocompléter -->
		        <input class="inputleft" id="firaisanaLabel" name="firaisanaLabel" type="text" size="22" value="${formMirotsakaFidiana.firaisana.label}" onchange="javascript:invalidateField('faritraID');" disabled="true"/>	
		      <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
		        <input type="hidden" id="firaisanaID" name="${status.expression}" value="${formMirotsakaFidiana.firaisana.id}" />	
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
              <spring:bind path="formMirotsakaFidiana.faritra">
              <td>Faritra</td>
              <td>
          	  <!-- la saisie à autocompléter -->
                <input id="faritraLabel" name="faritraLabel" type="text" size="22" value="${formMirotsakaFidiana.faritra.label}" disabled="true"/>
		      <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
		        <input type="hidden" id="faritraID" name="${status.expression}" value="${formMirotsakaFidiana.faritra.id}" />
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
            </tr>

            <tr>
              <td>Tél : </td>
  		      <spring:bind path="formMirotsakaFidiana.tel">
	  	      <td align="left">
	            <input type="text" size="22" name="${status.expression}" value="${status.value}"  disabled="true"/>
	            <font color="red" size="1.2">${status.errorMessage}</font>
	          </td>
	          </spring:bind>
	          <spring:bind path="formMirotsakaFidiana.mailaka">
	          <td align="left">E-mail </td>
	          <td align="right">
	            <input type="text" size="22" name="${status.expression}" value="${status.value}"  disabled="true"/>
	            <font color="red" size="1.2">${status.errorMessage}</font>
	          </td>
	          </spring:bind>
              <td>&nbsp;</td>
            </tr>

            <%
            if (formMirotsakaFidiana.getMirotsakaFidiana().getMpivavaka().isManambady()){
            %>
            <tr>
              <td>Vady </td>
              <spring:bind path="formMirotsakaFidiana.vady">
              <td align="left">
                <input type="text" size="22" name="${status.expression}" value="${status.value}"  disabled="true"/>
                <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
              </spring:bind>
              <td colspan="3"> 
                <table width=100%" border="0">
                  <tr>
                    <td width="15%">Fanambadiana</td>
		            <td colspan="3"><b><%= formMirotsakaFidiana.getDatyFanambadiana() != null ? Utils.sfDateFormatJJMMYYYY.format(formMirotsakaFidiana.getDatyFanambadiana()) : "" %></b>&nbsp;&nbsp;tao amin'ny &nbsp; <b>${formMirotsakaFidiana.fitandremanaFanambadiana.label}</b></td>
                  </tr>
                </table>
              </td>
            </tr>
            <%
            }
            else{
            %>
            <tr>
              <td colspan="5">Tsy manambady </td>
            </tr>
            <%
            }
            %>

			<!-- Historique naha-diakona -->
			<%
			Mpivavaka mpivavaka = formMirotsakaFidiana.getMpivavaka();
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
			  <td>Daty nirotsahana :</td>
	  		  <spring:bind path="formMirotsakaFidiana.datyNirotsahana">
			  <td>
                <input name="${status.expression}" type="text" id="dateNirotsahana" value="${status.value}" size="10" class="inputleft" />
                <img src="<%=request.getContextPath()%>/images/icon_calendar.gif" id="imgDateNirotsahana" width="16" height="16" />
			  </td>
			  </spring:bind>
			</tr>
			<%
			}
			else{%>
			<tr>
			  <td colspan="2">Mbola tsy diakona</td>
			  <td>Daty nirotsahana :</td>
	  		  <spring:bind path="formMirotsakaFidiana.datyNirotsahana">
			  <td>
                <input name="${status.expression}" type="text" id="dateNirotsahana" value="${status.value}" size="10" class="inputleft" />
                <img src="<%=request.getContextPath()%>/images/icon_calendar.gif" id="imgDateNirotsahana" width="16" height="16" />
			  </td>
			  <td>&nbsp;</td>
			  </spring:bind>
			</tr>
			<%
			}
			%>
            <tr>
              <td colspan="5">&nbsp;</td>
            </tr>
        
            <tr>
	          <td>&nbsp;</td>	          
	          <% if (formMirotsakaFidiana.isFromSearch()) {%>
	          <td align="center"><input name="Miverina" class="button" id="boutonMiverina" value="Miverina" type="button" onclick="javascript: document.location='${formMirotsakaFidiana.from}&from=<%=request.getSession().getAttribute(ConstantUtils.sfSelectedTab)%>';"/></td>
	          <%
	          } 
	          else { 
	          %>
	          <td align="center"><input name="Miverina" class="button" id="boutonMiverina" value="Miverina" type="button" onclick="javascript: document.location='index.htm?<%=request.getSession().getAttribute(ConstantUtils.sfSelectedTab)%>';"/></td>
	          <% 
	          } 
	          %>
              <% 
              if (formMirotsakaFidiana.getMirotsakaFidiana().getId() == null) {%>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
	          <td align="right"><input name="Valider" class="button" id="boutonValider" value="Mirotsaka" type="submit" <%= !formMirotsakaFidiana.getMirotsakaFidiana().getMpivavaka().isElligibleDiakona(new java.util.Date()) ? "disabled='true'" : "" %>/></td>
	          <%
	          }
	          else{
	            if (formMirotsakaFidiana.getMirotsakaFidiana().isEkenaFirotsahana() == null){
	          %>
		      <td>&nbsp;</td>          
	          <td align="right"><input name="Valider" class="button" id="boutonValider" value="Ekena" type="submit" /></td>
	          <td align="right"><input name="Valider" class="button" id="boutonValider" value="Lavina" type="submit" /></td>
	          <%
	            }
	            else{
	              if (formMirotsakaFidiana.getMirotsakaFidiana().isEkenaFirotsahana().booleanValue()){
	          %>
	          <td colspan="2" bgcolor="#66CC00">Fangatahana efa nekena. <%=formMirotsakaFidiana.getMirotsakaFidiana().getLaharanaMpirotsaka() != null ? " Laharana No <b>"+formMirotsakaFidiana.getMirotsakaFidiana().getLaharanaMpirotsaka()+"</b>": ""%></td>
	          <td><input name="Valider" class="button" id="boutonValider" value="Lavina" type="submit" /></td>
	          <%  }
	              else{
	          %>
	          <td colspan="2" bgcolor="#FF0000">fangatahana efa nolavina</td>
	          <td><input name="Valider" class="button" id="boutonValider" value="Ekena" type="submit" /></td>
	          <%
	              }
	            }  
	          }
	          %>
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
		inputField     :    "datyNirotsahana",     // id of the input field
		ifFormat       :    "%d/%m/%Y",      // format of the input field
		button         :    "imgDateNirotsahana",  // trigger for the calendar (button ID)
		align          :    "Tl",           // alignment (defaults to "Bl")
		singleClick    :    true
	});
	
</script>

<!-- fin corps -->

<%@ include file="/footer.jsp" %>
