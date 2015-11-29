package model;

import java.time.LocalDate;

import service.Service;

public class CASTest
{
    public static void main(String args[])
    {
        Conference c1 = Service.createConference("Advanced Java", 4500, LocalDate.of(2015, 11, 18),
                LocalDate.of(2015, 11, 20));
        Excursion r1 = Service.createExcursion("Egeskov Castle", LocalDate.of(2015, 11, 19), 75,
                c1);
        Excursion r2 = Service.createExcursion("Traphholt Museum", LocalDate.of(2015, 11, 20), 200,
                c1);

        Company a1 = Service.createCompany("IBM", "34276845");

        Participant p1 = Service.createParticipant("Finn Madson", "Silkeborgvej 30", "Aarhus",
                "Denmark", "123455678");
        Participant p2 = Service.createParticipant("Niels Petersen", "nkdfjkl", "sdfsd", "dfsdf",
                "56789804");
        Participant p3 = Service.createParticipant("Peter Somer", "nkdfjkl", "sdfsd", "dfsdf",
                "56789804");
        Participant p4 = Service.createParticipant("Lone Jensen", "nkdfjkl", "sdfsd", "dfsdf",
                "56789804");
        Participant p5 = Service.createParticipant("Lone Jensen", "nkdfjkl", "sdfsd", "dfsdf",
                "56789804");

        p5.setCompany(a1);

        Hotel h1 = Service.createHotel("The White Swan", 1050, 1250);
        Extra x1 = h1.createExtra("WIFI", 50);
        Extra x2 = h1.createExtra("VIP", 100);
        c1.addHotel(h1);

        Enrollment e1 = Service.createEnrollment(LocalDate.of(2015, 11, 18),
                LocalDate.of(2015, 11, 20), false, p1, c1, null);
        Enrollment e2 = Service.createEnrollment(LocalDate.of(2015, 11, 18),
                LocalDate.of(2015, 11, 20), false, p2, c1, h1);
        Enrollment e3 = Service.createEnrollment(LocalDate.of(2015, 11, 18),
                LocalDate.of(2015, 11, 19), false, p3, c1, h1);
        Enrollment e4 = Service.createEnrollment(LocalDate.of(2015, 11, 18),
                LocalDate.of(2015, 11, 20), true, p4, c1, h1);

        h1.addEnrollments(e1);
        h1.addEnrollments(e2);
        h1.addEnrollments(e3);
        h1.addEnrollments(e4);

        Companion n1 = Service.createCompanion("Mie Summer", e3);
        e3.setCompanion(n1);
        n1.addExcursion(r1);
        r1.addCompanion(n1);
        Companion n2 = Service.createCompanion("Jan Madsen", e4);
        e4.setCompanion(n2);
        n2.addExcursion(r1);
        n2.addExcursion(r2);
        r1.addCompanion(n2);
        r2.addCompanion(n2);

        e3.addExtra(x1);
        e4.addExtra(x2);
        e4.addExtra(x1);

        System.out.println(e1.getTotalPrice());
        System.out.println(e2.getTotalPrice());
        System.out.println(e3.getTotalPrice());
        System.out.println(e4.getTotalPrice());

        System.out.println(Service.getParticipants(c1));
        System.out.println();
        System.out.println(Service.getExcursionInfo(c1));
        System.out.println();
        System.out.println(Service.getHotelsInfo(c1));
    }
}