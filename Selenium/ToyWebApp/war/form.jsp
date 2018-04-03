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
	    
	    <form name="toyForm" action="review.jsp">
	    
	    characters:
	    <input type="text" name="characters" size=32 /><br>
	    
	    colors:
	    <input type="radio" name="colors" value="red" />red
	    <input type="radio" name="colors" value="white" />white
	    <input type="radio" name="colors" value="blue" />blue
	    
	    <br>
	    <input type="checkbox" name="agree" value="agree" />I agree
	    
	    <br>
	    <input type="submit" value="Submit" />
	    
	    </form>
	    
	    </td></tr>
	    
	    <tr><td colspan=3 align='center'>&nbsp;</td></tr>
    </table>

    <%@ include file="includes/btm.jsp" %>
  </body>
</html>
