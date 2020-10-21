package com.cg.mts;

import com.cg.mts.util.Util;
import com.cg.mts.entities.Customer;
import com.cg.mts.service.AdminService;
import com.cg.mts.service.CabService;
import com.cg.mts.service.CustomerService;
import com.cg.mts.service.DriverService;
import com.cg.mts.service.IAdminService;
import com.cg.mts.service.ICabService;
import com.cg.mts.service.ICustomerService;
import com.cg.mts.service.IDriverService;
import com.cg.mts.service.ITripBookingService;
import com.cg.mts.service.TripBookingService;
import com.cg.mts.entities.*;

import java.time.LocalDateTime;
import java.util.List;


public class AppMain {

    public static void main(String[] args) {

        AppMain appMain = new AppMain();
        appMain.execute();

        Util util = Util.getInstance();
        util.close();
    }

    public void execute() {

    	Cab cab = new Cab(1, "ABC", 4.5f);
    	Driver driver = new Driver("ABC", "ABC", "ABC", "ABC", 1, "ABC", cab, 4.5f);
    	LocalDateTime myObj = LocalDateTime.now();
    	TripBooking tripBooking = new TripBooking(1, 2, driver, "ABC", "abc", myObj, myObj, false, 1.1f, 1.1f);
        Customer customer = new Customer("Customer", "123", "123456", "abc");
        Customer customer1 = new Customer("Customer1", "123", "123456", "abc");
        Customer customer2 = new Customer("Customer2", "123", "123456", "abc");


        ITripBookingService tripBookingService = new TripBookingService();
        TripBooking trp = tripBookingService.insertTripBooking(tripBooking);
        ICustomerService customerService = new CustomerService();
        Customer c = customerService.insertCustomer(customer);
        Customer c1 = customerService.insertCustomer(customer1);
        Customer c2 = customerService.insertCustomer(customer2);

        IAdminService adminService = new AdminService();
        List<TripBooking> li1 = adminService.getTripsCabwise();
        for(TripBooking tr: li1) {
        	System.out.println("Driver Name" + tr.getDriver().getUsername());
        }
        List<TripBooking> li2 = adminService.getAllTrips(2);
        for(TripBooking tr: li2) {
        	System.out.println("Bill1" + tr.getBill());
        }
        List<TripBooking> li3 = adminService.getAllTripsForDays(1, myObj, myObj);
        for(TripBooking tr: li3) {
        	System.out.println("Bill2");
        }
        List<TripBooking> li4 = adminService.getTripsCustomerwise();
        for(TripBooking tr: li4) {
        	System.out.println("Bill3" + tr.getBill());
        }
        List<TripBooking> li5 = adminService.getTripsDatewise();
        for(TripBooking tr: li5) {
        	System.out.println("Bill4" + tr.getBill());
        }
        ICabService cabService = new CabService();
        List<Cab> li = cabService.viewCabsOfType("ABC");
        for(Cab cb: li) {
        	System.out.println("CAB ID 1" + cb.getCabId());
        }
        int count = cabService.countCabsOfType("ABC");
        System.out.println("Count of cab" + count);
        ICustomerService cs1 = new CustomerService();
        List<Customer> lik = cs1.viewCustomers();
        for(Customer cust: lik) {
        	System.out.println("Customer is" + customer.getCustomerId() + customer.getEmail());
        }
        IDriverService driverService = new DriverService();
        List<Driver> dr = driverService.viewBestDrivers();
        for(Driver d: dr) {
        	System.out.println("Driver" + d.getDriverId());
        }
        Driver dri = driverService.deleteDriver(0);
        System.out.println(">>" + dri);
        System.out.println(trp);
        System.out.println("New customer has" + c.getUsername());
        System.out.println("New customer with id 1 as: " + customerService.viewCustomer(1).getUsername());

//        List<Customer> list = customerService.viewCustomers();
//
//        for (Customer list1 : list)
//            System.out.println("The whole customer list is:" + list1.getUsername());
        //System.out.println("New customer deleted is " + customerService.deleteCustomer(c).getUsername());


    }
}
