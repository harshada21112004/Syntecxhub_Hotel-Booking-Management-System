import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Hotel hotel = new Hotel();

        while (true) {

            System.out.println("\n===== HOTEL BOOKING SYSTEM =====");

            System.out.println("1. View Rooms");

            System.out.println("2. Search Room");

            System.out.println("3.Book Room");

            System.out.println("4.View Booking");

            System.out.println("5.Cancel Booking");

            System.out.println("6.View Statistics");

            System.out.println("7. Exit");

            try {

                System.out.print("Enter Choice : ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:

                        hotel.displayRooms();

                        break;

                    case 2:

                        System.out.print("Enter Room Number : ");

                        int roomNumber = sc.nextInt();

                        Room room = hotel.searchRoom(roomNumber);

                        if (room != null) {

                            System.out.println("Room Found");
                            System.out.println("Type : " + room.getRoomType());
                            System.out.println("Price : " + room.getPrice());
                            System.out.println("Status : " +
                                    (room.isBooked() ? "Booked" : "Available"));

                        } else {

                            System.out.println("Room Not Found");

                        }

                        break;

                    case 3:

                        System.out.print("Enter Room Number : ");

                        roomNumber = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter Customer Name : ");

                        String customer = sc.nextLine();

                        hotel.bookRoom(roomNumber, customer);

                        break;

                    case 4:

                        hotel.viewBookings();

                        break;

                    case 5:

                        System.out.print("Enter Room Number : ");

                        int cancelRoom = sc.nextInt();

                        hotel.cancelBooking(cancelRoom);

                        break;

                    case 6:

                        hotel.showStatistics();

                        break;

                    case 7:

                        System.out.println("Thank You!");

                        sc.close();

                        return;

                    default:

                        System.out.println("Invalid Choice");

                }

            } catch (InputMismatchException e) {

                System.out.println("Please enter numbers only.");

                sc.nextLine(); // Clear invalid input

            }

        }

    }

}