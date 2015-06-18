package org.apache.jsp.jsp.secure;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.Map;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.util.Utils;
import mg.fjkm.ankadifotsy.bo.FanisamBato;
import mg.fjkm.ankadifotsy.bo.Fifidianana;

public final class vokatraMisarakaAjax_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


List<Map<String, Object>> mapLaharanaAnaranaVavy2Vato, mapLaharanaAnaranaLahy2Vato;
Long fifidiananaId;
FanisamBato fanisamBatoVehivavy, fanisamBatoLehilahy;
int nbRows;

  private static java.util.List _jspx_dependants;

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
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

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

mapLaharanaAnaranaVavy2Vato = (List<Map<String, Object>>)request.getAttribute(ConstantUtils.sfDATA_VALINY_FIFIDIANANA_VEHIVAVY);
mapLaharanaAnaranaLahy2Vato = (List<Map<String, Object>>)request.getAttribute(ConstantUtils.sfDATA_VALINY_FIFIDIANANA_LEHILAHY);
nbRows = mapLaharanaAnaranaVavy2Vato.size() > mapLaharanaAnaranaLahy2Vato.size() ? mapLaharanaAnaranaVavy2Vato.size() : mapLaharanaAnaranaLahy2Vato.size();
fifidiananaId = ((Fifidianana)request.getAttribute(ConstantUtils.sfREQUEST_FIFIDIANANA)).getId();
fanisamBatoVehivavy = (FanisamBato)request.getAttribute(ConstantUtils.sfDATA_FANISAMBATO_VEHIVAVY);
fanisamBatoLehilahy = (FanisamBato)request.getAttribute(ConstantUtils.sfDATA_FANISAMBATO_LEHILAHY);

      out.write("\r\n");
      out.write("      \r\n");
      out.write("    <table width=\"90%\" border=\"1\" align=\"center\">      \r\n");
      out.write("      <tr>\r\n");
      out.write("        <td colspan=\"2\">\r\n");
      out.write("          <div id=\"pejyId\"><b>PEJY : ");
      out.print((Integer)request.getAttribute(ConstantUtils.sfDATA_PAGE_NO)+1 );
      out.write("</b></div>\r\n");
      out.write("        </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      \r\n");
      out.write("      <tr bgcolor=\"#3333CC\" style=\"color:#FFFFFF\">\r\n");
      out.write("        <td width=\"50%\">\r\n");
      out.write("          <table border=\"0\" width=\"100%\">\r\n");
      out.write("            <tr bgcolor=\"#3333CC\" style=\"color:#FFFFFF\">\r\n");
      out.write("              <td colspan=\"2\">Isan'ny vato </td>\r\n");
      out.write("              <td>rehetra :</td>\r\n");
      out.write("              <td> ");
      out.print(fanisamBatoVehivavy.getIsamBatoVoaisa());
      out.write("</td>\r\n");
      out.write("              <td>&nbsp;</td>\r\n");
      out.write("              <td>manankery :</td>\r\n");
      out.write("              <td> ");
      out.print(fanisamBatoVehivavy.getIsamBatoManankery());
      out.write(" </td>\r\n");
      out.write("              <td>&nbsp;</td>\r\n");
      out.write("              <td>maty :</td>\r\n");
      out.write("              <td> ");
      out.print(fanisamBatoVehivavy.getIsamBatoMaty());
      out.write(" </td>\r\n");
      out.write("              <td>&nbsp;</td>\r\n");
      out.write("              <td>fotsy :</td>\r\n");
      out.write("              <td>");
      out.print(fanisamBatoVehivavy.getIsamBatoFotsy());
      out.write("</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("          </table>\r\n");
      out.write("        </td>      \r\n");
      out.write("        <td width=\"50%\">\r\n");
      out.write("          <table border=\"0\" width=\"100%\">\r\n");
      out.write("            <tr bgcolor=\"#3333CC\" style=\"color:#FFFFFF\">\r\n");
      out.write("              <td colspan=\"2\">Isan'ny vato </td>\r\n");
      out.write("              <td>rehetra :</td>\r\n");
      out.write("              <td> ");
      out.print(fanisamBatoLehilahy.getIsamBatoVoaisa());
      out.write("</td>\r\n");
      out.write("              <td>&nbsp;</td>\r\n");
      out.write("              <td>manankery :</td>\r\n");
      out.write("              <td> ");
      out.print(fanisamBatoLehilahy.getIsamBatoManankery());
      out.write(" </td>\r\n");
      out.write("              <td>&nbsp;</td>\r\n");
      out.write("              <td>maty :</td>\r\n");
      out.write("              <td> ");
      out.print(fanisamBatoLehilahy.getIsamBatoMaty());
      out.write(" </td>\r\n");
      out.write("              <td>&nbsp;</td>\r\n");
      out.write("              <td>fotsy :</td>\r\n");
      out.write("              <td>");
      out.print(fanisamBatoLehilahy.getIsamBatoFotsy());
      out.write("</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("          </table>\r\n");
      out.write("        </td>      \r\n");
      out.write("      </tr>\r\n");
      out.write("      \r\n");
      out.write("      <tr>\r\n");
      out.write("        <td width=\"50%\">\r\n");
      out.write("          <table width=\"100%\" border=\"0\">\r\n");
      out.write("          <thead bgcolor=\"#0000CC\" style=\"color:#FFFFFF\"><td width=\"5%\">&nbsp;</td><td width=\"8%\">Laharan'ny mpirotsaka</td><td width=\"25%\">Anarana</td><td width=\"27%\">Fanampiny</td><td width=\"9%\">Vato</td></thead>\r\n");
      out.write("          <tbody>\r\n");
      out.write("          <!-- Affichage des résultats provisoire par Ajax pour les Diakona vehivavy -->\r\n");
      out.write("          \r\n");
      out.write("          ");

          for (int i=0; i < nbRows; i++){
        	if (i < mapLaharanaAnaranaVavy2Vato.size()){
        	  Map<String, Object> m = mapLaharanaAnaranaVavy2Vato.get(i);
          
      out.write("\r\n");
      out.write("          <tr ");
      out.print( i % 2 == 0 ? "bgcolor='#66CCFF'":"bgcolor='#C0C0C0'" );
      out.write(">\r\n");
      out.write("            <td><img src=\"");
      out.print(request.getContextPath());
      out.write('/');
      out.print(Utils.getPhotoName(request, (String)m.get("anarana"), (Long)m.get("mpivavakaId"), (Boolean)m.get("lahy")));
      out.write("\" width=\"50\" height=\"50\"/></td>\r\n");
      out.write("            <td align=\"center\">");
      out.print(m.get("laharana") );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print(m.get("anarana") );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print(m.get("fanampiny") );
      out.write("</td>\r\n");
      out.write("            <td align=\"right\">");
      out.print(m.get("vato") );
      out.write("</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          ");

        	}
        	else{
          
      out.write("\r\n");
      out.write("          <tr ");
      out.print( i % 2 == 0 ? "bgcolor='#66CCFF'":"bgcolor='#C0C0C0'" );
      out.write(">\r\n");
      out.write("            <td><img src=\"");
      out.print(request.getContextPath());
      out.write('/');
      out.print(Utils.getPhotoName(request, "", -1L, false));
      out.write("\" width=\"50\" height=\"50\"/></td>\r\n");
      out.write("            <td align=\"center\">&nbsp;</td>\r\n");
      out.write("            <td>&nbsp;</td>\r\n");
      out.write("            <td>&nbsp;</td>\r\n");
      out.write("            <td align=\"right\">&nbsp;</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          ");

        	}
          }
          
      out.write("\r\n");
      out.write("          </tbody>\r\n");
      out.write("          </table>\r\n");
      out.write("        </td>\r\n");
      out.write("\r\n");
      out.write("        <td width=\"50%\">\r\n");
      out.write("          <table width=\"100%\" border=\"0\">\r\n");
      out.write("          <thead bgcolor=\"#0000CC\" style=\"color:#FFFFFF\"><td width=\"5%\">&nbsp;</td><td width=\"8%\">Laharan'ny mpirotsaka</td><td width=\"25%\">Anarana</td><td width=\"27%\">Fanampiny</td><td width=\"9%\">Vato</td></thead>\r\n");
      out.write("          <tbody>\r\n");
      out.write("          ");

          for (int i=0; i < nbRows; i++){
        	if (i < mapLaharanaAnaranaLahy2Vato.size()){
        	  Map<String, Object> m = mapLaharanaAnaranaLahy2Vato.get(i);
          
      out.write("\r\n");
      out.write("          <tr ");
      out.print( i % 2 == 0 ? "bgcolor='#66CCFF'":"bgcolor='#C0C0C0'" );
      out.write(">\r\n");
      out.write("            <td><img src=\"");
      out.print(request.getContextPath());
      out.write('/');
      out.print(Utils.getPhotoName(request, (String)m.get("anarana"), (Long)m.get("mpivavakaId"), (Boolean)m.get("lahy")));
      out.write("\" width=\"50\" height=\"50\"/></td>\r\n");
      out.write("            <td align=\"center\">");
      out.print(m.get("laharana") );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print(m.get("anarana") );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print(m.get("fanampiny") );
      out.write("</td>\r\n");
      out.write("            <td align=\"right\">");
      out.print(m.get("vato") );
      out.write("</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          ");

        	}
        	else{
          
      out.write("\r\n");
      out.write("          <tr ");
      out.print( i % 2 == 0 ? "bgcolor='#66CCFF'":"bgcolor='#C0C0C0'" );
      out.write(">\r\n");
      out.write("            <td><img src=\"");
      out.print(request.getContextPath());
      out.write('/');
      out.print(Utils.getPhotoName(request, "", -1L, true));
      out.write("\" width=\"50\" height=\"50\"/></td>\r\n");
      out.write("            <td align=\"center\">&nbsp;</td>\r\n");
      out.write("            <td>&nbsp;</td>\r\n");
      out.write("            <td>&nbsp;</td>\r\n");
      out.write("            <td align=\"right\">&nbsp;</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          ");

        	}
          }
          
      out.write("\r\n");
      out.write("          </tbody>\r\n");
      out.write("          </table>\r\n");
      out.write("        </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      \r\n");
      out.write("    </table>\r\n");
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
