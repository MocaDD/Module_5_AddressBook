import com.sun.istack.internal.NotNull;

public class Address extends ContactData implements java.io.Serializable{

    private String streetName;
    private String streetNumber;

    public Address(final @NotNull String streetName, final @NotNull String streetNumber) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }
}