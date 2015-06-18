<%@ include file="/jsp/include.jsp" %>

<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>

<%@ include file="/header.jsp" %>

<script language="javascript">    
	function cancelUpload(){
		document.forms["formUploadPhoto"].submitted.value = false;
		document.forms["formUploadPhoto"].submit();
	}
</script>

<!-- debut corps -->

<!-- Le Div qui sert à afficher les bulles d'aide -->
<div id="curseur" class="infobulle"></div>
    
<table align="center" border="0">
  <tr>
	<td>
		<%@ include file="/onglet.jsp" %>
    </td>
  </tr>
    
  <tr>
    <td>
	  <div class="title1">Mampiditra sary ho an'ny mpivavaka : </div><br>
	</td>
  </tr>
  
  <tr>
    <td>
	<form id="formUploadPhoto" name="formUploadPhoto" method="post" enctype="multipart/form-data" action="uploadPhoto.htm">
	<table width="90%" align="center" border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td>Anarana : </td>
	    <td>
	       <input class="inputleft" name="anarana" type="text" size="22" value="${formUploadPhoto.mpivavaka.anarana}" disabled="true"/>	
         </td>
	  </tr>

	  <tr>
	    <td>Fanampiny : </td>
	    <td>
	       <input class="inputleft" name="fanampiny" type="text" size="22" value="${formUploadPhoto.mpivavaka.fanampiny}" disabled="true"/>	
         </td>
	  </tr>

	  <tr>
	    <td>Sary *: </td>
	    <td>
           <input type="file" size="26" class="button" name="file"/>
        </td>
	  </tr>
	  	  
	  <tr>
	    <td align="right"><input name="Valider" class="button" id="boutonValider" value="Miverina" type="button" onclick="javascript: cancelUpload();" /></td>
	    <td align="right"><input name="Valider" class="button" id="boutonValider" value="Alefa" type="submit" style="align:right"/></td>
	  </tr>
	</table>
	<spring:bind path="formUploadPhoto.submitted">
        <input type="hidden" name="${status.expression}" value="${status.value}"/>
    </spring:bind>
    </form>
	  
    </td>
  </tr>
  
</table>


<!-- fin corps -->

<!-- pied de page -->
<%@ include file="/footer.jsp" %>
