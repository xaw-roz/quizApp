<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rakesh-a
  Date: 9/13/2016
  Time: 8:39 AM
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Demo Project</title>
    <link href="..//css/templatemo_style.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<div id="templatemo_wrapper_outter">

    <div id="templatemo_wrapper_inner">


        <%@include file="../includes/header.jsp"%>
        <div id="templatemo_content_wrapper">


            <div id="templatemo_content">




                <div id="loginDiv">
                    <c:if test="${task=='add'}">

                        <div class="content_section">

                            <h2>Add new User</h2>
                        </div>
                        <form action="addUser" method="post">
                            <input type="hidden" name="page" value="addUser"/>
                            <label>Username:</label>
                            <input type="text" name="username" class="form-control" required>
                            <br>
                            <label>Password:</label>
                            <input type="password" name="password" class="form-control" required >
                            <br>
                            <label>Role:</label>
                            <input type="text" name="role" required>
                            <br>
                            <input type="submit" value="Add User" class="btn btn-default">

                        </form>
                    </c:if>

                    <c:if test="${task=='edit'}">
                        <div class="content_section">

                            <h2>Edit User</h2>
                        </div>
                        <form action="editUser" method="post">
                            <input type="hidden" name="page" value="editUser"/>
                            <input type="hidden" name="id" value="${user.id}"/>
                            <label>Username:</label>
                            <input type="text" name="username" value="${user.name}" class="form-control" required>
                            <br>
                            <label>Password:</label>
                            <input type="password" name="password" value="${user.password}" class="form-control" required>
                            <br>
                            <label>Role:</label>
                            <input type="text" name="role" value="${user.role}" class="form-control" required>
                            <br>
                            <input type="submit" value="Edit" class="btn btn-default">

                        </form>
                    </c:if>
                </div>





            </div>

            <div class="cleaner"></div>

        </div> <!-- end of templatemo_content_wrapper -->

        <div id="templatemo_footer">

            This is Footer
        </div><!-- end of footer -->

    </div> <!-- end of templatemo_wrapper_inner -->

</div> <!-- end of templatemo_wrapper_outter -->


</body>
</html>
