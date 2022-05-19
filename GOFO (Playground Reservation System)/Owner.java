import java.util.ArrayList;

/**
 * This class is the Owner that will register their playgrounds
 *
 * @author Youssef Mohamed
 * @version 1.0
 * @since 6 June 2021
 */

public class Owner extends Person {
    private ArrayList<Playground> playgrounds = new ArrayList<Playground>();
    private ArrayList<Request> myRequests = new ArrayList<Request>();

    /**
     * is a default constructor of owner class
     */
    public Owner() {
        this.setName("");
        this.setID("");
        this.setPassword("");
        this.setEmail("");
        this.setPhone("");
        this.setLocation("");
        eWallet wallet = new eWallet();
        this.setWallet(wallet);
        Database.owners.add(this);
    }

    /**
     * is a parametrized constructor of owner class
     *
     * @param name     is the name of the owner
     * @param ID       is the id of the owner
     * @param email    is the email of the owner
     * @param password is the password of the owner
     * @param location is the location of the owner
     * @param phone    is the phone of the owner
     * @param wallet   is the wallet of the owner
     */
    public void signUp(String name, String ID, String email, String password, String location, String phone, eWallet wallet) {
        this.setName(name);
        this.setID(ID);
        this.setPassword(password);
        this.setEmail(email);
        this.setPhone(phone);
        this.setLocation(location);
        this.setWallet(wallet);
        Database.owners.add(this);
    }

    /**
     * used to register the owner's playgrounds
     *
     * @param name               is the name of the playground
     * @param location           is the location of the playground
     * @param size               is the size of the playground
     * @param price              is the price of the playground
     * @param cancellationPeriod is the available time to cancel this booking of the playground
     * @param totalAvailableHoursToBooK            is the total hours free to book per day of the playground
     * @param start              is the open time of the playground
     */
    public void registerPlayground(String name, String location, String size, int price, float cancellationPeriod, int totalAvailableHoursToBooK, int start) {
        Playground myPG = new Playground(name, location, size, price, cancellationPeriod, totalAvailableHoursToBooK, this, start);
    }

    /**
     * Used to edit specific playground
     *
     * @param choice is the selected playground
     * @param name   is the name of the attribute which needs to change
     * @param var    is the value which will be assigned to the attribute
     */
    public void editPlayground(String choice, String name, String var) {
        int n = playgrounds.size();
        for (int i = 0; i < n; i++) {
            if (choice == playgrounds.get(i).getName()) {
                switch (name) {
                    case "name": {
                        playgrounds.get(i).setName(var);
                        break;
                    }
                    case "location": {
                        playgrounds.get(i).setLocation(var);
                        break;
                    }
                    case "size": {
                        playgrounds.get(i).setSize(var);
                        break;
                    }
                    case "price": {
                        int val = Integer.parseInt(var);
                        playgrounds.get(i).setPrice(val);
                        break;
                    }
                    case "totalHR": {
                        int val = Integer.parseInt(var);
                        playgrounds.get(i).setTotalAvailableHoursToBook(val);
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
        }
    }

    /**
     * get all the playgrounds of an owner
     */
    public void getMyPlaygrounds() {
        int n = Database.playgrounds.size();
        for (int i = 0; i < n; i++) {
            if (Database.playgrounds.get(i).getOwner().getName() == this.getName()) {
                playgrounds.add(Database.playgrounds.get(i));
            }
        }
    }

    /**
     * Used to display all playground of an owner
     */
    public void displayPlayGrounds() {
        getMyPlaygrounds();
        int n = playgrounds.size();
        for (int i = 0; i < n; i++) {
            System.out.println(playgrounds.get(i));
        }
    }


    /**
     * used to add the request of a booking
     *
     * @param req is the request that the player added
     */
    public void addRequest(Request req) {
        myRequests.add(req);
    }

    /**
     * used to get all the requests
     *
     * @return is the list of all request for this owner
     */
    public ArrayList<Request> getMyRequests() {
        return myRequests;
    }

    /**
     * used to return specific request
     *
     * @param id is the id of the request to be selected
     * @return is the selected request
     */
    public Request selectRequest(int id) {
        int n = myRequests.size();
        for (int i = 0; i < n; i++) {
            if (id == myRequests.get(i).getId()) {
                return myRequests.get(i);
            } else {
                return null;
            }
        }
        return null;
    }

    /**
     * accept request
     *
     * @param req is the selected request
     */
    public void acceptRequest(Request req) {
        req.accept();
    }

    /**
     * decline request
     *
     * @param req is the selected request
     */
    public void declineRequest(Request req) {
        req.decline();
    }
}
