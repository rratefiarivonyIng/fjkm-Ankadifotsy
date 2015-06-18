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
              <td colspan="2"><b>Isan'ny vato</b> </td>
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
              <td colspan="4" align="left"><input name="vatoFotsy" type="checkbox" <%=formManisaVato.isVatoFotsy() ? "checked" : ""%>/></td>
              <td colspan="3">&nbsp;</td>
              <td>Vato maty </td>
              <td align="right"><input name="vatoMaty"  type="checkbox" <%=formManisaVato.isVatoMaty() ? "checked" : ""%>/></td>
            </tr>
      
            <tr bgcolor="#000099" style="color:#FFFFFF">
              <td>Laharana </td>
              <td colspan="9"><input type="text" name="vatoLaharana" id="vatoLaharana" value="${formManisaVato.vatoLaharana }"/><input type="hidden" name="famerenana" id="famerenana" value="${formManisaVato.famerenana}"/></td>
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
	              out.println("<td width=\"10%\" bgcolor=\"#66CCFF\">"+mirotsakaLaharana+" <input type=\"checkbox\" name=\"mirotsaka"+mirotsakaLaharana+"\" checked ></td>");
	        	else
		          out.println("<td width=\"10%\" bgcolor=\"#66CCFF\">"+mirotsakaLaharana+" <input type=\"checkbox\" name=\"mirotsaka"+mirotsakaLaharana+"\"></td>");
	          }
	          else{
		        if (formManisaVato.isMirotsakaFidianaVoafidy(mirotsakaFidianaId))
	              out.println("<td width=\"10%\" bgcolor=\"#C0C0C0\">"+mirotsakaLaharana+" <input type=\"checkbox\" name=\"mirotsaka"+mirotsakaLaharana+"\" checked ></td>");
		        else
	              out.println("<td width=\"10%\" bgcolor=\"#C0C0C0\">"+mirotsakaLaharana+" <input type=\"checkbox\" name=\"mirotsaka"+mirotsakaLaharana+"\"></td>");
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

           <tr bgcolor="#336600" style="color:#FFFFFF">
              <td colspan="2"><b>Isan'ny vato</b></td>
              <td>[<%=Utils.getIpFromRequest(request) %>] :</td>
              <td> ${formManisaVato.isaVatoVoaisaIP} </td>
              <td>manankery :</td>
              <td> ${formManisaVato.isaVatoManankeryIP} </td>
              <td>maty :</td>
              <td> ${formManisaVato.isaVatoMatyIP} </td>
              <td>fotsy :</td>
              <td> ${formManisaVato.isaVatoFotsyIP}</td>
           </tr>

           <tr>
              <td align="left" colspan="3"><input name="MivoakaFanisana" class="button" id="boutonMivoakaFanisana" value="Mivoaka fanisàna" type="button" onclick="javascript: document.location.href='selectFifidianana.htm?id=<%=Utils.getFifidiananaFromSession(request).getId()%>'" title="Mivoaka @ fanisàna."/></td>
              <td align="center" colspan="3"><input name="MiverinaVatoFarany" class="buttonMiverina" id="boutonMiverinaVatoFarany" value="Avereno vato farany" type="button" onclick="javascript: submitVato(true,'${formManisaVato.dtime}');" title="Miverina eo amin'ny vato voaisa teo aloha." ${formManisaVato.miverinaVatoTeoAloha}/></td>
              <td align="center" colspan="3"><input name="Fafao" class="button" id="boutonFafao" value="Fafao" type="button" title="Mamerina ny fanisana ny vato teo." onclick="javascript: initFormManisaVato();" /></td>
              <td align="right" colspan="1"><input name="Valider" class="button" id="boutonValider" value="Alefa" type="button" title="Isaina ireto vato ireto." onclick="javascript: submitVato(false, '${formManisaVato.dtime}');" /></td>
            </tr>      
          </table>
             
<!-- message dans boite de dialogue de type div positionné dans les controller -->
<%@ include file="/messageManisaVato.jsp" %>
             