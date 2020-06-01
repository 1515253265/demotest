package com.me.controller;

import com.me.entity.Course;
import com.me.entity.Student;
import com.me.entity.Teacher;
import com.me.entity.Tkmetrics;
import com.me.repository.CourseRepository;
import com.me.repository.impl.CourseRepositoryImpl;
import com.me.service.CourseService;
import com.me.service.Impl.CourseServiceImpl;
import com.me.service.Impl.LoginServiceImpl;
import com.me.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private LoginService loginService = new LoginServiceImpl();
    private CourseService courseService = new CourseServiceImpl();
    private CourseRepository courseRepository = new CourseRepositoryImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
        Object object = loginService.login(username, password, type);
        if (object != null) {
            HttpSession session = request.getSession();
            switch (type) {
                case "student"://跳转到首页
                    Student student = (Student) object;
                    session.setAttribute("student", student);
                    List<Course> list = courseRepository.findAll(username);
                    request.setAttribute("list",list);
                   /* List<> list = bookService.findAll(1);

                    request.setAttribute("list", list);
                    request.setAttribute("dataPrePage", 6);
                    request.setAttribute("currentPage", 1);
                    request.setAttribute("pages", bookService.getPages()); */
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                case "teacher":
                    Teacher teacher = (Teacher) object;
                    session.setAttribute("teacher", teacher);
                    List<Tkmetrics> list1 = courseService.findAllByTeacher(username);
                    request.setAttribute("list",list1);
                    //跳转到管理员首页
                    request.getRequestDispatcher("teacher.jsp").forward(request,response);
                    break;
            }
        } else {
            System.out.println("这里啊");
            response.sendRedirect("login.jsp");
        }
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws
            ServletException,IOException{
        doPost(request,response);
    }

}
