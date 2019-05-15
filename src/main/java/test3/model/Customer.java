package test3.model;

public class Customer {

    private String name;
    private boolean staff;
    private boolean affiliate;
    private int yearOfLoyalty;

    public Customer(String name, boolean staff, boolean affiliate, int yearOfLoyalty) {
        this.name = name;
        this.staff = staff;
        this.affiliate = affiliate;
        this.yearOfLoyalty = yearOfLoyalty;
    }

    public String getName() {
        return name;
    }

    public boolean isStaff() {
        return staff;
    }

    public boolean isAffiliate() {
        return affiliate;
    }

    public int getYearOfLoyalty() {
        return yearOfLoyalty;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", staff=" + staff +
                ", affiliate=" + affiliate +
                ", yearOfLoyalty=" + yearOfLoyalty +
                '}';
    }
}