		<ul id="tabnav">
			<%
			if (Utils.getLoggedUserName() != null){%>
			 <li id="connect">Miarahaba an'i <b><%=Utils.getLoggedUserName()%></b></li>
			<%
			}
			%>
			<li id="connect">IP : <%=Utils.getIpFromRequest(request) %></li>		
			<% if (ConstantUtils.sfAccessMpivavaka.equals(session.getAttribute(ConstantUtils.sfSelectedTab))) {%>
			<li class="active"><a href="<%=request.getContextPath()%>/secure/index.htm">Mpivavaka</a></li>
			<li><a class="onglet" href="<%=request.getContextPath()%>/secure/index.htm?sampana">SSAAF</a></li>
			<li><a class="onglet" href="<%=request.getContextPath()%>/secure/index.htm?diakona">Diakona</a></li>
			<li><a class="onglet" href="<%=request.getContextPath()%>/secure/index.htm?fifidianana">Fifidianana</a></li>
			<li><a class="onglet" href="<%=request.getContextPath()%>/secure/index.htm?administration">Administration</a></li>
			<%}%>

			<% if (ConstantUtils.sfAccessSampana.equals(session.getAttribute(ConstantUtils.sfSelectedTab))) {%>
			<li><a class="onglet" href="<%=request.getContextPath()%>/secure/index.htm">Mpivavaka</a></li>
			<li class="active"><a href="<%=request.getContextPath()%>/secure/index.htm?sampana">SSAAF</a></li>
			<li><a class="onglet" href="<%=request.getContextPath()%>/secure/index.htm?diakona">Diakona</a></li>
			<li><a class="onglet" href="<%=request.getContextPath()%>/secure/index.htm?fifidianana">Fifidianana</a></li>
			<li><a class="onglet" href="<%=request.getContextPath()%>/secure/index.htm?administration">Administration</a></li>
			<%}%>

			<% if (ConstantUtils.sfAccessDiakona.equals(session.getAttribute(ConstantUtils.sfSelectedTab))) {%>
			<li><a class="onglet" href="<%=request.getContextPath()%>/secure/index.htm">Mpivavaka</a></li>
			<li><a class="onglet" href="<%=request.getContextPath()%>/secure/index.htm?sampana">SSAAF</a></li>
			<li class="active"><a href="<%=request.getContextPath()%>/secure/index.htm?diakona">Diakona</a></li>
			<li><a class="onglet" href="<%=request.getContextPath()%>/secure/index.htm?fifidianana">Fifidianana</a></li>
			<li><a class="onglet" href="<%=request.getContextPath()%>/secure/index.htm?administration">Administration</a></li>
			<%}%>

			<% if (ConstantUtils.sfAccessFifidianana.equals(session.getAttribute(ConstantUtils.sfSelectedTab))) {%>
			<li><a class="onglet" href="<%=request.getContextPath()%>/secure/index.htm">Mpivavaka</a></li>
			<li><a class="onglet" href="<%=request.getContextPath()%>/secure/index.htm?sampana">SSAAF</a></li>
			<li><a class="onglet" href="<%=request.getContextPath()%>/secure/index.htm?diakona">Diakona</a></li>
			<li class="active"><a href="<%=request.getContextPath()%>/secure/index.htm?fifidianana">Fifidianana</a></li>
			<li><a class="onglet" href="<%=request.getContextPath()%>/secure/index.htm?administration">Administration</a></li>
			<%}%>

			<% if (ConstantUtils.sfAccessAdmin.equals(session.getAttribute(ConstantUtils.sfSelectedTab))) {%>
			<li><a class="onglet" href="<%=request.getContextPath()%>/secure/index.htm">Mpivavaka</a></li>
			<li><a class="onglet" href="<%=request.getContextPath()%>/secure/index.htm?sampana">SSAAF</a></li>
			<li><a class="onglet" href="<%=request.getContextPath()%>/secure/index.htm?diakona">Diakona</a></li>
			<li><a class="onglet" href="<%=request.getContextPath()%>/secure/index.htm?fifidianana">Fifidianana</a></li>
			<li class="active"><a href="<%=request.getContextPath()%>/secure/index.htm?administration">Administration</a></li>
			<%}%>

			<% if (org.acegisecurity.context.SecurityContextHolder.getContext().getAuthentication() != null) {%>
			<li id="disconnect"><a href="<%=request.getContextPath()%>/logout.jsp">Mivoaka</a></li>
			<%}%>
		</ul>
