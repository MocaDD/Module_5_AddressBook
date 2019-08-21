import java.util.Scanner;

public class Menu {

    private String nameOfTheFile;
    private AddressBook addressBook;

    public void display_menu() {
        System.out.println("1) Add a contact\n2) Remove a contact\n3) Search a contact by name\n4) Export address book\n" +
                "5) Import address book\n" + "6) See the name off all contacts in the address book\n" + "7) Exit\n");
        System.out.print("Selection: ");
    }

    public Menu() {

        addressBook = new AddressBook();
        nameOfTheFile = "addressBook.txt";
        Scanner in = new Scanner(System.in);
        int choice;
        MethodsUsedInMenu menuMethods = new MethodsUsedInMenu(addressBook, nameOfTheFile);

        while (true) {
            display_menu();
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You picked option 1");
                    menuMethods.addContact();
                    break;
                case 2:
                    System.out.println("You picked option 2");
                    menuMethods.removeContact();
                    break;
                case 3:
                    System.out.println("You picked option 3");
                    menuMethods.searchContactByName();
                    break;
                case 4:
                    System.out.println("You picked option 4");
                    menuMethods.exportAddressBook();
                    break;
                case 5:
                    System.out.println("You picked option 5");
                    menuMethods.importAddressBook();
                    break;
                case 6:
                    System.out.println("You picked option 6");
                    menuMethods.printTheNameOfAllContacts();
                    break;
                case 7:
                    System.out.println("Exiting Program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Unrecognized option ! Please select another.");
                    break;
            }
        }
    }
}