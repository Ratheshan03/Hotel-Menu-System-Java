# Hotel-Menu-System-Java
- This is a command-line interface program.
- Consists 2 versions of the program.
- functionalities such as add, remove, view, display, find, swap => rooms, storing and loading the customer details and etc. 

### This Project is based on the below Assignment =>

Task 1. Arrays version. Design a program for a hotel with eight rooms using the code given below. Start by checking that the code works. <br>
                    package arrays; <br>
                    import java.util.*; <br>
                    public class HotelExample { <br>
                      public static void main(String[] args) { <br>
                          Scanner input = new Scanner(System.in); <br>
                          String roomName; <br>
                          int roomNum = 0; <br>
                          String[] hotel = new String[7]; <br>
                          //for (int x = 0; x < 6; x++ ) hotel[x] = ""; //initialise <br>
                          initialise(hotel); //better to initialise in a procedure <br>
                            while ( roomNum < 6 ) <br>
                            { <br>
                              for (int x = 0; x < 6; x++ ) <br>
                                { <br>
                                if (hotel[x].equals("e"))System.out.println("room " + x + " is empty"); <br>
                                } <br>
                                  System.out.println("Enter room number (0-5) or 6 to stop:" ); <br>
                                  roomNum = input.nextInt(); <br>
                                  System.out.println("Enter name for room " + roomNum +" :" ) ; <br>
                                  roomName = input.next(); <br>
                                  hotel[roomNum] = roomName ; <br>
                                for (int x = 0; x < 6; x++ ) <br>
                                { <br>
                                System.out.println("room " + x + " occupied by " + hotel[x]); <br>
                                    } <br>
                                  } <br>
                                } <br>
                            private static void initialise( String hotelRef[] ) { <br>
                                for (int x = 0; x < 6; x++ ) hotelRef[x] = "e"; <br>
                                    System.out.println( "initilise "); <br>
                                    } <br>
                                 }  <br>
Once the basic code runs, put the code that ‘Views All rooms’ and ‘Adds customer to room’, into separate procedures, <br>
and test it works. You can build up your test cases as you develop your program (see testing below). <br>
Then add a menu system which will allow the user to choose what they want to select. Enter an ‘A’ to add a customer to a room, <br>
and a ‘V’ to view all rooms. Implement each as a method. When an ‘A’ is pressed, it should do the Add method; a ‘V’ should do the View method. <br>
One by one, add extra methods to do each of the following. The user should be able to choose from the menu what the program does. <br>
                E: Display Empty rooms <br>
                D: Delete customer from room <br>
                F: Find room from customer name <br>
                S: Store program data into file <br>
                L: Load program data from file <br>
                O: View guests Ordered alphabetically by name. (Do not use library sort routine) <br>


Task 2. Classes version. Create a second version of the Hotel program using an array of Room objects. Create a class  <br>
        called Hotel and another class called Room. The program should function as in Task 1. <br>


Task 3. Extend your programs from Task 1 and Task2. Modify both programs so that each room can now hold the following <br>
        additional information. (Hint: you will need a Person class for the class version) <br>
                a. The number of guests in a room. <br>
                b. Additional information for the paying guest. <br>
                i. First Name. <br>
                ii. Surname. <br>
                iii. Credit Card number. <br>
(This task will familiarize you with what we mean by “maintainability” of a program. If you don’t use classes, you will <br>
need to use parallel arrays! While you are doing this task think about which of the programs was easier to extend and why) <br>

Task 4. Queue version. Add a waiting list to your Hotel class version. Modify your ‘A: Add’ and ‘D: Delete’ as follows: <br>
                When you press ‘A’ to add a new customer, if the hotel is full, the customer should be added to a Waiting List (a queue). <br>
                When you press ‘D’ to delete a customer from a room, the next customer in the waiting queue should be automatically placed in the room. <br>
                Extra marks will be awarded if you implement the waiting list as a circular queue. <br>
                

