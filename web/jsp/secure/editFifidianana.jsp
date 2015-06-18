<%@ include file="/jsp/include.jsp" %>

<%@ page import="java.util.List" %>

<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>
<%@ page import="mg.fjkm.ankadifotsy.util.Utils" %>

<%@ page import="mg.fjkm.ankadifotsy.bo.Fifidianana" %>

<%@ page import="mg.fjkm.ankadifotsy.form.FormFifidianana" %>

<%@ include file="/header.jsp" %>

<script language="javascript">    
	function invalidateField(field){
		document.getElementById(field+'Label').value ='';
		document.getElementById(field).value ='';
	}

	function checkFifidiananaOlonaMaro(){
		if (document.getElementsByName('fifidiananaOloTokana')[0].checked)
			document.getElementById('fifidiananaOlonaMaroId').style.display = 'none';
		else
			document.getElementById('fifidiananaOlonaMaroId').style.display = 'block';
	}	
</script>

<!-- debut corps -->
<%!
	FormFifidianana formFifidianana;
%>
<%
	formFifidianana = (FormFifidianana)request.getAttribute(FormFifidianana.sfFORM_ID);
%>

<!-- Le Div qui sert à afficher les bulles d'aide -->
<div id="curseur" class="infobulle"></div>
    
<table align="center" border="0">
  <tr>
	<td>
		<%@ include file="/onglet.jsp" %>
    </td>
  </tr>
    
  <tr>
    <td>
	  <div class="title1">Fifidianana : </div><br>
	</td>
  </tr>
  
  <tr>
    <td>
    <table border="1" width="65%">
      <tr>
        <td>
	      <form id="formFifidianana" name="formFifidianana" method="post" action="editFifidianana.htm">
          <table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
            <tr>
	          <td width="40%">Anaran'ny fifidianana *:</td>
	          <td width="60%">
              <spring:bind path="formFifidianana.label" >
                <input class="inputleft" id="labelId" name="${status.expression }" type="text" size="22" value="${status.value}" />	
                <font color="red" size="1.2">${status.errorMessage}</font>
              </spring:bind>
	          </td>
	        </tr>
	  
            <tr>
              <td title="Karazana fifidianana">Karazany *</td>
              <td>
              <spring:bind path="formFifidianana.karazamPifidianana" >
     	      <!-- la saisie à autocompléter -->
              <input class="inputleft" id="karazamPifidiananaLabel" name="karazamPifidiananaLabel" type="text" size="22" value="${formFifidianana.karazamPifidianana.label}" />	
              <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
              <input type="hidden" id="karazamPifidiananaID" name="${status.expression}" value="${formFifidianana.karazamPifidianana.id}" />	
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
      
            <tr>
              <td align="left">Fitandremana *</td>
              <td align="left">
              <spring:bind path="formFifidianana.fitandremana" >
    	      <!-- la saisie à autocompléter -->
              <input class="inputleft" id="fitandremanaLabel" name="fitandremanaLabel" type="text" size="22" value="${formFifidianana.fitandremana.label}" />	
              <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
              <input type="hidden" id="fitandremanaID" name="${status.expression}" value="${formFifidianana.fitandremana.id}" />	
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
              <td>TaomPanompoana *</td>
              <td>
                <spring:bind path="formFifidianana.taomPanompoana" >
      	        <!-- la saisie à autocompléter -->
                <input class="inputleft" id="taomPanompoanaLabel" name="taomPanompoanaLabel" type="text" size="22" value="${formFifidianana.taomPanompoana}" />	
                <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->
                <input type="hidden" id="taomPanompoanaID" name="${status.expression}" value="${formFifidianana.taomPanompoana.id}" />	
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
	          <td>Daty manomboka ny firotsahana *:</td>
	          <td>
                <spring:bind path="formFifidianana.datyManombokaFirotsahana">
                <input name="${status.expression}" type="text" id="datyManombokaFirotsahana" value="${status.value}" size="10" class="inputleft" />
                <img src="<%=request.getContextPath()%>/images/icon_calendar.gif" id="imgDateManombokaFirotsahana" width="16" height="16" />
                <font color="red" size="1.2">${status.errorMessage}</font>
                </spring:bind>
              </td>
	        </tr>

	        <tr>
	          <td>Daty mamarana ny firotsahana *: </td>
	          <td>
                <spring:bind path="formFifidianana.datyMamaranaFirotsahana">
                <input name="${status.expression}" type="text" id="datyMamaranaFirotsahana" value="${status.value}" size="10" class="inputleft" />
                <img src="<%=request.getContextPath()%>/images/icon_calendar.gif" id="imgDateMamaranaFirotsahana" width="16" height="16" />
                <font color="red" size="1.2">${status.errorMessage}</font>
                </spring:bind>
              </td>
	        </tr>

	        <tr>
	          <td>Daty fifidianana *: </td>
	          <td>
                <spring:bind path="formFifidianana.datyFifidianana">
                <input name="${status.expression}" type="text" id="datyFifidianana" value="${status.value}" size="10" class="inputleft" />
                <img src="<%=request.getContextPath()%>/images/icon_calendar.gif" id="imgDateFifidianana" width="16" height="16" />
                <font color="red" size="1.2">${status.errorMessage}</font>
                </spring:bind>
              </td>
	        </tr>

	        <tr>
	          <td>Daty manakatona : </td>
	          <td>
                <spring:bind path="formFifidianana.datyManakatona">
                <input name="${status.expression}" type="text" id="datyManakatona" value="${status.value}" size="10" class="inputleft" />
                <img src="<%=request.getContextPath()%>/images/icon_calendar.gif" id="imgDateManakatona" width="16" height="16" />
                <font color="red" size="1.2">${status.errorMessage}</font>
                </spring:bind>
              </td>
	        </tr>
      
      		<tr>
      		  <td>Fifidianana olo-tokana *:</td>
      		  <td>
      		    <table>
      		      <spring:bind path="formFifidianana.fifidiananaOloTokana" >
      		      <tr>
	              <c:choose>
	              <c:when test="${status.value}">
	                <td><input class="inputleft" name="${status.expression}" type="radio" value="true" onclick="javascript:checkFifidiananaOlonaMaro();" checked/>Eny</td>
	                <td><input class="inputleft" name="${status.expression}" type="radio" value="false" onclick="javascript:checkFifidiananaOlonaMaro();" />Tsia</td>
	              </c:when>
	              <c:otherwise>
	                <td><input class="inputleft" name="${status.expression}" type="radio" value="true" onclick="javascript:checkFifidiananaOlonaMaro();" />Eny</td>
	                <td><input class="inputleft" name="${status.expression}" type="radio" value="false" onclick="javascript:checkFifidiananaOlonaMaro();" checked />Tsia</td>
	              </c:otherwise>
	              </c:choose>
      		      </tr>
      		      </spring:bind>
      		    </table>
      		  </td>
      		</tr>
      		      		
            <tr>
              <td colspan="2">
      		    <div id="fifidiananaOlonaMaroId" <%= formFifidianana.isFifidiananaOloTokana() ? "style='display:none'" : "style='display:block'" %>>
                <table border="0" bgcolor="#33CCCC">
                  <tr>
                    <td>Laharana ho an'ny mpirotsaka ho fidiana : </td>
                    <td>
		            <spring:bind path="formFifidianana.mitohyLaharana">
                      <table align="left">
                        <tr>
	                    <c:choose>
	                    <c:when test="${status.value}">
	                      <td><input class="inputleft" name="${status.expression}" type="radio" value="true" checked/>Mitambatra</td>
	                      <td><input class="inputleft" name="${status.expression}" type="radio" value="false" />Misaraka</td>
	                    </c:when>
	                    <c:otherwise>
	                      <td><input class="inputleft" name="${status.expression}" type="radio" value="true" />Mitambatra</td>
	                      <td><input class="inputleft" name="${status.expression}" type="radio" value="false" checked />Misaraka</td>
	                    </c:otherwise>
	                    </c:choose>
                        </tr>
                      </table>
                    </spring:bind>
                    </td>
                  </tr>
                  
                  <tr>
                    <td>Isan'ny olona fidiana *:</td>
                    <spring:bind path="formFifidianana.isaOlonaFidiana">
                    <td><input class="inputleft" name="${status.expression}" type="text" size="22" value="${status.value}" /></td>
                    </spring:bind>
                  </tr>
                </table>
                </div>
              </td>
	        </tr>

            <tr>
              <td>Isan'ny literan'ny No bileta :</td>
              <spring:bind path="formFifidianana.isan_Nomerao">
              <td><input class="inputleft" name="${status.expression}" type="text" size="22" value="${status.value}" /></td>
              </spring:bind>
            </tr>
	  	  
	        <tr>
	          <td align="right"><input name="Valider" class="button" id="boutonValider" value="Miverina" type="button" onclick="javascript: document.location='<%=request.getContextPath()%>/secure/index.htm?<%=request.getSession().getAttribute(ConstantUtils.sfSelectedTab)%>';" /></td>
	          <td align="right"><input name="Valider" class="button" id="boutonValider" value="Alefa" type="submit" style="align:right"/></td>
	          <spring:bind path="formFifidianana.manomboka">
	          <c:if test="${status.value eq true}">
		          <td align="right"><input name="Valider" class="button" id="boutonValider" value="Ajanony" type="submit" style="align:right; background:#FF3300 "/></td>
	          </c:if>
	          <c:if test="${not (status.value eq true)}">
		          <td align="right"><input name="Valider" class="button" id="boutonValider" value="Atombohy" type="submit" style="align:right; background:#66CC00"/></td>
	          </c:if>
	          </spring:bind>
	        </tr>
	
	        <tr>
              <td colspan="2">
              <!-- Information de création et de dernière modification -->
              <%@ include file="infoCreation.jsp" %>	
	          </td>
            </tr>
	
	      </table>
          </form>
        
        </td>
      </tr>
    </table>	  
    </td>
  </tr>
  
</table>


<script language="javascript">
	Calendar.setup({
		inputField     :    "datyManakatona",     // id of the input field
		ifFormat       :    "%d/%m/%Y",      // format of the input field
		button         :    "imgDateManakatona",  // trigger for the calendar (button ID)
		align          :    "Tl",           // alignment (defaults to "Bl")
		singleClick    :    true
	});

	Calendar.setup({
		inputField     :    "datyFifidianana",     // id of the input field
		ifFormat       :    "%d/%m/%Y",      // format of the input field
		button         :    "imgDateFifidianana",  // trigger for the calendar (button ID)
		align          :    "Tl",           // alignment (defaults to "Bl")
		singleClick    :    true
	});

	Calendar.setup({
		inputField     :    "datyManombokaFirotsahana",     // id of the input field
		ifFormat       :    "%d/%m/%Y",      // format of the input field
		button         :    "imgDateManombokaFirotsahana",  // trigger for the calendar (button ID)
		align          :    "Tl",           // alignment (defaults to "Bl")
		singleClick    :    true
	});

	Calendar.setup({
		inputField     :    "datyMamaranaFirotsahana",     // id of the input field
		ifFormat       :    "%d/%m/%Y",      // format of the input field
		button         :    "imgDateMamaranaFirotsahana",  // trigger for the calendar (button ID)
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
	    
	msg.open("<%=request.getAttribute("message")%>", options);
	return false;
};

showErrorMessage();
</script>
<%
  }
%>

<!-- fin corps -->

<!-- pied de page -->
<%@ include file="/footer.jsp" %>
