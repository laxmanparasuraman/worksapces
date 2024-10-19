package round__2_Cpaste.jan2024.svblog.the100;

//public class kk {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}

public class SafestPosition {
    public static int findSafestPosition(int numOfProcesses, int startPosition, int skip) {
        int position = startPosition  -1; // Convert to 0-based index
        int remainingProcesses = numOfProcesses;

        while (remainingProcesses > 1) {
            position = (position + skip) % remainingProcesses;
            System.out.println(position +"in"+remainingProcesses);
            if (position == 0) { // Convert back to 1-based index
System.out.println(position +" "+remainingProcesses);
                position = remainingProcesses;
                
            }
            remainingProcesses--;
        }

        return position;
    }

    public static void main(String[] args) {
        int numOfProcesses = 5;
        int startPosition = 3;
        int skip = 2;

        int safestPosition = findSafestPosition(numOfProcesses, startPosition, skip);
        System.out.println("The safest position is: " + safestPosition);
    }
}

