package railwayReservation;

import java.util.*;

public class MainClass
{
	public static void main(String[] args) {
		boolean loop = true;
		
		while(loop)
		{
			System.out.println("\nChoose any one service \n 1. Book Ticket \n 2. Cancel Ticket "
					+ " \n 3. Display Confirmed List \n 4. Display RAC List"
					+ " \n 5. Display Waiting List \n 6. Exit");
			
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			
			switch(n)
			{
			case 1:
				System.out.println("Enter name: ");
				String name = sc.next();
				System.out.println("Enter age: ");
				int age = sc.nextInt();
				System.out.println("Enter berth: ");
				char preference = sc.next().charAt(0);
				if(preference == 'U' || preference == 'M' || preference == 'L')
				{
					TicketBooking.bookTicket(new Passenger(name, age, preference));
				}
				else System.out.println("Invalid Berth");
				
				break;
				
			case 2:
				System.out.println("Enter your Ticket Id: ");
				int id = sc.nextInt();
				System.out.println(TicketCancelling.cancelling(id));
				
				break;
				
			case 3:
				TicketBooking.displayConfirmed();
				break;
			
			case 4:
				TicketBooking.displayRAC();
				break;
				
			case 5: 
				TicketBooking.displayWaiting();
				break;
			
			case 6:
				System.out.println("\tThank you!!!!");
				sc.close();
				loop = false;
				break;
			
			default:
				System.out.println("Choose the valid service");
			}
			
		}
	}
}
