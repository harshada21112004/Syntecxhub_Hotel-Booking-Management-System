public class Booking {

    private int bookingId;
    private String customerName;
    private int roomNumber;

    public Booking(int bookingId, String customerName, int roomNumber) {

        this.bookingId = bookingId;
        this.customerName = customerName;
        this.roomNumber = roomNumber;

    }

    public int getBookingId() {
        return bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

}