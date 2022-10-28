package com.bridgelabz;

/**
 * Hello world!
 *
 */
public class CabInvoiceGenerator {
	private static final double COST_PER_KM = 10;
	private static final double COST_PER_KM_PREMIUM = 15;
	private static final double COST_PER_MIN = 1;
	private static final double COST_PER_MIN_PREMIUM = 2;


	public static double calculateFare(double distance, double time) {
		double totalFare = COST_PER_KM * distance + COST_PER_MIN * time;
		return totalFare <= 5 ? 5 : totalFare;
	}

	public static double calculateFarePremium(double distance, double time) {
		double totalFare = COST_PER_KM_PREMIUM * distance + COST_PER_MIN_PREMIUM * time;
		return totalFare <= 20 ? 20 : totalFare;

	}

	public static double calculateFare(Ride[] rides) {
		double aggregateFare = 0.0;
		for (Ride ride : rides) {
			if (ride.getRideType() == null || ride.getRideType().equals(RideType.NORMAL))
				aggregateFare += calculateFare(ride.getDistance(), ride.getTime());
			else
				aggregateFare += calculateFarePremium(ride.getDistance(), ride.getTime());
		}
		return aggregateFare;
	}

	public static Invoice generateInvoice(Ride[] rides) {
		double totalFare = calculateFare(rides);
		int totalRides = rides.length;
		double averageFare = totalFare / totalRides;
		return new Invoice(totalFare, totalRides, averageFare);
	}

	public static void main(String[] args) {
		System.out.println("Hello World!");
		System.out.println(calculateFare(20L, 6L));
		System.out.println(calculateFarePremium(20L, 6L));
		Ride[] rides = { new Ride(10, 5), new Ride(0.1, 3), new Ride(5, 9), new Ride(9, 8) };
		System.out.println(calculateFare(rides));
		System.out.println(generateInvoice(rides));

	}
}
