package controller;

import domains.Question;
import domains.User;
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
import java.util.HashMap;

/**
 * Created by rocks on 10/24/2016.
 */
@WebServlet(name = "QuizServlet")
public class QuizServlet extends HttpServlet {

    ArrayList <Integer> selectedQuestions=new ArrayList<>();
    int totalQuestions;
    int totalCorrectAnswers;

    public class QuestionAndAnswer{
        Question question;

        public Question getQuestion() {
            return question;
        }

        public void setQuestion(Question question) {
            this.question = question;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        String answer;
    }
    ArrayList <QuestionAndAnswer> questionAndSelectedAnswer=new ArrayList<>();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        UserServlet userServlet=new UserServlet();
        userServlet.checkSession(request, response, page);


        if(page.equalsIgnoreCase("playquiz")) {
            totalQuestions=0;
            totalCorrectAnswers=0;
            selectedQuestions.clear();
            questionAndSelectedAnswer.clear();

            selectUniqueQuestion(request, response);
        }

        if(page.equalsIgnoreCase("submitAnswer"))
        {
            String id=request.getParameter("id");
            String selectedAnswer=request.getParameter("answer");
            QuestionService questionService=new QuestionService();
            Question question=questionService.getQuestion(id);
            if(question.getCorrectAnswer().equalsIgnoreCase(selectedAnswer))
            {
                totalCorrectAnswers++;
            }
            totalQuestions++;
            QuestionAndAnswer questionAndAnswer=new QuestionAndAnswer();
            questionAndAnswer.setQuestion(question);
            questionAndAnswer.setAnswer(selectedAnswer);
            questionAndSelectedAnswer.add(questionAndAnswer);
            if(totalQuestions<10)
            {

                selectUniqueQuestion(request,response);
            }
            else {
                request.setAttribute("totalCorrectAnswers",totalCorrectAnswers);
                request.setAttribute("questionAndSelectedAnswer",questionAndSelectedAnswer);
                RequestDispatcher rd=request.getRequestDispatcher("quiz/quizResult.jsp");
                rd.forward(request,response);
                HttpSession session = request.getSession(false);
                User user = (User)session.getAttribute("user");
                QuizService quizService=new QuizService();
                Date date=new Date();
                quizService.storeResult(user.getId(),((double)totalCorrectAnswers/(double) totalQuestions)*100);
            }

        }
    }

    private void selectUniqueQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        {
            QuizService quizService=new QuizService();
            Question question= quizService.getRandomQuestion();
            if(selectedQuestions.contains(question.getId()))
            {
                selectUniqueQuestion(request,response);
            }
            else {
                selectedQuestions.add(question.getId());
                request.setAttribute("question",question);
                RequestDispatcher requestDispatcher=request.getRequestDispatcher("quiz/playQuiz.jsp");
                requestDispatcher.forward(request,response);

            }


        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
