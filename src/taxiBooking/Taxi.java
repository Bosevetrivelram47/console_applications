package taxiBooking;

public class Taxi implements Cloneable
{
	private char currentLocation = 'A';
	private int customerId;
	private int taxiId;
	private char pickupLocation;
	private char dropLocation;
	private int pickupTime;
	private int dropTime;
	private int earnings;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public char getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Character currentLocation) {
		this.currentLocation = currentLocation;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public int getTaxiId() {
		return taxiId;
	}

	public void setTaxiId(Integer taxiId) {
		this.taxiId = taxiId;
	}

	public char getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(Character pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public char getDropLocation() {
		return dropLocation;
	}

	public void setDropLocation(Character dropLocation) {
		this.dropLocation = dropLocation;
	}

	public int getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(Integer pickupTime) {
		this.pickupTime = pickupTime;
	}

	public int getDropTime() {
		return dropTime;
	}

	public void setDropTime(Integer dropTime) {
		this.dropTime = dropTime;
	}

	public int getEarnings() {
		return earnings;
	}

	public void setEarnings(Integer earnings) {
		this.earnings = earnings;
	}

	@Override
	public String toString() {
		return "Taxi Number: " + taxiId + "\nTaxi Current Location: " + currentLocation + "\nTaxi Earnings: " + earnings + 
				"\nCusomer Id: " + customerId + "\nPickup Location: " + pickupLocation + "\nDrop Location: " + dropLocation + "\nDrop Time: " + dropTime;
	}
	
}
