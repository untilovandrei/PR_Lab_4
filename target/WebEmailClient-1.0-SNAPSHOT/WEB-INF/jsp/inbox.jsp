<%-- 
    Document   : inbox
    Created on : May 2, 2018, 8:29:22 AM
    Author     : andrei
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>From ${messagesList.size()}</th>
                    <th>Description</th>
                    <th>Date</th>
                </tr>
            </thead>
        </table>
        
        
        <table>
            <tbody>
                <c:forEach var="messageData" items="${messagesList}">
                    <tr>
                        <td>${messageData.sender}</td>
                        <td>${messageData.subject}</td>
                        <td>${messageData.date}</td>
                    </tr>
                </c:forEach>
                
            </tbody>
        </table>
    </body>
</html>
