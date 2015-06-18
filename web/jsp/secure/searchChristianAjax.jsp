<%@ include file="/jsp/include.jsp" %>

<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>

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
	              </tr>
	          
	              <tr>
		            <td title="Laharana ho an'ny mpandray">Laharana </td>
		            <td align="center">
		      	      <input id="laharanaId" name="laharana" value="${formSearchChristian.laharana}" type="text" size="22" />
		      	      <font color="red" size="1.2">${status.errorMessage}</font>
		            </td>
	              </tr>
	            </table>
	          </td>
	          <td colspan="2">
	            <table width="100%">
	              <tr>
	                <td width="30%">Batisa</td>
	                <td colspan="2">
		              <table valign="TOP">
		                <tr>
						<%
						  if (formSearchChristian.getBatisa() == 1){ %>				
			              <td><input class="inputleft" name="batisa" type="radio" value="1" checked />Eny</td>
			              <td><input class="inputleft" name="batisa" type="radio" value="0" />Tsia</td>
			              <td><input class="inputleft" name="batisa" type="radio" value="-1" />Rehetra</td>
						<%
						} 
						else if (formSearchChristian.getBatisa() == 0) { %>
			              <td><input class="inputleft" name="batisa" type="radio" value="1" />Eny</td>
			              <td><input class="inputleft" name="batisa" type="radio" value="0" checked />Tsia</td>
			              <td><input class="inputleft" name="batisa" type="radio" value="-1" />Rehetra</td>
						<%
						}
						else { %>
			              <td><input class="inputleft" name="batisa" type="radio" value="1" />Eny</td>
			              <td><input class="inputleft" name="batisa" type="radio" value="0" />Tsia</td>
			              <td><input class="inputleft" name="batisa" type="radio" value="-1" checked />Rehetra</td>
						<%
						}
						%>
		                </tr>
		              </table>
				    </td>
	              </tr>
	              <tr>
	                <td>Mpandray</td>
	                <td colspan="2">
		              <table valign="TOP">
		                <tr>
						<%
						  if (formSearchChristian.getMpandray() == 1){ %>				
			              <td><input class="inputleft" name="mpandray" type="radio" value="1" checked />Eny</td>
			              <td><input class="inputleft" name="mpandray" type="radio" value="0" />Tsia</td>
			              <td><input class="inputleft" name="mpandray" type="radio" value="-1" />Rehetra</td>
						<%
						} 
						else if (formSearchChristian.getMpandray() == 0) { %>
			              <td><input class="inputleft" name="mpandray" type="radio" value="1" />Eny</td>
			              <td><input class="inputleft" name="mpandray" type="radio" value="0" checked />Tsia</td>
			              <td><input class="inputleft" name="mpandray" type="radio" value="false" />Rehetra</td>1
						<%
						}
						else { %>
			              <td><input class="inputleft" name="mpandray" type="radio" value="1" />Eny</td>
			              <td><input class="inputleft" name="mpandray" type="radio" value="0" />Tsia</td>
			              <td><input class="inputleft" name="mpandray" type="radio" value="-1" checked />Rehetra</td>
						<%
						}
						%>
		                </tr>
		              </table>
				    </td>
	              </tr>
	            </table>
		      </td>

	          <td colspan="2">
                <table>
                  <tr>
                    <td colspan="2">
                      <table width="100%" >
                        <tr>
						<%
						  if (formSearchChristian.getLahy() == 1){ %>				
			              <td width="33%"><input name="lahy" type="radio" value="1" checked />Lahy</td>
			              <td width="33%"><input name="lahy" type="radio" value="0" />Vavy</td>
			              <td width="33%"><input name="lahy" type="radio" value="-1" />Rehetra</td>
						<%
						} 
						else if (formSearchChristian.getLahy() == 0) { %>
			              <td><input name="lahy" type="radio" value="1" />Lahy</td>
			              <td><input name="lahy" type="radio" value="0" checked />Vavy</td>
			              <td><input name="lahy" type="radio" value="-1" />Rehetra</td>
						<%
						}
						else { %>
			              <td><input name="lahy" type="radio" value="1" />Lahy</td>
			              <td><input name="lahy" type="radio" value="0"  />Vavy</td>
			              <td><input name="lahy" type="radio" value="-1" checked />Rehetra</td>
						<%
						}
						%>
	                    </tr>
	                  </table>
	                </td>
                  </tr>
                  <tr>
		            <td width="27%">Talenta</td>
		            <td>
		              <input type="text" size="22" id="talentaId" name="talenta" value="${formSearchChristian.talenta}"  />
		              <font color="red" size="1.2">${status.errorMessage}</font>
		            </td>
                  </tr>
                </table>
		      </td>
	        </tr>
       
            <tr>
              <td width="9%">Anarana *</td>
              <td align="left" width="24%">
          	    <input name="anarana" id="anaranaId" value="${formSearchChristian.anarana}" type="text" size="22"  />
          	    <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
              <td width="10%">Fanampiny </td>
              <td width="23%">
          	    <input name="fanampiny" id="fanampinyId" value="${formSearchChristian.fanampiny}" type="text" size="22"  />
          	    <font color="red" size="1.2">${status.errorMessage}</font>
              </td>
          
              <td colspan="2">
                <table width="100%">
                  <tr>
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
	              </tr>
	            </table>
	          </td>		  
            </tr>
                
            <tr>
	          <td colspan="2" align="left">&nbsp;</td>
	          <td>&nbsp;</td>
	          <td align="right"><input name="Valider" id="boutonValider" value="Tadiavo" type="button" class="button" onclick="javascript:loadResults(0);"/></td>
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

  <tr>
    <td>
      <!-- Affichage des résultats par Ajax -->
      <div id="searchResults">

      </div>
    </td>
  </tr>
	
</table>

  
<script language="javascript">
	//renvoie la valeur de la radio button sélectionné
	function getRadioValue(radio){
		var val = null;
		for (var i=0; i<radio.length;i++) {
			if (radio[i].checked) {
				val = radio[i].value;
				break;
			}
		}	
		return val;
	}
	
	function loadResultsAjax(pageNo){		
		//Affichage d'un message occupé
		var options = {
		    button:null
	    };
	    msg.open('<img src="<%=request.getContextPath()%>/images/indicator.gif" /> Mbola mitady ...', options);
		
		var req = new AjReq();
		var opts = {
			method : 'POST',
			params : 'fitandremanaId='+document.getElementById('fitandremanaID').value+'&laharana='+document.getElementById('laharanaId').value+'&batisa='+getRadioValue(document.forms["formSearchChristian"].elements["batisa"])+'&mpandray='+getRadioValue(document.forms["formSearchChristian"].elements["mpandray"])+'&lahy='+getRadioValue(document.forms["formSearchChristian"].elements["lahy"])+'&talenta='+document.getElementById('talentaId').value+'&anarana='+document.getElementById('anaranaId').value+'&fanampiny='+document.getElementById('fanampinyId').value+'&antonAsa='+document.getElementById('antonAsaID').value+'&valider=Valider&pageNo='+pageNo+'&from=<%=formSearchChristian.getFrom() != null ? formSearchChristian.getFrom() : ""%>',
			update : document.getElementById('searchResults'),
			abortAfter : 15000,
			onSuccess : function(){ msg.close(); },
			onAbort : function(){ msg.close(); }
		};
		
		req.send('searchChristianAjax.htm', opts);
	};
	
	function loadResults(pageNo){
		if (fjkmAnkadifotsyIsNavigatorIE()){
			if (fjkmAnkadifotsyVerIE() >= 8){
				loadResultsAjax(pageNo);
			}
			else{
				submitFormFromLink(0);
			}
		}
		else{
			loadResultsAjax(pageNo);
		}
	};
</script>

<%
  //auto-Submit pour afficher les résultats précédents
  if (formSearchChristian.isSubmit()){
%>
<script language="javascript">
	loadResults('<%=formSearchChristian.getPageNo()%>');
</script>
<%
  }
%>

<!-- fin corps -->

<%@ include file="/footer.jsp" %>
