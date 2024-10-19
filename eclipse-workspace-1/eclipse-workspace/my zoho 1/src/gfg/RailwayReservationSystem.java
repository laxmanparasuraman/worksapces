package gfg;

//public class Railway_reservation {
//
//}
import java.util.*;

class Passenger {
    private String name;
    private int age; 
    private String gender;

    public Passenger(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}

class Train {
    private String trainNumber;
    private String source;
    private String destination;
    private int totalSeats;
    private int availableSeats;
    private List<Passenger> passengers;

    public Train(String trainNumber, String source, String destination, int totalSeats) {
        this.trainNumber = trainNumber;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
       
        this.passengers = new ArrayList<>();
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public boolean bookTicket(Passenger passenger) {
        if (availableSeats > 0) {
            availableSeats--;
            passengers.add(passenger);
            return true;
        } else {
            return false;
        }
    }

    public void displayPassengerList() {
        System.out.println("Passenger List for Train " + trainNumber + ":");
        for (Passenger passenger : passengers) {
            System.out.println("Name: " + passenger.getName() +
                               ", Age: " + passenger.getAge() +
                               ", Gender: " + passenger.getGender());
        }
    }
}

class ReservationSystem {
    public Map<String, Train> trains;

    public ReservationSystem() {
        trains = new HashMap<>();
    }

    public void addTrain(Train train) {
        trains.put(train.getTrainNumber(), train);
    }

    public Train findTrain(String trainNumber) {
        return trains.get(trainNumber);
    }
}

public class RailwayReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationSystem reservationSystem = new ReservationSystem();

        Train train1 = new Train("12345", "CityA", "CityB", 50);
        Train train2 = new Train("67890", "CityB", "CityC", 60);

        reservationSystem.addTrain(train1);
        reservationSystem.addTrain(train2);

        System.out.println("Welcome to the Railway Reservation System");

        while (true) {
            System.out.println("Enter train number to book a ticket (or 'exit' to quit):");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for using the Reservation System. Goodbye!");
                break;
            }

            Train selectedTrain = reservationSystem.findTrain(input);

            if (selectedTrain == null) {
                System.out.println("Invalid train number. Please try again.");
            } else {
                System.out.println("Enter passenger details:");
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Age: ");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.print("Gender: ");
                String gender = scanner.nextLine();

                Passenger passenger = new Passenger(name, age, gender);

                if (selectedTrain.bookTicket(passenger)) {
                    System.out.println("Ticket booked successfully!");
                    //reservationSystem.trains.values().displayPassengerList();
                    
                } else {
                    System.out.println("Sorry, no available seats on this train.");
                }
            }
        }

        // Display passenger lists for all trains
        for (Train train : reservationSystem.trains.values()) {
            System.out.println();
            train.displayPassengerList();
        }
    }
}
