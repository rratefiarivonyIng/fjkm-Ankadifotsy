<%
  if (request.getAttribute(ConstantUtils.sfMessageEnregistrementOK) != null){
%>
<script language="javascript">
function showMessage (){
	var options = {
		"title": "Valin'ny fangatahana",
		"button": "OK",
		"className":"success",
		<%
		if (request.getAttribute(ConstantUtils.sfEditedFromSearch) != null && ((Boolean)request.getAttribute(ConstantUtils.sfEditedFromSearch)).booleanValue()){
		%>
		"modal":"true",
		"onClose": function(){
			document.location='listMirotsakaFidiana.htm?reload&from=<%=request.getSession().getAttribute(ConstantUtils.sfSelectedTab)%>'
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