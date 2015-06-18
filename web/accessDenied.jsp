<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>  
<%@ page isErrorPage="true" %>

<%@ include file="/jsp/include.jsp" %>

<%@ include file="/header.jsp" %>

<TABLE border="0" cellspacing="0" cellpadding="3" align="CENTER" bgcolor="#FFFFFF">
<TR>
	<TD><Font size="3" face="Arial" color="#FF0000">Tsy mahazo alàlana hiditra eto ianao. Manontania ny Administrateur.<br/></font></TD>
</TR>
<TR>
	<TD><a href="<%=request.getContextPath()%>/secure/index.htm">Miverina any amin'ny fidirana</a><br/></TD>
</TR>
</TABLE>

<%@ include file="/footer.jsp" %>