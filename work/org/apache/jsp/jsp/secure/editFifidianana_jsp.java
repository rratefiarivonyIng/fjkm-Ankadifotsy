package org.apache.jsp.jsp.secure;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.util.Utils;
import mg.fjkm.ankadifotsy.bo.Fifidianana;
import mg.fjkm.ankadifotsy.form.FormFifidianana;
import mg.fjkm.ankadifotsy.util.Utils;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.bo.SaveableEntity;

public final class editFifidianana_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


	FormFifidianana formFifidianana;

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(9);
    _jspx_dependants.add("/jsp/include.jsp");
    _jspx_dependants.add("/WEB-INF/tlds/c.tld");
    _jspx_dependants.add("/WEB-INF/tlds/fmt.tld");
    _jspx_dependants.add("/WEB-INF/tlds/ajaxtags.tld");
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/jsp/ajaxInclude.jsp");
    _jspx_dependants.add("/onglet.jsp");
    _jspx_dependants.add("/jsp/secure/infoCreation.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_spring_bind_path;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_otherwise;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_spring_bind_path = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_otherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_spring_bind_path.release();
    _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_c_when_test.release();
    _jspx_tagPool_c_otherwise.release();
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
      out.write("\r\n");
      out.write("\tfunction checkFifidiananaOlonaMaro(){\r\n");
      out.write("\t\tif (document.getElementsByName('fifidiananaOloTokana')[0].checked)\r\n");
      out.write("\t\t\tdocument.getElementById('fifidiananaOlonaMaroId').style.display = 'none';\r\n");
      out.write("\t\telse\r\n");
      out.write("\t\t\tdocument.getElementById('fifidiananaOlonaMaroId').style.display = 'block';\r\n");
      out.write("\t}\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<!-- debut corps -->\r\n");
      out.write('\r');
      out.write('\n');

	formFifidianana = (FormFifidianana)request.getAttribute(FormFifidianana.sfFORM_ID);

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
      out.write("    \r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>\r\n");
      out.write("\t  <div class=\"title1\">Fifidianana : </div><br>\r\n");
      out.write("\t</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  \r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>\r\n");
      out.write("    <table border=\"1\" width=\"65%\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td>\r\n");
      out.write("\t      <form id=\"formFifidianana\" name=\"formFifidianana\" method=\"post\" action=\"editFifidianana.htm\">\r\n");
      out.write("          <table width=\"100%\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("            <tr>\r\n");
      out.write("\t          <td width=\"40%\">Anaran'ny fifidianana *:</td>\r\n");
      out.write("\t          <td width=\"60%\">\r\n");
      out.write("              ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_0 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_0.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_0.setParent(null);
      _jspx_th_spring_bind_0.setPath("formFifidianana.label");
      int[] _jspx_push_body_count_spring_bind_0 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_0 = _jspx_th_spring_bind_0.doStartTag();
        if (_jspx_eval_spring_bind_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("                <input class=\"inputleft\" id=\"labelId\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" type=\"text\" size=\"22\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("                <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("              ");
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
      out.write("\t          </td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t  \r\n");
      out.write("            <tr>\r\n");
      out.write("              <td title=\"Karazana fifidianana\">Karazany *</td>\r\n");
      out.write("              <td>\r\n");
      out.write("              ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_1 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_1.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_1.setParent(null);
      _jspx_th_spring_bind_1.setPath("formFifidianana.karazamPifidianana");
      int[] _jspx_push_body_count_spring_bind_1 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_1 = _jspx_th_spring_bind_1.doStartTag();
        if (_jspx_eval_spring_bind_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("     \t      <!-- la saisie à autocompléter -->\r\n");
            out.write("              <input class=\"inputleft\" id=\"karazamPifidiananaLabel\" name=\"karazamPifidiananaLabel\" type=\"text\" size=\"22\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formFifidianana.karazamPifidianana.label}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("              <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->\r\n");
            out.write("              <input type=\"hidden\" id=\"karazamPifidiananaID\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formFifidianana.karazamPifidianana.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("              <span id=\"indicatorKarazamPifidiananaID\" style=\"display:none;\"><img src=\"");
            out.print(request.getContextPath());
            out.write("/images/indicator.gif\" /></span>\r\n");
            out.write("              <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("         \r\n");
            out.write("              ");
            if (_jspx_meth_ajax_autocomplete_0(_jspx_th_spring_bind_1, _jspx_page_context, _jspx_push_body_count_spring_bind_1))
              return;
            out.write("                  \r\n");
            out.write("              ");
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
      out.write("              </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("      \r\n");
      out.write("            <tr>\r\n");
      out.write("              <td align=\"left\">Fitandremana *</td>\r\n");
      out.write("              <td align=\"left\">\r\n");
      out.write("              ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_2 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_2.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_2.setParent(null);
      _jspx_th_spring_bind_2.setPath("formFifidianana.fitandremana");
      int[] _jspx_push_body_count_spring_bind_2 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_2 = _jspx_th_spring_bind_2.doStartTag();
        if (_jspx_eval_spring_bind_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("    \t      <!-- la saisie à autocompléter -->\r\n");
            out.write("              <input class=\"inputleft\" id=\"fitandremanaLabel\" name=\"fitandremanaLabel\" type=\"text\" size=\"22\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formFifidianana.fitandremana.label}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("              <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->\r\n");
            out.write("              <input type=\"hidden\" id=\"fitandremanaID\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formFifidianana.fitandremana.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("              <span id=\"indicatorFitandremanaID\" style=\"display:none;\"><img src=\"");
            out.print(request.getContextPath());
            out.write("/images/indicator.gif\" /></span>\r\n");
            out.write("              <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("        \r\n");
            out.write("              ");
            if (_jspx_meth_ajax_autocomplete_1(_jspx_th_spring_bind_2, _jspx_page_context, _jspx_push_body_count_spring_bind_2))
              return;
            out.write("                  \r\n");
            out.write("              ");
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
      out.write("              </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("\t  \r\n");
      out.write("            <tr>\r\n");
      out.write("              <td>TaomPanompoana *</td>\r\n");
      out.write("              <td>\r\n");
      out.write("                ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_3 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_3.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_3.setParent(null);
      _jspx_th_spring_bind_3.setPath("formFifidianana.taomPanompoana");
      int[] _jspx_push_body_count_spring_bind_3 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_3 = _jspx_th_spring_bind_3.doStartTag();
        if (_jspx_eval_spring_bind_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("      \t        <!-- la saisie à autocompléter -->\r\n");
            out.write("                <input class=\"inputleft\" id=\"taomPanompoanaLabel\" name=\"taomPanompoanaLabel\" type=\"text\" size=\"22\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formFifidianana.taomPanompoana}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("                <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->\r\n");
            out.write("                <input type=\"hidden\" id=\"taomPanompoanaID\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formFifidianana.taomPanompoana.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("                <span id=\"indicatorTaomPanompoanaID\" style=\"display:none;\"><img src=\"");
            out.print(request.getContextPath());
            out.write("/images/indicator.gif\" /></span>\r\n");
            out.write("                <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("          \r\n");
            out.write("                ");
            if (_jspx_meth_ajax_autocomplete_2(_jspx_th_spring_bind_3, _jspx_page_context, _jspx_push_body_count_spring_bind_3))
              return;
            out.write("                  \r\n");
            out.write("                ");
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
      out.write("              </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t          <td>Daty manomboka ny firotsahana *:</td>\r\n");
      out.write("\t          <td>\r\n");
      out.write("                ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_4 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_4.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_4.setParent(null);
      _jspx_th_spring_bind_4.setPath("formFifidianana.datyManombokaFirotsahana");
      int[] _jspx_push_body_count_spring_bind_4 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_4 = _jspx_th_spring_bind_4.doStartTag();
        if (_jspx_eval_spring_bind_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("                <input name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" type=\"text\" id=\"datyManombokaFirotsahana\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" size=\"10\" class=\"inputleft\" />\r\n");
            out.write("                <img src=\"");
            out.print(request.getContextPath());
            out.write("/images/icon_calendar.gif\" id=\"imgDateManombokaFirotsahana\" width=\"16\" height=\"16\" />\r\n");
            out.write("                <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("                ");
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
      out.write("              </td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t          <td>Daty mamarana ny firotsahana *: </td>\r\n");
      out.write("\t          <td>\r\n");
      out.write("                ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_5 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_5.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_5.setParent(null);
      _jspx_th_spring_bind_5.setPath("formFifidianana.datyMamaranaFirotsahana");
      int[] _jspx_push_body_count_spring_bind_5 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_5 = _jspx_th_spring_bind_5.doStartTag();
        if (_jspx_eval_spring_bind_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("                <input name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" type=\"text\" id=\"datyMamaranaFirotsahana\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" size=\"10\" class=\"inputleft\" />\r\n");
            out.write("                <img src=\"");
            out.print(request.getContextPath());
            out.write("/images/icon_calendar.gif\" id=\"imgDateMamaranaFirotsahana\" width=\"16\" height=\"16\" />\r\n");
            out.write("                <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("                ");
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
      out.write("              </td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t          <td>Daty fifidianana *: </td>\r\n");
      out.write("\t          <td>\r\n");
      out.write("                ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_6 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_6.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_6.setParent(null);
      _jspx_th_spring_bind_6.setPath("formFifidianana.datyFifidianana");
      int[] _jspx_push_body_count_spring_bind_6 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_6 = _jspx_th_spring_bind_6.doStartTag();
        if (_jspx_eval_spring_bind_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("                <input name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" type=\"text\" id=\"datyFifidianana\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" size=\"10\" class=\"inputleft\" />\r\n");
            out.write("                <img src=\"");
            out.print(request.getContextPath());
            out.write("/images/icon_calendar.gif\" id=\"imgDateFifidianana\" width=\"16\" height=\"16\" />\r\n");
            out.write("                <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("                ");
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
      out.write("              </td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t          <td>Daty manakatona : </td>\r\n");
      out.write("\t          <td>\r\n");
      out.write("                ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_7 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_7.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_7.setParent(null);
      _jspx_th_spring_bind_7.setPath("formFifidianana.datyManakatona");
      int[] _jspx_push_body_count_spring_bind_7 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_7 = _jspx_th_spring_bind_7.doStartTag();
        if (_jspx_eval_spring_bind_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("                <input name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" type=\"text\" id=\"datyManakatona\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" size=\"10\" class=\"inputleft\" />\r\n");
            out.write("                <img src=\"");
            out.print(request.getContextPath());
            out.write("/images/icon_calendar.gif\" id=\"imgDateManakatona\" width=\"16\" height=\"16\" />\r\n");
            out.write("                <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("                ");
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
      out.write("              </td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("      \r\n");
      out.write("      \t\t<tr>\r\n");
      out.write("      \t\t  <td>Fifidianana olo-tokana *:</td>\r\n");
      out.write("      \t\t  <td>\r\n");
      out.write("      \t\t    <table>\r\n");
      out.write("      \t\t      ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_8 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_8.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_8.setParent(null);
      _jspx_th_spring_bind_8.setPath("formFifidianana.fifidiananaOloTokana");
      int[] _jspx_push_body_count_spring_bind_8 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_8 = _jspx_th_spring_bind_8.doStartTag();
        if (_jspx_eval_spring_bind_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("      \t\t      <tr>\r\n");
            out.write("\t              ");
            if (_jspx_meth_c_choose_0(_jspx_th_spring_bind_8, _jspx_page_context, _jspx_push_body_count_spring_bind_8))
              return;
            out.write("\r\n");
            out.write("      \t\t      </tr>\r\n");
            out.write("      \t\t      ");
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
      out.write("      \t\t    </table>\r\n");
      out.write("      \t\t  </td>\r\n");
      out.write("      \t\t</tr>\r\n");
      out.write("      \t\t      \t\t\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td colspan=\"2\">\r\n");
      out.write("      \t\t    <div id=\"fifidiananaOlonaMaroId\" ");
      out.print( formFifidianana.isFifidiananaOloTokana() ? "style='display:none'" : "style='display:block'" );
      out.write(">\r\n");
      out.write("                <table border=\"0\" bgcolor=\"#33CCCC\">\r\n");
      out.write("                  <tr>\r\n");
      out.write("                    <td>Laharana ho an'ny mpirotsaka ho fidiana : </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("\t\t            ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_9 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_9.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_9.setParent(null);
      _jspx_th_spring_bind_9.setPath("formFifidianana.mitohyLaharana");
      int[] _jspx_push_body_count_spring_bind_9 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_9 = _jspx_th_spring_bind_9.doStartTag();
        if (_jspx_eval_spring_bind_9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("                      <table align=\"left\">\r\n");
            out.write("                        <tr>\r\n");
            out.write("\t                    ");
            if (_jspx_meth_c_choose_1(_jspx_th_spring_bind_9, _jspx_page_context, _jspx_push_body_count_spring_bind_9))
              return;
            out.write("\r\n");
            out.write("                        </tr>\r\n");
            out.write("                      </table>\r\n");
            out.write("                    ");
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
      out.write("                    </td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                  \r\n");
      out.write("                  <tr>\r\n");
      out.write("                    <td>Isan'ny olona fidiana *:</td>\r\n");
      out.write("                    ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_10 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_10.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_10.setParent(null);
      _jspx_th_spring_bind_10.setPath("formFifidianana.isaOlonaFidiana");
      int[] _jspx_push_body_count_spring_bind_10 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_10 = _jspx_th_spring_bind_10.doStartTag();
        if (_jspx_eval_spring_bind_10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("                    <td><input class=\"inputleft\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" type=\"text\" size=\"22\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" /></td>\r\n");
            out.write("                    ");
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
      out.write("                  </tr>\r\n");
      out.write("                </table>\r\n");
      out.write("                </div>\r\n");
      out.write("              </td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t  \t  \r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t          <td align=\"right\"><input name=\"Valider\" class=\"button\" id=\"boutonValider\" value=\"Miverina\" type=\"button\" onclick=\"javascript: document.location='");
      out.print(request.getContextPath());
      out.write("/secure/index.htm?");
      out.print(request.getSession().getAttribute(ConstantUtils.sfSelectedTab));
      out.write("';\" /></td>\r\n");
      out.write("\t          <td align=\"right\"><input name=\"Valider\" class=\"button\" id=\"boutonValider\" value=\"Alefa\" type=\"submit\" style=\"align:right\"/></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t\r\n");
      out.write("\t        <tr>\r\n");
      out.write("              <td colspan=\"2\">\r\n");
      out.write("              <!-- Information de création et de dernière modification -->\r\n");
      out.write("              ");
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
      out.write("\t          </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("\t\r\n");
      out.write("\t      </table>\r\n");
      out.write("          </form>\r\n");
      out.write("        \r\n");
      out.write("        </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table>\t  \r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  \r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\tCalendar.setup({\r\n");
      out.write("\t\tinputField     :    \"datyManakatona\",     // id of the input field\r\n");
      out.write("\t\tifFormat       :    \"%d/%m/%Y\",      // format of the input field\r\n");
      out.write("\t\tbutton         :    \"imgDateManakatona\",  // trigger for the calendar (button ID)\r\n");
      out.write("\t\talign          :    \"Tl\",           // alignment (defaults to \"Bl\")\r\n");
      out.write("\t\tsingleClick    :    true\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\tCalendar.setup({\r\n");
      out.write("\t\tinputField     :    \"datyFifidianana\",     // id of the input field\r\n");
      out.write("\t\tifFormat       :    \"%d/%m/%Y\",      // format of the input field\r\n");
      out.write("\t\tbutton         :    \"imgDateFifidianana\",  // trigger for the calendar (button ID)\r\n");
      out.write("\t\talign          :    \"Tl\",           // alignment (defaults to \"Bl\")\r\n");
      out.write("\t\tsingleClick    :    true\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\tCalendar.setup({\r\n");
      out.write("\t\tinputField     :    \"datyManombokaFirotsahana\",     // id of the input field\r\n");
      out.write("\t\tifFormat       :    \"%d/%m/%Y\",      // format of the input field\r\n");
      out.write("\t\tbutton         :    \"imgDateManombokaFirotsahana\",  // trigger for the calendar (button ID)\r\n");
      out.write("\t\talign          :    \"Tl\",           // alignment (defaults to \"Bl\")\r\n");
      out.write("\t\tsingleClick    :    true\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\tCalendar.setup({\r\n");
      out.write("\t\tinputField     :    \"datyMamaranaFirotsahana\",     // id of the input field\r\n");
      out.write("\t\tifFormat       :    \"%d/%m/%Y\",      // format of the input field\r\n");
      out.write("\t\tbutton         :    \"imgDateMamaranaFirotsahana\",  // trigger for the calendar (button ID)\r\n");
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

  private boolean _jspx_meth_ajax_autocomplete_0(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_bind_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_bind_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ajax:autocomplete
    org.ajaxtags.tags.AjaxAutocompleteTag _jspx_th_ajax_autocomplete_0 = (org.ajaxtags.tags.AjaxAutocompleteTag) _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.get(org.ajaxtags.tags.AjaxAutocompleteTag.class);
    _jspx_th_ajax_autocomplete_0.setPageContext(_jspx_page_context);
    _jspx_th_ajax_autocomplete_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_bind_1);
    _jspx_th_ajax_autocomplete_0.setSource("karazamPifidiananaLabel");
    _jspx_th_ajax_autocomplete_0.setTarget("karazamPifidiananaID");
    _jspx_th_ajax_autocomplete_0.setBaseUrl("karazamPifidiananaAutoCompletion.htm");
    _jspx_th_ajax_autocomplete_0.setClassName("autocomplete");
    _jspx_th_ajax_autocomplete_0.setIndicator("indicatorKarazamPifidiananaID");
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
    _jspx_th_ajax_autocomplete_1.setSource("fitandremanaLabel");
    _jspx_th_ajax_autocomplete_1.setTarget("fitandremanaID");
    _jspx_th_ajax_autocomplete_1.setBaseUrl("fitandremanaAutoCompletion.htm");
    _jspx_th_ajax_autocomplete_1.setClassName("autocomplete");
    _jspx_th_ajax_autocomplete_1.setIndicator("indicatorFitandremanaID");
    _jspx_th_ajax_autocomplete_1.setMinimumCharacters("1");
    int _jspx_eval_ajax_autocomplete_1 = _jspx_th_ajax_autocomplete_1.doStartTag();
    if (_jspx_th_ajax_autocomplete_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_1);
      return true;
    }
    _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_1);
    return false;
  }

  private boolean _jspx_meth_ajax_autocomplete_2(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_bind_3, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_bind_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ajax:autocomplete
    org.ajaxtags.tags.AjaxAutocompleteTag _jspx_th_ajax_autocomplete_2 = (org.ajaxtags.tags.AjaxAutocompleteTag) _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.get(org.ajaxtags.tags.AjaxAutocompleteTag.class);
    _jspx_th_ajax_autocomplete_2.setPageContext(_jspx_page_context);
    _jspx_th_ajax_autocomplete_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_bind_3);
    _jspx_th_ajax_autocomplete_2.setSource("taomPanompoanaLabel");
    _jspx_th_ajax_autocomplete_2.setTarget("taomPanompoanaID");
    _jspx_th_ajax_autocomplete_2.setBaseUrl("taomPanompoanaAutoCompletion.htm");
    _jspx_th_ajax_autocomplete_2.setClassName("autocomplete");
    _jspx_th_ajax_autocomplete_2.setIndicator("indicatorTaomPanompoanaID");
    _jspx_th_ajax_autocomplete_2.setMinimumCharacters("1");
    int _jspx_eval_ajax_autocomplete_2 = _jspx_th_ajax_autocomplete_2.doStartTag();
    if (_jspx_th_ajax_autocomplete_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_2);
      return true;
    }
    _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_2);
    return false;
  }

  private boolean _jspx_meth_c_choose_0(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_bind_8, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_bind_8)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_bind_8);
    int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
    if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t              ");
        if (_jspx_meth_c_when_0(_jspx_th_c_choose_0, _jspx_page_context, _jspx_push_body_count_spring_bind_8))
          return true;
        out.write("\r\n");
        out.write("\t              ");
        if (_jspx_meth_c_otherwise_0(_jspx_th_c_choose_0, _jspx_page_context, _jspx_push_body_count_spring_bind_8))
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

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_bind_8)
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
        out.write("\" type=\"radio\" value=\"true\" onclick=\"javascript:checkFifidiananaOlonaMaro();\" checked/>Eny</td>\r\n");
        out.write("\t                <td><input class=\"inputleft\" name=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\" type=\"radio\" value=\"false\" onclick=\"javascript:checkFifidiananaOlonaMaro();\" />Tsia</td>\r\n");
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

  private boolean _jspx_meth_c_otherwise_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_bind_8)
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
        out.write("\" type=\"radio\" value=\"true\" onclick=\"javascript:checkFifidiananaOlonaMaro();\" />Eny</td>\r\n");
        out.write("\t                <td><input class=\"inputleft\" name=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\" type=\"radio\" value=\"false\" onclick=\"javascript:checkFifidiananaOlonaMaro();\" checked />Tsia</td>\r\n");
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

  private boolean _jspx_meth_c_choose_1(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_bind_9, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_bind_9)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_1 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_1.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_bind_9);
    int _jspx_eval_c_choose_1 = _jspx_th_c_choose_1.doStartTag();
    if (_jspx_eval_c_choose_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t                    ");
        if (_jspx_meth_c_when_1(_jspx_th_c_choose_1, _jspx_page_context, _jspx_push_body_count_spring_bind_9))
          return true;
        out.write("\r\n");
        out.write("\t                    ");
        if (_jspx_meth_c_otherwise_1(_jspx_th_c_choose_1, _jspx_page_context, _jspx_push_body_count_spring_bind_9))
          return true;
        out.write("\r\n");
        out.write("\t                    ");
        int evalDoAfterBody = _jspx_th_c_choose_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_1);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_1);
    return false;
  }

  private boolean _jspx_meth_c_when_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_bind_9)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_1 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_1.setPageContext(_jspx_page_context);
    _jspx_th_c_when_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_1);
    _jspx_th_c_when_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_when_1 = _jspx_th_c_when_1.doStartTag();
    if (_jspx_eval_c_when_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t                      <td><input class=\"inputleft\" name=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\" type=\"radio\" value=\"true\" checked/>Mitambatra</td>\r\n");
        out.write("\t                      <td><input class=\"inputleft\" name=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\" type=\"radio\" value=\"false\" />Misaraka</td>\r\n");
        out.write("\t                    ");
        int evalDoAfterBody = _jspx_th_c_when_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
    return false;
  }

  private boolean _jspx_meth_c_otherwise_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_bind_9)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_otherwise_1 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_1.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_1);
    int _jspx_eval_c_otherwise_1 = _jspx_th_c_otherwise_1.doStartTag();
    if (_jspx_eval_c_otherwise_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t                      <td><input class=\"inputleft\" name=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\" type=\"radio\" value=\"true\" />Mitambatra</td>\r\n");
        out.write("\t                      <td><input class=\"inputleft\" name=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\" type=\"radio\" value=\"false\" checked />Misaraka</td>\r\n");
        out.write("\t                    ");
        int evalDoAfterBody = _jspx_th_c_otherwise_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_otherwise_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_1);
      return true;
    }
    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_1);
    return false;
  }
}
