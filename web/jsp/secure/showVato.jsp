<%@ include file="/jsp/include.jsp" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%@ page import="mg.fjkm.ankadifotsy.bo.SaveableEntity" %>
<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>
<%@ page import="mg.fjkm.ankadifotsy.util.Utils" %>

<%@ page import="mg.fjkm.ankadifotsy.form.FormManisaVato" %>

<%!
FormManisaVato formManisaVato;
%>
<%
  formManisaVato = (FormManisaVato)request.getSession().getAttribute("FormMijeryVato");
%>
	      <table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
            <tr bgcolor="#000099" style="color:#FFFFFF">
              <td colspan="2">Isan'ny vato </td>
              <td>rehetra :</td>
              <td> ${formManisaVato.isaVatoVoaisa} </td>
              <td>manankery :</td>
              <td> ${formManisaVato.isaVatoManankery} </td>
              <td>maty :</td>
              <td> ${formManisaVato.isaVatoMaty} </td>
              <td>fotsy :</td>
              <td> ${formManisaVato.isaVatoFotsy}</td>
            </tr>
            <tr>
              <td>Vato fotsy </td>
              <td colspan="4" align="left"><input name="vatoFotsy" type="checkbox" disabled="disabled" <%=formManisaVato.isVatoFotsy() ? "checked" : ""%>/></td>
              <td colspan="3">&nbsp;</td>
              <td>Vato maty </td>
              <td align="right"><input name="vatoMaty"  type="checkbox" disabled="disabled" <%=formManisaVato.isVatoMaty() ? "checked" : ""%>/></td>
            </tr>
      
            <tr bgcolor="#000099" style="color:#FFFFFF">
              <td>Laharana </td><td><input type="text" name="vatoLaharana" id="vatoLaharana" value="${formManisaVato.vatoLaharana }" disabled="disabled"/><input type="hidden" name="famerenana" id="famerenana" value="${formManisaVato.famerenana}"/></td><td colspan="8" >&nbsp;</td>
            </tr>
	      <%
	        int col = 0;
	        int row = 0;
	        for (Map<String,Object> mirotsakaFidiana : formManisaVato.getMirotsakaFidianas()){
	          Integer mirotsakaLaharana = (Integer)mirotsakaFidiana.get("laharanaMpirotsaka");
	          Long mirotsakaFidianaId = (Long)mirotsakaFidiana.get("mirotsakaFidianaId");
	          if (col % 10 == 0){
	            out.println("<tr>");
	            row ++;
	          }
	      
	          if (row % 2 == 0){
	        	if (formManisaVato.isMirotsakaFidianaVoafidy(mirotsakaFidianaId))
	              out.println("<td width=\"10%\" bgcolor=\"#66CCFF\">"+mirotsakaLaharana+" <input type=\"checkbox\" name=\"mirotsaka"+mirotsakaLaharana+"\" checked disabled=\"disabled\"></td>");
	        	else
		          out.println("<td width=\"10%\" bgcolor=\"#66CCFF\">"+mirotsakaLaharana+" <input type=\"checkbox\" name=\"mirotsaka"+mirotsakaLaharana+"\" disabled=\"disabled\"></td>");
	          }
	          else{
		        if (formManisaVato.isMirotsakaFidianaVoafidy(mirotsakaFidianaId))
	              out.println("<td width=\"10%\" bgcolor=\"#C0C0C0\">"+mirotsakaLaharana+" <input type=\"checkbox\" name=\"mirotsaka"+mirotsakaLaharana+"\" checked disabled=\"disabled\"></td>");
		        else
	              out.println("<td width=\"10%\" bgcolor=\"#C0C0C0\">"+mirotsakaLaharana+" <input type=\"checkbox\" name=\"mirotsaka"+mirotsakaLaharana+"\" disabled=\"disabled\"></td>");
	          }
	          
	          if ((col+1) % 10 == 0){
	            out.println("</tr>");
	          }
	      
	          col++;
	        }
	        
	        //Compléter les colonnes vides sans candidats et fermer le tag </tr>
	        if (col % 10 > 0){
	        	
	        	for (int i = col % 10 ; i < 10; i++){
	  	          if (row % 2 == 0)
	  	            out.println("<td width=\"10%\" bgcolor=\"#66CCFF\">&nbsp;</td>");
	  	          else
	  	            out.println("<td width=\"10%\" bgcolor=\"#C0C0C0\">&nbsp;</td>");
	        	}
	        	out.println("</tr>");
	        }	        
	      %>
            <tr>
              <td colspan="10" bgcolor="#000099">
              	<center><input type="button" name="Ovao" value="Ovao" onclick="javascript: document.location='<%=request.getContextPath()%>/admin/editVato.htm?vatoLaharana=<%=formManisaVato.getVatoLaharana()%>&<%=formManisaVato.getLehilahy()? "lehilahy":"vehivavy"%>';" /></center>
			  </td>
            </tr>

            <tr>
              <td colspan="10" bgcolor="#000099">    
              	<!-- Information de création et de dernière modification -->
      			<%@ include file="infoCreation.jsp" %>	
			  </td>
            </tr>

          </table>
             
<!-- message dans boite de dialogue de type div positionné dans les controller -->
<%@ include file="/messageManisaVato.jsp" %>
             