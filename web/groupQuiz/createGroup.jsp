<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Create group</title>
    <link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="css/table.css" rel="stylesheet" type="text/css" />
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>
<div id="templatemo_wrapper_outter">

    <div id="templatemo_wrapper_inner">


        <%@include file="../includes/header.jsp"%>
        <div id="templatemo_content_wrapper">


            <div id="templatemo_content">




                <div id="loginDiv">

                    <div class="content_section">


                        <h2>Enter the name of the groups</h2>
                    </div>

                    <form action="/groupquize" method="post">
                        <input type="hidden" name="page" value="createGroups"/>

                        <br>
                        Enter the 1st group name :<input type="text" name="group1" value="" >
                        <br>
                        Enter the 2nd group name :<input type="text" name="group2" value="" >
                        <br>
                        Enter the 3rd group name :<input type="text" name="group3" value="" >

                        <br>
                        <input type="submit" value="Create Groups" class="btn btn-default">


                    </form>
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
