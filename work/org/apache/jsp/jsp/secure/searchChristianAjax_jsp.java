package org.apache.jsp.jsp.secure;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.util.List;
import mg.fjkm.ankadifotsy.bo.Fitandremana;
import mg.fjkm.ankadifotsy.bo.Mpivavaka;
import mg.fjkm.ankadifotsy.form.FormSearchChristian;
import mg.fjkm.ankadifotsy.util.Utils;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.bo.SaveableEntity;
import java.util.Date;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.util.Utils;
import mg.fjkm.ankadifotsy.bo.Fifidianana;
import mg.fjkm.ankadifotsy.form.FormListMirotsakaFidiana;

public final class searchChristianAjax_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


	FormSearchChristian formSearchChristian;


	FormListMirotsakaFidiana formListMirotsakaFidiana;
	Fifidianana fifidianana;
	Date now;

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(10);
    _jspx_dependants.add("/jsp/include.jsp");
    _jspx_dependants.add("/WEB-INF/tlds/c.tld");
    _jspx_dependants.add("/WEB-INF/tlds/fmt.tld");
    _jspx_dependants.add("/WEB-INF/tlds/ajaxtags.tld");
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/jsp/ajaxInclude.jsp");
    _jspx_dependants.add("/onglet.jsp");
    _jspx_dependants.add("/jsp/secure/showFifidianana.jsp");
    _jspx_dependants.add("/messageAttrLaharana.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_spring_bind_path;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_spring_bind_path = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.release();
    _jspx_tagPool_spring_bind_path.release();
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
      out.write("<script language=\"javascript\">\t\r\n");
      out.write("\tfunction submitFormFromLink(pageNo){\r\n");
      out.write("\t\tdocument.getElementById('pageNo').value = pageNo;\r\n");
      out.write("\t\tdocument.getElementById('boutonValider').value = 'Tadiavo';\r\n");
      out.write("\t\tdocument.getElementById('formSearchChristian').submit();\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction invalidateField(field){\r\n");
      out.write("\t\tdocument.getElementById(field+'Label').value ='';\r\n");
      out.write("\t\tdocument.getElementById(field).value ='';\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction updateValidateButton(){\r\n");
      out.write("\t\tvar certifieCheckBox = document.getElementById('certifieCheckBox');\r\n");
      out.write("\t\tdocument.getElementById('boutonValider').disabled = ! (certifieCheckBox.checked);\t\t\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<!-- debut corps -->\r\n");
      out.write('\r');
      out.write('\n');

	formSearchChristian = (FormSearchChristian)request.getAttribute(FormSearchChristian.sfFORM_ID);

      out.write("\r\n");
      out.write("\r\n");
      out.write("<table align=\"center\" border=\"0\" >\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>\r\n");
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
      out.write("\r\n");
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
      out.write("\r\n");
      out.write("  \r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>Fitadiavana Mpivavaka : </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  \r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>\r\n");
      out.write("\t<form id=\"formSearchChristian\" name=\"formSearchChristian\" method=\"post\" action=\"searchChristian.htm\">\r\n");
      out.write("\t<table width=\"100%\" valign=\"TOP\" align=\"center\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t  <tr>\r\n");
      out.write("\t    <td colspan=\"2\">\r\n");
      out.write("\t      <table width=\"100%\"  border=\"0\">\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t          <td colspan=\"2\">\r\n");
      out.write("\t            <table width=\"90%\">\r\n");
      out.write("\t              <tr>\r\n");
      out.write("\t                <td width=\"50%\" align=\"left\">Fitandremana *</td>\r\n");
      out.write("\t                <td align=\"left\">\r\n");
      out.write("          \t        <!-- la saisie à autocompléter -->\r\n");
      out.write("\t\t              <input class=\"inputleft\" id=\"fitandremanaLabel\" name=\"fitandremanaLabel\" type=\"text\" size=\"22\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formSearchChristian.fitandremana.label}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />\t\r\n");
      out.write("\t\t            <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->\r\n");
      out.write("\t\t              <input type=\"hidden\" id=\"fitandremanaID\" name=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formSearchChristian.fitandremana.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />\t\r\n");
      out.write("\t\t              <span id=\"indicatorFitandremanaID\" style=\"display:none;\"><img src=\"");
      out.print(request.getContextPath());
      out.write("/images/indicator.gif\" /></span>\r\n");
      out.write("\t\t              <font color=\"red\" size=\"1.2\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</font>\r\n");
      out.write("              \r\n");
      out.write("                    ");
      if (_jspx_meth_ajax_autocomplete_0(_jspx_page_context))
        return;
      out.write("                  \r\n");
      out.write("\t                  <font color=\"red\" size=\"1.2\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</font>\r\n");
      out.write("\t                </td>\r\n");
      out.write("\t              </tr>\r\n");
      out.write("\t          \r\n");
      out.write("\t              <tr>\r\n");
      out.write("\t\t            <td title=\"Laharana ho an'ny mpandray\">Laharana </td>\r\n");
      out.write("\t\t            <td align=\"center\">\r\n");
      out.write("\t\t      \t      <input id=\"laharanaId\" name=\"laharana\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formSearchChristian.laharana}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"text\" size=\"22\" />\r\n");
      out.write("\t\t      \t      <font color=\"red\" size=\"1.2\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</font>\r\n");
      out.write("\t\t            </td>\r\n");
      out.write("\t              </tr>\r\n");
      out.write("\t            </table>\r\n");
      out.write("\t          </td>\r\n");
      out.write("\t          <td colspan=\"2\">\r\n");
      out.write("\t            <table width=\"100%\">\r\n");
      out.write("\t              <tr>\r\n");
      out.write("\t                <td width=\"30%\">Batisa</td>\r\n");
      out.write("\t                <td colspan=\"2\">\r\n");
      out.write("\t\t              <table valign=\"TOP\">\r\n");
      out.write("\t\t                <tr>\r\n");
      out.write("\t\t\t\t\t\t");

						  if (formSearchChristian.getBatisa() == 1){ 
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t              <td><input class=\"inputleft\" name=\"batisa\" type=\"radio\" value=\"1\" checked />Eny</td>\r\n");
      out.write("\t\t\t              <td><input class=\"inputleft\" name=\"batisa\" type=\"radio\" value=\"0\" />Tsia</td>\r\n");
      out.write("\t\t\t              <td><input class=\"inputleft\" name=\"batisa\" type=\"radio\" value=\"-1\" />Rehetra</td>\r\n");
      out.write("\t\t\t\t\t\t");

						} 
						else if (formSearchChristian.getBatisa() == 0) { 
      out.write("\r\n");
      out.write("\t\t\t              <td><input class=\"inputleft\" name=\"batisa\" type=\"radio\" value=\"1\" />Eny</td>\r\n");
      out.write("\t\t\t              <td><input class=\"inputleft\" name=\"batisa\" type=\"radio\" value=\"0\" checked />Tsia</td>\r\n");
      out.write("\t\t\t              <td><input class=\"inputleft\" name=\"batisa\" type=\"radio\" value=\"-1\" />Rehetra</td>\r\n");
      out.write("\t\t\t\t\t\t");

						}
						else { 
      out.write("\r\n");
      out.write("\t\t\t              <td><input class=\"inputleft\" name=\"batisa\" type=\"radio\" value=\"1\" />Eny</td>\r\n");
      out.write("\t\t\t              <td><input class=\"inputleft\" name=\"batisa\" type=\"radio\" value=\"0\" />Tsia</td>\r\n");
      out.write("\t\t\t              <td><input class=\"inputleft\" name=\"batisa\" type=\"radio\" value=\"-1\" checked />Rehetra</td>\r\n");
      out.write("\t\t\t\t\t\t");

						}
						
      out.write("\r\n");
      out.write("\t\t                </tr>\r\n");
      out.write("\t\t              </table>\r\n");
      out.write("\t\t\t\t    </td>\r\n");
      out.write("\t              </tr>\r\n");
      out.write("\t              <tr>\r\n");
      out.write("\t                <td>Mpandray</td>\r\n");
      out.write("\t                <td colspan=\"2\">\r\n");
      out.write("\t\t              <table valign=\"TOP\">\r\n");
      out.write("\t\t                <tr>\r\n");
      out.write("\t\t\t\t\t\t");

						  if (formSearchChristian.getMpandray() == 1){ 
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t              <td><input class=\"inputleft\" name=\"mpandray\" type=\"radio\" value=\"1\" checked />Eny</td>\r\n");
      out.write("\t\t\t              <td><input class=\"inputleft\" name=\"mpandray\" type=\"radio\" value=\"0\" />Tsia</td>\r\n");
      out.write("\t\t\t              <td><input class=\"inputleft\" name=\"mpandray\" type=\"radio\" value=\"-1\" />Rehetra</td>\r\n");
      out.write("\t\t\t\t\t\t");

						} 
						else if (formSearchChristian.getMpandray() == 0) { 
      out.write("\r\n");
      out.write("\t\t\t              <td><input class=\"inputleft\" name=\"mpandray\" type=\"radio\" value=\"1\" />Eny</td>\r\n");
      out.write("\t\t\t              <td><input class=\"inputleft\" name=\"mpandray\" type=\"radio\" value=\"0\" checked />Tsia</td>\r\n");
      out.write("\t\t\t              <td><input class=\"inputleft\" name=\"mpandray\" type=\"radio\" value=\"false\" />Rehetra</td>1\r\n");
      out.write("\t\t\t\t\t\t");

						}
						else { 
      out.write("\r\n");
      out.write("\t\t\t              <td><input class=\"inputleft\" name=\"mpandray\" type=\"radio\" value=\"1\" />Eny</td>\r\n");
      out.write("\t\t\t              <td><input class=\"inputleft\" name=\"mpandray\" type=\"radio\" value=\"0\" />Tsia</td>\r\n");
      out.write("\t\t\t              <td><input class=\"inputleft\" name=\"mpandray\" type=\"radio\" value=\"-1\" checked />Rehetra</td>\r\n");
      out.write("\t\t\t\t\t\t");

						}
						
      out.write("\r\n");
      out.write("\t\t                </tr>\r\n");
      out.write("\t\t              </table>\r\n");
      out.write("\t\t\t\t    </td>\r\n");
      out.write("\t              </tr>\r\n");
      out.write("\t            </table>\r\n");
      out.write("\t\t      </td>\r\n");
      out.write("\r\n");
      out.write("\t          <td colspan=\"2\">\r\n");
      out.write("                <table>\r\n");
      out.write("                  <tr>\r\n");
      out.write("                    <td colspan=\"2\">\r\n");
      out.write("                      <table width=\"100%\" >\r\n");
      out.write("                        <tr>\r\n");
      out.write("\t\t\t\t\t\t");

						  if (formSearchChristian.getLahy() == 1){ 
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t              <td width=\"33%\"><input name=\"lahy\" type=\"radio\" value=\"1\" checked />Lahy</td>\r\n");
      out.write("\t\t\t              <td width=\"33%\"><input name=\"lahy\" type=\"radio\" value=\"0\" />Vavy</td>\r\n");
      out.write("\t\t\t              <td width=\"33%\"><input name=\"lahy\" type=\"radio\" value=\"-1\" />Rehetra</td>\r\n");
      out.write("\t\t\t\t\t\t");

						} 
						else if (formSearchChristian.getLahy() == 0) { 
      out.write("\r\n");
      out.write("\t\t\t              <td><input name=\"lahy\" type=\"radio\" value=\"1\" />Lahy</td>\r\n");
      out.write("\t\t\t              <td><input name=\"lahy\" type=\"radio\" value=\"0\" checked />Vavy</td>\r\n");
      out.write("\t\t\t              <td><input name=\"lahy\" type=\"radio\" value=\"-1\" />Rehetra</td>\r\n");
      out.write("\t\t\t\t\t\t");

						}
						else { 
      out.write("\r\n");
      out.write("\t\t\t              <td><input name=\"lahy\" type=\"radio\" value=\"1\" />Lahy</td>\r\n");
      out.write("\t\t\t              <td><input name=\"lahy\" type=\"radio\" value=\"0\"  />Vavy</td>\r\n");
      out.write("\t\t\t              <td><input name=\"lahy\" type=\"radio\" value=\"-1\" checked />Rehetra</td>\r\n");
      out.write("\t\t\t\t\t\t");

						}
						
      out.write("\r\n");
      out.write("\t                    </tr>\r\n");
      out.write("\t                  </table>\r\n");
      out.write("\t                </td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                  <tr>\r\n");
      out.write("\t\t            <td width=\"27%\">Talenta</td>\r\n");
      out.write("\t\t            <td>\r\n");
      out.write("\t\t              <input type=\"text\" size=\"22\" id=\"talentaId\" name=\"talenta\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formSearchChristian.talenta}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"  />\r\n");
      out.write("\t\t              <font color=\"red\" size=\"1.2\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</font>\r\n");
      out.write("\t\t            </td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                </table>\r\n");
      out.write("\t\t      </td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("       \r\n");
      out.write("            <tr>\r\n");
      out.write("              <td width=\"9%\">Anarana *</td>\r\n");
      out.write("              <td align=\"left\" width=\"24%\">\r\n");
      out.write("          \t    <input name=\"anarana\" id=\"anaranaId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formSearchChristian.anarana}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"text\" size=\"22\"  />\r\n");
      out.write("          \t    <font color=\"red\" size=\"1.2\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</font>\r\n");
      out.write("              </td>\r\n");
      out.write("              <td width=\"10%\">Fanampiny </td>\r\n");
      out.write("              <td width=\"23%\">\r\n");
      out.write("          \t    <input name=\"fanampiny\" id=\"fanampinyId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formSearchChristian.fanampiny}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"text\" size=\"22\"  />\r\n");
      out.write("          \t    <font color=\"red\" size=\"1.2\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</font>\r\n");
      out.write("              </td>\r\n");
      out.write("          \r\n");
      out.write("              <td colspan=\"2\">\r\n");
      out.write("                <table width=\"100%\">\r\n");
      out.write("                  <tr>\r\n");
      out.write("\t\t            <td width=\"24%\">Asa </td>\r\n");
      out.write("\t\t            <td>\r\n");
      out.write("\t          \t    <!-- la saisie à autocompléter -->\r\n");
      out.write("\t\t\t          <input class=\"inputleft\" id=\"antonAsaLabel\" name=\"antonAsaLabel\" type=\"text\" size=\"22\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formSearchChristian.antonAsa.intitule}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />\t\r\n");
      out.write("\t\t\t        <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->\r\n");
      out.write("\t\t\t          <input type=\"hidden\" id=\"antonAsaID\" name=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formSearchChristian.antonAsa.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />\t\r\n");
      out.write("\t\t\t          <span id=\"indicatorAntonAsaID\" style=\"display:none;\"><img src=\"");
      out.print(request.getContextPath());
      out.write("/images/indicator.gif\" /></span>\r\n");
      out.write("\t\t\t          <font color=\"red\" size=\"1.2\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</font>\r\n");
      out.write("\t              \r\n");
      out.write("\t                  ");
      if (_jspx_meth_ajax_autocomplete_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t            </td>\r\n");
      out.write("\t              </tr>\r\n");
      out.write("\t            </table>\r\n");
      out.write("\t          </td>\t\t  \r\n");
      out.write("            </tr>\r\n");
      out.write("                \r\n");
      out.write("            <tr>\r\n");
      out.write("\t          <td colspan=\"2\" align=\"left\">&nbsp;</td>\r\n");
      out.write("\t          <td>&nbsp;</td>\r\n");
      out.write("\t          <td align=\"right\"><input name=\"Valider\" id=\"boutonValider\" value=\"Tadiavo\" type=\"button\" class=\"button\" onclick=\"javascript:loadResults(0);\"/></td>\r\n");
      out.write("\t\t      <td>&nbsp;</td>          \r\n");
      out.write("              <td>&nbsp;</td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("          </table>\r\n");
      out.write("        </td>\r\n");
      out.write("\t  </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("\r\n");
      out.write("    ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_0 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_0.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_0.setParent(null);
      _jspx_th_spring_bind_0.setPath("formSearchChristian.pageNo");
      int[] _jspx_push_body_count_spring_bind_0 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_0 = _jspx_th_spring_bind_0.doStartTag();
        if (_jspx_eval_spring_bind_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("       <input name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" id=\"pageNo\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" type=\"hidden\" />\r\n");
            out.write("    ");
            int evalDoAfterBody = _jspx_th_spring_bind_0.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_0.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_0);
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("    ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_1 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_1.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_1.setParent(null);
      _jspx_th_spring_bind_1.setPath("formSearchChristian.from");
      int[] _jspx_push_body_count_spring_bind_1 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_1 = _jspx_th_spring_bind_1.doStartTag();
        if (_jspx_eval_spring_bind_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("       <input name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" id=\"from\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" type=\"hidden\" />\r\n");
            out.write("    ");
            int evalDoAfterBody = _jspx_th_spring_bind_1.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_1[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_1.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_1.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_1);
      }
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("    </form>\r\n");
      out.write("\t  \r\n");
      out.write("   </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>\r\n");
      out.write("      <!-- Affichage des résultats par Ajax -->\r\n");
      out.write("      <div id=\"searchResults\">\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("\t\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\t//renvoie la valeur de la radio button sélectionné\r\n");
      out.write("\tfunction getRadioValue(radio){\r\n");
      out.write("\t\tvar val = null;\r\n");
      out.write("\t\tfor (var i=0; i<radio.length;i++) {\r\n");
      out.write("\t\t\tif (radio[i].checked) {\r\n");
      out.write("\t\t\t\tval = radio[i].value;\r\n");
      out.write("\t\t\t\tbreak;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\t\r\n");
      out.write("\t\treturn val;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction loadResultsAjax(pageNo){\t\t\r\n");
      out.write("\t\t//Affichage d'un message occupé\r\n");
      out.write("\t\tvar options = {\r\n");
      out.write("\t\t    button:null\r\n");
      out.write("\t    };\r\n");
      out.write("\t    msg.open('<img src=\"");
      out.print(request.getContextPath());
      out.write("/images/indicator.gif\" /> Mbola mitady ...', options);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar req = new AjReq();\r\n");
      out.write("\t\tvar opts = {\r\n");
      out.write("\t\t\tmethod : 'POST',\r\n");
      out.write("\t\t\tparams : 'fitandremanaId='+document.getElementById('fitandremanaID').value+'&laharana='+document.getElementById('laharanaId').value+'&batisa='+getRadioValue(document.forms[\"formSearchChristian\"].elements[\"batisa\"])+'&mpandray='+getRadioValue(document.forms[\"formSearchChristian\"].elements[\"mpandray\"])+'&lahy='+getRadioValue(document.forms[\"formSearchChristian\"].elements[\"lahy\"])+'&talenta='+document.getElementById('talentaId').value+'&anarana='+document.getElementById('anaranaId').value+'&fanampiny='+document.getElementById('fanampinyId').value+'&antonAsa='+document.getElementById('antonAsaID').value+'&valider=Valider&pageNo='+pageNo+'&from=");
      out.print(formSearchChristian.getFrom() != null ? formSearchChristian.getFrom() : "");
      out.write("',\r\n");
      out.write("\t\t\tupdate : document.getElementById('searchResults'),\r\n");
      out.write("\t\t\tabortAfter : 15000,\r\n");
      out.write("\t\t\tonSuccess : function(){ msg.close(); },\r\n");
      out.write("\t\t\tonAbort : function(){ msg.close(); }\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\t\r\n");
      out.write("\t\treq.send('searchChristianAjax.htm', opts);\r\n");
      out.write("\t};\r\n");
      out.write("\t\r\n");
      out.write("\tfunction loadResults(pageNo){\r\n");
      out.write("\t\tif (fjkmAnkadifotsyIsNavigatorIE()){\r\n");
      out.write("\t\t\tif (fjkmAnkadifotsyVerIE() >= 8){\r\n");
      out.write("\t\t\t\tloadResultsAjax(pageNo);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse{\r\n");
      out.write("\t\t\t\tsubmitFormFromLink(0);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse{\r\n");
      out.write("\t\t\tloadResultsAjax(pageNo);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t};\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");

  //auto-Submit pour afficher les résultats précédents
  if (formSearchChristian.isSubmit()){

      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\tloadResults('");
      out.print(formSearchChristian.getPageNo());
      out.write("');\r\n");
      out.write("</script>\r\n");

  }

      out.write("\r\n");
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

  private boolean _jspx_meth_ajax_autocomplete_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ajax:autocomplete
    org.ajaxtags.tags.AjaxAutocompleteTag _jspx_th_ajax_autocomplete_0 = (org.ajaxtags.tags.AjaxAutocompleteTag) _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.get(org.ajaxtags.tags.AjaxAutocompleteTag.class);
    _jspx_th_ajax_autocomplete_0.setPageContext(_jspx_page_context);
    _jspx_th_ajax_autocomplete_0.setParent(null);
    _jspx_th_ajax_autocomplete_0.setSource("fitandremanaLabel");
    _jspx_th_ajax_autocomplete_0.setTarget("fitandremanaID");
    _jspx_th_ajax_autocomplete_0.setBaseUrl("fitandremanaAutoCompletion.htm");
    _jspx_th_ajax_autocomplete_0.setClassName("autocomplete");
    _jspx_th_ajax_autocomplete_0.setIndicator("indicatorFitandremanaID");
    _jspx_th_ajax_autocomplete_0.setMinimumCharacters("1");
    int _jspx_eval_ajax_autocomplete_0 = _jspx_th_ajax_autocomplete_0.doStartTag();
    if (_jspx_th_ajax_autocomplete_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_0);
      return true;
    }
    _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_0);
    return false;
  }

  private boolean _jspx_meth_ajax_autocomplete_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ajax:autocomplete
    org.ajaxtags.tags.AjaxAutocompleteTag _jspx_th_ajax_autocomplete_1 = (org.ajaxtags.tags.AjaxAutocompleteTag) _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.get(org.ajaxtags.tags.AjaxAutocompleteTag.class);
    _jspx_th_ajax_autocomplete_1.setPageContext(_jspx_page_context);
    _jspx_th_ajax_autocomplete_1.setParent(null);
    _jspx_th_ajax_autocomplete_1.setSource("antonAsaLabel");
    _jspx_th_ajax_autocomplete_1.setTarget("antonAsaID");
    _jspx_th_ajax_autocomplete_1.setBaseUrl("antonAsaAutoCompletion.htm");
    _jspx_th_ajax_autocomplete_1.setClassName("autocomplete");
    _jspx_th_ajax_autocomplete_1.setIndicator("indicatorAntonAsaID");
    _jspx_th_ajax_autocomplete_1.setMinimumCharacters("2");
    int _jspx_eval_ajax_autocomplete_1 = _jspx_th_ajax_autocomplete_1.doStartTag();
    if (_jspx_th_ajax_autocomplete_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_1);
      return true;
    }
    _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_1);
    return false;
  }
}
