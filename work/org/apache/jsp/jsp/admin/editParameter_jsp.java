package org.apache.jsp.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.util.Utils;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.bo.SaveableEntity;

public final class editParameter_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(8);
    _jspx_dependants.add("/jsp/include.jsp");
    _jspx_dependants.add("/WEB-INF/tlds/c.tld");
    _jspx_dependants.add("/WEB-INF/tlds/fmt.tld");
    _jspx_dependants.add("/WEB-INF/tlds/ajaxtags.tld");
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/jsp/ajaxInclude.jsp");
    _jspx_dependants.add("/onglet.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_spring_bind_path;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_spring_bind_path = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
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
      out.write("     \t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<!-- debut corps -->\r\n");
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
      out.write("\t  <div class=\"title1\">Mikirakira ny \"paramètres\" : </div><br>\r\n");
      out.write("\t</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  \r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>\r\n");
      out.write("\t<form id=\"formParameter\" name=\"formParameter\" method=\"post\" action=\"editParameter.htm\">\r\n");
      out.write("\t<table width=\"90%\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t  <tr>\r\n");
      out.write("\t    <td>Isan'ny valin'ny fitadiavana isaky ny pejy *: </td>\r\n");
      out.write("\t    <td>\r\n");
      out.write("         ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_0 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_0.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_0.setParent(null);
      _jspx_th_spring_bind_0.setPath("formParameter.nbElementPerPage");
      int[] _jspx_push_body_count_spring_bind_0 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_0 = _jspx_th_spring_bind_0.doStartTag();
        if (_jspx_eval_spring_bind_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("\t        <input class=\"inputleft\" id=\"nbElementPerPageLabel\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" type=\"text\" size=\"22\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("\t        <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("         ");
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
      out.write("         </td>\r\n");
      out.write("\t  </tr>\r\n");
      out.write("\t  <tr>\r\n");
      out.write("\t    <td>Isan'ny mpirotsaka fidiana isaky ny pejy *: </td>\r\n");
      out.write("\t    <td>\r\n");
      out.write("         ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_1 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_1.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_1.setParent(null);
      _jspx_th_spring_bind_1.setPath("formParameter.nbMirotsakaFidianaPerPage");
      int[] _jspx_push_body_count_spring_bind_1 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_1 = _jspx_th_spring_bind_1.doStartTag();
        if (_jspx_eval_spring_bind_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("\t        <input class=\"inputleft\" id=\"nbMirotsakaFidianaPerPage\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" type=\"text\" size=\"22\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("\t        <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("         ");
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
      out.write("         </td>\r\n");
      out.write("\t  </tr>\r\n");
      out.write("\t  <tr>\r\n");
      out.write("\t    <td>Isan'ny vokatra vonjy maika *: </td>\r\n");
      out.write("\t    <td>\r\n");
      out.write("         ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_2 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_2.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_2.setParent(null);
      _jspx_th_spring_bind_2.setPath("formParameter.nbTempResultVote");
      int[] _jspx_push_body_count_spring_bind_2 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_2 = _jspx_th_spring_bind_2.doStartTag();
        if (_jspx_eval_spring_bind_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("\t        <input class=\"inputleft\" id=\"nbTempResultVoteLabel\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" type=\"text\" size=\"22\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("\t        <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("         ");
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
      out.write("         </td>\r\n");
      out.write("\t  </tr>\r\n");
      out.write("\t  \r\n");
      out.write("\t  <tr>\r\n");
      out.write("\t    <td align=\"right\"><input name=\"Valider\" class=\"button\" id=\"boutonValider\" value=\"Miverina\" type=\"button\" onclick=\"javascript: document.location='index.htm?");
      out.print(request.getSession().getAttribute(ConstantUtils.sfSelectedTab));
      out.write("';\" /></td>\r\n");
      out.write("\t    <td align=\"right\"><input name=\"Valider\" class=\"button\" id=\"boutonValider\" value=\"Alefa\" type=\"submit\" style=\"align:right\"/></td>\r\n");
      out.write("\t  </tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("    </form>\r\n");
      out.write("\t  \r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  \r\n");
      out.write("</table>\r\n");
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
}
