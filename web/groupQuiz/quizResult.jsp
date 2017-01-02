<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Quiz result</title>
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
                        <br>
                        <br>
                        <br>


                        The score of ${group1.name} is ${group1.total_marks} <br>

                        The score of ${group2.name} is ${group2.total_marks} <br>

                        The score of ${group3.name} is ${group3.total_marks} <br>

                        <h1 style="size:30px; color: blue">Winner is ${winner}</h1>

                </div>





            </div>

            <div class="cleaner"></div>

        </div> <!-- end of templatemo_content_wrapper -->

        <div id="templatemo_footer">

            This is Footer
        </div><!-- end of footer -->

    </div> <!-- end of templatemo_wrapper_inner -->

</div> <!-- end of templatemo_wrapper_outter -->
</div>


</body>
</html>
