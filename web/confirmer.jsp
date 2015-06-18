<%@ page contentType="text/html; charset=ISO-8859-1" %>
<%@ include file="/jsp/include.jsp" %>
<html><title>Suppression d'un contribuable</title>
	<link rel="stylesheet" href="stylesheets/General.css" type="text/css" media="all"/>		
	<link rel="stylesheet" href="stylesheets/login.css" type="text/css" media="all"/>		
<script language="javascript">
	function confirmAction()
	{
		window.returnValue = "oui";
		window.close();
	}

	function cancelAction()
	{
		window.returnValue = "non";
		window.close();
	}
</script>
<body>
	<table>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
	<table width="100%">
		<tr>
			<td width="5%">&nbsp;</td>
			<td>
				<table class="confirmer">
		<tr>	                                  
		   <td colspan=2 class=titre2>Voulez-vous confirmer la suppression du contribuable ?</td>
		</tr>	
		
		<tr>
			<td>
				<center>	                        
					<table>
						<tr>                    
							<td align="right" ><input type="button" value="Oui" onclick="confirmAction();"></td>
							<td align="left" ><input type="button" value="Non" onclick="cancelAction();"></td>
						</tr>
					</table>	                        
				</center>
			</td>
		</tr>													
	</table>			
			</td>
			<td>&nbsp;</td>
		</tr>
	</table>
	
</body>
</html>