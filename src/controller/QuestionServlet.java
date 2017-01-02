package controller;

import domains.Question;
import domains.User;
import service.QuestionService;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by rakesh-a on 9/14/2016.
 */
@WebServlet(name = "QuestionServlet")
public class QuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = request.getParameter("page");

        checkSession(request, response, page);

        if (page.equalsIgnoreCase("qAdd")) {
            request.setAttribute("task","add");
            RequestDispatcher rd=request.getRequestDispatcher("question/addQuestion.jsp");
            rd.forward(request,response);
        }
        if (page.equalsIgnoreCase("addQuestion")) {
            String correctAnswer="";
            String question=request.getParameter("question");
            String option1=request.getParameter("option1");
            String option2=request.getParameter("option2");
            String option3=request.getParameter("option3");
            String option4=request.getParameter("option4");
            Integer correctOption=Integer.parseInt(request.getParameter("correctAnswer"));
            correctAnswer = chooseCorrectAnswer(option1, option2, option3, option4, correctOption);
            String subject=request.getParameter("subject");
            QuestionService questionService=new QuestionService();
            questionService.addQuestion(question,option1,option2,option3,option4,correctAnswer,subject);
            redirectToQuestionList(request,response);

        }
        if (page.equalsIgnoreCase("list")) {
            System.out.println("abc");
            redirectToQuestionList(request, response);
        }
        if(page.equalsIgnoreCase("qdelete"))
        {
            String id=request.getParameter("id");
            QuestionService questionService=new QuestionService();
            questionService.deleteQuestion(id);
            redirectToQuestionList(request,response);
        }
        if(page.equalsIgnoreCase("qedit"))
        {
            String id=request.getParameter("id");
            QuestionService questionService=new QuestionService();
            Question question=questionService.getQuestion(id);
            request.setAttribute("question",question);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("question/editQuestion.jsp");
            requestDispatcher.forward(request,response);
        }
        if(page.equalsIgnoreCase("editQuest"))
        {
            System.out.println("in edit");
            String correctAnswer;
            String id=request.getParameter("id");
            String question=request.getParameter("question");
            String option1=request.getParameter("option1");
            String option2=request.getParameter("option2");
            String option3=request.getParameter("option3");
            String option4=request.getParameter("option4");
            Integer correctOption=Integer.parseInt(request.getParameter("correctAnswer"));
            correctAnswer = chooseCorrectAnswer(option1, option2, option3, option4, correctOption);
            String subject=request.getParameter("subject");
            QuestionService questionService=new QuestionService();
            questionService.editQuestion(id,question,option1,option2,option3,option4,correctAnswer,subject);
            redirectToQuestionList(request,response);
        }




    }

    private String chooseCorrectAnswer(String option1, String option2, String option3, String option4, Integer correctOption) {
        String correctAnswer="";
        switch (correctOption)
        {
            case 1:
            {
                correctAnswer=option1;
                break;
            }
            case 2:
            {
                correctAnswer=option2;
                break;
            }
            case 3:
            {
                correctAnswer=option3;
                break;
            }
            case 4:
            {
                correctAnswer=option4;
            }
        }
        return correctAnswer;
    }

    private void redirectToQuestionList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Question> questionList;
        questionList=new QuestionService().getQuestionList();
        request.setAttribute("questionList",questionList);
        RequestDispatcher rd = request.getRequestDispatcher("question/list.jsp");
        rd.forward(request,response);
    }

    private void checkSession(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        if (page == null) {
            page = "XXX";
        }
        if (!page.equalsIgnoreCase("login")) {
            HttpSession session = request.getSession(false);
            User user = (User)session.getAttribute("user");
            if (user == null) {
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request,response);
            }
        }
    }






    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
