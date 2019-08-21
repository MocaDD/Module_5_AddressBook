import java.util.ArrayList;

public class AddressBook implements java.io.Serializable    {

    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    public void addContact(final Contact contact)    {
            contacts.add(contact);
    }

    public boolean removeContact(final Contact contact)    {

        Integer index = searchContactByName(contact.getName());

        if (index == null) {
            System.out.println("This contact doesn't exist.");
            return false;
        } else {
            contacts.remove((int)index);
            return true;
        }
    }

    public Integer searchContactByName(final String name) {

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name))
                return i;
        }
        return null;
    }

    public int getSizeOfAddressBook()    {
        return contacts.size();
    }

    public Contact getContactFromIndex(int index)  {
        return contacts.get(index);
    }
}