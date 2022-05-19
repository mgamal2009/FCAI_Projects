/**
 * This class is an abstract class that the user, admin and owner will inherit from
 *
 * @author Mohammad Alameen
 * @version 1.0
 * @since 6 June 2021
 */

public class Person {
    private String name;
    private String ID;
    private String email;
    private String password;
    private String location;
    private String phone;
    private eWallet wallet;

    /**
     * is the parametrized constructor of the Person class
     */
    public Person() {
        this.name = "";
        this.ID = "";
        this.email = "";
        this.password = "";
        this.phone = "";
        this.wallet = new eWallet();
    }

    /**
     * is the parametrized constructor of the Person class
     */
    public Person(String name, String ID, String email, String password, String location, String phone, eWallet wallet) {
        this.name = name;
        this.ID = ID;
        this.email = email;
        this.password = password;
        this.location = location;
        this.phone = phone;
        this.wallet = wallet;
    }

    /**
     * @return the name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * @return the ID of the person
     */
    public String getID() {
        return ID;
    }

    /**
     * @return the email of the person
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the password of the person
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the location of the playground
     */
    public String getLocation() {
        return location;
    }

    /**
     * @return the phone number of the person
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @return the wallet of the person
     */
    public eWallet getWallet() {
        return wallet;
    }

    /**
     * Assigns the name of person to name
     *
     * @param name is the name of the person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Assigns the ID of person to ID
     *
     * @param ID is the ID of the person
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Assigns the email of person to email
     *
     * @param email is the email of the person
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Assigns the password of person to password
     *
     * @param password is the password of the person
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Assigns the location of person to location
     *
     * @param location is the location of the person
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Assigns the phone number of person to phone
     *
     * @param phone is the phone of the person
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Assigns the eWallet of person to wallet
     *
     * @param wallet is the eWallet of the person
     */
    public void setWallet(eWallet wallet) {
        this.wallet = wallet;
    }

    /**
     * Displays the information of the person
     *
     * @Override
     */
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", location='" + location + '\'' +
                ", phone=" + phone +
                '}';
    }

    /**
     * @param email    is the email of the person
     * @param password is the password of the person
     * @return return true if the data is correct
     */
    public boolean signIN(String email, String password) {
        return true;
    }

    /**
     * @return return true if the verify is fine
     */
    public boolean verify() {
        return true;
    }

}
