package controller;

import domains.Group;
import domains.Question;
import domains.User;
import service.GroupQuizService;
import service.QuestionService;
import service.QuizService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Created by rocks on 11/12/2016.
 */
@WebServlet(name = "GroupQuizServlet")
public class GroupQuizServlet extends HttpServlet {
    int groupTurn=0;
    ArrayList <Group> groups=new ArrayList<>();
    int totalNumberOfGroup;
    boolean pass=false;
    int passcount=0;
    String passquestionID;
    ArrayList<String> totalQuestionID=new ArrayList<>();
    int tempGroupTurn;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = request.getParameter("page");
        if (page.equalsIgnoreCase("groups")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("groupQuiz/createGroup.jsp");
            requestDispatcher.forward(request, response);
        }
        if (page.equalsIgnoreCase("listquestions")) {
            Group group = groups.get(groupTurn);
            request.setAttribute("group", group);
            request.setAttribute("questionList", totalQuestionID);
            RequestDispatcher rd = request.getRequestDispatcher("groupQuiz/showQuestions.jsp");
            rd.forward(request, response);
        }
        if (page.equalsIgnoreCase("playgroupquiz")) {
            Group currentGroup = groups.get(groupTurn);
            String questionid = request.getParameter("id");
            Question question = returnQuestion(questionid);
            request.setAttribute("group", currentGroup);
            request.setAttribute("question", question);
            RequestDispatcher rd = request.getRequestDispatcher("groupQuiz/showQuestion.jsp");
            rd.forward(request, response);
        }


        if (page.equalsIgnoreCase("answersubmit")) {
            String id = request.getParameter("id");
            String selectedAnswer = request.getParameter("answer");
            {
                if (selectedAnswer == null) {
                    pass = true;
                    passcount++;
                    passquestionID = id;
                    if (passcount == 3) {
                        groupTurn=(((groupTurn+passcount)%3)+1);
                        pass = false;
                        passcount = 0;
                    }
                } else {
                    pass = false;
                    passcount = 0;
                    QuestionService questionService = new QuestionService();
                    Question question = questionService.getQuestion(id);
                    Group group = groups.get(groupTurn+passcount);
                    if (question.getCorrectAnswer().equalsIgnoreCase(selectedAnswer)) {
                        int marks = group.getTotal_marks() + 1;
                        group.setTotal_marks(marks);

                    }
                }
                if (totalQuestionID.size() == 0) {
                    String winner="";
                    request.setAttribute("group1", groups.get(0));
                    request.setAttribute("group2", groups.get(1));
                    request.setAttribute("group3", groups.get(2));

                    if((groups.get(0).getTotal_marks()>groups.get(1).getTotal_marks()) &&(groups.get(0).getTotal_marks() > groups.get(2).getTotal_marks()))
                    {
                        winner=groups.get(0).getName();

                    }
                    else if((groups.get(1).getTotal_marks()>groups.get(0).getTotal_marks())&&(groups.get(1).getTotal_marks()>groups.get(2).getTotal_marks()))
                    {
                        winner=groups.get(1).getName();
                    }
                    else if((groups.get(2).getTotal_marks()>groups.get(0).getTotal_marks())&&(groups.get(2).getTotal_marks()>groups.get(1).getTotal_marks()))
                    {
                        winner=groups.get(2).getName();
                    }
                    else {
                        winner="The winner can't be decided because of tie";
                    }
                    request.setAttribute("winner",winner);
                    RequestDispatcher rd = request.getRequestDispatcher("groupQuiz/quizResult.jsp");
                    rd.forward(request, response);
                } else {
                    groupTurn++;
                    if (groupTurn == 3) {
                        groupTurn = 0;
                    }
                    else if(groupTurn==4)
                    {
                        groupTurn=1;
                    }
                    Group groupa = groups.get(groupTurn);
                    if (pass == false) {
                        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/groupquize?page=listquestions"));
                    } else {
                        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/groupquize?page=playgroupquiz&&id=" + passquestionID));
                    }
                }

            }
        }

            if (page.equalsIgnoreCase("createGroups")) {
                Group group1 = new Group();
                String groupName1 = request.getParameter("group1");
                group1.setName(groupName1);
                groups.add(group1);
                Group group2 = new Group();
                String groupName2 = request.getParameter("group2");
                group2.setName(groupName2);
                groups.add(group2);
                Group group3 = new Group();
                String groupName3 = request.getParameter("group3");
                group3.setName(groupName3);
                groups.add(group3);
                GroupQuizService groupQuizService = new GroupQuizService();
                totalQuestionID.addAll(groupQuizService.getAllQuestionsList());


                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/groupquize?page=listquestions"));


            }

            checkSession(request, response, page);

        }


    public Question returnQuestion(String questionId)
    {
        GroupQuizService groupQuizService=new GroupQuizService();
        totalQuestionID.remove(questionId);
        Question question=groupQuizService.getQuestion(questionId) ;
        return question;

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
