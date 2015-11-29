package model;

import java.util.ArrayList;

public class Companion
{
    private String name;
    private ArrayList<Excursion> excursions = new ArrayList<>();
    private Enrollment enrollment;

    public Companion(String name, Enrollment enrollment)
    {
        this.name = name;
        this.enrollment = enrollment;
    }

    public void addEnrollment(Enrollment enrollment)
    {
        this.enrollment = enrollment;
    }

    public Enrollment getEnrollment()
    {
        return this.enrollment;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    // ---------------------------------------------------------------------------

    public ArrayList<Excursion> getExcursions()
    {
        return new ArrayList<Excursion>(excursions);
    }

    /**
     * Adds the Excursion.
     */
    public void addExcursion(Excursion excursion)
    {
        assert excursion != null;
        excursions.add(excursion);
    }

    /**
     * Removes the Excursion.
     */
    public void removeExcursion(Excursion excursion)
    {
        excursions.remove(excursion);
    }

    // ---------------------------------------------------------------------------

    public int getExcursionsPrice()
    {
        int price = 0;

        if (!excursions.isEmpty()) {
            for (int i = 0; i < excursions.size(); i++) {
                price += excursions.get(i).getPrice();
            }
        }

        return price;
    }

    // ---------------------------------------------------------------------------

    @Override
    public String toString()
    {
        return name;
    }
}
