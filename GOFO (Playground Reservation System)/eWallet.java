/**
 * This class is the eWallet that the player and Owner use to Transfer money and check balance
 *
 * @author Mohammad Alameen
 * @version 1.0
 * @since 6 June 2021
 */

public class eWallet {
    private int balance;

    /**
     * default constructor of the eWallet class
     */
    public eWallet() {
        this.balance = 0;
    }

    /**
     * parametrized constructor of the eWallet class
     */
    public eWallet(int balance) {
        this.balance = balance;
    }

    /**
     * @return the balance of the eWallet
     */
    public int checkBalance() {
        return balance;
    }

    /**
     * Assigns the balance of eWallet to balance
     *
     * @param balance is the balance of the eWallet
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * This function amt to the eWallet of the Owner whose ID matches ID
     *
     * @param amt    is the amount to be transferred
     * @param player is the player who send the money
     * @param owner  is the playground owner who will receive the money
     */
    public void transfer(int amt, Player player, Owner owner) {
        //Person p = new Person();

        if (player.getWallet().balance < amt) {
            throw new ArithmeticException("Not enough balance");
        } else {
            owner.getWallet().balance += amt;
            player.getWallet().balance -= amt;
        }

    }

    /**
     * displays the information of the eWallet
     *
     * @Override
     */
    public String toString() {
        return "eWallet{" +
                "balance=" + balance +
                '}';
    }
}
