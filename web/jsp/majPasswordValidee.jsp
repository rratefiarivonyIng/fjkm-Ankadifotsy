<%@ include file="/jsp/include.jsp" %>

<%@ include file="/header.jsp" %>

<!-- debut corps -->
<table width="100%">
	<tr><td>
		<ul id="tabnav">
			<li><a class="onglet" href="index.htm">Mpivavaka</a></li>
			<li><a class="onglet" href="index.htm?sampana">Sampana</a></li>
			<li class="activte"><a href="index.htm?diakona">Diakona</a></li>
			<li><a class="onglet" href="index.htm?adminitration">Administration</a></li>
			<% if (org.acegisecurity.context.SecurityContextHolder.getContext().getAuthentication() != null) {%>
			<li id="disconnect"><a href="<%=request.getContextPath()%>/logout.jsp">Mivoaka</a></li>
			<%}%>
		</ul>
		<p></p>
		</td></tr>
		<tr><td align="center">
	<div class="title1" align="center" >Modification mot de passe</div> 
	  <p></p>
	  
	  <table width="80%"  border="0" align="center">
        <tr>
          <td  class="tabjaune"><div align="center"><span class="normal">Votre login : <span class="Style1">${userInfo.login}</span></span></div></td>
        </tr>
        <tr>
          <td class="tabgrise"><div class="normal" align="center">Votre nouveau mot de passe :<span class="Style1">${userInfo.password}</span></div>
          </td>
        </tr>
      </table>
	</div>
	  <div class="normal" align="center"></div>
	  </td>
	</tr>
</table>
<!-- fin corps -->

<%@ include file="/footer.jsp" %>