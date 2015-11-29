package model;

import java.util.ArrayList;

public class Company
{
    private String name;
    private String phone;

    // link to Participant class (--> 0..*)
    private ArrayList<Participant> participants = new ArrayList<>();

    public Company(String name, String phone)
    {
        this.name = name;
        this.phone = phone;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    // -----------------------------------------------------------------------------

    /**
     * Returns a list of this company's participants.
     */
    public ArrayList<Participant> getParticipants()
    {
        return new ArrayList<Participant>(participants);
    }

    /**
     * Adds the participant.
     */
    public void addParticipant(Participant participant)
    {
        assert participant != null;
        participants.add(participant);
    }

    /**
     * Removes the participant.
     */
    public void removeParticipant(Participant participant)
    {
        participants.remove(participant);
    }
}
