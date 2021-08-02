# Hotel-Menu-System-Java
- This is a command-line interface program.
- Consists 2 versions of the program.
- functionalities such as add, remove, view, display, find, swap => rooms, storing and loading the customer details and etc. 

# This Project is based on the below Assignment =>

Task 1. Arrays version. Design a program for a hotel with eight rooms using the code given below. Start by checking that the code works.
                    package arrays;
                    import java.util.*;
                    public class HotelExample {
                      public static void main(String[] args) {
                          Scanner input = new Scanner(System.in);
                          String roomName;
                          int roomNum = 0;
                          String[] hotel = new String[7];
                          //for (int x = 0; x < 6; x++ ) hotel[x] = ""; //initialise
                          initialise(hotel); //better to initialise in a procedure
                            while ( roomNum < 6 )
                            {
                              for (int x = 0; x < 6; x++ )
                                {
                                if (hotel[x].equals("e"))System.out.println("room " + x + " is empty");
                                }
                                  System.out.println("Enter room number (0-5) or 6 to stop:" );
                                  roomNum = input.nextInt();
                                  System.out.println("Enter name for room " + roomNum +" :" ) ;
                                  roomName = input.next();
                                  hotel[roomNum] = roomName ;
                                for (int x = 0; x < 6; x++ )
                                {
                                System.out.println("room " + x + " occupied by " + hotel[x]);
                                    }
                                  }
                                }
                            private static void initialise( String hotelRef[] ) {
                                for (int x = 0; x < 6; x++ ) hotelRef[x] = "e";
                                    System.out.println( "initilise ");
                                    }
                                 } 
Once the basic code runs, put the code that ‘Views All rooms’ and ‘Adds customer to room’, into separate procedures,
and test it works. You can build up your test cases as you develop your program (see testing below).
Then add a menu system which will allow the user to choose what they want to select. Enter an ‘A’ to add a customer to a room,
and a ‘V’ to view all rooms. Implement each as a method. When an ‘A’ is pressed, it should do the Add method; a ‘V’ should do the View method.
One by one, add extra methods to do each of the following. The user should be able to choose from the menu what the program does.
                E: Display Empty rooms
                D: Delete customer from room
                F: Find room from customer name
                S: Store program data into file
                L: Load program data from file
                O: View guests Ordered alphabetically by name. (Do not use library sort routine)


Task 2. Classes version. Create a second version of the Hotel program using an array of Room objects. Create a class 
        called Hotel and another class called Room. The program should function as in Task 1.


Task 3. Extend your programs from Task 1 and Task2. Modify both programs so that each room can now hold the following
        additional information. (Hint: you will need a Person class for the class version)
                a. The number of guests in a room.
                b. Additional information for the paying guest.
                i. First Name.
                ii. Surname.
                iii. Credit Card number.
(This task will familiarize you with what we mean by “maintainability” of a program. If you don’t use classes, you will
need to use parallel arrays! While you are doing this task think about which of the programs was easier to extend and why)

Task 4. Queue version. Add a waiting list to your Hotel class version. Modify your ‘A: Add’ and ‘D: Delete’ as follows:
                When you press ‘A’ to add a new customer, if the hotel is full, the customer should be added to a Waiting List (a queue).
                When you press ‘D’ to delete a customer from a room, the next customer in the waiting queue should be automatically placed in the room.
                Extra marks will be awarded if you implement the waiting list as a circular queue.
                

