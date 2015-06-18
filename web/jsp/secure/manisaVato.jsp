<%@ include file="/jsp/include.jsp" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>
<%@ page import="mg.fjkm.ankadifotsy.util.Utils" %>

<%@ page import="mg.fjkm.ankadifotsy.form.FormManisaVato" %>

<%@ include file="/header.jsp" %>


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
	  <div class="title1">Fanisam-bato : </div><br>
	</td>
  </tr>
  
  <tr>
    <td colspan="2">
    <table width="100%" border="1">
      <tr>
        <td width="15%">
          <!-- Affichage des résultats provisoire par Ajax pour les Diakona vehivavy -->
          <div id="searchResultManisaFifidiananaVehivavy" style="vertical-align: top; " >
          </div>
        </td>

        <td width="70%" bgcolor="#00CCFF">
          <div id="formManisaVato">
          <%@ include file="formManisaVato.jsp" %>
          </div>
        </td>

        <td width="15%">
          <!-- Affichage des résultats provisoire par Ajax pour les Diakona lehilahy -->
          <div id="searchResultManisaFifidiananaLehilahy">
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
	}

  	function getParameters(){
  	  	var params = '';
		var inputs = document.getElementsByTagName("input");
		var first = true;
		for (var i = 1 ; i < inputs.length; i++){
			var curInput = inputs[i];
			if (curInput.type=='checkbox' && curInput.checked){
				if (!first)
					params = params + '&';

				params = params+curInput.name+'=on'
				first = false;
			}
		}
		return params;
  	}

  	function showMessage(message){
		var options = {
			modal:true,
			button:'ok'
		};
		msg.open(message, options);
		return false;
   	}
  	
  	function submitVato(){				
		var req = new AjReq();
		var opts = {
			method : 'POST',
			params : getParameters(),
			update : document.getElementById('formManisaVato'),
			abortAfter : 15000,
			onSuccess : function(){ showMessage('Voaray soa aman-tsara ny vato nampidirina teo');},
			onAbort : function(){ showMessage('Tsy voaisa ny vato nampidirina teo');}
		};
		
		req.send('manisaVato.htm', opts);
	}


	var reqAjaxVokatraVehivavy = new AjReq();
	var optVokatraVehivavys = {
		method : 'POST',
		params : 'lahy=false',
		abortAfter : 15000,
		update : document.getElementById('searchResultManisaFifidiananaVehivavy'),
		onSuccess : function(){window.setTimeout(getVokatraVonjyMaikaVehivavy, 30000);}
	};
 	
  	function getVokatraVonjyMaikaVehivavy(){
  		reqAjaxVokatraVehivavy.send('vokatraTapatapany.htm', optVokatraVehivavys);
	}

	var reqAjaxVokatraLehilahy = new AjReq();
	var optVokatraLehilahys = {
		method : 'POST',
		params : 'lahy=true',
		abortAfter : 15000,
		update : document.getElementById('searchResultManisaFifidiananaLehilahy'),
		onSuccess : function(){window.setTimeout(getVokatraVonjyMaikaLehilahy, 35000);}
	};
	
  	function getVokatraVonjyMaikaLehilahy(){				
  		reqAjaxVokatraLehilahy.send('vokatraTapatapany.htm', optVokatraLehilahys);
	}

  	getVokatraVonjyMaikaVehivavy();
  	getVokatraVonjyMaikaLehilahy();
</script>

<!-- fin corps -->

<%@ include file="/footer.jsp" %>
