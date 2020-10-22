//package com.cg.mts;
//
//import com.cg.mts.util.Util;
//import com.cg.mts.entities.Customer;
//import com.cg.mts.service.AdminService;
//import com.cg.mts.service.CabService;
//import com.cg.mts.service.CustomerService;
//import com.cg.mts.service.DriverService;
//import com.cg.mts.service.IAdminService;
//import com.cg.mts.service.ICabService;
//import com.cg.mts.service.ICustomerService;
//import com.cg.mts.service.IDriverService;
//import com.cg.mts.service.ITripBookingService;
//import com.cg.mts.service.TripBookingService;
//import com.cg.mts.entities.*;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//
//public class AppMain {
//
//    public static void main(String[] args) {
//
//        AppMain appMain = new AppMain();
//        appMain.execute();
//
//        Util util = Util.getInstance();
//        util.close();
//    }
//
//    public void execute() {
//
//    	Cab cab = new Cab(1, "ABC", 4.5f);
//    	Driver driver = new Driver("ABC", "ABC", "ABC", "ABC", 1, "ABC", cab, 4.5f);
//    	LocalDateTime myObj = LocalDateTime.now();
//    	TripBooking tripBooking = new TripBooking(1, 2, driver, "ABC", "abc", myObj, myObj, false, 1.1f, 1.1f);
//        Customer customer = new Customer("Customer", "123", "123456", "abc");
//        Customer customer1 = new Customer("Customer1", "123", "123456", "abc");
//        Customer customer2 = new Customer("Customer2", "123", "123456", "abc");
//
//
//        ITripBookingService tripBookingService = new TripBookingService();
//        TripBooking trp = tripBookingService.insertTripBooking(tripBooking);
//        ICustomerService customerService = new CustomerService();
//        Customer c = customerService.insertCustomer(customer);
//        Customer c1 = customerService.insertCustomer(customer1);
//        Customer c2 = customerService.insertCustomer(customer2);
//
//        IAdminService adminService = new AdminService();
//        List<TripBooking> li1 = adminService.getTripsCabwise();
//        for(TripBooking tr: li1) {
//        	System.out.println("Driver Name" + tr.getDriver().getUsername());
//        }
//        List<TripBooking> li2 = adminService.getAllTrips(2);
//        for(TripBooking tr: li2) {
//        	System.out.println("Bill1" + tr.getBill());
//        }
//        List<TripBooking> li3 = adminService.getAllTripsForDays(1, myObj, myObj);
//        for(TripBooking tr: li3) {
//        	System.out.println("Bill2");
//        }
//        List<TripBooking> li4 = adminService.getTripsCustomerwise();
//        for(TripBooking tr: li4) {
//        	System.out.println("Bill3" + tr.getBill());
//        }
//        List<TripBooking> li5 = adminService.getTripsDatewise();
//        for(TripBooking tr: li5) {
//        	System.out.println("Bill4" + tr.getBill());
//        }
//        ICabService cabService = new CabService();
//        List<Cab> li = cabService.viewCabsOfType("ABC");
//        for(Cab cb: li) {
//        	System.out.println("CAB ID 1" + cb.getCabId());
//        }
//        int count = cabService.countCabsOfType("ABC");
//        System.out.println("Count of cab" + count);
//        ICustomerService cs1 = new CustomerService();
//        List<Customer> lik = cs1.viewCustomers();
//        for(Customer cust: lik) {
//        	System.out.println("Customer is" + customer.getCustomerId() + customer.getEmail());
//        }
//        IDriverService driverService = new DriverService();
//        List<Driver> dr = driverService.viewBestDrivers();
//        for(Driver d: dr) {
//        	System.out.println("Driver" + d.getDriverId());
//        }
//        Driver dri = driverService.deleteDriver(0);
////        System.out.println(">>" + dri);
//        System.out.println(trp);
//        System.out.println("New customer has" + c.getUsername());
//        System.out.println("New customer with id 1 as: " + customerService.viewCustomer(1).getUsername());
//
//        ICustomerService customerSr = new CustomerService();
//        Customer custr = customerSr.validateCustomer("ABC", "123");
//        IAdminService adminService1 = new AdminService();
//        adminService1.deleteAdmin(1);
//        adminService.insertAdmin(new Admin("SAD", "ABC", "ABC", "ABC", 1));
//        Admin ad = adminService.updateAdmin(new Admin("RAJ", "ABC", "ABC", "ABC", 1));
////        List<Customer> list = customerService.viewCustomers();
////
////        for (Customer list1 : list)
////            System.out.println("The whole customer list is:" + list1.getUsername());
//        //System.out.println("New customer deleted is " + customerService.deleteCustomer(c).getUsername());
//
//
//    }
//}
package com.cg.mts;

import com.cg.mts.entities.Admin;
import com.cg.mts.entities.Cab;
import com.cg.mts.repository.IAdminRepository;
import com.cg.mts.service.AdminService;
import com.cg.mts.service.CabService;
import com.cg.mts.service.IAdminService;
import com.cg.mts.service.ICabService;
import com.cg.mts.util.Util;
import com.cg.mts.entities.Customer;
import com.cg.mts.entities.Driver;
import com.cg.mts.entities.TripBooking;
import com.cg.mts.service.CustomerService;
import com.cg.mts.service.DriverService;
import com.cg.mts.service.ICustomerService;
import com.cg.mts.service.IDriverService;
import com.cg.mts.service.ITripBookingService;
import com.cg.mts.service.TripBookingService;

import java.time.LocalDateTime;
import java.util.List;


public class AppMain {

    public static void main(String[] args) {

        AppMain appMain = new AppMain();
//        appMain.executeCustomerService();
        appMain.executeAdminServices();
        appMain.executeCustomerService();
        appMain.executeCabService();
        appMain.executeDriverService();
        appMain.executeTripBookingService();
        Util util = Util.getInstance();
        util.close();
    }

    private void executeAdminServices() {

        Admin admin = new Admin("Admin", "123", "12345", "abcde");
        Admin admin1 = new Admin("Admin1", "123", "12345", "abc");
        Admin admin2 = new Admin("Admin2", "123", "12345", "abc");


        IAdminService adminService = new AdminService();
        adminService.insertAdmin(admin);
        adminService.insertAdmin(admin1);
        adminService.insertAdmin(admin2);
//        adminService.deleteAdmin(1);
        List<TripBooking> li = adminService.getAllTrips(1);
        for(TripBooking l: li) {
        	System.out.println("Bill" + l.getBill());
        }
        List<TripBooking> li2 = adminService.getAllTripsForDays(1, LocalDateTime.now(), LocalDateTime.now());
        List<TripBooking> li3 = adminService.getTripsCabwise();
        List<TripBooking> li4 = adminService.getTripsCustomerwise();
        for(TripBooking l: li4) {
        	System.out.println(l.getBill());
        }
        List<TripBooking> li5 = adminService.getTripsDatewise();
        
        Admin updateAdmin = new Admin("Updated admin", "1654", "4587", "khagdja");
        //System.out.println(admin.getAdminId());
        updateAdmin.setAdminId(admin.getAdminId());
        //System.out.println(updateAdmin.getAdminId());
        updateAdmin = adminService.updateAdmin(updateAdmin);
    }

    public void executeCustomerService() {

        Customer customer = new Customer("Customer", "123", "123456", "abc");
//        customer.setCustomerId(1);
        Customer customer1 = new Customer("Customer1", "123", "123456", "abc");
//        customer.setCustomerId(2);
        Customer customer2 = new Customer("Customer2", "123", "123456", "abc");


        ICustomerService customerService = new CustomerService();
        Customer c = customerService.insertCustomer(customer);
        Customer c1 = customerService.insertCustomer(customer1);
        Customer c2 = customerService.insertCustomer(customer2);
        customerService.deleteCustomer(customer2);
        Customer customer3 = new Customer("Customer 3", "234", "345", "56");
        customer3.setCustomerId(c1.getCustomerId());
        customer3 = customerService.updateCustomer(customer3);
        Customer customer5 = customerService.viewCustomer(0);
        Customer customer4 = customerService.validateCustomer("Customer", "123");
        System.out.println(customer4.getMobileNumber());
        System.out.println("New customer has" + c.getUsername());
        
//        System.out.println(customer5.getEmail());
        List<Customer> allCustomers= customerService.viewCustomers();
        for(Customer c11: allCustomers) {
        	System.out.println(c11.getEmail());
        }
//        System.out.println("New customer with id 1 as: " + customerService.viewCustomer(1).getUsername());

//        List<Customer> list = customerService.viewCustomers();
//
//        for (Customer list1 : list)
//            System.out.println("The whole customer list is:" + list1.getUsername());
        //System.out.println("New customer deleted is " + customerService.deleteCustomer(c).getUsername());


    }
    public void executeCabService() {
    	Cab cab = new Cab("ABC", 0.5f);
    	ICabService cabService = new CabService();
    	Cab cabz = cabService.insertCab(cab);
    	int count = cabService.countCabsOfType("ABC");
    	System.out.println(count);
    	cabService.deleteCab(cab);
    	Cab cab1 = new Cab("ABD", 0.6f);
    	cabService.insertCab(cab1);
    	Cab cab2 = new Cab("ABC", 0.8f);
    	cab2.setCabId(cab1.getCabId());
    	cabService.updateCab(cab2);
    	List<Cab> cc = cabService.viewCabsOfType("ABC");
    	for(Cab cf: cc) {
    		System.out.println(cf.getCabId());
    	}
    }
    public void executeDriverService() {
    	Cab cab = new Cab("ABC", 1.0f);
    	Driver driver = new Driver("cab", "cab1", "Cab2", "Cab3", "Cab4", cab, 4.5f);
    	IDriverService driverService = new DriverService();
    	driverService.insertDriver(driver);
    	driverService.deleteDriver(6);
    	Driver driver2 = new Driver("cab", "cab1", "Cab3", "Cab3", "Cab3", cab, 4.0f);
    	driver2.setDriverId(driver.getDriverId());
    	driverService.updateDriver(driver2);
    	List<Driver> drivers = driverService.viewBestDrivers();
    	for(Driver dd: drivers) {
    		System.out.println(dd.getEmail());
    	}
    	drivers = driverService.viewBestDrivers();
    	Driver ddd = driverService.viewDriver(driver2.getDriverId());
    	System.out.print(ddd.getLicenseNo());
//    	Driver
    }
    public void executeTripBookingService() {
    	Cab cab = new Cab("ABC", 1.0f);
    	Driver driver = new Driver("cab", "cab1", "Cab2", "Cab3", "Cab4", cab, 4.5f);
    	TripBooking tripBooking = new TripBooking(11, driver, "abc", "bac", LocalDateTime.now(), LocalDateTime.now(), false, 11, 0);
    	ITripBookingService tripBookingService = new TripBookingService();
    	tripBookingService.insertTripBooking(tripBooking);
    	TripBooking trp = tripBookingService.calculateBill(1);
    	if(trp == null) {
    		System.out.println("no value");
    	}
    	System.out.println(trp);
    	tripBookingService.deleteTripBooking(tripBooking);
    	TripBooking newTripBooking = new TripBooking(11, driver, "abc", "bac", LocalDateTime.now(), LocalDateTime.now(), true, 11, 0);
    	newTripBooking.setTripBookingId(tripBooking.getTripBookingId());
    	tripBookingService.updateTripBooking(newTripBooking);
    	List<TripBooking> tr1p = tripBookingService.viewAllTripsCustomer(tripBooking.getCustomerId());
    	for(TripBooking trk: tr1p) {
    		System.out.println(trk.getFromLocation());
    	}
    }
}