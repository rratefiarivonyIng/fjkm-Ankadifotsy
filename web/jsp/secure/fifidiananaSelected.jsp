<%@ include file="/jsp/include.jsp" %>

<%@ page import="java.util.Date" %>


<%@ page import="mg.fjkm.ankadifotsy.util.Utils" %>
<%@ page import="mg.fjkm.ankadifotsy.util.ConstantUtils" %>

<%@ include file="/header.jsp" %>

<!-- debut corps -->

<table align="center" border="0" >
  <tr>
    <td>
		<%@ include file="/onglet.jsp" %>
    </td>
  </tr>
  
  <%@ include file="showFifidianana.jsp" %>
  
  <%!
  Boolean afakaManisaVato = null;
  Boolean efaNahazoLaharanaAvokoa = null;
  %> 
  <%
  afakaManisaVato = (Boolean)request.getAttribute(ConstantUtils.sfREQUEST_AFAKA_MANISA_VATO);
  efaNahazoLaharanaAvokoa = (Boolean)request.getAttribute(ConstantUtils.sfREQUEST_NAHAZO_LAHARANA);
  if (fifidianana != null){
  %>
  <tr>
    <td>
	  <div>eto ianao dia  :
	  <ol>
		<li>
		<%
		if (fifidianana.getDatyMamaranaFirotsahana().getTime() >= now.getTime()){
		%>
		<a href="searchChristianAjax.htm?from=fifidianana" title='manokatra ny pejy fitadiavana mpivavaka'>Hampiditra firotsahana,</a>
		<%
		}
		else{
		%>
		Hampiditra firotsahana,
        <%
        }
        %>		 
		</li>
		<li><a href="listMirotsakaFidiana.htm?<%=ConstantUtils.sfParamMirotsakaFidianaRehetra%>=1">Lisitry ny mpirotsaka ho fidiana (${numberTotalMirotsakaFidiana})</a>, </li>
		<li><a href="listMirotsakaFidiana.htm?<%=ConstantUtils.sfParamMirotsakaFidianaRehetra%>=0">Lisitry ny mpirotsaka mbola tsy nojerena (${numberNotChecked})</a>, </li>
		<li><a href="listMirotsakaFidiana.htm?<%=ConstantUtils.sfParamMirotsakaFidianaRehetra%>=0&<%=ConstantUtils.sfParamMirotsakaFidianaNekena%>=1">Lisitry ny mpirotsaka ho fidiana efa nekena (${numberCheckedOk})</a>, </li>
		<li><a href="listMirotsakaFidiana.htm?<%=ConstantUtils.sfParamMirotsakaFidianaRehetra%>=0&<%=ConstantUtils.sfParamMirotsakaFidianaNekena%>=0">Lisitry ny mpirotsaka nolavina (${numberCheckedKo})</a> </li>
		<%
		//Mbola tsy tapitra ny fisoratana anarana
		if (fifidianana.getDatyMamaranaFirotsahana().getTime() >= now.getTime()){
		%>
			<li>Lisitra farany ny mpirotsaka vehivavy</li>
			<li>Lisitra farany ny mpirotsaka lehilahy</li>
		<%
			if (fifidianana.isMitohyLaharana() || fifidianana.isFifidiananaOloTokana()){
		%>
		<li>Fanisam-bato</li>
		<li>Voka-pifidianana araka ny isam-bato</li>
		<li>Voka-pifidianana araka ny anarana</li>
		<%
			}
			else{
		%>
		<li>Fanisam-bato vehivavy</li>
		<li>Fanisam-bato lehilahy</li>
		<li>Voka-pifidianana araka ny isam-bato</li>
		<li>Voka-pifidianana araka ny anarana</li>
		<%
			}
		}
		else{
			if (efaNahazoLaharanaAvokoa != null && efaNahazoLaharanaAvokoa.booleanValue()){
		%>
		<li><a href="listFaranyMirotsakaFidiana.htm?<%=ConstantUtils.sfParamMirotsakaFidianaRehetra%>=0&<%=ConstantUtils.sfParamMirotsakaFidianaNekena%>=1&vehivavy">Lisitra farany ny mpirotsaka vehivavy</a></li> 
		<li><a href="listFaranyMirotsakaFidiana.htm?<%=ConstantUtils.sfParamMirotsakaFidianaRehetra%>=0&<%=ConstantUtils.sfParamMirotsakaFidianaNekena%>=1&lehilahy">Lisitra farany ny mpirotsaka lehilahy</a></li> 
		<%
			}
			else{
		%>
			<li>Lisitra farany ny mpirotsaka vehivavy</li>
			<li>Lisitra farany ny mpirotsaka lehilahy</li>
		<%
			}
			
			if (afakaManisaVato){
				if (fifidianana.isMitohyLaharana() || fifidianana.isFifidiananaOloTokana()){
		%>
				<li><a href="initManisaVato.htm?<%=ConstantUtils.sfParamMirotsakaFidianaRehetra%>=0&<%=ConstantUtils.sfParamMirotsakaFidianaNekena%>=0">Fanisam-bato</a></li> 
				<li><a href="vokatraFifidianana.htm?init=1">Voka-pifidianana araka ny isam-bato</a></li> 
				<li><a href="vokatraFifidianana.htm?init=2">Voka-pifidianana araka ny anarana</a></li> 
        <%
				}
				else{
		%>
				<li><a href="initManisaVato.htm?<%=ConstantUtils.sfParamMirotsakaFidianaRehetra%>=0&<%=ConstantUtils.sfParamMirotsakaFidianaNekena%>=0&vehivavy">Fanisam-bato vehivavy</a></li> 
				<li><a href="initManisaVato.htm?<%=ConstantUtils.sfParamMirotsakaFidianaRehetra%>=0&<%=ConstantUtils.sfParamMirotsakaFidianaNekena%>=0&lehilahy">Fanisam-bato lehilahy</a></li> 
				<li><a href="vokatraFifidianana.htm?init=1">Voka-pifidianana araka ny isam-bato</a></li> 
				<li><a href="vokatraFifidianana.htm?init=2">Voka-pifidianana araka ny anarana</a></li> 
				<li><a href="fanamarinanaVato.htm">Fanamarinam-bato</a></li> 
		<%
				}
			}
			else{
				if (fifidianana.isMitohyLaharana() || fifidianana.isFifidiananaOloTokana()){
		%>
				<li>Fanisam-bato</li>
				<li>Voka-pifidianana araka ny isam-bato</li>
				<li>Voka-pifidianana araka ny anarana</li>
				<li>Fanamarinam-bato</li>
		<%
				}
				else{
		%>
				<li>Fanisam-bato vehivavy</li>
				<li>Fanisam-bato lehilahy</li>
				<li><a href="vokatraFifidianana.htm?init=1">Voka-pifidianana araka ny isam-bato</a></li> 
				<li><a href="vokatraFifidianana.htm?init=2">Voka-pifidianana araka ny anarana</a></li> 
				<li><a href="fanamarinanaVato.htm">Fanamarinam-bato</a></li> 
		<%
				}
			}
        }
		if (Utils.isLoggedUserAdmin()){
		%>
			<li><a href="<%=request.getContextPath()%>/admin/initFifidianana.htm"><b><font color="red">Averina 0 ny vato rehetra</font></b></a></li> 
		<%
		}
        %>		 
	  </ol>
	  </div>
    </td>
  </tr>
  <%
  }
  %>
</table>

<!-- message dans boite de dialogue de type div positionné dans les controller -->
<%@ include file="/messageFifidianana.jsp" %>

<!-- fin corps -->

<%@ include file="/footer.jsp" %>
