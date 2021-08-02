public class Person {
    private int guestNum;
    private String firstName;
    private String surName;
    private int creditNum;

    // default constructor
    public Person() {
    }

    public Person(int gNum, String fName, String sName, int cNum) {
        this.guestNum = gNum;
        this.firstName = fName;
        this.surName = sName;
        this.creditNum = cNum;
    }

    // Set Methods
    public void setFirstName(String fname ) {
        this.firstName = fname;
    }

    public void setSurName(String sname) {
        this.surName = sname;
    }

    public void setGuestNum(int num) {
        this.guestNum = num;
    }

    public void setCreditNum(int num) {
        this.creditNum = num;
    }


    // Get Methods
    public String getFirstName() {
        return this.firstName;
    }

    public String getSurName() {
        return this.surName;
    }

    public int getGuestNum() {
        return this.guestNum;
    }

    public int getCreditNum() {
        return this.creditNum;
    }

}
