<%@ include file="/jsp/include.jsp" %>

<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%@ include file="/header.jsp" %>

<script language="javascript">	
	function submitFormFromLink(pageNo){
		document.getElementById('pageNo').value = pageNo;
		document.getElementById('boutonValider').value = 'Tadiavo';
		document.getElementById('formListMirotsakaFidiana').submit();
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

<table align="center" border="0" >
  <tr>
    <td>
		<%@ include file="/onglet.jsp" %>
    </td>
  </tr>
  <%@ include file="showFifidianana.jsp" %>
    
  <tr><td>${formListMirotsakaFidiana.title}</td></tr>
  <tr>
    <td>
	<form id="formListMirotsakaFidiana" name="formListMirotsakaFidiana" method="post" action="searchChristian.htm">
    <spring:bind path="formListMirotsakaFidiana.pageNo">
       <input name="${status.expression}" id="pageNo" value="${status.value}" type="hidden" />
    </spring:bind>

    <spring:bind path="formListMirotsakaFidiana.from">
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
	
  <tr>
    <td><a href="selectFifidianana.htm?id=${formListMirotsakaFidiana.fifidiananaId}">Miverina amin'ny fifidianana</a></td>
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
			params : 'pageNo='+pageNo+'&<%=ConstantUtils.sfParamMirotsakaFidianaRehetra%>=<%=formListMirotsakaFidiana.isAllMirotsakaFidiana() ? "1":"0" %>&<%=ConstantUtils.sfParamMirotsakaFidianaNekena%>=<%=formListMirotsakaFidiana.getEkenaFirotsahana() != null ? (formListMirotsakaFidiana.getEkenaFirotsahana().booleanValue() ? "1" :"0"):"" %>',
			update : document.getElementById('searchResults'),
			abortAfter : 15000,
			onSuccess : function(){ msg.close(); },
			onAbort : function(){ msg.close(); }
		};
		req.send('listMirotsakaFidiana.htm', opts);		
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
  if (formListMirotsakaFidiana.isSubmit()){
%>
<script language="javascript">
	loadResults('<%=formListMirotsakaFidiana.getPageNo()%>');
</script>
<%
  }
%>

<!-- fin corps -->

<%@ include file="/footer.jsp" %>
