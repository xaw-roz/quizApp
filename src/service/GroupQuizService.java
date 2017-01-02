package service;

import domains.Question;
import utils.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by rocks on 11/12/2016.
 */
public class GroupQuizService {

    public ArrayList<String> getAllQuestionsList() {

        ArrayList <String> questionIds=new ArrayList<>();
        try

        {
            String query = "select id from question";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);


            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                questionIds.add(Integer.toString(rs.getInt("id")));

            }

        } catch (Exception e)

        {
            e.printStackTrace();
        }
        return questionIds;
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

}
