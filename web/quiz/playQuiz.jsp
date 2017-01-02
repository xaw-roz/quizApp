<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>AddQuestion</title>
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


                        <h2>Play Quiz</h2>
                    </div>

                    <form action="quizplay" method="post">
                        <input type="hidden" name="page" value="submitAnswer"/>
                        <input type="hidden" name="id" value="${question.id}">

                        <center>${question.question}</center>
                        <br>
                        <input type="radio" name="answer" value="${question.option1}" >  ${question.option1}
                        <br>
                        <input type="radio" name="answer" value="${question.option2}" >  ${question.option2}
                        <br>
                        <input type="radio" name="answer" value="${question.option3}" >  ${question.option3}
                        <br>
                        <input type="radio" name="answer" value="${question.option4}" >  ${question.option4}
                        <br>
                        <input type="submit" value="Next" class="btn btn-default">


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
