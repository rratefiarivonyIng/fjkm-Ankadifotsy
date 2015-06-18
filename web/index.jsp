<%@ include file="/jsp/include.jsp" %>

<%@ page import="java.util.List" %>

<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>

<%@ page import="mg.fjkm.ankadifotsy.bo.User" %>

<html>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FJKM Ankadifotsy</title>
<meta id="MetaDescription" name="DESCRIPTION" content="fjkm-Ankadifotsy.mg">
<meta id="MetaKeywords" name="KEYWORDS" content="FJKM, Ankadifotsy, Java J2EE">
<meta id="MetaAuthor" name="AUTHOR" content="Rija RATEFIARIVONY">

<link type="text/css" media="screen" rel="stylesheet" href="<%=request.getContextPath()%>/css/calendar-system.css">
<link type="text/css" media="screen" rel="stylesheet" href="<%=request.getContextPath()%>/css/fjkmAnkadifotsy.css">
<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/scripts/calendar.js"></script>
<script type="text/javascript" language="javascript" src='<%=request.getContextPath()%>/scripts/lang/calendar-fr.js' ></script>
<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/scripts/calendar-setup.js"></script>


<%@ include file="/jsp/ajaxInclude.jsp" %>

<style type="text/css">
<!--
.Style1 {color: #26337E}
-->
</style>
</head>
<body alink="#ffffff"  vlink="#ffffff" link="#ffffff">

<table valign="TOP" align="center" bgcolor="#ffffff" cellpadding="0" cellspacing="0" width="728">
	<tbody>
	<tr>					
		<td bgcolor="#223039" width="521">  
			<img src="<%=request.getContextPath()%>/images/top.jpg"/>
		</td>
	</tr>
</tbody>
</table>

<%
  List<User>users = (List<User>)request.getAttribute("users");
  for (User user : users){
  	out.println("Login :"+user.getLogin()+"<br/>");
  	out.println("PWD :"+user.getPassword()+"<br/>");
  }
%>

<table valign="TOP" align="center" bgcolor="#2a3942" border="0" cellpadding="3" cellspacing="0" width="725">
  <tbody><tr> 
    <td class="footermenu" align="center" bgcolor="#2a3942" height="30"><font color="#ffffff" size="2" face="Trebuchet MS"><span class="duztext">FJKM - Ankadifotsy<strong>-</strong>Fitantanana ny vahoakan'Andriamanitra <br>
      Ankadifotsy - Antananarivo(101)-BP  - Antso an-taroby : 
    08 - Mailaka:komity@fjkm-ankadifotsy.mg</span></font></td>
  </tr>
  <tr>
    <td class="footermenu" align="center"> <font color="#e8e7e7" size="-2" face="Geneva, Arial, Helvetica, sans-serif">© 
      2011-2015 FJKM Ankadifotsy</font></strong></td>

  </tr>
  <tr>
    <td><a href="logout.jsp">Mivoaka</a></td>
  </tr>
</tbody>
</table>

</td></tr>
</tbody>
</table>
</body>
</html>