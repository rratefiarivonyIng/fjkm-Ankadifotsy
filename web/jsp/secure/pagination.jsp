<%@ include file="/jsp/include.jsp" %>

<%@ page import="mg.fjkm.ankadifotsy.util.Utils" %>

<%@ page import="mg.fjkm.ankadifotsy.form.AbstractFormSearch" %>

<%!
  AbstractFormSearch searchForm;
%>
<%
  searchForm = Utils.getCurrentSearchForm(request);
%>
      <table width="100%">
        <tr>
          <td>  
            <b>Pejy <%=searchForm.getPageNo()+1%> / <%=searchForm.getNbPageTotal()+1%></b>
          </td>
          <td align="right" width="50%">
            <b>Pejy : &nbsp;</b>
            <%  
            if (searchForm.hasPreviousPage()){
            %>
            &nbsp;<a href="javascript:loadResults('<%=searchForm.getPageNo()-1%>' );" title="pejy teo aloha" class="pageLink"><img src="<%=request.getContextPath()%>/images/Previous_s.png"/></a>&nbsp;
            <%
            }
            
            if (searchForm.getNbPageTotal() > 1){
              for (int i=1; i<= searchForm.getNbPageTotal()+1; i++){
            %>
                &nbsp;
            <%
                if ((i-1) == searchForm.getPageNo()){
            %>
                <b><%=i%></b>
            <%
                }
                else{
            %>
                <a href="javascript:loadResults('<%=i-1%>' );"><%=i%></a>
            <%
                }
              }
            }
            
            if (searchForm.hasNextPage()){
            %>
            &nbsp;<a href="javascript:loadResults('<%=searchForm.getPageNo()+1%>');" title="pejy manaraka" class="pageLink"><img src="<%=request.getContextPath()%>/images/Next_s.png"/></a> &nbsp;
            <%
            }
            %>
          </td>
        </tr>
      </table>
