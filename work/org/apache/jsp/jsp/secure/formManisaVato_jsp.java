package org.apache.jsp.jsp.secure;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.Map;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.util.Utils;
import mg.fjkm.ankadifotsy.form.FormManisaVato;

public final class formManisaVato_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


FormManisaVato formManisaVato;

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(5);
    _jspx_dependants.add("/jsp/include.jsp");
    _jspx_dependants.add("/WEB-INF/tlds/c.tld");
    _jspx_dependants.add("/WEB-INF/tlds/fmt.tld");
    _jspx_dependants.add("/WEB-INF/tlds/ajaxtags.tld");
    _jspx_dependants.add("/messageManisaVato.jsp");
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
