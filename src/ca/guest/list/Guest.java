package ca.guest.list;

public class Guest {
    private static int guestCounter=0;
    private Integer guestId;
    private String guestName;
    private Long phoneNumber;
    private int age;

    public Guest(String guestName, Long phoneNumber, int age) {
        this.guestName = guestName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        guestCounter++; //static variable to be incremented everytime we create an object of guest.
        this.guestId=guestCounter;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public String getGuestName() {
        return guestName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "guestId=" + guestId +
                ", guestName='" + guestName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", age=" + age +
                '}';
    }
}
