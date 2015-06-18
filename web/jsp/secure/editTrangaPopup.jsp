<%@ include file="/jsp/include.jsp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page contentType="text/html; charset=ISO-8859-1" %>

<%@ page import="java.util.List" %>

<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>
<%@ page import="mg.fjkm.ankadifotsy.util.Utils" %>

<%@ page import="mg.fjkm.ankadifotsy.bo.Fitandremana" %>
<%@ page import="mg.fjkm.ankadifotsy.bo.SaveableEntity" %>

<%@ page import="mg.fjkm.ankadifotsy.form.FormTranga" %>

<html>
  <title>${formTranga.title}</title>
  <meta id="MetaDescription" name="DESCRIPTION" content="fjkm-Ankadifotsy.mg">
  <meta id="MetaKeywords" name="KEYWORDS" content="FJKM, Ankadifotsy, Java J2EE">
  <meta id="MetaAuthor" name="AUTHOR" content="Rija RATEFIARIVONY">  

  <link type="text/css" media="screen" rel="stylesheet" href="<%=request.getContextPath()%>/css/calendar-system.css">
  <link type="text/css" media="screen" rel="stylesheet" href="<%=request.getContextPath()%>/css/fjkmAnkadifotsy.css">
  <script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/scripts/calendar.js"></script>
  <script type="text/javascript" language="javascript" src='<%=request.getContextPath()%>/scripts/lang/calendar-fr.js' ></script>
  <script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/scripts/calendar-setup.js"></script>

<%@ include file="/jsp/ajaxInclude.jsp" %>

<%!
	FormTranga formTranga;
%>
<%
	formTranga = (FormTranga)request.getAttribute(FormTranga.sfFORM_ID);
%>

<body>
  <table width="100%" border="1">
    <tr>
      <td colspan="2"><div class="title2">${formTranga.label}</div></td>
    </tr>
    
    <tr>
      <td width="5%"></td>
      <td>
        <form id="formTranga" name="formTranga" method="post" action="editTranga.htm">
        <table border="0" width="100%">
          <tr>
            <td>Laharana :</td>
	  		<spring:bind path="formTranga.laharana">
            <td>
              <input name="${status.expression}" type="text" id="laharana" value="${status.value}" size="10" class="inputleft" />
            </td>
            </spring:bind>
          </tr>
          
          <tr>
            <td>Tamin'ny *:</td>
	  		<spring:bind path="formTranga.daty">
            <td>
              <input name="${status.expression}" type="text" id="datyTranga" value="${status.value}" size="10" class="inputleft" />
              <img src="<%=request.getContextPath()%>/images/icon_calendar.gif" id="imgdatyTranga" width="16" height="16" />
              <font color="red" size="1.2">${status.errorMessage}</font>
            </td>
            </spring:bind>
          </tr>	
		
		  <tr>
		    <td width="40%">Fitandremana *:</td>
            <spring:bind path="formTranga.fitandremana" >
            <td align="left">
              <select name="${status.expression}" id="fitandremanaTranga" value="${formTranga.fitandremana.id}" >
              <%
              	if (formTranga.getFitandremana() == null)
				  out.println("<option value='' selected='true' ></option>");
              
                List<Fitandremana> fitandremanas = (List<Fitandremana>) request.getAttribute(ConstantUtils.sfDATA_FITANDREMANAS);
                for (Fitandremana forme : fitandremanas){
                  if (formTranga.getFitandremana() != null && forme.getId().equals(formTranga.getFitandremana().getId()))
                    out.println("<option value='"+forme.getId()+"' selected='true' >"+forme.getLabel()+"</option>");
                  else
                    out.println("<option value='"+forme.getId()+"'>"+forme.getLabel()+"</option>");
                }
              %>
              </select>
              <font color="red" size="1.2">${status.errorMessage}</font>
            </td>
            </spring:bind>
		  </tr>
		  
          <tr>
            <td colspan="2">
              <table width="100%" >
                <tr>                    
                  <td align="left" width="50%"><input type="button" value="Ajanony" onclick="javascript:window.close();"/></td>
                  <td align="right" width="50%"><input type="submit" value="Alefa" name="Valider" /></td>
                </tr>
              </table>	                        
            </td>
          </tr>
        </table>
        </form>
        			
      </td>
    </tr>

    <tr>
      <td colspan="2">
      <!-- Information de création et de dernière modification -->
        <%@ include file="infoCreationIn2Rows.jsp" %>	
	  </td>
    </tr>

  </table>

<script language="javascript">
	Calendar.setup({
		inputField     :    "datyTranga",     // id of the input field
		ifFormat       :    "%d/%m/%Y",      // format of the input field
		button         :    "imgdatyTranga",  // trigger for the calendar (button ID)
		align          :    "Tl",           // alignment (defaults to "Bl")
		singleClick    :    true
	});
</script>

</body>
</html>