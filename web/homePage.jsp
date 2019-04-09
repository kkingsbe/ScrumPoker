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
<body onload="myFunction()">
<div id="loader"></div>
<div id="dot"></div>
<div style="display:none;" id="myDiv" class="animate-bottom">
    <div class="card card-inverse under">
        <img class="img-fluid  background underlay" src="https://i.imgur.com/mmVZxbz.jpg" >
        <div class="card-img-overlay" style=" ">
            <h4 class="card-title" style="text-align:center; top:7%; color:white; font-size:500%;">Scrum Poker</h4>
            <div class="container lowertext">
                <div class="row">
                    <div class="col-sm">
                        <h2>Create Game</h2>
                        <form action="http://75.101.200.70/ServletTest/createGame" method="post">
                            <p>Username:</p>
                            <input type="text" name="username"><br>
                            <p>Game name:</p>
                            <input type="text" name="gamename"><br>
                            <p>Description:</p>
                            <input type="text" name="description"><br><br>
                            <input type="submit" value="Submit">
                        </form>
                    </div>
                    <div class="col-sm">
                        <h2>Join Game</h2>
                        <form action="joinGame" method="post">
                            <p>Username:</p>
                            <input type="text" name="username">
                            <p>Gamename:</p>
                            <input type="text" name="gamename"><br><br>

                            <input type="submit" value="Join Game">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


</div>
<script>
    var myVar;
    function myFunction() {myVar = setTimeout(showPage, 1000);}
    function showPage() {
        document.getElementById("loader").style.display = "none";
        document.getElementById("myDiv").style.display = "block";
    }
</script>
</body>
</html>