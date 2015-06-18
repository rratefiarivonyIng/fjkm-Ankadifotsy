<%@ include file="/jsp/include.jsp" %>

<%@ page import="java.util.List" %>

<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>

<%@ page import="mg.fjkm.ankadifotsy.form.FormMotDePasse" %>

<%@ include file="/header.jsp" %>

<script language="javascript">
	function submitFormFromLink(mode){
		document.getElementById('mode').value = mode;
		document.getElementById('formMotDePasse').submit();
	}		
</script>

<!-- debut corps -->
<%
	request.setAttribute("ctx",request.getContextPath());
%>

<table width="100%">
	<tr>
	  <td>
		<ul id="tabnav">
			<li><a href="index.htm">Mpivavaka</a></li>
			<li><a class="onglet" href="index.htm?sampana">Sampana</a></li>
			<li><a class="onglet" href="index.htm?diakona">Diakona</a></li>
			<li class="active"><a class="onglet" href="index.htm?administration">Administration</a></li>
			<% if (org.acegisecurity.context.SecurityContextHolder.getContext().getAuthentication() != null) {%>
			<li id="disconnect"><a href="<%=request.getContextPath()%>/logout.jsp">Déconnecter</a></li>
			<%}%>
		</ul>
	    <p class="title1">Attribution / Modification du mot de passe du contribuable</p>
	    <div class="normal" align="center">Veuillez saisir le nif, le mot de passe et la confirmation : </div>
	    <div class="boxform">
	<form 
		id="formMotDePasse" 
		name="formMotDePasse" 
		method="post" 
		action="attributionMotDePasse.htm" 
	>
	
	<table width="557" border="0" align="center" cellpadding="3" cellspacing="0" bgcolor="#FFCC66" valign="TOP">
	<tbody>
	  <tr>
	    <td colspan="6"><span class="title2">Attribution du mot de passe de <strong>${formMotDePasse.login}</strong> </span> 
	    </td>
	  </tr>
	    
	  <tr>
	    <td>&nbsp;</td>
        <td width="97">Login :</td>
        <spring:bind path="formMotDePasse.login">
        <td colspan="4"><input type="text" name="${status.expression}" value="${status.value}" class="inputleft" size="30" /></td>
        </spring:bind>
      </tr>
	  <tr>
	    <td>&nbsp;</td>
        <td width="97">Mot de passe :</td>
        <spring:bind path="formMotDePasse.password">
        <td colspan="4"><input type="password" name="${status.expression}" value="${status.value}" class="inputleft" size="30" /><font color="red" size="1.2">${status.errorMessage}</font></td>
        </spring:bind>
      </tr>
	  <tr>
	    <td>&nbsp;</td>
        <td width="97">Confirmation :</td>
        <spring:bind path="formMotDePasse.confirmation">
        <td colspan="4"><input type="password" name="${status.expression}" value="${status.value}" class="inputleft" size="30" /><font color="red" size="1.2">${status.errorMessage}</font></td>
        </spring:bind>
      </tr>

	  <tr>
		<td colspan="2"><input name="Annuler" value="Annuler" type="submit" /></td>                  
		<td colspan="2"><input name="Enregistrer" value="Enregistrer" type="submit"/></td>                  
	  </tr>
	    
	</tbody>
	</table>
	</form>
	</div>	  
      </td>
	</tr>
</table>
<!-- fin corps -->

<%@ include file="/footer.jsp" %>