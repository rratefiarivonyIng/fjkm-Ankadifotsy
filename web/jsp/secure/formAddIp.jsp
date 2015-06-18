<%@ include file="/jsp/include.jsp" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>
<%@ page import="mg.fjkm.ankadifotsy.util.Utils" %>
<%@ page import="mg.fjkm.ankadifotsy.form.FormAuthorizedIp" %>
<%!
	FormAuthorizedIp formAuthorizedIp;
%>
<%
	formAuthorizedIp = (FormAuthorizedIp)request.getAttribute(FormAuthorizedIp.sfFORM_ID);
%>
		  <input type="hidden" name="authorizedIP_id" id="authorizedIP_id" value="<%=formAuthorizedIp.getId() != null ? formAuthorizedIp.getId() : "" %>"/>
	      <table width="100%" align="center" border="0" cellpadding="0" cellspacing="0" >
            <tr style="color:#FFFFFF">
              <td colspan="2">IP :</td>
              <td><input type="text" name="authorizedIP_ip" id="authorizedIP_ip" value="<%=formAuthorizedIp.getIp() %>"/></td>
              <td>Fanazavana :</td>
              <td><input type="text" name="authorizedIP_fanazavana" id="authorizedIP_fanazavana" value="<%=formAuthorizedIp.getDescription() %>"/></td>
              <td>Ekena :</td>
              <td><input type="checkbox" name="authorizedIP_ekena" id="authorizedIP_ekena" <%=formAuthorizedIp.isAuthorized()? "checked" : ""%>/></td>
            </tr>
      
            <tr >
              <td>&nbsp;</td>
              <td colspan="2"><input name="Fafao" class="button" id="boutonFafao" value="Fafao" type="button" title="Mamerina ahafahana manao fampidirana vaovao." onclick="javascript: initFormAddIp();" /></td>
              <td>&nbsp;</td>              
              <td colspan="2"><input name="Valider" class="button" id="boutonValider" value="Ampidiro" type="button" title="Ampidirina ny IP ..." onclick="javascript: submitIP();" /></td>
            </tr>      
          </table>
          
<!-- message dans boite de dialogue de type div positionné dans les controller -->
<%@ include file="/messageAddIP.jsp" %>          