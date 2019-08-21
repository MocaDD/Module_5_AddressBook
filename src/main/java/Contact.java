import com.sun.istack.internal.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class Contact implements java.io.Serializable{

    private String name;
    private ArrayList<ContactData> data = new ArrayList<ContactData>();

    public Contact(@NotNull String name, @Nullable Address address, @Nullable Phone phoneNumber, @Nullable Email email) {
        this.name = name;
        if (!(address == null)) {
            data.add(address);
        }

        data.add(phoneNumber);

        if (!(email == null))   {
            data.add(email);
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<ContactData> getData() {
        return data;
    }
}