import java.util.*;

public class ContactApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Contact> contacts = new ArrayList<>();
        boolean sorted = false;

       
        String fileName;
        boolean fileLoaded = false; 
        do {
            System.out.print("Enter the file name: ");
            fileName = scanner.nextLine();

           
            contacts = List1.readContactsFromFile(fileName);

            
            if (contacts.isEmpty()) {
                System.out.println("File not found. Please try again.");
            } else {
                fileLoaded = true;  // File loaded successfully
            }
        } while (!fileLoaded);

        
        while (true) {
            System.out.println("Contact List");
            System.out.println("------------");
            System.out.println("Select one of the following operations:");
            System.out.println("1. Display contacts in alphabetic order");
            System.out.println("2. Display contacts in reverse alphabetic order");
            System.out.println("3. Search contacts");
            System.out.println("4. Exit");

            System.out.print("Enter your selection here: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    if (!sorted) {
                        List1.selectionSort(contacts);
                        sorted = true;
                    }
                    List1.printContactsSequentially(contacts);
                    break;
                case 2:
                    if (!sorted) {
                        List1.selectionSort(contacts);
                        sorted = true;
                    }
                    List1.printContactsInReverseOrder(contacts);
                    break;
                case 3:
                    System.out.print("Enter contact name: ");
                    String name = scanner.nextLine().trim();  // Trim any extra spaces
                    Contact foundContact = (sorted) ? List1.binarySearch(contacts, name)
                                                    : List1.sequentialSearch(contacts, name);
                    if (foundContact != null) {
                        System.out.println("Contact [" + foundContact.getName() + ": " + foundContact.getPhoneNumber() + "]");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 4:
                    System.out.println("Good-bye!");
                    return;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }
}

