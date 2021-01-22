package com.bisheflight.bisheflightmain.controller;


import com.bisheflight.bisheflightmain.model.Flight;
import com.bisheflight.bisheflightmain.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
public class FlightController {

    @Autowired
    private FlightService flightService;


    @RequestMapping(value = "/addFlight",method = RequestMethod.POST)
    public String addFlight(HttpServletRequest request, HttpSession session, HttpServletResponse response){

        response.setHeader("Access-Control-Allow-Credentials", "true");


        Flight flight = new Flight();
        flight.setFlightNo(request.getParameter("flightNo"));
        try{
            flight.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(request.getParameter("startTime")));
            flight.setArrivalTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(request.getParameter("arrivalTime")));
        }catch (ParseException e){
            e.printStackTrace();
        }
        flight.setStartAirport(request.getParameter("startAirport"));
        flight.setEndAirport(request.getParameter("endAirport"));
        flight.setBusinessClassAmount(Integer.valueOf(request.getParameter("businessClassAmount")));
        flight.setFirstClassAmount(Integer.valueOf(request.getParameter("firstClassAmount")));
        flight.setEconomyClassAmount(Integer.valueOf(request.getParameter("economyClassAmount")));
        flight.setBusinessClassPrice(Float.valueOf(request.getParameter("businessClassPrice")));
        flight.setFirstClassPrice(Float.valueOf(request.getParameter("firstClassPrice")));
        flight.setEconomyClassPrice(Float.valueOf(request.getParameter("economyClassPrice")));
        flight.setStatus(request.getParameter("status"));
        flight.setCreateTime(new Date());
        boolean result = flightService.save(flight);
        if (result) {
            return "successful";
        }else{
            return "error";
        }
    }

    //查询所有信息
    @RequestMapping(value = "/searchAllFlights",method = RequestMethod.GET)
    public List<Flight> searchAllCustomer(HttpServletRequest request, HttpSession session, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Credentials", "true");

        return flightService.list();
    }

    //模糊查询
    @RequestMapping(value = "/searchByFlightKeyword",method = RequestMethod.GET)
    public List<Flight> searchByKeyword(HttpServletRequest request,HttpSession session,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Credentials", "true");

        String keyword = request.getParameter("keyword");
        return flightService.searchByKeyword(keyword);
    }

    @RequestMapping(value = "/deleteByFlightId",method = RequestMethod.POST)
    public String deleteById(HttpServletRequest request,HttpSession session,HttpServletResponse response,@RequestParam("flightID") Integer id){
        response.setHeader("Access-Control-Allow-Credentials", "true");

        /*@RequestParam等价于request.getParameter
         * 其中value对应axios中的参数名
         * */

        boolean result = flightService.removeById(id);
        if(result){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping(value = "/updateFlight",method = RequestMethod.POST)
    public String update(HttpServletRequest request,HttpSession session,HttpServletResponse response,@RequestParam("flightID") Integer id){

        response.setHeader("Access-Control-Allow-Credentials", "true");

        Flight flight = new Flight();
        flight.setId(id);
        flight.setFlightNo(request.getParameter("flightNo"));
        try{
            flight.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(request.getParameter("startTime")));
            flight.setArrivalTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(request.getParameter("arrivalTime")));
        }catch (ParseException e){
            e.printStackTrace();
        }
        flight.setStartAirport(request.getParameter("startAirport"));
        flight.setEndAirport(request.getParameter("endAirport"));
        flight.setBusinessClassAmount(Integer.valueOf(request.getParameter("businessClassAmount")));
        flight.setFirstClassAmount(Integer.valueOf(request.getParameter("firstClassAmount")));
        flight.setEconomyClassAmount(Integer.valueOf(request.getParameter("economyClassAmount")));
        flight.setBusinessClassPrice(Float.valueOf(request.getParameter("businessClassPrice")));
        flight.setFirstClassPrice(Float.valueOf(request.getParameter("firstClassPrice")));
        flight.setEconomyClassPrice(Float.valueOf(request.getParameter("economyClassPrice")));
        flight.setStatus(request.getParameter("status"));

        boolean result = flightService.updateById(flight);
        if (result) {
            return "successful";
        }else{
            return "error";
        }
    }

}
