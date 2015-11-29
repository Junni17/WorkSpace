package ex3student;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * Models a flight with an airline between airports.
 */
public class Flight {
	private String flightNumber;
	private String destination;
	private LocalDateTime departure;
	private LocalDateTime arrival;
	private ArrayList<Passenger> passengers;

	/**
	 * Initializes a new flight.<br/>
	 * Req: flightNumber is not empty, destination is not empty.
	 */
	public Flight(String flightNumber, String destination) {
		assert flightNumber != null && !flightNumber.isEmpty() || destination != null && !destination.isEmpty();
		this.flightNumber = flightNumber;
		this.destination = destination;
		this.departure = null;
		this.arrival = null;
		this.passengers = new ArrayList<>();
	}

	/**
	 * Returns the destination.
	 */
	public String getDestination() {
		return this.destination;
	}

	/**
	 * Returns the flight number.
	 */
	public String getFlightNumber() {
		return this.flightNumber;
	}

	/**
	 * Returns the date and time of departure.<br/>
	 * Note: Returns null, if departure date and time is not set.
	 */
	public LocalDateTime getDeparture() {
		if (this.departure == null) {
			return null;
		} else {
			return this.departure;
		}
	}

	/**
	 * Sets the date and time of departure.<br>
	 * Req: Departure date and time is before arrival date and time (if set).
	 */
	public void setDeparture(LocalDateTime departure) {
		assert departure.isBefore(this.arrival);
		this.departure = departure;
	}

	/**
	 * Returns the local date and time of arrival.<br/>
	 * Note: Returns null, if arrival date and time is not set.
	 */
	public LocalDateTime getArrival() {
		if (this.arrival == null) {
			return null;
		} else {
			return this.arrival;
		}
	}

	/**
	 * Sets the local date and time of arrival.<br/>
	 * Req: Arrival date and time is after departure date and time (if set).
	 */
	public void setArrival(LocalDateTime arrival) {
		assert arrival.isAfter(this.departure);
		this.arrival = arrival;

	}

	/**
	 * Returns a copy of the passenger list.
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList getPassengerList() {
		return this.passengers;
	}

	/**
	 * Creates and returns a passenger added to the passenger list.<br/>
	 * Precondition: name is not empty, age >= 0.
	 */
	public Passenger addPassenger(String name, int age) {
		Passenger temp = new Passenger(name, age);
		this.passengers.add(temp);
		return temp;
	}

	/**
	 * Removes a named passenger from the passenger list.<br/>
	 * Returns true, if the passenger is removed from the passenger list. Req:
	 * name is not empty.
	 */
	public boolean removePassenger(String name) {
		assert name != null && !name.isEmpty();
		for (int i = 0; i < this.passengers.size(); i++) {
			if (this.passengers.get(i).getName() == name) {
				this.passengers.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * The duration of the flight measured in hours.<br/>
	 * Req: The departure and arrival date and time are set.
	 */
	public double durationInHours() {
		assert this.departure != null && this.arrival != null;
		double duration = ChronoUnit.HOURS.between(this.departure, this.arrival);
		return duration;
	}

	/**
	 * Returns true if the flight time overlaps midnight of the day of
	 * departure.<br/>
	 * Req: Departure and arrival date and time are set.
	 */
	public boolean midnightFlight() {
		assert this.departure != null && this.arrival != null;
		LocalDateTime midnight = LocalDateTime.of(this.departure.getYear(), this.departure.getMonth(),
				this.departure.getDayOfMonth() + 1, 0, 0, 0);
		if (this.arrival.isAfter(midnight)) {
			return true;
		} else {

			return false;
		}
	}

	/**
	 * Returns the average age of all the passengers.<br/>
	 * Req: The passenger list is not empty.
	 */
	public double averagePassengerAge() {
		assert!this.passengers.isEmpty();
		double age = 0.0;
		int passengers = 0;
		for (int i = 0; i < this.passengers.size(); i++) {
			age += this.passengers.get(i).getAge();
			passengers++;
		}
		double ageAverage = age / passengers;

		return ageAverage;
	}

}
