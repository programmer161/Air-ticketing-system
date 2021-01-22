package com.bisheflight.bisheflightmain.controller;


import com.bisheflight.bisheflightmain.model.Flight;
import com.bisheflight.bisheflightmain.model.Orderticket;
import com.bisheflight.bisheflightmain.service.FlightService;
import com.bisheflight.bisheflightmain.service.OrderticketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
public class OrderTicket {

    @Autowired
    private OrderticketService orderService;

    @Autowired
    private FlightService flightService;


    @RequestMapping(value = "/selectFlight",method = RequestMethod.GET)
    public List<Flight> selectFlight(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Credentials", "true");

        String startAirport = request.getParameter("startCity");
        String endAirport = request.getParameter("endCity");
        return orderService.selectFlight(startAirport,endAirport);
    }

    //订购按钮后的查询
    @RequestMapping(value = "/forOrderSelect",method = RequestMethod.GET)
    public List<Flight> forOrderSelect(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Credentials", "true");

        String startAirport = request.getParameter("orderStartCity");
        String endAirport = request.getParameter("orderEndCity");
        String flightNo = request.getParameter("flightNo");
        return orderService.forOrderSelect(startAirport,endAirport,flightNo);
    }

    //订购操作
    @RequestMapping(value = "/order",method = RequestMethod.POST)
    public String orderTicket(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Credentials", "true");

        Flight flight = new Flight();

        //取随机数在1-10000000
        Random random = new Random();
        int number = random.nextInt(10000000) % (10000000-1+1) + 1;

        Orderticket order = new Orderticket();
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
        if(a.equals("MU")){
            order.setOrderNo("MU" + number);
        }
        order.setPrice(Float.valueOf(request.getParameter("price")));
        order.setPerson(request.getParameter("passengerName"));
        order.setPhone(request.getParameter("phoneNumber"));
        order.setidcard(request.getParameter("IDCard"));
        order.setOrderStatus(request.getParameter("status"));
        order.setCreateTime(new Date());

        //对应舱位数-1
        flight = flightService.getById(Integer.valueOf(request.getParameter("id")));
        flight.setId(Integer.valueOf(request.getParameter("id")));
        if(request.getParameter("selectClass").equals("头等舱")){
            System.out.println("进来了");
            flight.setFirstClassAmount(flight.getFirstClassAmount() - 1);
        }else if(request.getParameter("selectClass").equals("商务舱")){
            flight.setBusinessClassAmount(flight.getBusinessClassAmount() - 1);
        }else if(request.getParameter("selectClass").equals("经济舱")){
            flight.setEconomyClassAmount(flight.getEconomyClassAmount() - 1);
        }


        flightService.updateById(flight);
        boolean result = orderService.save(order);

        if (result) {
            return "successful";
        }else{
            return "error";
        }
    }


}
