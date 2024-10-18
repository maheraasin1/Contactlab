import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class List1 {

    // Method to read contacts from file into a list
    public static List<Contact> readContactsFromFile(String fileName) {
        List<Contact> contacts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                if (data.length >= 3) {  // Ensure correct format (at least 3 elements)
                    String name = data[0] + " " + data[1];
                    String phoneNumber = data[2];
                    contacts.add(new Contact(name, phoneNumber));
                }
            }
        } catch (IOException e) {
            // Handle exception silently, letting the main method show the error
        }
        return contacts;
    }

    // Method to sort contacts alphabetically by name using selection sort
    public static void selectionSort(List<Contact> contacts) {
        for (int i = 0; i < contacts.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < contacts.size(); j++) {
                if (contacts.get(j).compareTo(contacts.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            Collections.swap(contacts, i, minIndex);
        }
    }

    // Sequential search method for unsorted list
    public static Contact sequentialSearch(List<Contact> contacts, String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null; // Return null if not found
    }

    // Binary search method for sorted list
    public static Contact binarySearch(List<Contact> contacts, String name) {
        int left = 0, right = contacts.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = contacts.get(mid).getName().compareToIgnoreCase(name);
            if (comparison == 0) {
                return contacts.get(mid);
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Return null if not found
    }

    // Print contacts in alphabetical order
    public static void printContactsSequentially(List<Contact> contacts) {
        System.out.println("Contact List:");
        for (Contact contact : contacts) {
            System.out.println("Contact [" + contact.getName() + ": " + contact.getPhoneNumber() + "]");
        }
    }

    // Print contacts in reverse alphabetical order
    public static void printContactsInReverseOrder(List<Contact> contacts) {
        System.out.println("Contact List:");
        for (int i = contacts.size() - 1; i >= 0; i--) {
            Contact contact = contacts.get(i);
            System.out.println("Contact [" + contact.getName() + ": " + contact.getPhoneNumber() + "]");
        }
    }
}

