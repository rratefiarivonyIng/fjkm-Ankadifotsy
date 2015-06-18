<%@ include file="/jsp/include.jsp" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>
<%@ page import="mg.fjkm.ankadifotsy.util.Utils" %>

<%@ page import="mg.fjkm.ankadifotsy.form.FormManisaVato" %>

<%@ include file="/header.jsp" %>

<%!
FormManisaVato manisaVatoMisaraka_formManisaVato;
%>
<%
  manisaVatoMisaraka_formManisaVato = (FormManisaVato)request.getSession().getAttribute(FormManisaVato.sfFORM_ID);
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
	  <div class="title1">Fanisam-bato <%= manisaVatoMisaraka_formManisaVato.getLehilahy().booleanValue() ? " lehilahy " : " vehivavy " %>: </div><br>
	</td>
  </tr>
  
  <tr>
    <td colspan="2">
    <table width="100%" border="1">
      <tr>
        <td width="20%">
          <!-- Affichage des résultats par provisoire par Ajax pour les Diakona vehivavy -->
          <div id="searchResultManisaFifidianana" style="vertical-align: top; " >
          </div>
        </td>

        <td width="80%" bgcolor="#00CCFF">
          <div id="manisaVatoMisaraka_formManisaVato">
          <%@ include file="formManisaVato.jsp" %>
          </div>
        </td>

      </tr>      
    </table>
	  
    </td>
  </tr>
  
</table>

<script language="javascript">
  //ré-initialiser à blanc les cases à cocher du formulaire
	function initFormManisaVato(){
		var inputs = document.getElementsByTagName("input");
		for (var i = 1 ; i < inputs.length; i++){
			var curInput = inputs[i];
			if (curInput.type=='checkbox'){
				curInput.checked = false;
			}
		}
		var vatoLaharanaDiv = document.getElementById("vatoLaharana");
		if (vatoLaharanaDiv)
			vatoLaharanaDiv.value = "";

		var famerenanaDiv = document.getElementById("famerenana");
		if (famerenanaDiv)
			famerenanaDiv.value = "false";
		
	}

  	function getParameters(miverina, dtime){
  	  	var params = 'lehilahy=<%=manisaVatoMisaraka_formManisaVato.getLehilahy()%>';
		var inputs = document.getElementsByTagName("input");
		for (var i = 1 ; i < inputs.length; i++){
			var curInput = inputs[i];
			if (curInput.type=='checkbox' && curInput.checked){
				params = params + '&';

				params = params + curInput.name + '=on'
			}
		}

		if (miverina)
			params = params + '&miverina=true';

		var vatoLaharana = document.getElementById('vatoLaharana').value;
		params = params + '&vatoLaharana='+vatoLaharana;

		var famerenana = document.getElementById('famerenana').value;
		params = params + '&famerenana='+famerenana;

		if (typeof dtime != 'undefined')
			params = params + '&dtime='+dtime;
		
		return params;
  	}

  	function showMessage(){
  	  	var messageId = document.getElementById('message');
  	  	var fromAdmin = document.getElementById('fromAdmin');
  	  	if (messageId){
	  	  	var message = messageId.value;
	  	  	var options;
  	  	  	if (fromAdmin){
				options = {
					modal:true,
					button:'ok',
					onClose : function(){
						document.location.href='<%=request.getContextPath()%>/secure/selectFifidianana.htm?id=<%=Utils.getFifidiananaFromSession(request).getId()%>';
					}
				};
  	  	  	}
  	  	  	else{
				options = {
					modal:true,
					button:'ok'
				};
  	  	  	}
			msg.open(message, options);
  	  	}
		return false;
   	}
  	
  	function submitVato(miverina, dtime){				
		var req = new AjReq();
		var opts = {
			method : 'POST',
			params : getParameters(miverina, dtime),
			update : document.getElementById('manisaVatoMisaraka_formManisaVato'),
			abortAfter : 150000,
			onSuccess : function(){ showMessage();},
			onAbort : function(){ showMessage('Tsy voaisa ny vato nampidirina teo');}
		};

		req.send('manisaVato.htm', opts);
	}


	var reqAjaxVokatra = new AjReq();
	var optVokatras = {
		method : 'POST',
		params : 'lahy=<%=manisaVatoMisaraka_formManisaVato.getLehilahy().booleanValue()%>',
		abortAfter : 15000,
		update : document.getElementById('searchResultManisaFifidianana'),
		onSuccess : function(){window.setTimeout(getVokatraVonjyMaika, 30000);}
	};
 	
  	function getVokatraVonjyMaika(){
  		reqAjaxVokatra.send('vokatraTapatapany.htm', optVokatras);
	}

	document.addEventListener("keydown", ytDocumentKeyDownHandler = function(event){ 
		var keycode = (event.keyCode ? event.keyCode : event.which);
		if (keycode == 13){
			//Touche Entrée
			submitVato(false);
		}
	});							
	
  	getVokatraVonjyMaika();
</script>

<!-- fin corps -->

<%@ include file="/footer.jsp" %>
