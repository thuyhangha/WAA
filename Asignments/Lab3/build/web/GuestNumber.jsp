<%-- 
    Document   : GuestNumber
    Created on : Nov 12, 2017, 1:34:58 PM
    Author     : hangha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <form method="get">
            Enter a number <input type=text name=guestNumber> 
            <input type=submit value='CheckNumber'>
        </form>
       
        <%
            Object randNumberSession = session.getAttribute("randNumber");
            String guestNumber = request.getParameter("guestNumber");
            
            if(randNumberSession == null) {       
                session.setAttribute("randNumber", (int)(Math.random() * 9) + 1);
            }
            Integer inputVal = Integer.parseInt(randNumberSession.toString());
            
            if (guestNumber != null && guestNumber != "") {           
                if(Integer.parseInt(guestNumber) < inputVal){
            %>
                    <p>Too low, try again.</p>                    
            <%
                }
                else if(Integer.parseInt(guestNumber) > inputVal){
            %>
                    <p>Too high, try again.</p>
            <%        
                }
                else{
                %>
                     <p>Correct, congratulations!</p>
                <%        
                }
            } 
        %>

    </body>
</html>
