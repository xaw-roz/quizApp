<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>EditQuestion</title>
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


                            <h2>Edit Question</h2>
                        </div>

                        <form action="/qedit" method="post">
                            <input type="hidden" name="page" value="editQuest"/>
                            <input type="hidden" name="id" value="${question.id}">
                            <label>Question:</label>
                            <input type="text" name="question" value="${question.question}" class="form-control" required>
                            <br>
                            <label>Option 1:</label>
                            <input type="text" name="option1" value="${question.option1}" class="form-control" required>
                            <br>
                            <label>Option 2:</label>
                            <input type="text" name="option2" value="${question.option2}" class="form-control" required>
                            <br>
                            <label>Option 3:</label>
                            <input type="text" name="option3" value="${question.option3}" class="form-control" required>
                            <br>
                            <label>Option 4:</label>
                            <input type="text" name="option4" value="${question.option4}" class="form-control" required>
                            <br>
                            <label>Correct Answer:</label>
                            <c:if test="${question.correctAnswer==question.option1}">
                            <input type="radio" name="correctAnswer" value="1" checked> :1
                            </c:if>
                            <c:if test="${question.correctAnswer!=question.option1}">
                                <input type="radio" name="correctAnswer" value="1"> :1
                            </c:if>

                            <c:if test="${question.correctAnswer==question.option2}">
                                <input type="radio" name="correctAnswer" value="2" checked :2
                            </c:if>
                            <c:if test="${question.correctAnswer!=question.option2}">
                                <input type="radio" name="correctAnswer" value="2"> :2
                            </c:if>



                            <c:if test="${question.correctAnswer==question.option3}">
                                <input type="radio" name="correctAnswer" value="3" checked> :3
                            </c:if>
                            <c:if test="${question.correctAnswer!=question.option3}">
                                <input type="radio" name="correctAnswer" value="3"> :3
                            </c:if>



                            <c:if test="${question.correctAnswer==question.option4}">
                                <input type="radio" name="correctAnswer" value="4" checked> :4
                            </c:if>
                            <c:if test="${question.correctAnswer!=question.option4}">
                                <input type="radio" name="correctAnswer" value="4"> :4
                            </c:if>

                            <br>
                            <label>Subject:</label>
                            <select name="subject">
                                <c:if test="${question.subject=='science'}">
                                <option value="science" selected>Science</option></c:if>
                                <c:if test="${question.subject!='science'}">
                                    <option value="science">Science</option></c:if>

                                <c:if test="${question.subject=='gk'}">
                                    <option value="gk" selected>GK</option></c:if>
                                <c:if test="${question.subject!='gk'}">
                                    <option value="gk">GK</option></c:if>

                                <c:if test="${question.subject=='programming'}">
                                    <option value="programming" selected>programming</option></c:if>
                                <c:if test="${question.subject!='programming'}">
                                    <option value="programming">programming</option></c:if>
                            </select>

                            <br>
                            <input type="submit" value="Commit Changes" class="btn btn-default">


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
