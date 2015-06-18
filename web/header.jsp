<html>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page import="mg.fjkm.ankadifotsy.util.Utils" %>
<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>
<%@ page import="mg.fjkm.ankadifotsy.bo.SaveableEntity" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FJKM Ankadifotsy</title>
<meta id="MetaDescription" name="DESCRIPTION" content="fjkm-Ankadifotsy.mg">
<meta id="MetaKeywords" name="KEYWORDS" content="FJKM, Ankadifotsy, Java J2EE">
<meta id="MetaAuthor" name="AUTHOR" content="Rija RATEFIARIVONY">

<link type="text/css" media="screen" rel="stylesheet" href="<%=request.getContextPath()%>/css/calendar-system.css">
<link type="text/css" media="screen" rel="stylesheet" href="<%=request.getContextPath()%>/css/fjkmAnkadifotsy.css">
<link type="text/css" media="all" rel="stylesheet"  href="<%=request.getContextPath()%>/msg/msg.css" />  <!-- Pour les messages dans des BD DIV -->

<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/scripts/calendar.js"></script>
<script type="text/javascript" language="javascript" src='<%=request.getContextPath()%>/scripts/lang/calendar-fr.js' ></script>
<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/scripts/calendar-setup.js"></script>
<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/scripts/tooltip.js"></script>
<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/scripts/fjkmAnkadifotsy.js"></script>
<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/msg/msg.src.js"></script> <!-- Pour les messages dans des BD DIV -->
<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/scripts/AjReq.src.js" ></script>  <!-- Ajax -->
<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/scripts/bubulle.v2.src.js" ></script>  <!-- Bubulle -->
	<!--[if lte IE 8]><link href="../../ressources/css/base-ie.css" rel="stylesheet" type="text/css" /><![endif]-->
	<!--[if lte IE 8]><link href="../../ressources/css/ielt8.css" rel="stylesheet" type="text/css" /><![endif]-->
	<!--[if lt IE 7]><link href="../../ressources/css/ielt7.css" rel="stylesheet" type="text/css" /><![endif]-->

<%@ include file="/jsp/ajaxInclude.jsp" %>

<style type="text/css">
<!--
.Style1 {color: #26337E}
-->
</style>

<script type="text/javascript" language="javascript">
function maximizeMinimize(){
	if (document.getElementById('topBanner').style.display=='block'){
		document.getElementById('topBanner').style.display='none';
		document.getElementById('buttonReduce').style.display='block';		
	}
	else{
		document.getElementById('topBanner').style.display='block';
		document.getElementById('buttonReduce').style.display='none';		
	}
}
</script>

</head>
<body alink="#ffffff"  vlink="#ffffff" link="#ffffff">

<div id="topBanner" align="center" style="display:block;">
<img src="<%=request.getContextPath()%>/images/top.jpg" ondblclick="javascript: maximizeMinimize();" title="Double-cliquez pour réduire"/>
</div>
<div id="buttonReduce" style="display:none; position:relative; float:right;"><img src="<%=request.getContextPath()%>/images/reduce.jpg" onclick="javascript: maximizeMinimize();" title="cliquez pour agrandir"/></div>