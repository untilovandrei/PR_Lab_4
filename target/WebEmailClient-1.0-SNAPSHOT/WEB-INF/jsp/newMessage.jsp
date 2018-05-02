<%-- 
    Document   : sendMessage
    Created on : Apr 29, 2018, 11:24:44 PM
    Author     : andrei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags"        prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"          prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"   prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>New message</title>
        <spring:url value="/resources/css/logIn.css?<?php echo date('l jS \of F Y h:i:s A'); ?>" var="logInCss" />
        <spring:url value="/resources/css/js/respond.min.js" var="minJs" />
        <spring:url value="/resources/images/avatar.png" var="avatar" />

        <spring:url value="/spring-mvc/attempt/sendMessage.html" var="sendMessage"/>




        <link href="${logInCss}" rel="stylesheet" />
        <script src="${minJs}"></script>
        
<style>
    .error {
        color: red; font-weight: bold;
    }
</style>

    </head>
    <body class="is-loading">

        <!-- Wrapper -->
        <div id="wrapper">

            <!-- Main -->
            <section id="main">
                
                <h1>New message</h1>
                <hr/>

                <form:form action="${sendMessage}" commandName="newMessage" autocomplete="off">
                    <div class="field">
                        <form:input path="recipient"  placeholder="To"   />
                        <form:errors path="recipient" cssClass="error"/>
                    </div>
                    <div class="field">
                        <form:input path="subject"  placeholder="Subject" />
                        <form:errors path="subject" cssClass="error"/>
                    </div>
                    <div class="textarea">
                        <form:textarea path="text"  placeholder="Write message...." />
                        <form:errors path="text" cssClass="error"/>
                    </div>


                    <input type="submit" class="button" value="Send" />
                    <%--<form:button type="submit" class="button" >Log In</form:button>--%>
                </form:form>
                <hr />
                
            </section>

        </div>

        <!-- Scripts -->
        <script src="resources/css/js/respond.min.js"></script>
        <script>
            if ('addEventListener' in window) {
                window.addEventListener('load', function () {
                    document.body.className = document.body.className.replace(/\bis-loading\b/, '');
                });
                document.body.className += (navigator.userAgent.match(/(MSIE|rv:11\.0)/) ? ' is-ie' : '');
            }
        </script>
        <script>
            window.onload = function() {
            document.getElementById("recipient").focus();
          };
        </script>

    </body>
</html>
