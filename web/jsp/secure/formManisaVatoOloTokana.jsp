<%@ include file="/jsp/include.jsp" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>
<%@ page import="mg.fjkm.ankadifotsy.util.Utils" %>

<%@ page import="mg.fjkm.ankadifotsy.form.FormManisaVato" %>

<%!
FormManisaVato formManisaVato;
%>
<%
  formManisaVato = (FormManisaVato)request.getSession().getAttribute(FormManisaVato.sfFORM_ID);
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
              <td colspan="4" align="left"><input name="vatoFotsy" type="checkbox" /></td>
              <td colspan="3">&nbsp;</td>
              <td>Vato maty </td>
              <td align="right"><input name="vatoMaty"  type="checkbox" /></td>
            </tr>
      
            <tr>
              <td colspan="10" bgcolor="#000099">&nbsp;</td>
            </tr>
	      <%
	        int col = 0;
	        int row = 0;
	        for (Map<String,Object> mirotsakaFidiana : formManisaVato.getMirotsakaFidianas()){
	          if (col % 10 == 0){
	            out.println("<tr>");
	            row ++;
	          }
	      
	          if (row % 2 == 0)
	            out.println("<td width=\"10%\" bgcolor=\"#66CCFF\">"+mirotsakaFidiana.get("laharanaMpirotsaka")+" <input type=\"radio\" name=\"mirotsaka\" value=\""+mirotsakaFidiana.get("laharanaMpirotsaka")+"\"></td>");
	          else
	            out.println("<td width=\"10%\" bgcolor=\"#C0C0C0\">"+mirotsakaFidiana.get("laharanaMpirotsaka")+" <input type=\"radio\" name=\"mirotsaka\" value=\""+mirotsakaFidiana.get("laharanaMpirotsaka")+"\"></td>");
         
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
              <td colspan="10" bgcolor="#000099">&nbsp;</td>
            </tr>

           <tr>
              <td align="left" colspan="5"><input name="Miverina" class="button" id="boutonMiverina" value="Miverina" type="button" onclick="javascript: document.location.href='selectFifidianana.htm?id=<%=Utils.getFifidiananaFromSession(request).getId()%>'" title="Miverina eo amin'ny fifidianana."/></td>
              <td align="center" colspan="4"><input name="Fafao" class="button" id="boutonFafao" value="Fafao" type="button" title="Mamerina ny fanisana ny vato teo." onclick="javascript: initFormManisaVato();" /></td>
              <td align="right" colspan="1"><input name="Valider" class="button" id="boutonValider" value="Alefa" type="button" title="Isaina ireto vato ireto." onclick="javascript: submitVato();" /></td>
            </tr>      
          </table>
             
<!-- message dans boite de dialogue de type div positionné dans les controller -->
<%@ include file="/messageManisaVato.jsp" %>
             