package org.apache.jsp.jsp.secure;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.util.Utils;
import mg.fjkm.ankadifotsy.form.FormListMirotsakaFidiana;
import mg.fjkm.ankadifotsy.util.Utils;
import mg.fjkm.ankadifotsy.form.AbstractFormSearch;

public final class listFaranyMirotsakaFidianaResultsAjax_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


	FormListMirotsakaFidiana formListMirotsakaFidiana;
	List<Map<String, Object>> listMirotsakaFidiana;


  AbstractFormSearch searchForm;

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(5);
    _jspx_dependants.add("/jsp/include.jsp");
    _jspx_dependants.add("/WEB-INF/tlds/c.tld");
    _jspx_dependants.add("/WEB-INF/tlds/fmt.tld");
    _jspx_dependants.add("/WEB-INF/tlds/ajaxtags.tld");
    _jspx_dependants.add("/jsp/secure/pagination.jsp");
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
      out.write("\r\n");
      out.write("<script language=\"javascript\">\t\r\n");
      out.write("\tfunction submitFormFromLink(pageNo){\r\n");
      out.write("\t\tdocument.getElementById('pageNo').value = pageNo;\r\n");
      out.write("\t\tdocument.getElementById('boutonValider').value = 'Tadiavo';\r\n");
      out.write("\t\tdocument.getElementById('formMirotsakaFidiana').submit();\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".impression   { font-family: Arial Unicode MS; font-size: 20px; font-weight: bold;}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<!-- debut corps -->\r\n");
      out.write('\r');
      out.write('\n');

	formListMirotsakaFidiana = (FormListMirotsakaFidiana)request.getAttribute(FormListMirotsakaFidiana.sfFORM_ID);
	listMirotsakaFidiana = (List<Map<String, Object>>)request.getAttribute(ConstantUtils.sfDATA_MIROTSAKAFIDIANAS);
  if (listMirotsakaFidiana != null && listMirotsakaFidiana.size() > 0){ 

      out.write("\r\n");
      out.write("<table width=\"100%\">\r\n");
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
      out.write("\t\t<table align=\"center\" bgcolor=\"#ffffff\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n");
      out.write("\t    <tr>\r\n");
      out.write("\t      <td colspan=\"9\">\r\n");
      out.write("\t        <table width=\"100%\" border=\"1\">\r\n");
      out.write("\t          <tr>\r\n");
      out.write("                  <td align=\"left\" width=\"13%\" bgcolor=\"#48A9D2\">&nbsp;</td>\r\n");
      out.write("\t\t\t      <td width=\"3%\" bgcolor=\"#48A9D2\"><div align=\"center\" class=\"impression\"><b>No </b></div></td>\r\n");
      out.write("\t\t\t      <td width=\"26%\" bgcolor=\"#48A9D2\"><div align=\"center\" class=\"impression\"><b>Anarana Fanampiny</b></div></td>\r\n");
      out.write("\t\t\t      \r\n");
      out.write("                  <td align=\"left\" width=\"2%\" bgcolor=\"#FFFFFF\">&nbsp;</td>\r\n");
      out.write("\t\t\t      \r\n");
      out.write("                  <td align=\"left\" width=\"13%\" bgcolor=\"#48A9D2\">&nbsp;</td>\r\n");
      out.write("\t\t\t      <td width=\"3%\" bgcolor=\"#48A9D2\"><div align=\"center\" class=\"impression\"><b>No</b></div></td>\r\n");
      out.write("\t\t\t      <td width=\"26%\" bgcolor=\"#48A9D2\"><div align=\"center\" class=\"impression\"><b>Anarana Fanampiny</b></div></td>\r\n");
      out.write("\t\t\t  </tr>\r\n");
      out.write("\t        </table>\r\n");
      out.write("\t      </td>\r\n");
      out.write("\t    </tr>\r\n");
      out.write("        ");

        Date now = new Date();
        int nbLines = listMirotsakaFidiana.size() / 2;
		for (int i = 0; i < nbLines ; i++){
		    Map<String, Object> mirotsakaFidiana = listMirotsakaFidiana.get(i);
		    Map<String, Object> mirotsakaFidiana2 = null;
		    try{
		    	mirotsakaFidiana2 = listMirotsakaFidiana.get(i + nbLines);
		    }
		    catch(Exception e){
		    	if (i < listMirotsakaFidiana.size())
		    		mirotsakaFidiana2 = listMirotsakaFidiana.get(i + listMirotsakaFidiana.size() / 2);
		    }
		    
		    out.println("<tr>");
		    if (i % 2 == 0){
		   	
      out.write("\r\n");
      out.write("          <td width=\"14%\" bgcolor=\"#66CCFF\"><img src=\"");
      out.print(request.getContextPath());
      out.write('/');
      out.print(Utils.getPhotoName(request, (String)mirotsakaFidiana.get("anarana"), (Long)mirotsakaFidiana.get("mpivavakaId"), (Boolean)mirotsakaFidiana.get("lahy")));
      out.write("\" width=\"155\" height=\"163\"/></td>\r\n");
      out.write("\t      <td width=\"5%\" bgcolor=\"#66CCFF\"><div align=\"center\" class=\"impression\">");
      out.print(mirotsakaFidiana.get("laharanaMpirotsaka") != null ? mirotsakaFidiana.get("laharanaMpirotsaka") : "");
      out.write("</div></td>\r\n");
      out.write("\t      <td width=\"26%\" bgcolor=\"#66CCFF\"><div align=\"left\" class=\"impression\">");
      out.print(mirotsakaFidiana.get("anarana"));
      out.write("&nbsp;");
      out.print(mirotsakaFidiana.get("fanampiny"));
      out.write("</div></td>\r\n");
      out.write("\r\n");
      out.write("\t\t  <td align=\"left\" width=\"2%\" bgcolor=\"#FFFFFF\">&nbsp;</td>\r\n");
      out.write("\t\t\t\t");

				if (mirotsakaFidiana2 != null){
				
      out.write("\r\n");
      out.write("          <td width=\"14%\" bgcolor=\"#66CCFF\"><img src=\"");
      out.print(request.getContextPath());
      out.write('/');
      out.print(Utils.getPhotoName(request, (String)mirotsakaFidiana2.get("anarana"), (Long)mirotsakaFidiana2.get("mpivavakaId"), (Boolean)mirotsakaFidiana2.get("lahy")));
      out.write("\" width=\"155\" height=\"163\"/></td>\r\n");
      out.write("\t      <td width=\"5%\" bgcolor=\"#66CCFF\"><div align=\"center\" class=\"impression\">");
      out.print(mirotsakaFidiana2.get("laharanaMpirotsaka") != null ? mirotsakaFidiana2.get("laharanaMpirotsaka") : "");
      out.write("</div></td>\r\n");
      out.write("\t      <td width=\"26%\" bgcolor=\"#66CCFF\"><div align=\"left\" class=\"impression\">");
      out.print(mirotsakaFidiana2.get("anarana"));
      out.write("&nbsp;");
      out.print(mirotsakaFidiana2.get("fanampiny"));
      out.write("</div></td>\r\n");
      out.write("\t      \t\t");

				}
				else
				{
	      		
      out.write("\r\n");
      out.write("          <td width=\"14%\" bgcolor=\"#66CCFF\">&nbsp;</td>\r\n");
      out.write("\t      <td width=\"5%\" bgcolor=\"#66CCFF\"><div align=\"center\" class=\"impression\"></div></td>\r\n");
      out.write("\t      <td width=\"26%\" bgcolor=\"#66CCFF\"><div align=\"left\" class=\"impression\"></div></td>\r\n");
      out.write("            ");
	
				}
		   	}
		   	else{
		   	
      out.write("\r\n");
      out.write("          <td width=\"14%\" bgcolor=\"#C0C0C0\"><img src=\"");
      out.print(request.getContextPath());
      out.write('/');
      out.print(Utils.getPhotoName(request, (String)mirotsakaFidiana.get("anarana"), (Long)mirotsakaFidiana.get("mpivavakaId"), (Boolean)mirotsakaFidiana.get("lahy")));
      out.write("\" width=\"155\" height=\"163\"/></td>\r\n");
      out.write("\t      <td width=\"5%\" bgcolor=\"#C0C0C0\"><div align=\"center\" class=\"impression\">");
      out.print(mirotsakaFidiana.get("laharanaMpirotsaka") != null ? mirotsakaFidiana.get("laharanaMpirotsaka") : "");
      out.write("</div></td>\t\t      \r\n");
      out.write("\t      <td width=\"26%\" bgcolor=\"#C0C0C0\"><div align=\"left\" class=\"impression\">");
      out.print(mirotsakaFidiana.get("anarana"));
      out.write("&nbsp;");
      out.print(mirotsakaFidiana.get("fanampiny"));
      out.write("</div></td>\r\n");
      out.write("\r\n");
      out.write("\t\t  <td align=\"left\" width=\"2%\" bgcolor=\"#FFFFFF\">&nbsp;</td>\r\n");
      out.write("\t\t\t\t");

				if (mirotsakaFidiana2 != null){
				
      out.write("\r\n");
      out.write("          <td width=\"14%\" bgcolor=\"#C0C0C0\"><img src=\"");
      out.print(request.getContextPath());
      out.write('/');
      out.print(Utils.getPhotoName(request, (String)mirotsakaFidiana2.get("anarana"), (Long)mirotsakaFidiana2.get("mpivavakaId"), (Boolean)mirotsakaFidiana2.get("lahy")));
      out.write("\" width=\"155\" height=\"163\"/></td>\r\n");
      out.write("\t      <td width=\"6%\" bgcolor=\"#C0C0C0\"><div align=\"center\" class=\"impression\">");
      out.print(mirotsakaFidiana2.get("laharanaMpirotsaka") != null ? mirotsakaFidiana2.get("laharanaMpirotsaka") : "");
      out.write("</div></td>\t\t      \r\n");
      out.write("\t      <td width=\"26%\" bgcolor=\"#C0C0C0\"><div align=\"left\" class=\"impression\">");
      out.print(mirotsakaFidiana2.get("anarana"));
      out.write("&nbsp;");
      out.print(mirotsakaFidiana2.get("fanampiny"));
      out.write("</div></td>\r\n");
      out.write("\t      \t\t");

				}
				else{
	      		
      out.write("\r\n");
      out.write("          <td width=\"14%\" bgcolor=\"#C0C0C0\"></td>\r\n");
      out.write("\t      <td width=\"6%\" bgcolor=\"#C0C0C0\"><div align=\"center\" class=\"impression\"></div></td>\t\t      \r\n");
      out.write("\t      <td width=\"26%\" bgcolor=\"#C0C0C0\"><div align=\"left\" class=\"impression\"></div></td>\r\n");
      out.write(" \t        ");

				}
		   }
		   out.println("</tr>");
		}
	}
	else{
	    if (listMirotsakaFidiana != null){
	
      out.write("\r\n");
      out.write("\t <tr>\r\n");
      out.write("       <td colspan=\"5\"><div align=\"center\" style=\"bgcolor:#FF0000;\">Tsy misy mpivavaka mifanaraka amin'ny sivana.</div></td>\r\n");
      out.write("\t </tr>\r\n");
      out.write("\t");

		}
	}
	
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>");
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
