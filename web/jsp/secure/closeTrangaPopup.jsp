<%@ include file="/jsp/include.jsp" %>

<html>
<head>
<title> Fermeture de la fen�tre </title>
<meta name="Author" content="Rija RATEFIARIVONY">
<meta name="Keywords" content="">
<meta name="Description" content="ferme la fen�tre en cours">
</head>
<script language="javascript">    
  function updateOpenerAndSelfClose(){
    window.opener.document.getElementById('${idKarazaTranga}').innerHTML='Eny';
    window.close();
  }
  
</script>
<body onload="javascript:updateOpenerAndSelfClose();">

</body>
</html> 
