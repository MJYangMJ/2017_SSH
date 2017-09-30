<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2017/9/26
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
    <title>Login JSP</title>
    </head>
    <body>
        <form action="loginAction" method="post">
            <input name="name" label="Username"/>
            <input name="password" label="Password"/>
            <input name="type" label="Type"/>
            <input type="submit" value="submit"/>
        </form>
    </body>
</html>
