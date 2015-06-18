<%@ include file="/jsp/include.jsp" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>
<%@ page import="mg.fjkm.ankadifotsy.util.Utils" %>

<%@ page import="mg.fjkm.ankadifotsy.form.FormManisaVato" %>

<%@ include file="/header.jsp" %>

<%!
FormManisaVato manisaVatoOloTokana;
%>
<%
  manisaVatoOloTokana = (FormManisaVato)request.getSession().getAttribute(FormManisaVato.sfFORM_ID);
%>

<!-- debut corps -->
<table width="1000px" align="center" border="0">
  <tr>
	<td>
		<%@ include file="/onglet.jsp" %>
    </td>
  </tr>
  
  <%@ include file="showFifidianana.jsp" %>  
  
  <tr>
    <td colspan="2">
	  <div class="title1">Fanisam-bato hisafidianana olona tokana : </div><br>
	</td>
  </tr>
  
  <tr>
    <td colspan="2">
    <table width="100%" border="1">
      <tr>
        <td width="20%">
          <!-- Affichage des résultats provisoire par Ajax pour les Diakona vehivavy -->
          <div id="searchResultManisaFifidianana" style="vertical-align: top; " >
          </div>
        </td>

        <td width="80%" bgcolor="#00CCFF">
          <form id="formManisaVatoOloTokanaId" name="formManisaVatoOloTokana" action="">
          <div id="manisaVatoOloTokana">
          <%@ include file="formManisaVatoOloTokana.jsp" %>
          </div>
          </form>
        </td>

      </tr>      
    </table>
	  
    </td>
  </tr>
  
</table>

<script language="javascript">
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

	//ré-initialiser à blanc les cases à cocher du formulaire
	function initFormManisaVato(){
		var inputs = document.getElementsByTagName("input");
		for (var i = 1 ; i < inputs.length; i++){
			var curInput = inputs[i];
			if (curInput.type=='checkbox'){
				curInput.checked = false;
			}
		}
	}

  	function getParameters(){
  	  	var params = 'lehilahy=<%=manisaVatoOloTokana.getLehilahy()%>';
		var inputs = document.getElementsByTagName("input");
		
		for (var i = 1 ; i < inputs.length; i++){
			var curInput = inputs[i];
			if (curInput.type=='checkbox' && curInput.checked){
				params = params + '&';

				params = params+curInput.name+'=on'
			}
		}

		var myForm = document.getElementById("formManisaVatoOloTokanaId");
		var mirotsakaArray = myForm.elements["mirotsaka"];
		var mirotsakaVal = '';
		if (getRadioValue(mirotsakaArray) != null)
			mirotsakaVal = getRadioValue(mirotsakaArray);
		params = params + '&mirotsaka='+ mirotsakaVal;
		return params;
  	}

  	function showMessage(){
  	  	if (document.getElementById('message') != null){
	  	  	var message = document.getElementById('message').value;
			var options = {
				modal:true,
				button:'ok'
			};
			msg.open(message, options);
  	  	}
		return false;
   	}
  	
  	function submitVato(){				
		var req = new AjReq();
		var opts = {
			method : 'POST',
			params : getParameters(),
			update : document.getElementById('manisaVatoOloTokana'),
			abortAfter : 15000,
			onSuccess : function(){ showMessage();},
			onAbort : function(){ showMessage('Tsy voaisa ny vato nampidirina teo');}
		};
		
		req.send('manisaVato.htm', opts);
	}


	var reqAjaxVokatra = new AjReq();
	var optVokatras = {
		method : 'POST',
		abortAfter : 15000,
		update : document.getElementById('searchResultManisaFifidianana'),
		onSuccess : function(){window.setTimeout(getVokatraVonjyMaika, 30000);}
	};
 	
  	function getVokatraVonjyMaika(){
  		reqAjaxVokatra.send('vokatraTapatapany.htm', optVokatras);
	}

  	getVokatraVonjyMaika();
</script>

<!-- fin corps -->

<%@ include file="/footer.jsp" %>
