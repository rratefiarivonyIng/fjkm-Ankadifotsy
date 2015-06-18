<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>  
<%@ page isErrorPage="true" %>

<%@ include file="/jsp/include.jsp" %>

<%@ include file="/header.jsp" %>

<TABLE border="0" cellspacing="0" cellpadding="3" align="CENTER" valign="TOP" bgcolor="#FFFFFF">
<TR>
	<TD><Font size="3" face="Arial" color="#FF0000">Miala tsiny : Misy tsy fihetezana.<br/></font></TD>
</TR>
<TR>
	<TD><Font size="3" face="Arial" color="#FF0000"><%=exception.getMessage()%><br/></font></TD>
	<%
		exception.printStackTrace();
	%>
</TR>
<TR>
	<TD><a href="<%=request.getContextPath()%>/index.jsp">Miverina any amin'ny fidirana</a><br/></TD>
</TR>
</TABLE>

<%@ include file="/footer.jsp" %>
