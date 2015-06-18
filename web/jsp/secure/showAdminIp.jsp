<%@ include file="/jsp/include.jsp" %>

<%@ page import="java.util.List" %>

<%@ page import="mg.fjkm.ankadifotsy.bo.AuthorizedIP" %>
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
  
  <tr>
    <td colspan="2">
	  <div class="title1">Fikirakirana IP ... : </div><br>
	</td>
  </tr>
  
  <tr>
    <td colspan="2">
    <table width="100%" border="1">
      <tr>
        <td bgcolor="#000099">
          <div id="formAddIp">
          <%@ include file="formAddIp.jsp" %>
          </div>        
        </td>
      </tr>
      <tr>
        <td width="40%">
          <!-- Affichage des IPs déjà autorisées -->
          <div id="listIps" style="vertical-align: top; " >
          </div>
        </td>
      </tr>      
    </table>
	  
    </td>
  </tr>
  
</table>

<script language="javascript">
  //ré-initialiser à blanc les cases à cocher du formulaire
	function initFormAddIp(){
		document.getElementById("authorizedIP_id").value = "";
		document.getElementById("authorizedIP_ip").value = "";
		document.getElementById("authorizedIP_fanazavana").value = "";
		document.getElementById("authorizedIP_ekena").checked = false;		
	}

  	function reloadIPs(){
		var req = new AjReq();
		var opts = {
			method : 'POST',
			update : document.getElementById('listIps'),
			abortAfter : 15000,
		};
		
		req.send('listIp.htm', opts);
  	}

  	function deleteIp(id){
		var req = new AjReq();
		var opts = {
			method : 'POST',
			params : 'id='+id,
			abortAfter : 15000,
			update : document.getElementById('formAddIp'),
			onSuccess : function(){ 
				showResponseMessage();
				reloadIPs();
			},
			onAbort : function(){ showMessage('Nisy tsy nety ny fanesorana IP teo');}
		};
		
		req.send('deleteIp.htm', opts);
  	}

  	function editIp(id){
		var req = new AjReq();
		var opts = {
			method : 'POST',
			params : 'id='+id,
			abortAfter : 15000,
			update : document.getElementById('formAddIp'),
			onSuccess : function(){ 
				showResponseMessage();
				reloadIPs();
			},
			onAbort : function(){ showMessage('Nisy tsy nety ny fanesorana IP teo');}
		};
		
		req.send('editIp.htm', opts);
  	}
  	
  	function getParameters(){
  	  	var params = '';

  	  	var id = document.getElementById("authorizedIP_id").value;
  	  	params = 'id='+id;

  	  	var ip = document.getElementById("authorizedIP_ip").value;
  	  	params = params + '&ip='+ip;

  	  	var descr = document.getElementById("authorizedIP_fanazavana").value;
  	  	params = params + '&descr='+descr;

  	  	var ekena = document.getElementById("authorizedIP_ekena");
  	  	var ekenaValue;
  	  	if (ekena.checked){
  	  	  	ekenaValue = 'true';
  	  		//console.log('Ekena :'+ekena);
  	  	}
  	  	else
  	  	  	ekenaValue = 'false';

  	   	params = params + '&ekena='+ekenaValue;
  	   	
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

  	function showResponseMessage(){
  	  	var messageId = document.getElementById('message');
  	  	if (messageId){
	  	  	var message = messageId.value;
	  	  	var options;
			options = {
				modal:true,
				button:'ok'
			};
			msg.open(message, options);
  	  	}
		return false;
   	}
   	
  	function submitIP(){				
		var req = new AjReq();
		var opts = {
			method : 'POST',
			params : getParameters(),
			update : document.getElementById('formAddIp'),
			abortAfter : 15000,
			onSuccess : function(){ 
				showResponseMessage();
				reloadIPs();
			},
			onAbort : function(){ showMessage('Tsy voaray ny IP nampidirina teo');}
		};
		
		req.send('addIp.htm', opts);
	}

  	reloadIPs();	//Charger pour la 1ère fois la liste des IPs déjà autorisées
</script>

<!-- fin corps -->

<%@ include file="/footer.jsp" %>
