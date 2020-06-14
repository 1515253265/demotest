package com.me.controller;

import com.me.entity.Course;
import com.me.entity.Tkmetrics;
import com.me.service.CourseService;
import com.me.service.Impl.CourseServiceImpl;
import com.me.service.Impl.TeacherServiceImpl;
import com.me.service.Impl.TkmetricsServiceImpl;
import com.me.service.TeacherService;
import com.me.service.TkmetricsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/teacher")
public class TeacherServlet extends HttpServlet {

        private TeacherService teacherService = new TeacherServiceImpl();
        private CourseService courseService = new CourseServiceImpl();
        private TkmetricsService tkmetricsService = new TkmetricsServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        String method = req.getParameter("method");
        String username = req.getParameter("username");
        if( method ==null){
            method = "findAll";
        }
        switch (method){
            case "findAll"://查找该老师的学生逃课信息
                String pageStr = req.getParameter("page");
                Integer page = Integer.parseInt(pageStr);
                List<Tkmetrics> list = courseService.findAllByTeacher(username,page);
                req.setAttribute("list",list);
                req.setAttribute("dataPrePage",10);
                req.setAttribute("currentPage",page);
                req.setAttribute("pages",courseService.getTeacherPages(username));
                //跳转到管理员首页
                req.getRequestDispatcher("teacher.jsp").forward(req,resp);
                break;
            case "handle"://修改逃课记录状态
                String tnoStr = req.getParameter("tno");
                Integer tno = Integer.parseInt(tnoStr);
                String stateStr = req.getParameter("state");
                Integer state = Integer.parseInt(stateStr);
                if(state == 2){
                teacherService.updateByTno(tno,2);
                }
                if(state == 4){
                 teacherService.updateByTno(tno,4);
                }
                resp.sendRedirect("/teacher?method=findAll&page=1&username="+username);
                break;
            case "delete"://删除逃课记录
                tnoStr = req.getParameter("tno");
                tno = Integer.parseInt(tnoStr);
                teacherService.deleteByTno(tno);
                resp.sendRedirect("/teacher?method=findAll&page=1&username="+username);
                break;
            case "findAllByLno"://查找该课程所有学生的名字
                String lnoStr = req.getParameter("lno");
                Integer lno = Integer.parseInt(lnoStr);
                List<Course> courseList = courseService.findAllByLno(lno);
                req.setAttribute("list",courseList);
                req.getRequestDispatcher("/insert.jsp").forward(req,resp);
                break;
            case "insert"://插入学生的逃课信息
                String cnoStr = req.getParameter("cno");
                String snoStr = req.getParameter("sno");
                String teacherIdStr = req.getParameter("lno");
                Integer cno = Integer.parseInt(cnoStr);
                Integer sno = Integer.parseInt(snoStr);
                lno = Integer.parseInt(teacherIdStr);
                tkmetricsService.insert(cno,sno,lno);
                resp.sendRedirect("/teacher?method=findAllByLno&lno="+lno);
                break;
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);
        doPost(req,resp);
    }
}
