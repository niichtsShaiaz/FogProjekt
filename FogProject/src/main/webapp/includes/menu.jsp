<%
    boolean loggedIn = false;
    String role = "";
    if(session.getAttribute("User") != null)
    {
        loggedIn = true;
        FunctionLayer.User user = (FunctionLayer.User)session.getAttribute("User");
        role = user.getRole();
    }
%>
<nav>
	<ul class="nav nav-tabs">
		<li class="nav-item">
			<a class="nav-link" href="Form.jsp">Lav en carport med dine egne maal</a>
		</li>
                <%if(loggedIn && role.equals("Employee")){%>
		<li class="nav-item">
			<a class="nav-link" href="FrontController?command=AllOrders">Alle ordrer</a>
		</li>
                <%}%>
                <%if(loggedIn){%>
                <li class="nav-item">
			<a class="nav-link" href="FrontController?command=UserOrders">My Orders</a> 
		</li>
                <%}%>
                <%if(!loggedIn){%>
		<li class="nav-item">
			<a class="nav-link" href="Registration.jsp">registrering</a>
		</li>
                <%}%>
                <%if(!loggedIn){%>
		<li class="nav-item">
			<a class="nav-link" href="Login.jsp">Login</a>
		</li>
                <%}%>
                <%if(loggedIn){%>
		<li class="nav-item">
			<a class="nav-link" href="FrontController?command=LogOut">Logud</a>
		</li>
                <%}%>
	</ul>
</nav>