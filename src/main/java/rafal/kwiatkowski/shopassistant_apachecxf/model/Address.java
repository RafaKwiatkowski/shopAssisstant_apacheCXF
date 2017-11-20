package rafal.kwiatkowski.shopassistant_apachecxf.model;


import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Embeddable
public class Address {

    String country;
    String postCode;
    String city;
    String street;
    String houseNumber;
    String apartmentNumber;

    public Address() {
    }

    public Address(String country, String postCode, String city, String street, String houseNumber, String apartmentNumber) {
        this.country = country;
        this.postCode = postCode;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }
}
