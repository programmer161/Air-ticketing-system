package com.bisheflight.bisheflightmain.controller;

import com.bisheflight.bisheflightmain.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
    @ResponseBody
    public String adminLogin(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        response.setHeader("Access-Control-Allow-Credentials", "true");

        //获取表单参数的值
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String adminlogin = administratorService.login(username,password);
        if(adminlogin == null)
        {
            return "error";
        }else{
            return "successful";
        }
    }
}
