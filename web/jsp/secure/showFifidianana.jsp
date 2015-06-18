<%@ include file="/jsp/include.jsp" %>

<%@ page import="java.util.Date" %>

<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>
<%@ page import="mg.fjkm.ankadifotsy.util.Utils" %>

<%@ page import="mg.fjkm.ankadifotsy.bo.Fifidianana" %>

<%@ page import="mg.fjkm.ankadifotsy.form.FormListMirotsakaFidiana" %>

<%!
	FormListMirotsakaFidiana formListMirotsakaFidiana;
	Fifidianana fifidianana;
	Date now;
%>
<%
	fifidianana = (Fifidianana)request.getAttribute(ConstantUtils.sfREQUEST_FIFIDIANANA);	//pour showFifidianana.jsp
	formListMirotsakaFidiana = (FormListMirotsakaFidiana)request.getAttribute(FormListMirotsakaFidiana.sfFORM_ID);
	now = new Date();
%>

<%if (fifidianana != null){ %>
  <tr>
    <td>
	  <table width="100%"  align="center" border="0" cellpadding="0" cellspacing="0" bgColor="#0099FF">
	    <tr>
	      <td><b><%=fifidianana.getLabel()%> </b></td>
	      <td>eto amin'ny <b><%=fifidianana.getFitandremana().getLabel()%></b></td>
	      <td>Taom-panompoana <b><%=fifidianana.getTaomPanompoana().toString()%></b></td>
		  <td><input type="button" class="button" name="Mivoaka" value="Mivoaka <%=fifidianana.getLabel() == null || "".equals(fifidianana.getLabel().trim()) ? fifidianana.getKarazamPifidianana().getLabel() : fifidianana.getLabel()%>" onclick="javascript: document.location.href='index.htm?fifidianana&<%=ConstantUtils.sfParameterMivoakaFifidianana%>';"/></td>
	    </tr>
	    <tr>
	      <td>Firotsahana ho fidiana :</td>
	      <td>manomboka ny <b><%=Utils.sfDateFormatJJMMYYYY.format(fifidianana.getDatyManombokaFirotsahana())%></b></td>
	      <td>mifarana ny <b><%=Utils.sfDateFormatJJMMYYYY.format(fifidianana.getDatyMamaranaFirotsahana())%></b></td>
		  <td>
		  <%  
		  if (formListMirotsakaFidiana != null && !formListMirotsakaFidiana.isAllMirotsakaFidiana()) {
		    if (formListMirotsakaFidiana.getEkenaFirotsahana() != null && formListMirotsakaFidiana.getEkenaFirotsahana().booleanValue()){
		      if (fifidianana.getDatyMamaranaFirotsahana().getTime() < now.getTime() && !formListMirotsakaFidiana.isHaveAllMirotsakaFidianaEkenaLaharana()){
		  %>
                <input type="button" name="Omeo Laharana" value="Omeo Laharana" onclick="javascript:showMessageAttribution();"/>
		  <%
		      }
		    }
		  }
		  %>
		  </td>
	    </tr>
	  </table>
	</td>
  </tr>
<%}%>

<!--- message éventuel depuis attribution de numéro -------->
<%@ include file="/messageAttrLaharana.jsp" %>
