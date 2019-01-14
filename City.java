/**
 * Class to create people and buildings in the city
 * @author Madi Binyon
 * @version 1.00, 8 January 2019
 */
public class City {
  /**
   * Array of buildings found in the city
   */
  static Building[] cityBuildings = new Building[] {
                new Building(),
                new Building("Post Office" , "123 N Post"),
                new Building("Grocery Store" , "17 E Garland"),
                new Building("Movie Theatre" , "1000 N Chill"),
                new Building("Election Office" , "422 N Justice"),
        };
  /**
   * Array of the city's population.  This includes different people at different locations
   */
        static Person[] population =  new Person[] {
                new Police(),
                new Police("Maria", "45", "930-5744", Police.PoliceRole.Sargent, "City Hall"),
                new Police("Martin", "30", "760-5614", Police.PoliceRole.Chief, "City Hall"),
                new Police("Gloria", "25", "942-5511", Police.PoliceRole.Captain, "City Hall"),
                new Police("Luke", "19", "529-1075", Police.PoliceRole.Patrol, "City Hall"),
                new Kid("Jack", "6", "111-1111", "Snickers", "School"),
                new Kid("Lucy", "7", "111-1112", "Sour Patch Kids", "School"),
                new Kid("Ben", "6", "111-1113", "Licorice", "School"),
                new Teacher("Mrs. Jones", "24", "111-1113", "1st grade", "Master's", "School"),
                new Teacher("Mr. Ross", "50", "111-1114", "2nd grade", "Bachelor's", "School")
        };


    }
