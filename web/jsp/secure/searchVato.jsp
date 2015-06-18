<%@ include file="/jsp/include.jsp" %>

<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>

<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>
<%@ page import="mg.fjkm.ankadifotsy.util.Utils" %>

<%@ page import="mg.fjkm.ankadifotsy.bo.Fitandremana" %>
<%@ page import="mg.fjkm.ankadifotsy.bo.Fifidianana" %>

<%@ page import="mg.fjkm.ankadifotsy.form.FormSearchVato" %>

<%@ include file="/header.jsp" %>

<!-- debut corps -->
<%!
	FormSearchVato formSearchVato;
%>
<%
	formSearchVato = (FormSearchVato)request.getAttribute(FormSearchVato.sfFORM_ID);
%>

<table align="center" border="0" >
  <tr>
    <td>
		<%@ include file="/onglet.jsp" %>
    </td>
  </tr>

  <%@ include file="showFifidianana.jsp" %>  
  
  <tr>
    <td>Fitadiavana Vato : </td>
  </tr>
  
  <tr>
    <td>
	<form id="formSearchVato" name="formSearchVato" method="post" action="fanamarinanaVato.htm">
	<table width="100%" align="center" border="1" cellpadding="0" cellspacing="0">
	  <tr>
	    <td colspan="2">
	      <table width="100%"  border="0">
	        <tr>
	          <td colspan="2">
	            <table width="100%" border="0">	
					<tr>
						<td align="left">Vato laharana :</td>
						<td align="center">
							<spring:bind path="formSearchVato.vatoLaharana"><input name="${status.expression }" value="${status.value}" size="22" class="inputleft" id="vatoLaharana"/></spring:bind>
						</td>
						<spring:bind path="formSearchVato.lehilahy">
						<td colspan="2">
							<table width="100%" >
								<tr>
								<%
								if (formSearchVato.getLehilahy() == true){ %>				
								<td width="50%"><input name="${status.expression}" type="radio" value="true" checked />Lehilahy</td>
								<td width="50%"><input name="${status.expression}" type="radio" value="false" />Vehivavy</td>
								<%
								} 
								else if (formSearchVato.getLehilahy() == false) { %>
								<td><input name="${status.expression}" type="radio" value="true" />Lehilahy</td>
								<td><input name="${status.expression}" type="radio" value="false" checked />Vehivavy</td>
								<%
								}
								%>
					    		</tr>
					  		</table>
						</td>
						</spring:bind>

				        <td align="right"><input type="button" name="Valider" class="button" id="boutonValider" value="Tadiavo" onclick="javascript: submitVato(true);" /></td>
						
					</tr>	
	            </table>
		      </td>

	          <td colspan="2">&nbsp;</td>
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
		<table width="100%" align="center" border="1" cellpadding="0" cellspacing="0">
			<tr>
		        <td width="80%" bgcolor="#00CCFF">
		          <div id="mitadyVato_formSearchVato">
		          </div>
		        </td>
			</tr>
		</table>  	
  	</td>
  </tr>
</table>

<script language="javascript">
  	function showMessage(){
  	  	var messageId = document.getElementById('message');
  	  	if (messageId){
	  	  	var message = messageId.value;
			var options = {
				modal:true,
				button:'ok'
			};
			msg.open(message, options);
  	  	}
		return false;
   	}

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
	
  	function getParameters(miverina){
  	  	var params = 'lehilahy='+getRadioValue(document.forms["formSearchVato"].elements["lehilahy"]);
		var inputs = document.getElementsByTagName("input");

		var vatoLaharana = document.getElementById('vatoLaharana').value;
		params = params + '&vatoLaharana='+vatoLaharana;
		
		return params;
  	}
  	  	
  	function submitVato(miverina){				
		var req = new AjReq();
		var opts = {
			method : 'POST',
			params : getParameters(miverina),
			update : document.getElementById('mitadyVato_formSearchVato'),
			abortAfter : 150000,
			onSuccess : function(){ showMessage();},
			onAbort : function(){ showMessage('Tsy voaisa ny vato nampidirina teo');}
		};
		
		req.send('fanamarinanaVato.htm', opts);
	}
</script>

<!-- fin corps -->

<%@ include file="/footer.jsp" %>
