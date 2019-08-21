import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MethodsUsedInMenu {

    private Scanner scanner;
    private AddressBook addressBook;
    private String nameOfTheFile;

    public MethodsUsedInMenu(AddressBook addressBook, String nameOfTheFile) {
        this.addressBook = addressBook;
        this.nameOfTheFile = nameOfTheFile;
        this.scanner = new Scanner(System.in);
    }

    protected void addContact() {
        System.out.println("Please introduce the following details about the contact:");
        System.out.println("Name:");
        String name = scanner.nextLine();
        if (addressBook.searchContactByName(name) == null) {
            System.out.println("Address street name:");
            String streetName = scanner.nextLine();
            System.out.println("Address street number:");
            String streetNumber = scanner.nextLine();
            Address address = new Address(streetName, streetNumber);
            System.out.println("Phone number:");
            String phoneNumber = scanner.nextLine();
            Phone phone = new Phone(phoneNumber);
            System.out.println("Email:");
            String email = scanner.nextLine();
            Email emailObject = new Email(email);
            Contact contact = new Contact(name, address, phone, emailObject);
            addressBook.addContact(contact);
            System.out.println("The contact: " + name + " has been added.");
        } else {
            System.out.println("A contact with this name already exists. Please choose another name.");
        }
        System.out.println("\n");
    }

    protected void removeContact() {
        System.out.println("Please introduce the name of the contact:");
        String nameOfTheContact = scanner.nextLine();
        if (addressBook.removeContact(new Contact(nameOfTheContact, null, null, null)))
            System.out.println("The contact has been removed.");
        System.out.println("\n");
    }

    protected void searchContactByName() {
        System.out.println("Please introduce the name of the contact you want to search:");
        String name = scanner.nextLine();
        Integer searchResult = addressBook.searchContactByName(name);
        if (searchResult == null) {
            System.out.println("A contact with this name does not exist.");
        }
        else {
            System.out.println(name + " is a contact in this address book and has the following details:");
            ArrayList<ContactData> data  = addressBook.getContactFromIndex(searchResult.intValue()).getData();
            for (ContactData s : data)
            {
                if (s.getClass().getName() == "Address")   {
                    Address temp = (Address)s;
                    System.out.println("Street name: " + temp.getStreetName() + "\nStreet number: "
                            + temp.getStreetNumber());
                } else if (s.getClass().getName() == "Email")  {
                    Email temp = (Email) s;
                    System.out.println("Email: " + temp.getEmail());
                } else  {
                    Phone temp = (Phone) s;
                    System.out.println("Phone: " + temp.getPhoneNumber());
                }
            }
        }
        System.out.println("\n");
    }

    protected void exportAddressBook() {
        try {
            FileOutputStream fileOut = new FileOutputStream(nameOfTheFile);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(addressBook);
            out.close();
            fileOut.close();
            System.out.printf("Your address book is saved in addressBook.txt\n");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    protected void importAddressBook() {
        try {
            FileInputStream fileIn = new FileInputStream(nameOfTheFile);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            addressBook = (AddressBook) in.readObject();
            System.out.println("The address book has been imported.");
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            System.out.println(nameOfTheFile + "does not exist or you don't have permissions to work with it.");
        } catch (ClassNotFoundException c) {
            System.out.println("AddressBook class not found");
            c.printStackTrace();
        }
    }

    protected void printTheNameOfAllContacts()  {
        System.out.println("Your contacts are:");
        for (int i = 0; i < addressBook.getSizeOfAddressBook(); i++)
            System.out.println(addressBook.getContactFromIndex(i).getName());
        System.out.println("\n");
    }
}