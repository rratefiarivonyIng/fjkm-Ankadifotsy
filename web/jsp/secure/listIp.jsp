<%@ include file="/jsp/include.jsp" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="mg.fjkm.ankadifotsy.bo.AuthorizedIP" %>

			<%!
			List<AuthorizedIP> aips;
			int i;
			boolean hasMoreElements;
			Iterator<AuthorizedIP> iterator;
			AuthorizedIP aip1, aip2;
			%>
			<%
			aips = (List<AuthorizedIP>)request.getAttribute("aips");
			%>
			
			<%
			if (aips != null && aips.size()>0){
			%>
			
			<table border="0" width="100%">
			  <%
			  i = 0;
			  iterator = aips.iterator();
			  hasMoreElements = iterator.hasNext();
			  
			  while (hasMoreElements){
				  aip1 = iterator.next();
				  if (iterator.hasNext())
					  aip2 = iterator.next();
				  else{
					  aip2 = null;
					  hasMoreElements = false;
				  }
				  
				  if (i % 2 == 0){
			  %>
			  <tr bgcolor="#66CCFF">
			    <td width="10%"><%=aip1.getIp()%></td>
			    <td width="20%" align="left"><%=aip1.getDescription()%></td>
			    <td width="5%" bgcolor='<%=aip1.isAuthorized() ? "#33FF00":"#FF0000"%>'>&nbsp;</td>
			    <td width="7%" align="center"><input type="button" name="esory" value="esory" onclick="deleteIp('<%=aip1.getId()%>')"/></td>
			    <td width="8%" align="center"><input type="button" name="ovao" value="ovao" onclick="editIp('<%=aip1.getId()%>')"/></td>
			    <td bgcolor="#000000">&nbsp;</td>
			    	<%
			    		if (aip2 != null)
			    		{
			    	%>
			    <td width="10%"><%=aip2.getIp()%></td>
			    <td width="20%" align="left"><%=aip2.getDescription()%></td>
			    <td width="5%" bgcolor='<%=aip2.isAuthorized() ? "#33FF00":"#FF0000"%>'>&nbsp;</td>
			    <td width="7%" align="center"><input type="button" name="esory" value="esory" onclick="deleteIp('<%=aip2.getId()%>')"/></td>
			    <td width="8%" align="center"><input type="button" name="ovao" value="ovao" onclick="editIp('<%=aip2.getId()%>')"/></td>
			    	<% 
			    		}
			    		else{
			    	%>
			    <td width="10%">&nbsp;</td>
			    <td width="20%" align="left">&nbsp;</td>
			    <td width="5%">&nbsp;</td>
			    <td width="7%" align="center">&nbsp;</td>
			    <td width="8%" align="center">&nbsp;</td>
					<%
			    		}
					%>
			  </tr>
			  <%
				  }
				  else{
			   %>
			  <tr bgcolor="#C0C0C0">
			    <td width="10%"><%=aip1.getIp()%></td>
			    <td width="20%" align="left"><%=aip1.getDescription()%></td>
			    <td width="5%" bgcolor='<%=aip1.isAuthorized() ? "#33FF00":"#FF0000"%>'>&nbsp;</td>
			    <td width="7%" align="center"><input type="button" name="esory" value="esory" onclick="deleteIp('<%=aip1.getId()%>')"/></td>
			    <td width="8%" align="center"><input type="button" name="ovao" value="ovao" onclick="editIp('<%=aip1.getId()%>')"/></td>
			    <td bgcolor="#000000">&nbsp;</td>
			    	<%
			    		if (aip2 != null)
			    		{
			    	%>
			    <td width="10%"><%=aip2.getIp()%></td>
			    <td width="20%" align="left"><%=aip2.getDescription()%></td>
			    <td width="5%" bgcolor='<%=aip2.isAuthorized() ? "#33FF00":"#FF0000"%>'>&nbsp;</td>
			    <td width="7%" align="center"><input type="button" name="esory" value="esory" onclick="deleteIp('<%=aip2.getId()%>')"/></td>
			    <td width="8%" align="center"><input type="button" name="ovao" value="ovao" onclick="editIp('<%=aip2.getId()%>')"/></td>
			    	<% 
			    		}
			    		else{
			    	%>
			    <td width="10%">&nbsp;</td>
			    <td width="20%" align="left">&nbsp;</td>
			    <td width="5%">&nbsp;</td>
			    <td width="7%" align="center">&nbsp;</td>
			    <td width="8%" align="center">&nbsp;</td>
					<%
			    		}
					%>

			  </tr>
			   <%
				  }
				  hasMoreElements = iterator.hasNext();
				  i++;
			  }
			  %>
			</table>
			<%
			}
			%>
