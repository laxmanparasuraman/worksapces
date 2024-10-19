//
//public class WeightedSorting {
//
//}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class WeightedSorting {
	public static void sort( WeightedNumber arr[]) {
		int n =arr.length;
		System.out.println(Arrays.toString(arr)+"  before sort   ");
		for(int i=0;i<n;i++) {
			for (int j=i;j<n;j++) {
				if(arr[i].getWeight()>arr[j].getWeight()) {
					WeightedNumber temp =arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
	
    public static void main(String[] args) {
        int[] numbers = {10, 36, 54, 89, 12};
        ArrayList<WeightedNumber> weightedNumbers = new ArrayList<>();
        
        WeightedNumber  arr[]=new WeightedNumber[5];////
        int ind=0;
        for (int number : numbers) {
            int weight = calculateWeight(number);
            weightedNumbers.add(new WeightedNumber(number, weight));
            arr[ind++]=new WeightedNumber(number, weight);
        }
        
        
        
        
        
        sort(arr);
        System.out.println(Arrays.toString(arr)+"  mae");
        for (WeightedNumber wn : arr) {
            System.out.println("<" + wn.getNumber() + ", its_weight = " + wn.getWeight() + ">");
        }        
        
    System.out.println("new");
    System.out.println("");
        
        
       /* It seems you want to sort a list of objects based on a specific property name of the class. You can use the 
        * Comparator.comparing method along with method references to achieve this. Here's the syntax for sorting a 
        * list using Comparator.comparing:

        Collections.sort(listName, Comparator.comparing(ClassName::getPropertyName));
        */
        Collections.sort(weightedNumbers, Comparator.comparingInt(WeightedNumber::getWeight).reversed());
//        System.out.println(true);
//        weightedNumbers.sort(Comparator.comparingInt(WeightedNumber::getNumber));

        System.out.println("Sorted numbers based on weight:");
        for (WeightedNumber wn : weightedNumbers) {
            System.out.println("<" + wn.getNumber() + ", its_weight = " + wn.getWeight() + ">");
//            System.out.println(true);
//            weightedNumbers.sort(Comparator.comparingInt(WeightedNumber::getNumber));
        }
        System.out.println(true);
        weightedNumbers.sort(Comparator.comparingInt(WeightedNumber::getWeight));

            System.out.println("Sorted numbers based on weight: new ");
            for (WeightedNumber wn1 : weightedNumbers) {
                System.out.println("<" + wn1.getNumber() + ", its_weight = " + wn1.getWeight() + ">");

        }
    }

    private static int calculateWeight(int number) {
        if (isPerfectSquare(number)) {
            return 5;
        } else if (number % 4 == 0 && number % 6 == 0) {
        	
            return 4;
        } else if (number % 2 == 0) {
            return 3;
        } else {
            return 0;
        }
    }

    private static boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}

class WeightedNumber {
    private int number;
    private int weight;

    public WeightedNumber(int number, int weight) {
        this.number = number;
        this.weight = weight;
    }

    public int getNumber() {
        return number;
    }

    public int getWeight() {

    	return weight;
    }
}
