package railwayReservation;

import java.util.HashMap;
import java.util.Map;

public class TicketCancelling extends TicketBooking
{
	private static char preferenceTracker = '\0';
	private static int cancelledSeatNumber = 0;
	
	private static Map<Integer, Character> seatNumberWithBerth = new HashMap<Integer, Character>();
	
	public static String cancelling(int id)
	{
		for(Passenger p : confirmedList)
		{
			if(p.getId() == id)
			{
				cancel(p);
				return "Success";
			}
		}
		
		for(Passenger p : racQueue)
		{
			if(p.getId() == id)
			{
				cancel(p);
				return "Success";
			}
		}
		
		for(Passenger p : waitingListQueue)
		{
			if(p.getId() == id)
			{
				cancel(p);
				return "Success";
			}
		}
		
		return "Invalid id";
	}
	
	private static void cancel(Passenger p)
	{
		if(p.getTicketType() == "berth")
		{
			preferenceTracker = p.getPreference();
			cancelledSeatNumber = p.getSeatNumber();
			
			seatNumberWithBerth.put(cancelledSeatNumber, preferenceTracker);
			
			deleteFromAllLists(p);
			addRacToBerth(racQueue.poll());
			addWaitingToRac(waitingListQueue.poll());
		}
		else if(p.getTicketType() == "rac")
		{
			racQueue.remove(p);
			addWaitingToRac(waitingListQueue.poll());
		}
		else
		{
			waitingListQueue.remove(p);
		}
	}
	
	private static void addRacToBerth(Passenger p)
	{
		if(p != null)
		{
			p.setPreference(preferenceTracker);
			p.setSeatNumber(cancelledSeatNumber);
			p.setTicketType("Berth");
			
			if(preferenceTracker == 'U')
			{
				upperList.add(p);
			}
			else if(preferenceTracker == 'M')
			{
				middleList.add(p);
			}
			else
			{
				lowerList.add(p);
			}
			
			confirmedList.add(p);
			seatNumberWithBerth.remove(cancelledSeatNumber);
			preferenceTracker = '\0';
			cancelledSeatNumber = 0;
		}
	}
	
	private static void addWaitingToRac(Passenger p)
	{
		if(p != null)
		{
			p.setTicketType("rac");
			racQueue.add(p);
		}
	}
	
	private static void deleteFromAllLists(Passenger p)
	{
		confirmedList.remove(p);
		upperList.remove(p);
		middleList.remove(p);
		lowerList.remove(p);
	}
	
	public static Map<Integer, Character> getSeatNumberWithBerth()
	{
		return seatNumberWithBerth;
	}
}
