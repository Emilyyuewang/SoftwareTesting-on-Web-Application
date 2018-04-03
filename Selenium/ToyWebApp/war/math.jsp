<html>
<%@ include file="includes/global.jsp" %>
  <head>
    <title>Assignment 3 Toy Web App - Math</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  </head>

  <body>
  	<%@ include file="includes/top.jsp" %>
	<br>
	
    <table class="items">
	    <tr><td colspan=3 align='center'><h2>Assignment 3 Toy Web App - Math</h2></td></tr>
	    <tr><td colspan=3 align='left'>
	    
	    <form>
	    <h4>Result:</h4>
	    <%
	    String param1 = request.getParameter("param1");
	    String param2 = request.getParameter("param2");
	    String operation = request.getParameter("operation");
	    
	    if ((param1 == null || param1.length() == 0) ||
	    	(param2 == null || param2.length() == 0) ||
	    	(operation == null || operation.length() == 0))
	    {
	    %>
	    	<input type="text" name="result" size=96 value="Usage: http://localhost:8888/math.jsp?param1=XX&opertation=X&param2=XX" />
	    <%
	    }
	    else
	    {
		    boolean paramsOk = false;
		    int param1Val = -1;
			int param2Val = -1;
			
			try
			{
				param1Val = Integer.parseInt(param1);
				param2Val = Integer.parseInt(param2);
				
				paramsOk = true;
			}
			catch (NumberFormatException nfe)
			{
			%>
				<input type="text" name="result" size=96 value="param1 and param2 must be integers..." />
			<%
			}
			
			if (paramsOk)
			{
				if (!(operation.equals("plus") || operation.equals("minus")))
				{
				%>
					<input type="text" name="result" size=96 value="supported operations are 'plus' and 'minus' only..." />
				<%
				}
				else
				{
					int res = 0;
					if (operation.equals("plus"))
						res = param1Val + param2Val;
					else
						res = param1Val - param2Val;
				%>
					<input type="text" name="result" size=96 value="<%= res %>" />
				<%
				}
			}
		}
	    %>
	    </form>
	    
	    </td></tr>
	    
	    <tr><td colspan=3 align='center'>&nbsp;</td></tr>
    </table>

    <%@ include file="includes/btm.jsp" %>
  </body>
</html>
