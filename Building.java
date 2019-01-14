/**
 * Class to model buildings in the city
 * @author Madi Binyon
 * @version 1.00, 8 January 2019
 */
public class Building {
    private String name;
    private String address;
    Building() {
        name = "Unnamed building";
        address = "123 N Main St";
    }

    /**
     * Creates a specific building
     * @param n Name of building
     * @param a Building address
     */
    Building(String n, String a)
    {
        name = n;
        address = a;
    }

    /**
     * Set's the name of the building
     * @param n Building name
     */
    public void setName(String n) { name = n; }

    /**
     * Set's the building's address
     * @param a Address of building
     */
    public void setAddress(String a) { address = a; }

    /**
     * @return Address of building
     */
    public String getAddress() { return address; }

    /**
     * @return Name of building
     */
    public String getName() { return name; }

    /**
     * Overload of toString() method in order to display relevant info about the building
     * @return Building's name and address
     */
    public String toString() {
        return "the " + name + " located at " + address;
    }
}
