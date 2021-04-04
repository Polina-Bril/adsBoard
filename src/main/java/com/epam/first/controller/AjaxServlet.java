package com.epam.first.controller;

import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AjaxServlet", urlPatterns = {"/ajax_servlet"})
public class AjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String json = null;
        String type = request.getParameter("button");
        if(type.equals("1")) {
            response.setContentType("text/plain");
            json = "Привет AJAX";
        } else if (type.equals("2")) {
            response.setContentType("application/json");
            List<String> newLlist = new ArrayList<>();
            newLlist.add("item1");
            newLlist.add("item2");
            newLlist.add("item3");
            json = new Gson().toJson(newLlist);
        } else if(type.equals("3")){
            List<String> searchList = new ArrayList<>();
            searchList.add("Мама");
            searchList.add("Милу");
            searchList.add("мылом");
            searchList.add("мыла");
            searchList.add("Мила");
            searchList.add("мыла");
            searchList.add("не");
            searchList.add("любила");
            searchList.add("Мыло");
            searchList.add("Мила");
            searchList.add("уронила");
            json = new Gson().toJson(searchList);
        }
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}