package customdialog;

public class PhoneBook
{
    private String name;
    private String phone;

    public PhoneBook(String name, String phone)
    {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString()
    {
        return (this.name + ", " + this.phone);
    }

}
