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


                        <h2>Quiz Result</h2>
                    </div>

                    <c:forEach items="${questionAndSelectedAnswer}" var="questionAndAnswer">

                        ----------------------------------------------------------------------------------------------<br>
                        Question :${questionAndAnswer.question.question}<br>
                        ----------------------------------------------------------------------------------------------<br>
                        <br>
                        Option 1 :
                        ${questionAndAnswer.question.option1}
                        <br>
                        Option 2 :
                        ${questionAndAnswer.question.option2}
                        <br>
                        Option 3 :
                        ${questionAndAnswer.question.option3}
                        <br>
                        Option 4 :
                        ${questionAndAnswer.question.option4}
                        <br>
                        Correct Answer :
                        ${questionAndAnswer.question.correctAnswer}
                        <br>
                        Selected Answer :
                        ${questionAndAnswer.answer}
                        <br>
                        <br>
                        <c:if test="${questionAndAnswer.question.correctAnswer==questionAndAnswer.answer}">
                            <p style="color: #4CAF50;font-size: large">CORRECT</p>
                                </c:if>
                        <c:if test="${questionAndAnswer.question.correctAnswer!=questionAndAnswer.answer}">
                            <p style="color:red;font-size: large">WRONG</p>
                        </c:if>
                        <br>
                        ----------------------------------------------------------------------------------------------<br>
                        <br>
                        <br>
                    </c:forEach>

                    <b>Total Questions : 10</b><br>
                    <b>Correct Answers : ${totalCorrectAnswers}</b>

                    <br>

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
