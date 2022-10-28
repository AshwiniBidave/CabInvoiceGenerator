package com.bridgelabz;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
    public void givenDistanceAndTimeShouldReturnTotalFare(){
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double totalFare = cabInvoiceGenerator.calculateFare(20, 6);
        Assertions.assertEquals(206.0,totalFare);
    }
    @Test
    public void givenDistanceAndTimeShouldReturnMinimumFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double totalFare = cabInvoiceGenerator.calculateFare(0.1 , 3);
        Assertions.assertEquals(5.0,cabInvoiceGenerator.calculateFare(0.1, 3));
    }

    @Test
    public void givenMultipleRidesShouldReturnAggregateFare() {
        Ride[] rides = {new Ride(10,5),new Ride(0.1,3),new Ride(5,9),new Ride(9,8)};
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double totalFare = cabInvoiceGenerator.calculateFare(rides);
        Assertions.assertEquals(267.0,totalFare);
    }
    @Test
    public void givenMultipleRidesShouldReturnInvoice() {
        Ride[] rides = {new Ride(10,5),new Ride(0.1,3),new Ride(5,9),new Ride(9,8)};
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        Invoice actualInvoice = cabInvoiceGenerator.generateInvoice(rides);
        Invoice expectedInvoice = new Invoice(267.0,4,66.75);
        Assertions.assertEquals(expectedInvoice,actualInvoice);
    }
    @Test
    public void givenUserIDShouldReturnInvoice() {
        Ride[] rides1 = {new Ride(10,5),new Ride(0.1,3),new Ride(5,9),new Ride(9,8)};
        Ride[] rides2 = {new Ride(10,6),new Ride(0.1,3),new Ride(5,9),new Ride(9,8)};
        RideRepository.customerList.add(new Customer(1,rides1));
        RideRepository.customerList.add(new Customer(2,rides2));
        Invoice actualInvoice = RideRepository.generateInvoiceByUserId(2);
        Invoice expectedInvoice = new Invoice(268.0,4,67);
        Assertions.assertEquals(expectedInvoice,actualInvoice);
    }
    @Test
    public void givenRideTypeShouldReturnInvoice() {
        Ride[] rides1 = {new Ride(10,5,RideType.NORMAL),new Ride(0.1,3,RideType.NORMAL),new Ride(5,9,RideType.NORMAL),new Ride(9,8,RideType.NORMAL)};
        Ride[] rides2 = {new Ride(10,6,RideType.PREMIUM),new Ride(0.1,3,RideType.PREMIUM),new Ride(5,9,RideType.PREMIUM),new Ride(9,8,RideType.PREMIUM)};
        RideRepository.customerList.add(new Customer(1,rides1));
        RideRepository.customerList.add(new Customer(2,rides2));
        Invoice actualInvoice = RideRepository.generateInvoiceByUserId(1);
//        Invoice actualInvoice = RideRepository.generateInvoiceByUserId(2);
        Invoice expectedInvoice = new Invoice(267.0,4,66.75);
        Assertions.assertEquals(expectedInvoice,actualInvoice);
    }
}
