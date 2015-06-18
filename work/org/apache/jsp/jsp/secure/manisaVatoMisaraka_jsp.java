package org.apache.jsp.jsp.secure;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.Map;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.util.Utils;
import mg.fjkm.ankadifotsy.form.FormManisaVato;
import mg.fjkm.ankadifotsy.util.Utils;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.bo.SaveableEntity;
import java.util.Date;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.util.Utils;
import mg.fjkm.ankadifotsy.bo.Fifidianana;
import mg.fjkm.ankadifotsy.form.FormListMirotsakaFidiana;
import java.util.List;
import java.util.Map;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.util.Utils;
import mg.fjkm.ankadifotsy.form.FormManisaVato;

public final class manisaVatoMisaraka_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


FormManisaVato manisaVatoMisaraka_formManisaVato;


	FormListMirotsakaFidiana formListMirotsakaFidiana;
	Fifidianana fifidianana;
	Date now;


FormManisaVato formManisaVato;

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(12);
    _jspx_dependants.add("/jsp/include.jsp");
    _jspx_dependants.add("/WEB-INF/tlds/c.tld");
    _jspx_dependants.add("/WEB-INF/tlds/fmt.tld");
    _jspx_dependants.add("/WEB-INF/tlds/ajaxtags.tld");
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/jsp/ajaxInclude.jsp");
    _jspx_dependants.add("/onglet.jsp");
    _jspx_dependants.add("/jsp/secure/showFifidianana.jsp");
    _jspx_dependants.add("/messageAttrLaharana.jsp");
    _jspx_dependants.add("/jsp/secure/formManisaVato.jsp");
    _jspx_dependants.add("/messageManisaVato.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>FJKM Ankadifotsy</title>\r\n");
      out.write("<meta id=\"MetaDescription\" name=\"DESCRIPTION\" content=\"fjkm-Ankadifotsy.mg\">\r\n");
      out.write("<meta id=\"MetaKeywords\" name=\"KEYWORDS\" content=\"FJKM, Ankadifotsy, Java J2EE\">\r\n");
      out.write("<meta id=\"MetaAuthor\" name=\"AUTHOR\" content=\"Rija RATEFIARIVONY\">\r\n");
      out.write("\r\n");
      out.write("<link type=\"text/css\" media=\"screen\" rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/calendar-system.css\">\r\n");
      out.write("<link type=\"text/css\" media=\"screen\" rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/fjkmAnkadifotsy.css\">\r\n");
      out.write("<link type=\"text/css\" media=\"all\" rel=\"stylesheet\"  href=\"");
      out.print(request.getContextPath());
      out.write("/msg/msg.css\" />  <!-- Pour les messages dans des BD DIV -->\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/scripts/calendar.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\" src='");
      out.print(request.getContextPath());
      out.write("/scripts/lang/calendar-fr.js' ></script>\r\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/scripts/calendar-setup.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/scripts/tooltip.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/scripts/fjkmAnkadifotsy.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/msg/msg.src.js\"></script> <!-- Pour les messages dans des BD DIV -->\r\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/scripts/AjReq.src.js\" ></script>  <!-- Ajax -->\r\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/scripts/bubulle.v2.src.js\" ></script>  <!-- Bubulle -->\r\n");
      out.write("\t<!--[if lte IE 8]><link href=\"../../ressources/css/base-ie.css\" rel=\"stylesheet\" type=\"text/css\" /><![endif]-->\r\n");
      out.write("\t<!--[if lte IE 8]><link href=\"../../ressources/css/ielt8.css\" rel=\"stylesheet\" type=\"text/css\" /><![endif]-->\r\n");
      out.write("\t<!--[if lt IE 7]><link href=\"../../ressources/css/ielt7.css\" rel=\"stylesheet\" type=\"text/css\" /><![endif]-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/scripts/prototype.js\"></script>\r\n");
      out.write("  <script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/scripts/scriptaculous/scriptaculous.js\"></script>\r\n");
      out.write("  <script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/scripts/overlibmws/overlibmws.js\"></script>\r\n");
      out.write("  <script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/scripts/ajax/ajaxtags.js\"></script>\r\n");
      out.write("  <script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/scripts/ajax/ajaxtags_parser.js\"></script>\r\n");
      out.write("  <script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/scripts/ajax/ajaxtags_controls.js\"></script>\r\n");
      out.write("\r\n");
      out.write("  <link type=\"text/css\" media=\"screen\" rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/ajaxtags.css\">\r\n");
      out.write("  ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write(".Style1 {color: #26337E}\r\n");
      out.write("-->\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\">\r\n");
      out.write("function maximizeMinimize(){\r\n");
      out.write("\tif (document.getElementById('topBanner').style.display=='block'){\r\n");
      out.write("\t\tdocument.getElementById('topBanner').style.display='none';\r\n");
      out.write("\t\tdocument.getElementById('buttonReduce').style.display='block';\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\telse{\r\n");
      out.write("\t\tdocument.getElementById('topBanner').style.display='block';\r\n");
      out.write("\t\tdocument.getElementById('buttonReduce').style.display='none';\t\t\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body alink=\"#ffffff\"  vlink=\"#ffffff\" link=\"#ffffff\">\r\n");
      out.write("\r\n");
      out.write("<div id=\"topBanner\" align=\"center\" style=\"display:block;\">\r\n");
      out.write("<img src=\"");
      out.print(request.getContextPath());
      out.write("/images/top.jpg\" ondblclick=\"javascript: maximizeMinimize();\" title=\"Double-cliquez pour réduire\"/>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"buttonReduce\" style=\"display:none; position:relative; float:right;\"><img src=\"");
      out.print(request.getContextPath());
      out.write("/images/reduce.jpg\" onclick=\"javascript: maximizeMinimize();\" title=\"cliquez pour agrandir\"/></div>");
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');

  manisaVatoMisaraka_formManisaVato = (FormManisaVato)request.getSession().getAttribute(FormManisaVato.sfFORM_ID);

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- debut corps -->\r\n");
      out.write("<table width=\"1000px\" align=\"center\" border=\"0\">\r\n");
      out.write("  <tr>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t");
      out.write("\t\t<ul id=\"tabnav\">\r\n");
      out.write("\t\t\t");

			if (Utils.getLoggedUserName() != null){
      out.write("\r\n");
      out.write("\t\t\t <li id=\"connect\">Miarahaba an'i <b>");
      out.print(Utils.getLoggedUserName());
      out.write("</b></li>\r\n");
      out.write("\t\t\t");

			}
			
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t");
 if (ConstantUtils.sfAccessMpivavaka.equals(session.getAttribute(ConstantUtils.sfSelectedTab))) {
      out.write("\r\n");
      out.write("\t\t\t<li class=\"active\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/secure/index.htm\">Mpivavaka</a></li>\r\n");
      out.write("\t\t\t<li><a class=\"onglet\" href=\"");
      out.print(request.getContextPath());
      out.write("/secure/index.htm?sampana\">SSAAF</a></li>\r\n");
      out.write("\t\t\t<li><a class=\"onglet\" href=\"");
      out.print(request.getContextPath());
      out.write("/secure/index.htm?diakona\">Diakona</a></li>\r\n");
      out.write("\t\t\t<li><a class=\"onglet\" href=\"");
      out.print(request.getContextPath());
      out.write("/secure/index.htm?fifidianana\">Fifidianana</a></li>\r\n");
      out.write("\t\t\t<li><a class=\"onglet\" href=\"");
      out.print(request.getContextPath());
      out.write("/secure/index.htm?administration\">Administration</a></li>\r\n");
      out.write("\t\t\t");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t");
 if (ConstantUtils.sfAccessSampana.equals(session.getAttribute(ConstantUtils.sfSelectedTab))) {
      out.write("\r\n");
      out.write("\t\t\t<li><a class=\"onglet\" href=\"");
      out.print(request.getContextPath());
      out.write("/secure/index.htm\">Mpivavaka</a></li>\r\n");
      out.write("\t\t\t<li class=\"active\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/secure/index.htm?sampana\">SSAAF</a></li>\r\n");
      out.write("\t\t\t<li><a class=\"onglet\" href=\"");
      out.print(request.getContextPath());
      out.write("/secure/index.htm?diakona\">Diakona</a></li>\r\n");
      out.write("\t\t\t<li><a class=\"onglet\" href=\"");
      out.print(request.getContextPath());
      out.write("/secure/index.htm?fifidianana\">Fifidianana</a></li>\r\n");
      out.write("\t\t\t<li><a class=\"onglet\" href=\"");
      out.print(request.getContextPath());
      out.write("/secure/index.htm?administration\">Administration</a></li>\r\n");
      out.write("\t\t\t");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t");
 if (ConstantUtils.sfAccessDiakona.equals(session.getAttribute(ConstantUtils.sfSelectedTab))) {
      out.write("\r\n");
      out.write("\t\t\t<li><a class=\"onglet\" href=\"");
      out.print(request.getContextPath());
      out.write("/secure/index.htm\">Mpivavaka</a></li>\r\n");
      out.write("\t\t\t<li><a class=\"onglet\" href=\"");
      out.print(request.getContextPath());
      out.write("/secure/index.htm?sampana\">SSAAF</a></li>\r\n");
      out.write("\t\t\t<li class=\"active\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/secure/index.htm?diakona\">Diakona</a></li>\r\n");
      out.write("\t\t\t<li><a class=\"onglet\" href=\"");
      out.print(request.getContextPath());
      out.write("/secure/index.htm?fifidianana\">Fifidianana</a></li>\r\n");
      out.write("\t\t\t<li><a class=\"onglet\" href=\"");
      out.print(request.getContextPath());
      out.write("/secure/index.htm?administration\">Administration</a></li>\r\n");
      out.write("\t\t\t");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t");
 if (ConstantUtils.sfAccessFifidianana.equals(session.getAttribute(ConstantUtils.sfSelectedTab))) {
      out.write("\r\n");
      out.write("\t\t\t<li><a class=\"onglet\" href=\"");
      out.print(request.getContextPath());
      out.write("/secure/index.htm\">Mpivavaka</a></li>\r\n");
      out.write("\t\t\t<li><a class=\"onglet\" href=\"");
      out.print(request.getContextPath());
      out.write("/secure/index.htm?sampana\">SSAAF</a></li>\r\n");
      out.write("\t\t\t<li><a class=\"onglet\" href=\"");
      out.print(request.getContextPath());
      out.write("/secure/index.htm?diakona\">Diakona</a></li>\r\n");
      out.write("\t\t\t<li class=\"active\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/secure/index.htm?fifidianana\">Fifidianana</a></li>\r\n");
      out.write("\t\t\t<li><a class=\"onglet\" href=\"");
      out.print(request.getContextPath());
      out.write("/secure/index.htm?administration\">Administration</a></li>\r\n");
      out.write("\t\t\t");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t");
 if (ConstantUtils.sfAccessAdmin.equals(session.getAttribute(ConstantUtils.sfSelectedTab))) {
      out.write("\r\n");
      out.write("\t\t\t<li><a class=\"onglet\" href=\"");
      out.print(request.getContextPath());
      out.write("/secure/index.htm\">Mpivavaka</a></li>\r\n");
      out.write("\t\t\t<li><a class=\"onglet\" href=\"");
      out.print(request.getContextPath());
      out.write("/secure/index.htm?sampana\">SSAAF</a></li>\r\n");
      out.write("\t\t\t<li><a class=\"onglet\" href=\"");
      out.print(request.getContextPath());
      out.write("/secure/index.htm?diakona\">Diakona</a></li>\r\n");
      out.write("\t\t\t<li><a class=\"onglet\" href=\"");
      out.print(request.getContextPath());
      out.write("/secure/index.htm?fifidianana\">Fifidianana</a></li>\r\n");
      out.write("\t\t\t<li class=\"active\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/secure/index.htm?administration\">Administration</a></li>\r\n");
      out.write("\t\t\t");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t");
 if (org.acegisecurity.context.SecurityContextHolder.getContext().getAuthentication() != null) {
      out.write("\r\n");
      out.write("\t\t\t<li id=\"disconnect\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/logout.jsp\">Mivoaka</a></li>\r\n");
      out.write("\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  \r\n");
      out.write("  ");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');

	fifidianana = (Fifidianana)request.getAttribute(ConstantUtils.sfREQUEST_FIFIDIANANA);	//pour showFifidianana.jsp
	formListMirotsakaFidiana = (FormListMirotsakaFidiana)request.getAttribute(FormListMirotsakaFidiana.sfFORM_ID);
	now = new Date();

      out.write("\r\n");
      out.write("\r\n");
if (fifidianana != null){ 
      out.write("\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>\r\n");
      out.write("\t  <table width=\"100%\"  align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" bgColor=\"#0099FF\">\r\n");
      out.write("\t    <tr>\r\n");
      out.write("\t      <td><b>");
      out.print(fifidianana.getLabel());
      out.write(" </b></td>\r\n");
      out.write("\t      <td>eto amin'ny <b>");
      out.print(fifidianana.getFitandremana().getLabel());
      out.write("</b></td>\r\n");
      out.write("\t      <td>Taom-panompoana <b>");
      out.print(fifidianana.getTaomPanompoana().toString());
      out.write("</b></td>\r\n");
      out.write("\t\t  <td><input type=\"button\" class=\"button\" name=\"Mivoaka\" value=\"Mivoaka ");
      out.print(fifidianana.getLabel() == null || "".equals(fifidianana.getLabel().trim()) ? fifidianana.getKarazamPifidianana().getLabel() : fifidianana.getLabel());
      out.write("\" onclick=\"javascript: document.location.href='index.htm?fifidianana&");
      out.print(ConstantUtils.sfParameterMivoakaFifidianana);
      out.write("';\"/></td>\r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t    <tr>\r\n");
      out.write("\t      <td>Firotsahana ho fidiana :</td>\r\n");
      out.write("\t      <td>manomboka ny <b>");
      out.print(Utils.sfDateFormatJJMMYYYY.format(fifidianana.getDatyManombokaFirotsahana()));
      out.write("</b></td>\r\n");
      out.write("\t      <td>mifarana ny <b>");
      out.print(Utils.sfDateFormatJJMMYYYY.format(fifidianana.getDatyMamaranaFirotsahana()));
      out.write("</b></td>\r\n");
      out.write("\t\t  <td>\r\n");
      out.write("\t\t  ");
  
		  if (formListMirotsakaFidiana != null && !formListMirotsakaFidiana.isAllMirotsakaFidiana()) {
		    if (formListMirotsakaFidiana.getEkenaFirotsahana() != null && formListMirotsakaFidiana.getEkenaFirotsahana().booleanValue()){
		      if (fifidianana.getDatyMamaranaFirotsahana().getTime() < now.getTime() && !formListMirotsakaFidiana.isHaveAllMirotsakaFidianaEkenaLaharana()){
		  
      out.write("\r\n");
      out.write("                <input type=\"button\" name=\"Omeo Laharana\" value=\"Omeo Laharana\" onclick=\"javascript:showMessageAttribution();\"/>\r\n");
      out.write("\t\t  ");

		      }
		    }
		  }
		  
      out.write("\r\n");
      out.write("\t\t  </td>\r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t  </table>\r\n");
      out.write("\t</td>\r\n");
      out.write("  </tr>\r\n");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--- message éventuel depuis attribution de numéro -------->\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("function showMessageAttribution (){\r\n");
      out.write("\tvar options = {\r\n");
      out.write("\t\tajaxContent:'attributeLaharanaMirotsakaFidiana.htm',\r\n");
      out.write("\t\tmodal:true,\r\n");
      out.write("\t\tbutton:\"OK\"\r\n");
      out.write("\t}\r\n");
      out.write("\tmsg.open('<img src=\"");
      out.print(request.getContextPath());
      out.write("/images/indicator.gif\" /> Miandry kely ...', options);\r\n");
      out.write("\treturn false;\r\n");
      out.write("};\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");

  if (request.getAttribute(ConstantUtils.sfMessageAttributionNumero) != null){

      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("function showMessage (){\r\n");
      out.write("\tvar options = {\r\n");
      out.write("\t\t\"title\": \"Valin'ny fangatahana\",\r\n");
      out.write("\t\t\"button\": \"OK\",\r\n");
      out.write("\t\t\"className\":\"success\",\r\n");
      out.write("\t\t");

		if (request.getAttribute(ConstantUtils.sfEditedFromSearch) != null && ((Boolean)request.getAttribute(ConstantUtils.sfEditedFromSearch)).booleanValue()){
		
      out.write("\r\n");
      out.write("\t\t\"modal\":\"true\",\r\n");
      out.write("\t\t\"onClose\": function(){\r\n");
      out.write("\t\t\tdocument.location='listMirotsakaFidiana.htm?reload&from=");
      out.print(request.getSession().getAttribute(ConstantUtils.sfSelectedTab));
      out.write("'\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t");

		}
		else{
		
      out.write("\r\n");
      out.write("\t\t\"modal\":\"true\"\r\n");
      out.write("\t\t");

		}
		
      out.write("\r\n");
      out.write("\t};\r\n");
      out.write("\t    \r\n");
      out.write("\tmsg.open(\"");
      out.print(request.getAttribute(ConstantUtils.sfMessageContent));
      out.write("\", options);\r\n");
      out.write("\treturn false;\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("showMessage();\r\n");
      out.write("</script>\r\n");

  }

      out.write('\r');
      out.write('\n');
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  <tr>\r\n");
      out.write("    <td colspan=\"2\">\r\n");
      out.write("\t  <div class=\"title1\">Fanisam-bato ");
      out.print( manisaVatoMisaraka_formManisaVato.getLehilahy().booleanValue() ? " lehilahy " : " vehivavy " );
      out.write(": </div><br>\r\n");
      out.write("\t</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  \r\n");
      out.write("  <tr>\r\n");
      out.write("    <td colspan=\"2\">\r\n");
      out.write("    <table width=\"100%\" border=\"1\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td width=\"20%\">\r\n");
      out.write("          <!-- Affichage des résultats par provisoire par Ajax pour les Diakona vehivavy -->\r\n");
      out.write("          <div id=\"searchResultManisaFifidianana\" style=\"vertical-align: top; \" >\r\n");
      out.write("          </div>\r\n");
      out.write("        </td>\r\n");
      out.write("\r\n");
      out.write("        <td width=\"80%\" bgcolor=\"#00CCFF\">\r\n");
      out.write("          <div id=\"manisaVatoMisaraka_formManisaVato\">\r\n");
      out.write("          ");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');

  formManisaVato = (FormManisaVato)request.getSession().getAttribute(FormManisaVato.sfFORM_ID);

      out.write("\r\n");
      out.write("\t      <table width=\"100%\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("            <tr bgcolor=\"#000099\" style=\"color:#FFFFFF\">\r\n");
      out.write("              <td colspan=\"2\">Isan'ny vato </td>\r\n");
      out.write("              <td>rehetra :</td>\r\n");
      out.write("              <td> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formManisaVato.isaVatoVoaisa}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" </td>\r\n");
      out.write("              <td>manankery :</td>\r\n");
      out.write("              <td> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formManisaVato.isaVatoManankery}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" </td>\r\n");
      out.write("              <td>maty :</td>\r\n");
      out.write("              <td> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formManisaVato.isaVatoMaty}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" </td>\r\n");
      out.write("              <td>fotsy :</td>\r\n");
      out.write("              <td> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formManisaVato.isaVatoFotsy}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td>Vato fotsy </td>\r\n");
      out.write("              <td colspan=\"4\" align=\"left\"><input name=\"vatoFotsy\" type=\"checkbox\" /></td>\r\n");
      out.write("              <td colspan=\"3\">&nbsp;</td>\r\n");
      out.write("              <td>Vato maty </td>\r\n");
      out.write("              <td align=\"right\"><input name=\"vatoMaty\"  type=\"checkbox\" /></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("      \r\n");
      out.write("            <tr>\r\n");
      out.write("              <td colspan=\"10\" bgcolor=\"#000099\">&nbsp;</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("\t      ");

	        int col = 0;
	        int row = 0;
	        for (Map<String,Object> mirotsakaFidiana : formManisaVato.getMirotsakaFidianas()){
	          if (col % 10 == 0){
	            out.println("<tr>");
	            row ++;
	          }
	      
	          if (row % 2 == 0)
	            out.println("<td width=\"10%\" bgcolor=\"#66CCFF\">"+mirotsakaFidiana.get("laharanaMpirotsaka")+" <input type=\"checkbox\" name=\"mirotsaka"+mirotsakaFidiana.get("laharanaMpirotsaka")+"\"></td>");
	          else
	            out.println("<td bgcolor=\"#C0C0C0\">"+mirotsakaFidiana.get("laharanaMpirotsaka")+" <input type=\"checkbox\" name=\"mirotsaka"+mirotsakaFidiana.get("laharanaMpirotsaka")+"\"></td>");
         
	          if ((col+1) % 10 == 0){
	            out.println("</tr>");
	          }
	      
	          col++;
	        }
	        
	        //Compléter les colonnes vides sans candidats et fermer le tag </tr>
	        if (col % 10 > 0){
	        	
	        	for (int i = col % 10 ; i < 10; i++){
	  	          if (row % 2 == 0)
	  	            out.println("<td bgcolor=\"#66CCFF\">&nbsp;</td>");
	  	          else
	  	            out.println("<td bgcolor=\"#C0C0C0\">&nbsp;</td>");
	        	}
	        	out.println("</tr>");
	        }	        
	      
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td colspan=\"10\" bgcolor=\"#000099\">&nbsp;</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("\r\n");
      out.write("           <tr>\r\n");
      out.write("              <td align=\"left\" colspan=\"5\"><input name=\"Miverina\" class=\"button\" id=\"boutonMiverina\" value=\"Miverina\" type=\"button\" onclick=\"javascript: document.location.href='selectFifidianana.htm?id=");
      out.print(Utils.getFifidiananaFromSession(request).getId());
      out.write("'\" title=\"Miverina eo amin'ny fifidianana.\"/></td>\r\n");
      out.write("              <td align=\"center\" colspan=\"4\"><input name=\"Fafao\" class=\"button\" id=\"boutonFafao\" value=\"Fafao\" type=\"button\" title=\"Mamerina ny fanisana ny vato teo.\" onclick=\"javascript: initFormManisaVato();\" /></td>\r\n");
      out.write("              <td align=\"right\" colspan=\"1\"><input name=\"Valider\" class=\"button\" id=\"boutonValider\" value=\"Alefa\" type=\"button\" title=\"Isaina ireto vato ireto.\" onclick=\"javascript: submitVato();\" /></td>\r\n");
      out.write("            </tr>      \r\n");
      out.write("          </table>\r\n");
      out.write("             \r\n");
      out.write("<!-- message dans boite de dialogue de type div positionné dans les controller -->\r\n");

  if (request.getAttribute(ConstantUtils.sfMessageExist) != null && ((Boolean)request.getAttribute(ConstantUtils.sfMessageExist)).booleanValue()){

      out.write("\r\n");
      out.write("    <input type=\"hidden\" id=\"message\" value=\"");
      out.print(request.getAttribute(ConstantUtils.sfMessageContent));
      out.write("\" />\r\n");

  }

      out.write("\r\n");
      out.write("             ");
      out.write("\r\n");
      out.write("          </div>\r\n");
      out.write("        </td>\r\n");
      out.write("\r\n");
      out.write("      </tr>      \r\n");
      out.write("    </table>\r\n");
      out.write("\t  \r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  \r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("  //ré-initialiser à blanc les cases à cocher du formulaire\r\n");
      out.write("\tfunction initFormManisaVato(){\r\n");
      out.write("\t\tvar inputs = document.getElementsByTagName(\"input\");\r\n");
      out.write("\t\tfor (var i = 1 ; i < inputs.length; i++){\r\n");
      out.write("\t\t\tvar curInput = inputs[i];\r\n");
      out.write("\t\t\tif (curInput.type=='checkbox'){\r\n");
      out.write("\t\t\t\tcurInput.checked = false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("  \tfunction getParameters(){\r\n");
      out.write("  \t  \tvar params = 'lehilahy=");
      out.print(manisaVatoMisaraka_formManisaVato.getLehilahy());
      out.write("';\r\n");
      out.write("\t\tvar inputs = document.getElementsByTagName(\"input\");\r\n");
      out.write("\t\tfor (var i = 1 ; i < inputs.length; i++){\r\n");
      out.write("\t\t\tvar curInput = inputs[i];\r\n");
      out.write("\t\t\tif (curInput.type=='checkbox' && curInput.checked){\r\n");
      out.write("\t\t\t\tparams = params + '&';\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tparams = params+curInput.name+'=on'\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn params;\r\n");
      out.write("  \t}\r\n");
      out.write("\r\n");
      out.write("  \tfunction showMessage(){\r\n");
      out.write("  \t  \tvar message = document.getElementById('message').value;\r\n");
      out.write("\t\tvar options = {\r\n");
      out.write("\t\t\tmodal:true,\r\n");
      out.write("\t\t\tbutton:'ok'\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\tmsg.open(message, options);\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("   \t}\r\n");
      out.write("  \t\r\n");
      out.write("  \tfunction submitVato(){\t\t\t\t\r\n");
      out.write("\t\tvar req = new AjReq();\r\n");
      out.write("\t\tvar opts = {\r\n");
      out.write("\t\t\tmethod : 'POST',\r\n");
      out.write("\t\t\tparams : getParameters(),\r\n");
      out.write("\t\t\tupdate : document.getElementById('manisaVatoMisaraka_formManisaVato'),\r\n");
      out.write("\t\t\tabortAfter : 15000,\r\n");
      out.write("\t\t\tonSuccess : function(){ showMessage();},\r\n");
      out.write("\t\t\tonAbort : function(){ showMessage('Tsy voaisa ny vato nampidirina teo');}\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\t\r\n");
      out.write("\t\treq.send('manisaVato.htm', opts);\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tvar reqAjaxVokatra = new AjReq();\r\n");
      out.write("\tvar optVokatras = {\r\n");
      out.write("\t\tmethod : 'POST',\r\n");
      out.write("\t\tparams : 'lahy=");
      out.print(manisaVatoMisaraka_formManisaVato.getLehilahy().booleanValue());
      out.write("',\r\n");
      out.write("\t\tabortAfter : 15000,\r\n");
      out.write("\t\tupdate : document.getElementById('searchResultManisaFifidianana'),\r\n");
      out.write("\t\tonSuccess : function(){window.setTimeout(getVokatraVonjyMaika, 30000);}\r\n");
      out.write("\t};\r\n");
      out.write(" \t\r\n");
      out.write("  \tfunction getVokatraVonjyMaika(){\r\n");
      out.write("  \t\treqAjaxVokatra.send('vokatraTapatapany.htm', optVokatras);\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("  \tgetVokatraVonjyMaika();\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<!-- fin corps -->\r\n");
      out.write("\r\n");
      out.write("<table valign=\"TOP\" align=\"center\" bgcolor=\"#0099FF\" border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"1000\">\r\n");
      out.write("  <tbody><tr> \r\n");
      out.write("    <td class=\"footermenu\" align=\"center\" bgcolor=\"#0099FF\"><font color=\"#ffffff\" size=\"2\" face=\"Trebuchet MS\"><span class=\"duztext\">FJKM - Ankadifotsy<strong>-</strong>Fitantanana ny vahoakan'Andriamanitra <br>\r\n");
      out.write("</span></font></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td class=\"footermenu\" align=\"center\"> <font color=\"#e8e7e7\" size=\"-2\" face=\"Geneva, Arial, Helvetica, sans-serif\">© \r\n");
      out.write("      2011 FJKM Ankadifotsy</font></strong></td>\r\n");
      out.write("  </tr>  \r\n");
      out.write("</tbody>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("</td></tr>\r\n");
      out.write("</tbody>\r\n");
      out.write("</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write('\r');
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
