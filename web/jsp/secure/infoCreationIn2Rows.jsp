<% if (request.getAttribute(ConstantUtils.sfSaveableEntity) != null) {
     SaveableEntity saveableEntity = (SaveableEntity) request.getAttribute(ConstantUtils.sfSaveableEntity);
%>
<table width="100%" border="0" bgcolor="#FFCC99">
<tr>
  <td align="left">
   Nampidirin'i :<b><%=saveableEntity.getUserCreator().getLogin()%> </b> 
  </td>
  <td align="right">
  tamin'ny : <b><%=Utils.sfDateFormatJJMMYYYY.format(saveableEntity.getDateCreation())%></b>
  </td>
</tr>

<% if (saveableEntity.getUserLastModification() != null) { %>
<tr>
  <td align="left">
   Novain'i :<b><%=saveableEntity.getUserLastModification().getLogin()%> </b> 
  </td>
  <td align="right">
  tamin'ny : <b><%=Utils.sfDateFormatJJMMYYYY.format(saveableEntity.getDateLastModification())%></b>
  </td>
<%}
  else {%>
  <td align="left">
    &nbsp;
  </td>
  <td align="right">
    &nbsp;
  </td>
</tr>
<%}%>

</table>
<%}%>