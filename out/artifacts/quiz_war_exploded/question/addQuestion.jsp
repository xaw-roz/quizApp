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


                            <h2>Add new Question</h2>
                        </div>

                        <form action="addQuestion" method="post">
                            <input type="hidden" name="page" value="addQuestion"/>
                            <label>Question:</label>
                            <input type="text" name="question" class="form-control" required>
                            <br>
                            <label>Option 1:</label>
                            <input type="text" name="option1" class="form-control" required>
                            <br>
                            <label>Option 2:</label>
                            <input type="text" name="option2" class="form-control" required>
                            <br>
                            <label>Option 3:</label>
                            <input type="text" name="option3" class="form-control" required>
                            <br>
                            <label>Option 4:</label>
                            <input type="text" name="option4" class="form-control" required>
                            <br>
                            <label>Correct Answer:</label>
                            <input type="radio" name="correctAnswer" value="1" > :1
                            <input type="radio" name="correctAnswer" value="2" > :2
                            <input type="radio" name="correctAnswer" value="3" > :3
                            <input type="radio" name="correctAnswer" value="4" > :4
                            <br>
                            <label>Subject:</label>
                            <select name="subject">
                                <option value="science">Science</option>
                                <option value="gk">GK</option>
                                <option value="computerscience">Computer Science</option>
                            </select>

                            <br>
                            <input type="submit" value="Add Question" class="btn btn-default">


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
