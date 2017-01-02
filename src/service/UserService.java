package service;

import domains.User;
import utils.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shreha on 8/25/2016.
 */
public class UserService {

    public User getUser(String name, String password) {
        User user = null;
        try {
        String query = "select * from user where username=? and password=?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);


            pstm.setString(1, name);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public List<User> getUserList() {
        List<User> userList = new ArrayList<User>();
        try {
            String query = "select * from user";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);


            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                userList.add(user);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
    public void deleteUser(String id)
    {
        String query="delete from user where id="+id;
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            pstm.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public User getUser(String id)
    {
        String query="select * from user where id="+id;
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        User user = new User();
        try {
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
//        System.out.println(user.getRole()+"  "+user.getUserName());
        return user;

    }
    public void editUser(String id,String username,String password,String role)
    {

        String query="UPDATE user\n" +
                "SET username='"+username+"',password='"+password+"',role='"+role+"'" +
                "WHERE id="+id ;
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try{
            pstm.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void addU(String username,String password,String role)
    {
        String query="Insert into user (username,password,role) values ('"+username+"','"+password+"','"+role+"')";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try{
            pstm.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
