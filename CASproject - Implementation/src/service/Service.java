package service;

import java.time.LocalDate;

import model.Companion;
import model.Company;
import model.Conference;
import model.Enrollment;
import model.Excursion;
import model.Extra;
import model.Hotel;
import model.Participant;
import storage.Storage;

public class Service {
	/**
	 * Creates a new Conference.<br />
	 * Requires: name not empty, price > 0, endDate is after startDate
	 */
	public static Conference createConference(String name, int price, LocalDate startDate, LocalDate endDate) {
		assert!name.isEmpty();
		assert price > 0;
		assert endDate.isAfter(startDate);

		Conference conference = new Conference(name, price, startDate, endDate);
		Storage.storeConference(conference);
		return conference;
	}

	/**
	 * Deletes the conference.<br />
	 * Requires: The conference has no participants (enrollments).
	 */
	public static void deleteConference(Conference conference) {
		assert conference.enrollmentsCount() == 0;
		Storage.deleteConference(conference);
	}

	/**
	 * Updates the conference.<br />
	 * Requires: name != "".
	 */
	public static void updateConference(Conference conference, String name, int price, LocalDate startDate,
			LocalDate endDate) {
		assert name != "";
		conference.setName(name);
		conference.setPrice(price);
		conference.setStartDate(startDate);
		conference.setEndDate(endDate);
	}

	// -------------------------------------------------------------------------

	/**
	 * Creates a new Hotel.<br />
	 * Requires: name not empty, priceSingle > 0, priceDouble > 0.
	 */
	public static Hotel createHotel(String name, int priceSingle, int priceDouble) {
		assert name != "";
		assert priceSingle > 0;
		assert priceDouble > 0;

		Hotel hotel = new Hotel(name, priceSingle, priceDouble);
		Storage.storeHotel(hotel);
		return hotel;
	}

	// -------------------------------------------------------------------------

	/**
	 * Creates a new Excursion.<br />
	 * Requires: name not empty.
	 */
	public static Excursion createExcursion(String name, LocalDate date, int price, Conference conference) {
		assert name != "";

		Excursion exc = new Excursion(name, date, price);
		conference.addExcursion(exc);
		return exc;
	}

	// -------------------------------------------------------------------------

	/**
	 * Creates a new participant.<br />
	 * Requires: name not empty.
	 */
	public static Participant createParticipant(String name, String address, String city, String country,
			String phone) {
		assert name != "";
		Participant participant = new Participant(name, address, city, country, phone);
		Storage.storeParticipant(participant);
		return participant;
	}

	/**
	 * Deletes the participant.
	 */
	public static void deleteParticipant(Participant participant) {
		Storage.deleteParticipant(participant);
	}

	// -------------------------------------------------------------------------
	// Company

	/**
	 * Creates a new Company.<br />
	 * Requires: name not empty.
	 */
	public static Company createCompany(String name, String phone) {
		assert name != "";

		Company company = new Company(name, phone);
		Storage.storeCompany(company);
		return company;
	}

	/**
	 * Sets the participant's company.<br/>
	 * Note: company may be null.
	 */
	public static void setCompanyOfParticipant(Participant participant, Company company) {
		participant.setCompany(company);
		company.addParticipant(participant);

	}

	// -------------------------------------------------------------------------
	// Enrollment

	public static Enrollment createEnrollment(LocalDate dateOfArrival, LocalDate dateOfDeparture,
			boolean presentingTalk, Participant participant, Conference conference, Hotel hotel) {
		Enrollment enr = new Enrollment(dateOfArrival, dateOfDeparture, presentingTalk, participant, conference, hotel);
		return enr;
	}

	// -------------------------------------------------------------------------
	// Extra

	public static Extra createExtra(String name, int price, Hotel hotel) {
		Extra extra = new Extra(name, price, hotel);
		return extra;
	}

	// -------------------------------------------------------------------------
	// Companion

	public static Companion createCompanion(String name, Enrollment enrollment) {
		Companion comp = new Companion(name, enrollment);
		return comp;
	}

	// -------------------------------------------------------------------------

	public static String getParticipants(Conference conference) {
		String participants = "Participants: \n";
		for (int i = 0; i < conference.enrollmentsCount(); i++) {
			participants += conference.getEnrollments().get(i).getParticipant().toString() + "\n";
		}
		return participants;
	}

	public static String getExcursionInfo(Conference conference) {
		String excursions = "Excursions: \n";
		for (int i = 0; i < conference.getExcursions().size(); i++) {
			excursions += "\nExcursion: " + conference.getExcursions().get(i).getName() + "\n" + "------------" + "\n";
			for (int j = 0; j < conference.getExcursions().get(i).getCompanions().size(); j++) {
				excursions += "Companion: " + conference.getExcursions().get(i).getCompanions().get(j)
						+ ". Participant: "
						+ conference.getExcursions().get(i).getCompanions().get(j).getEnrollment().getParticipant()
						+ "\n";
			}
		}
		return excursions;
	}

	public static String getHotelsInfo(Conference conference) {
		String hotels = "Hotels: \n";
		for (int i = 0; i < conference.getHotels().size(); i++) {
			hotels += "\nHotel: " + conference.getHotels().get(i).getName() + "\n" + "------------" + "\n";
			for (int j = 0; j < conference.getHotels().get(i).getEnrollments().size(); j++) {
				hotels += "Participant: " + conference.getHotels().get(i).getEnrollments().get(j).getParticipant();
				if (conference.getHotels().get(i).getEnrollments().get(j).getCompanion() != null) {
					hotels += " Companion: " + conference.getHotels().get(i).getEnrollments().get(j).getCompanion();
				}
				hotels += "\n";
			}
		}
		return hotels;
	}

	/**
	 * Initializes the storage with some objects.
	 */
	public static void initStorage() {
		// Conference c1 = Service.createConference("Android security", 300,
		// LocalDate.of(2016, 6, 3),
		// LocalDate.of(2016, Month.JUNE, 15));
		// Service.createConference("Java Object Language Perspective", 500,
		// LocalDate.of(2016, 8, 7),
		// LocalDate.of(2016, Month.AUGUST, 12));
		// Service.createConference("Be Mobile!", 450, LocalDate.of(2016, 8, 7),
		// LocalDate.of(2016, Month.AUGUST, 12));
		// Service.createConference("Do it rather in C++", 320,
		// LocalDate.of(2016, 8, 7),
		// LocalDate.of(2016, Month.AUGUST, 12));
		//
		// Participant p1 = Service.createParticipant("Marco Polo", "Unknown 1",
		// "London", "GB",
		// "12345678");
		// Participant p2 = Service.createParticipant("Bjorne Bryg", "Unknown
		// 2", "London", "GB",
		// "12345679");
		// Service.createParticipant("Name Surname", "Unknown 3", "London",
		// "GB", "12345689");
		//
		// Hotel h1 = Service.createHotel("Ritz", 1200, 2000);
		// Service.createHotel("Guest", 400, 600);
		// Service.createHotel("Hostel", 100, 150);
		// Service.createHotel("Really Cheap Hotel", 20, 35);
		//
		// Service.createExtra("WiFi", 30, h1);
		//
		// Company m1 = Service.createCompany("IBM", "34875920");
		// Service.createCompany("Apple", "33874920");
		// Service.createCompany("Microsoft", "34177921");
		//
		// Excursion e1 = Service.createExcursion("Aros", LocalDate.of(2016,
		// Month.JUNE, 16), 70, c1);
		// Service.createExcursion("Den Gamle By", LocalDate.of(2016,
		// Month.JUNE, 17), 80, c1);
		//
		// Service.createCompanion("George Bush");
		//
		// Service.createEnrollment(LocalDate.of(2016, Month.JUNE, 2),
		// LocalDate.of(2016, Month.JUNE, 16), true, p1, c1, h1, null);
		//
		// // Connections
		//
		// Service.setCompanyOfParticipant(p1, m1);
		// Service.setCompanyOfParticipant(p2, m1);

		// Conference c1 = Service.createConference("Advanced Java", 4500,
		// LocalDate.of(2015, 11, 18),
		// LocalDate.of(2015, 11, 20));
		// Excursion r1 = Service.createExcursion("Egeskov Castle",
		// LocalDate.of(2015, 11, 19), 75,
		// c1);
		// Excursion r2 = Service.createExcursion("Traphholt Museum",
		// LocalDate.of(2015, 11, 20), 200,
		// c1);
		//
		// Company a1 = Service.createCompany("IBM", "34276845");
		//
		// Participant p1 = Service.createParticipant("Finn Madson",
		// "Silkeborgvej 30", "Aarhus",
		// "Denmark", "123455678");
		// Participant p2 = Service.createParticipant("Niels Petersen",
		// "nkdfjkl", "sdfsd", "dfsdf",
		// "56789804");
		// Participant p3 = Service.createParticipant("Peter Somer", "nkdfjkl",
		// "sdfsd", "dfsdf",
		// "56789804");
		// Participant p4 = Service.createParticipant("Lone Jensen", "nkdfjkl",
		// "sdfsd", "dfsdf",
		// "56789804");
		// Participant p5 = Service.createParticipant("Lone Jensen", "nkdfjkl",
		// "sdfsd", "dfsdf",
		// "56789804");
		//
		// p5.setCompany(a1);
		//
		// Companion n1 = Service.createCompanion("Mie Summer");
		// n1.addExcursion(r1);
		// Companion n2 = Service.createCompanion("Jan Madsen");
		// n2.addExcursion(r1);
		// n2.addExcursion(r2);
		//
		// Hotel h1 = Service.createHotel("The White Swan", 1050, 1250);
		// Extra x1 = h1.createExtra("WIFI", 50);
		// Extra x2 = h1.createExtra("VIP", 100);
		//
		// Enrollment e1 = Service.createEnrollment(LocalDate.of(2015, 11, 18),
		// LocalDate.of(2015, 11, 20), false, p1, c1, null, null);
		// Enrollment e2 = Service.createEnrollment(LocalDate.of(2015, 11, 18),
		// LocalDate.of(2015, 11, 20), false, p2, c1, h1, null);
		// Enrollment e3 = Service.createEnrollment(LocalDate.of(2015, 11, 18),
		// LocalDate.of(2015, 11, 19), false, p3, c1, h1, n1);
		// Enrollment e4 = Service.createEnrollment(LocalDate.of(2015, 11, 18),
		// LocalDate.of(2015, 11, 20), true, p4, c1, h1, n2);
		// Enrollment e5 = Service.createEnrollment(LocalDate.of(2015, 11, 18),
		// LocalDate.of(2015, 11, 20), false, p5, c1, h1, n2);
		//
		// e3.addExtra(x1);
		// e4.addExtra(x2);
		// e4.addExtra(x1);
		//
		// e5.addExtra(x1);
		// e5.addExtra(x2);
	}
}
