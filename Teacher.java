import java.util.Scanner;

/**
 * This class extends from Person and models teachers in the city
 * @author Madi Binyon
 * @version 1.00, 8 January 2019
 */
public class Teacher extends Person implements Employee {
    private String gradeLevel;
    private String certification;
    private int pay;
    private int ID;
    private String location;
    public Teacher() {
        super();
        gradeLevel = "kindergarten";
        certification = "AA";
        location = "School";
    }
    /**
     * Initializes qualities of teacher
     * @param na Teacher's name
     * @param ag Teacher's age
     * @param pn Teacher's phone number
     * @param gl Grade level teacher instructs
     * @param c Teacher's certification
     * @param l Taecher's location
     */
    public Teacher(String na, String ag, String pn, String gl, String c, String l) {
        name = na;
        age = ag;
        phoneNum = pn;
        gradeLevel = gl;
        certification = c;
        location = l;
    }

    /**
     * Sets grade level the teacher instructs
     * @param gl Grade level
     */
    public void setGradeLevel(String gl) { gradeLevel = gl; }

    /**
     * Sets teacher's certification level
     * @param c Teacher's certification
     */
    public void setCertification(String c) { certification = c; }

    /**
     * @return Grade level teacher instructs
     */
    public String getGradeLevel() { return gradeLevel; }

    /**
     * @return Certification of teacher
     */
    public String getCertification() { return certification; }

    /**
     * Teacher includes methods from Employee.java
     * @param p Pay being given to teacher
     * @return Total amount teacher has been paid
     */
    public int givePay(int p) {
        pay += p;
        return pay;
    }
    /**
     * Teacher includes methods from Employee.java; teachers have an ID
     * @return ID entered for teacher
     */
    public int getID() {

        System.out.print("What is " + name + "'s employee ID?");
        Scanner scnr = new Scanner(System.in);
        ID = scnr.nextInt();
        return ID;

    }
    /**
     * Overload of toString() method in order to display relevant info about the teacher
     * @return Teacher's name, grade level, certification and location
     */
    public String toString() {
        return name + " is a " + gradeLevel + " teacher with a " + certification + " degree currently at " + location;
    }

    /**
     * Sets location of teacher
     * @param l Location of teacher
     */
    public void setLocation(String l) {
        location = l;
    }

    /**
     * @return Location of teacher
     */
    public String getLocation() {
        return location;
    }

    /**
     * @return Total pay for specified officer
     */
    public int getPay() {
        System.out.println(name + " was paid $" + pay + " today.");
        return pay;
    }
}
