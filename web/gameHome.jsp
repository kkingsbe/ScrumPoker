<%@ page import="java.util.ArrayList" %>
<%@ page import="GamePackage.GameDriver" %><%--
  Created by IntelliJ IDEA.
  User: Noah
  Date: 3/29/2019
  Time: 7:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="default.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
    <title></title>

</head>
<%! ArrayList<String> players = new ArrayList<String>()%>
<body onload="showPage()">
<div id="loader"></div>
<div id="dot"></div>
<div style="display:none;" id="myDiv" class="animate-bottom">
    <div class="card card-inverse under">
        <img class="img-fluid  background underlay" src="https://d2v9y0dukr6mq2.cloudfront.net/video/thumbnail/jVhILry/smoke-abstract-background-4k_n1v1jgbxe__F0005.png" >
        <div class="card-img-overlay" style=" ">
            <h4 class="card-title" style="text-align:center; top:7%; color:white; font-size:500%;"><%= request.getParameter("username")%></h4>
            <div class="container lowertext">
                <h3>Players: </h3><%
                players = GameDriver.getPlayers(request.getParameter("gamename"));
                for(String player: players){%>
                    <p><%= player%></p>
                <%}%>
            </div>
        </div>
    </div>


</div>
<script>
    var myVar;
    //function myFunction() {myVar = setTimeout(showPage, 1000);}
    function showPage() {
        document.getElementById("loader").style.display = "none";
        document.getElementById("myDiv").style.display = "block";
        myVar =setTimeout(reload(), 1000)
    }
    function reload(){

        location.reload()
    }

</script>
</body>
</html>
