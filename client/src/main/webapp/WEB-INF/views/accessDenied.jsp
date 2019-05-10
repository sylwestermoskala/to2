
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
<style>
    .no_permission{
        position: absolute;
        left: 0;
        top: 0%;
        width: 100%;
        text-align: center;
        font-size: 18px;
    }

    .bd_class{
        background-color:#ffad99;
        background-image:linear-gradient(to bottom right, white, #ffad99);
    }


</style>
</head>
<body class="bd_class">
    <div class = "no_permission">
        <h2>Sorry, you do not have permission to view this page.</h2>

    Click <a href="log">here</a>
        to go back to the Homepage.
    </div>
</body>
</html>
