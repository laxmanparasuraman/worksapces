package round__3;

import java.util.Scanner;

class Passenger {
    private String name;
    private int age;
 
    private String gender;
    private String berthPreference;
    private String ticketStatus;

    public Passenger(String nam, int age, String gender, String berthPreference) {
        this.name = nam;
        this.age = age;
        this.gender = gender;
        this.berthPreference = berthPreference;
        this.ticketStatus = "Waiting";
    }
Passenger lax;


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getBerthPreference() {
        return berthPreference;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}

class Ticket {
    private Passenger passenger;

    public Ticket(Passenger passenger) {
        this.passenger = passenger;
    }

    public Passenger getPassenger() {
        return passenger;
    }
}

class Train {
	protected int totalBerths = 63;
    protected int totalRAC = 18;
    protected int totalWaiting = 10;
    protected Ticket[] confirmedTickets = new Ticket[totalBerths];
    protected Ticket[] RACTickets = new Ticket[totalRAC];
    protected Ticket[] waitingList = new Ticket[totalWaiting];
    protected int filledTickets = 0;

    public boolean bookTicket(Passenger passenger) {
        if (filledTickets >= totalBerths + totalRAC + totalWaiting) {
            System.out.println("No tickets available.");
            return false;
        }

        if (passenger.getAge() < 5) { 
            System.out.println("Children below 5 years not eligible for booking.");
            return false;
        }

         if (passenger.getAge() > 60 || (passenger.getAge() <= 60 && passenger.getGender().equalsIgnoreCase("female") && passenger.getAge() > 0)) {
            if (filledTickets < totalBerths) {
                confirmedTickets[filledTickets] = new Ticket(passenger);
                passenger.setTicketStatus("Confirmed");
            } else if (filledTickets >= totalBerths && filledTickets < totalBerths + totalRAC) {
                RACTickets[filledTickets - totalBerths] = new Ticket(passenger);
                passenger.setTicketStatus("RAC");
            }
        } else {
            if (filledTickets < totalBerths + totalRAC) {
                RACTickets[filledTickets] = new Ticket(passenger);
                passenger.setTicketStatus("RAC");
            } else if (filledTickets >= totalBerths + totalRAC && filledTickets < totalBerths + totalRAC + totalWaiting) {
                waitingList[filledTickets - totalBerths - totalRAC] = new Ticket(passenger);
                passenger.setTicketStatus("Waiting");
            } else {
                System.out.println("No tickets available.");
                return false;
            }
        }

        filledTickets++;
        return true;
    }

    public boolean cancelTicket(Passenger passenger) {
        for (int i = 0; i < totalBerths; i++) {
            if (confirmedTickets[i] != null && confirmedTickets[i].getPassenger() == passenger) {
                confirmedTickets[i] = null;
                passenger.setTicketStatus("Cancelled");
                filledTickets--;
                return true;
            }
        }

        for (int i = 0; i < totalRAC; i++) {
            if (RACTickets[i] != null && RACTickets[i].getPassenger() == passenger) {
                RACTickets[i] = null;
                passenger.setTicketStatus("Cancelled");
                filledTickets--;
                return true;
            }
        }

        for (int i = 0; i < totalWaiting; i++) {
            if (waitingList[i] != null && waitingList[i].getPassenger() == passenger) {
                waitingList[i] = null;
                passenger.setTicketStatus("Cancelled");
                filledTickets--;
                return true;
            }
        }

        return false;
    }

    public void printBookedTickets() {
        System.out.println("Booked Tickets:");
        for (int i = 0; i < totalBerths; i++) {
            if (confirmedTickets[i] != null) {
                Passenger passenger = confirmedTickets[i].getPassenger();
                System.out.println("Name: " + passenger.getName() +
                        ", Age: " + passenger.getAge() +
                        ", Gender: " + passenger.getGender() +
                        ", Berth Preference: " + passenger.getBerthPreference() +
                        ", Status: " + passenger.getTicketStatus());
            }
        }
        for (int i = 0; i < totalRAC; i++) {
            if (RACTickets[i] != null) {
                Passenger passenger = RACTickets[i].getPassenger();
                System.out.println("Name: " + passenger.getName() +
                        ", Age: " + passenger.getAge() +
                        ", Gender: " + passenger.getGender() +
                        ", Berth Preference: " + passenger.getBerthPreference() +
                        ", Status: " + passenger.getTicketStatus());
            }
        }
    }

    public void printAvailableTickets() {
        System.out.println("Available Tickets:");
        for (int i = 0; i < totalBerths + totalRAC + totalWaiting; i++) {
            if (confirmedTickets[i] == null && RACTickets[i] == null && waitingList[i] == null) {
                System.out.println("Ticket " + (i + 1) + ": Unoccupied");
            }
        }
    }
}

public class RailwayReservationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Train train = new Train();

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Book a Ticket");
            System.out.println("2. Cancel a Ticket");
            System.out.println("3. Print Booked Tickets");
            System.out.println("4. Print Available Tickets");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter passenger name: ");
                  scanner.nextLine(); // Consume newline
                    String name = scanner.nextLine();
                    System.out.print("Enter passenger age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter passenger gender (Male/Female): ");
                    scanner.nextLine(); // Consume newline
                    String gender = scanner.nextLine();
                    System.out.print("Enter berth preference (Lower/Upper/Side): ");
                    String berthPreference = scanner.nextLine();

                    Passenger passenger = new Passenger(name, age, gender, berthPreference);
                    train.bookTicket(passenger);
                    break;

                case 2:
                    System.out.print("Enter passenger name for cancellation: ");
                    scanner.nextLine(); // Consume newline
                    String cancelName = scanner.nextLine();

                    boolean cancelled = false;
                    for (int i = 0; i < train.totalBerths + train.totalRAC + train.totalWaiting; i++) {
                        if (train.confirmedTickets[i] != null && train.confirmedTickets[i].getPassenger().getName().equalsIgnoreCase(cancelName)) {
                            train.cancelTicket(train.confirmedTickets[i].getPassenger());
                            cancelled = true;
                            break;
                        } else if (train.RACTickets[i] != null && train.RACTickets[i].getPassenger().getName().equalsIgnoreCase(cancelName)) {
                            train.cancelTicket(train.RACTickets[i].getPassenger());
                            cancelled = true;
                            break;
                        } else if (train.waitingList[i] != null && train.waitingList[i].getPassenger().getName().equalsIgnoreCase(cancelName)) {
                            train.cancelTicket(train.waitingList[i].getPassenger());
                            cancelled = true;
                            break;
                        }
                    }

                    if (cancelled) {
                        System.out.println("Ticket for passenger " + cancelName + " cancelled.");
                    } else {
                        System.out.println("Ticket for passenger " + cancelName + " not found.");
                    }
                    break;

                case 3:
                    train.printBookedTickets();
                    break;

                case 4:
                    train.printAvailableTickets();
                    break;

                case 5:
                    System.out.println("Exiting the application.");
                    System.exit(0);
                   // break;

              default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
