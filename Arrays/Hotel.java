import java.io.*;
import java.util.*;

public class Hotel {
    // Global variables
    static Scanner input = new Scanner(System.in);
    static String[] hotel = new String[8];
    static String[] firstName = new String[8];
    static String[] surName = new String[8];
    static int[] noOfGuests = { 0, 0, 0, 0, 0, 0, 0, 0 };
    static int[] cardNumber = { 0, 0, 0, 0, 0, 0, 0, 0 };
    static int roomNum = 0;
    static String customerName;

    private static void main(String[] args) {
        initialise(hotel);
        initialise(firstName);
        initialise(surName);
        Menu();
    }

    private static void Menu() {
        System.out.println();
        System.out.println("|-----------------------Menu------------------------|");
        System.out.println(" V: View all rooms");
        System.out.println(" A: Add a customer to a room");
        System.out.println(" E: Display empty rooms");
        System.out.println(" D: Delete customer from a room");
        System.out.println(" F: Find a room from customer name");
        System.out.println(" S: Store program data into file");
        System.out.println(" L: Load program data from file");
        System.out.println(" O: View guests ordered alphabetically by name");
        System.out.println("|---------------------------------------------------|");
        validate();
    }

    private static void validate() {
        System.out.println();
        System.out.print("Choose Your Option: ");
        String option = input.nextLine();
        option = option.toUpperCase();

        while (true) {
            if (option.equals("V")) {
                View(hotel);
                break;
            } else if (option.equals("A")) {
                Add(hotel);
                break;
            } else if (option.equals("E")) {
                Empty(hotel);
                break;
            } else if (option.equals("D")) {
                Delete(hotel);
                break;
            } else if (option.equals("F")) {
                Find(hotel);
                break;
            } else if (option.equals("S")) {
                Store(hotel);
                break;
            } else if (option.equals("L")) {
                Load();
                break;
            } else if (option.equals("O")) {
                Ordered(hotel);
                break;
            } else {
                System.out.println("Invalid input");
                break;
            }
        }
        System.out.println();
        // Prompting user whether he need to continue the program.
        System.out.println("Would you like to continue? answer(Y[yes] or N[no]): ");
        String answer = input.next();
        answer = answer.toLowerCase();
        if (answer.equals("y")) {
            input.nextLine();
            Menu();
        }
        if (answer.equals("n")) {
            System.out.println("|------------------------------THANK YOU---------------------------------|");
        }
    }

    private static void initialise(String[] array) {
        // Emptying the array indexes.
        for (int x = 0; x < array.length; x++) {
            array[x] = "Empty";
        }
    }

    private static void View(String[] array) {
        System.out.println("----------------------OUR ROOMS WITH GUESTS-----------------------");
        System.out.println();
        for (int x = 0; x < array.length; x++) {
            if (array[x].equals("Empty")) {
                System.out.println("Room number " + (x + 1) + " is empty");
            } else {
                System.out.println("Room number " + (x + 1) + " is occupied by " + array[x]);
                System.out.println("Guest's Full Name: " + firstName[x] + " " + surName[x]);
                System.out.println(
                        "Number of Guests in the room: " + noOfGuests[x] + "  Credit card number: " + cardNumber[x]);
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------------------------------");
    }

    private static void Add(String[] array) {
        System.out.println("|-----------------------------ADD GUEST-------------------------------|");
        System.out.println();
        System.out.print("Enter a room number between (1-8): ");
        roomNum = input.nextInt();
        while (true) {
            if (roomNum >= 1 && roomNum <= 8) {
                break;
            } else {
                System.out.println("Invalid Room number");
                System.out.print("Enter a room number between (1-8): ");
                roomNum = input.nextInt();
            }
        }
        // Checking whether rooms are full or not.
        boolean roomFull = false;
        for (String s : array) {
            if (s.equals("Empty")) {
                roomFull = false;
                break;
            } else {
                roomFull = true;
            }
        }
        if (!roomFull) {
            System.out.print("Enter a name to book the room - " + roomNum + ": ");
            array[roomNum - 1] = input.next();

            System.out.print("Enter the First name of the customer: ");
            firstName[roomNum - 1] = input.next();

            System.out.print("Enter the Surname of the customer: ");
            surName[roomNum - 1] = input.next();

            System.out.print("Enter number of guests: ");
            noOfGuests[roomNum - 1] = input.nextInt();

            System.out.print("Enter the credit card number: ");
            cardNumber[roomNum - 1] = input.nextInt();

            System.out.println();
            System.out.println("|-------------------Customer Details have been Added-------------------|");

        } else {
            System.out.println();
            System.out.println("|----------------------------Rooms are Full----------------------------| ");
        }
    }

    private static void Empty(String[] array) {
        System.out.println("|----------------------EMPTY ROOMS-----------------------|");
        System.out.println();
        for (int x = 0; x < array.length; x++) {
            if (array[x].equals("Empty")) {
                System.out.println("Room number " + (x + 1) + " is empty");
            }
        }
        System.out.println();
        System.out.println("|--------------------------------------------------------|");
    }

    private static void Delete(String[] array) {
        System.out.println("|--------------------REMOVE GUEST---------------------|");
        System.out.println();
        System.out.print("Enter which room do you want to delete a customer from: ");
        roomNum = input.nextInt();
        while (roomNum < 1 || roomNum > 8) {
            System.out.println("Invalid Room number! Try again.");
            System.out.print("Enter a room number between (0-7): ");
            roomNum = input.nextInt();
        }
        // Clearing the customer details
        array[roomNum - 1] = "Empty";
        firstName[roomNum - 1] = "Empty";
        surName[roomNum - 1] = "Empty";
        noOfGuests[roomNum - 1] = 0;
        cardNumber[roomNum - 1] = 0;
        System.out.println("Customer deleted from the room number " + (roomNum) + ".");
        System.out.println();
        System.out.println("|-----------------------------------------------------|");
    }

    private static void Find(String[] array) {
        System.out.println("|-----------------------FIND GUEST------------------------|");
        System.out.println();
        System.out.print("Enter Customer's name: ");
        customerName = input.nextLine();
        while (true) {
            // Checks whether customerName contains alphabetical letters or not.
            if (customerName.matches("^[a-z A-Z]*$")) {
                break;
            } else {
                System.out.println("Invalid Input");
                System.out.print("Enter Customer's name: ");
                customerName = input.nextLine();
            }
        }
        // Traverses through the array and checks for the customer name.
        boolean found = true;
        for (int x = 0; x < 8; x++) {
            if (array[x].equals(customerName)) {
                System.out.println(customerName + " is in the room number " + (x + 1));
                System.out.println("Guest's Full Name: " + firstName[x] + " " + surName[x]);
                System.out.println(
                        "Number of Guests in the room: " + noOfGuests[x] + "  Credit card number: " + cardNumber[x]);
                found = true;
                break;
            } else {
                found = false;
            }
        }
        if (!found) {
            System.out.println("Entered Person " + customerName + " was Not found.");
        }
        System.out.println();
        System.out.println("|-----------------------------------------------------------|");
    }

    private static void Store(String[] array) {
        // Storing the data in a text file
        try {
            FileWriter filewriter = new FileWriter("Output.txt");
            filewriter.write("|--------------------------HOTEL DATA---------------------------|" + "\n");
            filewriter.write("\n");
            for (int x = 0; x < 8; x++) {
                if (array[x].equals("Empty")) {
                    filewriter.write("---------------------------------------------------------------" + "\n");
                    filewriter.write("Room number " + (x + 1) + " is empty \n");
                } else {
                    filewriter.write("---------------------------------------------------------------" + "\n");
                    filewriter.write("Room number " + (x + 1) + " is occupied by " + array[x] + "\n");
                    filewriter.write("Full Name: " + firstName[x] + " " + surName[x] + "\n");
                    filewriter.write("Number of Guests in the room: " + noOfGuests[x] + "  Credit card number: "
                            + cardNumber[x] + "\n");
                }
                filewriter.write("---------------------------------------------------------------" + "\n");
                filewriter.write("\n");
            }
            filewriter.close();
            System.out.println("Successfully Stored in a file");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    private static void Load() {
        // Loading data of the Stored file.
        System.out.println("LOADED DATA: ");
        try {
            File object = new File("Output.txt");
            Scanner reader = new Scanner(object);
            while (reader.hasNextLine()) {
                String info = reader.nextLine();
                System.out.println(info);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        System.out.println("|----------------------------------------------------------------| ");
    }

    private static void Ordered(String[] array) {
        System.out.println("|-------------ALPHABETICALLY ORDERED LIST OF GUESTS--------------|");
        System.out.println();
        String[] temp_arr = new String[array.length];
        for (int i = 0; i < array.length; i++) { // to get array clone without referencing
            temp_arr[i] = array[i];
        }
        // sorting the array
        String temp;
        for (int j = 0; j < temp_arr.length; j++) {
            for (int i = 1; i < temp_arr.length; i++) {
                if (temp_arr[i - 1].compareToIgnoreCase(temp_arr[i]) > 0) {
                    temp = temp_arr[i - 1];
                    temp_arr[i - 1] = temp_arr[i];
                    temp_arr[i] = temp;
                }
            }
        }
        // leaving the empty rooms and Printing the rooms in customers only.
        for (String s : temp_arr) {
            if (!s.equals("Empty")) {
                for (int y = 0; y < temp_arr.length; y++) {
                    if (s.equals(array[y])) {
                        System.out.println(s + " has occupied room number " + (y + 1));
                    }
                }
            }
        }
        System.out.println();
        System.out.println("|----------------------------------------------------------------|");
    }
}