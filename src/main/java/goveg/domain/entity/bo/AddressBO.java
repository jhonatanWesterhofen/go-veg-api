package goveg.domain.entity.bo;

public class AddressBO {

    private Long id;

    private String street;

    private String number;

    private String complement;

    private String postalCode;

    private String city;

    private String state;

    private String longitude;

    private String latitude;

    public AddressBO(Long id, String street, String number, String complement, String postalCode, String city,
            String state, String longitude, String latitude) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.postalCode = postalCode;
        this.city = city;
        this.state = state;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public Long getId() {
        return id;
    }
}