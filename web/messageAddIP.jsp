<%
if (request.getAttribute(ConstantUtils.sfMessageExist) != null && ((Boolean)request.getAttribute(ConstantUtils.sfMessageExist)).booleanValue()){
%>
    <input type="hidden" id="message" value="<%=request.getAttribute(ConstantUtils.sfMessageContent)%>" />
<%
}
%>
