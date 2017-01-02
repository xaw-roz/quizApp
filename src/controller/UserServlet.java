package controller;

import domains.User;
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

@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");

        checkSession(request, response, page);
        if (page.equalsIgnoreCase("login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = new UserService().getUser(username, password);
            if (user!=null) {

                request.setAttribute("message","Login Success!");
                HttpSession session = request.getSession(false);
                session.setAttribute("user", user);
                RequestDispatcher rd = request.getRequestDispatcher("user/home.jsp");
                rd.forward(request,response);
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request,response);
            }



        }
        if (page.equalsIgnoreCase("logout")) {
            HttpSession session = request.getSession(false);
            session.invalidate();
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
        }
        if (page.equalsIgnoreCase("home")) {
            RequestDispatcher rd = request.getRequestDispatcher("user/home.jsp");
            rd.forward(request,response);
        }
        if (page.equalsIgnoreCase("list")) {
            redirectToList(request, response);
        }
        if(page.equalsIgnoreCase("udelete"))
        {
            String id=request.getParameter("id");
            UserService usr = new UserService();
            usr.deleteUser(id);
            redirectToList(request,response);
        }
        if(page.equalsIgnoreCase("uedit"))
        {
            String id=request.getParameter("id");
            UserService userService=new UserService();
            User user=userService.getUser(id);
            request.setAttribute("user",user);
            request.setAttribute("task","edit");
            RequestDispatcher rd = request.getRequestDispatcher("user/createOrEditUser.jsp");
            rd.forward(request, response);

        }
        if(page.equalsIgnoreCase("edit"))
        {
            String id=request.getParameter("id");
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            String role=request.getParameter("role");
            UserService userService=new UserService();
            userService.editUser(id,username,password,role);
            redirectToList(request, response);
        }
        if(page.equalsIgnoreCase("uAdd"))
        {
            request.setAttribute("task","add");
            RequestDispatcher rd = request.getRequestDispatcher("user/createOrEditUser.jsp");
            rd.forward(request, response);
        }
        if(page.equalsIgnoreCase("addUser"))
        {
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            String role=request.getParameter("role");
            UserService userService=new UserService();
            userService.addU(username,password,role);
            redirectToList(request, response);
        }



    }

    public void checkSession(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
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

    public void redirectToList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = new UserService().getUserList();
        request.setAttribute("userList",userList);
        RequestDispatcher rd = request.getRequestDispatcher("user/list.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
