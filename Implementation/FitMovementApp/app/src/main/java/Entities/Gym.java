package Entities;

public class Gym {

    private int ID;
    private String name;
    private String street;
    private String snum;
    private String postalCode;
    private String city;
    private String province;
    private String country;

    public Gym(int ID, String name, String street, String snum, String postalCode, String city, String province, String country) {
        this.ID = ID;
        this.name = name;
        this.street = street;
        this.snum = snum;
        this.postalCode = postalCode;
        this.city = city;
        this.province = province;
        this.country = country;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getSnum() {
        return snum;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return getStreet() + " " + getSnum() + ", " + getPostalCode() + " " + getCity() + ", "+ getProvince() + " " + getCountry();
    }
}
