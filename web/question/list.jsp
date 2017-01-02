<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Demo Project</title>
    <link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
    <link href="css/table.css" rel="stylesheet" type="text/css" />
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>

<div id="templatemo_wrapper_outter">

    <div id="templatemo_wrapper_inner">

        <div id="templatemo_header">
            This is Header
        </div> <!-- end of templatemo_header -->

        <%@include file="../includes/header.jsp"%>
        <!-- end of templatemo_menu -->

        <div id="templatemo_content_wrapper">

            <div id="templatemo_content">

                <div class="content_section">

                    <h2>Question List</h2>
                </div>
                <h2><a href="qAdd?page=qAdd">Add New Question</a></h2>
                <table>
                    <tr>
                        <th>Question</th>
                        <th>Option1</th>
                        <th>Option2</th>
                        <th>Option3</th>
                        <th>Option4</th>
                        <th>Correct Answer</th>
                        <th>Subject</th>
                    </tr>
                    <c:forEach items="${questionList}" var="question">
                        <tr>
                            <td>${question.question}</td>
                            <td>${question.option1}</td>
                            <td>${question.option2}</td>
                            <td>${question.option3}</td>
                            <td>${question.option4}</td>
                            <td>${question.correctAnswer}</td>
                            <td>${question.subject}</td>

                            <td><a href="qedit?page=qedit&id=${question.id}"><img src="../images/edit.jpg" height="30px" width="40px" alt="Edit"></a></td>
                            <td><a href="qdelete?page=qdelete&id=${question.id}"><img src="../images/delete.jpg" height="30px" width="40px" alt="Delete"></a></td>
                        </tr>
                    </c:forEach>
                </table>

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



