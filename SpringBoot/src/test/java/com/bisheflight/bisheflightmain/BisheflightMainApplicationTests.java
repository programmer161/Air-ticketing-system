package com.bisheflight.bisheflightmain;

import com.bisheflight.bisheflightmain.mapper.OrderticketMapper;
import com.bisheflight.bisheflightmain.model.*;
import com.bisheflight.bisheflightmain.service.*;
import org.assertj.core.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class BisheflightMainApplicationTests {

	@Autowired
	private AdministratorService administratorService;

	@Autowired
	private FlightService flightService;
	@Autowired
	private AirportService airportService;
	@Autowired
	private PlaneService planeService;
	@Autowired
	private OrderticketService orderService;


	private OrderticketMapper orderMapper;

	@Test
	public void testInsert() {

	/*Administrator administrator = new Administrator();
	//administrator.setId(2);
	administrator.setPassword("222333");
	administrator.setUsername("阿色22");
	administrator.setLastlogintime(new Date());
	administrator.setCreattime(new Date());
	administratorMapper.insert(administrator);*/

	/*administrator.setId(3);
	administrator.setUsername("阿色");
	administrator.setLastlogintime(new Date());
	administratorService.save(administrator);*/
	/*List<Administrator> list = administratorService.list();
	System.out.println(list);

       /* List<Object> newList = new ArrayList();
		List<Flight> flights = flightService.list();
		Plane plane = planeService.getById(1);
		newList.add(plane);
		newList.add(flights.get(0));

		System.out.println(newList);
        System.out.println(flights);*/

	     List<Orderticket> list = orderService.searchByKeyword("北京");
		/*System.out.println(list);
		System.out.println(list.get(0).getFlightNo());
	     System.out.println(flightService.searchByKeyword(list.get(1).getFlightNo()));
	     System.out.println(list.size());
        /*int a = flights.get(0).getBusinessClassAmount();
        //System.out.println(a);
		flights.get(0).setStatus("延误");
        flightService.updateBatchById(flights);
        //System.out.println(flights);

		/*System.out.println(flights);
		System.out.println(airportService.getById(flights.get(0).getStartAirportId()));*/

		//System.out.println(orderService.selectFlight("北京","满洲里"));

		/*String a = "CZ5656";
		String s = a.substring(0,2);
		if(s.equals("CZ")){
			System.out.println("CZ");
		}*/

		java.util.Date dt = new Date();
		dt = list.get(0).getStartTime();
		long dtt = dt.getTime();
		System.out.println(dtt - new Date().getTime());


	}

}