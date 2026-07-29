public class Room {
    private int roomNumber;
    private String roomType;
    private double price;
    private boolean booked;
    private String customerName;

    public Room(int roomNumber,String roomType, double price)
    {
        this.roomNumber=roomNumber;
        this.roomType=roomType;
        this.price=price;
        this.booked=false;
        this.customerName=" ";
    }

    public int getRoomNumber()
    {
        return roomNumber;
    }

    public String getRoomType()
    {
        return roomType;
    }

    public double getPrice()
    {
        return price;
    }

    public boolean isBooked()
    {
        return booked;
    }
    
    public String getCustomerName()
    {
        return customerName;
    }

    public void setBooked(boolean booked)
    {
        this.booked=booked;
    }

    public void setCustomerName(String customerName)
    {
        this.customerName=customerName;
    }
}