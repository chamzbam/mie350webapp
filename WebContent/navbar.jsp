<nav class="navbar navbar-inverse">
	<div class="container-fluid bg-primary text-white">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">SKULE BUS</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="index.jsp">Home</a></li>
				
				
				
				<li><a
					href="/mie350webapp/PostController?action=listPost">Forum
						</a></li>		
				
				<li><a
					href="/mie350webapp/TextbookController?action=listPost">Textbook Exchange
						</a></li>		
				<li><a
					href="/mie350webapp/StudentController?action=listStudent">Contacts
						</a></li>
				
				
			</ul>
			<!-- The following code can be added to include a Login button to the right-hand side of the navbar-->
			<ul class="nav navbar-nav navbar-right">
				<li><a href="login.jsp"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
				<li><a href="Signup.jsp"><span
						class="glyphicon glyphicon-log-in"></span> Signup</a></li>
			</ul>

		</div>
	</div>
</nav>