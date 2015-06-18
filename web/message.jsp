<%
  if (request.getAttribute(ConstantUtils.sfMessageEnregistrementOK) != null || request.getAttribute(ConstantUtils.sfMessageExist) != null){
%>
<script language="javascript">
function showMessage (){
	var options = {
		"title": "Valin'ny fangatahana",
		"button": "OK",
		"className":<%=request.getAttribute(ConstantUtils.sfMessageEnregistrementOK) != null ? "\"success\"" : "\"error\""%>,
		<%
		if (request.getAttribute(ConstantUtils.sfEditedFromSearch) != null && ((Boolean)request.getAttribute(ConstantUtils.sfEditedFromSearch)).booleanValue()){
		%>
		"modal":"true",
		"onClose": function(){
			document.location='searchChristianAjax.htm?reload&from=<%=request.getSession().getAttribute(ConstantUtils.sfSelectedTab)%>'
		}
		<%
		}
		else{
		%>
		"modal":"true"
		<%
		}
		%>
	};
	    
	msg.open("<%=request.getAttribute(ConstantUtils.sfMessageContent)%>", options);
	return false;
};

showMessage();
</script>
<%
  }
%>
