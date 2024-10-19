package round__3;

import java.util.*;

class Taxi {
    private static int taxiCounter = 1;

    private int taxiId;
    private char currentLocation;
    private double earnings;

    public Taxi(char location) {
        taxiId = taxiCounter++;
        currentLocation = location;
        earnings = 0;
    }

    public int getTaxiId() {
        return taxiId;
    }

    public char getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(char location) {
        currentLocation = location;
    }

    public double getEarnings() {
        return earnings;
    }

    public void addEarnings(double amount) {
        earnings += amount;
    }
}

class Booking {
    private static int bookingCounter = 1;

    private int bookingId;
    private int customerId;
    private char pickupPoint;
    private char dropPoint;
    private int pickupTime;
    private int dropTime;
    private double amount;

    public Booking(int custId, char pickup, char drop, int pickupT, int dropT, double amt) {
        bookingId = bookingCounter++;
        customerId = custId;
        pickupPoint = pickup;
        dropPoint = drop;
        pickupTime = pickupT;
        dropTime = dropT;
        amount = amt;
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public char getPickupPoint() {
        return pickupPoint;
    }

    public char getDropPoint() {
        return dropPoint;
    }

    public int getPickupTime() {
        return pickupTime;
    }

    public int getDropTime() {
        return dropTime;
    }

    public double getAmount() {
        return amount;
    }
}

class CallTaxiBookingApp {
    private static final int NUM_TAXIS = 4;
    private static final int DISTANCE = 15;
    private static final int MINIMUM_DISTANCE = 5;
    private static final double MINIMUM_FARE = 100;
    private static final double ADDITIONAL_FARE = 10;

    private List<Taxi> taxis;
    private List<Booking> bookings;

    public CallTaxiBookingApp() {
        taxis = new ArrayList<>();
        bookings = new ArrayList<>();
        initializeTaxis(); 
    }

    private void initializeTaxis() {
        for (int i = 0; i < NUM_TAXIS; i++) {
            taxis.add(new Taxi('A'));
        }
    }

    public void bookTaxi(int custId, char pickup, char drop, int pickupTime) {
        Taxi taxi = findAvailableTaxi(pickup, pickupTime);
        if (taxi != null) {
            int distance = Math.abs(pickup - drop) * DISTANCE;
            double fare = calculateFare(distance);
            int dropTime = pickupTime + distance / DISTANCE;
            taxi.setCurrentLocation(drop);
            taxi.addEarnings(fare);
            bookings.add(new Booking(custId, pickup, drop, pickupTime, dropTime, fare));
            System.out.println("Taxi can be allotted.");
            System.out.println("Taxi-" + taxi.getTaxiId() + " is allotted");
        } else {
            System.out.println("No taxi available at the moment.");
        }
    }

    private Taxi findAvailableTaxi(char pickup, int pickupTime) {
        Taxi availableTaxi = null;
        int minDistance = Integer.MAX_VALUE;

        for (Taxi taxi : taxis) {
            if (taxi.getCurrentLocation() == pickup) {
                return taxi;
            }
            int distance = Math.abs(taxi.getCurrentLocation() - pickup) * DISTANCE;
            if (distance < minDistance && pickupTime + distance / DISTANCE <= 24) {
                minDistance = distance;
                availableTaxi = taxi;
            }
        }
        return availableTaxi;
    }

    private double calculateFare(int distance) {
        if (distance <= MINIMUM_DISTANCE) {
            return MINIMUM_FARE;
        } else {
            return MINIMUM_FARE + (distance - MINIMUM_DISTANCE) * ADDITIONAL_FARE;
        }
    }

    public void displayTaxiDetails() {
        System.out.println("Taxi No:    Total Earnings:");
        for (Taxi taxi : taxis) {
            System.out.println("Taxi-" + taxi.getTaxiId() + "    Total Earnings: Rs. " + taxi.getEarnings());
            for (Booking booking : bookings) {
               // if (booking.getCustomerId() == taxi.getTaxiId()) {
                	if(true) {
                    System.out.println(booking.getBookingId() + "    " + booking.getCustomerId() + "    " +
                            booking.getPickupPoint() + "    " + booking.getDropPoint() + "    " +
                            booking.getPickupTime() + "    " + booking.getDropTime() + "    " +
                            booking.getAmount());
                }
            }
            
        }
    }
}

public class TaxiMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CallTaxiBookingApp app = new CallTaxiBookingApp();

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Book a taxi");
            System.out.println("2. Display taxi details");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
          //  scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    int customerId = scanner.nextInt();
                   scanner.nextLine(); // Consume the newline
                    System.out.print("Enter Pickup Point (A-F): ");
                    char pickupPoint = scanner.nextLine().charAt(0);
                    System.out.print("Enter Drop Point (A-F): ");
                    char dropPoint = scanner.nextLine().charAt(0);
                    System.out.print("Enter Pickup Time (24-hour format): ");
                    int pickupTime = scanner.nextInt();
                    app.bookTaxi(customerId, pickupPoint, dropPoint, pickupTime);
                    break;
                case 2:
                    app.displayTaxiDetails();
                    break;
                case 3:
                    System.out.println("Exiting the application.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
