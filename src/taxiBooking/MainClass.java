package taxiBooking;

import java.util.Scanner;

public class MainClass
{
	public static void main(String[] args) throws CloneNotSupportedException {
		boolean loop = true;
		
		while(loop)
		{
			System.out.println("Choose any one service \n 1. Book Taxi \n 2. Display Details \n 3. Exit");
			Scanner sc = new Scanner(System.in);
			
			int option = sc.nextInt();
			
			switch(option)
			{
			case 1:
				System.out.println("Enter Pickup Location: ");
				Character pickupLocation = sc.next().charAt(0);
				System.out.println("Enter Drop Location: ");
				Character dropLocation = sc.next().charAt(0);
				System.out.println("Enter Pickup time: ");
				Integer pickupTime = sc.nextInt();
				
				System.out.println(TaxiBooking.booking(pickupLocation, dropLocation, pickupTime));
				
				break;
				
			case 2: 
				TaxiBooking.display();
				break;
				
			case 3:
				loop = false;
				System.out.println("Thank you!!!!");
				sc.close();
				break;
			
			default:
				System.out.println("Invalid Service");
			}
		}
	}
}
