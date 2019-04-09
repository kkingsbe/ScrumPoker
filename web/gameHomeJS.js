var myVar;
//function myFunction() {myVar = setTimeout(showPage, 1000);}
function showPage() {
    document.getElementById("loader").style.display = "none";
    document.getElementById("myDiv").style.display = "block";
    myVar =setTimeout(reload(), 1000)
}
function reload(){

    $("#refresh").load(gameHome.jsp + " #refresh>*", "");

}

