package com.bisheflight.bisheflightmain.controller;

import com.bisheflight.bisheflightmain.model.Customer;
import com.bisheflight.bisheflightmain.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customerlogin", method = RequestMethod.POST)
    @ResponseBody
    public String customerLogin(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        /*
         *解决携带Cookie跨域无法访问资源问题
         * https://blog.csdn.net/qq_26566331/article/details/72478923
         * */
        response.setHeader("Access-Control-Allow-Credentials", "true");

        //获取表单参数的值
        String mobilePhone = request.getParameter("username");
        String password = request.getParameter("password");
        String customerlogin = customerService.login(mobilePhone,password);
        if(customerlogin == null)
        {
            return "error";
        }else{
            return "successful";
        }
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(HttpServletRequest request,HttpSession session,HttpServletResponse response){

        response.setHeader("Access-Control-Allow-Credentials", "true");

        Customer customer = new Customer();
        customer.setMobilephone(request.getParameter("phone"));
        customer.setNickname(request.getParameter("nickName"));
        customer.setPassword(request.getParameter("password"));
        customer.setEmail(request.getParameter("email"));
        customer.setRealname(request.getParameter("realName"));
        customer.setSex(request.getParameter("selectSex"));
        customer.setCreatetime(new Date());
        boolean result = customerService.save(customer);
        if (result) {
            return "successful";
        }else{
            return "error";
        }
    }

    //查询所有信息
    @RequestMapping(value = "/searchAllCustomer",method = RequestMethod.GET)
    public List<Customer> searchAllCustomer(HttpServletRequest request,HttpSession session,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Credentials", "true");

        return customerService.list();
    }

    //模糊查询
    @RequestMapping(value = "/searchByCustomerKeyword",method = RequestMethod.GET)
    public List<Customer> searchByKeyword(HttpServletRequest request,HttpSession session,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Credentials", "true");

        String keyword = request.getParameter("keyword");
        return customerService.searchByKeyword(keyword);
    }

    @RequestMapping(value = "/deleteByCustomerId",method = RequestMethod.POST)
    public String deleteById(HttpServletRequest request,HttpSession session,HttpServletResponse response,@RequestParam("userID") Integer id){
        response.setHeader("Access-Control-Allow-Credentials", "true");

        /*@RequestParam等价于request.getParameter
        * 其中value对应axios中的参数名
        * */

        boolean result = customerService.removeById(id);
        if(result){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping(value = "/updateCustomer",method = RequestMethod.POST)
    public String update(HttpServletRequest request,HttpSession session,HttpServletResponse response,@RequestParam("userID") Integer id){

        response.setHeader("Access-Control-Allow-Credentials", "true");

        Customer customer = new Customer();
        customer.setId(id);
        customer.setRealname(request.getParameter("realName"));
        customer.setMobilephone(request.getParameter("phone"));
        customer.setNickname(request.getParameter("nickName"));
        customer.setEmail(request.getParameter("email"));
        customer.setSex(request.getParameter("selectSex"));
        customer.setBirthday(request.getParameter("birthday"));
        boolean result = customerService.updateById(customer);
        if (result) {
            return "successful";
        }else{
            return "error";
        }
    }

}
