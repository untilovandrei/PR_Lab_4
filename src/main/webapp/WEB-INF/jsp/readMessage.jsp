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
        <title>Read message</title>
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
                <h1>Message </h1>
                <hr/>

                <form:form commandName="message">
                    <div class="field">
                        <h2>Sender</h2> <form:input path="sender" readonly="true" />
                    </div>
                    <div class="field" style="width: 600px">
                        <h2>Subject</h2>  <form:input path="subject" readonly="true" />
                    </div>
                    <div class="textarea">
                        <h2>Message</h2> <form:textarea path="text" rows="10" readonly="true"/>
                    </div>
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
