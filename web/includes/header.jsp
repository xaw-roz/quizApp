<%@ page import="domains.User" %><%
    User user = (User)session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("index.jsp");

    }
%>
<div id="templatemo_menu">

    <ul>
        <li><a href="home?page=home" class="current">Home</a></li>
        <li><a href="ulist?page=list">User</a></li>
        <li><a href="qlist?page=list">Question</a></li>
        <li><a href="logout?page=logout" >Logout</a></li>
        <li><a href="quizplay?page=playquiz">Play Quiz</a> </li>
        <li><a href="groupquize?page=groups">Play Group Quiz</a> </li>

    </ul>

</div>