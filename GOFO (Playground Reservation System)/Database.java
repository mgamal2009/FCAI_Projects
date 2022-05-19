import java.util.ArrayList;

/**
 * This class is the database of the program that stores all the data
 *
 * @author Mahmoud Gamal
 * @version 1.0
 * @since 7 June 2021
 */

public class Database {
    static ArrayList<Owner> owners = new ArrayList<Owner>();
    static ArrayList<Playground> playgrounds = new ArrayList<Playground>();
    static ArrayList<Player> players = new ArrayList<Player>();
    static Admin myAdmin = new Admin();
}
