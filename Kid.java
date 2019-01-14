/**
 * This class extends from Person and models kids in the city
 * @author Madi Binyon
 * @version 1.00, 8 January 2019
 */
public class Kid extends Person {
    private String favCandy;
    private String location;
    Kid() {
        super();
        favCandy = "Bottlecaps";
        location = "School";
    }

    /**
     * Initialize the properties of the child being created
     * @param na Child's name
     * @param ag Child's age
     * @param pn Child's phone number
     * @param fc Child's favorite candy
     * @param l Child's location
     */
    Kid(String na, String ag, String pn, String fc, String l) {
        super(na, ag, pn);
        favCandy = fc;
        location = l;
    }

    /**
     * @param fc Sets child's favorite candy
     */
    public void setFavCandy(String fc) {
        favCandy = fc;
    }

    /**
     * @return Child's favorite candy
     */
    public String getFavCandy() { return favCandy; }

    /**
     * Overload of toString() method in order to display relevant info about the child
     * @return Child's name, age, favorite candy, and location
     */
    public String toString() {
        return name + " is a " + age + " year old who loves " + favCandy + " and is at " + location;
    }

    /**
     * Set location of child
     * @param l Location of child
     */
    public void setLocation(String l) {
        location = l;
    }

    /**
     * @return Child's location
     */
    public String getLocation() {
        return location;
    }
}
