/**
 * This class is the Request that used to request a booking from players
 *
 * @author Youssef Mohamed, Mahmoud Gamal
 * @version 1.0
 * @since 6 June 2021
 */

public class Request {
    private Playground requestedPG;
    static int id = 0;
    private boolean accepted = false;

    /**
     * Used to request a booking for a playground
     *
     * @param playground is the playground which is requested
     */
    public Request(Playground playground) {
        requestedPG = playground;
        requestedPG.getOwner().addRequest(this);
        id++;
    }

    /**
     * set accepted to true
     */
    public void accept() {
        accepted = true;
    }

    /**
     * set accepted to false
     */
    public void decline() {
        accepted = false;
    }

    /**
     * @return id is the id of this request
     */
    public int getId() {
        return id;
    }


    /**
     * @param accepted is the value which will be assigned to the request status
     */
    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    /**
     * @return to get the player check the status of the request
     */
    public boolean isAccepted() {
        return accepted;
    }

}
