package question1;

public class Address {

    private Integer houseNumber;
    private String street;
    private String city;
    private Integer pincode;

    public Address(Integer houseNumber, String street, String city, Integer pincode) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.pincode = pincode;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }


}
