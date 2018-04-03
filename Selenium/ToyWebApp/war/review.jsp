<html>
<%@ include file="includes/global.jsp" %>
  <head>
    <title>Assignment 3 Toy Web App - Form</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  </head>

  <body>
  	<%@ include file="includes/top.jsp" %>
	<br>
	
    <table class="items">
	    <tr><td colspan=3 align='center'><h2>Assignment 3 Toy Web App - Form</h2></td></tr>
	    <tr><td colspan=3 align='left'>
	    
	    <form>
	    <h4>Review:</h4>
	    <%
	    String characters = request.getParameter("characters");
	    String colors = request.getParameter("colors");
	    String agree = request.getParameter("agree");
	    
	    if ((characters == null || characters.length() == 0) ||
	    	(colors == null || colors.length() == 0) ||
	    	(agree == null || agree.length() == 0))
	    {
	    %>
	    	<input type="text" name="error" size=96 value="some fields were left empty..." />
	    <%
	    }
	    else
	    {
	    %>
		    characters: <input type="text" name="charRev" size=96 value="<%= characters %>" />
		    <br>
		    colors: <input type="text" name="colRev" size=96 value="<%= colors %>" />
		    <br>
		    agree: <input type="text" name="agrRev" size=96 value="<%= agree %>" />
	    <%
	    }
	    %>
	    </form>
	    
	    </td></tr>
	    
	    <tr><td colspan=3 align='center'>&nbsp;</td></tr>
    </table>

    <%@ include file="includes/btm.jsp" %>
  </body>
</html>
