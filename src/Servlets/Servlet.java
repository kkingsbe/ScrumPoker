package Servlets;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import javax.servlet.*;

public class Servlet extends javax.servlet.http.HttpServlet {
    private String hello;
    public void init() throws ServletException {
        hello = "neat";

    }
    //public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException{

    //}
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");   //sets response type, in this case html
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>\n" +
                "<!--this is an image gallery template made by Noah Edmiston-->\n" +
                "<html><h1>test</h1>\n" +
                "\t<head>\n" +
                "\t\t<!-- Latest compiled and minified CSS -->\n" +
                "\t\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css\">\n" +
                "\n" +
                "\t\t<!-- jQuery library -->\n" +
                "\t\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n" +
                "\n" +
                "\t\t<!-- Popper JS -->\n" +
                "\t\t<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js\"></script>\n" +
                "\n" +
                "\t\t<!-- Latest compiled JavaScript -->\n" +
                "\t\t<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js\"></script>\n" +
                "\t\t<title></title>\n" +
                "\t\t<style>\n" +
                "\t\t#loader {\n" +
                "  position: absolute;\n" +
                "  left: 49%;\n" +
                "  top: 42.5%;\n" +
                "  z-index: 1;\n" +
                "  width: 2vw;\n" +
                "  height: 15vw;\n" +
                "  background-color:#795794;\n" +
                "  \n" +
                "  /* border-top: 16px solid */\n" +
                "  \n" +
                "  -webkit-animation: spin 2s ease-in-out infinite;\n" +
                "  animation: spin 2s ease-in-out infinite;\n" +
                "}\n" +
                "@-webkit-keyframes spin {\n" +
                "  0% { -webkit-transform: rotate(0deg); }\n" +
                "  100% { -webkit-transform: rotate(360deg); }\n" +
                "}\n" +
                "@keyframes spin {\n" +
                "  0% { transform: rotate(0deg); }\n" +
                "  100% { transform: rotate(360deg); }\n" +
                "}\n" +
                ".animate-bottom {\n" +
                "  position: relative;\n" +
                "  -webkit-animation-name: animatebottom;\n" +
                "  -webkit-animation-duration: 1s;\n" +
                "  animation-name: animatebottom;\n" +
                "  animation-duration: 1s\n" +
                "}\n" +
                "@-webkit-keyframes animatebottom {\n" +
                "  from { bottom:-100px; opacity:0 } \n" +
                "  to { bottom:0px; opacity:1 }\n" +
                "}\n" +
                "@keyframes animatebottom { \n" +
                "  from{ bottom:-100px; opacity:0 } \n" +
                "  to{ bottom:0; opacity:1 }\n" +
                "}\n" +
                "#myDiv {\n" +
                "  display: none;\n" +
                "  text-align: center;\n" +
                "}\n" +
                ".arrowup{\n" +
                "\tleft:0%;\n" +
                "\theight:auto;\n" +
                "\twidth:4%;\n" +
                "}\n" +
                ".overlay{\n" +
                "\tz-index:2;\n" +
                "\tposition:absolute;\n" +
                "\ttop:80px;\n" +
                "\tleft:80px;\n" +
                "\topacity:0;\n" +
                "}\n" +
                ".overlaytext{\n" +
                "\tcolor:white;\n" +
                "\t\n" +
                "\t\n" +
                "}\n" +
                ".fade-in-image:hover{\n" +
                "\tanimation: hover 3s;\n" +
                "\topacity:.5;\n" +
                "}\n" +
                "img:hover~#overlay1{\n" +
                "\tanimation: fade-in-text 3s;\n" +
                "}\n" +
                "@keyframes fade-in-text{\n" +
                "\t0%{opacity: 0;}\n" +
                "\t100%{opacity:1;}\n" +
                "}\n" +
                "@keyframes hover{\n" +
                "\t0%{opacity: 1;}\n" +
                "\t100%{opacity:0.5;}\n" +
                "}\n" +
                "img:hover ~ #overlay1{\n" +
                "\topacity:1;\n" +
                "\t\n" +
                "}\n" +
                ".background{\n" +
                "\tbackground-color:black;\n" +
                "}\n" +
                "</style>\n" +
                "\t</head>\n" +
                "\t<body onload=\"myFunction()\">\n" +
                "\t<div id=\"loader\"></div>\n" +
                "\t<div id=\"dot\"></div>\n" +
                "\t<div style=\"display:none;\" id=\"myDiv\" class=\"animate-bottom\">\n" +
                "\t\t<div class=\"card card-inverse\">\n" +
                "\t\t\t<img class=\"img-fluid border-radius:0; background\" src=\"https://wallpapersite.com/images/wallpapers/mountains-2880x1800-lg-nexus-android-stock-4k-2538.jpg\" >\n" +
                "\t\t\t<div class=\"card-img-overlay\" style=\" \">\n" +
                "\t\t\t<h4 class=\"card-title\" style=\"text-align:center; top:7%; color:white; font-size:500%;\">Lorem</h4>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<nav class = \"navbar-expand-sm bg-light navbar-light sticky-top\">\n" +
                "\t\t\t<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapsibleNavbar\">\n" +
                "\t\t\t\t<span class=\"navbar-toggler-icon\"></span>\n" +
                "\t\t\t</button>\n" +
                "\t\t\t<div class=\"collapse navbar-collapse\" id=\"collapsibleNavbar\">\n" +
                "\t\t\t\t<ul class=\"navbar-nav\">\n" +
                "\t\t\t\t\t<li class=\"nav-item active\">\n" +
                "\t\t\t\t\t\t<a class=\"nav-link\" href=\"#\">Home</a>\n" +
                "\t\t\t\t\t</li>\n" +
                "\t\t\t\t\t<li class=\"nav-item\">\n" +
                "\t\t\t\t\t\t<a class=\"nav-link\" href=\"#\">PlaceHolder 1</a>\n" +
                "\t\t\t\t\t</li>\n" +
                "\t\t\t\t\t<li class=\"nav-item\">\n" +
                "\t\t\t\t\t\t<a class=\"nav-link\" href=\"#\">Placeholder 2</a>\n" +
                "\t\t\t\t\t</li>\n" +
                "\t\t\t\t\t<li class=\"nav-item\">\n" +
                "\t\t\t\t\t\t<a class=\"nav-link\" href=\"#\">Placeholder 3</a>\n" +
                "\t\t\t\t\t</li>\n" +
                "\t\t\t\t</ul>\n" +
                "\t\t\t</div>\n" +
                "\t\t</nav>\n" +
                "\t\t<div class=\"row\" style=\"padding-bottom:5%;padding-right:.5%;padding-left:.5%;\">\n" +
                "\t\t\t<div class=\"col-lg-6 col-sm-12\" style = >\n" +
                "\t\t\t\t<div class=\"card\">\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t<img class=\"card-image-top img-fluid hovering fade-in-image\"  src=\"https://wallpaperscraft.com/image/pier_dock_sea_dusk_shore_118549_3840x2400.jpg\">\n" +
                "\t\t\t\t\t<div id=\"overlay1\" class=\"overlay\">\n" +
                "\t\t\t\t\t\t<h2  class=\"overlaytext\">Lorem</h2>\n" +
                "\t\t\t\t\t\t<p class=\"overlaytext\">Lorem ipsum dolor sit amet, consectetur adipiscing elit.<p>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"card-body\">\n" +
                "\t\t\t\t\t\t<h3 class=\"card-title\">Lorem Ipsum</h3>\n" +
                "\t\t\t\t\t\t<p = class=\"card-text\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec accumsan neque in magna sodales pellentesque luctus non metus. Aliquam accumsan sem eros, quis varius erat fermentum ut. Curabitur eu erat tellus. Vivamus non velit leo. Proin suscipit vitae nisi vitae molestie. Suspendisse aliquam egestas sem.</p>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"col-lg-6 col-sm-12\" style = >\n" +
                "\t\t\t\t<div class=\"card\">\n" +
                "\t\t\t\t\t<img class=\"card-image-top img-fluid fade-in-image\"  src=\"https://wallpaperscraft.com/image/pier_dock_sea_dusk_shore_118549_3840x2400.jpg\">\n" +
                "\t\t\t\t\t<div id=\"overlay1\" class=\"overlay\">\n" +
                "\t\t\t\t\t\t<h2  class=\"overlaytext\">Lorem</h2>\n" +
                "\t\t\t\t\t\t<p class=\"overlaytext\">Lorem ipsum dolor sit amet, consectetur adipiscing elit.<p>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"card-body\" >\n" +
                "\t\t\t\t\t\t<h3 class=\"card-title\">Lorem Ipsum</h3>\n" +
                "\t\t\t\t\t\t<p = class=\"card-text\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec accumsan neque in magna sodales pellentesque luctus non metus. Aliquam accumsan sem eros, quis varius erat fermentum ut. Curabitur eu erat tellus. Vivamus non velit leo. Proin suscipit vitae nisi vitae molestie. Suspendisse aliquam egestas sem.</p>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\n" +
                "\t\t\t<div class=\"col-lg-6 col-sm-12\" style = >\n" +
                "\t\t\t\t<div class=\"card\">\n" +
                "\t\t\t\t\t<img class=\"card-image-top img-fluid fade-in-image\"  src=\"https://wallpaperscraft.com/image/pier_dock_sea_dusk_shore_118549_3840x2400.jpg\">\n" +
                "\t\t\t\t\t<div id=\"overlay1\" class=\"overlay\">\n" +
                "\t\t\t\t\t\t<h2  class=\"overlaytext\">Lorem</h2>\n" +
                "\t\t\t\t\t\t<p class=\"overlaytext\">Lorem ipsum dolor sit amet, consectetur adipiscing elit.<p>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"card-body\">\n" +
                "\t\t\t\t\t\t<h3 class=\"card-title\">Lorem Ipsum</h3>\n" +
                "\t\t\t\t\t\t<p = class=\"card-text\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec accumsan neque in magna sodales pellentesque luctus non metus. Aliquam accumsan sem eros, quis varius erat fermentum ut. Curabitur eu erat tellus. Vivamus non velit leo. Proin suscipit vitae nisi vitae molestie. Suspendisse aliquam egestas sem.</p>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"col-lg-6 col-sm-12\" style = >\n" +
                "\t\t\t\t<div class=\"card\">\n" +
                "\t\t\t\t\t<img class=\"card-image-top img-fluid fade-in-image\"  src=\"https://wallpaperscraft.com/image/pier_dock_sea_dusk_shore_118549_3840x2400.jpg\">\n" +
                "\t\t\t\t\t<div id=\"overlay1\" class=\"overlay\">\n" +
                "\t\t\t\t\t\t<h2  class=\"overlaytext\">Lorem</h2>\n" +
                "\t\t\t\t\t\t<p class=\"overlaytext\">Lorem ipsum dolor sit amet, consectetur adipiscing elit.<p>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"card-body\" >\n" +
                "\t\t\t\t\t\t<h3 class=\"card-title\">Lorem Ipsum</h3>\n" +
                "\t\t\t\t\t\t<p = class=\"card-text\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec accumsan neque in magna sodales pellentesque luctus non metus. Aliquam accumsan sem eros, quis varius erat fermentum ut. Curabitur eu erat tellus. Vivamus non velit leo. Proin suscipit vitae nisi vitae molestie. Suspendisse aliquam egestas sem.</p>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"card\" style=\"\">\n" +
                "\t\t\t<img  class=\"card-img-top img-fluid\" src=\"https://wallpaperscraft.com/image/pier_dock_sea_dusk_shore_118549_3840x2400.jpg\">\n" +
                "\t\t\t<div id=\"overlay1\" class=\"overlay\">\n" +
                "\t\t\t\t\t\t<h2  class=\"overlaytext\">Lorem</h2>\n" +
                "\t\t\t\t\t\t<p class=\"overlaytext\">Lorem ipsum dolor sit amet, consectetur adipiscing elit.<p>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"card-body\">\n" +
                "\t\t\t\t<h4 class=\"card-title\">Lorem Ipsum</h4>\n" +
                "\t\t\t\t<p class=\"card-text\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi orci elit, pulvinar non metus convallis, laoreet facilisis diam. Vestibulum sit amet pulvinar lorem. Vestibulum ante ipsum primis in faucibus orci.</p>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<script>\n" +
                "\t\t\tvar myVar;\n" +
                "\t\t\tfunction myFunction() {myVar = setTimeout(showPage, 1000);}\n" +
                "\t\t\tfunction showPage() {\n" +
                "\t\t\t\tdocument.getElementById(\"loader\").style.display = \"none\";\n" +
                "\t\t\t\tdocument.getElementById(\"myDiv\").style.display = \"block\";\n" +
                "\t\t\t}\n" +
                "\t\t</script>\n" +
                "\t</body>\n" +
                "</html>");
    }
}
