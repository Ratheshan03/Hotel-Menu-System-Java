import java.io.*;
import java.util.Scanner;

public class Hotel {
    static Scanner input = new Scanner(System.in);
    static int roomNum = 0;
    static boolean roomFull;
    static Room[] hotel = new Room[8];

    static Person[] firstName = new Person[8];
    static Person[] surName = new Person[8];
    static Person[] creditNumber = new Person[8];
    static Person[] guestNumber = new Person[8];

    // Waiting_Queue Class Objects
    static Waiting_Queue RName = new Waiting_Queue();
    static Waiting_Queue FName = new Waiting_Queue();
    static Waiting_Queue SName = new Waiting_Queue();
    static Waiting_Queue CNumber = new Waiting_Queue();
    static Waiting_Queue GNumber = new Waiting_Queue();


    public static void main(String[] args) {
		// Creating Person class objects 
        for(int x=0; x< hotel.length; x++){
            hotel[x] = new Room();
        }
        for(int x=0; x< firstName.length; x++){
            firstName[x] = new Person();
        }
        for(int x=0; x< surName.length; x++){
            surName[x] = new Person();
        }
        for(int x=0; x< creditNumber.length; x++){
            creditNumber[x] = new Person();
        }
        for(int x=0; x< guestNumber.length; x++){
            guestNumber[x] = new Person();
        }
        initialise(hotel);
        Menu();
    }

    private static void Menu() {
        System.out.println();
        System.out.println("|-----------------------Menu------------------------|");
        System.out.println("V: View all rooms");
        System.out.println("A: Add a customer to a room");
        System.out.println("E: Display empty rooms");
        System.out.println("D: Delete customer from a room");
        System.out.println("F: Find a room from customer name");
        System.out.println("S: Store program data into file");
        System.out.println("L: Load program data from file");
        System.out.println("O: View guests ordered alphabetically by name");
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
        System.out.println("Would you like to continue? answer(Y/y[yes] or N/n[no]): ");
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

    private static void initialise(Room[] hotel) {
        // Emptying the array indexes.
        for (int x = 0; x < hotel.length; x++) {
            hotel[x].setName("Empty");
        }
    }

    private static void View(Room[] hotel) {
        System.out.println("----------------------OUR ROOMS WITH GUESTS-----------------------");
        for (int x = 0; x < 8; x++) {
            if(hotel[x].getName().equals("Empty")){
                System.out.println("Room number " + (x+1) + " is empty");
            }else {
                System.out.println("Room number " + (x + 1) + " is occupied by " + hotel[x].getName());
                System.out.println("Guest Full Name: " + firstName[x].getFirstName() + " " + surName[x].getSurName());
                System.out.println("Number of Guests in the room: " + guestNumber[x].getGuestNum() + "  Credit card number: " + creditNumber[x].getCreditNum());
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------------");
    }

    private static void Add(Room[] hotel) {
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
        System.out.println("Enter the Customer details for room number - " + roomNum);
        System.out.print("Enter a name to book the room: ");
        String Name = input.next();

        System.out.print("Enter the First Name of the customer: ");
        String fName = input.next();

        System.out.print("Enter the Surname of the customer: ");
        String sName = input.next();

        System.out.print("Enter number of guests going to stay: ");
        int gNum = input.nextInt();

        System.out.print("Enter the Credit card number: ");
        int cNum = input.nextInt();

        // Checking whether rooms are full or not.
        for (Room room : hotel) {
            if (room.getName().equals("Empty")) {
                roomFull = false;
                break;
            }else{
                roomFull = true;
            }
        }
        if(!roomFull){
            // Using the setMethods to set the values in arrays.
            hotel[roomNum - 1].setName(Name);
            firstName[roomNum - 1].setFirstName(fName);
            surName[roomNum - 1].setSurName(sName);
            guestNumber[roomNum - 1].setGuestNum(gNum);
            creditNumber[roomNum - 1].setCreditNum(cNum);
            System.out.println();
            System.out.println("|-----------------Customer Details have been Added-----------------|");
        }else{
            System.out.println();
            System.out.println("||---------------------Rooms are full!---------------------||");
            // Using enqueue methods to add values to the queues.
            RName.enQueueString(Name);
            FName.enQueueString(fName);
            SName.enQueueString(sName);
            GNumber.enQueueNumber(gNum);
            CNumber.enQueueNumber(cNum);
            System.out.println();
            System.out.println("|-----------------Customer has been Added to Waiting List-----------------|");
        }
        System.out.println();
    }

    private static void Empty(Room[] hotel) {
        System.out.println("|----------------------EMPTY ROOMS-----------------------|");
        for (int x = 0; x < hotel.length; x++) {
            if (hotel[x].getName().equals("Empty")) {
                System.out.println("Room number " + (x + 1) + " is empty");
            }
        }

        System.out.println("|--------------------------------------------------------|");
    }

    private static void Delete(Room[] hotel) {
        System.out.println("|--------------------REMOVE GUEST---------------------|");
        System.out.println();
        System.out.print("Enter which room do you want to delete a customer from: ");
        roomNum = input.nextInt();
        // checking the input
        while (roomNum < 1 || roomNum > 8) {
            System.out.println("Invalid Room number");
            System.out.print("Enter a room number between (0-7): ");
            roomNum = input.nextInt();
        }
        // Deleting or Clearing the customer details
        hotel[roomNum - 1].setName("Empty");
        firstName[roomNum -1].setFirstName("Empty");
        surName[roomNum -1].setSurName("Empty");
        guestNumber[roomNum-1].setGuestNum(0);
        creditNumber[roomNum-1].setCreditNum(0);

        // Adding new Customer details from waiting list.
        // Using dequeue method and adding the returned value.
        hotel[roomNum - 1].setName(RName.deQueueString());
        firstName[roomNum - 1].setFirstName(FName.deQueueString());
        surName[roomNum - 1].setSurName(SName.deQueueString());
        guestNumber[roomNum - 1].setGuestNum(GNumber.deQueueNumber());
        creditNumber[roomNum - 1].setCreditNum(CNumber.deQueueNumber());

        System.out.println("Old Customer deleted from the room number " + roomNum + ".");
        System.out.println("New Customer has been added from the waiting list to the room number " + roomNum + ".");
        System.out.println();
        System.out.println("|-----------------------------------------------------|");

    }

    private static void Find(Room[] hotel) {
        System.out.println("|-----------------------FIND GUEST------------------------|");
        System.out.println();
        System.out.print("Enter Customer's name: ");
        String Name = input.nextLine();
        while (true) {
            // Checks whether customerName contains alphabetical letters or not.
            if (Name.matches("^[a-z A-Z]*$")) {
                break;
            } else {
                System.out.println("Invalid Input");
                System.out.print("Enter Customer's name: ");
                Name = input.nextLine();
            }
        }
        //Traverses through the array and checks for the customer name.
        boolean found = true;
        for (int x = 0; x < hotel.length; x++) {
            if (Name.equals(hotel[x].getName())) {
                System.out.println(Name + " is in room number " + (x+1));
                System.out.println("Guest's Full Name: " + firstName[x].getFirstName()+ " " + surName[x].getSurName());
                System.out.println("Number of Guests in the room: " + guestNumber[x].getGuestNum() + "  Credit card number: " + creditNumber[x].getCreditNum());
                found = true;
                break;
            } else {
                found = false;
            }
        }
        if (!found) {
            System.out.println("Entered Person " + Name + " was Not found.");
        }
        System.out.println();
        System.out.println("|----------------------------------------------------------|");
    }

    public static void Store(Room[] hotel) {
        // Storing data in a text file
        try {
            FileWriter filewriter = new FileWriter("Output.txt");
            filewriter.write("|--------------------------HOTEL DATA---------------------------|" + "\n");
            filewriter.write("\n");

            for(int x = 0; x < 8; x++) {
                if (hotel[x].equals("Empty")) {
                    filewriter.write("---------------------------------------------------------------" + "\n");
                    filewriter.write("Room number " + (x + 1) + " is empty \n");

                }else{
                    filewriter.write("---------------------------------------------------------------"+ "\n");
                    filewriter.write("Room number " + (x + 1) + " is occupied by " + hotel[x].getName() + "\n");
                    filewriter.write("Guest's Full Name: " + firstName[x].getFirstName() + " " + surName[x].getSurName() +"\n");
                    filewriter.write("Number of Guests in the room: " + guestNumber[x].getGuestNum() + "  Credit card number: " + creditNumber[x].getCreditNum()+ "\n");
                }
                filewriter.write("---------------------------------------------------------------" + "\n");
                filewriter.write("\n");
            }
            filewriter.close();
            System.out.println("Data has been successfully Stored in a file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void Load() {
        // Loading the data in the Stored file
        System.out.println("LOADED DATA:");
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
        System.out.println("|--------------------------------------------------------------| ");

    }

    public static void Ordered(Room[] hotel) {
        System.out.println("|-------------ALPHABETICALLY ORDERED LIST OF GUESTS--------------|");
        System.out.println();
        String[] temp_arr = new String[hotel.length];
        for (int i = 0; i < hotel.length; i++) { // to get array clone without referencing
            temp_arr[i] = hotel[i].getName();
        }
        // sorting the array
        String temp;
        for (int j = 0; j < temp_arr.length; j++) {
            for (int i = 1; i < temp_arr.length; i++) {
                if (temp_arr[i-1].compareToIgnoreCase(temp_arr[i]) > 0) {
                    temp = temp_arr[i-1];
                    temp_arr[i-1] = temp_arr[i];
                    temp_arr[i] = temp;
                }
            }
        }
        // leaving the empty rooms and Printing the rooms in customers only.
        for (String s : temp_arr) {
            if (!s.equals("Empty")) {
                for (int y = 0; y < temp_arr.length; y++) {
                    if (s.equals(hotel[y].getName())) {
                        System.out.println(s + " has occupied room number " + (y + 1));
                    }
                }
            }
        }
        System.out.println();
        System.out.println("|----------------------------------------------------------------|");
    }
}
