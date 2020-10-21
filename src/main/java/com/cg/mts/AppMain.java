package com.cg.mts;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.mts.dao.Util;
import com.cg.mts.entities.*;
import com.cg.mts.service.CustomerService;
import com.cg.mts.service.ICustomerService;
import com.cg.mts.service.ITripBookingService;
import com.cg.mts.service.TripBookingService;
import com.cg.mts.service.*;

public class AppMain {

    public static void main(String[] args) {

        AppMain appMain = new AppMain();
        appMain.execute();

        Util util = Util.getInstance();
        util.close();
    }

    public void execute() {

        Customer customer = new Customer("Customer", "123", "123456", "abc");
        Customer customer1 = new Customer("Customer1", "123", "123456", "abc");
        Customer customer2 = new Customer("Customer2", "123", "123456", "abc");

        Cab cab = new Cab(2, "ABC", 2.5f);
        Driver driver = new Driver("ABC", "ABC", "BAC", "BAC", 2, "ABC", cab, 4.5f);
        LocalDateTime myObj = LocalDateTime.now();
        TripBooking tripBooking = new TripBooking(1, 2, driver, "ABC", "ABC", myObj, myObj, false, 1, 1);

        ICustomerService customerService = new CustomerService();
        Customer c = customerService.insertCustomer(customer);
        Customer c1 = customerService.insertCustomer(customer1);
        Customer c2 = customerService.insertCustomer(customer2);


        ITripBookingService tripBookingService = new TripBookingService();
        IDriverService driverService = new DriverService();
//        ICabService cabService = new CabService();
//        Cab cab1 = cabService.insertCab(cab);
//        Driver driver1 = driverService.insertDriver(driver);
//        List<Driver> listOfDrivers = driverService.viewBestDrivers();
//        for(Driver li:listOfDrivers) {
//        	System.out.println("Driver Id is" + li.getRating());
//        }
        TripBooking tripBooking1 = tripBookingService.insertTripBooking(tripBooking);
        List<TripBooking> li = tripBookingService.viewAllTripsCustomer(2);
        System.out.println("LI");
        System.out.println("Li" + li);
        for(TripBooking trp: li) {
        	System.out.println("TripBooking>>>>>"+trp.getCustomerId());
        }
        System.out.println("New Driver found");
        System.out.println("New customer has" + c);
        System.out.println("New customer with id 1 as: " + customerService.viewCustomer(2).getUsername());
        System.out.println("The whole customer list is:" + customerService.viewCustomers().toString());
        //System.out.println("New customer deleted is " + customerService.deleteCustomer(c).getUsername());


    }
}