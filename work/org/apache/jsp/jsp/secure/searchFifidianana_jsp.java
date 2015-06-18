package org.apache.jsp.jsp.secure;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.util.List;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.util.Utils;
import mg.fjkm.ankadifotsy.bo.Fitandremana;
import mg.fjkm.ankadifotsy.bo.Fifidianana;
import mg.fjkm.ankadifotsy.form.FormSearchFifidianana;
import mg.fjkm.ankadifotsy.util.Utils;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.bo.SaveableEntity;
import mg.fjkm.ankadifotsy.util.Utils;
import mg.fjkm.ankadifotsy.form.AbstractFormSearch;

public final class searchFifidianana_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


	FormSearchFifidianana formSearchFifidianana;


  AbstractFormSearch searchForm;

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
    _jspx_dependants.add("/jsp/secure/pagination.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_spring_bind_path;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_spring_bind_path = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_spring_bind_path.release();
    _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.release();
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
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<!-- debut corps -->\r\n");
      out.write('\r');
      out.write('\n');

	formSearchFifidianana = (FormSearchFifidianana)request.getAttribute(FormSearchFifidianana.sfFORM_ID);

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
      out.write("  \r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>Fitadiavana fifidianana : </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  \r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>\r\n");
      out.write("\t<form id=\"formSearchFifidianana\" name=\"formSearchFifidianana\" method=\"post\" action=\"searchFifidianana.htm\">\r\n");
      out.write("\t<table width=\"100%\" align=\"center\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t  <tr>\r\n");
      out.write("\t    <td colspan=\"2\">\r\n");
      out.write("\t      <table width=\"100%\"  border=\"0\">\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t          <td colspan=\"2\">\r\n");
      out.write("\t            <table width=\"90%\" border=\"0\">\r\n");
      out.write("\t              <tr>\r\n");
      out.write("\t                <td width=\"50%\" align=\"left\">Fitandremana *</td>\r\n");
      out.write("\t                <td align=\"left\">\r\n");
      out.write("\t\t\t        ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_0 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_0.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_0.setParent(null);
      _jspx_th_spring_bind_0.setPath("formSearchFifidianana.fitandremana");
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
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formSearchFifidianana.fitandremana.label}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("\t\t            <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->\r\n");
            out.write("\t\t              <input type=\"hidden\" id=\"fitandremanaID\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formSearchFifidianana.fitandremana.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
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
      out.write("\t\t            <td title=\"Karazana fifidianana\">Karazany </td>\r\n");
      out.write("\t\t            <td align=\"center\">\r\n");
      out.write("\t\t\t        ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_1 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_1.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_1.setParent(null);
      _jspx_th_spring_bind_1.setPath("formSearchFifidianana.karazamPifidianana");
      int[] _jspx_push_body_count_spring_bind_1 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_1 = _jspx_th_spring_bind_1.doStartTag();
        if (_jspx_eval_spring_bind_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("          \t        <!-- la saisie à autocompléter -->\r\n");
            out.write("\t\t              <input class=\"inputleft\" id=\"karazamPifidiananaLabel\" name=\"karazamPifidiananaLabel\" type=\"text\" size=\"22\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formSearchFifidianana.karazamPifidianana.label}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("\t\t            <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->\r\n");
            out.write("\t\t              <input type=\"hidden\" id=\"karazamPifidiananaID\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formSearchFifidianana.karazamPifidianana.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("\t\t              <span id=\"indicatorKarazamPifidiananaID\" style=\"display:none;\"><img src=\"");
            out.print(request.getContextPath());
            out.write("/images/indicator.gif\" /></span>\r\n");
            out.write("\t\t              <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("              \r\n");
            out.write("                    ");
            if (_jspx_meth_ajax_autocomplete_1(_jspx_th_spring_bind_1, _jspx_page_context, _jspx_push_body_count_spring_bind_1))
              return;
            out.write("                  \r\n");
            out.write("                    ");
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
      out.write("\t\t            </td>\r\n");
      out.write("\t              </tr>\r\n");
      out.write("\t            </table>\r\n");
      out.write("\t          </td>\r\n");
      out.write("\t          <td colspan=\"2\">\r\n");
      out.write("\t            <table width=\"100%\" border=\"0\">\r\n");
      out.write("\t              <tr>\r\n");
      out.write("\t                <td width=\"30%\">TaomPanompoana</td>\r\n");
      out.write("\t                <td colspan=\"2\">\r\n");
      out.write("\t                ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_2 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_2.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_2.setParent(null);
      _jspx_th_spring_bind_2.setPath("formSearchFifidianana.taomPanompoana");
      int[] _jspx_push_body_count_spring_bind_2 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_2 = _jspx_th_spring_bind_2.doStartTag();
        if (_jspx_eval_spring_bind_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("          \t        <!-- la saisie à autocompléter -->\r\n");
            out.write("\t\t              <input class=\"inputleft\" id=\"taomPanompoanaLabel\" name=\"taomPanompoanaLabel\" type=\"text\" size=\"22\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formSearchFifidianana.taomPanompoana}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("\t\t            <!-- le champs servant à récupérer la valeur comme s'il s'agissait d'une liste -->\r\n");
            out.write("\t\t              <input type=\"hidden\" id=\"taomPanompoanaID\" name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formSearchFifidianana.taomPanompoana.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\t\r\n");
            out.write("\t\t              <span id=\"indicatorTaomPanompoanaID\" style=\"display:none;\"><img src=\"");
            out.print(request.getContextPath());
            out.write("/images/indicator.gif\" /></span>\r\n");
            out.write("\t\t              <font color=\"red\" size=\"1.2\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.errorMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</font>\r\n");
            out.write("              \r\n");
            out.write("                    ");
            if (_jspx_meth_ajax_autocomplete_2(_jspx_th_spring_bind_2, _jspx_page_context, _jspx_push_body_count_spring_bind_2))
              return;
            out.write("                  \r\n");
            out.write("\t\t            ");
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
      out.write("\t\t\t\t    </td>\r\n");
      out.write("\t              </tr>\r\n");
      out.write("\t              <tr>\r\n");
      out.write("\t                <td>Efa Mikatona</td>\r\n");
      out.write("\t                <td colspan=\"2\">\r\n");
      out.write("\t                ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_3 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_3.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_3.setParent(null);
      _jspx_th_spring_bind_3.setPath("formSearchFifidianana.datyManakatona");
      int[] _jspx_push_body_count_spring_bind_3 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_3 = _jspx_th_spring_bind_3.doStartTag();
        if (_jspx_eval_spring_bind_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.support.BindStatus status = null;
          status = (org.springframework.web.servlet.support.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("                      <input name=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.expression}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" type=\"text\" id=\"datyMikatona\" value=\"");
            out.print(formSearchFifidianana.getDatyManakatona() != null ? Utils.sfDateFormatJJMMYYYY.format(formSearchFifidianana.getDatyManakatona()) : "");
            out.write("\" size=\"10\" class=\"inputleft\" />\r\n");
            out.write("                      <img src=\"");
            out.print(request.getContextPath());
            out.write("/images/icon_calendar.gif\" id=\"imgDateMikatona\" width=\"16\" height=\"16\" />\r\n");
            out.write("\t\t            ");
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
      out.write("                    </td>\r\n");
      out.write("\t              </tr>\r\n");
      out.write("\t            </table>\r\n");
      out.write("\t\t      </td>\r\n");
      out.write("\r\n");
      out.write("\t          <td colspan=\"2\">&nbsp;</td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("                       \r\n");
      out.write("            <tr>\r\n");
      out.write("\t          <td colspan=\"2\" align=\"left\">&nbsp;</td>\r\n");
      out.write("\t          <td>&nbsp;</td>\r\n");
      out.write("\t          <td align=\"right\"><input name=\"Valider\" class=\"button\" id=\"boutonValider\" value=\"Tadiavo\" type=\"submit\" /></td>\r\n");
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
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_4 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_4.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_4.setParent(null);
      _jspx_th_spring_bind_4.setPath("formSearchFifidianana.pageNo");
      int[] _jspx_push_body_count_spring_bind_4 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_4 = _jspx_th_spring_bind_4.doStartTag();
        if (_jspx_eval_spring_bind_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
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
      out.write("\r\n");
      out.write("    ");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_5 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_5.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_5.setParent(null);
      _jspx_th_spring_bind_5.setPath("formSearchFifidianana.from");
      int[] _jspx_push_body_count_spring_bind_5 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_5 = _jspx_th_spring_bind_5.doStartTag();
        if (_jspx_eval_spring_bind_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
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
      out.write("\t\r\n");
      out.write("    </form>\r\n");
      out.write("\t  \r\n");
      out.write("   </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("\r\n");
      out.write("   ");

  List<Fifidianana> fifidiananas = (List<Fifidianana>)request.getAttribute(ConstantUtils.sfDATA_FIFIDIANANAS);
  if (fifidiananas != null && fifidiananas.size() > 0){ 
      out.write("\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>\r\n");
      out.write("      ");
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
      out.write('\r');
      out.write('\n');

  searchForm = Utils.getCurrentSearchForm(request);

      out.write("\r\n");
      out.write("      <table width=\"100%\">\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td>  \r\n");
      out.write("            <b>Pejy ");
      out.print(searchForm.getPageNo()+1);
      out.write(' ');
      out.write('/');
      out.write(' ');
      out.print(searchForm.getNbPageTotal()+1);
      out.write("</b>\r\n");
      out.write("          </td>\r\n");
      out.write("          <td align=\"right\" width=\"50%\">\r\n");
      out.write("            <b>Pejy : &nbsp;</b>\r\n");
      out.write("            ");
  
            if (searchForm.hasPreviousPage()){
            
      out.write("\r\n");
      out.write("            &nbsp;<a href=\"javascript:loadResults('");
      out.print(searchForm.getPageNo()-1);
      out.write("' );\" title=\"pejy teo aloha\" class=\"pageLink\"><img src=\"");
      out.print(request.getContextPath());
      out.write("/images/Previous_s.png\"/></a>&nbsp;\r\n");
      out.write("            ");

            }
            
            if (searchForm.getNbPageTotal() > 1){
              for (int i=1; i<= searchForm.getNbPageTotal()+1; i++){
            
      out.write("\r\n");
      out.write("                &nbsp;\r\n");
      out.write("            ");

                if ((i-1) == searchForm.getPageNo()){
            
      out.write("\r\n");
      out.write("                <b>");
      out.print(i);
      out.write("</b>\r\n");
      out.write("            ");

                }
                else{
            
      out.write("\r\n");
      out.write("                <a href=\"javascript:loadResults('");
      out.print(i-1);
      out.write("' );\">");
      out.print(i);
      out.write("</a>\r\n");
      out.write("            ");

                }
              }
            }
            
            if (searchForm.hasNextPage()){
            
      out.write("\r\n");
      out.write("            &nbsp;<a href=\"javascript:loadResults('");
      out.print(searchForm.getPageNo()+1);
      out.write("');\" title=\"pejy manaraka\" class=\"pageLink\"><img src=\"");
      out.print(request.getContextPath());
      out.write("/images/Next_s.png\"/></a> &nbsp;\r\n");
      out.write("            ");

            }
            
      out.write("\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      </table>\r\n");
      out.write("\r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>\r\n");
      out.write("\t\t<table align=\"center\" bgcolor=\"#ffffff\" border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n");
      out.write("\t    <tr>\r\n");
      out.write("\t      <td colspan=\"4\">\r\n");
      out.write("\t        <table width=\"100%\" border=\"1\">\r\n");
      out.write("\t          <tr>\r\n");
      out.write("\t\t\t      <td width=\"12%\" bgcolor=\"#48A9D2\"><div align=\"center\" class=\"Style8\"><b>Fitandremana</b></div></td>\r\n");
      out.write("\t\t\t      <td width=\"22%\" bgcolor=\"#48A9D2\"><div align=\"center\" class=\"Style8\"><b>Karazany</b></div></td>\r\n");
      out.write("\t\t\t      <td width=\"15%\" bgcolor=\"#48A9D2\"><div align=\"center\" class=\"Style8\"><b>Taom-panompoana</b></div></td>\r\n");
      out.write("\t\t\t      <td width=\"22%\" bgcolor=\"#48A9D2\"><div align=\"center\" class=\"Style8\"><b>Mikatona</b></div></td>\r\n");
      out.write("\t\t\t  </tr>\r\n");
      out.write("\t        </table>\r\n");
      out.write("\t      </td>\r\n");
      out.write("\t    </tr>\r\n");
      out.write("        \r\n");
      out.write("        ");

        Date now = new Date();
		for (int i = 0; i < fifidiananas.size(); i++){
		    Fifidianana fifidianana = fifidiananas.get(i);
		    out.println("<tr>");
		    if (i % 2 == 0){
      out.write("\r\n");
      out.write("\t          <td width=\"12%\" bgcolor=\"#66CCFF\"><div align=\"center\" class=\"Style8\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/editFifidianana.htm?");
      out.print(ConstantUtils.sfFifidiananaId);
      out.write('=');
      out.print(fifidianana.getId());
      out.write("\" title=\"Manova ny fifidianana\">");
      out.print(fifidianana.getFitandremana().getLabel());
      out.write("</a></div></td>\r\n");
      out.write("\t          <td width=\"22%\" bgcolor=\"#66CCFF\"><div align=\"left\" class=\"Style8\"><a href=\"selectFifidianana.htm?id=");
      out.print(fifidianana.getId());
      out.write("\" title=\"Misafidy fifidianana hokirakiraina\">");
      out.print(fifidianana.getKarazamPifidianana().getLabel());
      out.write("</a></div></td>\r\n");
      out.write("\t          <td width=\"15%\" bgcolor=\"#66CCFF\"><div align=\"left\" class=\"Style8\">");
      out.print(fifidianana.getTaomPanompoana().toString());
      out.write("</div></td>\r\n");
      out.write("\t          <td width=\"22%\" bgcolor=\"#66CCFF\"><div align=\"left\" class=\"Style8\">\r\n");
      out.write("\t        ");

              if (fifidianana.isMikatona(now)){
      out.write("\r\n");
      out.write("                Eny\r\n");
      out.write("            ");

              }else{
      out.write("\r\n");
      out.write("                Tsia\r\n");
      out.write("            ");

              }
	        
      out.write("\r\n");
      out.write("\t           </div>\r\n");
      out.write("\t         </td>\r\n");
      out.write("\t        ");

		   	}
		   	else{
		   	
      out.write("\r\n");
      out.write("\t          <td width=\"12%\" bgcolor=\"#C0C0C0\"><div align=\"center\" class=\"Style8\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/editFifidianana.htm?");
      out.print(ConstantUtils.sfFifidiananaId);
      out.write('=');
      out.print(fifidianana.getId());
      out.write("\" title=\"Manova ny fifidianana\">");
      out.print(fifidianana.getFitandremana().getLabel());
      out.write("</a></div></td>\r\n");
      out.write("\t          <td width=\"22%\" bgcolor=\"#C0C0C0\"><div align=\"left\" class=\"Style8\"><a href=\"selectFifidianana.htm?id=");
      out.print(fifidianana.getId());
      out.write('"');
      out.write('>');
      out.print(fifidianana.getKarazamPifidianana().getLabel());
      out.write("</a></div></td>\r\n");
      out.write("\t          <td width=\"15%\" bgcolor=\"#C0C0C0\"><div align=\"left\" class=\"Style8\">");
      out.print(fifidianana.getTaomPanompoana().toString());
      out.write("</div></td>\r\n");
      out.write("\t          <td width=\"22%\" bgcolor=\"#C0C0C0\"><div align=\"left\" class=\"Style8\">\r\n");
      out.write("\t        ");

              if (fifidianana.isMikatona(now)){
      out.write("\r\n");
      out.write("                Eny\r\n");
      out.write("            ");

              }else{
      out.write("\r\n");
      out.write("                Tsia\r\n");
      out.write("            ");

              }
	        
      out.write("\r\n");
      out.write("\t      </div>\r\n");
      out.write("\t      </td>\r\n");
      out.write("\t\t");

		   }
		   out.println("</tr>");
		}
	}
	else{
	    if (fifidiananas != null){
	
      out.write("\r\n");
      out.write("\t <tr>\r\n");
      out.write("       <td colspan=\"5\" align=\"center\" bgcolor=\"#FF0000\">Tsy misy mifanaraka amin'ny sivana.</td>\r\n");
      out.write("\t </tr>\r\n");
      out.write("\t");

		}
	}
	
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("\t\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\tCalendar.setup({\r\n");
      out.write("\t\tinputField     :    \"datyMikatona\",     // id of the input field\r\n");
      out.write("\t\tifFormat       :    \"%d/%m/%Y\",      // format of the input field\r\n");
      out.write("\t\tbutton         :    \"imgDateMikatona\",  // trigger for the calendar (button ID)\r\n");
      out.write("\t\talign          :    \"Tl\",           // alignment (defaults to \"Bl\")\r\n");
      out.write("\t\tsingleClick    :    true\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_ajax_autocomplete_1(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_bind_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_bind_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ajax:autocomplete
    org.ajaxtags.tags.AjaxAutocompleteTag _jspx_th_ajax_autocomplete_1 = (org.ajaxtags.tags.AjaxAutocompleteTag) _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.get(org.ajaxtags.tags.AjaxAutocompleteTag.class);
    _jspx_th_ajax_autocomplete_1.setPageContext(_jspx_page_context);
    _jspx_th_ajax_autocomplete_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_bind_1);
    _jspx_th_ajax_autocomplete_1.setSource("karazamPifidiananaLabel");
    _jspx_th_ajax_autocomplete_1.setTarget("karazamPifidiananaID");
    _jspx_th_ajax_autocomplete_1.setBaseUrl("karazamPifidiananaAutoCompletion.htm");
    _jspx_th_ajax_autocomplete_1.setClassName("autocomplete");
    _jspx_th_ajax_autocomplete_1.setIndicator("indicatorKarazamPifidiananaID");
    _jspx_th_ajax_autocomplete_1.setMinimumCharacters("1");
    int _jspx_eval_ajax_autocomplete_1 = _jspx_th_ajax_autocomplete_1.doStartTag();
    if (_jspx_th_ajax_autocomplete_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_1);
      return true;
    }
    _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.reuse(_jspx_th_ajax_autocomplete_1);
    return false;
  }

  private boolean _jspx_meth_ajax_autocomplete_2(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_bind_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_bind_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ajax:autocomplete
    org.ajaxtags.tags.AjaxAutocompleteTag _jspx_th_ajax_autocomplete_2 = (org.ajaxtags.tags.AjaxAutocompleteTag) _jspx_tagPool_ajax_autocomplete_target_source_minimumCharacters_indicator_className_baseUrl_nobody.get(org.ajaxtags.tags.AjaxAutocompleteTag.class);
    _jspx_th_ajax_autocomplete_2.setPageContext(_jspx_page_context);
    _jspx_th_ajax_autocomplete_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_bind_2);
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
}
