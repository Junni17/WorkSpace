package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Enrollment {
	private LocalDate dateOfArrival;
	private LocalDate dateOfDeparture;
	private boolean presentingTalk = false;

	// link to hotel class (--> 0..1)
	private Hotel hotel;

	// link to companion class (--> 0..1)
	private Companion companion;

	private Participant participant;

	// link to companion class (--> 1)
	private Conference conference;

	// link to Enrollment class (--> 0..*)
	private ArrayList<Extra> extras = new ArrayList<>();

	public Enrollment(LocalDate dateOfArrival, LocalDate dateOfDeparture, boolean presentingTalk,
			Participant participant, Conference conference, Hotel hotel) {
		this.dateOfArrival = dateOfArrival;
		this.dateOfDeparture = dateOfDeparture;
		this.presentingTalk = presentingTalk;

		this.setParticipant(participant);
		this.setConference(conference);
		this.setHotel(hotel);

		conference.addEnrollment(this);
	}

	public LocalDate getDateOfArrival() {
		return this.dateOfArrival;
	}

	public void setDateOfArrival(LocalDate dateOfArrival) {
		this.dateOfArrival = dateOfArrival;
	}

	public LocalDate getDateOfDeparture() {
		return this.dateOfDeparture;
	}

	public void setDateOfDeparture(LocalDate dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}

	public boolean isPresentingTalk() {
		return this.presentingTalk;
	}

	public void setPresentingTalk(boolean presentingTalk) {
		this.presentingTalk = presentingTalk;
	}

	// -----------------------------------------------------------------------------

	/**
	 * Returns the hotel of participant's enrollment.<br/>
	 * Returns null, if participant does not have a hotel.
	 */
	public Hotel getHotel() {
		return this.hotel;
	}

	/**
	 * Sets the hotel of participant.<br/>
	 * Note: hotel may be null.
	 */
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	// -----------------------------------------------------------------------------

	/**
	 * Returns the companion of participant's enrollment.<br/>
	 * Returns null, if participant does not have a companion.
	 */
	public Companion getCompanion() {
		return this.companion;
	}

	/**
	 * Sets the companion of participant.
	 */
	public void setCompanion(Companion companion) {
		this.companion = companion;
	}

	// -----------------------------------------------------------------------------

	public Participant getParticipant() {
		return this.participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	// -----------------------------------------------------------------------------

	public Conference getConference() {
		return this.conference;
	}

	public void setConference(Conference conference) {
		this.conference = conference;
	}

	// -----------------------------------------------------------------------------

	/**
	 * Returns a list of this participant's extras.
	 */
	public ArrayList<Extra> getExras() {
		return new ArrayList<Extra>(this.extras);
	}

	/**
	 * Adds the extra.
	 */
	public void addExtra(Extra extra) {
		assert extra != null;
		this.extras.add(extra);
	}

	// -----------------------------------------------------------------------------

	/**
	 * Returns the period of the conference as an integer
	 */
	public int getPeriod() {

		Period period = Period.between(this.dateOfArrival, this.dateOfDeparture);
		int days = period.getDays();

		return days;
	}

	/**
	 * Returns the total price of the enrollment.
	 */
	public int getTotalPrice() {
		int totalPrice = 0;

		if (!this.isPresentingTalk()) {
			totalPrice += this.conference.getPrice();
		}
		if (this.companion != null) {
			totalPrice += this.companion.getExcursionsPrice();
		}
		if (this.hotel != null) {
			if (this.companion != null) {
				totalPrice += this.hotel.getPriceDouble() * this.getPeriod();
			} else {
				totalPrice += this.hotel.getPriceSingle() * this.getPeriod();
			}
			if (!this.extras.isEmpty()) {
				for (Extra extra : this.extras) {
					totalPrice += extra.getPrice() * this.getPeriod();
				}
			}
		}

		return totalPrice;
	}

	@Override
	public String toString() {
		return this.conference.getName() + " - " + this.getTotalPrice() + " kr";
	}
}
