import java.util.ArrayList;

public class Hotel {

    private ArrayList<Room> rooms;
    private ArrayList<Booking> bookings;
    private int bookingCounter;

    public Hotel() {

        rooms = new ArrayList<>();
        bookings = new ArrayList<>();

        bookingCounter = 1;

        addRooms();

    }

    private void addRooms() {

        rooms.add(new Room(101, "Standard", 1000));

        rooms.add(new Room(102, "Standard", 1000));

        rooms.add(new Room(103, "Deluxe", 2000));

        rooms.add(new Room(104, "Deluxe", 2000));

        rooms.add(new Room(105, "Suite", 3500));

    }

    public void displayRooms() {

        System.out.println("\n==========================================================");
        System.out.printf("%-10s %-12s %-10s %-12s %-15s%n",
                "Room No", "Type", "Price", "Status", "Customer");
        System.out.println("==========================================================");

        for (Room room : rooms) {

            System.out.printf("%-10d %-12s %-10.2f %-12s %-15s%n",
                    room.getRoomNumber(),
                    room.getRoomType(),
                    room.getPrice(),
                    room.isBooked() ? "Booked" : "Available",
                    room.isBooked() ? room.getCustomerName() : "-");

        }

    }

    

    public Room searchRoom(int roomNumber) {

        for (Room room : rooms) {

            if (room.getRoomNumber() == roomNumber) {

                return room;

            }

        }

        return null;

    }

    public void bookRoom(int roomNumber, String customerName) {

        Room room = searchRoom(roomNumber);

        if (room == null) {

            System.out.println("Room not found.");
            return;

        }

        if (customerName == null || customerName.trim().isEmpty()) {
            System.out.println("Customer name cannot be empty.");
            return;
        }

        if (room.isBooked()) {

            System.out.println("Room is already booked.");
            return;

        }

        room.setBooked(true);
        room.setCustomerName(customerName);

        Booking booking = new Booking(
                bookingCounter++,
                customerName,
                roomNumber);

        bookings.add(booking);

        System.out.println("Room booked successfully!");

    }

    public void viewBookings() {

        if (bookings.isEmpty()) {

            System.out.println("No bookings found.");

            return;

        }

        System.out.println("\n----- BOOKINGS -----");

        for (Booking booking : bookings) {

            System.out.println(
                    "Booking ID : " + booking.getBookingId());

            System.out.println(
                    "Customer : " + booking.getCustomerName());

            System.out.println(
                    "Room : " + booking.getRoomNumber());

            System.out.println();

        }

    }

    public void cancelBooking(int roomNumber) {

        Room room = searchRoom(roomNumber);

        if (room == null) {
            System.out.println("Room not found.");
            return;
        }

        if (!room.isBooked()) {
            System.out.println("Room is not booked.");
            return;
        }

        // Remove booking from booking list
        for (int i = 0; i < bookings.size(); i++) {

            if (bookings.get(i).getRoomNumber() == roomNumber) {
                bookings.remove(i);
                break;
            }

        }

        // Reset room details
        room.setBooked(false);
        room.setCustomerName("");

        System.out.println("Booking cancelled successfully.");
    }

    public void showStatistics() {

        int available = 0;
        int booked = 0;

        for (Room room : rooms) {

            if (room.isBooked()) {
                booked++;
            } else {
                available++;
            }

        }

        System.out.println("\n===== HOTEL STATISTICS =====");
        System.out.println("Total Rooms      : " + rooms.size());
        System.out.println("Available Rooms  : " + available);
        System.out.println("Booked Rooms     : " + booked);
    }
}