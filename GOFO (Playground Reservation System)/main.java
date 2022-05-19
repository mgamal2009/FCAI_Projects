import java.util.ArrayList;

/**
 * This is the main that we will use to test our classes
 *
 * @author Mahmoud Gamal , Mohammad Alameen
 * @version 1.0
 * @since 7 June 2021
 */

public class main {
    public static void main(String args[]) {
        /**
         * added some wallets for our users
         */
        eWallet wallet_1 = new eWallet(100);
        eWallet wallet_2 = new eWallet(50);
        eWallet wallet_3 = new eWallet(200);
        eWallet wallet_4 = new eWallet(500);

        /**
         * signed up some owners and a player
         */
        Owner owner_1 = new Owner();
        owner_1.signUp("Ahmed", "1", "ahmed@gmail.com", "1234", "Nasr_City", "0123456789", wallet_1);
        Owner owner_2 = new Owner();
        owner_2.signUp("Gemy", "2", "gemy@gmail.com", "1234", "Giza", "0123456789", wallet_2);
        Owner owner_3 = new Owner();
        owner_3.signUp("Ameen", "3", "Ameen@gmail.com", "1234", "Ramses", "0123456789", wallet_3);
        Player player = new Player();
        player.signUp("Kemper", "4", "co-ed@gmail.com", "1234", "Nasr_City", "0123456789", wallet_4);

        /**
         * registered some playgrounds
         */
        owner_1.registerPlayground("Star_1", "Nasr_City", "200m^2", 80, 24.0f, 11, 9);
        owner_1.registerPlayground("Star_2", "Nasr_City", "300m^2", 100, 24.0f, 24, 9);
        owner_2.registerPlayground("Hero", "Giza", "300m^2", 100, 24.0f, 11, 13);
        owner_3.registerPlayground("Moon", "Ramses", "150m^2", 60, 48.0f, 16, 8);

        /**
         * the player displays all the playgrounds and try to sort or filter them
         */

        System.out.println(player.displayAll());
        System.out.println(player.displayNearToMe());
        System.out.println(player.displaySpecificLocation("Giza"));
        System.out.println(player.filterByHours());

        /**
         * getting the balance of the player and the owner before the booking done
         */

        System.out.println("\n" + player.getWallet().checkBalance());
        System.out.println(owner_2.getWallet().checkBalance() + "\n" );
        /**
         * the player selects the playground and check if it available at this time and book "Hero" playground and transfer the money to the owner
         */
        player.selectPlayGround("Hero");
        player.checkAvailableTimeSLots(14, 4);
        player.booking(player.selectPlayGround("Hero"), 14, 4);

        /**
         * display player and owner balance after booking the playground
         */
        System.out.println("\n" + player.getWallet().checkBalance());
        System.out.println(owner_2.getWallet().checkBalance() + "\n" );

        /**
         * trying to book the same time slots again
         */
        player.selectPlayGround("Hero");
        player.checkAvailableTimeSLots(14, 4);
        /**
         * displays the information of the playground after some one booked some timeslots
         */
        System.out.println("\n");
        owner_2.displayPlayGrounds();

    }
}
