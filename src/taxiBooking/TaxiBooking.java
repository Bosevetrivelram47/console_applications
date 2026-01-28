package taxiBooking;

import java.util.ArrayList;
import java.util.List;

public class TaxiBooking
{
	private static List<Taxi> taxiList = new ArrayList<Taxi>();
	final static int TAXI_LIMIT = 4;
	private static int idGenerator = 1;
	private static List<Taxi> taxiBookedHistory = new ArrayList<Taxi>();
	
	public static String booking(Character pickupLocation, Character dropLocation, Integer pickupTime) throws CloneNotSupportedException
	{
		if(taxiList.size() < TAXI_LIMIT)
		{
			taxiList.add(new Taxi());
		}
		
		int minDistance = Integer.MAX_VALUE;
		int minCost = Integer.MAX_VALUE;
		
		Taxi taxiReady = null;
		
		for(Taxi t : taxiList)
		{
			if(t.getDropTime() <= pickupTime && Math.abs(pickupLocation - t.getCurrentLocation()) <= minDistance)
			{
				if(Math.abs(pickupLocation - t.getCurrentLocation()) == minDistance)
				{
					if(taxiReady != null && t.getEarnings() < taxiReady.getEarnings())
					{
						taxiReady = t;
					}
				}
				else
				{
					minDistance = Math.abs(pickupLocation - t.getCurrentLocation());
					taxiReady = t;
				}
			}
		}
		
		if(taxiReady != null)
		{
			taxiReady.setCustomerId(idGenerator++);
			taxiReady.setTaxiId(taxiList.indexOf(taxiReady) + 1);
			taxiReady.setPickupLocation(pickupLocation);
			taxiReady.setDropLocation(dropLocation);
			taxiReady.setCurrentLocation(dropLocation);
			taxiReady.setPickupTime(pickupTime);
			taxiReady.setDropTime(pickupTime + Math.abs(dropLocation - pickupLocation));
			taxiReady.setEarnings(taxiReady.getEarnings() + (Math.abs(dropLocation - pickupLocation) * 15 - 5) * 10 + 100);
			taxiBookedHistory.add((Taxi) taxiReady.clone());
			
			return "Taxi number " + taxiReady.getTaxiId() + " is booked";
		}
		
		return "Taxi is not Available";
	}
	
	public static void display()
	{
		System.out.println("________________________________");
		for(Taxi t : taxiBookedHistory)
		{
			System.out.println(t.toString());
			System.out.println("________________________________");
		}
	}
}
