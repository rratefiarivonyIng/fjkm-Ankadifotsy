<% if (request.getAttribute(ConstantUtils.sfSaveableEntity) != null) {
     SaveableEntity saveableEntity = (SaveableEntity) request.getAttribute(ConstantUtils.sfSaveableEntity);
%>
<table width="100%" border="0" bgcolor="#FFCC99">
<tr>
  <td align="left">
   No : [<b><%=saveableEntity.getId()%></b>] > Nampidirin'i :<b><%=saveableEntity.getUserCreator().getLogin()%> </b> 
  </td>
  <td align="left">
  tamin'ny : <b><%=Utils.sfDateFormatJJMMYYYYHHmmss.format(saveableEntity.getDateCreation())%></b>
  </td>

<% if (saveableEntity.getUserLastModification() != null) { %>
  <td align="right">
   Novain'i :<b><%=saveableEntity.getUserLastModification().getLogin()%> </b> 
  </td>
  <td align="right">
  tamin'ny : <b><%=Utils.sfDateFormatJJMMYYYYHHmmss.format(saveableEntity.getDateLastModification())%></b>
  </td>
<%}
  else {%>
  <td align="right">
    &nbsp;
  </td>
  <td align="right">
    &nbsp;
  </td>
<%}%>
</tr>
</table>
<%}%>