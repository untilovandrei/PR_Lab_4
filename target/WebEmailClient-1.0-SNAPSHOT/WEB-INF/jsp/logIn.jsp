<%-- 
    Document   : logIn
    Created on : Mar 1, 2017, 3:40:30 PM
    Author     : andrei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags"        prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"          prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"   prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Log In</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <spring:url value="/resources/css/logIn.css?<?php echo date('l jS \of F Y h:i:s A'); ?>" var="logInCss" />
        <spring:url value="/resources/css/js/respond.min.js" var="minJs" />
        <spring:url value="/resources/images/avatar.png" var="avatar" />

        <spring:url value="/spring-mvc/attempt/logIn.html" var="logInURL"/>




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
                <header>
                    <span class="avatar"><img src="${avatar}" /></span>
                </header>
                <h1>Authentification</h1>
                <hr/>

                <form:form action="${logInURL}" commandName="user" autocomplete="off">
                    <div class="field">
                        <form:input path="email"  placeholder="Email" />
                        <form:errors path="email" cssClass="error"/>
                    </div>
                    <div class="field">
                        <form:password path="password"  placeholder="Password" />
                        <form:errors path="password" cssClass="error"/>
                    </div>


                    <input type="submit" class="button" value="Log In"/>
                    <%--<form:button type="submit" class="button" >Log In</form:button>--%>
                </form:form>
                <hr />
            </section>

            <!-- Footer -->
            <footer id="footer">
                <ul class="copyright">
                    <li>&copy; Email client 2018</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
                </ul>
            </footer>

        </div>

        <!-- Scripts -->
        <script src="resources/css/js/respond.min.js"></script>
        <script>
                window.addEventListener('load', function () {
                    document.body.className = document.body.className.replace(/\bis-loading\b/, '');
                });
                document.body.className += (navigator.userAgent.match(/(MSIE|rv:11\.0)/) ? ' is-ie' : '');
        </script>
        <script>
            window.onload = function() {
            document.getElementById("email").focus();
          };
        </script>

    </body>
</html>
