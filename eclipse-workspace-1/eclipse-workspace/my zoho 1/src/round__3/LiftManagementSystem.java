package round__3;

//public class li {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

class Lift {
    private String name;
    private int currentFloor;
    private int capacity;
    private boolean inService;

    public Lift(String name, int capacity) {
        this.name = name;
        this.currentFloor = 0;
        this.capacity = capacity;
        this.inService = true;
    }

    public String getName() {
        return name;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isInService() {
        return inService;
    }

    public void setCurrentFloor(int floor) {
        this.currentFloor = floor;
    }

    public void markOutOfService() {
        this.inService = false;
    }

    public void markInService() {
        this.inService = true;
    }

    public int calculateDistance(int targetFloor) {
        return Math.abs(targetFloor - currentFloor);
    }

    public int calculateStops(int targetFloor, int[] stops) {
        int numStops = 0;
        for (int stop : stops) {
            if (stop >= 0 && stop <= 10 && stop != currentFloor) {
                numStops++;
            }
        }
        return numStops + calculateDistance(targetFloor);
    }
}

public class LiftManagementSystem {
    private static List<Lift> lifts = new ArrayList<>();

    public static void main(String[] args) {
        initializeLifts();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter source floor: ");
            int sourceFloor = scanner.nextInt();
            System.out.print("Enter destination floor: ");
            int destinationFloor = scanner.nextInt();

            Lift nearestLift = findNearestLift(sourceFloor, destinationFloor);
            if (nearestLift != null) {
                System.out.println(nearestLift.getName() + " is assigned.");
                nearestLift.setCurrentFloor(destinationFloor);
                printLiftStatus();
            } else {
                System.out.println("No available lifts.");
            }

            System.out.print("Do you want to continue (Y/N)? ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("Y")) {
                break;
            }
        }

        scanner.close();
    }

    private static void initializeLifts() {
        lifts.add(new Lift("L1", 5));
        lifts.add(new Lift("L2", 5));
        lifts.add(new Lift("L3", 10));
        lifts.add(new Lift("L4", 10));
        lifts.add(new Lift("L5", 15));

        // Restricting floors
        
        for (Lift lift : lifts) {
            if (lift.getName().equals("L1") || lift.getName().equals("L2")) {
                lift.markOutOfService();
            }
        }
    }

    private static Lift findNearestLift(int sourceFloor, int destinationFloor) {
        Lift nearestLift = null;
        int minDistance = Integer.MAX_VALUE;
        int[] stops = { sourceFloor, destinationFloor };

        for (Lift lift : lifts) {
            if (lift.isInService()) {
                int distance = lift.calculateDistance(sourceFloor);
                int stopsCount = lift.calculateStops(destinationFloor, stops);

                if (distance < minDistance || (distance == minDistance && stopsCount < nearestLift.calculateStops(destinationFloor, stops))) {
                    nearestLift = lift;
                    minDistance = distance;
                }
            }
        }

        return nearestLift;
    }

    private static void printLiftStatus() {
        System.out.println("Lift   : L1 L2 L3 L4 L5");
        System.out.print("Floor: ");
        for (Lift lift : lifts) {
            System.out.print(lift.getCurrentFloor() + "   ");
        }
        System.out.println();
    }
}
/*
 * ROUND 3: ADVANCE PROGRAMMING ROUND LIFT SYSTEM THERE WERE 8 MODULES 1.
 * DISPLAY T
 * HE POSITION OF LIFT
 * 
 * LIFT : L1 L2 L3 L4 L5 FLOOR: 0 0 0 0 0 2. ASSIGN LIFT TO THE USERS
 * 
 * INPUT : 2 5 OUTPUT : L1 IS ASSIGNED LIFT : L1 L2 L3 L4 L5 FLOOR: 5 0 0 0 0 3.
 * ASSIGN NEAREST LIFT BY COMPARING THEIR CURRENT POSITIONS ASSUME,
 * 
 * LIFT : L1 L2 L3 L4 L5 FLOOR: 5 2 7 9 0 INPUT : 4 10 OUTPUT : L1 IS ASSIGNED
 * LIFT : L1 L2 L3 L4 L5 FLOOR: 10 2 7 9 0 EXPLANATION : L1 IS NEAR TO 4 FLOOR
 * 
 * 4. IF TWO LIFTS ARE NEAREST TO THE USER’S SOURCE FLOOR, THE ASSIGN THE LIFT
 * WITH SAME DIRECTION OF USER’S REQUIREMENT. EXAMPLE: IF USER REQUEST TO MOVE
 * FROM 4 TO 2 ,AND IF L3 IS IN 5TH FLOOR & L5 IS IN 3RD FLOOR, THEN WE SHOULD
 * ASSIGN L3 BECAUSE USER REQUESTED FOR DOWNWARD MOTION SO L3 ILL MOVE DOWN FROM
 * 5TH FLOOR
 * 
 * 5. RESTRICT L1 & L2 FOR 0-5TH FLOOR , L3 & L4 FOR 6-10TH FLOOR , L5 FOR
 * 0-10TH INITIALLY ALL LIFTS ARE AT 0TH FLOOR.
 * 
 * 6. ASSIGN LIFT WITH LEAST NUMBER OF STOPS EXAMPLE: IF L3 IS IN 9TH FLOOR AND
 * L5 IS AT 8ND FLOOR IF USER WANTS TO MOVE FROM 8 TO 0 WE SHOULD ASSIGN L3
 * BECAUSE L3 ILL STOP AT 8,7,6 AND THEN 0 NUMBEROFSTOPS = 3, BUT L5 ILL STOP AT
 * 8,7,6,5,4,3,2,1,0 AND NUMBEROFSTOPS = 8 SO WE SHOULD ASSIGN L3
 * 
 * 7. ASSIGN CAPACITY (NUMBER OF PEOPLE CAPABLE TO TRAVEL) TO ALL LIFT AND
 * ASSIGN ACCORDING TO THE CAPACITY
 * 
 * 8. IF ANY LIFT IS UNDER MAINTENANCE THEN THEIR CURRENT POSITION SHOULD BE
 * MARKED AS “-1” AND THAT LIFT SHOULD NOT BE ASSIGNED AT ANY COST.
 */