package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Enrollment
{
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
            Participant participant, Conference conference, Hotel hotel)
    {
        this.dateOfArrival = dateOfArrival;
        this.dateOfDeparture = dateOfDeparture;
        this.presentingTalk = presentingTalk;

        this.setParticipant(participant);
        this.setConference(conference);
        this.setHotel(hotel);

        conference.addEnrollment(this);
    }

    public LocalDate getDateOfArrival()
    {
        return dateOfArrival;
    }

    public void setDateOfArrival(LocalDate dateOfArrival)
    {
        this.dateOfArrival = dateOfArrival;
    }

    public LocalDate getDateOfDeparture()
    {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(LocalDate dateOfDeparture)
    {
        this.dateOfDeparture = dateOfDeparture;
    }

    public boolean isPresentingTalk()
    {
        return presentingTalk;
    }

    public void setPresentingTalk(boolean presentingTalk)
    {
        this.presentingTalk = presentingTalk;
    }

    // -----------------------------------------------------------------------------

    /**
     * Returns the hotel of participant's enrollment.<br/>
     * Returns null, if participant does not have a hotel.
     */
    public Hotel getHotel()
    {
        return hotel;
    }

    /**
     * Sets the hotel of participant.<br/>
     * Note: hotel may be null.
     */
    public void setHotel(Hotel hotel)
    {
        this.hotel = hotel;
    }

    // -----------------------------------------------------------------------------

    /**
     * Returns the companion of participant's enrollment.<br/>
     * Returns null, if participant does not have a companion.
     */
    public Companion getCompanion()
    {
        return companion;
    }

    /**
     * Sets the companion of participant.
     */
    public void setCompanion(Companion companion)
    {
        this.companion = companion;
    }

    // -----------------------------------------------------------------------------

    public Participant getParticipant()
    {
        return participant;
    }

    public void setParticipant(Participant participant)
    {
        this.participant = participant;
    }

    // -----------------------------------------------------------------------------

    public Conference getConference()
    {
        return conference;
    }

    public void setConference(Conference conference)
    {
        this.conference = conference;
    }

    // -----------------------------------------------------------------------------

    /**
     * Returns a list of this participant's extras.
     */
    public ArrayList<Extra> getExras()
    {
        return new ArrayList<Extra>(extras);
    }

    /**
     * Adds the extra.
     */
    public void addExtra(Extra extra)
    {
        assert extra != null;
        extras.add(extra);
    }

    // -----------------------------------------------------------------------------

    public int getPeriod()
    {

        Period period = null;

        period = Period.between(dateOfArrival, dateOfDeparture);
        int days = period.getDays();

        return days;
    }

    public int getTotalPrice()
    {
        int totalPrice = 0;

        if (!this.isPresentingTalk()) {
            totalPrice += conference.getPrice();
        }
        if (companion != null) {
            totalPrice += companion.getExcursionsPrice();
        }
        if (hotel != null) {
            if (companion != null) {
                totalPrice += hotel.getPriceDouble() * this.getPeriod();
            } else {
                totalPrice += hotel.getPriceSingle() * this.getPeriod();
            }
            if (!extras.isEmpty()) {
                for (Extra extra : extras) {
                    totalPrice += extra.getPrice() * this.getPeriod();
                }
            }
        }

        return totalPrice;
    }
}
