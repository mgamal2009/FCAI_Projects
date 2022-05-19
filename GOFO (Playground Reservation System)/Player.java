import java.time.LocalTime;
import java.util.*;

/**
 * This class is the playground that players will book
 *
 * @author Mahmoud Gamal , Mohammad Alameen
 * @version 1.0
 * @since 7 June 2021
 */

public class Player extends Person {
    private Playground selectedPG = new Playground();
    private ArrayList<Player> friend = new ArrayList<Player>();
    private ArrayList<Player> favTeam = new ArrayList<Player>();
    private ArrayList<Request> requests = new ArrayList<Request>();


    /**
     * is a default constructor of player class
     */
    public Player(){
        this.setName("");
        this.setID("");
        this.setPassword("");
        this.setEmail("");
        this.setPhone("");
        this.setLocation("");
        eWallet wallet = new eWallet();
        this.setWallet(wallet);
        Database.players.add(this);
    }

    /**
     * is a parametrized constructor of player class
     *
     * @param name     is the name of the player
     * @param ID       is the id of the player
     * @param email    is the email of the player
     * @param password is the password of the player
     * @param location is the location of the player
     * @param phone    is the phone of the player
     * @param wallet   is the wallet of the player
     */
    public void signUp(String name, String ID, String email, String password, String location, String phone, eWallet wallet) {
        this.setName(name);
        this.setID(ID);
        this.setPassword(password);
        this.setEmail(email);
        this.setPhone(phone);
        this.setLocation(location);
        this.setWallet(wallet);
        Database.players.add(this);
    }

    /**
     * adds a player to the list of friends
     *
     * @param id is the id of the selected player to be added
     */
    public void addFriend(String id) {
        int n = Database.players.size();
        for (int i = 0; i < n; i++) {
            if (Database.players.get(i).getID().equalsIgnoreCase(id)) {
                friend.add(Database.players.get(i));
                break;
            }
        }
    }

    /**
     * adds a player to the list of team
     *
     * @param id is the id of the selected player to be added
     */
    public void addFavTeam(String id) {
        int n = Database.players.size();
        for (int i = 0; i < n; i++) {
            if (Database.players.get(i).getID().equalsIgnoreCase(id)) {
                favTeam.add(Database.players.get(i));
                break;
            }
        }
    }

    /**
     * adds a request to the list of requests
     *
     * @param myRequest is the request sent to book a playground
     */
    public void addRequest(Request myRequest) {
        requests.add(myRequest);
    }

    /**
     * @return the friends of the player
     */
    public ArrayList<Player> getFriend() {
        return friend;
    }

    /**
     * @return the favourite team of the player
     */
    public ArrayList<Player> getFavTeam() {
        return favTeam;
    }

    /**
     * @return the request of the player
     */
    public ArrayList<Request> getRequests() {
        return requests;
    }

    /**
     * @return the selected playground to book
     */
    public Playground getSelectedPG() {
        return selectedPG;
    }

    /**
     * Assigns the selected playground to book
     *
     * @param selectedPG
     */
    public void setSelectedPG(Playground selectedPG) {
        this.selectedPG = selectedPG;
    }

    /**
     * @return all the playgrounds saved in the database
     */
    public ArrayList<Playground> displayAll() {
        return Database.playgrounds;
    }

    /**
     * @return an arraylist that contains the playgrounds near to the player
     */
    public ArrayList<Playground> displayNearToMe() {
        ArrayList<Playground> temp = new ArrayList<Playground>();
        int n = Database.playgrounds.size();
        for (int i = 0; i < n; i++) {
            if (this.getLocation() == Database.playgrounds.get(i).getLocation()) {
                temp.add(Database.playgrounds.get(i));
            }
        }
        return temp;
    }

    /**
     * makes sure that the selected time slots are available in the playground
     *
     * @param start      is the start of the time slots the player wants to book
     * @param numOfHours is the number of hours the player wants to book
     */
    public void checkAvailableTimeSLots(int start, int numOfHours) {
        for (int i = 0; i < numOfHours; i++) {
            if (!selectedPG.getTimeSlot().contains(LocalTime.of(start, 0))) {
                System.out.println("Selected Time slot is not available");
                return;
            }
            start++;
        }
        System.out.println("Selected Time slot is available");
    }

    /**
     * @param loc is the location of the playgrounds that the players wants to display
     * @return an arraylist of the playground in the location the player chosen
     */
    public ArrayList<Playground> displaySpecificLocation(String loc) {
        ArrayList<Playground> temp = new ArrayList<Playground>();
        int n = Database.playgrounds.size();
        for (int i = 0; i < n; i++) {
            if (loc == Database.playgrounds.get(i).getLocation()) {
                temp.add(Database.playgrounds.get(i));
            }
        }
        return temp;
    }

    /**
     * @return an arraylist of the playgrounds sorted by total available hours
     */
    public ArrayList<Playground> filterByHours() {
        ArrayList<Playground> temp = new ArrayList<Playground>();
        temp = Database.playgrounds;
        Collections.sort(temp);
        return temp;
    }

    /**
     * sends an invite to the player's favourite team
     */
    public void invite() {
        System.out.println("Invitation sent");
    }

    /**
     * books the playground and transfer the money to the owner
     *
     * @param p          is the playground that the player want to book
     * @param start      is the start hour of the reservation
     * @param numOfHours is the length of the reservation
     */
    public void booking(Playground p, int start, int numOfHours) {
        this.getWallet().transfer(selectedPG.getPrice() * numOfHours, this, selectedPG.getOwner());
        for (int i = 0; i < numOfHours; i++) {
            selectedPG.getTimeSlot().remove(LocalTime.of(start, 0));
            start++;
        }
        int tep = selectedPG.getTotalAvailableHoursToBook() - numOfHours;
        selectedPG.setTotalAvailableHoursToBook(tep);
        int n = Database.playgrounds.size();
        for (int i = 0; i < n; i++) {
            if (Database.playgrounds.get(i).getName() == selectedPG.getName()) {
                Database.playgrounds.get(i).setTimeSlot(selectedPG.getTimeSlot());
                Database.playgrounds.get(i).setTotalAvailableHoursToBook(selectedPG.getTotalAvailableHoursToBook());
            }
        }
        Request myRequest = new Request(selectedPG);
    }

    /**
     * @param name is the name of the playground that the players wants to choose
     * @return the playground the player wanted to choose
     */
    public Playground selectPlayGround(String name) {
        int n = Database.playgrounds.size();
        for (int i = 0; i < n; i++) {
            if (Database.playgrounds.get(i).getName() == name) {
                selectedPG = Database.playgrounds.get(i);
                return selectedPG;
            }
        }
        return null;
    }
}
