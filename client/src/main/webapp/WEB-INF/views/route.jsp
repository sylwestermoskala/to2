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
        input:focus {
            outline:none;
        }

        DIV.table
        {
            display:table;
        }
        FORM.tr, DIV.tr
        {
            display:table-row;
        }
        SPAN.td
        {
            display:table-cell;
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

            <li>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <h2 style="color: white">Welcome: ${pageContext.request.userPrincipal.name}</h2>
                </c:if>
            </li>
        </ul>
    </div>
    <!-- naval with buttons -->
    <div class="btn-group" role="group" aria-label="Basic example">
        <button type="button" class="btn btn-secondary" onclick="window.location.href='/logout'">Log out</button>
    </div>
</nav>




<!-- PAGE CONTENT -->
<div class="content-wrapper">
    <div class="content">
        <div class="row">
            <div class="col-lg-12">
                <div class="card">
                    <div class="form-group pull-right">
                        <input id="myInput" type="text" class="search form-control" placeholder="What you looking for?">
                    </div>
                    <div class="card-block">

                        <table id="myTable" class="display datatable table table-stripped" cellspacing="0" width="100%">

                            <thead>
                            <tr>
                                <th>Route Number</th>
                                <th>Date</th>
                                <th>Distance</th>
                                <th>Start Location</th>
                                <th>End Location</th>
                                <th>Operation</th>
                            </tr>
                            </thead>

                            <tbody id="myTb">


                    <c:forEach items="${routes}" var="route">
                    <form action="/addReservation" method="post" commandName="reservation">
                        <tr id="myTableRow" style="">
                            <td><input type="number" min="0" step="1" name="id" style="border:none" readonly="readonly" value="${route.id}"/></td>
                            <td><input type="text" name="date" style="border:none" readonly="readonly" value="${route.date}"/></td>
                            <td><input type="number" min="0" step="1" name="distance" style="border:none" readonly="readonly" value="${route.distance}"/></td>
                            <td><input type="text" name="start_location" style="border:none" readonly="readonly" value="${route.start_location}"/></td>
                            <td><input type="text" name="end_location" style="border:none" readonly="readonly" value="${route.end_location}"/></td>
                            <td><input type="submit" value="Reservation"/></td>

                        </tr>

                    </form>

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


<div align="center"><a href="/log">Back</a></div>



<script>

    var $rows = $('#myTb tr');

    $('#myInput').keyup(function() {
        var searchText = $(this).val();
        $rows
            .show()
            .filter(function() {
                var $inputs = $(this).find("input");
                var found = searchText.length == 0; // for empty search, show all rows
                for (var i=0; i < $inputs.length && !found; i++) {
                    var text = $inputs.eq(i).val().replace(/\s+/g, ' ');
                    found = text.length > 0 && text.indexOf(searchText) >= 0;
                }
                return !found;
            })
            .hide();
    });

</script>



</body>
</html>







