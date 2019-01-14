/**
 * Extends from building to create a school in the city, array found in City.java as discussed
 * @author Madi Binyon
 * @version 1.00, 8 January 2019
 */
public class School extends Building {

    School() {
        super();
    }

    /**
     * Set name and address of school
     * @param n Name of specific school
     * @param a Address of school
     */
    School(String n, String a)
    {
        super(n, a);
    }
}
