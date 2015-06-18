<%@ include file="/jsp/include.jsp" %>

<%@ include file="/header.jsp" %>

<!-- debut corps -->
<table align="center">
  <tr>
    <td>
		<%@ include file="/onglet.jsp" %>
    </td>
  </tr>

  <%@ include file="showFifidianana.jsp" %>  
  
  <tr>
    <td>
	  <div class="title1">Fikirakirana ny momba ny fifidianana</div>
    </td>
  </tr>
  
  <tr>
    <td>&nbsp;</td>
  </tr>
  
  <tr>
    <td>
	  <div>Eto ianao dia afaka :
	  <ol>
		<li><a href="<%=request.getContextPath()%>/admin/editFifidianana.htm" title="Manokatra fifidianana vaovao">Manokatra fifidianana vaovao</a>, </li>
		<li><a href="<%=request.getContextPath()%>/secure/searchFifidianana.htm" title="Misafidy fifidianana hiasàna (mandray firotsahana, manisa vato, ...)">Mikirakira fifidianana</a> </li>
	  </ol>
	  </div>
	</td>
  </tr>
  
</table>
<!-- fin corps -->

<%@ include file="/footer.jsp" %>