/**
 * This class is the Admin that controls the states of the playgrounds
 *
 * @author Youssef Mohamed
 * @version 1.0
 * @since 6 June 2021
 */

public class Admin extends Person {

    /**
     * accept a playground
     *
     * @param name is the name of playground that need the approval
     */
    public void approvePlayground(String name) {
        int n = Database.playgrounds.size();
        for (int i = 0; i < n; i++) {
            if (name == Database.playgrounds.get(i).getName()) {
                Database.playgrounds.get(i).setStatus("activated");
            }
        }
    }

    /**
     * suspend a playground
     *
     * @param name is the name of playground that is suspended
     */
    public void suspend(String name) {
        int n = Database.playgrounds.size();
        for (int i = 0; i < n; i++) {
            if (name == Database.playgrounds.get(i).getName()) {
                Database.playgrounds.get(i).setStatus("suspended");
            }
        }
    }

    /**
     * reactivate a playground
     *
     * @param name is the name of playground that need to be reactivate
     */
    public void reactivate(String name) {
        int n = Database.playgrounds.size();
        for (int i = 0; i < n; i++) {
            if (name == Database.playgrounds.get(i).getName()) {
                Database.playgrounds.get(i).setStatus("reactivate");
            }
        }
    }

    /**
     * delete a playground
     *
     * @param name is the name of playground that is delete
     */
    public void delete(String name) {
        int n = Database.playgrounds.size();
        for (int i = 0; i < n; i++) {
            if (name == Database.playgrounds.get(i).getName()) {
                Database.playgrounds.remove(Database.playgrounds.get(i));
            }
        }
    }

    /**
     * display a playground
     *
     * @param name is the name of playground that is displayed
     */
    public void display(String name) {
        int n = Database.playgrounds.size();
        for (int i = 0; i < n; i++) {
            if (name == Database.playgrounds.get(i).getName()) {
                System.out.println(Database.playgrounds.get(i));
            }
        }
    }

    /**
     * display all playgrounds
     */
    public void display() {
        int n = Database.playgrounds.size();
        for (int i = 0; i < n; i++) {
            System.out.println(Database.playgrounds.get(i));
        }
    }

    /**
     * used to register the Admin
     *
     * @param name     is the name of the admin
     * @param email    is the email of the admin
     * @param password is the password of the admin
     * @param location is the location of the admin
     * @param phone    is the phone of the admin
     */
    public void signUp(String name, String email, String password, String location, String phone) {
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setLocation(location);
        this.setPhone(phone);

    }
}
