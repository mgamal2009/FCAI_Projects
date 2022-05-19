import java.time.LocalTime;
import java.util.ArrayList;

/**
 * This class is the playground that players will book
 *
 * @author Mohammad Alameen, Mahmoud Gamal
 * @version 1.0
 * @since 6 June 2021
 */


public class Playground implements Comparable<Playground> {
    private String name;
    private String location;
    private String size;
    private int price;
    private float cancellationPeriod;
    private int totalAvailableHoursToBook;
    private String status;
    private Owner owner;
    private ArrayList<LocalTime> timeSlot = new ArrayList<>();
    private int startTime;
    private int endTime;

    /**
     * default constructor for the Playground class
     */
    public Playground() {
        this.name = "";
        this.location = "";
        this.size = "";
        this.price = 0;
        this.cancellationPeriod = 0.0f;
        this.totalAvailableHoursToBook = 0;
        this.status = "";
        this.owner = new Owner();
        this.startTime = 0;
        this.endTime = 0;
    }

    /**
     * is the parametrized constructor of the Playground class
     */
    public Playground(String name, String location, String size, int price, float cancellationPeriod, int totalAvailableHoursToBook, Owner owner, int start) {
        this.name = name;
        this.location = location;
        this.size = size;
        this.price = price;
        this.cancellationPeriod = cancellationPeriod;
        this.totalAvailableHoursToBook = totalAvailableHoursToBook;
        this.status = "pending";
        this.owner = owner;
        this.startTime = start;
        int end = startTime + totalAvailableHoursToBook;
        if (end >= 24) {
            end -= 24;
        }
        this.endTime = end;
        if (end < start) {
            int i = start;
            while (i != end) {
                if (i >= 24) {
                    i = i - 24;
                }
                timeSlot.add(LocalTime.of(i, 0));
                i++;
                if (i >= 24) {
                    i = i - 24;
                }
            }
        } else if (end == start) {
            int i = 0;
            while (i < 24) {
                if (start >= 24) {
                    start = start - 24;
                }
                timeSlot.add(LocalTime.of(start, 0));
                start++;
                i++;
            }
        } else {
            for (int i = start; i < end; i++) {
                timeSlot.add(LocalTime.of(i, 0));
            }
        }
        Database.playgrounds.add(this);
    }

    /**
     * @return the name of the playground
     */
    public String getName() {
        return name;
    }

    /**
     * @return the location of the playground
     */
    public String getLocation() {
        return location;
    }

    /**
     * @return the size of the playground
     */
    public String getSize() {
        return size;
    }

    /**
     * @return the pricing of the playground
     */
    public int getPrice() {
        return price;
    }

    /**
     * @return the cancellation period of the playground
     */
    public float getCancellationPeriod() {
        return cancellationPeriod;
    }

    /**
     * @return the total available hours the playground can be booked
     */
    public int getTotalAvailableHoursToBook() {
        return totalAvailableHoursToBook;
    }

    /**
     * status could be: active, suspended
     *
     * @return the status of the playground
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the owner of the playground
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * @return the start time of the playground
     */
    public int getStartTime() {
        return startTime;
    }

    /**
     * @return the end time of the playground
     */
    public int getEndTime() {
        return endTime;
    }

    /**
     * @return the timeslot of the playground
     */
    public ArrayList<LocalTime> getTimeSlot() {
        return timeSlot;
    }

    /**
     * Assigns the name of the playground to name
     *
     * @param name is the name of the playground
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Assigns the location of the playground to location
     *
     * @param location is the location of the playground
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Assigns the size of the playground to size
     *
     * @param size is the size of the playground
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Assigns the price of the playground to price
     *
     * @param price is the price of the playground
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Assigns  the totalAvailableHoursToBook of the playground to totalAvailableHoursToBook
     *
     * @param totalAvailableHoursToBook is the total hours available that can be booked
     */
    public void setTotalAvailableHoursToBook(int totalAvailableHoursToBook) {
        this.totalAvailableHoursToBook = totalAvailableHoursToBook;
    }

    /**
     * Assigns the cancellationPeriod of the playground to cancellationPeriod
     *
     * @param cancellationPeriod is the cancellation period of the playground
     */
    public void setCancellationPeriod(float cancellationPeriod) {
        this.cancellationPeriod = cancellationPeriod;
    }

    /**
     * Assigns the status of the playground to status
     *
     * @param status is the statues of the playground
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Assign the start time of the playground to startTime
     *
     * @param startTime is the start time of the playground
     */
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    /**
     * Assign the end time of the playground to endTime
     *
     * @param endTime is the end time of the playground
     */
    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    /**
     * Assigns the owner of the playground to owner
     *
     * @param //owner is the owner of the playground
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    /**
     * Assigns the time slot of playground to timeslot
     *
     * @param timeSlot is the timeslot of the playground
     */
    public void setTimeSlot(ArrayList<LocalTime> timeSlot) {
        this.timeSlot = timeSlot;
    }

    /**
     * sorts the playgrounds
     *
     * @param comparesTo
     * @return the sorted playgrounds
     */
    public int compareTo(Playground comparesTo) {
        int compareTotalAvailableHoursToBook = ((Playground) comparesTo).getTotalAvailableHoursToBook();
        return compareTotalAvailableHoursToBook - this.getTotalAvailableHoursToBook();
    }

    /**
     * displays the information of the playground
     *
     * @Override
     */
    public String toString() {
        return "Playground{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", cancellationPeriod=" + cancellationPeriod +
                ", totalAvailableHoursToBook=" + totalAvailableHoursToBook +
                ", status='" + status + '\'' +
                ", owner=" + owner.getName() + '\n' +
                ", timeSlot=" + timeSlot + '\n' +
                ", startTime=" + LocalTime.of(startTime, 0) +
                ", endTime=" + LocalTime.of(endTime, 0) +
                '}' + '\n' + "=======================================" + '\n';
    }
}
