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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
public class CustomerOrderController {

    @Autowired
    private OrderticketService orderService;

    @Autowired
    private FlightService flightService;

    //查询订单
    @RequestMapping(value = "/searchByOrderKeyword",method = RequestMethod.GET)
    public List<Orderticket> searchByKeyword(HttpServletRequest request, HttpSession session, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Credentials", "true");

        String keyword = request.getParameter("keyword");
        return orderService.searchByKeyword(keyword);
    }

    //删除订单
    @RequestMapping(value = "/deleteOrdersId",method = RequestMethod.POST)
    public String deleteById(HttpServletRequest request,HttpSession session,HttpServletResponse response,@RequestParam("orderID") Integer id){
        response.setHeader("Access-Control-Allow-Credentials", "true");

        /*
        * orderInfo通过ID查找这张要删除的机票信息
        * flightInfo通过这张机票信息拿到起飞时间、降落时间和航班号去查航班信息，三者必须完全一样才可查
        * 对机票的舱位类型做判断，并相对应在航班信息上添加回对应舱位数
        * 最终删除
        * FUCK！！！！！老子在写尼玛呢，什么鬼逻辑脑袋要炸了！！！！！！
        * */
        List<Orderticket> orderInfo = orderService.selectOrderByID(id);
        List<Flight> flightInfo = orderService.deleteToSelectFlight(orderInfo.get(0).getStartTime(),orderInfo.get(0).getArrivalTime(),orderInfo.get(0).getFlightNo());
        if(orderInfo.get(0).getFlightClass().equals("头等舱")){
            flightInfo.get(0).setFirstClassAmount(flightInfo.get(0).getFirstClassAmount() + 1);
        }else if(orderInfo.get(0).getFlightClass().equals("商务舱")){
            flightInfo.get(0).setBusinessClassAmount(flightInfo.get(0).getBusinessClassAmount() + 1);
        }else if(orderInfo.get(0).getFlightClass().equals("经济舱")){
            flightInfo.get(0).setEconomyClassAmount( flightInfo.get(0).getEconomyClassAmount() + 1);
        }

        //时间小于乘机时间30分钟不允许退票
        java.util.Date dt = new Date();
        dt = orderInfo.get(0).getStartTime();
        long dtt = dt.getTime();
        if((dtt - new Date().getTime()) < 30*60*1000){
            return "timeout";
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
