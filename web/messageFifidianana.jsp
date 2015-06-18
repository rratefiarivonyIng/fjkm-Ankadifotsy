<%
  if (request.getAttribute(ConstantUtils.sfMessageEnregistrementOK) != null || request.getAttribute(ConstantUtils.sfMessageExist) != null){
%>
<script language="javascript">
function showMessage (){
	var options = {
		"title": "Valin'ny fangatahana",
		"button": "OK",
		"className":"success",
		"modal":"true"
	};
	    
	msg.open("<%=request.getAttribute(ConstantUtils.sfMessageContent)%>", options);
	return false;
};

showMessage();
</script>
<%
  }
%>
