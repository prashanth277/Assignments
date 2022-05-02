<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <script src="https://kit.fontawesome.com/5c7c1aca43.js" crossorigin="anonymous"></script>
</head>

<body>
<div>
    <div class="sidebar-logo container-fluid">
        Attendance Management
    </div>
</div>
<div class="sidebar-container ">
    <ul class="sidebar-navigation">
        <li class="header"></li>
        <li>
            <a href="#">
                <i class="fa fa-home" aria-hidden="true"></i> Dashboard
            </a>
        </li>
        <li>
            <a href="#">
                <i class="fa fa-tachometer" aria-hidden="true"></i> Mark Attendance
            </a>
        </li>
        <li>
            <a href="interns">
                <i class="fa fa-users" aria-hidden="true"></i> Interns
            </a>
        </li>
        <!--    <li>-->
        <!--      <a href="#">-->
        <!--        <i class="fa fa-cog" aria-hidden="true"></i> Settings-->
        <!--      </a>-->
        <!--    </li>-->
    </ul>
</div>

<div class="content-container">
    <div class="container-fluid">
        <div class="jumbo-tron">
            <h1>Here are the intern details</h1>
            <form action="handle" method="post">
                Intern Id:<input type="text" name="intern-id" placeholder="Enter Intern id" ><br>
                Name:<input type="text" name="name" placeholder="Enter name" ><br>
                Email:<input type="text" name="email" placeholder="Enter email" ><br>
                Phone No:<input type="text" name="phno" placeholder="Enter PhoneNo" ><br>
                <input type="submit"  value="save" name="save-btn" >
            </form>
        </div>

    </div>

</div>

</body>
</html>