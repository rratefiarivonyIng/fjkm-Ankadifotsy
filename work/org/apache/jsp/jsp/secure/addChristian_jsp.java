package org.apache.jsp.jsp.secure;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.bo.Fitandremana;
import mg.fjkm.ankadifotsy.bo.Mpivavaka;
import mg.fjkm.ankadifotsy.form.FormChristian;
import mg.fjkm.ankadifotsy.util.Utils;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.bo.SaveableEntity;
import java.util.Date;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.util.Utils;
import mg.fjkm.ankadifotsy.bo.Fifidianana;
import mg.fjkm.ankadifotsy.form.FormListMirotsakaFidiana;

public final class addChristian_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


	FormChristian formChristian;


	FormListMirotsakaFidiana formListMirotsakaFidiana;
	Fifidianana fifidianana;
	Date now;

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
    _jspx_dependants.add("/jsp/secure/infoCreation.jsp");
    _jspx_dependants.add("/jsp/secure/editTrangaScript.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_spring_bind_path;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_otherwise;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ajax_autocomplete_target_source_parameters_minimumCharacters_indicator_className_baseUrl_nobody;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_spring_bind_path = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_otherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ajax_autocomplete_target_source_parameters_minimumCharacters_indicator_className_baseUrl_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_spring_bind_path.release();
    _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_c_when_test.release();
    _jspx_tagPool_c_otherwise.release();
    _jspx_tagPool_ajax_autocomplete_target_source_parameters_minimumCharacters_indicator_className_baseUrl_nobody.release();
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
      out.write("<script language=\"javascript\">    \r\n");
      out.write("\tfunction invalidateField(field){\r\n");
      out.write("\t\tdocument.getElementById(field+'Label').value ='';\r\n");
      out.write("\t\tdocument.getElementById(field).value ='';\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction updateValidateButton(){\r\n");
      out.write("\t\tvar certifieCheckBox = document.getElementById('certifieCheckBox');\r\n");
      out.write("\t\tdocument.getElementById('boutonValider').disabled = ! (certifieCheckBox.checked);\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction uploadPhoto(){\r\n");
      out.write("\t\tdocument.forms[\"photoUploadForm\"].submit();\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<!-- debut corps -->\r\n");
      out.write('\r');
      out.write('\n');

	formChristian = (FormChristian)request.getAttribute(FormChristian.sfFORM_ID);

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Le Div qui sert à afficher les bulles d'aide -->\r\n");
      out.write("<div id=\"curseur\" class=\"infobulle\"></div>\r\n");
      out.write("    \r\n");
      out.write("<table align=\"center\" border=\"0\">\r\n");
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
      out.write("  \r\n");
      out.write("    \r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>\r\n");
      out.write("\t  <div class=\"title1\">Ampidiro ny mombamomba ny Kristiana : </div><br>\r\n");
      out.write("\t</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  \r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>\r\n");
      out.write("\t<form id=\"formChristian\" name=\"formChristian\" method=\"post\" action=\"editChristian.htm\">\r\n");
      out.write("\t<table width=\"90%\" valign=\"TOP\" align=\"center\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t  <tr>\r\n");
      out.write("\t    <td colspan=\"2\">\r\n");
      out.write("\t      <table width=\"100%\"  border=\"0\">\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t          <td colspan=\"2\" valign=\"top\">\r\n");
      out.write("\t            <table width=\"90%\" border=\"0\">\r\n");
      out.write("\t              <tr>\r\n");
      out.write("\t                <td width=\"50%\" align=\"left\">Fitandremana *</td>\r\n");
      out.write("\t                <td align=\"left\">\r\n");
      out.write("                    ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_0 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_0.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_0.setParent(null);
      _jspx_th_spring_bind_0.setPath("formChristian.fitandremana");
      int[] _jspx_push_body_count_spring_bind_0 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_0 = _jspx_th_spring_bind_0.doStartTag();
        if (_jspx_eval_spring_bind_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("          \t        <!-- la saisie à autocompléter -->\r\n");
            out.write("\t\t              <input class=\"inputleft\" id=\"fitandremanaLabel\" name=\"fitandremanaLabel\" type=\"text\" size=\"22\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formChristian.fitandremana.label}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("\t\t            <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->\r\n");
            out.write("\t\t              <input type=\"hidden\" id=\"fitandremanaID\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formChristian.fitandremana.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("\t\t              <span id=\"indicatorFitandremanaID\" style=\"display:none;\"><img src=\"");
            out.print(request.getContextPath());
            out.write("/images/indicator.gif\" /></span>\r\n");
            out.write("\t\t              <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("              \r\n");
            out.write("                    ");
            if (_jspx_meth_ajax_autocomplete_0(_jspx_th_spring_bind_0, _jspx_page_context, _jspx_push_body_count_spring_bind_0))
              return;
            out.write("                  \r\n");
            out.write("                    ");
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
      out.write("\t                </td>\r\n");
      out.write("\t              </tr>\r\n");
      out.write("\t          \r\n");
      out.write("\t              <tr>\r\n");
      out.write("\t\t\t        ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_1 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_1.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_1.setParent(null);
      _jspx_th_spring_bind_1.setPath("formChristian.laharana");
      int[] _jspx_push_body_count_spring_bind_1 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_1 = _jspx_th_spring_bind_1.doStartTag();
        if (_jspx_eval_spring_bind_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("\t\t            <td title=\"Laharana ho an'ny mpandray\">Laharana </td>\r\n");
            out.write("\t\t            <td align=\"center\">\r\n");
            out.write("\t\t      \t      <input name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" type=\"text\" size=\"18\" />\r\n");
            out.write("\t\t      \t      <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("\t\t            </td>\r\n");
            out.write("\t\t            ");
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
      out.write("\t              </tr>\r\n");
      out.write("\t              \r\n");
      out.write("\t              <tr>\r\n");
      out.write("\t                <td colspan=\"2\">&nbsp;</td>\r\n");
      out.write("\t              </tr>\r\n");
      out.write("\t            </table>\r\n");
      out.write("\t          </td>\r\n");
      out.write("\t          <td colspan=\"2\" valign=\"top\">\r\n");
      out.write("\t            <table width=\"100%\" border=\"0\">\r\n");
      out.write("\t              <tr>\r\n");
      out.write("\t                <td>Niaviana </td>\r\n");
      out.write("\t                <td colspan=\"2\" align=\"left\">\r\n");
      out.write("\t\t\t        ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_2 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_2.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_2.setParent(null);
      _jspx_th_spring_bind_2.setPath("formChristian.fitandremanaNiaviana");
      int[] _jspx_push_body_count_spring_bind_2 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_2 = _jspx_th_spring_bind_2.doStartTag();
        if (_jspx_eval_spring_bind_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("          \t        <!-- la saisie à autocompléter -->\r\n");
            out.write("\t\t              <input class=\"inputleft\" id=\"fitandremanaNiavianaLabel\" name=\"fitandremanaNiavianaLabel\" type=\"text\" size=\"22\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formChristian.fitandremanaNiaviana.label}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("\t\t            <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->\r\n");
            out.write("\t\t              <input type=\"hidden\" id=\"fitandremanaNiavianaID\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formChristian.fitandremanaNiaviana.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("\t\t              <span id=\"indicatorFitandremanaNiavianaID\" style=\"display:none;\"><img src=\"");
            out.print(request.getContextPath());
            out.write("/images/indicator.gif\" /></span>\r\n");
            out.write("\t\t              <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("              \r\n");
            out.write("                    ");
            if (_jspx_meth_ajax_autocomplete_1(_jspx_th_spring_bind_2, _jspx_page_context, _jspx_push_body_count_spring_bind_2))
              return;
            out.write("                  \r\n");
            out.write("                    ");
            int evalDoAfterBody = _jspx_th_spring_bind_2.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_2[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_2.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_2.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_2);
      }
      out.write("\r\n");
      out.write("\t                </td>\r\n");
      out.write("\t              </tr>\r\n");
      out.write("\t              \r\n");
      out.write("\t              <tr>\r\n");
      out.write("\t                <td width=\"40%\">Batisa</td>\r\n");
      out.write("\t                <td>\r\n");
      out.write("\t                  <div id=\"batisaId\">\r\n");
      out.write("\t                ");
 if (formChristian.isVitaBatisa()) {
      out.write("\r\n");
      out.write("\t                  <div onMouseOver=\"showToolTip('Laharana ");
      out.print(formChristian.getBatisa().getLaharana());
      out.write(" <br/>Tamin\\'ny ");
      out.print(Utils.sfDateFormatJJMMYYYY.format(formChristian.getBatisa().getDaty()));
      out.write(" <br/> tao ");
      out.print(formChristian.getBatisa().getFitandremana().getLabel());
      out.write("');\" onMouseOut=\"hideToolTip();\">Eny</div>\r\n");
      out.write("\t                ");
} 
	                   else{
      out.write("\r\n");
      out.write("\t                  Tsia\r\n");
      out.write("\t                ");
}
      out.write(" \r\n");
      out.write("\t                  </div>\r\n");
      out.write("\t\t\t        </td>\r\n");
      out.write("\t\t\t        <td>\r\n");
      out.write("\t\t\t          <a href=\"#\" id=\"ovayBatisa\" onclick=\"javascript:editBatisa();\">Ovay</a>\r\n");
      out.write("\t\t\t\t    </td>\r\n");
      out.write("\t              </tr>\r\n");
      out.write("\t              <tr>\r\n");
      out.write("\t                <td>Mpandray</td>\r\n");
      out.write("\t                <td id=\"mpandrayId\">\r\n");
      out.write("\t                ");
 if (formChristian.isMpandray()) {
      out.write("\r\n");
      out.write("\t                  <div onMouseOver=\"showToolTip('Laharana ");
      out.print(formChristian.getMpandray().getLaharana());
      out.write(" <br/>Tamin\\'ny ");
      out.print(Utils.sfDateFormatJJMMYYYY.format(formChristian.getMpandray().getDaty()));
      out.write(" <br/> tao ");
      out.print(formChristian.getMpandray().getFitandremana().getLabel());
      out.write("');\" onMouseOut=\"hideToolTip();\">Eny</div>\r\n");
      out.write("\t                ");
} 
	                else{
      out.write("\r\n");
      out.write("\t                  Tsia\r\n");
      out.write("\t                ");
}
      out.write(" \r\n");
      out.write("\t                </td>\r\n");
      out.write("\t\t\t        <td>\r\n");
      out.write("\t\t\t          <a href=\"#\" id=\"ovayMpandray\" onclick=\"javascript:editMpandray();\">Ovay</a>\r\n");
      out.write("\t\t\t\t    </td>\r\n");
      out.write("\t              </tr>\r\n");
      out.write("\t            </table>\r\n");
      out.write("\t\t      </td>\r\n");
      out.write("              \r\n");
      out.write("              <td>&nbsp;</td>\r\n");
      out.write("\t          <td align=\"right\">\r\n");
      out.write("                <img src=\"");
      out.print(request.getContextPath());
      out.write('/');
      out.print(formChristian.getPhotoName(request));
      out.write("\" width=\"80\" height=\"90\"/>\r\n");
      out.write("\t          </td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("       \r\n");
      out.write("            <tr>\r\n");
      out.write("\t\t      ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_3 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_3.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_3.setParent(null);
      _jspx_th_spring_bind_3.setPath("formChristian.anarana");
      int[] _jspx_push_body_count_spring_bind_3 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_3 = _jspx_th_spring_bind_3.doStartTag();
        if (_jspx_eval_spring_bind_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("              <td width=\"12%\">Anarana *</td>\r\n");
            out.write("              <td align=\"left\" width=\"23%\">\r\n");
            out.write("          \t    <input name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" type=\"text\" size=\"22\"  />\r\n");
            out.write("          \t    <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("              </td>\r\n");
            out.write("              ");
            int evalDoAfterBody = _jspx_th_spring_bind_3.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_3[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_3.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_3.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_3);
      }
      out.write("\r\n");
      out.write("\t\t      ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_4 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_4.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_4.setParent(null);
      _jspx_th_spring_bind_4.setPath("formChristian.fanampiny");
      int[] _jspx_push_body_count_spring_bind_4 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_4 = _jspx_th_spring_bind_4.doStartTag();
        if (_jspx_eval_spring_bind_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("              <td width=\"10%\">Fanampiny </td>\r\n");
            out.write("              <td width=\"23%\">\r\n");
            out.write("          \t    <input name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" type=\"text\" size=\"22\"  />\r\n");
            out.write("          \t    <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("              </td>\r\n");
            out.write("              ");
            int evalDoAfterBody = _jspx_th_spring_bind_4.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_4[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_4.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_4.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_4);
      }
      out.write("\r\n");
      out.write("\t\t      <td colspan=\"2\">\r\n");
      out.write("\t\t      ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_5 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_5.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_5.setParent(null);
      _jspx_th_spring_bind_5.setPath("formChristian.lahy");
      int[] _jspx_push_body_count_spring_bind_5 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_5 = _jspx_th_spring_bind_5.doStartTag();
        if (_jspx_eval_spring_bind_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("                <table valign=\"TOP\" align=\"right\">\r\n");
            out.write("                  <tr>\r\n");
            out.write("                  ");
 
                  if (formChristian.getMpivavaka().getId() != null){
                  
            out.write("\r\n");
            out.write("                  <td><a href=\"uploadPhoto.htm\">Manova ny sary</a></td>\r\n");
            out.write("                  ");

                  }
                  
            out.write("\r\n");
            out.write("\t              ");
            if (_jspx_meth_c_choose_0(_jspx_th_spring_bind_5, _jspx_page_context, _jspx_push_body_count_spring_bind_5))
              return;
            out.write("\r\n");
            out.write("                  </tr>\r\n");
            out.write("                </table>\r\n");
            out.write("              ");
            int evalDoAfterBody = _jspx_th_spring_bind_5.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_5[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_5.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_5.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_5);
      }
      out.write("\r\n");
      out.write("\t\t      </td>          \r\n");
      out.write("            </tr>\r\n");
      out.write("\r\n");
      out.write("            <tr height=\"12\">\r\n");
      out.write("              <td>Teraka ny </td>\r\n");
      out.write("\t  \t\t  ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_6 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_6.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_6.setParent(null);
      _jspx_th_spring_bind_6.setPath("formChristian.datyTeraka");
      int[] _jspx_push_body_count_spring_bind_6 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_6 = _jspx_th_spring_bind_6.doStartTag();
        if (_jspx_eval_spring_bind_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("              <td>\r\n");
            out.write("                <input name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" type=\"text\" id=\"datyTeraka\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" size=\"10\" class=\"inputleft\" />\r\n");
            out.write("                <img src=\"");
            out.print(request.getContextPath());
            out.write("/images/icon_calendar.gif\" id=\"imgDateTeraka\" width=\"16\" height=\"16\" />\r\n");
            out.write("              </td>\r\n");
            out.write("              ");
            int evalDoAfterBody = _jspx_th_spring_bind_6.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_6[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_6.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_6.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_6);
      }
      out.write("\r\n");
      out.write("              <td align=\"left\"> tao </td>\r\n");
      out.write("              ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_7 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_7.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_7.setParent(null);
      _jspx_th_spring_bind_7.setPath("formChristian.toeranaTeraka");
      int[] _jspx_push_body_count_spring_bind_7 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_7 = _jspx_th_spring_bind_7.doStartTag();
        if (_jspx_eval_spring_bind_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("              <td align=\"right\">\r\n");
            out.write("                <input type=\"text\" size=\"22\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\r\n");
            out.write("        \t    <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("              </td>\r\n");
            out.write("              ");
            int evalDoAfterBody = _jspx_th_spring_bind_7.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_7[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_7.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_7.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_7);
      }
      out.write("\r\n");
      out.write("              \r\n");
      out.write("              <td colspan=\"2\">&nbsp;</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("              ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_8 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_8.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_8.setParent(null);
      _jspx_th_spring_bind_8.setPath("formChristian.laharanaCIN");
      int[] _jspx_push_body_count_spring_bind_8 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_8 = _jspx_th_spring_bind_8.doStartTag();
        if (_jspx_eval_spring_bind_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("              <td>Karapanondro </td>\r\n");
            out.write("              <td align=\"left\">\r\n");
            out.write("                <input type=\"text\" size=\"22\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\"  />\r\n");
            out.write("                <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("              </td>\r\n");
            out.write("              ");
            int evalDoAfterBody = _jspx_th_spring_bind_8.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_8[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_8.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_8.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_8);
      }
      out.write("\r\n");
      out.write("              ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_9 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_9.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_9.setParent(null);
      _jspx_th_spring_bind_9.setPath("formChristian.datyCIN");
      int[] _jspx_push_body_count_spring_bind_9 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_9 = _jspx_th_spring_bind_9.doStartTag();
        if (_jspx_eval_spring_bind_9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("              <td>tamin'ny </td>\r\n");
            out.write("              <td>\r\n");
            out.write("                <input name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" type=\"text\" id=\"dateCIN\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" size=\"10\" class=\"inputleft\" />\r\n");
            out.write("                <img src=\"");
            out.print(request.getContextPath());
            out.write("/images/icon_calendar.gif\" id=\"imgDateCIN\" width=\"16\" height=\"16\" />\r\n");
            out.write("                <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("              </td>\r\n");
            out.write("              ");
            int evalDoAfterBody = _jspx_th_spring_bind_9.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_9[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_9.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_9.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_9);
      }
      out.write("\r\n");
      out.write("\t\t      <td>tao</td>          \r\n");
      out.write("              <td>          \r\n");
      out.write("\t          ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_10 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_10.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_10.setParent(null);
      _jspx_th_spring_bind_10.setPath("formChristian.taoCIN");
      int[] _jspx_push_body_count_spring_bind_10 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_10 = _jspx_th_spring_bind_10.doStartTag();
        if (_jspx_eval_spring_bind_10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("\t          \t  <!-- la saisie à autocompléter -->\r\n");
            out.write("\t\t\t      <input class=\"inputleft\" id=\"firaisanaCinLabel\" name=\"firaisanaCinLabel\" type=\"text\" size=\"22\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formChristian.taoCIN.label}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("\t\t\t      <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->\r\n");
            out.write("\t\t\t      <input type=\"hidden\" id=\"firaisanaCinID\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formChristian.taoCIN.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("\t\t\t      <span id=\"indicatorFiraisanaCinID\" style=\"display:none;\"><img src=\"");
            out.print(request.getContextPath());
            out.write("/images/indicator.gif\" /></span>\r\n");
            out.write("\t\t\t      <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("\t              \r\n");
            out.write("\t              ");
            if (_jspx_meth_ajax_autocomplete_2(_jspx_th_spring_bind_10, _jspx_page_context, _jspx_push_body_count_spring_bind_10))
              return;
            out.write("                  \r\n");
            out.write("\t          ");
            int evalDoAfterBody = _jspx_th_spring_bind_10.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_10[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_10.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_10.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_10);
      }
      out.write("\r\n");
      out.write("              </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td>&nbsp;</td>\r\n");
      out.write("\t\t      <td>&nbsp;</td>          \r\n");
      out.write("              ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_11 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_11.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_11.setParent(null);
      _jspx_th_spring_bind_11.setPath("formChristian.datyNanoloinaCIN");
      int[] _jspx_push_body_count_spring_bind_11 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_11 = _jspx_th_spring_bind_11.doStartTag();
        if (_jspx_eval_spring_bind_11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("              <td>Nosoloina </td>\r\n");
            out.write("              <td align=\"left\">\r\n");
            out.write("                <input name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" type=\"text\" id=\"datyNanoloinaCIN\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" size=\"10\" class=\"inputleft\" />\r\n");
            out.write("                <img src=\"");
            out.print(request.getContextPath());
            out.write("/images/icon_calendar.gif\" id=\"imgDateNanoloinaCIN\" width=\"16\" height=\"16\" />\r\n");
            out.write("                <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("              </td>\r\n");
            out.write("              ");
            int evalDoAfterBody = _jspx_th_spring_bind_11.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_11[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_11.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_11.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_11);
      }
      out.write("\r\n");
      out.write("              <td>tao </td>\r\n");
      out.write("              <td>\r\n");
      out.write("              ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_12 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_12.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_12.setParent(null);
      _jspx_th_spring_bind_12.setPath("formChristian.taoNanoloinaCIN");
      int[] _jspx_push_body_count_spring_bind_12 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_12 = _jspx_th_spring_bind_12.doStartTag();
        if (_jspx_eval_spring_bind_12 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("          \t  <!-- la saisie à autocompléter -->\r\n");
            out.write("\t\t        <input class=\"inputleft\" id=\"firaisanaNanoloinaCinLabel\" name=\"firaisanaNanoloinaCinLabel\" type=\"text\" size=\"22\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formChristian.taoNanoloinaCIN.label}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("\t\t      <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->\r\n");
            out.write("\t\t        <input type=\"hidden\" id=\"firaisanaNanoloinaCinID\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formChristian.taoNanoloinaCIN.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("\t\t        <span id=\"indicatorFiraisanaNanoloinaCinID\" style=\"display:none;\"><img src=\"");
            out.print(request.getContextPath());
            out.write("/images/indicator.gif\" /></span>\r\n");
            out.write("\t\t        <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("              \r\n");
            out.write("                ");
            if (_jspx_meth_ajax_autocomplete_3(_jspx_th_spring_bind_12, _jspx_page_context, _jspx_push_body_count_spring_bind_12))
              return;
            out.write("                  \r\n");
            out.write("              ");
            int evalDoAfterBody = _jspx_th_spring_bind_12.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_12[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_12.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_12.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_12);
      }
      out.write("\r\n");
      out.write("              </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td>Ray </td>\r\n");
      out.write("              <td align=\"left\">\r\n");
      out.write("          \t  <!-- la saisie à autocompléter -->\r\n");
      out.write("              ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_13 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_13.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_13.setParent(null);
      _jspx_th_spring_bind_13.setPath("formChristian.mpivavakaRayAnarana");
      int[] _jspx_push_body_count_spring_bind_13 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_13 = _jspx_th_spring_bind_13.doStartTag();
        if (_jspx_eval_spring_bind_13 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("\t\t        <input class=\"inputleft\" id=\"mpivavakaRayAnarana\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" type=\"text\" size=\"22\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("\t\t        <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("\t\t      ");
            int evalDoAfterBody = _jspx_th_spring_bind_13.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_13[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_13.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_13.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_13);
      }
      out.write("\r\n");
      out.write("\t\t      <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->\r\n");
      out.write("              ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_14 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_14.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_14.setParent(null);
      _jspx_th_spring_bind_14.setPath("formChristian.ray_");
      int[] _jspx_push_body_count_spring_bind_14 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_14 = _jspx_th_spring_bind_14.doStartTag();
        if (_jspx_eval_spring_bind_14 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("\t\t        <input type=\"hidden\" id=\"rayID\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formChristian.ray_.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("\t\t        <span id=\"indicatorRayID\" style=\"display:none;\"><img src=\"");
            out.print(request.getContextPath());
            out.write("/images/indicator.gif\" /></span>\r\n");
            out.write("\t\t        <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("              ");
            int evalDoAfterBody = _jspx_th_spring_bind_14.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_14[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_14.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_14.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_14);
      }
      out.write("\r\n");
      out.write("              \r\n");
      out.write("                ");
      if (_jspx_meth_ajax_autocomplete_4(_jspx_page_context))
        return;
      out.write("                  \r\n");
      out.write("              </td>\r\n");
      out.write("              <td>Reny </td>\r\n");
      out.write("              <td>\r\n");
      out.write("          \t  <!-- la saisie à autocompléter -->\r\n");
      out.write("              ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_15 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_15.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_15.setParent(null);
      _jspx_th_spring_bind_15.setPath("formChristian.mpivavakaRenyAnarana");
      int[] _jspx_push_body_count_spring_bind_15 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_15 = _jspx_th_spring_bind_15.doStartTag();
        if (_jspx_eval_spring_bind_15 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("\t\t        <input class=\"inputleft\" id=\"mpivavakaRenyAnarana\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" type=\"text\" size=\"22\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("\t\t        <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("\t\t      ");
            int evalDoAfterBody = _jspx_th_spring_bind_15.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_15[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_15.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_15.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_15);
      }
      out.write("\r\n");
      out.write("\t\t      <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->\r\n");
      out.write("              ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_16 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_16.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_16.setParent(null);
      _jspx_th_spring_bind_16.setPath("formChristian.reny_");
      int[] _jspx_push_body_count_spring_bind_16 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_16 = _jspx_th_spring_bind_16.doStartTag();
        if (_jspx_eval_spring_bind_16 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("\t\t        <input type=\"hidden\" id=\"renyID\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formChristian.reny_.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("\t\t        <span id=\"indicatorRenyID\" style=\"display:none;\"><img src=\"");
            out.print(request.getContextPath());
            out.write("/images/indicator.gif\" /></span>\r\n");
            out.write("\t\t        <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("              ");
            int evalDoAfterBody = _jspx_th_spring_bind_16.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_16[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_16.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_16.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_16);
      }
      out.write("\r\n");
      out.write("              \r\n");
      out.write("                ");
      if (_jspx_meth_ajax_autocomplete_5(_jspx_page_context))
        return;
      out.write("                  \r\n");
      out.write("              </td>\r\n");
      out.write("              <td>&nbsp;</td>\r\n");
      out.write("\t\t      <td>&nbsp;</td>          \r\n");
      out.write("            </tr>\r\n");
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td>Vady </td>\r\n");
      out.write("              <td align=\"left\">\r\n");
      out.write("          \t  <!-- la saisie à autocompléter -->\r\n");
      out.write("              ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_17 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_17.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_17.setParent(null);
      _jspx_th_spring_bind_17.setPath("formChristian.mpivavakaAnaranaVady");
      int[] _jspx_push_body_count_spring_bind_17 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_17 = _jspx_th_spring_bind_17.doStartTag();
        if (_jspx_eval_spring_bind_17 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("\t\t        <input class=\"inputleft\" id=\"mpivavakaVadyAnarana\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" type=\"text\" size=\"22\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("\t\t        <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("\t\t      ");
            int evalDoAfterBody = _jspx_th_spring_bind_17.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_17[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_17.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_17.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_17);
      }
      out.write("\r\n");
      out.write("\t\t      <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->\r\n");
      out.write("              ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_18 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_18.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_18.setParent(null);
      _jspx_th_spring_bind_18.setPath("formChristian.vady");
      int[] _jspx_push_body_count_spring_bind_18 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_18 = _jspx_th_spring_bind_18.doStartTag();
        if (_jspx_eval_spring_bind_18 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("\t\t        <input type=\"hidden\" id=\"vadyID\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formChristian.vady.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("\t\t        <span id=\"indicatorVadyID\" style=\"display:none;\"><img src=\"");
            out.print(request.getContextPath());
            out.write("/images/indicator.gif\" /></span>\r\n");
            out.write("\t\t        <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("              ");
            int evalDoAfterBody = _jspx_th_spring_bind_18.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_18[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_18.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_18.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_18);
      }
      out.write("\r\n");
      out.write("              \r\n");
      out.write("                ");
      if (_jspx_meth_ajax_autocomplete_6(_jspx_page_context))
        return;
      out.write("                  \r\n");
      out.write("              </td>\r\n");
      out.write("              <td>Tamin'ny</td>\r\n");
      out.write("              ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_19 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_19.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_19.setParent(null);
      _jspx_th_spring_bind_19.setPath("formChristian.datyFanambadiana");
      int[] _jspx_push_body_count_spring_bind_19 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_19 = _jspx_th_spring_bind_19.doStartTag();
        if (_jspx_eval_spring_bind_19 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("\t\t      <td>\r\n");
            out.write("                <input name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" type=\"text\" id=\"datyFanambadiana\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" size=\"10\" class=\"inputleft\" />\r\n");
            out.write("                <img src=\"");
            out.print(request.getContextPath());
            out.write("/images/icon_calendar.gif\" id=\"imgDateFanambadiana\" width=\"16\" height=\"16\" />\r\n");
            out.write("                <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("              </td>          \r\n");
            out.write("              ");
            int evalDoAfterBody = _jspx_th_spring_bind_19.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_19[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_19.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_19.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_19);
      }
      out.write("\r\n");
      out.write("              <td>tao</td>\r\n");
      out.write("              <td>\r\n");
      out.write("              ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_20 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_20.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_20.setParent(null);
      _jspx_th_spring_bind_20.setPath("formChristian.fitandremanaFanambadiana");
      int[] _jspx_push_body_count_spring_bind_20 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_20 = _jspx_th_spring_bind_20.doStartTag();
        if (_jspx_eval_spring_bind_20 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("          \t  <!-- la saisie à autocompléter -->\r\n");
            out.write("\t\t        <input class=\"inputleft\" id=\"fitandremanaFanambadianaLabel\" name=\"fitandremanaFanambadianaLabel\" type=\"text\" size=\"22\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formChristian.fitandremanaFanambadiana.label}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("\t\t      <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->\r\n");
            out.write("\t\t        <input type=\"hidden\" id=\"fitandremanaFanambadianaID\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formChristian.fitandremanaFanambadiana.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("\t\t        <span id=\"indicatorFitandremanaFanambadianaID\" style=\"display:none;\"><img src=\"");
            out.print(request.getContextPath());
            out.write("/images/indicator.gif\" /></span>\r\n");
            out.write("\t\t        <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("              \r\n");
            out.write("                ");
            if (_jspx_meth_ajax_autocomplete_7(_jspx_th_spring_bind_20, _jspx_page_context, _jspx_push_body_count_spring_bind_20))
              return;
            out.write("                  \r\n");
            out.write("              ");
            int evalDoAfterBody = _jspx_th_spring_bind_20.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_20[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_20.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_20.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_20);
      }
      out.write("\r\n");
      out.write("              </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("              ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_21 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_21.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_21.setParent(null);
      _jspx_th_spring_bind_21.setPath("formChristian.adresse");
      int[] _jspx_push_body_count_spring_bind_21 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_21 = _jspx_th_spring_bind_21.doStartTag();
        if (_jspx_eval_spring_bind_21 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("              <td>Adiresy </td>\r\n");
            out.write("              <td colspan=\"3\" align=\"left\">\r\n");
            out.write("\t\t\t    <textarea name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" rows=\"3\" cols=\"40\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</textarea>\r\n");
            out.write("                <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("              </td>\r\n");
            out.write("              ");
            int evalDoAfterBody = _jspx_th_spring_bind_21.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_21[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_21.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_21.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_21);
      }
      out.write("\r\n");
      out.write("\t\t      <td colspan=\"2\">\r\n");
      out.write("\t\t        <table width=\"100%\">\r\n");
      out.write("\t\t          <tr>\r\n");
      out.write("          \t\t    ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_22 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_22.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_22.setParent(null);
      _jspx_th_spring_bind_22.setPath("formChristian.antonAsa");
      int[] _jspx_push_body_count_spring_bind_22 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_22 = _jspx_th_spring_bind_22.doStartTag();
        if (_jspx_eval_spring_bind_22 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("\t\t            <td>Asa </td>\r\n");
            out.write("\t\t            <td>\r\n");
            out.write("\t          \t    <!-- la saisie à autocompléter -->\r\n");
            out.write("\t\t\t          <input class=\"inputleft\" id=\"antonAsaLabel\" name=\"antonAsaLabel\" type=\"text\" size=\"22\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formChristian.antonAsa.intitule}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("\t\t\t        <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->\r\n");
            out.write("\t\t\t          <input type=\"hidden\" id=\"antonAsaID\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formChristian.antonAsa.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("\t\t\t          <span id=\"indicatorAntonAsaID\" style=\"display:none;\"><img src=\"");
            out.print(request.getContextPath());
            out.write("/images/indicator.gif\" /></span>\r\n");
            out.write("\t\t\t          <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("\t              \r\n");
            out.write("\t                  ");
            if (_jspx_meth_ajax_autocomplete_8(_jspx_th_spring_bind_22, _jspx_page_context, _jspx_push_body_count_spring_bind_22))
              return;
            out.write("\r\n");
            out.write("\t\t            </td>\r\n");
            out.write("\t\t            ");
            int evalDoAfterBody = _jspx_th_spring_bind_22.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_22[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_22.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_22.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_22);
      }
      out.write("\r\n");
      out.write("\t\t          </tr>\r\n");
      out.write("\t\t          <tr>\r\n");
      out.write("          \t\t    ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_23 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_23.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_23.setParent(null);
      _jspx_th_spring_bind_23.setPath("formChristian.talenta");
      int[] _jspx_push_body_count_spring_bind_23 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_23 = _jspx_th_spring_bind_23.doStartTag();
        if (_jspx_eval_spring_bind_23 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("\t\t            <td>Talenta</td>\r\n");
            out.write("\t\t            <td>\r\n");
            out.write("\t\t              <input type=\"text\" size=\"22\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\"  />\r\n");
            out.write("\t\t              <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("\t\t            </td>\r\n");
            out.write("\t\t            ");
            int evalDoAfterBody = _jspx_th_spring_bind_23.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_23[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_23.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_23.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_23);
      }
      out.write("\r\n");
      out.write("\t\t          </tr>\r\n");
      out.write("\t\t        </table>\r\n");
      out.write("\t\t      </td>          \r\n");
      out.write("            </tr>        \r\n");
      out.write("\r\n");
      out.write("            <tr>        \r\n");
      out.write("              ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_24 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_24.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_24.setParent(null);
      _jspx_th_spring_bind_24.setPath("formChristian.firaisana");
      int[] _jspx_push_body_count_spring_bind_24 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_24 = _jspx_th_spring_bind_24.doStartTag();
        if (_jspx_eval_spring_bind_24 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("              <td>Firaisana</td>\r\n");
            out.write("              <td>\r\n");
            out.write("          \t  <!-- la saisie à autocompléter -->\r\n");
            out.write("\t\t        <input class=\"inputleft\" id=\"firaisanaLabel\" name=\"firaisanaLabel\" type=\"text\" size=\"22\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formChristian.firaisana.label}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" onchange=\"javascript:invalidateField('faritraID');\"/>\t\r\n");
            out.write("\t\t      <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->\r\n");
            out.write("\t\t        <input type=\"hidden\" id=\"firaisanaID\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formChristian.firaisana.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("\t\t        <span id=\"indicatorFiraisanaID\" style=\"display:none;\"><img src=\"");
            out.print(request.getContextPath());
            out.write("/images/indicator.gif\" /></span>\r\n");
            out.write("\t\t        <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("              \r\n");
            out.write("                ");
            if (_jspx_meth_ajax_autocomplete_9(_jspx_th_spring_bind_24, _jspx_page_context, _jspx_push_body_count_spring_bind_24))
              return;
            out.write("                  \r\n");
            out.write("              </td>\r\n");
            out.write("              ");
            int evalDoAfterBody = _jspx_th_spring_bind_24.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_24[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_24.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_24.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_24);
      }
      out.write("\r\n");
      out.write("              ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_25 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_25.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_25.setParent(null);
      _jspx_th_spring_bind_25.setPath("formChristian.faritra");
      int[] _jspx_push_body_count_spring_bind_25 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_25 = _jspx_th_spring_bind_25.doStartTag();
        if (_jspx_eval_spring_bind_25 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("              <td>Faritra</td>\r\n");
            out.write("              <td>\r\n");
            out.write("          \t  <!-- la saisie à autocompléter -->\r\n");
            out.write("                <input id=\"faritraLabel\" name=\"faritraLabel\" type=\"text\" size=\"22\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formChristian.faritra.label}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\"/>\r\n");
            out.write("\t\t      <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->\r\n");
            out.write("\t\t        <input type=\"hidden\" id=\"faritraID\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formChristian.faritra.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\r\n");
            out.write("\t\t        <span id=\"indicatorFaritraID\" style=\"display:none;\"><img src=\"");
            out.print(request.getContextPath());
            out.write("/images/indicator.gif\" /></span>\r\n");
            out.write("\t\t        <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("              \r\n");
            out.write("                ");
            if (_jspx_meth_ajax_autocomplete_10(_jspx_th_spring_bind_25, _jspx_page_context, _jspx_push_body_count_spring_bind_25))
              return;
            out.write("                                \r\n");
            out.write("              </td>\r\n");
            out.write("              ");
            int evalDoAfterBody = _jspx_th_spring_bind_25.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_25[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_25.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_25.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_25);
      }
      out.write("\r\n");
      out.write("\t\t      <td>&nbsp;</td>          \r\n");
      out.write("              <td>&nbsp;</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td>Tél : </td>\r\n");
      out.write("  \t\t      ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_26 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_26.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_26.setParent(null);
      _jspx_th_spring_bind_26.setPath("formChristian.tel");
      int[] _jspx_push_body_count_spring_bind_26 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_26 = _jspx_th_spring_bind_26.doStartTag();
        if (_jspx_eval_spring_bind_26 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("\t  \t      <td align=\"left\">\r\n");
            out.write("\t            <input type=\"text\" size=\"22\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\"  />\r\n");
            out.write("\t            <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("\t          </td>\r\n");
            out.write("\t          ");
            int evalDoAfterBody = _jspx_th_spring_bind_26.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_26[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_26.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_26.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_26);
      }
      out.write("\r\n");
      out.write("\t          ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_27 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_27.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_27.setParent(null);
      _jspx_th_spring_bind_27.setPath("formChristian.mailaka");
      int[] _jspx_push_body_count_spring_bind_27 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_27 = _jspx_th_spring_bind_27.doStartTag();
        if (_jspx_eval_spring_bind_27 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("\t          <td align=\"left\">E-mail </td>\r\n");
            out.write("\t          <td align=\"right\">\r\n");
            out.write("\t            <input type=\"text\" size=\"22\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\"  />\r\n");
            out.write("\t            <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("\t          </td>\r\n");
            out.write("\t          ");
            int evalDoAfterBody = _jspx_th_spring_bind_27.doAfterBody();
            status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_27[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_27.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_27.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_27);
      }
      out.write("\r\n");
      out.write("              <td>&nbsp;</td>\r\n");
      out.write("\t\t      <td>&nbsp;</td>          \r\n");
      out.write("            </tr>\r\n");
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td colspan=\"7\">&nbsp;</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        \r\n");
      out.write("            <tr>\r\n");
      out.write("\t          <td>&nbsp;</td>\r\n");
      out.write("\t          ");
 if (formChristian.isFromSearch()) {
      out.write("\r\n");
      out.write("\t          <td align=\"center\"><input name=\"Miverina\" class=\"button\" id=\"boutonMiverina\" value=\"Miverina\" type=\"button\" onclick=\"javascript: document.location='searchChristianAjax.htm?reload&from=");
      out.print(request.getSession().getAttribute(ConstantUtils.sfSelectedTab));
      out.write("';\"/></td>\r\n");
      out.write("\t          ");

	          } 
	          else { 
	          
      out.write("\r\n");
      out.write("\t          <td align=\"center\"><input name=\"Miverina\" class=\"button\" id=\"boutonMiverina\" value=\"Miverina\" type=\"button\" onclick=\"javascript: document.location='index.htm?");
      out.print(request.getSession().getAttribute(ConstantUtils.sfSelectedTab));
      out.write("';\"/></td>\r\n");
      out.write("\t          ");
 
	          } 
	          
      out.write("\r\n");
      out.write("\t          <td>&nbsp;</td>\r\n");
      out.write("\t\t      <td>&nbsp;</td>          \r\n");
      out.write("              <td>&nbsp;</td>\r\n");
      out.write("\t          <td align=\"right\"><input name=\"Valider\" class=\"button\" id=\"boutonValider\" value=\"Alefa\" type=\"submit\" /></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("          </table>\r\n");
      out.write("        </td>\r\n");
      out.write("\t  </tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("    </form>\r\n");
      out.write("\t  \r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  \r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>\r\n");
      out.write("    <!-- Information de création et de dernière modification -->\r\n");
      out.write("      ");
 if (request.getAttribute(ConstantUtils.sfSaveableEntity) != null) {
     SaveableEntity saveableEntity = (SaveableEntity) request.getAttribute(ConstantUtils.sfSaveableEntity);

      out.write("\r\n");
      out.write("<table width=\"100%\" border=\"0\" bgcolor=\"#FFCC99\">\r\n");
      out.write("<tr>\r\n");
      out.write("  <td align=\"left\">\r\n");
      out.write("   No : [<b>");
      out.print(saveableEntity.getId());
      out.write("</b>] > Nampidirin'i :<b>");
      out.print(saveableEntity.getUserCreator().getLogin());
      out.write(" </b> \r\n");
      out.write("  </td>\r\n");
      out.write("  <td align=\"left\">\r\n");
      out.write("  tamin'ny : <b>");
      out.print(Utils.sfDateFormatJJMMYYYY.format(saveableEntity.getDateCreation()));
      out.write("</b>\r\n");
      out.write("  </td>\r\n");
      out.write("\r\n");
 if (saveableEntity.getUserLastModification() != null) { 
      out.write("\r\n");
      out.write("  <td align=\"right\">\r\n");
      out.write("   Novain'i :<b>");
      out.print(saveableEntity.getUserLastModification().getLogin());
      out.write(" </b> \r\n");
      out.write("  </td>\r\n");
      out.write("  <td align=\"right\">\r\n");
      out.write("  tamin'ny : <b>");
      out.print(Utils.sfDateFormatJJMMYYYY.format(saveableEntity.getDateLastModification()));
      out.write("</b>\r\n");
      out.write("  </td>\r\n");
}
  else {
      out.write("\r\n");
      out.write("  <td align=\"right\">\r\n");
      out.write("    &nbsp;\r\n");
      out.write("  </td>\r\n");
      out.write("  <td align=\"right\">\r\n");
      out.write("    &nbsp;\r\n");
      out.write("  </td>\r\n");
}
      out.write("\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
}
      out.write("\t\r\n");
      out.write("\t</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\tCalendar.setup({\r\n");
      out.write("\t\tinputField     :    \"datyTeraka\",     // id of the input field\r\n");
      out.write("\t\tifFormat       :    \"%d/%m/%Y\",      // format of the input field\r\n");
      out.write("\t\tbutton         :    \"imgDateTeraka\",  // trigger for the calendar (button ID)\r\n");
      out.write("\t\talign          :    \"Tl\",           // alignment (defaults to \"Bl\")\r\n");
      out.write("\t\tsingleClick    :    true\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\tCalendar.setup({\r\n");
      out.write("\t\tinputField     :    \"dateCIN\",     // id of the input field\r\n");
      out.write("\t\tifFormat       :    \"%d/%m/%Y\",      // format of the input field\r\n");
      out.write("\t\tbutton         :    \"imgDateCIN\",  // trigger for the calendar (button ID)\r\n");
      out.write("\t\talign          :    \"Tl\",           // alignment (defaults to \"Bl\")\r\n");
      out.write("\t\tsingleClick    :    true\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\tCalendar.setup({\r\n");
      out.write("\t\tinputField     :    \"datyNanoloinaCIN\",     // id of the input field\r\n");
      out.write("\t\tifFormat       :    \"%d/%m/%Y\",      // format of the input field\r\n");
      out.write("\t\tbutton         :    \"imgDateNanoloinaCIN\",  // trigger for the calendar (button ID)\r\n");
      out.write("\t\talign          :    \"Tl\",           // alignment (defaults to \"Bl\")\r\n");
      out.write("\t\tsingleClick    :    true\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\tCalendar.setup({\r\n");
      out.write("\t\tinputField     :    \"datyFanambadiana\",     // id of the input field\r\n");
      out.write("\t\tifFormat       :    \"%d/%m/%Y\",      // format of the input field\r\n");
      out.write("\t\tbutton         :    \"imgDateFanambadiana\",  // trigger for the calendar (button ID)\r\n");
      out.write("\t\talign          :    \"Tl\",           // alignment (defaults to \"Bl\")\r\n");
      out.write("\t\tsingleClick    :    true\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<!-- Message d'erreur éventuel -->\r\n");

  if (request.getAttribute(ConstantUtils.sfMessageEnregistrementKO) != null){

      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("function showErrorMessage (){\r\n");
      out.write("\tvar options = {\r\n");
      out.write("\t\t\"title\": \"Valin'ny fangatahana\",\r\n");
      out.write("\t\t\"button\": \"OK\",\r\n");
      out.write("\t\t\"className\":\"error\",\r\n");
      out.write("\t\t\"modal\":\"true\"\r\n");
      out.write("\t};\r\n");
      out.write("\t    \r\n");
      out.write("\tmsg.open(\"Nisy tsy nety ny fampidirana na fanovàna mpivavaka tianao hatao\", options);\r\n");
      out.write("\treturn false;\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("showErrorMessage();\r\n");
      out.write("</script>\r\n");

  }

      out.write("\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\tfunction evalInnerHTML(){\r\n");
      out.write("\t\tvar div = document.getElementById('msgContent');\r\n");
      out.write("\t\teval(div.innerHTML);\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction evalScript(){\r\n");
      out.write("\t\tvar div = document.getElementById('msgBox');\r\n");
      out.write("\t\tvar x = div.getElementsByTagName(\"script\");\r\n");
      out.write("\t\tfor(var i=0;i<x.length;i++){\r\n");
      out.write("\t\t    eval(x[i].text);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction ajaxSubmitReq(){\r\n");
      out.write("\t\tvar req = new AjReq();\r\n");
      out.write("\t\tvar opts = {\r\n");
      out.write("\t\t\tmethod : 'POST',\r\n");
      out.write("\t\t\tparams : 'laharana='+document.getElementById('laharanaTranga').value+'&daty='+document.getElementById('datyTranga').value+'&fitandremana='+document.getElementById('fitandremanaTranga').value,\r\n");
      out.write("\t\t\tupdate : document.getElementById('msgContent'),\r\n");
      out.write("\t\t\tabortAfter : 15000,\r\n");
      out.write("\t\t\tonSuccess : function(){evalInnerHTML();}\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\treq.send('editTranga.htm', opts);\r\n");
      out.write("\t};\r\n");
      out.write("\r\n");
      out.write("\t<!-- Script pour l'edition d'un Batisa -->\r\n");
      out.write("\tfunction editBatisaAjax(){\r\n");
      out.write("\t\tvar options = {\r\n");
      out.write("\t\t\tajaxContent:'editTranga.htm?");
      out.print(ConstantUtils.sfTRANGA_BATISA);
      out.write("',\r\n");
      out.write("\t\t\tmodal:true,\r\n");
      out.write("\t\t\tbutton:null\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tmsg.open('Miandry kely', options);\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t};\r\n");
      out.write("\r\n");
      out.write("\tfunction editBatisa(){\r\n");
      out.write("\t\tif (fjkmAnkadifotsyIsNavigatorIE()){\r\n");
      out.write("\t\t\tif (fjkmAnkadifotsyVerIE() >= 8){\r\n");
      out.write("\t\t\t\teditBatisaAjax();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse{\r\n");
      out.write("\t\t\t\teditTranga('editTranga.htm?");
      out.print(ConstantUtils.sfTRANGA_BATISA);
      out.write("&popup', 'Batisa', 360, 280);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse{\r\n");
      out.write("\t\t\teditBatisaAjax();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t};\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- script pour l'edition d'un Mpandray -->\r\n");
      out.write("\tfunction editMpandrayAjax(){\r\n");
      out.write("\t\tvar options = {\r\n");
      out.write("\t\t\tajaxContent:'editTranga.htm?");
      out.print(ConstantUtils.sfTRANGA_MPANDRAY);
      out.write("',\r\n");
      out.write("\t\t\tmodal:true,\r\n");
      out.write("\t\t\tbutton:null\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tmsg.open('Miandry kely', options);\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t};\r\n");
      out.write("\r\n");
      out.write("\tfunction editMpandray(){\r\n");
      out.write("\t\tif (fjkmAnkadifotsyIsNavigatorIE()){\r\n");
      out.write("\t\t\tif (fjkmAnkadifotsyVerIE() >= 8){\r\n");
      out.write("\t\t\t\teditMpandrayAjax();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse{\r\n");
      out.write("\t\t\t\teditTranga('editTranga.htm?");
      out.print(ConstantUtils.sfTRANGA_MPANDRAY);
      out.write("&popup', 'Mpandray', 360, 280);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse{\r\n");
      out.write("\t\t\teditMpandrayAjax();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t};\r\n");
      out.write("\t\r\n");
      out.write("</script>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- fin corps -->\r\n");
      out.write("\r\n");
      out.write("<!-- pied de page -->\r\n");
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

  private boolean _jspx_meth_ajax_autocomplete_0(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_bind_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_bind_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ajax:autocomplete
    org.ajaxtags.tags.AjaxAutocompleteTag _jspx_th_ajax_autocomplete_0 = (org.ajaxtags.tags.AjaxAutocompleteTag) _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.get(org.ajaxtags.tags.AjaxAutocompleteTag.class);
    _jspx_th_ajax_autocomplete_0.setPageContext(_jspx_page_context);
    _jspx_th_ajax_autocomplete_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_bind_0);
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

  private boolean _jspx_meth_ajax_autocomplete_1(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_bind_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_bind_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ajax:autocomplete
    org.ajaxtags.tags.AjaxAutocompleteTag _jspx_th_ajax_autocomplete_1 = (org.ajaxtags.tags.AjaxAutocompleteTag) _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.get(org.ajaxtags.tags.AjaxAutocompleteTag.class);
    _jspx_th_ajax_autocomplete_1.setPageContext(_jspx_page_context);
    _jspx_th_ajax_autocomplete_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_bind_2);
    _jspx_th_ajax_autocomplete_1.setSource("fitandremanaNiavianaLabel");
    _jspx_th_ajax_autocomplete_1.setTarget("fitandremanaNiavianaID");
    _jspx_th_ajax_autocomplete_1.setBaseUrl("fitandremanaAutoCompletion.htm");
    _jspx_th_ajax_autocomplete_1.setClassName("autocomplete");
    _jspx_th_ajax_autocomplete_1.setIndicator("indicatorFitandremanaNiavianaID");
    _jspx_th_ajax_autocomplete_1.setMinimumCharacters("1");
    int _jspx_eval_ajax_autocomplete_1 = _jspx_th_ajax_autocomplete_1.doStartTag();
    if (_jspx_th_ajax_autocomplete_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_1);
      return true;
    }
    _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_1);
    return false;
  }

  private boolean _jspx_meth_c_choose_0(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_bind_5, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_bind_5)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_bind_5);
    int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
    if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t              ");
        if (_jspx_meth_c_when_0(_jspx_th_c_choose_0, _jspx_page_context, _jspx_push_body_count_spring_bind_5))
          return true;
        out.write("\r\n");
        out.write("\t              ");
        if (_jspx_meth_c_otherwise_0(_jspx_th_c_choose_0, _jspx_page_context, _jspx_push_body_count_spring_bind_5))
          return true;
        out.write("\r\n");
        out.write("\t              ");
        int evalDoAfterBody = _jspx_th_c_choose_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
    return false;
  }

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_bind_5)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t                <td><input class=\"inputleft\" name=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\" type=\"radio\" value=\"true\" checked />Lahy</td>\r\n");
        out.write("\t                <td><input class=\"inputleft\" name=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\" type=\"radio\" value=\"false\" />Vavy</td>\r\n");
        out.write("\t              ");
        int evalDoAfterBody = _jspx_th_c_when_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
    return false;
  }

  private boolean _jspx_meth_c_otherwise_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_bind_5)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_otherwise_0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_0.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    int _jspx_eval_c_otherwise_0 = _jspx_th_c_otherwise_0.doStartTag();
    if (_jspx_eval_c_otherwise_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t                <td><input class=\"inputleft\" name=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\" type=\"radio\" value=\"true\" />Lahy</td>\r\n");
        out.write("\t                <td><input class=\"inputleft\" name=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\" type=\"radio\" value=\"false\" checked />Vavy</td>\r\n");
        out.write("\t              ");
        int evalDoAfterBody = _jspx_th_c_otherwise_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_otherwise_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
      return true;
    }
    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
    return false;
  }

  private boolean _jspx_meth_ajax_autocomplete_2(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_bind_10, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_bind_10)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ajax:autocomplete
    org.ajaxtags.tags.AjaxAutocompleteTag _jspx_th_ajax_autocomplete_2 = (org.ajaxtags.tags.AjaxAutocompleteTag) _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.get(org.ajaxtags.tags.AjaxAutocompleteTag.class);
    _jspx_th_ajax_autocomplete_2.setPageContext(_jspx_page_context);
    _jspx_th_ajax_autocomplete_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_bind_10);
    _jspx_th_ajax_autocomplete_2.setSource("firaisanaCinLabel");
    _jspx_th_ajax_autocomplete_2.setTarget("firaisanaCinID");
    _jspx_th_ajax_autocomplete_2.setBaseUrl("firaisanaAutoCompletion.htm");
    _jspx_th_ajax_autocomplete_2.setClassName("autocomplete");
    _jspx_th_ajax_autocomplete_2.setIndicator("indicatorFiraisanaCinID");
    _jspx_th_ajax_autocomplete_2.setMinimumCharacters("2");
    int _jspx_eval_ajax_autocomplete_2 = _jspx_th_ajax_autocomplete_2.doStartTag();
    if (_jspx_th_ajax_autocomplete_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_2);
      return true;
    }
    _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_2);
    return false;
  }

  private boolean _jspx_meth_ajax_autocomplete_3(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_bind_12, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_bind_12)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ajax:autocomplete
    org.ajaxtags.tags.AjaxAutocompleteTag _jspx_th_ajax_autocomplete_3 = (org.ajaxtags.tags.AjaxAutocompleteTag) _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.get(org.ajaxtags.tags.AjaxAutocompleteTag.class);
    _jspx_th_ajax_autocomplete_3.setPageContext(_jspx_page_context);
    _jspx_th_ajax_autocomplete_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_bind_12);
    _jspx_th_ajax_autocomplete_3.setSource("firaisanaNanoloinaCinLabel");
    _jspx_th_ajax_autocomplete_3.setTarget("firaisanaNanoloinaCinID");
    _jspx_th_ajax_autocomplete_3.setBaseUrl("firaisanaAutoCompletion.htm");
    _jspx_th_ajax_autocomplete_3.setClassName("autocomplete");
    _jspx_th_ajax_autocomplete_3.setIndicator("indicatorFiraisanaNanoloinaCinID");
    _jspx_th_ajax_autocomplete_3.setMinimumCharacters("2");
    int _jspx_eval_ajax_autocomplete_3 = _jspx_th_ajax_autocomplete_3.doStartTag();
    if (_jspx_th_ajax_autocomplete_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_3);
      return true;
    }
    _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_3);
    return false;
  }

  private boolean _jspx_meth_ajax_autocomplete_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ajax:autocomplete
    org.ajaxtags.tags.AjaxAutocompleteTag _jspx_th_ajax_autocomplete_4 = (org.ajaxtags.tags.AjaxAutocompleteTag) _jspx_tagPool_ajax_autocomplete_target_source_parameters_minimumCharacters_indicator_className_baseUrl_nobody.get(org.ajaxtags.tags.AjaxAutocompleteTag.class);
    _jspx_th_ajax_autocomplete_4.setPageContext(_jspx_page_context);
    _jspx_th_ajax_autocomplete_4.setParent(null);
    _jspx_th_ajax_autocomplete_4.setSource("mpivavakaRayAnarana");
    _jspx_th_ajax_autocomplete_4.setTarget("rayID");
    _jspx_th_ajax_autocomplete_4.setBaseUrl("mpivavakaAutoCompletion.htm");
    _jspx_th_ajax_autocomplete_4.setParameters((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("excluMpivavakaID=${formChristian.mpivavaka.id},lehilahy=1", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
    _jspx_th_ajax_autocomplete_4.setClassName("autocomplete");
    _jspx_th_ajax_autocomplete_4.setIndicator("indicatorRayID");
    _jspx_th_ajax_autocomplete_4.setMinimumCharacters("1");
    int _jspx_eval_ajax_autocomplete_4 = _jspx_th_ajax_autocomplete_4.doStartTag();
    if (_jspx_th_ajax_autocomplete_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ajax_autocomplete_target_source_parameters_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_4);
      return true;
    }
    _jspx_tagPool_ajax_autocomplete_target_source_parameters_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_4);
    return false;
  }

  private boolean _jspx_meth_ajax_autocomplete_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ajax:autocomplete
    org.ajaxtags.tags.AjaxAutocompleteTag _jspx_th_ajax_autocomplete_5 = (org.ajaxtags.tags.AjaxAutocompleteTag) _jspx_tagPool_ajax_autocomplete_target_source_parameters_minimumCharacters_indicator_className_baseUrl_nobody.get(org.ajaxtags.tags.AjaxAutocompleteTag.class);
    _jspx_th_ajax_autocomplete_5.setPageContext(_jspx_page_context);
    _jspx_th_ajax_autocomplete_5.setParent(null);
    _jspx_th_ajax_autocomplete_5.setSource("mpivavakaRenyAnarana");
    _jspx_th_ajax_autocomplete_5.setTarget("renyID");
    _jspx_th_ajax_autocomplete_5.setBaseUrl("mpivavakaAutoCompletion.htm");
    _jspx_th_ajax_autocomplete_5.setParameters((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("excluMpivavakaID=${formChristian.mpivavaka.id},lehilahy=0", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
    _jspx_th_ajax_autocomplete_5.setClassName("autocomplete");
    _jspx_th_ajax_autocomplete_5.setIndicator("indicatorRenyID");
    _jspx_th_ajax_autocomplete_5.setMinimumCharacters("1");
    int _jspx_eval_ajax_autocomplete_5 = _jspx_th_ajax_autocomplete_5.doStartTag();
    if (_jspx_th_ajax_autocomplete_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ajax_autocomplete_target_source_parameters_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_5);
      return true;
    }
    _jspx_tagPool_ajax_autocomplete_target_source_parameters_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_5);
    return false;
  }

  private boolean _jspx_meth_ajax_autocomplete_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ajax:autocomplete
    org.ajaxtags.tags.AjaxAutocompleteTag _jspx_th_ajax_autocomplete_6 = (org.ajaxtags.tags.AjaxAutocompleteTag) _jspx_tagPool_ajax_autocomplete_target_source_parameters_minimumCharacters_indicator_className_baseUrl_nobody.get(org.ajaxtags.tags.AjaxAutocompleteTag.class);
    _jspx_th_ajax_autocomplete_6.setPageContext(_jspx_page_context);
    _jspx_th_ajax_autocomplete_6.setParent(null);
    _jspx_th_ajax_autocomplete_6.setSource("mpivavakaVadyAnarana");
    _jspx_th_ajax_autocomplete_6.setTarget("vadyID");
    _jspx_th_ajax_autocomplete_6.setBaseUrl("mpivavakaAutoCompletion.htm");
    _jspx_th_ajax_autocomplete_6.setParameters((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("excluMpivavakaID=${formChristian.mpivavaka.id},excluLehilahy=${formChristian.lahy}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
    _jspx_th_ajax_autocomplete_6.setClassName("autocomplete");
    _jspx_th_ajax_autocomplete_6.setIndicator("indicatorVadyID");
    _jspx_th_ajax_autocomplete_6.setMinimumCharacters("1");
    int _jspx_eval_ajax_autocomplete_6 = _jspx_th_ajax_autocomplete_6.doStartTag();
    if (_jspx_th_ajax_autocomplete_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ajax_autocomplete_target_source_parameters_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_6);
      return true;
    }
    _jspx_tagPool_ajax_autocomplete_target_source_parameters_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_6);
    return false;
  }

  private boolean _jspx_meth_ajax_autocomplete_7(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_bind_20, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_bind_20)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ajax:autocomplete
    org.ajaxtags.tags.AjaxAutocompleteTag _jspx_th_ajax_autocomplete_7 = (org.ajaxtags.tags.AjaxAutocompleteTag) _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.get(org.ajaxtags.tags.AjaxAutocompleteTag.class);
    _jspx_th_ajax_autocomplete_7.setPageContext(_jspx_page_context);
    _jspx_th_ajax_autocomplete_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_bind_20);
    _jspx_th_ajax_autocomplete_7.setSource("fitandremanaFanambadianaLabel");
    _jspx_th_ajax_autocomplete_7.setTarget("fitandremanaFanambadianaID");
    _jspx_th_ajax_autocomplete_7.setBaseUrl("fitandremanaAutoCompletion.htm");
    _jspx_th_ajax_autocomplete_7.setClassName("autocomplete");
    _jspx_th_ajax_autocomplete_7.setIndicator("indicatorFitandremanaFanambadianaID");
    _jspx_th_ajax_autocomplete_7.setMinimumCharacters("1");
    int _jspx_eval_ajax_autocomplete_7 = _jspx_th_ajax_autocomplete_7.doStartTag();
    if (_jspx_th_ajax_autocomplete_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_7);
      return true;
    }
    _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_7);
    return false;
  }

  private boolean _jspx_meth_ajax_autocomplete_8(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_bind_22, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_bind_22)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ajax:autocomplete
    org.ajaxtags.tags.AjaxAutocompleteTag _jspx_th_ajax_autocomplete_8 = (org.ajaxtags.tags.AjaxAutocompleteTag) _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.get(org.ajaxtags.tags.AjaxAutocompleteTag.class);
    _jspx_th_ajax_autocomplete_8.setPageContext(_jspx_page_context);
    _jspx_th_ajax_autocomplete_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_bind_22);
    _jspx_th_ajax_autocomplete_8.setSource("antonAsaLabel");
    _jspx_th_ajax_autocomplete_8.setTarget("antonAsaID");
    _jspx_th_ajax_autocomplete_8.setBaseUrl("antonAsaAutoCompletion.htm");
    _jspx_th_ajax_autocomplete_8.setClassName("autocomplete");
    _jspx_th_ajax_autocomplete_8.setIndicator("indicatorAntonAsaID");
    _jspx_th_ajax_autocomplete_8.setMinimumCharacters("2");
    int _jspx_eval_ajax_autocomplete_8 = _jspx_th_ajax_autocomplete_8.doStartTag();
    if (_jspx_th_ajax_autocomplete_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_8);
      return true;
    }
    _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_8);
    return false;
  }

  private boolean _jspx_meth_ajax_autocomplete_9(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_bind_24, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_bind_24)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ajax:autocomplete
    org.ajaxtags.tags.AjaxAutocompleteTag _jspx_th_ajax_autocomplete_9 = (org.ajaxtags.tags.AjaxAutocompleteTag) _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.get(org.ajaxtags.tags.AjaxAutocompleteTag.class);
    _jspx_th_ajax_autocomplete_9.setPageContext(_jspx_page_context);
    _jspx_th_ajax_autocomplete_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_bind_24);
    _jspx_th_ajax_autocomplete_9.setSource("firaisanaLabel");
    _jspx_th_ajax_autocomplete_9.setTarget("firaisanaID");
    _jspx_th_ajax_autocomplete_9.setBaseUrl("firaisanaAutoCompletion.htm");
    _jspx_th_ajax_autocomplete_9.setClassName("autocomplete");
    _jspx_th_ajax_autocomplete_9.setIndicator("indicatorFiraisanaID");
    _jspx_th_ajax_autocomplete_9.setMinimumCharacters("2");
    int _jspx_eval_ajax_autocomplete_9 = _jspx_th_ajax_autocomplete_9.doStartTag();
    if (_jspx_th_ajax_autocomplete_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_9);
      return true;
    }
    _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_9);
    return false;
  }

  private boolean _jspx_meth_ajax_autocomplete_10(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_bind_25, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_bind_25)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ajax:autocomplete
    org.ajaxtags.tags.AjaxAutocompleteTag _jspx_th_ajax_autocomplete_10 = (org.ajaxtags.tags.AjaxAutocompleteTag) _jspx_tagPool_ajax_autocomplete_target_source_parameters_minimumCharacters_indicator_className_baseUrl_nobody.get(org.ajaxtags.tags.AjaxAutocompleteTag.class);
    _jspx_th_ajax_autocomplete_10.setPageContext(_jspx_page_context);
    _jspx_th_ajax_autocomplete_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_bind_25);
    _jspx_th_ajax_autocomplete_10.setSource("faritraLabel");
    _jspx_th_ajax_autocomplete_10.setTarget("faritraID");
    _jspx_th_ajax_autocomplete_10.setBaseUrl("faritraAutoCompletion.htm");
    _jspx_th_ajax_autocomplete_10.setParameters("firaisanaID={firaisanaID}");
    _jspx_th_ajax_autocomplete_10.setClassName("autocomplete");
    _jspx_th_ajax_autocomplete_10.setIndicator("indicatorFaritraID");
    _jspx_th_ajax_autocomplete_10.setMinimumCharacters("2");
    int _jspx_eval_ajax_autocomplete_10 = _jspx_th_ajax_autocomplete_10.doStartTag();
    if (_jspx_th_ajax_autocomplete_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ajax_autocomplete_target_source_parameters_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_10);
      return true;
    }
    _jspx_tagPool_ajax_autocomplete_target_source_parameters_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_10);
    return false;
  }
}
