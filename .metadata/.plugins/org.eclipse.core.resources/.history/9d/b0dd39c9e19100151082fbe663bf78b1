package storage;

import java.util.ArrayList;

import model.Company;
import model.Conference;
import model.Hotel;
import model.Participant;

public class Storage
{
    private static ArrayList<Conference> conferences = new ArrayList<>();
    private static ArrayList<Company> companies = new ArrayList<>();
    private static ArrayList<Hotel> hotels = new ArrayList<>();
    private static ArrayList<Participant> participants = new ArrayList<>();

    // -------------------------------------------------------------------------
    // Conference
    public static ArrayList<Conference> getAllConferences()
    {
        return new ArrayList<>(conferences);
    }

    public static void storeConference(Conference conference)
    {
        assert conference != null;
        conferences.add(conference);
    }

    public static void deleteConference(Conference conference)
    {
        conferences.remove(conference);
    }

    // -------------------------------------------------------------------------
    // Company
    public static ArrayList<Company> getAllCompanies()
    {
        return new ArrayList<>(companies);
    }

    public static void storeCompany(Company company)
    {
        assert company != null;
        companies.add(company);
    }

    public static void deleteCompany(Company company)
    {
        companies.remove(company);
    }

    // -------------------------------------------------------------------------
    // Hotel
    public static ArrayList<Hotel> getAllHotels()
    {
        return new ArrayList<>(hotels);
    }

    public static void storeHotel(Hotel hotel)
    {
        assert hotel != null;
        hotels.add(hotel);
    }

    // -------------------------------------------------------------------------
    // Participant
    public static ArrayList<Participant> getAllParticipants()
    {
        return new ArrayList<>(participants);
    }

    public static void storeParticipant(Participant participant)
    {
        assert participant != null;
        participants.add(participant);
    }

    public static void deleteParticipant(Participant participant)
    {
        participants.remove(participant);
    }
}
