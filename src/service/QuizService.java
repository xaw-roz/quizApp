package service;

import domains.Question;
import utils.DatabaseConnection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.DoubleSummaryStatistics;

/**
 * Created by rocks on 10/24/2016.
 */
public class QuizService {
    public Question getRandomQuestion()
    {

            String query="SELECT * FROM question order by rand() limit 1";
            PreparedStatement preparedStatement=new DatabaseConnection().getPreparedStatement(query);
        Question question = new Question();
            try {
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return question;

    }
    public void storeResult(int userID, Double marks)
    {
        String query="insert into quiz (user_id,score,date_attempted) values (?,?,NOW())";
        PreparedStatement preparedStatement=new DatabaseConnection().getPreparedStatement(query);

        try {
            preparedStatement.setInt(1,userID);
            preparedStatement.setDouble(2,marks);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
