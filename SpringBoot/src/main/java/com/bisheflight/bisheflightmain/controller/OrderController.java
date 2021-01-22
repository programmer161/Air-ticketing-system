package com.bisheflight.bisheflightmain.controller;


import com.bisheflight.bisheflightmain.model.Flight;
import com.bisheflight.bisheflightmain.model.Orderticket;
import com.bisheflight.bisheflightmain.service.FlightService;
import com.bisheflight.bisheflightmain.service.OrderticketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

//admin order
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
public class OrderController {

    @Autowired
    private OrderticketService orderService;

    @Autowired
    private FlightService flightService;

    //模糊查询
    @RequestMapping(value = "/orderKeyword",method = RequestMethod.GET)
    public List<Orderticket> searchByKeyword(HttpServletRequest request,HttpSession session,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Credentials", "true");

        String keyword = request.getParameter("keyword");
        return orderService.searchByKeyword(keyword);
    }

    //查询所有信息
    @RequestMapping(value = "/searchAllOrders",method = RequestMethod.GET)
    public List<Orderticket> searchAllOrders(HttpServletRequest request, HttpSession session, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Credentials", "true");

        return orderService.list();
    }

    //更新操作
    @RequestMapping(value = "/updateOrders",method = RequestMethod.POST)
    public String updateOrderTicket(HttpServletRequest request, HttpServletResponse response,@RequestParam("orderID") Integer id){
        response.setHeader("Access-Control-Allow-Credentials", "true");


        Orderticket order = new Orderticket();
        order.setId(id);
        order.setStartCity(request.getParameter("startCity"));
        order.setEndCity(request.getParameter("endCity"));
        order.setFlightClass(request.getParameter("selectClass"));
        try{
            order.setArrivalTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(request.getParameter("arrivalTime")));
            order.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(request.getParameter("startTime")));
        }catch (ParseException e){
            e.printStackTrace();
        }
        order.setFlightNo(request.getParameter("flightNo"));
        String a = request.getParameter("flightNo").substring(0,2);

        order.setPrice(Float.valueOf(request.getParameter("price")));
        order.setPerson(request.getParameter("passengerName"));
        order.setPhone(request.getParameter("phoneNumber"));
        order.setidcard(request.getParameter("IDCard"));
        order.setOrderStatus(request.getParameter("status"));

        boolean result = orderService.updateById(order);
        if (result) {
            return "successful";
        }else{
            return "error";
        }
    }

    //删除
    @RequestMapping(value = "/deleteByOrderId",method = RequestMethod.POST)
    public String deleteById(HttpServletRequest request,HttpSession session,HttpServletResponse response,@RequestParam("orderID") Integer id){
        response.setHeader("Access-Control-Allow-Credentials", "true");

        /*
        * 逻辑参照CustomerOrderController
        * */
        List<Orderticket> orderInfo = orderService.selectOrderByID(id);
        System.out.println(orderInfo);
        List<Flight> flightInfo = orderService.deleteToSelectFlight(orderInfo.get(0).getStartTime(),orderInfo.get(0).getArrivalTime(),orderInfo.get(0).getFlightNo());
        System.out.println(flightInfo);
        if(orderInfo.get(0).getFlightClass().equals("头等舱")){
            System.out.println("进来了");
            flightInfo.get(0).setFirstClassAmount(flightInfo.get(0).getFirstClassAmount() + 1);
        }else if(orderInfo.get(0).getFlightClass().equals("商务舱")){
            flightInfo.get(0).setBusinessClassAmount(flightInfo.get(0).getBusinessClassAmount() + 1);
        }else if(orderInfo.get(0).getFlightClass().equals("经济舱")){
            flightInfo.get(0).setEconomyClassAmount( flightInfo.get(0).getEconomyClassAmount() + 1);
        }
        flightService.updateBatchById(flightInfo);
        boolean result = orderService.removeById(id);
        if(result){
            return "success";
        }else {
            return "error";
        }
    }

}
