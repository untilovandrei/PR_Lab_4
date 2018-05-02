<%-- 
    Document   : inbox
    Created on : May 2, 2018, 8:29:22 AM
    Author     : andrei
--%>

<%@ taglib uri="http://www.springframework.org/tags"        prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"          prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"   prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <spring:url value="/resources/css/inbox.css?<?php echo date('l jS \of F Y h:i:s A'); ?>" var="inboxCss" />
        <link rel="stylesheet" href="${inboxCss}" />
        
    </head>
    <body class="is-loading"  >

        <div id="wrapper">

            <section  id="main" >
        <table cellpadding="0" cellspacing="0" border="0">
            <thead>
                <tr>
                    <th>From</th>
                    <th>Description</th>
                    <th>Date</th>
                </tr>
            </thead>
        </table>
        
            <div class="tbl-content" >
                <table>
            <tbody  cellpadding="0" cellspacing="0" border="0" >
                <c:forEach var="messageData" items="${messagesList}">
                    <tr>
                        <td>${messageData.sender}</td>
                        <td>${messageData.subject}</td>
                        <td>${messageData.date}</td>
                    </tr>
                </c:forEach>
                
            </tbody>
            </table>
            </div>
                </section>
        </div>
        
                <script src="${respondJs}"></script>
        <script src="${htmlJs}"></script>
        <script>
if ('addEventListener' in window) {
    window.addEventListener('load', function () {
        document.body.className = document.body.className.replace(/\bis-loading\b/, '');
    });
    document.body.className += (navigator.userAgent.match(/(MSIE|rv:11\.0)/) ? ' is-ie' : '');
}
        </script>
       
    </body>
</html>
