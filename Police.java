import java.util.Scanner;

/**
 * This class extends from Person and models police in the city
 * @author Madi Binyon
 * @version 1.00, 8 January 2019
 */
public class Police extends Person implements Employee {
    private int pay = 0;
    private int ID;
    private String location;
    public enum PoliceRole {Patrol, Sargent, Captain, Chief}
    private PoliceRole _policerole;
    Police() {
        super();
        location = "City Hall";
        _policerole = PoliceRole.Patrol;

    }

    /**
     * Initializes qualities of police officer
     * @param na Officer's name
     * @param ag Officer's age
     * @param pn Officer's phone number
     * @param pr Officer's role
     * @param l Location of officer
     */
    Police(String na, String ag, String pn, PoliceRole pr, String l) {
        super(na, ag, pn);
        _policerole = pr;
        location = l;
    }

    /**
     * Police includes methods from Employee.java
     * @param p Pay being given to officer
     * @return Total officer has been paid
     */
    public int givePay(int p) {
        pay += p;
        return pay;
    }

    /**
     * Police includes methods from Employee.java; officers have an ID
     * @return ID entered for officer
     */
    public int getID() {

        System.out.print("What is " + name + "'s employee ID?");
        Scanner scnr = new Scanner(System.in);
        ID = scnr.nextInt();
        return ID;
    }

    /**
     * Set role for officer
     * @param p Role from enum of specified officer
     */
    public void setPoliceRole(PoliceRole p) {
        _policerole = p;
    }

    /**
     * @return Officer's role
     */
    public PoliceRole getPoliceRole() {
        return _policerole;
    }
    /**
     * Overload of toString() method in order to display relevant info about the officer
     * @return Officer's name, role, and location
     */
    public String toString() {
        return name + " is a " + _policerole + " who is at " + location ;
    }

    /**
     * Set location of officer
     * @param l Location of officer
     */
    public void setLocation(String l) {
        location = l;
    }

    /**
     * @return Location of officer
     */
    public String getLocation() {
         return location;
    }

    /**
     * @return Total pay for specified officer
     */
    public int getPay() {
        System.out.println(name + " was paid $" + pay  + " today.");
        return pay;
    }
}
