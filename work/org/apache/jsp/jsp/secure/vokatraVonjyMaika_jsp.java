package org.apache.jsp.jsp.secure;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.Map;
import mg.fjkm.ankadifotsy.util.ConstantUtils;

public final class vokatraVonjyMaika_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


List<Map<String, Object>> mapLaharanaAnarana2Vato;

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(4);
    _jspx_dependants.add("/jsp/include.jsp");
    _jspx_dependants.add("/WEB-INF/tlds/c.tld");
    _jspx_dependants.add("/WEB-INF/tlds/fmt.tld");
    _jspx_dependants.add("/WEB-INF/tlds/ajaxtags.tld");
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
      response.setContentType("text/html");
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
      out.write('\r');
      out.write('\n');

mapLaharanaAnarana2Vato = (List<Map<String, Object>>)request.getAttribute(ConstantUtils.sfDATA_TEMP_RESULT);

      out.write("\r\n");
      out.write("\r\n");

if (mapLaharanaAnarana2Vato != null){

      out.write("\r\n");
      out.write("<table border=\"0\" width=\"100%\">\r\n");
      out.write("  ");

  for (int i = 0; i < (Integer)request.getAttribute(ConstantUtils.sfTEMP_RESULT_NBLINES); i++){
	if (i < mapLaharanaAnarana2Vato.size()){
  	  Map<String, Object> m = mapLaharanaAnarana2Vato.get(i);
	  Integer laharana = (Integer)m.get("laharana");
	  String anarana = (String)m.get("anarana");
	  Long vato = (Long)m.get("vato");
	  
	  if (i % 2 == 0){
  
      out.write("\r\n");
      out.write("  <tr bgcolor=\"#66CCFF\">\r\n");
      out.write("    <td width=\"10%\">");
      out.print(laharana);
      out.write("</td><td>");
      out.print(anarana );
      out.write("</td><td width=\"15%\" align=\"right\">[");
      out.print(vato);
      out.write("]</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  ");

	  }
	  else{
   
      out.write("\r\n");
      out.write("  <tr bgcolor=\"#C0C0C0\">\r\n");
      out.write("    <td width=\"10%\">");
      out.print(laharana);
      out.write("</td><td>");
      out.print(anarana );
      out.write("</td><td width=\"15%\" align=\"right\">[");
      out.print(vato);
      out.write("]</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("   ");

	  }
  	}
  	else{
  	  if (i % 2 == 0){
  
      out.write("\r\n");
      out.write("  <tr bgcolor=\"#66CCFF\">\r\n");
      out.write("    <td width=\"10%\">&nbsp;</td><td>&nbsp;</td><td width=\"15%\">&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  ");

  	  }
  	  else{
  
      out.write("\r\n");
      out.write("  <tr bgcolor=\"#C0C0C0\">\r\n");
      out.write("    <td width=\"10%\">&nbsp;</td><td>&nbsp;</td><td width=\"15%\">&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  ");

  	  }
  	}
  }
  
      out.write("\r\n");
      out.write("</table>\r\n");

}

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
