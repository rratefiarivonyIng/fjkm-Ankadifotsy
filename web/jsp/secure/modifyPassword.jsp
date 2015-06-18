<%@ include file="/jsp/include.jsp" %>

<%@ page import="java.util.List" %>

<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>

<%@ page import="mg.fjkm.ankadifotsy.form.FormMotDePasse" %>

<%@ include file="/header.jsp" %>


<script language="javascript">
	function submitFormFromLink(mode){
		document.getElementById('mode').value = mode;
		document.getElementById('formModificationPassword').submit();
	}		
</script>

<!-- debut corps -->
<%
	request.setAttribute("ctx",request.getContextPath());
%>

<table align="center">
  <tr>
	<td>
	  <%@ include file="/onglet.jsp" %>
	</td>
  </tr>
	
  <tr>
	<td>
	  <div class="title1">Fikirakirana ny mombamomba ny vahoakan'Andriamanitra</div>
	</td>
  </tr>

  <tr>
    <td>&nbsp;</td>
  </tr>
  	
  <tr>
    <td>
		<form  id="formModificationPassword" 
		   name="formModificationPassword" 
		   method="post" 
		   action="manovaTenyMiafina.htm">
		   <table>
				<tbody>
				  <tr>
				    <td colspan="6"><span class="title2">Manova teny miafina ho an'i <strong>${formModificationPassword.login}</strong> </span> 
				    </td>
				  </tr>
				    
				  <tr>
				    <td>&nbsp;</td>
			        <td width="97">Anarana :</td>
			        <spring:bind path="formModificationPassword.login">
			        <td colspan="4"><input type="text" name="${status.expression}" value="${status.value}" disabled="true" class="inputleft" size="30" /></td>
			        </spring:bind>
			      </tr>

				  <tr>
				    <td>&nbsp;</td>
			        <td width="97">Teny miafina taloha *:</td>
			        <spring:bind path="formModificationPassword.oldPassword">
			        <td colspan="4"><input type="password" name="${status.expression}"  class="inputleft" size="30" /></td>
			        <font color="red" size="1.2">${status.errorMessage}</font>
			        </spring:bind>
			      </tr>

				  <tr>
				    <td>&nbsp;</td>
			        <td width="97">Teny miafina *:</td>
			        <spring:bind path="formModificationPassword.password">
			        <td colspan="4"><input type="password" name="${status.expression}" value="${status.value}" class="inputleft" size="30" />
			        <font color="red" size="1.2">${status.errorMessage}</font>
			        </td>
			        </spring:bind>
			      </tr>
				  <tr>
				    <td>&nbsp;</td>
			        <td width="97">Famerenana *:</td>
			        <spring:bind path="formModificationPassword.confirmation">
			        <td colspan="4"><input type="password" name="${status.expression}" value="${status.value}" class="inputleft" size="30" />
			        <font color="red" size="1.2">${status.errorMessage}</font>
			        </td>
			        </spring:bind>
			      </tr>
			
				  <tr>
					<td colspan="2"><input name="Annuler" value="Annuler" type="submit" /></td>                  
					<td colspan="2"><input name="Enregistrer" value="Enregistrer" type="submit"/></td>                  
				  </tr>
				    
				</tbody>
		   
		   </table>
		</form>
	</td>
  </tr>	
</table>

<!-- message dans boite de dialogue de type div positionné dans les controller -->
<%@ include file="/message.jsp" %>

<%@ include file="/footer.jsp" %>