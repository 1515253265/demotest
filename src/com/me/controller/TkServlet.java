package com.me.controller;

import com.me.entity.Course;
import com.me.entity.Tkmetrics;
import com.me.service.Impl.TkmetricsServiceImpl;
import com.me.service.TkmetricsService;

import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/TK")
public class TkServlet extends HttpServlet {
    private TkmetricsService tkmetricsService = new TkmetricsServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
    String method = req.getParameter("method");
        if(method == null){
        method = "findAllTk";
    }
    switch (method){
        case "findAllTk":
            String cnoStr = req.getParameter("cno");
            String snoStr = req.getParameter("sno");
            String pageStr = req.getParameter("page");
            Integer page = Integer.parseInt(pageStr);
            Integer cno = Integer.parseInt(cnoStr);
            Integer sno = Integer.parseInt(snoStr);
            List<Tkmetrics> tkmetricsList = tkmetricsService.findAllTk(sno,cno);
            req.setAttribute("list",tkmetricsList);
            req.getRequestDispatcher("tkxinxi.jsp").forward(req,resp);
            break;
        case "handle":
            String tnoStr = req.getParameter("tno");
            String stateStr = req.getParameter("state");
            pageStr = req.getParameter("page");
            page = Integer.parseInt(pageStr);
            cnoStr = req.getParameter("cno");
            snoStr = req.getParameter("sno");
            Integer c = Integer.parseInt(cnoStr);
            Integer s = Integer.parseInt(snoStr);
            Integer tno = Integer.parseInt(tnoStr);
            Integer state = Integer.parseInt(stateStr);
            tkmetricsService.handleTk(state,tno);
            resp.sendRedirect("/TK?method=findAllTk&cno="+c+"&sno="+s+"&page="+page);
            break;
        case"findCno":
            snoStr = req.getParameter("sno");
            sno = Integer.parseInt(snoStr);
    }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        doPost(req,resp);
    }
}
