package ca.guest.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class GuestList {
    public static void main(String[] args) {
        List <Guest> guestList = new ArrayList<Guest>(); //Dynamic Guest List
        int id; //used to store guest id value. (used in guest ID search)
        String name; //used to store guest name. (used in name search)
        int choice = -1;
        /*Creating two scanner variables to avoid confusion that may occur
         by storing multiple values in a single variable.
         */
        Scanner sc = new Scanner(System.in);
        Scanner input = new Scanner (System.in);
        while (choice!=0){
            printInteractiveMenu();
            System.out.print("Please Enter the Relevant Key:");
            choice=Integer.parseInt(sc.next());
            switch (choice){
                case 0 : {
                    System.out.println("Exiting Program......\nGoodBye!");
                } break;
                case 1:{
                    Scanner s = new Scanner(System.in); //Workaround to fix the name entry bug
                    System.out.println("Please Enter Guest Name: ");
                    String guestName = s.next();
                    try {
                        if (guestName.length()<=3)
                            throw new InvalidGuestName ("Name must be at least four Characters");
                    }
                    catch (InvalidGuestName n) {
                        System.out.println(n.getMessage());
                    }
                    System.out.println("Please Enter Guest Phone Number: ");
                    Long phoneNumber = input.nextLong();
                    try {
                        if (phoneNumber.toString().length()<10)
                            throw  new InvalidGuestPhoneNumber("Phone Number Must Be At Lest 10 Digits");
                        } catch (InvalidGuestPhoneNumber g) {
                        System.out.println(g.getMessage());
                    }
                    System.out.println("Please Enter Guest's Age");
                    int guestAge = input.nextInt();
                    try {
                        if (guestAge < 18)
                            throw new InvalidGuestAge("Guest must be at least 18 years old!");
                    } catch (InvalidGuestAge a){
                        System.out.println(a.getMessage());
                    }
                    guestList.add(new Guest (guestName,phoneNumber,guestAge)); //Adds new guest
                } break;
                case 2:{
                    System.out.print("Please Enter Guest ID: ");
                    id=input.nextInt();
                    for (Guest g: guestList) {
                        if(g.getGuestId()==id){
                            System.out.println("Guest Found!");
                            System.out.println(g.toString());
                            System.out.println("=====================");
                    }
                        else {
                            System.out.println("Entry Not Found.....");
                        }
                    }
                } break;
                case 3:{
                    System.out.print("Please Enter Guest Name: ");
                    name=input.next();
                    for (Guest g: guestList) {
                        if (g.getGuestName().equals(name)) {
                            System.out.println("Guest Found!");
                            System.out.println(g.toString());
                            System.out.println("======================");
                        }
                        else {
                            System.out.println("Guest Not Found...");
                        }
                    }
                } break;
                case 4: {
                    System.out.println("Please Enter Guest ID: ");
                    id = input.nextInt();
                    guestList.remove(id-1); //id-1 represents the index number.
                    System.out.println("Guest Removed Successfully");
                } break;
                case 5:{
                    System.out.println("Printing Guest List.....");
                    Iterator<Guest> iterator = guestList.iterator();
                    while (iterator.hasNext()){
                        System.out.println(iterator.next());
                    }
                    System.out.println("Done!");
                }
            }
        }
    }

    /**
     * Calling this method will create a Guest List Interactive Menu.
     */
    private static void printInteractiveMenu() {
        System.out.println("====== Guest List Menu ======");
        System.out.println("Press 1 --> Add New Guest\nPress 2 --> Print Guest by ID " +
                "\nPress 3 --> Search Guest By Name\nPress 4: Remove Guest By ID\nPress 5: Print List\n" +
                "Press 0 -->Exit");
        System.out.println("==============================\n");
    }
}
