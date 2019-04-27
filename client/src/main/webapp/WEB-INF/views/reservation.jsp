<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script
        src="https://code.jquery.com/jquery-3.2.1.min.js"
        integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
        crossorigin="anonymous">
    src="https://code.jquery.com/jquery-1.10.2.js"
    src="js/app-ajax.js"
</script>

<html lang="en">
<head>
    <title>Quiz</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">

    <style>
        .h2_reser {
            text-align: center;
            font-family: 'Bowlby One SC', cursive;
            font-size: 5.5vw;
            margin: 50px;
        }
        .h2_reser_head {
            font-family: 'Bowlby One SC', cursive;
        }
    </style>
</head>
<body>


<%--   NAV   --%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/log" onclick="window.location.href='/log'">HOME</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/userdetail" onclick="window.location.href='/userdetail'">Twoje dane<span class="sr-only">(current)</span></a>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Wybierz quiz
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="/quiz1" onclick="window.location.href='/quiz1'" id="Java Object Oriented">Java Object Oriented</a>
                    <a class="dropdown-item" href="/quiz1" onclick="window.location.href='/quiz1'" id="Collections">Collections</a>
                    <a class="dropdown-item" href="/quiz1" onclick="window.location.href='/quiz1'" id="Databases">Databases</a>
                </div>
            </li>
            <li>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <h2>Welcome : ${pageContext.request.userPrincipal.name}</h2>
                </c:if>
            </li>
        </ul>
    </div>
    <!-- naval with buttons -->
    <div class="btn-group" role="group" aria-label="Basic example">
        <button type="button" class="btn btn-secondary" onclick="window.location.href='/logout'">Wyloguj się</button>
    </div>
</nav>




<!-- PAGE CONTENT -->
<div class="content-wrapper">
    <div class="content">
        <div class="row">
            <div class="col-lg-12">
                <div class="card">
                    <%--<div class="form-group pull-right">--%>
                        <%--<input id="myInput" type="text" class="search form-control" placeholder="What you looking for?">--%>
                    <%--</div>--%>
                        <div class="h2_reser"><h2>My reservations</h2></div>
                    <div class="card-block">

                        <table id="myTable" class="display datatable table table-stripped" cellspacing="0" width="100%">
                            <thead class="h2_reser_head">
                            <tr>
                                <th>Route Number</th>
                                <th>Distance</th>
                                <th>Start Location</th>
                                <th>End Location</th>
                                <th>Operation</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach items="${responseReservation}" var="reser">
                                <tr id="myTableRow">
                                    <td>${reser.route_number}</td>
                                    <td>${reser.distance}</td>
                                    <td>${reser.start_location}</td>
                                    <td>${reser.end_location}</td>
                                    <td>
                                            <%--<a href="/delete/${route.id}">--%>
                                            <%--&lt;%&ndash;&lt;%&ndash;<button type="button" class="btn btn-success" onclick="tgPanel(this);">Reserve</button>&ndash;%&gt;&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;<button type="button" class="btn btn-success" onclick="post('')">Reserve</button>&ndash;%&gt;--%>
                                            <%--<spring:url value="/delete/${route.id}" var="deleteUrl" />--%>
                                            <%--<button class="btn btn-danger"--%>
                                            <%--onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>--%>
                                            <%--</a>--%>
                                            <%--<spring:url value="/delete/${route.id}" var="deleteUrl" />--%>
                                            <%--<button class="btn btn-danger"--%>
                                            <%--onclick="this.disabled=true">Delete</button>--%>
                                        <form action="/delete/${route.id}"  method="post"><input type="submit" value="Reservation"/></form>
                                        <spring:url value="/delete/${route.id}" var="deleteUrl"/>

                                            <%--delete/////////////////////////////////////////////////////////////////////////--%>
                                    </td>
                                    <td><form action="/delete/${route.id}"  method="post"><input type="submit" value="Delete"/></form></td>
                                    <td><spring:url value="/delete/${route.id}" var="deleteUrl"/>
                                            <%--<button class="btn btn-danger" onclick="removeUser('${deleteUrl}')">Delete</button></td>--%>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /PAGE CONTENT -->


<div align="center"><a href="/log">Powrot</a></div>

</body>
</html>


<script>

    $(document).ready(function(){
        $("#myInput").on("keyup", function() {
            var value = $(this).val().toLowerCase();
            $("#myTable tr").filter(function() {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
        });
    });

    var tr;

    function tgPanel(button) {
        tr = button.parentElement.parentElement;
        console.log(tr);
    }

    // delete the user from the database
    function removeUser(deleteURL) {

        $.ajax({

            type: "DELETE",
            url: deleteURL,

            success: function () {
                // window.location.reload();
                $('#myTableRow').remove();
            },

            failure: function (errMsg) {
                console.log(errMsg.toString())
            }
        });
    }

</script>




