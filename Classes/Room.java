public class Room {
    private String customerName;

	// Default constructor
    public Room() {
        customerName = "Empty";
    }

	// setMethod
    public void setName(String name) {
        this.customerName = name;
    }

	// getMethod
    public String getName()
    {
        return customerName;
    }
}
