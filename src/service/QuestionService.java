package service;

import domains.Question;
import domains.User;
import utils.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rakesh-a on 9/14/2016.
 */
public class QuestionService {
    public void addQuestion(String question, String option1, String option2, String option3, String option4, String correctAnswer, String subject) {
        try {
            String query = "insert into question (question,option1,option2,option3,option4,correctAnswer,subject) values (?,?,?,?,?,?,?)";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
            pstm.setString(1, question);
            pstm.setString(2, option1);
            pstm.setString(3, option2);
            pstm.setString(4, option3);
            pstm.setString(5, option4);
            pstm.setString(6, correctAnswer);
            pstm.setString(7, subject);

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Question> getQuestionList() {

        List<Question> questionList = new ArrayList<Question>();
        try

        {
            String query = "select * from question";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);


            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setQuestion(rs.getString("question"));
                question.setOption1(rs.getString("option1"));
                question.setOption2(rs.getString("option2"));
                question.setOption3(rs.getString("option3"));
                question.setOption4(rs.getString("option4"));
                question.setCorrectAnswer(rs.getString("correctAnswer"));
                question.setSubject(rs.getString("subject"));

                questionList.add(question);
            }

        } catch (Exception e)

        {
            e.printStackTrace();
        }
        return questionList;
    }
    public void deleteQuestion(String id)
    {
        try{
            String query="delete from question where id="+id;
            PreparedStatement preparedStatement=new DatabaseConnection().getPreparedStatement(query);
            preparedStatement.execute();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public Question getQuestion(String id)
    {
        Question question=new Question();
        try{
            String query="select * from question where id="+id;
            PreparedStatement preparedStatement=new DatabaseConnection().getPreparedStatement(query);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next())
            {
                question.setId(rs.getInt("id"));
                question.setQuestion(rs.getString("question"));
                question.setOption1(rs.getString("option1"));
                question.setOption2(rs.getString("option2"));
                question.setOption3(rs.getString("option3"));
                question.setOption4(rs.getString("option4"));
                question.setCorrectAnswer(rs.getString("correctAnswer"));
                question.setSubject(rs.getString("subject"));

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return question;
    }

    public void editQuestion(String id,String question, String option1, String option2, String option3, String option4, String correctAnswer, String subject)
    {
        try{
            String query="update question set question=? ,option1=? ,option2=?, option3=? ,option4=?, correctAnswer=?, subject=? where id="+id;
          //  System.out.println(query);
            PreparedStatement preparedStatement=new DatabaseConnection().getPreparedStatement(query);
            preparedStatement.setString(1,question);
            preparedStatement.setString(2,option1);
            preparedStatement.setString(3,option2);
            preparedStatement.setString(4,option3);
            preparedStatement.setString(5,option4);
            preparedStatement.setString(6,correctAnswer);
            preparedStatement.setString(7,subject);

            preparedStatement.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }



}
